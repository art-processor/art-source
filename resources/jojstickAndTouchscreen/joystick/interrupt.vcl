#select driverName
	#option spaceorb
static irqreturn_t spaceorb_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct spaceorb* spaceorb = serio_get_drvdata(serio);

	if (~data & 0x80) {
		if (spaceorb->idx) spaceorb_process_packet(spaceorb);
		spaceorb->idx = 0;
	}
	if (spaceorb->idx < SPACEORB_MAX_LENGTH)
		spaceorb->data[spaceorb->idx++] = data & 0x7f;
	return IRQ_HANDLED;
}
	#endoption
	#option spaceball
/*
 * Spaceball 4000 FLX packets all start with a one letter packet-type decriptor,
 * and end in 0x0d. It uses '^' as an escape for CR, XOFF and XON characters which
 * can occur in the axis values.
 */

static irqreturn_t spaceball_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct spaceball *spaceball = serio_get_drvdata(serio);

	switch (data) {
		case 0xd:
			spaceball_process_packet(spaceball);
			spaceball->idx = 0;
			spaceball->escape = 0;
			break;
		case '^':
			if (!spaceball->escape) {
				spaceball->escape = 1;
				break;
			}
			spaceball->escape = 0;
		case 'M':
		case 'Q':
		case 'S':
			if (spaceball->escape) {
				spaceball->escape = 0;
				data &= 0x1f;
			}
		default:
			if (spaceball->escape)
				spaceball->escape = 0;
			if (spaceball->idx < SPACEBALL_MAX_LENGTH)
				spaceball->data[spaceball->idx++] = data;
			break;
	}
	return IRQ_HANDLED;
}
	#endoption
	#option warrior
/*
 * warrior_interrupt() is called by the low level driver when characters
 * are ready for us. We then buffer them for further processing, or call the
 * packet processing routine.
 */

static irqreturn_t warrior_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct warrior *warrior = serio_get_drvdata(serio);

	if (data & 0x80) {
		if (warrior->idx) warrior_process_packet(warrior);
		warrior->idx = 0;
		warrior->len = warrior_lengths[(data >> 4) & 7];
	}

	if (warrior->idx < warrior->len)
		warrior->data[warrior->idx++] = data;

	if (warrior->idx == warrior->len) {
		if (warrior->idx) warrior_process_packet(warrior);
		warrior->idx = 0;
		warrior->len = 0;
	}
	return IRQ_HANDLED;
}
	#endoption
	#option zhenhua
/*
 * zhenhua_interrupt() is called by the low level driver when characters
 * are ready for us. We then buffer them for further processing, or call the
 * packet processing routine.
 */

static irqreturn_t zhenhua_interrupt(struct serio *serio, unsigned char data, unsigned int flags)
{
	struct zhenhua *zhenhua = serio_get_drvdata(serio);

	/* All Zhen Hua packets are 5 bytes. The fact that the first byte
	 * is allways 0xf7 and all others are in range 0x32 - 0xc8 (50-200)
	 * can be used to check and regain sync. */

	if (data == 0xef)
		zhenhua->idx = 0;	/* this byte starts a new packet */
	else if (zhenhua->idx == 0)
		return IRQ_HANDLED;	/* wrong MSB -- ignore this byte */

	if (zhenhua->idx < ZHENHUA_MAX_LENGTH)
		zhenhua->data[zhenhua->idx++] = zhenhua_bitreverse(data);

	if (zhenhua->idx == ZHENHUA_MAX_LENGTH) {
		zhenhua_process_packet(zhenhua);
		zhenhua->idx = 0;
	}

	return IRQ_HANDLED;
}
	#endoption
	#option twidjoy
/*
 * twidjoy_interrupt() is called by the low level driver when characters
 * are ready for us. We then buffer them for further processing, or call the
 * packet processing routine.
 */

static irqreturn_t twidjoy_interrupt(struct serio *serio, unsigned char data, unsigned int flags)
{
	struct twidjoy *twidjoy = serio_get_drvdata(serio);

	/* All Twiddler packets are 5 bytes. The fact that the first byte
	 * has a MSB of 0 and all other bytes have a MSB of 1 can be used
	 * to check and regain sync. */

	if ((data & 0x80) == 0)
		twidjoy->idx = 0;	/* this byte starts a new packet */
	else if (twidjoy->idx == 0)
		return IRQ_HANDLED;	/* wrong MSB -- ignore this byte */

	if (twidjoy->idx < TWIDJOY_MAX_LENGTH)
		twidjoy->data[twidjoy->idx++] = data;

	if (twidjoy->idx == TWIDJOY_MAX_LENGTH) {
		twidjoy_process_packet(twidjoy);
		twidjoy->idx = 0;
	}

	return IRQ_HANDLED;
}
	#endoption
	#option magellan
static irqreturn_t magellan_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct magellan* magellan = serio_get_drvdata(serio);

	if (data == '\r') {
		magellan_process_packet(magellan);
		magellan->idx = 0;
	} else {
		if (magellan->idx < MAGELLAN_MAX_LENGTH)
			magellan->data[magellan->idx++] = data;
	}
	return IRQ_HANDLED;
}
	#endoption
#endselect