#adapt "resources/jojstickAndTouchscreen/joystick/beforeLicence.vcl"
/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
#adapt "resources/jojstickAndTouchscreen/joystick/afterLicence.vcl"
 */

#include <linux/kernel.h>
#include <linux/slab.h>
#include <linux/module.h>
#include <linux/init.h>
#include <linux/input.h>
#include <linux/serio.h>

#define DRIVER_DESC	\"?@drvLongName? driver\"

MODULE_AUTHOR("Vojtech Pavlik <vojtech@ucw.cz>");
MODULE_DESCRIPTION(DRIVER_DESC);
MODULE_LICENSE("GPL");

/*
 * Constants.
 */
#adapt "resources/jojstickAndTouchscreen/joystick/constants.vcl"
/*
 * Per-?@driverName? data.
 */
struct ?@driverName? {
	struct input_dev *dev;
	int idx;
#select driverName
	#option warrior
	int len;
	#endoption
	#option spaceball
	int escape;
	#endoption
#endselect
	unsigned char data[?@driverName_CAP?_MAX_LENGTH];
	char phys[32];
};

/*
 * ?@driverName?_process_packet() decodes packets the driver receives from the
 * ?@driverName?. It updates the data accordingly.
 */
#adapt "resources/jojstickAndTouchscreen/joystick/processData.vcl"
#adapt "resources/jojstickAndTouchscreen/joystick/interrupt.vcl"
#adapt "resources/jojstickAndTouchscreen/commonTemplateBody.vcl"
	int err = -ENOMEM;
#break: connect 
	?@driverName? = kzalloc(sizeof(struct ?@driverName?), GFP_KERNEL);
	input_dev = input_allocate_device();
	if (!?@driverName? || !input_dev)
		goto fail1;

	?@driverName?->dev = input_dev;
	snprintf(?@driverName?->phys, sizeof(?@driverName?->phys), "%s/input0", serio->phys);

	input_dev->name = ?@devName?;
	input_dev->phys = ?@driverName?->phys;
	input_dev->id.bustype = BUS_RS232;
	input_dev->id.vendor = SERIO_?@driverName_CAP?;
	input_dev->id.product = 0x0001;
	input_dev->id.version = 0x0100;
	input_dev->dev.parent = &serio->dev;
#endbreak

	serio_set_drvdata(serio, ?@driverName?);

	err = serio_open(serio, drv);
	if (err)
		goto fail2;

	err = input_register_device(?@driverName?->dev);
	if (err)
		goto fail3;

	return 0;

 fail3:	serio_close(serio);
 fail2:	serio_set_drvdata(serio, NULL);
 fail1:	input_free_device(input_dev);
	kfree(?@driverName?);
	return err;
}
#adapt "resources/jojstickAndTouchscreen/serioDriverStructure.vcl"