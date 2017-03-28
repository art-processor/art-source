/*
 * The serio driver structure.
 */


static struct serio_device_id ?@driverName?_serio_ids[] = {
	{
		.type	= SERIO_RS232,
		.proto	= SERIO_?@driverName?,
		.id	= SERIO_ANY,
		.extra	= SERIO_ANY,
	},
	{ 0 }
};

MODULE_DEVICE_TABLE(serio, ?@driverName?_serio_ids);

static struct serio_driver ?@driverName?_drv = {
	.driver		= {
#select driverName
	#option tw|touchit213|tr|inexio|fujitsu|hampshire|dynapro|mtouch|gunze
		.name	= \"?@serioDrivename?\",
	#endoption
	#option spaceorb|spaceball|warrior|zhenhua|twidjoy|magellan
		.name	= \"?@driverName?\",
	#endoption
#endselect
	},
	.description	= DRIVER_DESC,
	.id_table	= ?@driverName?_serio_ids,
	.interrupt	= ?@driverName?_interrupt,
	.connect	= ?@driverName?_connect,
	.disconnect	= ?@driverName?_disconnect,
};

module_serio_driver(?@driverName?_drv);