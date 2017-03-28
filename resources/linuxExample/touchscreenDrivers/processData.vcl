#select driverName
	#option gunze
static void gunze_process_packet(struct gunze* gunze)
{
	struct input_dev *dev = gunze->dev;

	if (gunze->idx != GUNZE_MAX_LENGTH || gunze->data[5] != ',' ||
		(gunze->data[0] != 'T' && gunze->data[0] != 'R')) {
		printk(KERN_WARNING \"gunze.c: bad packet: >%.*s<\n\", GUNZE_MAX_LENGTH, gunze->data);
		return;
	}

	input_report_abs(dev, ABS_X, simple_strtoul(gunze->data + 1, NULL, 10));
	input_report_abs(dev, ABS_Y, 1024 - simple_strtoul(gunze->data + 6, NULL, 10));
	input_report_key(dev, BTN_TOUCH, gunze->data[0] == 'T');
	input_sync(dev);
}
	#endoption
	#option mtouch
static void mtouch_process_format_tablet(struct mtouch *mtouch)
{
	struct input_dev *dev = mtouch->dev;

	if (MTOUCH_FORMAT_TABLET_LENGTH == ++mtouch->idx) {
		input_report_abs(dev, ABS_X, MTOUCH_GET_XC(mtouch->data));
		input_report_abs(dev, ABS_Y, MTOUCH_MAX_YC - MTOUCH_GET_YC(mtouch->data));
		input_report_key(dev, BTN_TOUCH, MTOUCH_GET_TOUCHED(mtouch->data));
		input_sync(dev);

		mtouch->idx = 0;
	}
}

static void mtouch_process_response(struct mtouch *mtouch)
{
	if (MTOUCH_RESPONSE_END_BYTE == mtouch->data[mtouch->idx++]) {
		/* FIXME - process response */
		mtouch->idx = 0;
	} else if (MTOUCH_MAX_LENGTH == mtouch->idx) {
		printk(KERN_ERR \"mtouch.c: too many response bytes\n\");
		mtouch->idx = 0;
	}
}
	#endoption
	#option fujitsu|touchit213|tr|tw
	#endoption
	#otherwise
static void ?@driverName?_process_data(struct ?@driverName? *?@driverName?)
{
	struct input_dev *dev = ?@driverName?->dev;

	if (?@serioProto?_FORMAT_LENGTH == ++?@driverName?->idx) {
		input_report_abs(dev, ABS_X, ?@serioProto?_GET_XC(?@driverName?->data));
		input_report_abs(dev, ABS_Y, ?@serioProto?_GET_YC(?@driverName?->data));
		input_report_key(dev, BTN_TOUCH,
				 ?@serioProto?_GET_TOUCHED(?@driverName?->data));
		input_sync(dev);

		?@driverName?->idx = 0;
	}
}

static irqreturn_t ?@driverName?_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct ?@driverName? *?@driverName? = serio_get_drvdata(serio);

	?@driverName?->data[?@driverName?->idx] = data;

	if (?@serioProto?_RESPONSE_BEGIN_BYTE & ?@driverName?->data[0])
		?@driverName?_process_data(?@driverName?);
	else
	
		#select driverName
			#option inexio
				printk(KERN_DEBUG \"inexio.c: unknown/unsynchronized data from device, byte %x\n\",pinexio->data[0]);
		return IRQ_HANDLED;
}
			#endoption
			#otherwise
			dev_dbg(&serio->dev, \"unknown/unsynchronized data: %x\n\",
					?@driverName?->data[0]);
		return IRQ_HANDLED;
}
			#endotherwise
		#endselect
	#endotherwise
#endselect