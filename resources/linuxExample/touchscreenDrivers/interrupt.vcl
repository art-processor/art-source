#select driverName
	#option fujitsu
/*
 * Decode serial data (5 bytes per packet)
 * First byte
 * 1 C 0 0 R S S S
 * Where C is 1 while in calibration mode (which we don't use)
 * R is 1 when no coordinate corection was done.
 * S are button state
 */
static irqreturn_t fujitsu_interrupt(struct serio *serio,
				     unsigned char data, unsigned int flags)
{
	struct fujitsu *fujitsu = serio_get_drvdata(serio);
	struct input_dev *dev = fujitsu->dev;

	if (fujitsu->idx == 0) {
		/* resync skip until start of frame */
		if ((data & 0xf0) != 0x80)
			return IRQ_HANDLED;
	} else {
		/* resync skip garbage */
		if (data & 0x80) {
			fujitsu->idx = 0;
			return IRQ_HANDLED;
		}
	}

	fujitsu->data[fujitsu->idx++] = data;
	if (fujitsu->idx == FUJITSU_LENGTH) {
		input_report_abs(dev, ABS_X,
				 (fujitsu->data[2] << 7) | fujitsu->data[1]);
		input_report_abs(dev, ABS_Y,
				 (fujitsu->data[4] << 7) | fujitsu->data[3]);
		input_report_key(dev, BTN_TOUCH,
				 (fujitsu->data[0] & 0x03) != 2);
		input_sync(dev);
		fujitsu->idx = 0;
	}

	return IRQ_HANDLED;
}
	#endoption
	#option gunze
static irqreturn_t gunze_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct gunze* gunze = serio_get_drvdata(serio);

	if (data == '\r') {
		gunze_process_packet(gunze);
		gunze->idx = 0;
	} else {
		if (gunze->idx < GUNZE_MAX_LENGTH)
			gunze->data[gunze->idx++] = data;
	}
	return IRQ_HANDLED;
}
	#endoption
	#option mtouch
static irqreturn_t mtouch_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct mtouch* mtouch = serio_get_drvdata(serio);

	mtouch->data[mtouch->idx] = data;

	if (MTOUCH_FORMAT_TABLET_STATUS_BIT & mtouch->data[0])
		mtouch_process_format_tablet(mtouch);
	else if (MTOUCH_RESPONSE_BEGIN_BYTE == mtouch->data[0])
		mtouch_process_response(mtouch);
	else
		printk(KERN_DEBUG \"mtouch.c: unknown/unsynchronized data from device, byte %x\n\",mtouch->data[0]);

	return IRQ_HANDLED;
}
	#endoption
	#option touchit213
static irqreturn_t touchit213_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct touchit213 *touchit213 = serio_get_drvdata(serio);
	struct input_dev *dev = touchit213->dev;

	touchit213->data[touchit213->idx] = data;

	switch (touchit213->idx++) {
	case 0:
		if ((touchit213->data[0] & T213_FORMAT_STATUS_MASK) !=
				T213_FORMAT_STATUS_BYTE) {
			pr_debug(\"unsynchronized data: 0x%02x\n\", data);
			touchit213->idx = 0;
		}
		break;

	case 4:
		touchit213->idx = 0;
		input_report_abs(dev, ABS_X,
			(touchit213->data[1] << 7) | touchit213->data[2]);
		input_report_abs(dev, ABS_Y,
			(touchit213->data[3] << 7) | touchit213->data[4]);
		input_report_key(dev, BTN_TOUCH,
			touchit213->data[0] & T213_FORMAT_TOUCH_BIT);
		input_sync(dev);
		break;
	}

	return IRQ_HANDLED;
}
	#endoption
	#option tr
static irqreturn_t tr_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct tr *tr = serio_get_drvdata(serio);
	struct input_dev *dev = tr->dev;

	tr->data[tr->idx] = data;

	if ((tr->data[0] & TR_FORMAT_STATUS_MASK) == TR_FORMAT_STATUS_BYTE) {
		if (++tr->idx == TR_LENGTH) {
			input_report_abs(dev, ABS_X,
				(tr->data[1] << 5) | (tr->data[2] >> 1));
			input_report_abs(dev, ABS_Y,
				(tr->data[3] << 5) | (tr->data[4] >> 1));
			input_report_key(dev, BTN_TOUCH,
				tr->data[0] & TR_FORMAT_TOUCH_BIT);
			input_sync(dev);
			tr->idx = 0;
		}
	}

	return IRQ_HANDLED;
}
	#endoption
	#option tw
static irqreturn_t tw_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct tw *tw = serio_get_drvdata(serio);
	struct input_dev *dev = tw->dev;

	if (data) {		/* touch */
		tw->touched = 1;
		tw->data[tw->idx++] = data;
		/* verify length and that the two Y's are the same */
		if (tw->idx == TW_LENGTH && tw->data[1] == tw->data[2]) {
			input_report_abs(dev, ABS_X, tw->data[0]);
			input_report_abs(dev, ABS_Y, tw->data[1]);
			input_report_key(dev, BTN_TOUCH, 1);
			input_sync(dev);
			tw->idx = 0;
		}
	} else if (tw->touched) {	/* untouch */
		input_report_key(dev, BTN_TOUCH, 0);
		input_sync(dev);
		tw->idx = 0;
		tw->touched = 0;
	}

	return IRQ_HANDLED;
}
	#endoption
#endselect