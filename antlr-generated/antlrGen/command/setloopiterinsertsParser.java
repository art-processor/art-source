// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g 2017-03-28 11:47:27

  package antlrGen.command;
  
  import art.utils.Utils;
  import art.utils.SetLoopInfo;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class setloopiterinsertsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATION", "COMMANDCHAR", "IDENT", "STRING", "EPRESSIONCHAR", "REFERENCECHAR", "INTEGER", "QUOTATIONMARK", "NOTNEWLINE", "WS", "NL", "DIGIT", "SPECCHAR", "LETTER", "DOT", "ANYCHAR", "'iter'", "'='", "','", "'&&'", "'||'", "'('", "')'", "'=='", "'!='", "'<'", "'<='", "'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'\\\\\"'", "'\\\\#'", "'\\\\?'"
    };
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
    public static final int WS=13;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int NEGATION=4;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int QUOTATIONMARK=11;
    public static final int ANYCHAR=19;
    public static final int NOTNEWLINE=12;
    public static final int IDENT=6;
    public static final int DIGIT=15;
    public static final int NL=14;
    public static final int DOT=18;
    public static final int STRING=7;

    // delegates
    // delegators


        public setloopiterinsertsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public setloopiterinsertsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return setloopiterinsertsParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g"; }


    public static class evaluator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "evaluator"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:25:1: evaluator : ( ( ws | nl )* COMMANDCHAR i= iter )* EOF ;
    public final setloopiterinsertsParser.evaluator_return evaluator() throws RecognitionException {
        setloopiterinsertsParser.evaluator_return retval = new setloopiterinsertsParser.evaluator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMANDCHAR3=null;
        Token EOF4=null;
        setloopiterinsertsParser.iter_return i = null;

        setloopiterinsertsParser.ws_return ws1 = null;

        setloopiterinsertsParser.nl_return nl2 = null;


        CommonTree COMMANDCHAR3_tree=null;
        CommonTree EOF4_tree=null;

        StringBuilder sb = new StringBuilder();
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:27:3: ( ( ( ws | nl )* COMMANDCHAR i= iter )* EOF )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:3: ( ( ws | nl )* COMMANDCHAR i= iter )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:3: ( ( ws | nl )* COMMANDCHAR i= iter )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMANDCHAR||(LA2_0>=WS && LA2_0<=NL)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:5: ( ws | nl )* COMMANDCHAR i= iter
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:5: ( ws | nl )*
            	    loop1:
            	    do {
            	        int alt1=3;
            	        int LA1_0 = input.LA(1);

            	        if ( (LA1_0==WS) ) {
            	            alt1=1;
            	        }
            	        else if ( (LA1_0==NL) ) {
            	            alt1=2;
            	        }


            	        switch (alt1) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:6: ws
            	    	    {
            	    	    pushFollow(FOLLOW_ws_in_evaluator89);
            	    	    ws1=ws();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws1.getTree());

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:28:11: nl
            	    	    {
            	    	    pushFollow(FOLLOW_nl_in_evaluator93);
            	    	    nl2=nl();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nl2.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop1;
            	        }
            	    } while (true);

            	    COMMANDCHAR3=(Token)match(input,COMMANDCHAR,FOLLOW_COMMANDCHAR_in_evaluator97); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    COMMANDCHAR3_tree = (CommonTree)adaptor.create(COMMANDCHAR3);
            	    adaptor.addChild(root_0, COMMANDCHAR3_tree);
            	    }
            	    pushFollow(FOLLOW_iter_in_evaluator101);
            	    i=iter();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, i.getTree());
            	    if ( state.backtracking==0 ) {
            	      sb.append((i!=null?input.toString(i.start,i.stop):null));
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_evaluator108); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            EOF4_tree = (CommonTree)adaptor.create(EOF4);
            adaptor.addChild(root_0, EOF4_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "evaluator"

    public static class iter_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "iter"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:31:1: iter : 'iter' ( ws )* i= IDENT ( ws )* '=' ( ws )* e= expression ( ws )* ( ',' ( ws )* i1= IDENT ( ws )* '=' ( ws )* e1= expression ( ws )* )* ( ws | nl )* ;
    public final setloopiterinsertsParser.iter_return iter() throws RecognitionException {
        setloopiterinsertsParser.iter_return retval = new setloopiterinsertsParser.iter_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token i1=null;
        Token string_literal5=null;
        Token char_literal8=null;
        Token char_literal11=null;
        Token char_literal14=null;
        setloopiterinsertsParser.expression_return e = null;

        setloopiterinsertsParser.expression_return e1 = null;

        setloopiterinsertsParser.ws_return ws6 = null;

        setloopiterinsertsParser.ws_return ws7 = null;

        setloopiterinsertsParser.ws_return ws9 = null;

        setloopiterinsertsParser.ws_return ws10 = null;

        setloopiterinsertsParser.ws_return ws12 = null;

        setloopiterinsertsParser.ws_return ws13 = null;

        setloopiterinsertsParser.ws_return ws15 = null;

        setloopiterinsertsParser.ws_return ws16 = null;

        setloopiterinsertsParser.ws_return ws17 = null;

        setloopiterinsertsParser.nl_return nl18 = null;


        CommonTree i_tree=null;
        CommonTree i1_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree char_literal8_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal14_tree=null;

        Map<String, String> iterVars = new HashMap<String,String>();
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:3: ( 'iter' ( ws )* i= IDENT ( ws )* '=' ( ws )* e= expression ( ws )* ( ',' ( ws )* i1= IDENT ( ws )* '=' ( ws )* e1= expression ( ws )* )* ( ws | nl )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:5: 'iter' ( ws )* i= IDENT ( ws )* '=' ( ws )* e= expression ( ws )* ( ',' ( ws )* i1= IDENT ( ws )* '=' ( ws )* e1= expression ( ws )* )* ( ws | nl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal5=(Token)match(input,20,FOLLOW_20_in_iter127); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal5_tree = (CommonTree)adaptor.create(string_literal5);
            adaptor.addChild(root_0, string_literal5_tree);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:12: ( ws )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_iter129);
            	    ws6=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws6.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_iter134); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            adaptor.addChild(root_0, i_tree);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:24: ( ws )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==WS) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_iter136);
            	    ws7=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws7.getTree());

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            char_literal8=(Token)match(input,21,FOLLOW_21_in_iter139); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            char_literal8_tree = (CommonTree)adaptor.create(char_literal8);
            adaptor.addChild(root_0, char_literal8_tree);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:32: ( ws )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==WS) ) {
                    int LA5_2 = input.LA(2);

                    if ( (synpred6_setloopiterinserts()) ) {
                        alt5=1;
                    }


                }


                switch (alt5) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_iter141);
            	    ws9=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws9.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            pushFollow(FOLLOW_expression_in_iter146);
            e=expression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:49: ( ws )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==WS) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred7_setloopiterinserts()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_iter148);
            	    ws10=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws10.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               if (Utils.canWrite()){ iterVars.put((i!=null?i.getText():null), (e!=null?input.toString(e.start,e.stop):null));} 
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:3: ( ',' ( ws )* i1= IDENT ( ws )* '=' ( ws )* e1= expression ( ws )* )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==22) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:4: ',' ( ws )* i1= IDENT ( ws )* '=' ( ws )* e1= expression ( ws )*
            	    {
            	    char_literal11=(Token)match(input,22,FOLLOW_22_in_iter157); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal11_tree = (CommonTree)adaptor.create(char_literal11);
            	    adaptor.addChild(root_0, char_literal11_tree);
            	    }
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:8: ( ws )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==WS) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    	    {
            	    	    pushFollow(FOLLOW_ws_in_iter159);
            	    	    ws12=ws();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws12.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);

            	    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_iter164); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    i1_tree = (CommonTree)adaptor.create(i1);
            	    adaptor.addChild(root_0, i1_tree);
            	    }
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:21: ( ws )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==WS) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    	    {
            	    	    pushFollow(FOLLOW_ws_in_iter166);
            	    	    ws13=ws();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws13.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);

            	    char_literal14=(Token)match(input,21,FOLLOW_21_in_iter169); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal14_tree = (CommonTree)adaptor.create(char_literal14);
            	    adaptor.addChild(root_0, char_literal14_tree);
            	    }
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:29: ( ws )*
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==WS) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( (synpred10_setloopiterinserts()) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    	    {
            	    	    pushFollow(FOLLOW_ws_in_iter171);
            	    	    ws15=ws();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws15.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);

            	    pushFollow(FOLLOW_expression_in_iter176);
            	    e1=expression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, e1.getTree());
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:47: ( ws )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==WS) ) {
            	            int LA10_1 = input.LA(2);

            	            if ( (synpred11_setloopiterinserts()) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    	    {
            	    	    pushFollow(FOLLOW_ws_in_iter178);
            	    	    ws16=ws();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws16.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);

            	    if ( state.backtracking==0 ) {
            	       if (Utils.canWrite()){ iterVars.put((i1!=null?i1.getText():null), (e1!=null?input.toString(e1.start,e1.stop):null));} 
            	    }

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:116: ( ws | nl )*
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==WS) ) {
                    int LA12_2 = input.LA(2);

                    if ( (synpred13_setloopiterinserts()) ) {
                        alt12=1;
                    }


                }
                else if ( (LA12_0==NL) ) {
                    int LA12_3 = input.LA(2);

                    if ( (synpred14_setloopiterinserts()) ) {
                        alt12=2;
                    }


                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:117: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_iter187);
            	    ws17=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws17.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:122: nl
            	    {
            	    pushFollow(FOLLOW_nl_in_iter191);
            	    nl18=nl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nl18.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {

                      if (Utils.canWrite())
                      { 
                          SetLoopInfo.addIter(iterVars);
                      } 
                  
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "iter"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:46:1: expression : ( freeExpression | stringExpression );
    public final setloopiterinsertsParser.expression_return expression() throws RecognitionException {
        setloopiterinsertsParser.expression_return retval = new setloopiterinsertsParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        setloopiterinsertsParser.freeExpression_return freeExpression19 = null;

        setloopiterinsertsParser.stringExpression_return stringExpression20 = null;



        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:47:3: ( freeExpression | stringExpression )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==IDENT||LA13_0==INTEGER||LA13_0==WS||LA13_0==25||(LA13_0>=33 && LA13_0<=34)) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=STRING && LA13_0<=EPRESSIONCHAR)) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:47:5: freeExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_freeExpression_in_expression217);
                    freeExpression19=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression19.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:48:5: stringExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_stringExpression_in_expression223);
                    stringExpression20=stringExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stringExpression20.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class stringExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "stringExpression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:51:1: stringExpression : ( nameExpression | STRING )+ ;
    public final setloopiterinsertsParser.stringExpression_return stringExpression() throws RecognitionException {
        setloopiterinsertsParser.stringExpression_return retval = new setloopiterinsertsParser.stringExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING22=null;
        setloopiterinsertsParser.nameExpression_return nameExpression21 = null;


        CommonTree STRING22_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:52:3: ( ( nameExpression | STRING )+ )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:52:5: ( nameExpression | STRING )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:52:5: ( nameExpression | STRING )+
            int cnt14=0;
            loop14:
            do {
                int alt14=3;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==EPRESSIONCHAR) ) {
                    alt14=1;
                }
                else if ( (LA14_0==STRING) ) {
                    alt14=2;
                }


                switch (alt14) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:52:6: nameExpression
            	    {
            	    pushFollow(FOLLOW_nameExpression_in_stringExpression239);
            	    nameExpression21=nameExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameExpression21.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:52:23: STRING
            	    {
            	    STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_stringExpression243); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    STRING22_tree = (CommonTree)adaptor.create(STRING22);
            	    adaptor.addChild(root_0, STRING22_tree);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stringExpression"

    public static class nameExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameExpression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:55:1: nameExpression : ( EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR | EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+ );
    public final setloopiterinsertsParser.nameExpression_return nameExpression() throws RecognitionException {
        setloopiterinsertsParser.nameExpression_return retval = new setloopiterinsertsParser.nameExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EPRESSIONCHAR23=null;
        Token EPRESSIONCHAR27=null;
        Token EPRESSIONCHAR28=null;
        Token EPRESSIONCHAR32=null;
        setloopiterinsertsParser.ws_return ws24 = null;

        setloopiterinsertsParser.simpleExpr_return simpleExpr25 = null;

        setloopiterinsertsParser.ws_return ws26 = null;

        setloopiterinsertsParser.ws_return ws29 = null;

        setloopiterinsertsParser.freeExpression_return freeExpression30 = null;

        setloopiterinsertsParser.ws_return ws31 = null;


        CommonTree EPRESSIONCHAR23_tree=null;
        CommonTree EPRESSIONCHAR27_tree=null;
        CommonTree EPRESSIONCHAR28_tree=null;
        CommonTree EPRESSIONCHAR32_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:56:3: ( EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR | EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+ )
            int alt20=2;
            alt20 = dfa20.predict(input);
            switch (alt20) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:56:5: EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EPRESSIONCHAR23=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression260); if (state.failed) return retval;
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:56:22: ( ws )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==WS) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression263);
                    	    ws24=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    pushFollow(FOLLOW_simpleExpr_in_nameExpression267);
                    simpleExpr25=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr25.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:56:38: ( ws )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==WS) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression269);
                    	    ws26=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    EPRESSIONCHAR27=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression273); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:57:5: EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EPRESSIONCHAR28=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression280); if (state.failed) return retval;
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:57:22: ( ws )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==WS) ) {
                            int LA17_2 = input.LA(2);

                            if ( (synpred21_setloopiterinserts()) ) {
                                alt17=1;
                            }


                        }


                        switch (alt17) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression283);
                    	    ws29=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);

                    pushFollow(FOLLOW_freeExpression_in_nameExpression287);
                    freeExpression30=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression30.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:57:42: ( ws )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==WS) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression289);
                    	    ws31=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:57:58: ( EPRESSIONCHAR )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        alt19 = dfa19.predict(input);
                        switch (alt19) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: EPRESSIONCHAR
                    	    {
                    	    EPRESSIONCHAR32=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression293); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nameExpression"

    public static class simpleExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "simpleExpr"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:61:1: simpleExpr : REFERENCECHAR ( nameExprTerm )* ;
    public final setloopiterinsertsParser.simpleExpr_return simpleExpr() throws RecognitionException {
        setloopiterinsertsParser.simpleExpr_return retval = new setloopiterinsertsParser.simpleExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REFERENCECHAR33=null;
        setloopiterinsertsParser.nameExprTerm_return nameExprTerm34 = null;


        CommonTree REFERENCECHAR33_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:62:3: ( REFERENCECHAR ( nameExprTerm )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:62:5: REFERENCECHAR ( nameExprTerm )*
            {
            root_0 = (CommonTree)adaptor.nil();

            REFERENCECHAR33=(Token)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_simpleExpr313); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REFERENCECHAR33_tree = (CommonTree)adaptor.create(REFERENCECHAR33);
            root_0 = (CommonTree)adaptor.becomeRoot(REFERENCECHAR33_tree, root_0);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:62:20: ( nameExprTerm )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IDENT) ) {
                    int LA21_3 = input.LA(2);

                    if ( (synpred24_setloopiterinserts()) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==REFERENCECHAR) ) {
                    int LA21_4 = input.LA(2);

                    if ( (synpred24_setloopiterinserts()) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: nameExprTerm
            	    {
            	    pushFollow(FOLLOW_nameExprTerm_in_simpleExpr316);
            	    nameExprTerm34=nameExprTerm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameExprTerm34.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "simpleExpr"

    public static class nameExprTerm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nameExprTerm"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:65:1: nameExprTerm : ( IDENT | REFERENCECHAR simpleExpr | simpleExpr ) ;
    public final setloopiterinsertsParser.nameExprTerm_return nameExprTerm() throws RecognitionException {
        setloopiterinsertsParser.nameExprTerm_return retval = new setloopiterinsertsParser.nameExprTerm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT35=null;
        Token REFERENCECHAR36=null;
        setloopiterinsertsParser.simpleExpr_return simpleExpr37 = null;

        setloopiterinsertsParser.simpleExpr_return simpleExpr38 = null;


        CommonTree IDENT35_tree=null;
        CommonTree REFERENCECHAR36_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:66:3: ( ( IDENT | REFERENCECHAR simpleExpr | simpleExpr ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:66:5: ( IDENT | REFERENCECHAR simpleExpr | simpleExpr )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:66:5: ( IDENT | REFERENCECHAR simpleExpr | simpleExpr )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDENT) ) {
                alt22=1;
            }
            else if ( (LA22_0==REFERENCECHAR) ) {
                int LA22_2 = input.LA(2);

                if ( (LA22_2==EOF||LA22_2==IDENT||LA22_2==EPRESSIONCHAR||LA22_2==WS) ) {
                    alt22=3;
                }
                else if ( (LA22_2==REFERENCECHAR) ) {
                    int LA22_4 = input.LA(3);

                    if ( (synpred26_setloopiterinserts()) ) {
                        alt22=2;
                    }
                    else if ( (true) ) {
                        alt22=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:66:6: IDENT
                    {
                    IDENT35=(Token)match(input,IDENT,FOLLOW_IDENT_in_nameExprTerm334); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT35_tree = (CommonTree)adaptor.create(IDENT35);
                    adaptor.addChild(root_0, IDENT35_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:67:5: REFERENCECHAR simpleExpr
                    {
                    REFERENCECHAR36=(Token)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_nameExprTerm340); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REFERENCECHAR36_tree = (CommonTree)adaptor.create(REFERENCECHAR36);
                    root_0 = (CommonTree)adaptor.becomeRoot(REFERENCECHAR36_tree, root_0);
                    }
                    pushFollow(FOLLOW_simpleExpr_in_nameExprTerm343);
                    simpleExpr37=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr37.getTree());

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:68:5: simpleExpr
                    {
                    pushFollow(FOLLOW_simpleExpr_in_nameExprTerm349);
                    simpleExpr38=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr38.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nameExprTerm"

    public static class freeExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "freeExpression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:72:1: freeExpression : relation ( ( '&&' | '||' ) relation )* ;
    public final setloopiterinsertsParser.freeExpression_return freeExpression() throws RecognitionException {
        setloopiterinsertsParser.freeExpression_return retval = new setloopiterinsertsParser.freeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal40=null;
        Token string_literal41=null;
        setloopiterinsertsParser.relation_return relation39 = null;

        setloopiterinsertsParser.relation_return relation42 = null;


        CommonTree string_literal40_tree=null;
        CommonTree string_literal41_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:3: ( relation ( ( '&&' | '||' ) relation )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:5: relation ( ( '&&' | '||' ) relation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relation_in_freeExpression366);
            relation39=relation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relation39.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:14: ( ( '&&' | '||' ) relation )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=23 && LA24_0<=24)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:15: ( '&&' | '||' ) relation
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:15: ( '&&' | '||' )
            	    int alt23=2;
            	    int LA23_0 = input.LA(1);

            	    if ( (LA23_0==23) ) {
            	        alt23=1;
            	    }
            	    else if ( (LA23_0==24) ) {
            	        alt23=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 23, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt23) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:16: '&&'
            	            {
            	            string_literal40=(Token)match(input,23,FOLLOW_23_in_freeExpression370); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal40_tree = (CommonTree)adaptor.create(string_literal40);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal40_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:73:24: '||'
            	            {
            	            string_literal41=(Token)match(input,24,FOLLOW_24_in_freeExpression375); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal41_tree = (CommonTree)adaptor.create(string_literal41);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal41_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relation_in_freeExpression379);
            	    relation42=relation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relation42.getTree());

            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "freeExpression"

    public static class arithmeticTerm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arithmeticTerm"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:80:1: arithmeticTerm : ( ws )* ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER ) ( ws )* ;
    public final setloopiterinsertsParser.arithmeticTerm_return arithmeticTerm() throws RecognitionException {
        setloopiterinsertsParser.arithmeticTerm_return retval = new setloopiterinsertsParser.arithmeticTerm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT44=null;
        Token char_literal45=null;
        Token char_literal49=null;
        Token INTEGER50=null;
        setloopiterinsertsParser.ws_return ws43 = null;

        setloopiterinsertsParser.ws_return ws46 = null;

        setloopiterinsertsParser.freeExpression_return freeExpression47 = null;

        setloopiterinsertsParser.ws_return ws48 = null;

        setloopiterinsertsParser.ws_return ws51 = null;


        CommonTree IDENT44_tree=null;
        CommonTree char_literal45_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree INTEGER50_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:81:5: ( ( ws )* ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER ) ( ws )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:81:7: ( ws )* ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER ) ( ws )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:81:7: ( ws )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==WS) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_arithmeticTerm400);
            	    ws43=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws43.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:81:11: ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER )
            int alt28=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt28=1;
                }
                break;
            case 25:
                {
                alt28=2;
                }
                break;
            case INTEGER:
                {
                alt28=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }

            switch (alt28) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:81:12: IDENT
                    {
                    IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_arithmeticTerm404); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT44_tree = (CommonTree)adaptor.create(IDENT44);
                    adaptor.addChild(root_0, IDENT44_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:82:7: '(' ( ws )* freeExpression ( ws )* ')'
                    {
                    char_literal45=(Token)match(input,25,FOLLOW_25_in_arithmeticTerm412); if (state.failed) return retval;
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:82:14: ( ws )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==WS) ) {
                            int LA26_2 = input.LA(2);

                            if ( (synpred31_setloopiterinserts()) ) {
                                alt26=1;
                            }


                        }


                        switch (alt26) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_arithmeticTerm415);
                    	    ws46=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    pushFollow(FOLLOW_freeExpression_in_arithmeticTerm419);
                    freeExpression47=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression47.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:82:34: ( ws )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==WS) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_arithmeticTerm421);
                    	    ws48=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    char_literal49=(Token)match(input,26,FOLLOW_26_in_arithmeticTerm425); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:83:7: INTEGER
                    {
                    INTEGER50=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arithmeticTerm434); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER50_tree = (CommonTree)adaptor.create(INTEGER50);
                    adaptor.addChild(root_0, INTEGER50_tree);
                    }

                    }
                    break;

            }

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:83:16: ( ws )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==WS) ) {
                    int LA29_2 = input.LA(2);

                    if ( (synpred34_setloopiterinserts()) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_arithmeticTerm437);
            	    ws51=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws51.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arithmeticTerm"

    public static class relation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:86:1: relation : add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* ;
    public final setloopiterinsertsParser.relation_return relation() throws RecognitionException {
        setloopiterinsertsParser.relation_return retval = new setloopiterinsertsParser.relation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal53=null;
        Token string_literal54=null;
        Token char_literal55=null;
        Token string_literal56=null;
        Token string_literal57=null;
        Token char_literal58=null;
        setloopiterinsertsParser.add_return add52 = null;

        setloopiterinsertsParser.add_return add59 = null;


        CommonTree string_literal53_tree=null;
        CommonTree string_literal54_tree=null;
        CommonTree char_literal55_tree=null;
        CommonTree string_literal56_tree=null;
        CommonTree string_literal57_tree=null;
        CommonTree char_literal58_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:3: ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:5: add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_add_in_relation459);
            add52=add();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add52.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:9: ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=27 && LA31_0<=32)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:10: ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:10: ( '==' | '!=' | '<' | '<=' | '>=' | '>' )
            	    int alt30=6;
            	    switch ( input.LA(1) ) {
            	    case 27:
            	        {
            	        alt30=1;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt30=2;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt30=3;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt30=4;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt30=5;
            	        }
            	        break;
            	    case 32:
            	        {
            	        alt30=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt30) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:11: '=='
            	            {
            	            string_literal53=(Token)match(input,27,FOLLOW_27_in_relation463); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal53_tree = (CommonTree)adaptor.create(string_literal53);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal53_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:19: '!='
            	            {
            	            string_literal54=(Token)match(input,28,FOLLOW_28_in_relation468); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal54_tree = (CommonTree)adaptor.create(string_literal54);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal54_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:27: '<'
            	            {
            	            char_literal55=(Token)match(input,29,FOLLOW_29_in_relation473); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal55_tree = (CommonTree)adaptor.create(char_literal55);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal55_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:34: '<='
            	            {
            	            string_literal56=(Token)match(input,30,FOLLOW_30_in_relation478); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal56_tree = (CommonTree)adaptor.create(string_literal56);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal56_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:42: '>='
            	            {
            	            string_literal57=(Token)match(input,31,FOLLOW_31_in_relation483); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal57_tree = (CommonTree)adaptor.create(string_literal57);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal57_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:87:50: '>'
            	            {
            	            char_literal58=(Token)match(input,32,FOLLOW_32_in_relation488); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal58_tree = (CommonTree)adaptor.create(char_literal58);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal58_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_in_relation492);
            	    add59=add();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add59.getTree());

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "relation"

    public static class add_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "add"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:90:1: add : mult ( ( '+' | '-' ) mult )* ;
    public final setloopiterinsertsParser.add_return add() throws RecognitionException {
        setloopiterinsertsParser.add_return retval = new setloopiterinsertsParser.add_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal61=null;
        Token char_literal62=null;
        setloopiterinsertsParser.mult_return mult60 = null;

        setloopiterinsertsParser.mult_return mult63 = null;


        CommonTree char_literal61_tree=null;
        CommonTree char_literal62_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:3: ( mult ( ( '+' | '-' ) mult )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:5: mult ( ( '+' | '-' ) mult )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mult_in_add507);
            mult60=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult60.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:10: ( ( '+' | '-' ) mult )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=33 && LA33_0<=34)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:11: ( '+' | '-' ) mult
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:11: ( '+' | '-' )
            	    int alt32=2;
            	    int LA32_0 = input.LA(1);

            	    if ( (LA32_0==33) ) {
            	        alt32=1;
            	    }
            	    else if ( (LA32_0==34) ) {
            	        alt32=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 32, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt32) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:12: '+'
            	            {
            	            char_literal61=(Token)match(input,33,FOLLOW_33_in_add511); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal61_tree = (CommonTree)adaptor.create(char_literal61);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal61_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:91:19: '-'
            	            {
            	            char_literal62=(Token)match(input,34,FOLLOW_34_in_add516); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal62_tree = (CommonTree)adaptor.create(char_literal62);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal62_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_add520);
            	    mult63=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult63.getTree());

            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "add"

    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mult"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:94:1: mult : unary ( ( '*' | '/' ) unary )* ;
    public final setloopiterinsertsParser.mult_return mult() throws RecognitionException {
        setloopiterinsertsParser.mult_return retval = new setloopiterinsertsParser.mult_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal65=null;
        Token char_literal66=null;
        setloopiterinsertsParser.unary_return unary64 = null;

        setloopiterinsertsParser.unary_return unary67 = null;


        CommonTree char_literal65_tree=null;
        CommonTree char_literal66_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:3: ( unary ( ( '*' | '/' ) unary )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:5: unary ( ( '*' | '/' ) unary )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unary_in_mult537);
            unary64=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary64.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:11: ( ( '*' | '/' ) unary )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( ((LA35_0>=35 && LA35_0<=36)) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:12: ( '*' | '/' ) unary
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:12: ( '*' | '/' )
            	    int alt34=2;
            	    int LA34_0 = input.LA(1);

            	    if ( (LA34_0==35) ) {
            	        alt34=1;
            	    }
            	    else if ( (LA34_0==36) ) {
            	        alt34=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 34, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt34) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:13: '*'
            	            {
            	            char_literal65=(Token)match(input,35,FOLLOW_35_in_mult541); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal65_tree = (CommonTree)adaptor.create(char_literal65);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal65_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:95:20: '/'
            	            {
            	            char_literal66=(Token)match(input,36,FOLLOW_36_in_mult546); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal66_tree = (CommonTree)adaptor.create(char_literal66);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal66_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult550);
            	    unary67=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary67.getTree());

            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mult"

    public static class unary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:98:1: unary : ( '+' | negation )* arithmeticTerm ;
    public final setloopiterinsertsParser.unary_return unary() throws RecognitionException {
        setloopiterinsertsParser.unary_return retval = new setloopiterinsertsParser.unary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal68=null;
        setloopiterinsertsParser.negation_return negation69 = null;

        setloopiterinsertsParser.arithmeticTerm_return arithmeticTerm70 = null;


        CommonTree char_literal68_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:99:3: ( ( '+' | negation )* arithmeticTerm )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:99:5: ( '+' | negation )* arithmeticTerm
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:99:5: ( '+' | negation )*
            loop36:
            do {
                int alt36=3;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==33) ) {
                    alt36=1;
                }
                else if ( (LA36_0==34) ) {
                    alt36=2;
                }


                switch (alt36) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:99:6: '+'
            	    {
            	    char_literal68=(Token)match(input,33,FOLLOW_33_in_unary568); if (state.failed) return retval;

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:99:13: negation
            	    {
            	    pushFollow(FOLLOW_negation_in_unary573);
            	    negation69=negation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(negation69.getTree(), root_0);

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            pushFollow(FOLLOW_arithmeticTerm_in_unary578);
            arithmeticTerm70=arithmeticTerm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm70.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "unary"

    public static class negation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "negation"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:102:1: negation : '-' -> NEGATION ;
    public final setloopiterinsertsParser.negation_return negation() throws RecognitionException {
        setloopiterinsertsParser.negation_return retval = new setloopiterinsertsParser.negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal71=null;

        CommonTree char_literal71_tree=null;
        RewriteRuleTokenStream stream_34=new RewriteRuleTokenStream(adaptor,"token 34");

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:103:3: ( '-' -> NEGATION )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:103:5: '-'
            {
            char_literal71=(Token)match(input,34,FOLLOW_34_in_negation593); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_34.add(char_literal71);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 103:9: -> NEGATION
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(NEGATION, "NEGATION"));

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "negation"

    public static class ee_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ee"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:126:1: ee : ~ ( '#' | '?' ) ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' ) ;
    public final setloopiterinsertsParser.ee_return ee() throws RecognitionException {
        setloopiterinsertsParser.ee_return retval = new setloopiterinsertsParser.ee_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set72=null;
        Token NOTNEWLINE73=null;
        Token WS74=null;
        Token string_literal75=null;
        Token string_literal76=null;
        Token string_literal77=null;

        CommonTree set72_tree=null;
        CommonTree NOTNEWLINE73_tree=null;
        CommonTree WS74_tree=null;
        CommonTree string_literal75_tree=null;
        CommonTree string_literal76_tree=null;
        CommonTree string_literal77_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:3: (~ ( '#' | '?' ) ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:5: ~ ( '#' | '?' ) ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' )
            {
            root_0 = (CommonTree)adaptor.nil();

            set72=(Token)input.LT(1);
            if ( input.LA(1)==NEGATION||(input.LA(1)>=IDENT && input.LA(1)<=STRING)||(input.LA(1)>=REFERENCECHAR && input.LA(1)<=39) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set72));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:16: ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' )
            int alt38=5;
            switch ( input.LA(1) ) {
            case NOTNEWLINE:
                {
                alt38=1;
                }
                break;
            case EOF:
            case WS:
                {
                alt38=2;
                }
                break;
            case 37:
                {
                alt38=3;
                }
                break;
            case 38:
                {
                alt38=4;
                }
                break;
            case 39:
                {
                alt38=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:17: NOTNEWLINE
                    {
                    NOTNEWLINE73=(Token)match(input,NOTNEWLINE,FOLLOW_NOTNEWLINE_in_ee730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOTNEWLINE73_tree = (CommonTree)adaptor.create(NOTNEWLINE73);
                    adaptor.addChild(root_0, NOTNEWLINE73_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:30: ( WS )*
                    {
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:30: ( WS )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==WS) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:0:0: WS
                    	    {
                    	    WS74=(Token)match(input,WS,FOLLOW_WS_in_ee734); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    WS74_tree = (CommonTree)adaptor.create(WS74);
                    	    adaptor.addChild(root_0, WS74_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:36: '\\\\\"'
                    {
                    string_literal75=(Token)match(input,37,FOLLOW_37_in_ee739); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal75_tree = (CommonTree)adaptor.create(string_literal75);
                    adaptor.addChild(root_0, string_literal75_tree);
                    }

                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:44: '\\\\#'
                    {
                    string_literal76=(Token)match(input,38,FOLLOW_38_in_ee743); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal76_tree = (CommonTree)adaptor.create(string_literal76);
                    adaptor.addChild(root_0, string_literal76_tree);
                    }

                    }
                    break;
                case 5 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:127:52: '\\\\?'
                    {
                    string_literal77=(Token)match(input,39,FOLLOW_39_in_ee747); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal77_tree = (CommonTree)adaptor.create(string_literal77);
                    adaptor.addChild(root_0, string_literal77_tree);
                    }

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ee"

    public static class ws_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ws"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:139:1: ws : WS ;
    public final setloopiterinsertsParser.ws_return ws() throws RecognitionException {
        setloopiterinsertsParser.ws_return retval = new setloopiterinsertsParser.ws_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS78=null;

        CommonTree WS78_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:139:3: ( WS )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:139:5: WS
            {
            root_0 = (CommonTree)adaptor.nil();

            WS78=(Token)match(input,WS,FOLLOW_WS_in_ws820); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WS78_tree = (CommonTree)adaptor.create(WS78);
            adaptor.addChild(root_0, WS78_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ws"

    public static class nl_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "nl"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:140:1: nl : NL ;
    public final setloopiterinsertsParser.nl_return nl() throws RecognitionException {
        setloopiterinsertsParser.nl_return retval = new setloopiterinsertsParser.nl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NL79=null;

        CommonTree NL79_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:140:3: ( NL )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:140:5: NL
            {
            root_0 = (CommonTree)adaptor.nil();

            NL79=(Token)match(input,NL,FOLLOW_NL_in_nl826); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NL79_tree = (CommonTree)adaptor.create(NL79);
            adaptor.addChild(root_0, NL79_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "nl"

    // $ANTLR start synpred6_setloopiterinserts
    public final void synpred6_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:32: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:32: ws
        {
        pushFollow(FOLLOW_ws_in_synpred6_setloopiterinserts141);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_setloopiterinserts

    // $ANTLR start synpred7_setloopiterinserts
    public final void synpred7_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:49: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:33:49: ws
        {
        pushFollow(FOLLOW_ws_in_synpred7_setloopiterinserts148);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_setloopiterinserts

    // $ANTLR start synpred10_setloopiterinserts
    public final void synpred10_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:29: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:29: ws
        {
        pushFollow(FOLLOW_ws_in_synpred10_setloopiterinserts171);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_setloopiterinserts

    // $ANTLR start synpred11_setloopiterinserts
    public final void synpred11_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:47: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:47: ws
        {
        pushFollow(FOLLOW_ws_in_synpred11_setloopiterinserts178);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_setloopiterinserts

    // $ANTLR start synpred13_setloopiterinserts
    public final void synpred13_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:117: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:117: ws
        {
        pushFollow(FOLLOW_ws_in_synpred13_setloopiterinserts187);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_setloopiterinserts

    // $ANTLR start synpred14_setloopiterinserts
    public final void synpred14_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:122: ( nl )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:34:122: nl
        {
        pushFollow(FOLLOW_nl_in_synpred14_setloopiterinserts191);
        nl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred14_setloopiterinserts

    // $ANTLR start synpred21_setloopiterinserts
    public final void synpred21_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:57:20: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:57:20: ws
        {
        pushFollow(FOLLOW_ws_in_synpred21_setloopiterinserts283);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred21_setloopiterinserts

    // $ANTLR start synpred24_setloopiterinserts
    public final void synpred24_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:62:20: ( nameExprTerm )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:62:20: nameExprTerm
        {
        pushFollow(FOLLOW_nameExprTerm_in_synpred24_setloopiterinserts316);
        nameExprTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred24_setloopiterinserts

    // $ANTLR start synpred26_setloopiterinserts
    public final void synpred26_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:67:5: ( REFERENCECHAR simpleExpr )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:67:5: REFERENCECHAR simpleExpr
        {
        match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_synpred26_setloopiterinserts340); if (state.failed) return ;
        pushFollow(FOLLOW_simpleExpr_in_synpred26_setloopiterinserts343);
        simpleExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred26_setloopiterinserts

    // $ANTLR start synpred31_setloopiterinserts
    public final void synpred31_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:82:12: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:82:12: ws
        {
        pushFollow(FOLLOW_ws_in_synpred31_setloopiterinserts415);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred31_setloopiterinserts

    // $ANTLR start synpred34_setloopiterinserts
    public final void synpred34_setloopiterinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:83:16: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopiterinserts.g:83:16: ws
        {
        pushFollow(FOLLOW_ws_in_synpred34_setloopiterinserts437);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred34_setloopiterinserts

    // Delegated rules

    public final boolean synpred31_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred31_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred26_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred26_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred21_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred21_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred24_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred24_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred11_setloopiterinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_setloopiterinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA20 dfa20 = new DFA20(this);
    protected DFA19 dfa19 = new DFA19(this);
    static final String DFA20_eotS =
        "\5\uffff";
    static final String DFA20_eofS =
        "\5\uffff";
    static final String DFA20_minS =
        "\1\10\2\6\2\uffff";
    static final String DFA20_maxS =
        "\1\10\2\42\2\uffff";
    static final String DFA20_acceptS =
        "\3\uffff\1\2\1\1";
    static final String DFA20_specialS =
        "\5\uffff}>";
    static final String[] DFA20_transitionS = {
            "\1\1",
            "\1\3\2\uffff\1\4\1\3\2\uffff\1\2\13\uffff\1\3\7\uffff\2\3",
            "\1\3\2\uffff\1\4\1\3\2\uffff\1\2\13\uffff\1\3\7\uffff\2\3",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "55:1: nameExpression : ( EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR | EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+ );";
        }
    }
    static final String DFA19_eotS =
        "\5\uffff";
    static final String DFA19_eofS =
        "\1\1\1\uffff\2\4\1\uffff";
    static final String DFA19_minS =
        "\1\5\1\uffff\2\5\1\uffff";
    static final String DFA19_maxS =
        "\1\26\1\uffff\2\42\1\uffff";
    static final String DFA19_acceptS =
        "\1\uffff\1\2\2\uffff\1\1";
    static final String DFA19_specialS =
        "\5\uffff}>";
    static final String[] DFA19_transitionS = {
            "\1\1\1\uffff\1\1\1\2\4\uffff\2\1\7\uffff\1\1",
            "",
            "\1\4\1\1\2\4\2\1\2\uffff\1\3\1\4\7\uffff\1\4\2\uffff\1\1\7"+
            "\uffff\2\1",
            "\1\4\1\1\2\uffff\2\1\2\uffff\1\3\1\4\7\uffff\1\4\2\uffff\1"+
            "\1\7\uffff\2\1",
            ""
    };

    static final short[] DFA19_eot = DFA.unpackEncodedString(DFA19_eotS);
    static final short[] DFA19_eof = DFA.unpackEncodedString(DFA19_eofS);
    static final char[] DFA19_min = DFA.unpackEncodedStringToUnsignedChars(DFA19_minS);
    static final char[] DFA19_max = DFA.unpackEncodedStringToUnsignedChars(DFA19_maxS);
    static final short[] DFA19_accept = DFA.unpackEncodedString(DFA19_acceptS);
    static final short[] DFA19_special = DFA.unpackEncodedString(DFA19_specialS);
    static final short[][] DFA19_transition;

    static {
        int numStates = DFA19_transitionS.length;
        DFA19_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA19_transition[i] = DFA.unpackEncodedString(DFA19_transitionS[i]);
        }
    }

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = DFA19_eot;
            this.eof = DFA19_eof;
            this.min = DFA19_min;
            this.max = DFA19_max;
            this.accept = DFA19_accept;
            this.special = DFA19_special;
            this.transition = DFA19_transition;
        }
        public String getDescription() {
            return "()+ loopback of 57:58: ( EPRESSIONCHAR )+";
        }
    }
 

    public static final BitSet FOLLOW_ws_in_evaluator89 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_nl_in_evaluator93 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_COMMANDCHAR_in_evaluator97 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_iter_in_evaluator101 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_EOF_in_evaluator108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_iter127 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_ws_in_iter129 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_IDENT_in_iter134 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_ws_in_iter136 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_21_in_iter139 = new BitSet(new long[]{0x00000006020025C0L});
    public static final BitSet FOLLOW_ws_in_iter141 = new BitSet(new long[]{0x00000006020025C0L});
    public static final BitSet FOLLOW_expression_in_iter146 = new BitSet(new long[]{0x0000000000406022L});
    public static final BitSet FOLLOW_ws_in_iter148 = new BitSet(new long[]{0x0000000000406022L});
    public static final BitSet FOLLOW_22_in_iter157 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_ws_in_iter159 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_IDENT_in_iter164 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_ws_in_iter166 = new BitSet(new long[]{0x0000000000202000L});
    public static final BitSet FOLLOW_21_in_iter169 = new BitSet(new long[]{0x00000006020025C0L});
    public static final BitSet FOLLOW_ws_in_iter171 = new BitSet(new long[]{0x00000006020025C0L});
    public static final BitSet FOLLOW_expression_in_iter176 = new BitSet(new long[]{0x0000000000406022L});
    public static final BitSet FOLLOW_ws_in_iter178 = new BitSet(new long[]{0x0000000000406022L});
    public static final BitSet FOLLOW_ws_in_iter187 = new BitSet(new long[]{0x0000000000006022L});
    public static final BitSet FOLLOW_nl_in_iter191 = new BitSet(new long[]{0x0000000000006022L});
    public static final BitSet FOLLOW_freeExpression_in_expression217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_expression223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameExpression_in_stringExpression239 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_STRING_in_stringExpression243 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression260 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_ws_in_nameExpression263 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExpression267 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_ws_in_nameExpression269 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression280 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_ws_in_nameExpression283 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_freeExpression_in_nameExpression287 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_ws_in_nameExpression289 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression293 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_simpleExpr313 = new BitSet(new long[]{0x0000000000002242L});
    public static final BitSet FOLLOW_nameExprTerm_in_simpleExpr316 = new BitSet(new long[]{0x0000000000002242L});
    public static final BitSet FOLLOW_IDENT_in_nameExprTerm334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_nameExprTerm340 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExprTerm343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExprTerm349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_freeExpression366 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_23_in_freeExpression370 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_24_in_freeExpression375 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_relation_in_freeExpression379 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm400 = new BitSet(new long[]{0x0000000002002440L});
    public static final BitSet FOLLOW_IDENT_in_arithmeticTerm404 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_25_in_arithmeticTerm412 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm415 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_freeExpression_in_arithmeticTerm419 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm421 = new BitSet(new long[]{0x0000000004002000L});
    public static final BitSet FOLLOW_26_in_arithmeticTerm425 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_INTEGER_in_arithmeticTerm434 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm437 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_add_in_relation459 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_27_in_relation463 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_28_in_relation468 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_29_in_relation473 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_30_in_relation478 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_31_in_relation483 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_32_in_relation488 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_add_in_relation492 = new BitSet(new long[]{0x00000001F8000002L});
    public static final BitSet FOLLOW_mult_in_add507 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_33_in_add511 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_34_in_add516 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_mult_in_add520 = new BitSet(new long[]{0x0000000600000002L});
    public static final BitSet FOLLOW_unary_in_mult537 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_35_in_mult541 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_36_in_mult546 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_unary_in_mult550 = new BitSet(new long[]{0x0000001800000002L});
    public static final BitSet FOLLOW_33_in_unary568 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_negation_in_unary573 = new BitSet(new long[]{0x0000000602002440L});
    public static final BitSet FOLLOW_arithmeticTerm_in_unary578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_negation593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ee722 = new BitSet(new long[]{0x000000E000003002L});
    public static final BitSet FOLLOW_NOTNEWLINE_in_ee730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_ee734 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_37_in_ee739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ee743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ee747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_ws820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NL_in_nl826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred6_setloopiterinserts141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred7_setloopiterinserts148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred10_setloopiterinserts171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred11_setloopiterinserts178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred13_setloopiterinserts187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nl_in_synpred14_setloopiterinserts191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred21_setloopiterinserts283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameExprTerm_in_synpred24_setloopiterinserts316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_synpred26_setloopiterinserts340 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_simpleExpr_in_synpred26_setloopiterinserts343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred31_setloopiterinserts415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred34_setloopiterinserts437 = new BitSet(new long[]{0x0000000000000002L});

}