#select driverName
	#option twidjoy
/*
 *  Copyright (c) 2001 Arndt Schoenewald
 *  Copyright (c) 2000-2001 Vojtech Pavlik
 *  Copyright (c) 2000 Mark Fletcher
 *
 *  Sponsored by Quelltext AG (http://www.quelltext-ag.de), Dortmund, Germany
 */

/*
 * Driver to use Handykey's Twiddler (the first edition, i.e. the one with
 * the RS232 interface) as a joystick under Linux
 *
 * The Twiddler is a one-handed chording keyboard featuring twelve buttons on
 * the front, six buttons on the top, and a built-in tilt sensor. The buttons
 * on the front, which are grouped as four rows of three buttons, are pressed
 * by the four fingers (this implies only one button per row can be held down
 * at the same time) and the buttons on the top are for the thumb. The tilt
 * sensor delivers X and Y axis data depending on how the Twiddler is held.
 * Additional information can be found at http://www.handykey.com.
 *
 * This driver does not use the Twiddler for its intended purpose, i.e. as
 * a chording keyboard, but as a joystick: pressing and releasing a button
 * immediately sends a corresponding button event, and tilting it generates
 * corresponding ABS_X and ABS_Y events. This turns the Twiddler into a game
 * controller with amazing 18 buttons :-)
 *
 * Note: The Twiddler2 (the successor of the Twiddler that connects directly
 * to the PS/2 keyboard and mouse ports) is NOT supported by this driver!
 *
 * For questions or feedback regarding this driver module please contact:
 * Arndt Schoenewald <arndt@quelltext.com>
 */
	#endoption
	#option zhenhua
/*
 *  derived from \"twidjoy.c\"
 *
 *  Copyright (c) 2008 Martin Kebert
 *  Copyright (c) 2001 Arndt Schoenewald
 *  Copyright (c) 2000-2001 Vojtech Pavlik
 *  Copyright (c) 2000 Mark Fletcher
 *
 */

/*
 * Driver to use 4CH RC transmitter using Zhen Hua 5-byte protocol (Walkera Lama,
 * EasyCopter etc.) as a joystick under Linux.
 *
 * RC transmitters using Zhen Hua 5-byte protocol are cheap four channels
 * transmitters for control a RC planes or RC helicopters with possibility to
 * connect on a serial port.
 * Data coming from transmitter is in this order:
 * 1. byte = synchronisation byte
 * 2. byte = X axis
 * 3. byte = Y axis
 * 4. byte = RZ axis
 * 5. byte = Z axis
 * (and this is repeated)
 *
 * For questions or feedback regarding this driver module please contact:
 * Martin Kebert <gkmarty@gmail.com> - but I am not a C-programmer nor kernel
 * coder :-(
 */
	#endoption
	#otherwise
/*
 *  Copyright (c) 1999-2001 Vojtech Pavlik
		#select driverName
			#option spaceorb|spaceball
 *
 *  Based on the work of:
 *	David Thompson
			#endoption
			#option spaceball
 *	Joseph Krahn
			#endoption
		#endselect
 */
/*
 * ?@drvLongName? driver for Linux
 */
	#endotherwise
#endselect