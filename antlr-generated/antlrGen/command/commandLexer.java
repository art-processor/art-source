// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g 2017-03-28 13:21:16

  package antlrGen.command;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class commandLexer extends Lexer {
    public static final int WHILE=42;
    public static final int LETTER=81;
    public static final int REMOVE=27;
    public static final int ENDSELECT=29;
    public static final int EOF=-1;
    public static final int BREAK=41;
    public static final int ENDTEXT=58;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int INSERT=35;
    public static final int STRINGNOEND=74;
    public static final int INSERTAFTER=38;
    public static final int ARTVARCHAR=6;
    public static final int ENDIF=22;
    public static final int ANYCHAR=83;
    public static final int VAR=48;
    public static final int LLCAP=68;
    public static final int ENDWHILE=43;
    public static final int NL=7;
    public static final int COMMENT=77;
    public static final int ENDOPTION=31;
    public static final int SELECT=28;
    public static final int T__99=99;
    public static final int EXTENDEDMESSAGE=51;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int OTHERWISE=33;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int SETDEFER=17;
    public static final int DEFINED=5;
    public static final int ELSE=24;
    public static final int MESSAGEDEBUG=55;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int DEBUGMODE=69;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int ELIF=23;
    public static final int WS=76;
    public static final int ENDBREAK=40;
    public static final int DEFAULTOUTPUT=71;
    public static final int ISLAST=63;
    public static final int EXTENDEDADAPT=12;
    public static final int MESSAGEIF=53;
    public static final int ENDADAPT=14;
    public static final int OUTPUT=18;
    public static final int SIZE=65;
    public static final int ADAPTSAMELEVEL=11;
    public static final int COMMANDCHAR=8;
    public static final int OPTION=32;
    public static final int ADAPTCOPY=15;
    public static final int SPECCHAR=80;
    public static final int ENDOTHERWISE=34;
    public static final int IF=21;
    public static final int T__107=107;
    public static final int T__108=108;
    public static final int T__109=109;
    public static final int INSERTBEFORE=37;
    public static final int T__103=103;
    public static final int EXTENDEDADAPTSAMELEVEL=13;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int SIMPLEADAPT=10;
    public static final int IDENT=9;
    public static final int MESSAGE=50;
    public static final int OUTFILE=20;
    public static final int DIGIT=79;
    public static final int DOT=82;
    public static final int ENDMESSAGE=52;
    public static final int EXTENDEDBREAK=39;
    public static final int INTEGER=62;
    public static final int OPTIONUNDEFINED=30;
    public static final int REFERENCECHAR=61;
    public static final int ENDINSERT=36;
    public static final int ENDVARS=47;
    public static final int EPRESSIONCHAR=60;
    public static final int ISNUMERIC=66;
    public static final int EXTENDEDMESSAGEDEBUG=56;
    public static final int ITER=49;
    public static final int ULCAP=67;
    public static final int IFNDEF=26;
    public static final int VARS=46;
    public static final int SET=16;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int IFDEF=25;
    public static final int T__100=100;
    public static final int TEXT=57;
    public static final int ISFIRST=64;
    public static final int ENDSETLOOP=45;
    public static final int COMMENTCHAR=72;
    public static final int NEGATION=4;
    public static final int QUOTATIONMARK=73;
    public static final int OUTDIR=19;
    public static final int CURRENTFILE=70;
    public static final int NOTNEWLINE=75;
    public static final int ESCCOMMENT=78;
    public static final int SETLOOP=44;
    public static final int EXTENDEDMESSAGEIF=54;
    public static final int STRING=59;

    // delegates
    // delegators

    public commandLexer() {;} 
    public commandLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public commandLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g"; }

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:11:7: ( '=' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:11:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:12:7: ( ',' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:12:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:13:7: ( '(' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:14:7: ( ')' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:15:7: ( '|' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:15:9: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:16:7: ( '&&' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:16:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:17:7: ( '||' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:17:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:18:7: ( 'true' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:18:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:19:7: ( 'false' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:19:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:20:7: ( '==' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:20:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:21:7: ( '!=' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:21:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:22:7: ( '<' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:22:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:23:7: ( '<=' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:23:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:24:7: ( '>=' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:24:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:25:7: ( '>' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:25:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:26:7: ( '+' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:26:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:27:8: ( '-' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:27:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:28:8: ( '*' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:28:10: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:29:8: ( '/' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:29:10: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:30:8: ( 'defined' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:30:10: 'defined'
            {
            match("defined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:31:8: ( '$' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:31:10: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:32:8: ( '\\\\\"' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:32:10: '\\\\\"'
            {
            match("\\\""); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:33:8: ( '\\\\#' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:33:10: '\\\\#'
            {
            match("\\#"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:34:8: ( '\\\\?' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:34:10: '\\\\?'
            {
            match("\\?"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "T__108"
    public final void mT__108() throws RecognitionException {
        try {
            int _type = T__108;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:35:8: ( '\\\\%' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:35:10: '\\\\%'
            {
            match("\\%"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__108"

    // $ANTLR start "T__109"
    public final void mT__109() throws RecognitionException {
        try {
            int _type = T__109;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:36:8: ( '\\\\$' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:36:10: '\\\\$'
            {
            match("\\$"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__109"

    // $ANTLR start "COMMANDCHAR"
    public final void mCOMMANDCHAR() throws RecognitionException {
        try {
            int _type = COMMANDCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:996:12: ( '#' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:996:14: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMANDCHAR"

    // $ANTLR start "EPRESSIONCHAR"
    public final void mEPRESSIONCHAR() throws RecognitionException {
        try {
            int _type = EPRESSIONCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:997:14: ( '?' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:997:16: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EPRESSIONCHAR"

    // $ANTLR start "REFERENCECHAR"
    public final void mREFERENCECHAR() throws RecognitionException {
        try {
            int _type = REFERENCECHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:998:14: ( '@' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:998:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REFERENCECHAR"

    // $ANTLR start "COMMENTCHAR"
    public final void mCOMMENTCHAR() throws RecognitionException {
        try {
            int _type = COMMENTCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:999:12: ( '%' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:999:14: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENTCHAR"

    // $ANTLR start "QUOTATIONMARK"
    public final void mQUOTATIONMARK() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1000:23: ( '\"' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1000:25: '\"'
            {
            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QUOTATIONMARK"

    // $ANTLR start "CURRENTFILE"
    public final void mCURRENTFILE() throws RecognitionException {
        try {
            int _type = CURRENTFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1002:13: ( 'currentfile' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1002:15: 'currentfile'
            {
            match("currentfile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CURRENTFILE"

    // $ANTLR start "DEFAULTOUTPUT"
    public final void mDEFAULTOUTPUT() throws RecognitionException {
        try {
            int _type = DEFAULTOUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1003:15: ( 'defaultoutput' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1003:16: 'defaultoutput'
            {
            match("defaultoutput"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFAULTOUTPUT"

    // $ANTLR start "DEBUGMODE"
    public final void mDEBUGMODE() throws RecognitionException {
        try {
            int _type = DEBUGMODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1004:11: ( 'debugmode' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1004:13: 'debugmode'
            {
            match("debugmode"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUGMODE"

    // $ANTLR start "SIZE"
    public final void mSIZE() throws RecognitionException {
        try {
            int _type = SIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1005:6: ( 'size' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1005:8: 'size'
            {
            match("size"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIZE"

    // $ANTLR start "ISNUMERIC"
    public final void mISNUMERIC() throws RecognitionException {
        try {
            int _type = ISNUMERIC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1006:11: ( 'isnumeric' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1006:13: 'isnumeric'
            {
            match("isnumeric"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISNUMERIC"

    // $ANTLR start "ULCAP"
    public final void mULCAP() throws RecognitionException {
        try {
            int _type = ULCAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1007:6: ( 'ulcap' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1007:8: 'ulcap'
            {
            match("ulcap"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ULCAP"

    // $ANTLR start "LLCAP"
    public final void mLLCAP() throws RecognitionException {
        try {
            int _type = LLCAP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1008:6: ( 'llcap' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1008:8: 'llcap'
            {
            match("llcap"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LLCAP"

    // $ANTLR start "ISLAST"
    public final void mISLAST() throws RecognitionException {
        try {
            int _type = ISLAST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1012:7: ( 'islast' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1012:9: 'islast'
            {
            match("islast"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISLAST"

    // $ANTLR start "ISFIRST"
    public final void mISFIRST() throws RecognitionException {
        try {
            int _type = ISFIRST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1013:8: ( 'isfirst' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1013:10: 'isfirst'
            {
            match("isfirst"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISFIRST"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1019:5: ( '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1019:8: '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1020:5: ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=3;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\\') ) {
                    int LA1_2 = input.LA(2);

                    if ( (LA1_2=='\"') ) {
                        int LA1_4 = input.LA(3);

                        if ( ((LA1_4>='\u0000' && LA1_4<='\t')||(LA1_4>='\u000B' && LA1_4<='\f')||(LA1_4>='\u000E' && LA1_4<='\uFFFF')) ) {
                            alt1=1;
                        }

                        else {
                            alt1=2;
                        }

                    }
                    else if ( ((LA1_2>='\u0000' && LA1_2<='\t')||(LA1_2>='\u000B' && LA1_2<='\f')||(LA1_2>='\u000E' && LA1_2<='!')||(LA1_2>='#' && LA1_2<='\uFFFF')) ) {
                        alt1=2;
                    }


                }
                else if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='!')||(LA1_0>='#' && LA1_0<='[')||(LA1_0>=']' && LA1_0<='\uFFFF')) ) {
                    alt1=2;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1020:7: '\\\\\"'
            	    {
            	    match("\\\""); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1021:7: ~ ( '\"' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "STRINGNOEND"
    public final void mSTRINGNOEND() throws RecognitionException {
        try {
            int _type = STRINGNOEND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1027:5: ( '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1027:8: '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )*
            {
            match('\"'); 
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1028:5: ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\\') ) {
                    int LA2_2 = input.LA(2);

                    if ( (LA2_2=='\"') ) {
                        alt2=1;
                    }

                    else {
                        alt2=2;
                    }

                }
                else if ( ((LA2_0>='\u0000' && LA2_0<='\t')||(LA2_0>='\u000B' && LA2_0<='\f')||(LA2_0>='\u000E' && LA2_0<='!')||(LA2_0>='#' && LA2_0<='[')||(LA2_0>=']' && LA2_0<='\uFFFF')) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1028:7: '\\\\\"'
            	    {
            	    match("\\\""); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1029:7: ~ ( '\"' | '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRINGNOEND"

    // $ANTLR start "NOTNEWLINE"
    public final void mNOTNEWLINE() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1033:21: (~ ( '\\n' | '\\r' ) )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1033:23: ~ ( '\\n' | '\\r' )
            {
            if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "NOTNEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1041:5: ( ( ' ' | '\\t' ) )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1041:9: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "NL"
    public final void mNL() throws RecognitionException {
        try {
            int _type = NL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1045:5: ( ( '\\n' | '\\r\\n' ) )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1045:9: ( '\\n' | '\\r\\n' )
            {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1045:9: ( '\\n' | '\\r\\n' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n') ) {
                alt3=1;
            }
            else if ( (LA3_0=='\r') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1045:11: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1045:18: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NL"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:5: ( ( ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? ) | ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? ) | ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' ) | ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR ) ) )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:7: ( ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? ) | ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? ) | ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' ) | ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR ) )
            {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:7: ( ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? ) | ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? ) | ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' ) | ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR ) )
            int alt11=4;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='%') ) {
                int LA11_1 = input.LA(2);

                if ( ((LA11_1>='\u0000' && LA11_1<='=')||(LA11_1>='?' && LA11_1<='\uFFFF')) ) {
                    alt11=2;
                }
                else if ( (LA11_1=='>') ) {
                    alt11=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA11_0=='#') ) {
                int LA11_2 = input.LA(2);

                if ( (LA11_2=='c') ) {
                    alt11=3;
                }
                else if ( (LA11_2=='(') ) {
                    alt11=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:8: ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? )
                    {
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:8: ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? )
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:9: COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )?
                    {
                    mCOMMENTCHAR(); 
                    match('>'); 
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:25: ( . )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='<') ) {
                            int LA4_1 = input.LA(2);

                            if ( (LA4_1=='%') ) {
                                alt4=2;
                            }
                            else if ( ((LA4_1>='\u0000' && LA4_1<='$')||(LA4_1>='&' && LA4_1<='\uFFFF')) ) {
                                alt4=1;
                            }


                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<=';')||(LA4_0>='=' && LA4_0<='\uFFFF')) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:25: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('<'); 
                    mCOMMENTCHAR(); 
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:44: ( WS )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\t'||LA5_0==' ') ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:44: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:48: ( NL )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\n'||LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1052:48: NL
                            {
                            mNL(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:7: ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? )
                    {
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:7: ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? )
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:8: COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )?
                    {
                    mCOMMENTCHAR(); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:27: ( NOTNEWLINE )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:28: NOTNEWLINE
                    	    {
                    	    mNOTNEWLINE(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:41: ( NL )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\n'||LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1053:41: NL
                            {
                            mNL(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1054:7: ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' )
                    {
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1054:7: ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' )
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1054:8: COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment'
                    {
                    mCOMMANDCHAR(); 
                    match("comment"); 

                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1054:30: ( . )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0=='#') ) {
                            alt9=2;
                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='\"')||(LA9_0>='$' && LA9_0<='\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1054:30: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    mCOMMANDCHAR(); 
                    match("endcomment"); 


                    }


                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1055:7: ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR )
                    {
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1055:7: ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR )
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1055:8: COMMANDCHAR '(' ( . )* ')' COMMANDCHAR
                    {
                    mCOMMANDCHAR(); 
                    match('('); 
                    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1055:24: ( . )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==')') ) {
                            int LA10_1 = input.LA(2);

                            if ( (LA10_1=='#') ) {
                                alt10=2;
                            }
                            else if ( ((LA10_1>='\u0000' && LA10_1<='\"')||(LA10_1>='$' && LA10_1<='\uFFFF')) ) {
                                alt10=1;
                            }


                        }
                        else if ( ((LA10_0>='\u0000' && LA10_0<='(')||(LA10_0>='*' && LA10_0<='\uFFFF')) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1055:24: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    match(')'); 
                    mCOMMANDCHAR(); 

                    }


                    }
                    break;

            }

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "ESCCOMMENT"
    public final void mESCCOMMENT() throws RecognitionException {
        try {
            int _type = ESCCOMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1063:13: ( ( '\\\\' ) COMMENTCHAR ( WS | NOTNEWLINE )* )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1063:15: ( '\\\\' ) COMMENTCHAR ( WS | NOTNEWLINE )*
            {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1063:15: ( '\\\\' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1063:16: '\\\\'
            {
            match('\\'); 

            }

            mCOMMENTCHAR(); 
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1063:34: ( WS | NOTNEWLINE )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\u0000' && LA12_0<='\t')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\uFFFF')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ESCCOMMENT"

    // $ANTLR start "SIMPLEADAPT"
    public final void mSIMPLEADAPT() throws RecognitionException {
        try {
            int _type = SIMPLEADAPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1066:12: ( 'adapt' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1066:14: 'adapt'
            {
            match("adapt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SIMPLEADAPT"

    // $ANTLR start "EXTENDEDADAPT"
    public final void mEXTENDEDADAPT() throws RecognitionException {
        try {
            int _type = EXTENDEDADAPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1068:14: ( 'adapt:' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1068:16: 'adapt:'
            {
            match("adapt:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDEDADAPT"

    // $ANTLR start "ADAPTSAMELEVEL"
    public final void mADAPTSAMELEVEL() throws RecognitionException {
        try {
            int _type = ADAPTSAMELEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1070:15: ( 'adapt-samelevel' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1070:17: 'adapt-samelevel'
            {
            match("adapt-samelevel"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADAPTSAMELEVEL"

    // $ANTLR start "ADAPTCOPY"
    public final void mADAPTCOPY() throws RecognitionException {
        try {
            int _type = ADAPTCOPY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1072:10: ( 'adapt-copy' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1072:12: 'adapt-copy'
            {
            match("adapt-copy"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ADAPTCOPY"

    // $ANTLR start "EXTENDEDADAPTSAMELEVEL"
    public final void mEXTENDEDADAPTSAMELEVEL() throws RecognitionException {
        try {
            int _type = EXTENDEDADAPTSAMELEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1074:23: ( 'adapt-samelevel:' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1074:25: 'adapt-samelevel:'
            {
            match("adapt-samelevel:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDEDADAPTSAMELEVEL"

    // $ANTLR start "ENDADAPT"
    public final void mENDADAPT() throws RecognitionException {
        try {
            int _type = ENDADAPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1076:9: ( 'endadapt' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1076:11: 'endadapt'
            {
            match("endadapt"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDADAPT"

    // $ANTLR start "SET"
    public final void mSET() throws RecognitionException {
        try {
            int _type = SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1078:4: ( 'set' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1078:6: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SET"

    // $ANTLR start "SETDEFER"
    public final void mSETDEFER() throws RecognitionException {
        try {
            int _type = SETDEFER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1080:9: ( 'set-defer' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1080:11: 'set-defer'
            {
            match("set-defer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SETDEFER"

    // $ANTLR start "REMOVE"
    public final void mREMOVE() throws RecognitionException {
        try {
            int _type = REMOVE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1082:7: ( 'remove' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1082:9: 'remove'
            {
            match("remove"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "REMOVE"

    // $ANTLR start "OUTPUT"
    public final void mOUTPUT() throws RecognitionException {
        try {
            int _type = OUTPUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1084:7: ( 'output' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1084:9: 'output'
            {
            match("output"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPUT"

    // $ANTLR start "OUTDIR"
    public final void mOUTDIR() throws RecognitionException {
        try {
            int _type = OUTDIR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1086:7: ( 'outdir' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1086:9: 'outdir'
            {
            match("outdir"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTDIR"

    // $ANTLR start "OUTFILE"
    public final void mOUTFILE() throws RecognitionException {
        try {
            int _type = OUTFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1088:8: ( 'outfile' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1088:10: 'outfile'
            {
            match("outfile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTFILE"

    // $ANTLR start "INSERT"
    public final void mINSERT() throws RecognitionException {
        try {
            int _type = INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1090:7: ( 'insert' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1090:9: 'insert'
            {
            match("insert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSERT"

    // $ANTLR start "INSERTBEFORE"
    public final void mINSERTBEFORE() throws RecognitionException {
        try {
            int _type = INSERTBEFORE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1092:13: ( 'insert-before' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1092:15: 'insert-before'
            {
            match("insert-before"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSERTBEFORE"

    // $ANTLR start "INSERTAFTER"
    public final void mINSERTAFTER() throws RecognitionException {
        try {
            int _type = INSERTAFTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1094:12: ( 'insert-after' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1094:14: 'insert-after'
            {
            match("insert-after"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INSERTAFTER"

    // $ANTLR start "ENDINSERT"
    public final void mENDINSERT() throws RecognitionException {
        try {
            int _type = ENDINSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1096:10: ( 'endinsert' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1096:12: 'endinsert'
            {
            match("endinsert"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDINSERT"

    // $ANTLR start "EXTENDEDBREAK"
    public final void mEXTENDEDBREAK() throws RecognitionException {
        try {
            int _type = EXTENDEDBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1098:14: ( 'break:' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1098:16: 'break:'
            {
            match("break:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDEDBREAK"

    // $ANTLR start "BREAK"
    public final void mBREAK() throws RecognitionException {
        try {
            int _type = BREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1100:6: ( 'break' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1100:8: 'break'
            {
            match("break"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BREAK"

    // $ANTLR start "ENDBREAK"
    public final void mENDBREAK() throws RecognitionException {
        try {
            int _type = ENDBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1102:9: ( 'endbreak' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1102:11: 'endbreak'
            {
            match("endbreak"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDBREAK"

    // $ANTLR start "WHILE"
    public final void mWHILE() throws RecognitionException {
        try {
            int _type = WHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1104:6: ( 'while' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1104:8: 'while'
            {
            match("while"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WHILE"

    // $ANTLR start "ENDWHILE"
    public final void mENDWHILE() throws RecognitionException {
        try {
            int _type = ENDWHILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1106:9: ( 'endwhile' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1106:11: 'endwhile'
            {
            match("endwhile"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDWHILE"

    // $ANTLR start "SELECT"
    public final void mSELECT() throws RecognitionException {
        try {
            int _type = SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1108:7: ( 'select' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1108:9: 'select'
            {
            match("select"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SELECT"

    // $ANTLR start "ENDSELECT"
    public final void mENDSELECT() throws RecognitionException {
        try {
            int _type = ENDSELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1110:10: ( 'endselect' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1110:12: 'endselect'
            {
            match("endselect"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDSELECT"

    // $ANTLR start "OPTIONUNDEFINED"
    public final void mOPTIONUNDEFINED() throws RecognitionException {
        try {
            int _type = OPTIONUNDEFINED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1112:16: ( 'option-undefined' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1112:18: 'option-undefined'
            {
            match("option-undefined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPTIONUNDEFINED"

    // $ANTLR start "OPTION"
    public final void mOPTION() throws RecognitionException {
        try {
            int _type = OPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1114:7: ( 'option' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1114:9: 'option'
            {
            match("option"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPTION"

    // $ANTLR start "OTHERWISE"
    public final void mOTHERWISE() throws RecognitionException {
        try {
            int _type = OTHERWISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1116:10: ( 'otherwise' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1116:12: 'otherwise'
            {
            match("otherwise"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OTHERWISE"

    // $ANTLR start "ENDOTHERWISE"
    public final void mENDOTHERWISE() throws RecognitionException {
        try {
            int _type = ENDOTHERWISE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1118:13: ( 'endotherwise' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1118:15: 'endotherwise'
            {
            match("endotherwise"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDOTHERWISE"

    // $ANTLR start "ENDOPTION"
    public final void mENDOPTION() throws RecognitionException {
        try {
            int _type = ENDOPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1120:10: ( 'endoption' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1120:12: 'endoption'
            {
            match("endoption"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDOPTION"

    // $ANTLR start "IF"
    public final void mIF() throws RecognitionException {
        try {
            int _type = IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1122:3: ( 'art.if' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1122:5: 'art.if'
            {
            match("art.if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IF"

    // $ANTLR start "ELIF"
    public final void mELIF() throws RecognitionException {
        try {
            int _type = ELIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1124:5: ( 'art.elif' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1124:7: 'art.elif'
            {
            match("art.elif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELIF"

    // $ANTLR start "ELSE"
    public final void mELSE() throws RecognitionException {
        try {
            int _type = ELSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1126:5: ( 'art.else' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1126:7: 'art.else'
            {
            match("art.else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ELSE"

    // $ANTLR start "IFDEF"
    public final void mIFDEF() throws RecognitionException {
        try {
            int _type = IFDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1128:6: ( 'art.ifdef' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1128:8: 'art.ifdef'
            {
            match("art.ifdef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IFDEF"

    // $ANTLR start "IFNDEF"
    public final void mIFNDEF() throws RecognitionException {
        try {
            int _type = IFNDEF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1130:7: ( 'art.ifndef' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1130:9: 'art.ifndef'
            {
            match("art.ifndef"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IFNDEF"

    // $ANTLR start "ENDIF"
    public final void mENDIF() throws RecognitionException {
        try {
            int _type = ENDIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1132:6: ( 'art.endif' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1132:8: 'art.endif'
            {
            match("art.endif"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDIF"

    // $ANTLR start "SETLOOP"
    public final void mSETLOOP() throws RecognitionException {
        try {
            int _type = SETLOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1134:8: ( 'setloop' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1134:10: 'setloop'
            {
            match("setloop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SETLOOP"

    // $ANTLR start "ENDSETLOOP"
    public final void mENDSETLOOP() throws RecognitionException {
        try {
            int _type = ENDSETLOOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1136:11: ( 'endsetloop' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1136:13: 'endsetloop'
            {
            match("endsetloop"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDSETLOOP"

    // $ANTLR start "VARS"
    public final void mVARS() throws RecognitionException {
        try {
            int _type = VARS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1138:5: ( 'vars' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1138:7: 'vars'
            {
            match("vars"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VARS"

    // $ANTLR start "ENDVARS"
    public final void mENDVARS() throws RecognitionException {
        try {
            int _type = ENDVARS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1140:8: ( 'endvars' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1140:10: 'endvars'
            {
            match("endvars"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDVARS"

    // $ANTLR start "VAR"
    public final void mVAR() throws RecognitionException {
        try {
            int _type = VAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1142:4: ( 'var' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1142:6: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VAR"

    // $ANTLR start "ITER"
    public final void mITER() throws RecognitionException {
        try {
            int _type = ITER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1144:5: ( 'iter' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1144:7: 'iter'
            {
            match("iter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ITER"

    // $ANTLR start "MESSAGE"
    public final void mMESSAGE() throws RecognitionException {
        try {
            int _type = MESSAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1146:8: ( 'message' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1146:11: 'message'
            {
            match("message"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MESSAGE"

    // $ANTLR start "EXTENDEDMESSAGE"
    public final void mEXTENDEDMESSAGE() throws RecognitionException {
        try {
            int _type = EXTENDEDMESSAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1148:16: ( 'message:' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1148:19: 'message:'
            {
            match("message:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDEDMESSAGE"

    // $ANTLR start "MESSAGEIF"
    public final void mMESSAGEIF() throws RecognitionException {
        try {
            int _type = MESSAGEIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1150:10: ( 'message-if' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1150:13: 'message-if'
            {
            match("message-if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MESSAGEIF"

    // $ANTLR start "EXTENDEDMESSAGEIF"
    public final void mEXTENDEDMESSAGEIF() throws RecognitionException {
        try {
            int _type = EXTENDEDMESSAGEIF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1152:18: ( 'message-if:' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1152:21: 'message-if:'
            {
            match("message-if:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDEDMESSAGEIF"

    // $ANTLR start "MESSAGEDEBUG"
    public final void mMESSAGEDEBUG() throws RecognitionException {
        try {
            int _type = MESSAGEDEBUG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1154:13: ( 'message-debug' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1154:16: 'message-debug'
            {
            match("message-debug"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MESSAGEDEBUG"

    // $ANTLR start "EXTENDEDMESSAGEDEBUG"
    public final void mEXTENDEDMESSAGEDEBUG() throws RecognitionException {
        try {
            int _type = EXTENDEDMESSAGEDEBUG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1156:21: ( 'message-debug:' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1156:24: 'message-debug:'
            {
            match("message-debug:"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXTENDEDMESSAGEDEBUG"

    // $ANTLR start "ENDMESSAGE"
    public final void mENDMESSAGE() throws RecognitionException {
        try {
            int _type = ENDMESSAGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1158:11: ( 'endmessage' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1158:14: 'endmessage'
            {
            match("endmessage"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDMESSAGE"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1160:5: ( 'text' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1160:8: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "ENDTEXT"
    public final void mENDTEXT() throws RecognitionException {
        try {
            int _type = ENDTEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1162:8: ( 'endtext' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1162:11: 'endtext'
            {
            match("endtext"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ENDTEXT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1165:9: ( ( DIGIT )+ )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1165:11: ( DIGIT )+
            {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1165:11: ( DIGIT )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='0' && LA13_0<='9')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1165:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "SPECCHAR"
    public final void mSPECCHAR() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1166:19: ( ( QUOTATIONMARK | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' | '>' | '<' ) )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1166:21: ( QUOTATIONMARK | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' | '>' | '<' )
            {
            if ( input.LA(1)==' '||(input.LA(1)>='\"' && input.LA(1)<='#')||(input.LA(1)>='(' && input.LA(1)<='-')||input.LA(1)=='/'||input.LA(1)=='<'||(input.LA(1)>='>' && input.LA(1)<='@')||input.LA(1)=='|' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SPECCHAR"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1167:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1167:19: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1168:16: ( '0' .. '9' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1168:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1169:7: ( ( LETTER | '_' ) ( LETTER | DIGIT | '_' | '.' )* )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1169:9: ( LETTER | '_' ) ( LETTER | DIGIT | '_' | '.' )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1169:23: ( LETTER | DIGIT | '_' | '.' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='.'||(LA14_0>='0' && LA14_0<='9')||(LA14_0>='A' && LA14_0<='Z')||LA14_0=='_'||(LA14_0>='a' && LA14_0<='z')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:
            	    {
            	    if ( input.LA(1)=='.'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "DOT"
    public final void mDOT() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1170:13: ( '.' )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1170:15: '.'
            {
            match('.'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DOT"

    // $ANTLR start "ANYCHAR"
    public final void mANYCHAR() throws RecognitionException {
        try {
            int _type = ANYCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1171:8: ( . )
            // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1171:10: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ANYCHAR"

    public void mTokens() throws RecognitionException {
        // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:8: ( T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | COMMANDCHAR | EPRESSIONCHAR | REFERENCECHAR | COMMENTCHAR | CURRENTFILE | DEFAULTOUTPUT | DEBUGMODE | SIZE | ISNUMERIC | ULCAP | LLCAP | ISLAST | ISFIRST | STRING | STRINGNOEND | WS | NL | COMMENT | ESCCOMMENT | SIMPLEADAPT | EXTENDEDADAPT | ADAPTSAMELEVEL | ADAPTCOPY | EXTENDEDADAPTSAMELEVEL | ENDADAPT | SET | SETDEFER | REMOVE | OUTPUT | OUTDIR | OUTFILE | INSERT | INSERTBEFORE | INSERTAFTER | ENDINSERT | EXTENDEDBREAK | BREAK | ENDBREAK | WHILE | ENDWHILE | SELECT | ENDSELECT | OPTIONUNDEFINED | OPTION | OTHERWISE | ENDOTHERWISE | ENDOPTION | IF | ELIF | ELSE | IFDEF | IFNDEF | ENDIF | SETLOOP | ENDSETLOOP | VARS | ENDVARS | VAR | ITER | MESSAGE | EXTENDEDMESSAGE | MESSAGEIF | EXTENDEDMESSAGEIF | MESSAGEDEBUG | EXTENDEDMESSAGEDEBUG | ENDMESSAGE | TEXT | ENDTEXT | INTEGER | IDENT | ANYCHAR )
        int alt15=97;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:10: T__84
                {
                mT__84(); 

                }
                break;
            case 2 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:16: T__85
                {
                mT__85(); 

                }
                break;
            case 3 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:22: T__86
                {
                mT__86(); 

                }
                break;
            case 4 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:28: T__87
                {
                mT__87(); 

                }
                break;
            case 5 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:34: T__88
                {
                mT__88(); 

                }
                break;
            case 6 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:40: T__89
                {
                mT__89(); 

                }
                break;
            case 7 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:46: T__90
                {
                mT__90(); 

                }
                break;
            case 8 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:52: T__91
                {
                mT__91(); 

                }
                break;
            case 9 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:58: T__92
                {
                mT__92(); 

                }
                break;
            case 10 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:64: T__93
                {
                mT__93(); 

                }
                break;
            case 11 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:70: T__94
                {
                mT__94(); 

                }
                break;
            case 12 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:76: T__95
                {
                mT__95(); 

                }
                break;
            case 13 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:82: T__96
                {
                mT__96(); 

                }
                break;
            case 14 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:88: T__97
                {
                mT__97(); 

                }
                break;
            case 15 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:94: T__98
                {
                mT__98(); 

                }
                break;
            case 16 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:100: T__99
                {
                mT__99(); 

                }
                break;
            case 17 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:106: T__100
                {
                mT__100(); 

                }
                break;
            case 18 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:113: T__101
                {
                mT__101(); 

                }
                break;
            case 19 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:120: T__102
                {
                mT__102(); 

                }
                break;
            case 20 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:127: T__103
                {
                mT__103(); 

                }
                break;
            case 21 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:134: T__104
                {
                mT__104(); 

                }
                break;
            case 22 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:141: T__105
                {
                mT__105(); 

                }
                break;
            case 23 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:148: T__106
                {
                mT__106(); 

                }
                break;
            case 24 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:155: T__107
                {
                mT__107(); 

                }
                break;
            case 25 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:162: T__108
                {
                mT__108(); 

                }
                break;
            case 26 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:169: T__109
                {
                mT__109(); 

                }
                break;
            case 27 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:176: COMMANDCHAR
                {
                mCOMMANDCHAR(); 

                }
                break;
            case 28 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:188: EPRESSIONCHAR
                {
                mEPRESSIONCHAR(); 

                }
                break;
            case 29 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:202: REFERENCECHAR
                {
                mREFERENCECHAR(); 

                }
                break;
            case 30 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:216: COMMENTCHAR
                {
                mCOMMENTCHAR(); 

                }
                break;
            case 31 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:228: CURRENTFILE
                {
                mCURRENTFILE(); 

                }
                break;
            case 32 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:240: DEFAULTOUTPUT
                {
                mDEFAULTOUTPUT(); 

                }
                break;
            case 33 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:254: DEBUGMODE
                {
                mDEBUGMODE(); 

                }
                break;
            case 34 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:264: SIZE
                {
                mSIZE(); 

                }
                break;
            case 35 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:269: ISNUMERIC
                {
                mISNUMERIC(); 

                }
                break;
            case 36 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:279: ULCAP
                {
                mULCAP(); 

                }
                break;
            case 37 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:285: LLCAP
                {
                mLLCAP(); 

                }
                break;
            case 38 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:291: ISLAST
                {
                mISLAST(); 

                }
                break;
            case 39 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:298: ISFIRST
                {
                mISFIRST(); 

                }
                break;
            case 40 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:306: STRING
                {
                mSTRING(); 

                }
                break;
            case 41 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:313: STRINGNOEND
                {
                mSTRINGNOEND(); 

                }
                break;
            case 42 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:325: WS
                {
                mWS(); 

                }
                break;
            case 43 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:328: NL
                {
                mNL(); 

                }
                break;
            case 44 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:331: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 45 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:339: ESCCOMMENT
                {
                mESCCOMMENT(); 

                }
                break;
            case 46 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:350: SIMPLEADAPT
                {
                mSIMPLEADAPT(); 

                }
                break;
            case 47 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:362: EXTENDEDADAPT
                {
                mEXTENDEDADAPT(); 

                }
                break;
            case 48 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:376: ADAPTSAMELEVEL
                {
                mADAPTSAMELEVEL(); 

                }
                break;
            case 49 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:391: ADAPTCOPY
                {
                mADAPTCOPY(); 

                }
                break;
            case 50 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:401: EXTENDEDADAPTSAMELEVEL
                {
                mEXTENDEDADAPTSAMELEVEL(); 

                }
                break;
            case 51 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:424: ENDADAPT
                {
                mENDADAPT(); 

                }
                break;
            case 52 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:433: SET
                {
                mSET(); 

                }
                break;
            case 53 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:437: SETDEFER
                {
                mSETDEFER(); 

                }
                break;
            case 54 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:446: REMOVE
                {
                mREMOVE(); 

                }
                break;
            case 55 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:453: OUTPUT
                {
                mOUTPUT(); 

                }
                break;
            case 56 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:460: OUTDIR
                {
                mOUTDIR(); 

                }
                break;
            case 57 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:467: OUTFILE
                {
                mOUTFILE(); 

                }
                break;
            case 58 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:475: INSERT
                {
                mINSERT(); 

                }
                break;
            case 59 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:482: INSERTBEFORE
                {
                mINSERTBEFORE(); 

                }
                break;
            case 60 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:495: INSERTAFTER
                {
                mINSERTAFTER(); 

                }
                break;
            case 61 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:507: ENDINSERT
                {
                mENDINSERT(); 

                }
                break;
            case 62 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:517: EXTENDEDBREAK
                {
                mEXTENDEDBREAK(); 

                }
                break;
            case 63 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:531: BREAK
                {
                mBREAK(); 

                }
                break;
            case 64 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:537: ENDBREAK
                {
                mENDBREAK(); 

                }
                break;
            case 65 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:546: WHILE
                {
                mWHILE(); 

                }
                break;
            case 66 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:552: ENDWHILE
                {
                mENDWHILE(); 

                }
                break;
            case 67 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:561: SELECT
                {
                mSELECT(); 

                }
                break;
            case 68 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:568: ENDSELECT
                {
                mENDSELECT(); 

                }
                break;
            case 69 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:578: OPTIONUNDEFINED
                {
                mOPTIONUNDEFINED(); 

                }
                break;
            case 70 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:594: OPTION
                {
                mOPTION(); 

                }
                break;
            case 71 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:601: OTHERWISE
                {
                mOTHERWISE(); 

                }
                break;
            case 72 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:611: ENDOTHERWISE
                {
                mENDOTHERWISE(); 

                }
                break;
            case 73 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:624: ENDOPTION
                {
                mENDOPTION(); 

                }
                break;
            case 74 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:634: IF
                {
                mIF(); 

                }
                break;
            case 75 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:637: ELIF
                {
                mELIF(); 

                }
                break;
            case 76 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:642: ELSE
                {
                mELSE(); 

                }
                break;
            case 77 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:647: IFDEF
                {
                mIFDEF(); 

                }
                break;
            case 78 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:653: IFNDEF
                {
                mIFNDEF(); 

                }
                break;
            case 79 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:660: ENDIF
                {
                mENDIF(); 

                }
                break;
            case 80 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:666: SETLOOP
                {
                mSETLOOP(); 

                }
                break;
            case 81 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:674: ENDSETLOOP
                {
                mENDSETLOOP(); 

                }
                break;
            case 82 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:685: VARS
                {
                mVARS(); 

                }
                break;
            case 83 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:690: ENDVARS
                {
                mENDVARS(); 

                }
                break;
            case 84 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:698: VAR
                {
                mVAR(); 

                }
                break;
            case 85 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:702: ITER
                {
                mITER(); 

                }
                break;
            case 86 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:707: MESSAGE
                {
                mMESSAGE(); 

                }
                break;
            case 87 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:715: EXTENDEDMESSAGE
                {
                mEXTENDEDMESSAGE(); 

                }
                break;
            case 88 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:731: MESSAGEIF
                {
                mMESSAGEIF(); 

                }
                break;
            case 89 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:741: EXTENDEDMESSAGEIF
                {
                mEXTENDEDMESSAGEIF(); 

                }
                break;
            case 90 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:759: MESSAGEDEBUG
                {
                mMESSAGEDEBUG(); 

                }
                break;
            case 91 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:772: EXTENDEDMESSAGEDEBUG
                {
                mEXTENDEDMESSAGEDEBUG(); 

                }
                break;
            case 92 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:793: ENDMESSAGE
                {
                mENDMESSAGE(); 

                }
                break;
            case 93 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:804: TEXT
                {
                mTEXT(); 

                }
                break;
            case 94 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:809: ENDTEXT
                {
                mENDTEXT(); 

                }
                break;
            case 95 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:817: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 96 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:825: IDENT
                {
                mIDENT(); 

                }
                break;
            case 97 :
                // C:\\work\\art\\latest-code\\ART\\src\\art\\grammar\\command.g:1:831: ANYCHAR
                {
                mANYCHAR(); 

                }
                break;

        }

    }


    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA15_eotS =
        "\1\uffff\1\54\3\uffff\1\61\1\52\2\65\1\52\1\71\1\73\4\uffff\1\65"+
        "\1\uffff\1\52\1\107\2\uffff\1\113\5\65\1\126\2\uffff\1\52\10\65"+
        "\13\uffff\2\65\1\uffff\1\65\11\uffff\1\65\4\uffff\1\153\6\uffff"+
        "\10\65\2\126\4\uffff\13\65\1\uffff\5\65\2\uffff\2\65\1\u008e\10"+
        "\65\1\127\11\65\1\u00ab\1\65\1\u00ad\1\u00ae\5\65\1\u00b4\1\uffff"+
        "\1\65\1\uffff\5\65\1\u00bb\25\65\1\u00d3\1\uffff\1\65\2\uffff\1"+
        "\u00d5\4\65\1\uffff\6\65\1\uffff\1\u00e0\1\u00e1\1\u00e4\22\65\1"+
        "\u00fa\1\u00fb\1\uffff\1\65\1\uffff\5\65\1\u0102\1\65\1\u0104\1"+
        "\65\1\u0107\5\uffff\1\u010c\15\65\1\u011b\1\u011c\1\u011d\1\65\1"+
        "\u0120\1\65\3\uffff\1\65\1\u0123\3\65\1\u0127\1\uffff\1\65\1\uffff"+
        "\1\u0129\4\uffff\2\65\1\uffff\13\65\1\u013a\1\65\1\u013c\3\uffff"+
        "\1\u013d\2\uffff\1\65\1\u0141\1\uffff\3\65\1\uffff\1\65\4\uffff"+
        "\2\65\1\u0149\1\u014a\1\65\1\u014c\1\65\1\u014e\1\u014f\4\65\1\uffff"+
        "\1\65\2\uffff\1\65\3\uffff\1\65\1\u0159\1\65\1\u015b\1\uffff\1\u015d"+
        "\1\65\2\uffff\1\u015f\1\uffff\1\u0160\2\uffff\1\u0161\2\65\1\u0164"+
        "\1\65\1\u0166\2\uffff\1\65\1\uffff\1\65\3\uffff\1\u016c\3\uffff"+
        "\1\u016d\1\65\1\uffff\1\u016f\1\uffff\1\u0171\1\uffff\1\65\1\u0174"+
        "\3\uffff\1\65\4\uffff\1\65\2\uffff\1\u017a\1\uffff\1\u017c\2\uffff"+
        "\1\u017f\4\uffff\1\u0182\2\uffff";
    static final String DFA15_eofS =
        "\u0183\uffff";
    static final String DFA15_minS =
        "\1\0\1\75\3\uffff\1\174\1\46\1\145\1\141\3\75\4\uffff\1\145\1\uffff"+
        "\1\42\1\50\2\uffff\1\0\1\165\1\145\1\156\2\154\1\0\2\uffff\1\12"+
        "\1\144\1\156\1\145\1\160\1\162\1\150\1\141\1\145\13\uffff\1\165"+
        "\1\170\1\uffff\1\154\11\uffff\1\142\4\uffff\1\0\6\uffff\1\162\1"+
        "\172\1\154\1\146\1\163\1\145\2\143\2\0\4\uffff\1\141\1\164\1\144"+
        "\1\155\2\164\1\150\1\145\1\151\1\162\1\163\1\uffff\1\145\1\164\1"+
        "\163\1\141\1\165\2\uffff\1\162\1\145\1\55\1\145\1\165\1\141\1\151"+
        "\1\145\1\162\2\141\1\0\1\160\1\56\1\141\1\157\1\144\1\151\1\145"+
        "\1\141\1\154\1\56\1\163\2\56\1\145\1\156\1\165\1\147\1\145\1\56"+
        "\1\uffff\1\157\1\uffff\1\143\1\155\1\163\2\162\1\56\2\160\1\164"+
        "\1\145\1\144\1\156\1\162\1\150\1\145\1\160\1\141\2\145\1\166\1\165"+
        "\2\151\1\157\1\162\1\153\1\145\1\56\1\uffff\1\141\2\uffff\1\56\1"+
        "\145\1\154\1\155\1\156\1\uffff\1\157\1\164\1\145\1\164\1\163\1\164"+
        "\1\uffff\2\56\1\55\1\146\1\154\1\141\1\163\1\145\1\151\1\154\1\150"+
        "\1\164\1\162\1\163\1\170\1\145\1\164\1\162\1\154\1\156\1\167\2\56"+
        "\1\uffff\1\147\1\uffff\1\144\1\164\1\157\1\164\1\160\1\56\1\162"+
        "\1\56\1\164\1\55\3\uffff\1\143\1\uffff\1\56\1\151\1\144\1\160\1"+
        "\145\1\141\1\154\1\145\1\154\1\145\1\151\2\163\1\164\3\56\1\145"+
        "\1\55\1\151\3\uffff\1\145\1\56\1\157\1\144\1\146\1\56\1\uffff\1"+
        "\151\1\uffff\1\56\1\141\1\uffff\1\141\1\uffff\1\145\1\144\1\uffff"+
        "\1\146\1\145\1\151\1\164\1\162\1\153\1\145\1\143\1\157\1\162\1\157"+
        "\1\56\1\141\1\56\3\uffff\1\56\2\uffff\1\163\1\55\1\uffff\1\165\1"+
        "\145\1\151\1\uffff\1\143\3\uffff\1\155\1\146\1\145\2\56\1\146\1"+
        "\56\1\164\2\56\1\164\1\157\1\167\1\156\1\uffff\1\147\2\uffff\1\145"+
        "\1\uffff\1\144\1\uffff\1\164\1\56\1\154\1\56\1\145\1\56\1\146\2"+
        "\uffff\1\56\1\uffff\1\56\2\uffff\1\56\1\160\1\151\1\56\1\145\1\56"+
        "\1\146\1\145\1\160\1\uffff\1\145\1\uffff\1\154\1\uffff\1\56\3\uffff"+
        "\1\56\1\163\1\uffff\1\56\1\uffff\1\72\1\142\1\165\1\56\1\145\2\uffff"+
        "\1\145\3\uffff\1\165\1\164\1\uffff\1\166\1\56\1\147\1\56\1\145\1"+
        "\uffff\1\72\1\uffff\1\154\2\uffff\1\72\2\uffff";
    static final String DFA15_maxS =
        "\1\uffff\1\75\3\uffff\1\174\1\46\1\162\1\141\3\75\4\uffff\1\145"+
        "\1\uffff\1\77\1\143\2\uffff\1\uffff\1\165\1\151\1\164\2\154\1\uffff"+
        "\2\uffff\1\12\1\162\1\156\1\145\1\165\1\162\1\150\1\141\1\145\13"+
        "\uffff\1\165\1\170\1\uffff\1\154\11\uffff\1\146\4\uffff\1\uffff"+
        "\6\uffff\1\162\1\172\1\164\1\156\1\163\1\145\2\143\2\uffff\4\uffff"+
        "\1\141\1\164\1\144\1\155\2\164\1\150\1\145\1\151\1\162\1\163\1\uffff"+
        "\1\145\1\164\1\163\1\151\1\165\2\uffff\1\162\1\145\1\172\1\145\1"+
        "\165\1\141\1\151\1\145\1\162\2\141\1\uffff\1\160\1\56\1\167\1\157"+
        "\1\160\1\151\1\145\1\141\1\154\1\172\1\163\2\172\1\145\1\156\1\165"+
        "\1\147\1\145\1\172\1\uffff\1\157\1\uffff\1\143\1\155\1\163\2\162"+
        "\1\172\2\160\1\164\1\151\1\144\1\156\1\162\1\150\1\145\1\164\1\141"+
        "\2\145\1\166\1\165\2\151\1\157\1\162\1\153\1\145\1\172\1\uffff\1"+
        "\141\2\uffff\1\172\1\145\1\154\1\155\1\156\1\uffff\1\157\1\164\1"+
        "\145\1\164\1\163\1\164\1\uffff\3\172\1\146\1\156\1\141\1\163\1\145"+
        "\1\151\1\164\1\150\1\164\1\162\1\163\1\170\1\145\1\164\1\162\1\154"+
        "\1\156\1\167\2\172\1\uffff\1\147\1\uffff\1\144\1\164\1\157\1\164"+
        "\1\160\1\172\1\162\1\172\1\164\1\172\3\uffff\1\163\1\uffff\1\172"+
        "\1\163\1\144\1\160\1\145\1\141\1\154\1\145\1\154\1\145\1\151\2\163"+
        "\1\164\3\172\1\145\1\172\1\151\3\uffff\1\145\1\172\1\157\1\144\1"+
        "\146\1\172\1\uffff\1\151\1\uffff\1\172\1\142\1\uffff\1\141\1\uffff"+
        "\1\145\1\144\1\uffff\1\146\1\145\1\151\1\164\1\162\1\153\1\145\1"+
        "\143\1\157\1\162\1\157\1\172\1\141\1\172\3\uffff\1\172\2\uffff\1"+
        "\163\1\172\1\uffff\1\165\1\145\1\151\1\uffff\1\143\3\uffff\1\155"+
        "\1\146\1\145\2\172\1\146\1\172\1\164\2\172\1\164\1\157\1\167\1\156"+
        "\1\uffff\1\147\2\uffff\1\145\1\uffff\1\151\1\uffff\1\164\1\172\1"+
        "\154\1\172\1\145\1\172\1\146\2\uffff\1\172\1\uffff\1\172\2\uffff"+
        "\1\172\1\160\1\151\1\172\1\145\1\172\1\146\1\145\1\160\1\uffff\1"+
        "\145\1\uffff\1\154\1\uffff\1\172\3\uffff\1\172\1\163\1\uffff\1\172"+
        "\1\uffff\1\72\1\142\1\165\1\172\1\145\2\uffff\1\145\3\uffff\1\165"+
        "\1\164\1\uffff\1\166\1\172\1\147\1\172\1\145\1\uffff\1\72\1\uffff"+
        "\1\154\2\uffff\1\72\2\uffff";
    static final String DFA15_acceptS =
        "\2\uffff\1\2\1\3\1\4\7\uffff\1\20\1\21\1\22\1\23\1\uffff\1\25\2"+
        "\uffff\1\34\1\35\7\uffff\1\52\1\53\11\uffff\1\137\1\140\1\141\1"+
        "\12\1\1\1\2\1\3\1\4\1\7\1\5\1\6\2\uffff\1\140\1\uffff\1\13\1\15"+
        "\1\14\1\16\1\17\1\20\1\21\1\22\1\23\1\uffff\1\25\1\26\1\27\1\30"+
        "\1\uffff\1\32\1\33\1\54\1\34\1\35\1\36\12\uffff\1\51\1\50\1\52\1"+
        "\53\13\uffff\1\137\5\uffff\1\31\1\55\37\uffff\1\65\1\uffff\1\64"+
        "\34\uffff\1\124\1\uffff\1\10\1\135\5\uffff\1\42\6\uffff\1\125\27"+
        "\uffff\1\122\1\uffff\1\11\12\uffff\1\44\1\45\1\57\1\uffff\1\56\24"+
        "\uffff\1\76\1\77\1\101\6\uffff\1\103\1\uffff\1\46\2\uffff\1\72\1"+
        "\uffff\1\61\2\uffff\1\112\16\uffff\1\66\1\67\1\70\1\uffff\1\105"+
        "\1\106\2\uffff\1\24\3\uffff\1\120\1\uffff\1\47\1\73\1\74\16\uffff"+
        "\1\123\1\uffff\1\136\1\71\1\uffff\1\127\1\uffff\1\126\7\uffff\1"+
        "\113\1\114\1\uffff\1\63\1\uffff\1\100\1\102\11\uffff\1\41\1\uffff"+
        "\1\43\1\uffff\1\115\1\uffff\1\117\1\75\1\104\2\uffff\1\111\1\uffff"+
        "\1\107\5\uffff\1\116\1\121\1\uffff\1\134\1\131\1\130\2\uffff\1\37"+
        "\5\uffff\1\110\1\uffff\1\40\1\uffff\1\133\1\132\1\uffff\1\62\1\60";
    static final String DFA15_specialS =
        "\1\4\25\uffff\1\0\5\uffff\1\1\50\uffff\1\5\16\uffff\1\3\1\6\42"+
        "\uffff\1\2\u010a\uffff}>";
    static final String[] DFA15_transitionS = {
            "\11\52\1\35\1\36\2\52\1\37\22\52\1\35\1\11\1\34\1\23\1\21\1"+
            "\26\1\6\1\52\1\3\1\4\1\16\1\14\1\2\1\15\1\52\1\17\12\50\2\52"+
            "\1\12\1\1\1\13\1\24\1\25\32\51\1\52\1\22\2\52\1\51\1\52\1\40"+
            "\1\44\1\27\1\20\1\41\1\10\2\51\1\31\2\51\1\33\1\47\1\51\1\43"+
            "\2\51\1\42\1\30\1\7\1\32\1\46\1\45\3\51\1\52\1\5\uff83\52",
            "\1\53",
            "",
            "",
            "",
            "\1\60",
            "\1\62",
            "\1\64\14\uffff\1\63",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\72",
            "",
            "",
            "",
            "",
            "\1\100",
            "",
            "\1\102\1\103\1\106\1\105\31\uffff\1\104",
            "\1\110\72\uffff\1\110",
            "",
            "",
            "\0\110",
            "\1\114",
            "\1\116\3\uffff\1\115",
            "\1\120\4\uffff\1\117\1\121",
            "\1\122",
            "\1\123",
            "\12\125\1\uffff\2\125\1\uffff\24\125\1\127\71\125\1\124\uffa3"+
            "\125",
            "",
            "",
            "\1\131",
            "\1\132\15\uffff\1\133",
            "\1\134",
            "\1\135",
            "\1\137\3\uffff\1\140\1\136",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\146",
            "\1\147",
            "",
            "\1\150",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\152\3\uffff\1\151",
            "",
            "",
            "",
            "",
            "\12\154\1\uffff\2\154\1\uffff\ufff2\154",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\155",
            "\1\156",
            "\1\160\7\uffff\1\157",
            "\1\163\5\uffff\1\162\1\uffff\1\161",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\12\125\1\uffff\2\125\1\uffff\24\125\1\170\71\125\1\124\uffa3"+
            "\125",
            "\12\125\1\uffff\2\125\1\uffff\24\125\1\127\71\125\1\124\uffa3"+
            "\125",
            "",
            "",
            "",
            "",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0088\7\uffff\1\u0087",
            "\1\u0089",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff"+
            "\13\65\1\u008d\16\65",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\1\u0094",
            "\1\u0095",
            "\1\u0096",
            "\12\125\1\uffff\2\125\1\uffff\24\125\1\uffff\71\125\1\124"+
            "\uffa3\125",
            "\1\u0097",
            "\1\u0098",
            "\1\u0099\1\u009b\6\uffff\1\u009a\3\uffff\1\u00a0\1\uffff\1"+
            "\u009e\3\uffff\1\u009d\1\u00a1\1\uffff\1\u009f\1\u009c",
            "\1\u00a2",
            "\1\u00a4\1\uffff\1\u00a5\11\uffff\1\u00a3",
            "\1\u00a6",
            "\1\u00a7",
            "\1\u00a8",
            "\1\u00a9",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\22"+
            "\65\1\u00aa\7\65",
            "\1\u00ac",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\1\u00b2",
            "\1\u00b3",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u00b5",
            "",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00c0\3\uffff\1\u00bf",
            "\1\u00c1",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c7\3\uffff\1\u00c6",
            "\1\u00c8",
            "\1\u00c9",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u00d4",
            "",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u00e3\1\65\1\uffff\12\65\1\u00e2\6\uffff\32\65\4\uffff"+
            "\1\65\1\uffff\32\65",
            "\1\u00e5",
            "\1\u00e6\1\uffff\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec\7\uffff\1\u00ed",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "\1\u00f2",
            "\1\u00f3",
            "\1\u00f4",
            "\1\u00f5",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8",
            "\1\65\1\uffff\12\65\1\u00f9\6\uffff\32\65\4\uffff\1\65\1\uffff"+
            "\32\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\u00ff",
            "\1\u0100",
            "\1\u0101",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0103",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0105",
            "\1\u0106\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff"+
            "\32\65",
            "",
            "",
            "",
            "\1\u0109\17\uffff\1\u0108",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\3\65"+
            "\1\u010a\11\65\1\u010b\14\65",
            "\1\u010d\11\uffff\1\u010e",
            "\1\u010f",
            "\1\u0110",
            "\1\u0111",
            "\1\u0112",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\1\u0116",
            "\1\u0117",
            "\1\u0118",
            "\1\u0119",
            "\1\u011a",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u011e",
            "\1\u011f\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff"+
            "\32\65",
            "\1\u0121",
            "",
            "",
            "",
            "\1\u0122",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0124",
            "\1\u0125",
            "\1\u0126",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u0128",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u012b\1\u012a",
            "",
            "\1\u012c",
            "",
            "\1\u012d",
            "\1\u012e",
            "",
            "\1\u012f",
            "\1\u0130",
            "\1\u0131",
            "\1\u0132",
            "\1\u0133",
            "\1\u0134",
            "\1\u0135",
            "\1\u0136",
            "\1\u0137",
            "\1\u0138",
            "\1\u0139",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u013b",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\u013e",
            "\1\u0140\1\65\1\uffff\12\65\1\u013f\6\uffff\32\65\4\uffff"+
            "\1\65\1\uffff\32\65",
            "",
            "\1\u0142",
            "\1\u0143",
            "\1\u0144",
            "",
            "\1\u0145",
            "",
            "",
            "",
            "\1\u0146",
            "\1\u0147",
            "\1\u0148",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u014b",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u014d",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0150",
            "\1\u0151",
            "\1\u0152",
            "\1\u0153",
            "",
            "\1\u0154",
            "",
            "",
            "\1\u0155",
            "",
            "\1\u0157\4\uffff\1\u0156",
            "",
            "\1\u0158",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u015a",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u015c",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u015e",
            "",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0162",
            "\1\u0163",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0165",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0167",
            "\1\u0168",
            "\1\u0169",
            "",
            "\1\u016a",
            "",
            "\1\u016b",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u016e",
            "",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "",
            "\1\u0170",
            "\1\u0172",
            "\1\u0173",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u0175",
            "",
            "",
            "\1\u0176",
            "",
            "",
            "",
            "\1\u0177",
            "\1\u0178",
            "",
            "\1\u0179",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u017b",
            "\1\65\1\uffff\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32"+
            "\65",
            "\1\u017d",
            "",
            "\1\u017e",
            "",
            "\1\u0180",
            "",
            "",
            "\1\u0181",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | T__108 | T__109 | COMMANDCHAR | EPRESSIONCHAR | REFERENCECHAR | COMMENTCHAR | CURRENTFILE | DEFAULTOUTPUT | DEBUGMODE | SIZE | ISNUMERIC | ULCAP | LLCAP | ISLAST | ISFIRST | STRING | STRINGNOEND | WS | NL | COMMENT | ESCCOMMENT | SIMPLEADAPT | EXTENDEDADAPT | ADAPTSAMELEVEL | ADAPTCOPY | EXTENDEDADAPTSAMELEVEL | ENDADAPT | SET | SETDEFER | REMOVE | OUTPUT | OUTDIR | OUTFILE | INSERT | INSERTBEFORE | INSERTAFTER | ENDINSERT | EXTENDEDBREAK | BREAK | ENDBREAK | WHILE | ENDWHILE | SELECT | ENDSELECT | OPTIONUNDEFINED | OPTION | OTHERWISE | ENDOTHERWISE | ENDOPTION | IF | ELIF | ELSE | IFDEF | IFNDEF | ENDIF | SETLOOP | ENDSETLOOP | VARS | ENDVARS | VAR | ITER | MESSAGE | EXTENDEDMESSAGE | MESSAGEIF | EXTENDEDMESSAGEIF | MESSAGEDEBUG | EXTENDEDMESSAGEDEBUG | ENDMESSAGE | TEXT | ENDTEXT | INTEGER | IDENT | ANYCHAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA15_22 = input.LA(1);

                        s = -1;
                        if ( ((LA15_22>='\u0000' && LA15_22<='\uFFFF')) ) {s = 72;}

                        else s = 75;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA15_28 = input.LA(1);

                        s = -1;
                        if ( (LA15_28=='\\') ) {s = 84;}

                        else if ( ((LA15_28>='\u0000' && LA15_28<='\t')||(LA15_28>='\u000B' && LA15_28<='\f')||(LA15_28>='\u000E' && LA15_28<='!')||(LA15_28>='#' && LA15_28<='[')||(LA15_28>=']' && LA15_28<='\uFFFF')) ) {s = 85;}

                        else if ( (LA15_28=='\"') ) {s = 87;}

                        else s = 86;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA15_120 = input.LA(1);

                        s = -1;
                        if ( (LA15_120=='\\') ) {s = 84;}

                        else if ( ((LA15_120>='\u0000' && LA15_120<='\t')||(LA15_120>='\u000B' && LA15_120<='\f')||(LA15_120>='\u000E' && LA15_120<='!')||(LA15_120>='#' && LA15_120<='[')||(LA15_120>=']' && LA15_120<='\uFFFF')) ) {s = 85;}

                        else s = 87;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA15_84 = input.LA(1);

                        s = -1;
                        if ( (LA15_84=='\"') ) {s = 120;}

                        else if ( (LA15_84=='\\') ) {s = 84;}

                        else if ( ((LA15_84>='\u0000' && LA15_84<='\t')||(LA15_84>='\u000B' && LA15_84<='\f')||(LA15_84>='\u000E' && LA15_84<='!')||(LA15_84>='#' && LA15_84<='[')||(LA15_84>=']' && LA15_84<='\uFFFF')) ) {s = 85;}

                        else s = 86;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA15_0 = input.LA(1);

                        s = -1;
                        if ( (LA15_0=='=') ) {s = 1;}

                        else if ( (LA15_0==',') ) {s = 2;}

                        else if ( (LA15_0=='(') ) {s = 3;}

                        else if ( (LA15_0==')') ) {s = 4;}

                        else if ( (LA15_0=='|') ) {s = 5;}

                        else if ( (LA15_0=='&') ) {s = 6;}

                        else if ( (LA15_0=='t') ) {s = 7;}

                        else if ( (LA15_0=='f') ) {s = 8;}

                        else if ( (LA15_0=='!') ) {s = 9;}

                        else if ( (LA15_0=='<') ) {s = 10;}

                        else if ( (LA15_0=='>') ) {s = 11;}

                        else if ( (LA15_0=='+') ) {s = 12;}

                        else if ( (LA15_0=='-') ) {s = 13;}

                        else if ( (LA15_0=='*') ) {s = 14;}

                        else if ( (LA15_0=='/') ) {s = 15;}

                        else if ( (LA15_0=='d') ) {s = 16;}

                        else if ( (LA15_0=='$') ) {s = 17;}

                        else if ( (LA15_0=='\\') ) {s = 18;}

                        else if ( (LA15_0=='#') ) {s = 19;}

                        else if ( (LA15_0=='?') ) {s = 20;}

                        else if ( (LA15_0=='@') ) {s = 21;}

                        else if ( (LA15_0=='%') ) {s = 22;}

                        else if ( (LA15_0=='c') ) {s = 23;}

                        else if ( (LA15_0=='s') ) {s = 24;}

                        else if ( (LA15_0=='i') ) {s = 25;}

                        else if ( (LA15_0=='u') ) {s = 26;}

                        else if ( (LA15_0=='l') ) {s = 27;}

                        else if ( (LA15_0=='\"') ) {s = 28;}

                        else if ( (LA15_0=='\t'||LA15_0==' ') ) {s = 29;}

                        else if ( (LA15_0=='\n') ) {s = 30;}

                        else if ( (LA15_0=='\r') ) {s = 31;}

                        else if ( (LA15_0=='a') ) {s = 32;}

                        else if ( (LA15_0=='e') ) {s = 33;}

                        else if ( (LA15_0=='r') ) {s = 34;}

                        else if ( (LA15_0=='o') ) {s = 35;}

                        else if ( (LA15_0=='b') ) {s = 36;}

                        else if ( (LA15_0=='w') ) {s = 37;}

                        else if ( (LA15_0=='v') ) {s = 38;}

                        else if ( (LA15_0=='m') ) {s = 39;}

                        else if ( ((LA15_0>='0' && LA15_0<='9')) ) {s = 40;}

                        else if ( ((LA15_0>='A' && LA15_0<='Z')||LA15_0=='_'||(LA15_0>='g' && LA15_0<='h')||(LA15_0>='j' && LA15_0<='k')||LA15_0=='n'||(LA15_0>='p' && LA15_0<='q')||(LA15_0>='x' && LA15_0<='z')) ) {s = 41;}

                        else if ( ((LA15_0>='\u0000' && LA15_0<='\b')||(LA15_0>='\u000B' && LA15_0<='\f')||(LA15_0>='\u000E' && LA15_0<='\u001F')||LA15_0=='\''||LA15_0=='.'||(LA15_0>=':' && LA15_0<=';')||LA15_0=='['||(LA15_0>=']' && LA15_0<='^')||LA15_0=='`'||LA15_0=='{'||(LA15_0>='}' && LA15_0<='\uFFFF')) ) {s = 42;}

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA15_69 = input.LA(1);

                        s = -1;
                        if ( ((LA15_69>='\u0000' && LA15_69<='\t')||(LA15_69>='\u000B' && LA15_69<='\f')||(LA15_69>='\u000E' && LA15_69<='\uFFFF')) ) {s = 108;}

                        else s = 107;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA15_85 = input.LA(1);

                        s = -1;
                        if ( (LA15_85=='\"') ) {s = 87;}

                        else if ( (LA15_85=='\\') ) {s = 84;}

                        else if ( ((LA15_85>='\u0000' && LA15_85<='\t')||(LA15_85>='\u000B' && LA15_85<='\f')||(LA15_85>='\u000E' && LA15_85<='!')||(LA15_85>='#' && LA15_85<='[')||(LA15_85>=']' && LA15_85<='\uFFFF')) ) {s = 85;}

                        else s = 86;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 15, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}