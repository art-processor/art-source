#select driverName
	#option spaceorb
static unsigned char spaceorb_xor[] = \"SpaceWare\";

static unsigned char *spaceorb_errors[] = { \"EEPROM storing 0 failed\", \"Receive queue overflow\", \"Transmit queue timeout\",
		\"Bad packet\", \"Power brown-out\", \"EEPROM checksum error\", \"Hardware fault\" };

static void spaceorb_process_packet(struct spaceorb *spaceorb)
{
	struct input_dev *dev = spaceorb->dev;
	unsigned char *data = spaceorb->data;
	unsigned char c = 0;
	int axes[6];
	int i;

	if (spaceorb->idx < 2) return;
	for (i = 0; i < spaceorb->idx; i++) c ^= data[i];
	if (c) return;

	switch (data[0]) {

		case 'R':				/* Reset packet */
			spaceorb->data[spaceorb->idx - 1] = 0;
			for (i = 1; i < spaceorb->idx && spaceorb->data[i] == ' '; i++);
			printk(KERN_INFO \"input: s [s] is s\n\",
				 dev->name, spaceorb->data + i, spaceorb->phys);
			break;

		case 'D':				/* Ball + button data */
			if (spaceorb->idx != 12) return;
			for (i = 0; i < 9; i++) spaceorb->data[i+2] ^= spaceorb_xor[i];
			axes[0] = ( data[2]	 << 3) | (data[ 3] >> 4);
			axes[1] = ((data[3] & 0x0f) << 6) | (data[ 4] >> 1);
			axes[2] = ((data[4] & 0x01) << 9) | (data[ 5] << 2) | (data[4] >> 5);
			axes[3] = ((data[6] & 0x1f) << 5) | (data[ 7] >> 2);
			axes[4] = ((data[7] & 0x03) << 8) | (data[ 8] << 1) | (data[7] >> 6);
			axes[5] = ((data[9] & 0x3f) << 4) | (data[10] >> 3);
			for (i = 0; i < 6; i++)
				input_report_abs(dev, spaceorb_axes[i], axes[i] - ((axes[i] & 0x200) \? 1024 : 0));
			for (i = 0; i < 6; i++)
				input_report_key(dev, spaceorb_buttons[i], (data[1] >> i) & 1);
			break;

		case 'K':				/* Button data */
			if (spaceorb->idx != 5) return;
			for (i = 0; i < 6; i++)
				input_report_key(dev, spaceorb_buttons[i], (data[2] >> i) & 1);

			break;

		case 'E':				/* Error packet */
			if (spaceorb->idx != 4) return;
			printk(KERN_ERR \"spaceorb: Device error. [ \");
			for (i = 0; i < 7; i++) if (data[1] & (1 << i)) printk(\"s \", spaceorb_errors[i]);
			printk(\"]\n\");
			break;
	}

	input_sync(dev);
}
	#endoption
	#option spaceball
static void spaceball_process_packet(struct spaceball* spaceball)
{
	struct input_dev *dev = spaceball->dev;
	unsigned char *data = spaceball->data;
	int i;

	if (spaceball->idx < 2) return;

	switch (spaceball->data[0]) {

		case 'D':					/* Ball data */
			if (spaceball->idx != 15) return;
			for (i = 0; i < 6; i++)
				input_report_abs(dev, spaceball_axes[i],
					(__s16)((data[2 * i + 3] << 8) | data[2 * i + 2]));
			break;

		case 'K':					/* Button data */
			if (spaceball->idx != 3) return;
			input_report_key(dev, BTN_1, (data[2] & 0x01) || (data[2] & 0x20));
			input_report_key(dev, BTN_2, data[2] & 0x02);
			input_report_key(dev, BTN_3, data[2] & 0x04);
			input_report_key(dev, BTN_4, data[2] & 0x08);
			input_report_key(dev, BTN_5, data[1] & 0x01);
			input_report_key(dev, BTN_6, data[1] & 0x02);
			input_report_key(dev, BTN_7, data[1] & 0x04);
			input_report_key(dev, BTN_8, data[1] & 0x10);
			break;

		case '.':					/* Advanced button data */
			if (spaceball->idx != 3) return;
			input_report_key(dev, BTN_1, data[2] & 0x01);
			input_report_key(dev, BTN_2, data[2] & 0x02);
			input_report_key(dev, BTN_3, data[2] & 0x04);
			input_report_key(dev, BTN_4, data[2] & 0x08);
			input_report_key(dev, BTN_5, data[2] & 0x10);
			input_report_key(dev, BTN_6, data[2] & 0x20);
			input_report_key(dev, BTN_7, data[2] & 0x80);
			input_report_key(dev, BTN_8, data[1] & 0x01);
			input_report_key(dev, BTN_9, data[1] & 0x02);
			input_report_key(dev, BTN_A, data[1] & 0x04);
			input_report_key(dev, BTN_B, data[1] & 0x08);
			input_report_key(dev, BTN_C, data[1] & 0x10);
			input_report_key(dev, BTN_MODE, data[1] & 0x20);
			break;

		case 'E':					/* Device error */
			spaceball->data[spaceball->idx - 1] = 0;
			printk(KERN_ERR \"spaceball: Device error. [%s]\n\", spaceball->data + 1);
			break;

		case '\?':					/* Bad command packet */
			spaceball->data[spaceball->idx - 1] = 0;
			printk(KERN_ERR \"spaceball: Bad command. [%s]\n\", spaceball->data + 1);
			break;
	}

	input_sync(dev);
}
	#endoption
	#option warrior
static void warrior_process_packet(struct warrior *warrior)
{
	struct input_dev *dev = warrior->dev;
	unsigned char *data = warrior->data;

	if (!warrior->idx) return;

	switch ((data[0] >> 4) & 7) {
		case 1:					/* Button data */
			input_report_key(dev, BTN_TRIGGER,  data[3]       & 1);
			input_report_key(dev, BTN_THUMB,   (data[3] >> 1) & 1);
			input_report_key(dev, BTN_TOP,     (data[3] >> 2) & 1);
			input_report_key(dev, BTN_TOP2,    (data[3] >> 3) & 1);
			break;
		case 3:					/* XY-axis info->data */
			input_report_abs(dev, ABS_X, ((data[0] & 8) << 5) - (data[2] | ((data[0] & 4) << 5)));
			input_report_abs(dev, ABS_Y, (data[1] | ((data[0] & 1) << 7)) - ((data[0] & 2) << 7));
			break;
		case 5:					/* Throttle, spinner, hat info->data */
			input_report_abs(dev, ABS_THROTTLE, (data[1] | ((data[0] & 1) << 7)) - ((data[0] & 2) << 7));
			input_report_abs(dev, ABS_HAT0X, (data[3] & 2 \? 1 : 0) - (data[3] & 1 \? 1 : 0));
			input_report_abs(dev, ABS_HAT0Y, (data[3] & 8 \? 1 : 0) - (data[3] & 4 \? 1 : 0));
			input_report_rel(dev, REL_DIAL,  (data[2] | ((data[0] & 4) << 5)) - ((data[0] & 8) << 5));
			break;
	}
	input_sync(dev);
}
	#endoption
	#option zhenhua
/* bits in all incoming bytes needs to be \"reversed\" */
static int zhenhua_bitreverse(int x)
{
	x = ((x & 0xaa) >> 1) | ((x & 0x55) << 1);
	x = ((x & 0xcc) >> 2) | ((x & 0x33) << 2);
	x = ((x & 0xf0) >> 4) | ((x & 0x0f) << 4);
	return x;
}

static void zhenhua_process_packet(struct zhenhua *zhenhua)
{
	struct input_dev *dev = zhenhua->dev;
	unsigned char *data = zhenhua->data;

	input_report_abs(dev, ABS_Y, data[1]);
	input_report_abs(dev, ABS_X, data[2]);
	input_report_abs(dev, ABS_RZ, data[3]);
	input_report_abs(dev, ABS_Z, data[4]);

	input_sync(dev);
}
	#endoption
	#option twidjoy
static void twidjoy_process_packet(struct twidjoy *twidjoy)
{
	struct input_dev *dev = twidjoy->dev;
	unsigned char *data = twidjoy->data;
	struct twidjoy_button_spec *bp;
	int button_bits, abs_x, abs_y;

	button_bits = ((data[1] & 0x7f) << 7) | (data[0] & 0x7f);

	for (bp = twidjoy_buttons; bp->bitmask; bp++) {
		int value = (button_bits & (bp->bitmask << bp->bitshift)) >> bp->bitshift;
		int i;

		for (i = 0; i < bp->bitmask; i++)
			input_report_key(dev, bp->buttons[i], i+1 == value);
	}

	abs_x = ((data[4] & 0x07) << 5) | ((data[3] & 0x7C) >> 2);
	if (data[4] & 0x08) abs_x -= 256;

	abs_y = ((data[3] & 0x01) << 7) | ((data[2] & 0x7F) >> 0);
	if (data[3] & 0x02) abs_y -= 256;

	input_report_abs(dev, ABS_X, -abs_x);
	input_report_abs(dev, ABS_Y, +abs_y);

	input_sync(dev);
}
	#endoption
	#option magellan
/*
 * magellan_crunch_nibbles() verifies that the bytes sent from the Magellan
 * have correct upper nibbles for the lower ones, if not, the packet will
 * be thrown away. It also strips these upper halves to simplify further
 * processing.
 */

static int magellan_crunch_nibbles(unsigned char *data, int count)
{
	static unsigned char nibbles[16] = \"0AB3D56GH9:K<MN\?\";

	do {
		if (data[count] == nibbles[data[count] & 0xf])
			data[count] = data[count] & 0xf;
		else
			return -1;
	} while (--count);

	return 0;
}

static void magellan_process_packet(struct magellan* magellan)
{
	struct input_dev *dev = magellan->dev;
	unsigned char *data = magellan->data;
	int i, t;

	if (!magellan->idx) return;

	switch (magellan->data[0]) {

		case 'd':				/* Axis data */
			if (magellan->idx != 25) return;
			if (magellan_crunch_nibbles(data, 24)) return;
			for (i = 0; i < 6; i++)
				input_report_abs(dev, magellan_axes[i],
					(data[(i << 2) + 1] << 12 | data[(i << 2) + 2] << 8 |
					 data[(i << 2) + 3] <<  4 | data[(i << 2) + 4]) - 32768);
			break;

		case 'k':				/* Button data */
			if (magellan->idx != 4) return;
			if (magellan_crunch_nibbles(data, 3)) return;
			t = (data[1] << 1) | (data[2] << 5) | data[3];
			for (i = 0; i < 9; i++) input_report_key(dev, magellan_buttons[i], (t >> i) & 1);
			break;
	}

	input_sync(dev);
}
	#endoption
#endselect