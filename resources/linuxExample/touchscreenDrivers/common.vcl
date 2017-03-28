#adapt "resources/linuxExample/touchscreenDrivers/description.vcl"
#adapt "resources/linuxExample/touchscreenDrivers/license.vcl"
#adapt "resources/linuxExample/touchscreenDrivers/addCom.vcl"

\#include <linux/errno.h>
\#include <linux/kernel.h>
\#include <linux/module.h>
\#include <linux/slab.h>
\#include <linux/input.h>
\#include <linux/serio.h>
\#include <linux/init.h>

\#define DRIVER_DESC	\"?@description?\"

MODULE_AUTHOR(\"?@author?\");
MODULE_DESCRIPTION(DRIVER_DESC);
MODULE_LICENSE("GPL");

/*
 * Definitions & global arrays.
 */
	#adapt "resources/linuxExample/touchscreenDrivers/addComDef.vcl"
/*
 * Per-touchscreen data.
 */

struct ?@driverName? {
	struct input_dev *dev;
	struct serio *serio;
	int idx;
#select driverName
	#option tw
	int touched; 
	#endoption
	#option touchit213
	unsigned char csum;
	#endoption
#endselect

	unsigned char data[?@length?];
	char phys[32];
};
 
#adapt "resources/linuxExample/touchscreenDrivers/processData.vcl"

#adapt "resources/linuxExample/touchscreenDrivers/interrupt.vcl"

/*
 * ?@driverName?_disconnect() is the opposite of ?@driverName?_connect()
 */
 
 static void ?@driverName?_disconnect(struct serio *serio)
{
	struct ?@driverName? *?@driverName? = serio_get_drvdata(serio);

	input_get_device(?@driverName?->dev);
	input_unregister_device(?@driverName?->dev);
	serio_close(serio);
	serio_set_drvdata(serio, NULL);
	input_put_device(?@driverName?->dev);
	kfree(?@driverName?);
}

/*
 * ?@driverName?_connect() is the routine that is called when someone adds a
 * new serio device that supports ?@protocolName? protocol and registers it as
 * an input device.
 */
 
 static int ?@driverName?_connect(struct serio *serio, struct serio_driver *drv)
{
	struct ?@driverName? *?@driverName?;
	struct input_dev *input_dev;
	int err;

	?@driverName? = kzalloc(sizeof(struct ?@driverName?), GFP_KERNEL);
	input_dev = input_allocate_device();
	if (!?@driverName? || !input_dev) {
		err = -ENOMEM;
		goto fail1;
	}

	?@driverName?->serio = serio;
	?@driverName?->dev = input_dev;
	
#select driverName
	#option gunze
	snprintf(?@driverName?->phys, sizeof(serio->phys), "%s/input0", serio->phys);   
	#endoption
	#otherwise
	snprintf(?@driverName?->phys, sizeof(?@driverName?->phys), "%s/input0", serio->phys);
	#endotherwise
#endselect

	input_dev->name = \"?@drvLongName?\";
	input_dev->phys = ?@driverName?->phys;
	input_dev->id.bustype = BUS_RS232;
		input_dev->id.vendor = ?@vendor?;
	input_dev->id.product = ?@product?;
	input_dev->id.version = ?@version?;

#select driverName
	#option fujitsu
	#endoption
	#otherwise
		input_dev->dev.parent = &serio->dev;
	#endotherwise
#endselect

	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_ABS);
	input_dev->keybit[BIT_WORD(BTN_TOUCH)] = BIT_MASK(BTN_TOUCH);
	input_set_abs_params(?@setAbsParam1?, ABS_X, ?@setAbsParam2?, ?@setAbsParam3?, 0, 0);
	input_set_abs_params(?@setAbsParam1?, ABS_Y, ?@setAbsParam4?, ?@setAbsParam5?, 0, 0);

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

/*
 * The serio driver structure.
 */


static struct serio_device_id ?@driverName?_serio_ids[] = {
	{
		.type	= SERIO_RS232,
		.proto	= SERIO_?@serioProto?,
		.id	= SERIO_ANY,
		.extra	= SERIO_ANY,
	},
	{ 0 }
};

MODULE_DEVICE_TABLE(serio, ?@driverName?_serio_ids);

static struct serio_driver ?@driverName?_drv = {
	.driver		= {
		.name	= \"?@serioDrivename?\",
	},
	.description	= DRIVER_DESC,
	.id_table	= ?@driverName?_serio_ids,
	.interrupt	= ?@driverName?_interrupt,
	.connect	= ?@driverName?_connect,
	.disconnect	= ?@driverName?_disconnect,
};

module_serio_driver(?@driverName?_drv);