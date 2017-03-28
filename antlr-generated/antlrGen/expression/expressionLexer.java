// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g 2017-03-28 11:47:34

  package antlrGen.expression;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class expressionLexer extends Lexer {
    public static final int COMMANDCHAR=24;
    public static final int LETTER=32;
    public static final int SPECCHAR=31;
    public static final int EOF=-1;
    public static final int T__51=51;
    public static final int ARTVARCHAR=6;
    public static final int IDENT=11;
    public static final int ANYCHAR=33;
    public static final int LLCAP=18;
    public static final int OUTFILE=21;
    public static final int NL=28;
    public static final int DIGIT=30;
    public static final int COMMENT=29;
    public static final int T__50=50;
    public static final int INTEGER=12;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int REFERENCECHAR=10;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int EPRESSIONCHAR=9;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int ISNUMERIC=16;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int DEFINED=5;
    public static final int ULCAP=17;
    public static final int DEBUGMODE=19;
    public static final int ISFIRST=14;
    public static final int COMMENTCHAR=25;
    public static final int WS=27;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int NEGATION=4;
    public static final int DEBUGMODECOMMAND=7;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int DEFAULTOUTPUT=22;
    public static final int OUTDIR=23;
    public static final int CURRENTFILE=20;
    public static final int NOTNEWLINE=26;
    public static final int ISLAST=13;
    public static final int SIZE=15;
    public static final int STRING=8;

    // delegates
    // delegators

    public expressionLexer() {;} 
    public expressionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public expressionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g"; }

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:11:7: ( '&&' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:11:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:12:7: ( '||' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:12:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:13:7: ( '(' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:14:7: ( ')' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:14:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:15:7: ( 'true' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:15:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:16:7: ( 'false' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:16:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:17:7: ( '==' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:17:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:18:7: ( '!=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:18:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:19:7: ( '<' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:19:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:20:7: ( '<=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:20:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:21:7: ( '>=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:21:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:22:7: ( '>' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:22:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:23:7: ( '+' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:23:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "T__47"
    public final void mT__47() throws RecognitionException {
        try {
            int _type = T__47;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:24:7: ( '-' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:24:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__47"

    // $ANTLR start "T__48"
    public final void mT__48() throws RecognitionException {
        try {
            int _type = T__48;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:25:7: ( '*' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:25:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__48"

    // $ANTLR start "T__49"
    public final void mT__49() throws RecognitionException {
        try {
            int _type = T__49;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:26:7: ( '/' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:26:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__49"

    // $ANTLR start "T__50"
    public final void mT__50() throws RecognitionException {
        try {
            int _type = T__50;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:7: ( 'defined' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:9: 'defined'
            {
            match("defined"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__50"

    // $ANTLR start "T__51"
    public final void mT__51() throws RecognitionException {
        try {
            int _type = T__51;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:28:7: ( '$' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:28:9: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__51"

    // $ANTLR start "COMMANDCHAR"
    public final void mCOMMANDCHAR() throws RecognitionException {
        try {
            int _type = COMMANDCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:127:12: ( '#' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:127:14: '#'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:128:14: ( '?' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:128:16: '?'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:129:14: ( '@' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:129:16: '@'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:130:12: ( '%' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:130:14: '%'
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

    // $ANTLR start "CURRENTFILE"
    public final void mCURRENTFILE() throws RecognitionException {
        try {
            int _type = CURRENTFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:132:13: ( 'currentfile' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:132:15: 'currentfile'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:133:15: ( 'defaultoutput' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:133:16: 'defaultoutput'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:134:11: ( 'debugmode' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:134:13: 'debugmode'
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

    // $ANTLR start "OUTFILE"
    public final void mOUTFILE() throws RecognitionException {
        try {
            int _type = OUTFILE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:135:9: ( 'outfile' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:135:11: 'outfile'
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

    // $ANTLR start "OUTDIR"
    public final void mOUTDIR() throws RecognitionException {
        try {
            int _type = OUTDIR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:136:8: ( 'outdir' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:136:10: 'outdir'
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

    // $ANTLR start "SIZE"
    public final void mSIZE() throws RecognitionException {
        try {
            int _type = SIZE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:137:6: ( 'size' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:137:8: 'size'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:138:11: ( 'isnumeric' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:138:13: 'isnumeric'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:139:6: ( 'ulcap' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:139:8: 'ulcap'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:140:6: ( 'llcap' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:140:8: 'llcap'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:144:7: ( 'islast' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:144:9: 'islast'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:145:8: ( 'isfirst' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:145:10: 'isfirst'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:151:5: ( '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:151:8: '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:152:5: ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )*
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
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:152:7: '\\\\\"'
            	    {
            	    match("\\\""); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:153:7: ~ ( '\"' | '\\n' | '\\r' )
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

    // $ANTLR start "NOTNEWLINE"
    public final void mNOTNEWLINE() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:158:21: (~ ( '\\n' | '\\r' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:158:23: ~ ( '\\n' | '\\r' )
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:162:5: ( ( ' ' | '\\t' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:162:9: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            _channel = HIDDEN;

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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:166:5: ( ( '\\n' | '\\r\\n' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:166:9: ( '\\n' | '\\r\\n' )
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:166:9: ( '\\n' | '\\r\\n' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='\n') ) {
                alt2=1;
            }
            else if ( (LA2_0=='\r') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:166:11: '\\n'
                    {
                    match('\n'); 

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:166:18: '\\r\\n'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:5: ( ( ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? ) | ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? ) | ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' ) | ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR ) ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:7: ( ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? ) | ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? ) | ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' ) | ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR ) )
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:7: ( ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? ) | ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? ) | ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' ) | ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR ) )
            int alt10=4;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='%') ) {
                int LA10_1 = input.LA(2);

                if ( ((LA10_1>='\u0000' && LA10_1<='=')||(LA10_1>='?' && LA10_1<='\uFFFF')) ) {
                    alt10=2;
                }
                else if ( (LA10_1=='>') ) {
                    alt10=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA10_0=='#') ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2=='c') ) {
                    alt10=3;
                }
                else if ( (LA10_2=='(') ) {
                    alt10=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:8: ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? )
                    {
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:8: ( COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )? )
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:9: COMMENTCHAR '>' ( . )* '<' COMMENTCHAR ( WS )* ( NL )?
                    {
                    mCOMMENTCHAR(); 
                    match('>'); 
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:25: ( . )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='<') ) {
                            int LA3_1 = input.LA(2);

                            if ( ((LA3_1>='\u0000' && LA3_1<='$')||(LA3_1>='&' && LA3_1<='\uFFFF')) ) {
                                alt3=1;
                            }
                            else if ( (LA3_1=='%') ) {
                                alt3=2;
                            }


                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<=';')||(LA3_0>='=' && LA3_0<='\uFFFF')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:25: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('<'); 
                    mCOMMENTCHAR(); 
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:44: ( WS )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\t'||LA4_0==' ') ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:44: WS
                    	    {
                    	    mWS(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:48: ( NL )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\n'||LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:170:48: NL
                            {
                            mNL(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:7: ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? )
                    {
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:7: ( COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )? )
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:8: COMMENTCHAR ~ ( '>' ) ( NOTNEWLINE )* ( NL )?
                    {
                    mCOMMENTCHAR(); 
                    if ( (input.LA(1)>='\u0000' && input.LA(1)<='=')||(input.LA(1)>='?' && input.LA(1)<='\uFFFF') ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:27: ( NOTNEWLINE )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='\u0000' && LA6_0<='\t')||(LA6_0>='\u000B' && LA6_0<='\f')||(LA6_0>='\u000E' && LA6_0<='\uFFFF')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:28: NOTNEWLINE
                    	    {
                    	    mNOTNEWLINE(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:41: ( NL )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\n'||LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:171:41: NL
                            {
                            mNL(); 

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:172:7: ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' )
                    {
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:172:7: ( COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment' )
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:172:8: COMMANDCHAR 'comment' ( . )* COMMANDCHAR 'endcomment'
                    {
                    mCOMMANDCHAR(); 
                    match("comment"); 

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:172:30: ( . )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0=='#') ) {
                            alt8=2;
                        }
                        else if ( ((LA8_0>='\u0000' && LA8_0<='\"')||(LA8_0>='$' && LA8_0<='\uFFFF')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:172:30: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    mCOMMANDCHAR(); 
                    match("endcomment"); 


                    }


                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:173:7: ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR )
                    {
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:173:7: ( COMMANDCHAR '(' ( . )* ')' COMMANDCHAR )
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:173:8: COMMANDCHAR '(' ( . )* ')' COMMANDCHAR
                    {
                    mCOMMANDCHAR(); 
                    match('('); 
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:173:24: ( . )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==')') ) {
                            int LA9_1 = input.LA(2);

                            if ( ((LA9_1>='\u0000' && LA9_1<='\"')||(LA9_1>='$' && LA9_1<='\uFFFF')) ) {
                                alt9=1;
                            }
                            else if ( (LA9_1=='#') ) {
                                alt9=2;
                            }


                        }
                        else if ( ((LA9_0>='\u0000' && LA9_0<='(')||(LA9_0>='*' && LA9_0<='\uFFFF')) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:173:24: .
                    	    {
                    	    matchAny(); 

                    	    }
                    	    break;

                    	default :
                    	    break loop9;
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

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:176:9: ( ( DIGIT )+ )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:176:11: ( DIGIT )+
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:176:11: ( DIGIT )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='0' && LA11_0<='9')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:176:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
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
            int _type = SPECCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:177:10: ( ( '\"' | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:177:12: ( '\"' | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' )
            {
            if ( input.LA(1)==' '||(input.LA(1)>='\"' && input.LA(1)<='#')||(input.LA(1)>='(' && input.LA(1)<='-')||input.LA(1)=='/'||(input.LA(1)>='?' && input.LA(1)<='@')||input.LA(1)=='|' ) {
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
    // $ANTLR end "SPECCHAR"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:178:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:178:19: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:179:16: ( '0' .. '9' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:179:18: '0' .. '9'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:180:7: ( ( LETTER | DIGIT | '_' | '.' )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:180:9: ( LETTER | DIGIT | '_' | '.' )*
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:180:9: ( LETTER | DIGIT | '_' | '.' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0=='.'||(LA12_0>='0' && LA12_0<='9')||(LA12_0>='A' && LA12_0<='Z')||LA12_0=='_'||(LA12_0>='a' && LA12_0<='z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:
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
    // $ANTLR end "IDENT"

    // $ANTLR start "ANYCHAR"
    public final void mANYCHAR() throws RecognitionException {
        try {
            int _type = ANYCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:181:8: ( . )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:181:10: .
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
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:8: ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | COMMANDCHAR | EPRESSIONCHAR | REFERENCECHAR | COMMENTCHAR | CURRENTFILE | DEFAULTOUTPUT | DEBUGMODE | OUTFILE | OUTDIR | SIZE | ISNUMERIC | ULCAP | LLCAP | ISLAST | ISFIRST | STRING | WS | NL | COMMENT | INTEGER | SPECCHAR | IDENT | ANYCHAR )
        int alt13=41;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:10: T__34
                {
                mT__34(); 

                }
                break;
            case 2 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:16: T__35
                {
                mT__35(); 

                }
                break;
            case 3 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:22: T__36
                {
                mT__36(); 

                }
                break;
            case 4 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:28: T__37
                {
                mT__37(); 

                }
                break;
            case 5 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:34: T__38
                {
                mT__38(); 

                }
                break;
            case 6 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:40: T__39
                {
                mT__39(); 

                }
                break;
            case 7 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:46: T__40
                {
                mT__40(); 

                }
                break;
            case 8 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:52: T__41
                {
                mT__41(); 

                }
                break;
            case 9 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:58: T__42
                {
                mT__42(); 

                }
                break;
            case 10 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:64: T__43
                {
                mT__43(); 

                }
                break;
            case 11 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:70: T__44
                {
                mT__44(); 

                }
                break;
            case 12 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:76: T__45
                {
                mT__45(); 

                }
                break;
            case 13 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:82: T__46
                {
                mT__46(); 

                }
                break;
            case 14 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:88: T__47
                {
                mT__47(); 

                }
                break;
            case 15 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:94: T__48
                {
                mT__48(); 

                }
                break;
            case 16 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:100: T__49
                {
                mT__49(); 

                }
                break;
            case 17 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:106: T__50
                {
                mT__50(); 

                }
                break;
            case 18 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:112: T__51
                {
                mT__51(); 

                }
                break;
            case 19 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:118: COMMANDCHAR
                {
                mCOMMANDCHAR(); 

                }
                break;
            case 20 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:130: EPRESSIONCHAR
                {
                mEPRESSIONCHAR(); 

                }
                break;
            case 21 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:144: REFERENCECHAR
                {
                mREFERENCECHAR(); 

                }
                break;
            case 22 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:158: COMMENTCHAR
                {
                mCOMMENTCHAR(); 

                }
                break;
            case 23 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:170: CURRENTFILE
                {
                mCURRENTFILE(); 

                }
                break;
            case 24 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:182: DEFAULTOUTPUT
                {
                mDEFAULTOUTPUT(); 

                }
                break;
            case 25 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:196: DEBUGMODE
                {
                mDEBUGMODE(); 

                }
                break;
            case 26 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:206: OUTFILE
                {
                mOUTFILE(); 

                }
                break;
            case 27 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:214: OUTDIR
                {
                mOUTDIR(); 

                }
                break;
            case 28 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:221: SIZE
                {
                mSIZE(); 

                }
                break;
            case 29 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:226: ISNUMERIC
                {
                mISNUMERIC(); 

                }
                break;
            case 30 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:236: ULCAP
                {
                mULCAP(); 

                }
                break;
            case 31 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:242: LLCAP
                {
                mLLCAP(); 

                }
                break;
            case 32 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:248: ISLAST
                {
                mISLAST(); 

                }
                break;
            case 33 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:255: ISFIRST
                {
                mISFIRST(); 

                }
                break;
            case 34 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:263: STRING
                {
                mSTRING(); 

                }
                break;
            case 35 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:270: WS
                {
                mWS(); 

                }
                break;
            case 36 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:273: NL
                {
                mNL(); 

                }
                break;
            case 37 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:276: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 38 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:284: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 39 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:292: SPECCHAR
                {
                mSPECCHAR(); 

                }
                break;
            case 40 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:301: IDENT
                {
                mIDENT(); 

                }
                break;
            case 41 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:1:307: ANYCHAR
                {
                mANYCHAR(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\43\1\44\1\47\2\uffff\2\43\2\44\1\57\1\61\4\uffff\1\43\1\uffff"+
        "\1\70\2\uffff\1\74\6\43\1\47\2\uffff\1\44\1\106\12\uffff\2\43\12"+
        "\uffff\1\43\6\uffff\6\43\4\uffff\1\106\14\43\1\142\7\43\1\152\5"+
        "\43\1\uffff\1\160\6\43\1\uffff\3\43\1\172\1\173\1\uffff\5\43\1\u0081"+
        "\1\43\1\u0083\1\43\2\uffff\1\u0085\3\43\1\u0089\1\uffff\1\43\1\uffff"+
        "\1\u008b\1\uffff\3\43\1\uffff\1\43\1\uffff\1\43\1\u0091\1\43\1\u0093"+
        "\1\43\1\uffff\1\43\1\uffff\1\43\1\u0097\1\43\1\uffff\1\u0099\1\uffff";
    static final String DFA13_eofS =
        "\u009a\uffff";
    static final String DFA13_minS =
        "\1\0\1\46\1\174\2\uffff\1\162\1\141\4\75\4\uffff\1\145\1\uffff"+
        "\1\50\2\uffff\1\0\2\165\1\151\1\163\2\154\1\0\2\uffff\1\12\1\56"+
        "\12\uffff\1\165\1\154\12\uffff\1\142\6\uffff\1\162\1\164\1\172\1"+
        "\146\2\143\4\uffff\1\56\1\145\1\163\1\141\1\165\1\162\1\144\1\145"+
        "\1\165\1\141\1\151\2\141\1\56\1\145\1\156\1\165\1\147\1\145\2\151"+
        "\1\56\1\155\1\163\1\162\2\160\1\uffff\1\56\1\145\1\154\1\155\1\156"+
        "\1\154\1\162\1\uffff\1\145\1\164\1\163\2\56\1\uffff\1\144\1\164"+
        "\1\157\1\164\1\145\1\56\1\162\1\56\1\164\2\uffff\1\56\1\157\1\144"+
        "\1\146\1\56\1\uffff\1\151\1\uffff\1\56\1\uffff\1\165\1\145\1\151"+
        "\1\uffff\1\143\1\uffff\1\164\1\56\1\154\1\56\1\160\1\uffff\1\145"+
        "\1\uffff\1\165\1\56\1\164\1\uffff\1\56\1\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\46\1\174\2\uffff\1\162\1\141\4\75\4\uffff\1\145\1\uffff"+
        "\1\143\2\uffff\1\uffff\2\165\1\151\1\163\2\154\1\uffff\2\uffff\1"+
        "\12\1\172\12\uffff\1\165\1\154\12\uffff\1\146\6\uffff\1\162\1\164"+
        "\1\172\1\156\2\143\4\uffff\1\172\1\145\1\163\1\151\1\165\1\162\1"+
        "\146\1\145\1\165\1\141\1\151\2\141\1\172\1\145\1\156\1\165\1\147"+
        "\1\145\2\151\1\172\1\155\1\163\1\162\2\160\1\uffff\1\172\1\145\1"+
        "\154\1\155\1\156\1\154\1\162\1\uffff\1\145\1\164\1\163\2\172\1\uffff"+
        "\1\144\1\164\1\157\1\164\1\145\1\172\1\162\1\172\1\164\2\uffff\1"+
        "\172\1\157\1\144\1\146\1\172\1\uffff\1\151\1\uffff\1\172\1\uffff"+
        "\1\165\1\145\1\151\1\uffff\1\143\1\uffff\1\164\1\172\1\154\1\172"+
        "\1\160\1\uffff\1\145\1\uffff\1\165\1\172\1\164\1\uffff\1\172\1\uffff";
    static final String DFA13_acceptS =
        "\3\uffff\1\3\1\4\6\uffff\1\15\1\16\1\17\1\20\1\uffff\1\22\1\uffff"+
        "\1\24\1\25\10\uffff\1\43\1\44\2\uffff\1\43\1\47\2\50\1\51\1\1\1"+
        "\2\1\47\1\3\1\4\2\uffff\1\7\1\10\1\12\1\11\1\13\1\14\1\15\1\16\1"+
        "\17\1\20\1\uffff\1\22\1\23\1\45\1\24\1\25\1\26\6\uffff\1\42\1\43"+
        "\1\44\1\46\33\uffff\1\5\7\uffff\1\34\5\uffff\1\6\11\uffff\1\36\1"+
        "\37\5\uffff\1\33\1\uffff\1\40\1\uffff\1\21\3\uffff\1\32\1\uffff"+
        "\1\41\5\uffff\1\31\1\uffff\1\35\3\uffff\1\27\1\uffff\1\30";
    static final String DFA13_specialS =
        "\1\0\23\uffff\1\2\6\uffff\1\1\176\uffff}>";
    static final String[] DFA13_transitionS = {
            "\11\44\1\40\1\35\2\44\1\36\22\44\1\34\1\10\1\33\1\21\1\20\1"+
            "\24\1\1\1\44\1\3\1\4\1\15\1\13\1\41\1\14\1\42\1\16\12\37\2\44"+
            "\1\11\1\7\1\12\1\22\1\23\32\42\4\44\1\42\1\44\2\42\1\25\1\17"+
            "\1\42\1\6\2\42\1\30\2\42\1\32\2\42\1\26\3\42\1\27\1\5\1\31\5"+
            "\42\1\44\1\2\uff83\44",
            "\1\45",
            "\1\46",
            "",
            "",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\60",
            "",
            "",
            "",
            "",
            "\1\66",
            "",
            "\1\71\72\uffff\1\71",
            "",
            "",
            "\0\71",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\12\103\1\uffff\2\103\1\uffff\ufff2\103",
            "",
            "",
            "\1\105",
            "\1\43\1\uffff\12\107\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
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
            "\1\110",
            "\1\111",
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
            "\1\113\3\uffff\1\112",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\121\5\uffff\1\120\1\uffff\1\117",
            "\1\122",
            "\1\123",
            "",
            "",
            "",
            "",
            "\1\43\1\uffff\12\107\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\124",
            "\1\125",
            "\1\127\7\uffff\1\126",
            "\1\130",
            "\1\131",
            "\1\133\1\uffff\1\132",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\u0082",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\u0084",
            "",
            "",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "",
            "\1\u008a",
            "",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "",
            "\1\u008f",
            "",
            "\1\u0090",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\u0092",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\u0094",
            "",
            "\1\u0095",
            "",
            "\1\u0096",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            "\1\u0098",
            "",
            "\1\43\1\uffff\12\43\7\uffff\32\43\4\uffff\1\43\1\uffff\32"+
            "\43",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | T__47 | T__48 | T__49 | T__50 | T__51 | COMMANDCHAR | EPRESSIONCHAR | REFERENCECHAR | COMMENTCHAR | CURRENTFILE | DEFAULTOUTPUT | DEBUGMODE | OUTFILE | OUTDIR | SIZE | ISNUMERIC | ULCAP | LLCAP | ISLAST | ISFIRST | STRING | WS | NL | COMMENT | INTEGER | SPECCHAR | IDENT | ANYCHAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='&') ) {s = 1;}

                        else if ( (LA13_0=='|') ) {s = 2;}

                        else if ( (LA13_0=='(') ) {s = 3;}

                        else if ( (LA13_0==')') ) {s = 4;}

                        else if ( (LA13_0=='t') ) {s = 5;}

                        else if ( (LA13_0=='f') ) {s = 6;}

                        else if ( (LA13_0=='=') ) {s = 7;}

                        else if ( (LA13_0=='!') ) {s = 8;}

                        else if ( (LA13_0=='<') ) {s = 9;}

                        else if ( (LA13_0=='>') ) {s = 10;}

                        else if ( (LA13_0=='+') ) {s = 11;}

                        else if ( (LA13_0=='-') ) {s = 12;}

                        else if ( (LA13_0=='*') ) {s = 13;}

                        else if ( (LA13_0=='/') ) {s = 14;}

                        else if ( (LA13_0=='d') ) {s = 15;}

                        else if ( (LA13_0=='$') ) {s = 16;}

                        else if ( (LA13_0=='#') ) {s = 17;}

                        else if ( (LA13_0=='?') ) {s = 18;}

                        else if ( (LA13_0=='@') ) {s = 19;}

                        else if ( (LA13_0=='%') ) {s = 20;}

                        else if ( (LA13_0=='c') ) {s = 21;}

                        else if ( (LA13_0=='o') ) {s = 22;}

                        else if ( (LA13_0=='s') ) {s = 23;}

                        else if ( (LA13_0=='i') ) {s = 24;}

                        else if ( (LA13_0=='u') ) {s = 25;}

                        else if ( (LA13_0=='l') ) {s = 26;}

                        else if ( (LA13_0=='\"') ) {s = 27;}

                        else if ( (LA13_0==' ') ) {s = 28;}

                        else if ( (LA13_0=='\n') ) {s = 29;}

                        else if ( (LA13_0=='\r') ) {s = 30;}

                        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {s = 31;}

                        else if ( (LA13_0=='\t') ) {s = 32;}

                        else if ( (LA13_0==',') ) {s = 33;}

                        else if ( (LA13_0=='.'||(LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||(LA13_0>='a' && LA13_0<='b')||LA13_0=='e'||(LA13_0>='g' && LA13_0<='h')||(LA13_0>='j' && LA13_0<='k')||(LA13_0>='m' && LA13_0<='n')||(LA13_0>='p' && LA13_0<='r')||(LA13_0>='v' && LA13_0<='z')) ) {s = 34;}

                        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='\''||(LA13_0>=':' && LA13_0<=';')||(LA13_0>='[' && LA13_0<='^')||LA13_0=='`'||LA13_0=='{'||(LA13_0>='}' && LA13_0<='\uFFFF')) ) {s = 36;}

                        else s = 35;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA13_27 = input.LA(1);

                        s = -1;
                        if ( ((LA13_27>='\u0000' && LA13_27<='\t')||(LA13_27>='\u000B' && LA13_27<='\f')||(LA13_27>='\u000E' && LA13_27<='\uFFFF')) ) {s = 67;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA13_20 = input.LA(1);

                        s = -1;
                        if ( ((LA13_20>='\u0000' && LA13_20<='\uFFFF')) ) {s = 57;}

                        else s = 60;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}