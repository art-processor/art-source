#select driverName
	#option dynapro
\#define DYNAPRO_FORMAT_TOUCH_BIT 0x40
\#define DYNAPRO_FORMAT_LENGTH 3
\#define DYNAPRO_RESPONSE_BEGIN_BYTE 0x80

\#define DYNAPRO_MIN_XC 0
\#define DYNAPRO_MAX_XC 0x3ff
\#define DYNAPRO_MIN_YC 0
\#define DYNAPRO_MAX_YC 0x3ff

\#define DYNAPRO_GET_XC(data) (data[1] | ((data[0] & 0x38) << 4))
\#define DYNAPRO_GET_YC(data) (data[2] | ((data[0] & 0x07) << 7))
\#define DYNAPRO_GET_TOUCHED(data) (DYNAPRO_FORMAT_TOUCH_BIT & data[0])
	#endoption
	#option fujitsu
\#define FUJITSU_LENGTH 5
	#endoption
	#option gunze
\#define	GUNZE_MAX_LENGTH	10
	#endoption
	#option hampshire
\#define HAMPSHIRE_FORMAT_TOUCH_BIT 0x40
\#define HAMPSHIRE_FORMAT_LENGTH 4
\#define HAMPSHIRE_RESPONSE_BEGIN_BYTE 0x80

\#define HAMPSHIRE_MIN_XC 0
\#define HAMPSHIRE_MAX_XC 0x1000
\#define HAMPSHIRE_MIN_YC 0
\#define HAMPSHIRE_MAX_YC 0x1000

\#define HAMPSHIRE_GET_XC(data) (((data[3] & 0x0c) >> 2) | (data[1] << 2) | ((data[0] & 0x38) << 6))
\#define HAMPSHIRE_GET_YC(data) ((data[3] & 0x03) | (data[2] << 2) | ((data[0] & 0x07) << 9))
\#define HAMPSHIRE_GET_TOUCHED(data) (HAMPSHIRE_FORMAT_TOUCH_BIT & data[0])
	#endoption
	#option inexio
\#define INEXIO_FORMAT_TOUCH_BIT 0x01
\#define INEXIO_FORMAT_LENGTH 5
\#define INEXIO_RESPONSE_BEGIN_BYTE 0x80

/* todo: check specs for max length of all responses */
\#define INEXIO_MAX_LENGTH 16

\#define INEXIO_MIN_XC 0
\#define INEXIO_MAX_XC 0x3fff
\#define INEXIO_MIN_YC 0
\#define INEXIO_MAX_YC 0x3fff

\#define INEXIO_GET_XC(data) (((data[1])<<7) | data[2])
\#define INEXIO_GET_YC(data) (((data[3])<<7) | data[4])
\#define INEXIO_GET_TOUCHED(data) (INEXIO_FORMAT_TOUCH_BIT & data[0])
	#endoption
	#option mtouch
\#define MTOUCH_FORMAT_TABLET_STATUS_BIT 0x80
\#define MTOUCH_FORMAT_TABLET_TOUCH_BIT 0x40
\#define MTOUCH_FORMAT_TABLET_LENGTH 5
\#define MTOUCH_RESPONSE_BEGIN_BYTE 0x01
\#define MTOUCH_RESPONSE_END_BYTE 0x0d

/* todo: check specs for max length of all responses */
\#define MTOUCH_MAX_LENGTH 16

\#define MTOUCH_MIN_XC 0
\#define MTOUCH_MAX_XC 0x3fff
\#define MTOUCH_MIN_YC 0
\#define MTOUCH_MAX_YC 0x3fff

\#define MTOUCH_GET_XC(data) (((data[2])<<7) | data[1])
\#define MTOUCH_GET_YC(data) (((data[4])<<7) | data[3])
\#define MTOUCH_GET_TOUCHED(data) (MTOUCH_FORMAT_TABLET_TOUCH_BIT & data[0])
	#endoption
	#option touchit213
/*
 * Data is received through COM1 at 9600bit/s,8bit,no parity in packets
 * of 5 byte each.
 *
 *   +--------+   +--------+   +--------+   +--------+   +--------+
 *   |1000000p|   |0xxxxxxx|   |0xxxxxxx|   |0yyyyyyy|   |0yyyyyyy|
 *   +--------+   +--------+   +--------+   +--------+   +--------+
 *                    MSB          LSB          MSB          LSB
 *
 * The value of p is 1 as long as the screen is touched and 0 when
 * reporting the location where touching stopped, e.g. where the pen was
 * lifted from the screen.
 *
 * When holding the screen in landscape mode as the BIOS text output is
 * presented, x is the horizontal axis with values growing from left to
 * right and y is the vertical axis with values growing from top to
 * bottom.
 *
 * When holding the screen in portrait mode with the Sahara logo in its
 * correct position, x ist the vertical axis with values growing from
 * top to bottom and y is the horizontal axis with values growing from
 * right to left.
 */

\#define T213_FORMAT_TOUCH_BIT	0x01
\#define T213_FORMAT_STATUS_BYTE	0x80
\#define T213_FORMAT_STATUS_MASK	~T213_FORMAT_TOUCH_BIT

/*
 * On my Sahara Touch-IT 213 I have observed x values from 0 to 0x7f0
 * and y values from 0x1d to 0x7e9, so the actual measurement is
 * probably done with an 11 bit precision.
 */
\#define T213_MIN_XC 0
\#define T213_MAX_XC 0x07ff
\#define T213_MIN_YC 0
\#define T213_MAX_YC 0x07ff
	#endoption
	#option tr
\#define TR_FORMAT_TOUCH_BIT	0x01
\#define TR_FORMAT_STATUS_BYTE	0x40
\#define TR_FORMAT_STATUS_MASK	~TR_FORMAT_TOUCH_BIT

\#define TR_LENGTH 5

\#define TR_MIN_XC 0	
\#define TR_MAX_XC 0x1ff
\#define TR_MIN_YC 0
\#define TR_MAX_YC 0x1ff
	#endoption
	#option tw
\#define TW_LENGTH 3

\#define TW_MIN_XC 0
\#define TW_MAX_XC 0xff
\#define TW_MIN_YC 0
\#define TW_MAX_YC 0xff
	#endoption
#endselect