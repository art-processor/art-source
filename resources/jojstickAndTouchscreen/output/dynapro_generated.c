
/*
 * Dynapro serial touchscreen driver
 *
 * Copyright (c) 2009 Tias Guns
 * Based on the inexio driver (c) Vojtech Pavlik and Dan Streetman and
 * Richard Lemon
 *
 */
	

/*
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published by
 * the Free Software Foundation.
 */
	

/*
 * 2009/09/19 Tias Guns <tias@ulyssis.org>
 *   Copied inexio.c and edited for Dynapro protocol (from retired Xorg module)
 */
	

#include <linux/errno.h>
#include <linux/kernel.h>
#include <linux/module.h>
#include <linux/slab.h>
#include <linux/input.h>
#include <linux/serio.h>
#include <linux/init.h>

#define DRIVER_DESC	"Dynapro serial touchscreen driver"

MODULE_AUTHOR("Tias Guns <tias@ulyssis.org>");
MODULE_DESCRIPTION(DRIVER_DESC);
MODULE_LICENSE("GPL");

/*
 * Definitions & global arrays.
 */
	
#define DYNAPRO_FORMAT_TOUCH_BIT 0x40
#define DYNAPRO_FORMAT_LENGTH 3
#define DYNAPRO_RESPONSE_BEGIN_BYTE 0x80

#define DYNAPRO_MIN_XC 0
#define DYNAPRO_MAX_XC 0x3ff
#define DYNAPRO_MIN_YC 0
#define DYNAPRO_MAX_YC 0x3ff

#define DYNAPRO_GET_XC(data) (data[1] | ((data[0] & 0x38) << 4))
#define DYNAPRO_GET_YC(data) (data[2] | ((data[0] & 0x07) << 7))
#define DYNAPRO_GET_TOUCHED(data) (DYNAPRO_FORMAT_TOUCH_BIT & data[0])
	
/*
 * Per-touchscreen data.
 */

struct dynapro {
	struct input_dev *dev;
	struct serio *serio;
	int idx;

	unsigned char data[DYNAPRO_FORMAT_LENGTH];
	char phys[32];
};

static void dynapro_process_data(struct dynapro *dynapro)
{
	struct input_dev *dev = dynapro->dev;

	if (DYNAPRO_FORMAT_LENGTH == ++dynapro->idx) {
		input_report_abs(dev, ABS_X, DYNAPRO_GET_XC(dynapro->data));
		input_report_abs(dev, ABS_Y, DYNAPRO_GET_YC(dynapro->data));
		input_report_key(dev, BTN_TOUCH,
				 DYNAPRO_GET_TOUCHED(dynapro->data));
		input_sync(dev);

		dynapro->idx = 0;
	}
}

static irqreturn_t dynapro_interrupt(struct serio *serio,
		unsigned char data, unsigned int flags)
{
	struct dynapro *dynapro = serio_get_drvdata(serio);

	dynapro->data[dynapro->idx] = data;

	if (DYNAPRO_RESPONSE_BEGIN_BYTE & dynapro->data[0])
		dynapro_process_data(dynapro);
	else
	
		
			dev_dbg(&serio->dev, "unknown/unsynchronized data: %x\n",
					dynapro->data[0]);
		return IRQ_HANDLED;
}
			
	

/*
 * dynapro_disconnect() is the opposite of dynapro_connect()
 */
 
 static void dynapro_disconnect(struct serio *serio)
{
	struct dynapro *dynapro = serio_get_drvdata(serio);


	input_get_device(dynapro->dev);
	input_unregister_device(dynapro->dev);
	
	serio_close(serio);
	serio_set_drvdata(serio, NULL);
	input_put_device(dynapro->dev);
	kfree(dynapro);
}

/*
 * dynapro_connect() is the routine that is called when someone adds a
 * new serio device that supports dynapro protocol and registers it as
 * an input device.
 */
 
 static int dynapro_connect(struct serio *serio, struct serio_driver *drv)
{
	struct dynapro *dynapro;
	struct input_dev *input_dev;
	int err;

	dynapro = kzalloc(sizeof(struct dynapro), GFP_KERNEL);
	input_dev = input_allocate_device();
	if (!dynapro || !input_dev) {
		err = -ENOMEM;
		goto fail1;
	}

	dynapro->serio = serio;
	dynapro->dev = input_dev;


	snprintf(dynapro->phys, sizeof(dynapro->phys), "%s/input0", serio->phys);
	

	input_dev->name = "Dynapro Serial TouchScreen";
	input_dev->phys = dynapro->phys;
	input_dev->id.bustype = BUS_RS232;
		input_dev->id.vendor = SERIO_DYNAPRO;
	input_dev->id.product = 0;
	input_dev->id.version = 0x0001;


		input_dev->dev.parent = &serio->dev;
	

	input_dev->evbit[0] = BIT_MASK(EV_KEY) | BIT_MASK(EV_ABS);
	input_dev->keybit[BIT_WORD(BTN_TOUCH)] = BIT_MASK(BTN_TOUCH);
	input_set_abs_params(dynapro->dev, ABS_X, DYNAPRO_MIN_XC, DYNAPRO_MAX_XC, 0, 0);
	input_set_abs_params(dynapro->dev, ABS_Y, DYNAPRO_MIN_YC, DYNAPRO_MAX_YC, 0, 0);

	serio_set_drvdata(serio, dynapro);

	err = serio_open(serio, drv);
	if (err)
		goto fail2;
	err = input_register_device(dynapro->dev);
	if (err)
		goto fail3;

	return 0;

 fail3:	serio_close(serio);
 fail2:	serio_set_drvdata(serio, NULL);
 fail1:	input_free_device(input_dev);
	kfree(dynapro);
	return err;
}
/*
 * The serio driver structure.
 */


static struct serio_device_id dynapro_serio_ids[] = {
	{
		.type	= SERIO_RS232,
		.proto	= SERIO_dynapro,
		.id	= SERIO_ANY,
		.extra	= SERIO_ANY,
	},
	{ 0 }
};

MODULE_DEVICE_TABLE(serio, dynapro_serio_ids);

static struct serio_driver dynapro_drv = {
	.driver		= {

		.name	= "dynapro",
	
	},
	.description	= DRIVER_DESC,
	.id_table	= dynapro_serio_ids,
	.interrupt	= dynapro_interrupt,
	.connect	= dynapro_connect,
	.disconnect	= dynapro_disconnect,
};

module_serio_driver(dynapro_drv);
	