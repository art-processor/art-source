/*
 * ?@driverName?_disconnect() is the opposite of ?@driverName?_connect()
 */
 
 static void ?@driverName?_disconnect(struct serio *serio)
{
	struct ?@driverName? *?@driverName? = serio_get_drvdata(serio);

#select driverName
	#option tw|touchit213|tr|inexio|fujitsu|hampshire|dynapro|mtouch|gunze
	input_get_device(?@driverName?->dev);
	input_unregister_device(?@driverName?->dev);
	#endoption
#endselect	
	serio_close(serio);
	serio_set_drvdata(serio, NULL);
	input_put_device(?@driverName?->dev);
	kfree(?@driverName?);
}

/*
 * ?@driverName?_connect() is the routine that is called when someone adds a
 * new serio device that supports ?@driverName? protocol and registers it as
 * an input device.
 */
 
 static int ?@driverName?_connect(struct serio *serio, struct serio_driver *drv)
{
	struct ?@driverName? *?@driverName?;
	struct input_dev *input_dev;