#select driverName
	#option dynapro
/*
 * 2009/09/19 Tias Guns <tias@ulyssis.org>
 *   Copied inexio.c and edited for Dynapro protocol (from retired Xorg module)
 */
	#endoption
	#option hampshire
/*
 * 2010/04/08 Adam Bennett <abennett72@gmail.com>
 *   Copied dynapro.c and edited for Hampshire 4-byte protocol
 */
	#endoption
	#option inexio
/*
 * 2008/06/19 Richard Lemon <richard@codelemon.com>
 *   Copied mtouch.c and edited for iNexio protocol
 */
	#endoption
	#option mtouch
/*
 * 2005/02/19 Dan Streetman <ddstreet@ieee.org>
 *   Copied elo.c and edited for MicroTouch protocol
 */
	#endoption
	#option tw
/*
 * 2005/02/19 Rick Koch:
 *   The Touchwindow I used is made by Edmark Corp. and
 *   constantly outputs a stream of 0's unless it is touched.
 *   It then outputs 3 bytes: X, Y, and a copy of Y.
 */
	#endoption
#endselect