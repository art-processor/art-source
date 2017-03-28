#set driverName = "spaceorb", "spaceball", "warrior", "zhenhua", "twidjoy", "magellan"
#set driverName_CAP = "SPACEORB", "SPACEBALL", "WARRIOR", "ZHENHUA", "TWIDJOY", "MAGELLAN"
#set drvLongName = "SpaceTec SpaceOrb 360 and Avenger 6dof controller", "SpaceTec SpaceBall 2003/3003/4000 FLX", "Logitech WingMan Warrior joystick", "RC transmitter with 5-byte Zhen Hua protocol joystick", "Handykey Twiddler keyboard as a", "Magellan and Space Mouse 6dof controller"
#set devName = "\"SpaceTec SpaceOrb 360 / Avenger\"", "spaceball_names[id]", "\"Logitech WingMan Warrior\"", "\"Zhen Hua 5-byte device\"", "\"Handykey Twiddler\"", "\"LogiCad3D Magellan / SpaceMouse\""

#while driverName, driverName_CAP, drvLongName, devName
	#output "output/"?@driverName?"_generated.c"
	#adapt: "resources/jojstickAndTouchscreen/joystick/common.vcl"
		#select driverName
			#option warrior
			    #insert-before connect
				#endinsert
				#insert-after connect
	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_REL) |
		BIT_MASK(EV_ABS);
	input_dev->keybit[BIT_WORD(BTN_TRIGGER)] = BIT_MASK(BTN_TRIGGER) |
		BIT_MASK(BTN_THUMB) | BIT_MASK(BTN_TOP) | BIT_MASK(BTN_TOP2);
	input_dev->relbit[0] = BIT_MASK(REL_DIAL);
	input_set_abs_params(input_dev, ABS_X, -64, 64, 0, 8);
	input_set_abs_params(input_dev, ABS_Y, -64, 64, 0, 8);
	input_set_abs_params(input_dev, ABS_THROTTLE, -112, 112, 0, 0);
	input_set_abs_params(input_dev, ABS_HAT0X, -1, 1, 0, 0);
	input_set_abs_params(input_dev, ABS_HAT0Y, -1, 1, 0, 0);
				#endinsert
			#endoption
			#option zhenhua
				#insert-before connect
				#endinsert
				#insert-after connect
	input_dev->evbit[0] = BIT(EV_ABS);
	input_set_abs_params(input_dev, ABS_X, 50, 200, 0, 0);
	input_set_abs_params(input_dev, ABS_Y, 50, 200, 0, 0);
	input_set_abs_params(input_dev, ABS_Z, 50, 200, 0, 0);
	input_set_abs_params(input_dev, ABS_RZ, 50, 200, 0, 0);
				#endinsert
			#endoption
			#option spaceorb
				#insert-before connect
	int i;
				#endinsert
				#insert-after connect
	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_ABS);

	for (i = 0; i < 6; i++)
		set_bit(?@driverName?_buttons[i], input_dev->keybit);

	for (i = 0; i < 6; i++)
		input_set_abs_params(input_dev, ?@driverName?_axes[i], -508, 508, 0, 0);
				#endinsert
			#endoption
		    #option spaceball
				#insert-before connect
	int i, id;
	if ((id = serio->id.id) > SPACEBALL_MAX_ID)
		return -ENODEV;
				#endinsert
				#insert-after connect
	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_ABS);

	switch (id) {
		case SPACEBALL_4000FLX:
		case SPACEBALL_4000FLX_L:
			input_dev->keybit[BIT_WORD(BTN_0)] |= BIT_MASK(BTN_9);
			input_dev->keybit[BIT_WORD(BTN_A)] |= BIT_MASK(BTN_A) |
				BIT_MASK(BTN_B) | BIT_MASK(BTN_C) |
				BIT_MASK(BTN_MODE);
		default:
			input_dev->keybit[BIT_WORD(BTN_0)] |= BIT_MASK(BTN_2) |
				BIT_MASK(BTN_3) | BIT_MASK(BTN_4) |
				BIT_MASK(BTN_5) | BIT_MASK(BTN_6) |
				BIT_MASK(BTN_7) | BIT_MASK(BTN_8);
		case SPACEBALL_3003C:
			input_dev->keybit[BIT_WORD(BTN_0)] |= BIT_MASK(BTN_1) |
				BIT_MASK(BTN_8);
	}

	for (i = 0; i < 3; i++) {
		input_set_abs_params(input_dev, ABS_X + i, -8000, 8000, 8, 40);
		input_set_abs_params(input_dev, ABS_RX + i, -1600, 1600, 2, 8);
	}
				#endinsert
			#endoption
			#option twidjoy
				#insert-before connect
	struct twidjoy_button_spec *bp;
	int i;
				#endinsert
				#insert-after connect
	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_ABS);
	input_set_abs_params(input_dev, ABS_X, -50, 50, 4, 4);
	input_set_abs_params(input_dev, ABS_Y, -50, 50, 4, 4);

	for (bp = twidjoy_buttons; bp->bitmask; bp++)
		for (i = 0; i < bp->bitmask; i++)
			set_bit(bp->buttons[i], input_dev->keybit);
				#endinsert
			#endoption
			#option magellan
				#insert-before connect
	int i;
				#endinsert
				#insert-after connect
	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_ABS);
					
	for (i = 0; i < 9; i++)
		set_bit(magellan_buttons[i], input_dev->keybit);

	for (i = 0; i < 6; i++)
		input_set_abs_params(input_dev, magellan_axes[i], -360, 360, 0, 0);
				#endinsert
			#endoption
		#endselect
	#endadapt
#endwhile