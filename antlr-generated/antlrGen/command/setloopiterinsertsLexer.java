// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g 2017-03-28 11:47:28

  package antlrGen.command;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class setloopiterinsertsLexer extends Lexer {
    public static final int INTEGER=10;
    public static final int REFERENCECHAR=9;
    public static final int EPRESSIONCHAR=8;
    public static final int COMMANDCHAR=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int LETTER=17;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int SPECCHAR=16;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int WS=13;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int NEGATION=4;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTATIONMARK=11;
    public static final int IDENT=6;
    public static final int NOTNEWLINE=12;
    public static final int ANYCHAR=19;
    public static final int NL=14;
    public static final int DIGIT=15;
    public static final int DOT=18;
    public static final int STRING=7;

    // delegates
    // delegators

    public setloopiterinsertsLexer() {;} 
    public setloopiterinsertsLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public setloopiterinsertsLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g"; }

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:11:7: ( 'iter' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:11:9: 'iter'
            {
            match("iter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:12:7: ( '=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:12:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:13:7: ( ',' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:14:7: ( '&&' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:14:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:15:7: ( '||' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:15:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:16:7: ( '(' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:16:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:17:7: ( ')' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:17:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:18:7: ( '==' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:18:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:19:7: ( '!=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:19:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:20:7: ( '<' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:20:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:21:7: ( '<=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:21:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:22:7: ( '>=' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:22:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:23:7: ( '>' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:23:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:24:7: ( '+' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:24:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:25:7: ( '-' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:25:9: '-'
            {
            match('-'); 

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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:26:7: ( '*' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:26:9: '*'
            {
            match('*'); 

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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:27:7: ( '/' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:27:9: '/'
            {
            match('/'); 

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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:7: ( '\\\\\"' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:9: '\\\\\"'
            {
            match("\\\""); 


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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:29:7: ( '\\\\#' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:29:9: '\\\\#'
            {
            match("\\#"); 


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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:30:7: ( '\\\\?' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:30:9: '\\\\?'
            {
            match("\\?"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "COMMANDCHAR"
    public final void mCOMMANDCHAR() throws RecognitionException {
        try {
            int _type = COMMANDCHAR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:109:12: ( '#' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:109:14: '#'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:110:14: ( '?' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:110:16: '?'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:111:14: ( '@' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:111:16: '@'
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

    // $ANTLR start "QUOTATIONMARK"
    public final void mQUOTATIONMARK() throws RecognitionException {
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:112:23: ( '\"' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:112:25: '\"'
            {
            match('\"'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "QUOTATIONMARK"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:117:5: ( '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* '\"' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:117:8: '\"' ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )* '\"'
            {
            match('\"'); 
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:118:5: ( '\\\\\"' | ~ ( '\"' | '\\n' | '\\r' ) )*
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
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:118:7: '\\\\\"'
            	    {
            	    match("\\\""); 


            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:119:7: ~ ( '\"' | '\\n' | '\\r' )
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:124:21: (~ ( '\\n' | '\\r' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:124:23: ~ ( '\\n' | '\\r' )
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:132:5: ( ( ' ' | '\\t' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:132:9: ( ' ' | '\\t' )
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:136:5: ( ( '\\r' | '\\n' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:136:9: ( '\\r' | '\\n' )
            {
            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
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
    // $ANTLR end "NL"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:142:9: ( ( DIGIT )+ )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:142:11: ( DIGIT )+
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:142:11: ( DIGIT )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:142:11: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:143:10: ( ( QUOTATIONMARK | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' | '>' | '<' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:143:12: ( QUOTATIONMARK | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' | '>' | '<' )
            {
            if ( input.LA(1)==' '||(input.LA(1)>='\"' && input.LA(1)<='#')||(input.LA(1)>='(' && input.LA(1)<='-')||input.LA(1)=='/'||input.LA(1)=='<'||(input.LA(1)>='>' && input.LA(1)<='@')||input.LA(1)=='|' ) {
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:144:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:144:19: ( 'a' .. 'z' | 'A' .. 'Z' )
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:145:16: ( '0' .. '9' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:145:18: '0' .. '9'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:146:7: ( ( LETTER | DIGIT | '_' | '.' )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:146:9: ( LETTER | DIGIT | '_' | '.' )*
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:146:9: ( LETTER | DIGIT | '_' | '.' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='.'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:
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
            	    break loop3;
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:147:13: ( '.' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:147:15: '.'
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
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:148:8: ( . )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:148:10: .
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
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:8: ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | COMMANDCHAR | EPRESSIONCHAR | REFERENCECHAR | STRING | WS | NL | INTEGER | SPECCHAR | IDENT | ANYCHAR )
        int alt4=30;
        alt4 = dfa4.predict(input);
        switch (alt4) {
            case 1 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:10: T__20
                {
                mT__20(); 

                }
                break;
            case 2 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:16: T__21
                {
                mT__21(); 

                }
                break;
            case 3 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:22: T__22
                {
                mT__22(); 

                }
                break;
            case 4 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:28: T__23
                {
                mT__23(); 

                }
                break;
            case 5 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:34: T__24
                {
                mT__24(); 

                }
                break;
            case 6 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:40: T__25
                {
                mT__25(); 

                }
                break;
            case 7 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:46: T__26
                {
                mT__26(); 

                }
                break;
            case 8 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:52: T__27
                {
                mT__27(); 

                }
                break;
            case 9 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:58: T__28
                {
                mT__28(); 

                }
                break;
            case 10 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:64: T__29
                {
                mT__29(); 

                }
                break;
            case 11 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:70: T__30
                {
                mT__30(); 

                }
                break;
            case 12 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:76: T__31
                {
                mT__31(); 

                }
                break;
            case 13 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:82: T__32
                {
                mT__32(); 

                }
                break;
            case 14 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:88: T__33
                {
                mT__33(); 

                }
                break;
            case 15 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:94: T__34
                {
                mT__34(); 

                }
                break;
            case 16 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:100: T__35
                {
                mT__35(); 

                }
                break;
            case 17 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:106: T__36
                {
                mT__36(); 

                }
                break;
            case 18 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:112: T__37
                {
                mT__37(); 

                }
                break;
            case 19 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:118: T__38
                {
                mT__38(); 

                }
                break;
            case 20 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:124: T__39
                {
                mT__39(); 

                }
                break;
            case 21 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:130: COMMANDCHAR
                {
                mCOMMANDCHAR(); 

                }
                break;
            case 22 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:142: EPRESSIONCHAR
                {
                mEPRESSIONCHAR(); 

                }
                break;
            case 23 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:156: REFERENCECHAR
                {
                mREFERENCECHAR(); 

                }
                break;
            case 24 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:170: STRING
                {
                mSTRING(); 

                }
                break;
            case 25 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:177: WS
                {
                mWS(); 

                }
                break;
            case 26 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:180: NL
                {
                mNL(); 

                }
                break;
            case 27 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:183: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 28 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:191: SPECCHAR
                {
                mSPECCHAR(); 

                }
                break;
            case 29 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:200: IDENT
                {
                mIDENT(); 

                }
                break;
            case 30 :
                // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:1:206: ANYCHAR
                {
                mANYCHAR(); 

                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\2\31\1\35\1\uffff\1\32\1\41\2\uffff\1\32\1\46\1\50\4\uffff\1\32"+
        "\3\uffff\1\41\2\uffff\1\66\4\uffff\1\31\33\uffff\1\66\1\31\1\72"+
        "\1\uffff";
    static final String DFA4_eofS =
        "\73\uffff";
    static final String DFA4_minS =
        "\1\0\1\164\1\75\1\uffff\1\46\1\174\2\uffff\3\75\4\uffff\1\42\3"+
        "\uffff\1\0\2\uffff\1\56\4\uffff\1\145\33\uffff\1\56\1\162\1\56\1"+
        "\uffff";
    static final String DFA4_maxS =
        "\1\uffff\1\164\1\75\1\uffff\1\46\1\174\2\uffff\3\75\4\uffff\1\77"+
        "\3\uffff\1\uffff\2\uffff\1\172\4\uffff\1\145\33\uffff\1\172\1\162"+
        "\1\172\1\uffff";
    static final String DFA4_acceptS =
        "\3\uffff\1\3\2\uffff\1\6\1\7\3\uffff\1\16\1\17\1\20\1\21\1\uffff"+
        "\1\25\1\26\1\27\1\uffff\1\31\1\32\1\uffff\1\31\2\35\1\36\1\uffff"+
        "\1\10\1\2\1\3\1\4\1\5\1\34\1\6\1\7\1\11\1\13\1\12\1\14\1\15\1\16"+
        "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
        "\3\uffff\1\1";
    static final String DFA4_specialS =
        "\1\0\22\uffff\1\1\47\uffff}>";
    static final String[] DFA4_transitionS = {
            "\11\32\1\27\1\25\2\32\1\25\22\32\1\24\1\10\1\23\1\20\2\32\1"+
            "\4\1\32\1\6\1\7\1\15\1\13\1\3\1\14\1\30\1\16\12\26\2\32\1\11"+
            "\1\2\1\12\1\21\1\22\32\30\1\32\1\17\2\32\1\30\1\32\10\30\1\1"+
            "\21\30\1\32\1\5\uff83\32",
            "\1\33",
            "\1\34",
            "",
            "\1\37",
            "\1\40",
            "",
            "",
            "\1\44",
            "\1\45",
            "\1\47",
            "",
            "",
            "",
            "",
            "\1\55\1\56\33\uffff\1\57",
            "",
            "",
            "",
            "\12\63\1\uffff\2\63\1\uffff\ufff2\63",
            "",
            "",
            "\1\31\1\uffff\12\67\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "",
            "",
            "",
            "",
            "\1\70",
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
            "",
            "",
            "",
            "",
            "",
            "\1\31\1\uffff\12\67\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            "\1\71",
            "\1\31\1\uffff\12\31\7\uffff\32\31\4\uffff\1\31\1\uffff\32"+
            "\31",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | COMMANDCHAR | EPRESSIONCHAR | REFERENCECHAR | STRING | WS | NL | INTEGER | SPECCHAR | IDENT | ANYCHAR );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='i') ) {s = 1;}

                        else if ( (LA4_0=='=') ) {s = 2;}

                        else if ( (LA4_0==',') ) {s = 3;}

                        else if ( (LA4_0=='&') ) {s = 4;}

                        else if ( (LA4_0=='|') ) {s = 5;}

                        else if ( (LA4_0=='(') ) {s = 6;}

                        else if ( (LA4_0==')') ) {s = 7;}

                        else if ( (LA4_0=='!') ) {s = 8;}

                        else if ( (LA4_0=='<') ) {s = 9;}

                        else if ( (LA4_0=='>') ) {s = 10;}

                        else if ( (LA4_0=='+') ) {s = 11;}

                        else if ( (LA4_0=='-') ) {s = 12;}

                        else if ( (LA4_0=='*') ) {s = 13;}

                        else if ( (LA4_0=='/') ) {s = 14;}

                        else if ( (LA4_0=='\\') ) {s = 15;}

                        else if ( (LA4_0=='#') ) {s = 16;}

                        else if ( (LA4_0=='?') ) {s = 17;}

                        else if ( (LA4_0=='@') ) {s = 18;}

                        else if ( (LA4_0=='\"') ) {s = 19;}

                        else if ( (LA4_0==' ') ) {s = 20;}

                        else if ( (LA4_0=='\n'||LA4_0=='\r') ) {s = 21;}

                        else if ( ((LA4_0>='0' && LA4_0<='9')) ) {s = 22;}

                        else if ( (LA4_0=='\t') ) {s = 23;}

                        else if ( (LA4_0=='.'||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='h')||(LA4_0>='j' && LA4_0<='z')) ) {s = 24;}

                        else if ( ((LA4_0>='\u0000' && LA4_0<='\b')||(LA4_0>='\u000B' && LA4_0<='\f')||(LA4_0>='\u000E' && LA4_0<='\u001F')||(LA4_0>='$' && LA4_0<='%')||LA4_0=='\''||(LA4_0>=':' && LA4_0<=';')||LA4_0=='['||(LA4_0>=']' && LA4_0<='^')||LA4_0=='`'||LA4_0=='{'||(LA4_0>='}' && LA4_0<='\uFFFF')) ) {s = 26;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA4_19 = input.LA(1);

                        s = -1;
                        if ( ((LA4_19>='\u0000' && LA4_19<='\t')||(LA4_19>='\u000B' && LA4_19<='\f')||(LA4_19>='\u000E' && LA4_19<='\uFFFF')) ) {s = 51;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}