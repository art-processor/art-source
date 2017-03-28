#set driverName = 	"tw", 		"touchit213", 	"tr", 		"inexio", 		"fujitsu", 	"hampshire", 			"dynapro", 		"mtouch", 		 "gunze"
#set length = 		"TW_LENGTH", 	"5", 		"TR_LENGTH", 	"INEXIO_MAX_LENGTH", 	"FUJITSU_LENGTH", "HAMPSHIRE_FORMAT_LENGTH", 	"DYNAPRO_FORMAT_LENGTH", 	"MTOUCH_MAX_LENGTH", 	"GUNZE_MAX_LENGTH"

#set description = "Touchwindow serial touchscreen driver", "Sahara TouchIT-213 serial touchscreen driver", "Touchright serial touchscreen driver", "iNexio serial touchscreen driver", "Fujitsu serial touchscreen driver", "Hampshire serial touchscreen driver", "Dynapro serial touchscreen driver", "MicroTouch serial touchscreen driver", "Gunze AHL-51S touchscreen driver"

#set author = "Rick Koch <n1gp@hotmail.com>", "Claudio Nieder <private@claudio.ch>", "Rick Koch <n1gp@hotmail.com>", "Richard Lemon <richard@codelemon.com>", "Dmitry Torokhov <dtor@mail.ru>", "Adam Bennett <abennett72@gmail.com>", "Tias Guns <tias@ulyssis.org>", "Vojtech Pavlik <vojtech@ucw.cz>", "Vojtech Pavlik <vojtech@ucw.cz>"

#set protocolName = "Touchwin", "Touchright", "Touchright", "iNexio", "Fujitsu", "Hampshire", "Dynapro", "MicroTouch (Format Tablet)", "Gunze"

#set serioDrivename = "touchwin", "touchit213", "touchright", "inexio", "fujitsu_ts", "hampshire", "dynapro", "mtouch", "gunze"

#set drvLongName = "Touchwindow Serial TouchScreen", "Sahara TouchIT-213 Serial TouchScreen", "Touchright Serial TouchScreen", "iNexio Serial TouchScreen", "Fujitsu Serial Touchscreen", "Hampshire Serial TouchScreen", "Dynapro Serial TouchScreen", "MicroTouch Serial TouchScreen", "Gunze AHL-51S TouchScreen"

#set vendor = "SERIO_TOUCHWIN", "SERIO_TOUCHIT213", "SERIO_TOUCHRIGHT", "SERIO_INEXIO", "SERIO_FUJITSU", "SERIO_HAMPSHIRE", "SERIO_DYNAPRO", "SERIO_MICROTOUCH", "SERIO_GUNZE"

#set product = "0", "0", "0", "0", "0", "0", "0", "0", "0x0051"

#set serioProto = "TOUCHWIN", "TOUCHIT213", "TOUCHRIGHT", "INEXIO", "FUJITSU", "HAMPSHIRE", "DYNAPRO", "MICROTOUCH", "GUNZE"

#set version = "0x0100", "0x0100", "0x0100", "0x0001", "0x0100", "0x0001", "0x0001", "0x0100",  "0x0100"

#set setAbsParam1 = "tw->dev", "touchit213->dev", "tr->dev", "inexio->dev", "input_dev", "hampshire->dev", "dynapro->dev", "mtouch->dev", "input_dev"
#set setAbsParam2 = "TW_MIN_XC", "T213_MIN_XC", "TR_MIN_XC", "INEXIO_MIN_XC", "0", "HAMPSHIRE_MIN_XC", "DYNAPRO_MIN_XC", "MTOUCH_MIN_XC", "24"
#set setAbsParam3 = "TW_MAX_XC", "T213_MAX_XC", "TR_MAX_XC", "INEXIO_MAX_XC", "4096", "HAMPSHIRE_MAX_XC", "DYNAPRO_MAX_XC", "MTOUCH_MAX_XC", "1000" 
#set setAbsParam4 = "TW_MIN_YC", "T213_MIN_YC", "TR_MIN_YC", "INEXIO_MIN_YC", "0", "HAMPSHIRE_MIN_YC", "DYNAPRO_MIN_YC", "MTOUCH_MIN_YC", "24"
#set setAbsParam5 = "TW_MAX_YC", "T213_MAX_YC", "TR_MAX_YC", "INEXIO_MAX_YC", "4096", "HAMPSHIRE_MAX_YC", "DYNAPRO_MAX_YC", "MTOUCH_MAX_YC", "1000"

#while driverName, length, description, author, protocolName, drvLongName, serioDrivename, vendor, product, serioProto, version, setAbsParam1, setAbsParam2, setAbsParam3, setAbsParam4, setAbsParam5

	#output "output/"?@driverName?"_generated.c"
	#adapt "touchscreen/common.vcl"
	
#endwhile
