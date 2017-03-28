#select driverName
	#option spaceorb
#define SPACEORB_MAX_LENGTH	64

static int spaceorb_buttons[] = { BTN_TL, BTN_TR, BTN_Y, BTN_X, BTN_B, BTN_A };
static int spaceorb_axes[] = { ABS_X, ABS_Y, ABS_Z, ABS_RX, ABS_RY, ABS_RZ };
	#endoption
	#option spaceball
#define SPACEBALL_MAX_LENGTH	128
#define SPACEBALL_MAX_ID	9

#define SPACEBALL_1003      1
#define SPACEBALL_2003B     3
#define SPACEBALL_2003C     4
#define SPACEBALL_3003C     7
#define SPACEBALL_4000FLX   8
#define SPACEBALL_4000FLX_L 9

static int spaceball_axes[] = { ABS_X, ABS_Z, ABS_Y, ABS_RX, ABS_RZ, ABS_RY };
static char *spaceball_names[] = {
	\"\?\", \"SpaceTec SpaceBall 1003\", \"SpaceTec SpaceBall 2003\", \"SpaceTec SpaceBall 2003B\",
	\"SpaceTec SpaceBall 2003C\", \"SpaceTec SpaceBall 3003\", \"SpaceTec SpaceBall SpaceController\",
	\"SpaceTec SpaceBall 3003C\", \"SpaceTec SpaceBall 4000FLX\", \"SpaceTec SpaceBall 4000FLX Lefty\" };
	#endoption
	#option warrior
#define WARRIOR_MAX_LENGTH	16
static char warrior_lengths[] = { 0, 4, 12, 3, 4, 4, 0, 0 };
	#endoption
	#option twidjoy
#define TWIDJOY_MAX_LENGTH 5

static struct twidjoy_button_spec {
	int bitshift;
	int bitmask;
	int buttons[3];
}
twidjoy_buttons[] = {
	{  0, 3, { BTN_A,      BTN_B,     BTN_C    } },
	{  2, 3, { BTN_X,      BTN_Y,     BTN_Z    } },
	{  4, 3, { BTN_TL,     BTN_TR,    BTN_TR2  } },
	{  6, 3, { BTN_SELECT, BTN_START, BTN_MODE } },
	{  8, 1, { BTN_BASE5                       } },
	{  9, 1, { BTN_BASE                        } },
	{ 10, 1, { BTN_BASE3                       } },
	{ 11, 1, { BTN_BASE4                       } },
	{ 12, 1, { BTN_BASE2                       } },
	{ 13, 1, { BTN_BASE6                       } },
	{ 0,  0, { 0                               } }
};
	#endoption
	#option zhenhua
#define ZHENHUA_MAX_LENGTH 5
	#endoption
	#option magellan
#define	MAGELLAN_MAX_LENGTH	32

static int magellan_buttons[] = { BTN_0, BTN_1, BTN_2, BTN_3, BTN_4, BTN_5, BTN_6, BTN_7, BTN_8 };
static int magellan_axes[] = { ABS_X, ABS_Y, ABS_Z, ABS_RX, ABS_RY, ABS_RZ };
	#endoption
#endselect