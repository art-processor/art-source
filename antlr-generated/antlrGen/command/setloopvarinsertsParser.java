// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g 2017-03-28 11:47:25

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

public class setloopvarinsertsParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATION", "COMMANDCHAR", "IDENT", "STRING", "EPRESSIONCHAR", "REFERENCECHAR", "INTEGER", "QUOTATIONMARK", "NOTNEWLINE", "WS", "NL", "DIGIT", "SPECCHAR", "LETTER", "DOT", "ANYCHAR", "'var'", "'='", "'&&'", "'||'", "'('", "')'", "'=='", "'!='", "'<'", "'<='", "'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'\\\\\"'", "'\\\\#'", "'\\\\?'"
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


        public setloopvarinsertsParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public setloopvarinsertsParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return setloopvarinsertsParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g"; }


    public static class evaluator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "evaluator"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:25:1: evaluator : ( ( ws | nl )* COMMANDCHAR v= varDesc )* EOF ;
    public final setloopvarinsertsParser.evaluator_return evaluator() throws RecognitionException {
        setloopvarinsertsParser.evaluator_return retval = new setloopvarinsertsParser.evaluator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COMMANDCHAR3=null;
        Token EOF4=null;
        setloopvarinsertsParser.varDesc_return v = null;

        setloopvarinsertsParser.ws_return ws1 = null;

        setloopvarinsertsParser.nl_return nl2 = null;


        CommonTree COMMANDCHAR3_tree=null;
        CommonTree EOF4_tree=null;

        StringBuilder sb = new StringBuilder();
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:27:3: ( ( ( ws | nl )* COMMANDCHAR v= varDesc )* EOF )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:28:3: ( ( ws | nl )* COMMANDCHAR v= varDesc )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:28:3: ( ( ws | nl )* COMMANDCHAR v= varDesc )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==COMMANDCHAR||(LA2_0>=WS && LA2_0<=NL)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:28:5: ( ws | nl )* COMMANDCHAR v= varDesc
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:28:5: ( ws | nl )*
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
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:28:6: ws
            	    	    {
            	    	    pushFollow(FOLLOW_ws_in_evaluator89);
            	    	    ws1=ws();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws1.getTree());

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:28:11: nl
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
            	    pushFollow(FOLLOW_varDesc_in_evaluator101);
            	    v=varDesc();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, v.getTree());
            	    if ( state.backtracking==0 ) {
            	      sb.append((v!=null?input.toString(v.start,v.stop):null));
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

    public static class varDesc_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "varDesc"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:31:1: varDesc : 'var' ( ws )* i= IDENT ( ws )* ( '=' ( ws )* e= expression ( ws )* )? ( ws | nl )* ;
    public final setloopvarinsertsParser.varDesc_return varDesc() throws RecognitionException {
        setloopvarinsertsParser.varDesc_return retval = new setloopvarinsertsParser.varDesc_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token i=null;
        Token string_literal5=null;
        Token char_literal8=null;
        setloopvarinsertsParser.expression_return e = null;

        setloopvarinsertsParser.ws_return ws6 = null;

        setloopvarinsertsParser.ws_return ws7 = null;

        setloopvarinsertsParser.ws_return ws9 = null;

        setloopvarinsertsParser.ws_return ws10 = null;

        setloopvarinsertsParser.ws_return ws11 = null;

        setloopvarinsertsParser.nl_return nl12 = null;


        CommonTree i_tree=null;
        CommonTree string_literal5_tree=null;
        CommonTree char_literal8_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:3: ( 'var' ( ws )* i= IDENT ( ws )* ( '=' ( ws )* e= expression ( ws )* )? ( ws | nl )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:5: 'var' ( ws )* i= IDENT ( ws )* ( '=' ( ws )* e= expression ( ws )* )? ( ws | nl )*
            {
            root_0 = (CommonTree)adaptor.nil();

            string_literal5=(Token)match(input,20,FOLLOW_20_in_varDesc121); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            string_literal5_tree = (CommonTree)adaptor.create(string_literal5);
            adaptor.addChild(root_0, string_literal5_tree);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:11: ( ws )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==WS) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_varDesc123);
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

            i=(Token)match(input,IDENT,FOLLOW_IDENT_in_varDesc128); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            i_tree = (CommonTree)adaptor.create(i);
            adaptor.addChild(root_0, i_tree);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:24: ( ws )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==WS) ) {
                    int LA4_2 = input.LA(2);

                    if ( (synpred5_setloopvarinserts()) ) {
                        alt4=1;
                    }


                }


                switch (alt4) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_varDesc131);
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

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:28: ( '=' ( ws )* e= expression ( ws )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==21) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:29: '=' ( ws )* e= expression ( ws )*
                    {
                    char_literal8=(Token)match(input,21,FOLLOW_21_in_varDesc135); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    char_literal8_tree = (CommonTree)adaptor.create(char_literal8);
                    adaptor.addChild(root_0, char_literal8_tree);
                    }
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:33: ( ws )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==WS) ) {
                            int LA5_2 = input.LA(2);

                            if ( (synpred6_setloopvarinserts()) ) {
                                alt5=1;
                            }


                        }


                        switch (alt5) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_varDesc137);
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

                    pushFollow(FOLLOW_expression_in_varDesc142);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, e.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:50: ( ws )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==WS) ) {
                            int LA6_1 = input.LA(2);

                            if ( (synpred7_setloopvarinserts()) ) {
                                alt6=1;
                            }


                        }


                        switch (alt6) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_varDesc144);
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


                    }
                    break;

            }

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:56: ( ws | nl )*
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==WS) ) {
                    int LA8_2 = input.LA(2);

                    if ( (synpred9_setloopvarinserts()) ) {
                        alt8=1;
                    }


                }
                else if ( (LA8_0==NL) ) {
                    int LA8_3 = input.LA(2);

                    if ( (synpred10_setloopvarinserts()) ) {
                        alt8=2;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:57: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_varDesc150);
            	    ws11=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws11.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:62: nl
            	    {
            	    pushFollow(FOLLOW_nl_in_varDesc154);
            	    nl12=nl();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nl12.getTree());

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {

                       //add the new variable to the setloop
                       if (Utils.canWrite()){
                           SetLoopInfo.addVariableToSetLoop((i!=null?i.getText():null), (e!=null?input.toString(e.start,e.stop):null));
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
    // $ANTLR end "varDesc"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:44:1: expression : ( freeExpression | stringExpression );
    public final setloopvarinsertsParser.expression_return expression() throws RecognitionException {
        setloopvarinsertsParser.expression_return retval = new setloopvarinsertsParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        setloopvarinsertsParser.freeExpression_return freeExpression13 = null;

        setloopvarinsertsParser.stringExpression_return stringExpression14 = null;



        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:45:3: ( freeExpression | stringExpression )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==IDENT||LA9_0==INTEGER||LA9_0==WS||LA9_0==24||(LA9_0>=32 && LA9_0<=33)) ) {
                alt9=1;
            }
            else if ( ((LA9_0>=STRING && LA9_0<=EPRESSIONCHAR)) ) {
                alt9=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:45:5: freeExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_freeExpression_in_expression186);
                    freeExpression13=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression13.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:46:5: stringExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_stringExpression_in_expression192);
                    stringExpression14=stringExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stringExpression14.getTree());

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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:49:1: stringExpression : ( nameExpression | STRING )+ ;
    public final setloopvarinsertsParser.stringExpression_return stringExpression() throws RecognitionException {
        setloopvarinsertsParser.stringExpression_return retval = new setloopvarinsertsParser.stringExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING16=null;
        setloopvarinsertsParser.nameExpression_return nameExpression15 = null;


        CommonTree STRING16_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:50:3: ( ( nameExpression | STRING )+ )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:50:5: ( nameExpression | STRING )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:50:5: ( nameExpression | STRING )+
            int cnt10=0;
            loop10:
            do {
                int alt10=3;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==EPRESSIONCHAR) ) {
                    alt10=1;
                }
                else if ( (LA10_0==STRING) ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:50:6: nameExpression
            	    {
            	    pushFollow(FOLLOW_nameExpression_in_stringExpression208);
            	    nameExpression15=nameExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameExpression15.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:50:23: STRING
            	    {
            	    STRING16=(Token)match(input,STRING,FOLLOW_STRING_in_stringExpression212); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    STRING16_tree = (CommonTree)adaptor.create(STRING16);
            	    adaptor.addChild(root_0, STRING16_tree);
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:53:1: nameExpression : ( EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR | EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+ );
    public final setloopvarinsertsParser.nameExpression_return nameExpression() throws RecognitionException {
        setloopvarinsertsParser.nameExpression_return retval = new setloopvarinsertsParser.nameExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EPRESSIONCHAR17=null;
        Token EPRESSIONCHAR21=null;
        Token EPRESSIONCHAR22=null;
        Token EPRESSIONCHAR26=null;
        setloopvarinsertsParser.ws_return ws18 = null;

        setloopvarinsertsParser.simpleExpr_return simpleExpr19 = null;

        setloopvarinsertsParser.ws_return ws20 = null;

        setloopvarinsertsParser.ws_return ws23 = null;

        setloopvarinsertsParser.freeExpression_return freeExpression24 = null;

        setloopvarinsertsParser.ws_return ws25 = null;


        CommonTree EPRESSIONCHAR17_tree=null;
        CommonTree EPRESSIONCHAR21_tree=null;
        CommonTree EPRESSIONCHAR22_tree=null;
        CommonTree EPRESSIONCHAR26_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:54:3: ( EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR | EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+ )
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:54:5: EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EPRESSIONCHAR17=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression229); if (state.failed) return retval;
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:54:22: ( ws )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==WS) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression232);
                    	    ws18=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    pushFollow(FOLLOW_simpleExpr_in_nameExpression236);
                    simpleExpr19=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr19.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:54:38: ( ws )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==WS) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression238);
                    	    ws20=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);

                    EPRESSIONCHAR21=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression242); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:55:5: EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EPRESSIONCHAR22=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression249); if (state.failed) return retval;
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:55:22: ( ws )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==WS) ) {
                            int LA13_2 = input.LA(2);

                            if ( (synpred17_setloopvarinserts()) ) {
                                alt13=1;
                            }


                        }


                        switch (alt13) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression252);
                    	    ws23=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);

                    pushFollow(FOLLOW_freeExpression_in_nameExpression256);
                    freeExpression24=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression24.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:55:42: ( ws )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==WS) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_nameExpression258);
                    	    ws25=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:55:58: ( EPRESSIONCHAR )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        alt15 = dfa15.predict(input);
                        switch (alt15) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: EPRESSIONCHAR
                    	    {
                    	    EPRESSIONCHAR26=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression262); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:59:1: simpleExpr : REFERENCECHAR ( nameExprTerm )* ;
    public final setloopvarinsertsParser.simpleExpr_return simpleExpr() throws RecognitionException {
        setloopvarinsertsParser.simpleExpr_return retval = new setloopvarinsertsParser.simpleExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REFERENCECHAR27=null;
        setloopvarinsertsParser.nameExprTerm_return nameExprTerm28 = null;


        CommonTree REFERENCECHAR27_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:60:3: ( REFERENCECHAR ( nameExprTerm )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:60:5: REFERENCECHAR ( nameExprTerm )*
            {
            root_0 = (CommonTree)adaptor.nil();

            REFERENCECHAR27=(Token)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_simpleExpr282); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REFERENCECHAR27_tree = (CommonTree)adaptor.create(REFERENCECHAR27);
            root_0 = (CommonTree)adaptor.becomeRoot(REFERENCECHAR27_tree, root_0);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:60:20: ( nameExprTerm )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==IDENT) ) {
                    int LA17_3 = input.LA(2);

                    if ( (synpred20_setloopvarinserts()) ) {
                        alt17=1;
                    }


                }
                else if ( (LA17_0==REFERENCECHAR) ) {
                    int LA17_4 = input.LA(2);

                    if ( (synpred20_setloopvarinserts()) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: nameExprTerm
            	    {
            	    pushFollow(FOLLOW_nameExprTerm_in_simpleExpr285);
            	    nameExprTerm28=nameExprTerm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameExprTerm28.getTree());

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:63:1: nameExprTerm : ( IDENT | REFERENCECHAR simpleExpr | simpleExpr ) ;
    public final setloopvarinsertsParser.nameExprTerm_return nameExprTerm() throws RecognitionException {
        setloopvarinsertsParser.nameExprTerm_return retval = new setloopvarinsertsParser.nameExprTerm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT29=null;
        Token REFERENCECHAR30=null;
        setloopvarinsertsParser.simpleExpr_return simpleExpr31 = null;

        setloopvarinsertsParser.simpleExpr_return simpleExpr32 = null;


        CommonTree IDENT29_tree=null;
        CommonTree REFERENCECHAR30_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:64:3: ( ( IDENT | REFERENCECHAR simpleExpr | simpleExpr ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:64:5: ( IDENT | REFERENCECHAR simpleExpr | simpleExpr )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:64:5: ( IDENT | REFERENCECHAR simpleExpr | simpleExpr )
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==IDENT) ) {
                alt18=1;
            }
            else if ( (LA18_0==REFERENCECHAR) ) {
                int LA18_2 = input.LA(2);

                if ( (LA18_2==EOF||LA18_2==IDENT||LA18_2==EPRESSIONCHAR||LA18_2==WS) ) {
                    alt18=3;
                }
                else if ( (LA18_2==REFERENCECHAR) ) {
                    int LA18_4 = input.LA(3);

                    if ( (synpred22_setloopvarinserts()) ) {
                        alt18=2;
                    }
                    else if ( (true) ) {
                        alt18=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:64:6: IDENT
                    {
                    IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_nameExprTerm303); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT29_tree = (CommonTree)adaptor.create(IDENT29);
                    adaptor.addChild(root_0, IDENT29_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:65:5: REFERENCECHAR simpleExpr
                    {
                    REFERENCECHAR30=(Token)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_nameExprTerm309); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REFERENCECHAR30_tree = (CommonTree)adaptor.create(REFERENCECHAR30);
                    root_0 = (CommonTree)adaptor.becomeRoot(REFERENCECHAR30_tree, root_0);
                    }
                    pushFollow(FOLLOW_simpleExpr_in_nameExprTerm312);
                    simpleExpr31=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr31.getTree());

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:66:5: simpleExpr
                    {
                    pushFollow(FOLLOW_simpleExpr_in_nameExprTerm318);
                    simpleExpr32=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr32.getTree());

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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:70:1: freeExpression : relation ( ( '&&' | '||' ) relation )* ;
    public final setloopvarinsertsParser.freeExpression_return freeExpression() throws RecognitionException {
        setloopvarinsertsParser.freeExpression_return retval = new setloopvarinsertsParser.freeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal34=null;
        Token string_literal35=null;
        setloopvarinsertsParser.relation_return relation33 = null;

        setloopvarinsertsParser.relation_return relation36 = null;


        CommonTree string_literal34_tree=null;
        CommonTree string_literal35_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:3: ( relation ( ( '&&' | '||' ) relation )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:5: relation ( ( '&&' | '||' ) relation )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_relation_in_freeExpression335);
            relation33=relation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relation33.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:14: ( ( '&&' | '||' ) relation )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=22 && LA20_0<=23)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:15: ( '&&' | '||' ) relation
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:15: ( '&&' | '||' )
            	    int alt19=2;
            	    int LA19_0 = input.LA(1);

            	    if ( (LA19_0==22) ) {
            	        alt19=1;
            	    }
            	    else if ( (LA19_0==23) ) {
            	        alt19=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 19, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt19) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:16: '&&'
            	            {
            	            string_literal34=(Token)match(input,22,FOLLOW_22_in_freeExpression339); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:71:24: '||'
            	            {
            	            string_literal35=(Token)match(input,23,FOLLOW_23_in_freeExpression344); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal35_tree = (CommonTree)adaptor.create(string_literal35);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal35_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relation_in_freeExpression348);
            	    relation36=relation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relation36.getTree());

            	    }
            	    break;

            	default :
            	    break loop20;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:78:1: arithmeticTerm : ( ws )* ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER ) ( ws )* ;
    public final setloopvarinsertsParser.arithmeticTerm_return arithmeticTerm() throws RecognitionException {
        setloopvarinsertsParser.arithmeticTerm_return retval = new setloopvarinsertsParser.arithmeticTerm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT38=null;
        Token char_literal39=null;
        Token char_literal43=null;
        Token INTEGER44=null;
        setloopvarinsertsParser.ws_return ws37 = null;

        setloopvarinsertsParser.ws_return ws40 = null;

        setloopvarinsertsParser.freeExpression_return freeExpression41 = null;

        setloopvarinsertsParser.ws_return ws42 = null;

        setloopvarinsertsParser.ws_return ws45 = null;


        CommonTree IDENT38_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree char_literal43_tree=null;
        CommonTree INTEGER44_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:79:5: ( ( ws )* ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER ) ( ws )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:79:7: ( ws )* ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER ) ( ws )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:79:7: ( ws )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==WS) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_arithmeticTerm369);
            	    ws37=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws37.getTree());

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:79:11: ( IDENT | '(' ( ws )* freeExpression ( ws )* ')' | INTEGER )
            int alt24=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt24=1;
                }
                break;
            case 24:
                {
                alt24=2;
                }
                break;
            case INTEGER:
                {
                alt24=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:79:12: IDENT
                    {
                    IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_arithmeticTerm373); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT38_tree = (CommonTree)adaptor.create(IDENT38);
                    adaptor.addChild(root_0, IDENT38_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:80:7: '(' ( ws )* freeExpression ( ws )* ')'
                    {
                    char_literal39=(Token)match(input,24,FOLLOW_24_in_arithmeticTerm381); if (state.failed) return retval;
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:80:14: ( ws )*
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==WS) ) {
                            int LA22_2 = input.LA(2);

                            if ( (synpred27_setloopvarinserts()) ) {
                                alt22=1;
                            }


                        }


                        switch (alt22) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_arithmeticTerm384);
                    	    ws40=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop22;
                        }
                    } while (true);

                    pushFollow(FOLLOW_freeExpression_in_arithmeticTerm388);
                    freeExpression41=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression41.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:80:34: ( ws )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==WS) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
                    	    {
                    	    pushFollow(FOLLOW_ws_in_arithmeticTerm390);
                    	    ws42=ws();

                    	    state._fsp--;
                    	    if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);

                    char_literal43=(Token)match(input,25,FOLLOW_25_in_arithmeticTerm394); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:81:7: INTEGER
                    {
                    INTEGER44=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arithmeticTerm403); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER44_tree = (CommonTree)adaptor.create(INTEGER44);
                    adaptor.addChild(root_0, INTEGER44_tree);
                    }

                    }
                    break;

            }

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:81:16: ( ws )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==WS) ) {
                    int LA25_2 = input.LA(2);

                    if ( (synpred30_setloopvarinserts()) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: ws
            	    {
            	    pushFollow(FOLLOW_ws_in_arithmeticTerm406);
            	    ws45=ws();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, ws45.getTree());

            	    }
            	    break;

            	default :
            	    break loop25;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:84:1: relation : add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* ;
    public final setloopvarinsertsParser.relation_return relation() throws RecognitionException {
        setloopvarinsertsParser.relation_return retval = new setloopvarinsertsParser.relation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal47=null;
        Token string_literal48=null;
        Token char_literal49=null;
        Token string_literal50=null;
        Token string_literal51=null;
        Token char_literal52=null;
        setloopvarinsertsParser.add_return add46 = null;

        setloopvarinsertsParser.add_return add53 = null;


        CommonTree string_literal47_tree=null;
        CommonTree string_literal48_tree=null;
        CommonTree char_literal49_tree=null;
        CommonTree string_literal50_tree=null;
        CommonTree string_literal51_tree=null;
        CommonTree char_literal52_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:3: ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:5: add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_add_in_relation428);
            add46=add();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add46.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:9: ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( ((LA27_0>=26 && LA27_0<=31)) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:10: ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:10: ( '==' | '!=' | '<' | '<=' | '>=' | '>' )
            	    int alt26=6;
            	    switch ( input.LA(1) ) {
            	    case 26:
            	        {
            	        alt26=1;
            	        }
            	        break;
            	    case 27:
            	        {
            	        alt26=2;
            	        }
            	        break;
            	    case 28:
            	        {
            	        alt26=3;
            	        }
            	        break;
            	    case 29:
            	        {
            	        alt26=4;
            	        }
            	        break;
            	    case 30:
            	        {
            	        alt26=5;
            	        }
            	        break;
            	    case 31:
            	        {
            	        alt26=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 26, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt26) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:11: '=='
            	            {
            	            string_literal47=(Token)match(input,26,FOLLOW_26_in_relation432); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal47_tree = (CommonTree)adaptor.create(string_literal47);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal47_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:19: '!='
            	            {
            	            string_literal48=(Token)match(input,27,FOLLOW_27_in_relation437); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal48_tree = (CommonTree)adaptor.create(string_literal48);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal48_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:27: '<'
            	            {
            	            char_literal49=(Token)match(input,28,FOLLOW_28_in_relation442); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal49_tree = (CommonTree)adaptor.create(char_literal49);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal49_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:34: '<='
            	            {
            	            string_literal50=(Token)match(input,29,FOLLOW_29_in_relation447); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal50_tree = (CommonTree)adaptor.create(string_literal50);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal50_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:42: '>='
            	            {
            	            string_literal51=(Token)match(input,30,FOLLOW_30_in_relation452); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal51_tree = (CommonTree)adaptor.create(string_literal51);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal51_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:85:50: '>'
            	            {
            	            char_literal52=(Token)match(input,31,FOLLOW_31_in_relation457); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal52_tree = (CommonTree)adaptor.create(char_literal52);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal52_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_in_relation461);
            	    add53=add();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add53.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:88:1: add : mult ( ( '+' | '-' ) mult )* ;
    public final setloopvarinsertsParser.add_return add() throws RecognitionException {
        setloopvarinsertsParser.add_return retval = new setloopvarinsertsParser.add_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal55=null;
        Token char_literal56=null;
        setloopvarinsertsParser.mult_return mult54 = null;

        setloopvarinsertsParser.mult_return mult57 = null;


        CommonTree char_literal55_tree=null;
        CommonTree char_literal56_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:3: ( mult ( ( '+' | '-' ) mult )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:5: mult ( ( '+' | '-' ) mult )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mult_in_add476);
            mult54=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult54.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:10: ( ( '+' | '-' ) mult )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=32 && LA29_0<=33)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:11: ( '+' | '-' ) mult
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:11: ( '+' | '-' )
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==32) ) {
            	        alt28=1;
            	    }
            	    else if ( (LA28_0==33) ) {
            	        alt28=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 28, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:12: '+'
            	            {
            	            char_literal55=(Token)match(input,32,FOLLOW_32_in_add480); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal55_tree = (CommonTree)adaptor.create(char_literal55);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal55_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:89:19: '-'
            	            {
            	            char_literal56=(Token)match(input,33,FOLLOW_33_in_add485); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal56_tree = (CommonTree)adaptor.create(char_literal56);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal56_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_add489);
            	    mult57=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult57.getTree());

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
    // $ANTLR end "add"

    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mult"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:92:1: mult : unary ( ( '*' | '/' ) unary )* ;
    public final setloopvarinsertsParser.mult_return mult() throws RecognitionException {
        setloopvarinsertsParser.mult_return retval = new setloopvarinsertsParser.mult_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal59=null;
        Token char_literal60=null;
        setloopvarinsertsParser.unary_return unary58 = null;

        setloopvarinsertsParser.unary_return unary61 = null;


        CommonTree char_literal59_tree=null;
        CommonTree char_literal60_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:3: ( unary ( ( '*' | '/' ) unary )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:5: unary ( ( '*' | '/' ) unary )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unary_in_mult506);
            unary58=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary58.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:11: ( ( '*' | '/' ) unary )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=34 && LA31_0<=35)) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:12: ( '*' | '/' ) unary
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:12: ( '*' | '/' )
            	    int alt30=2;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==34) ) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==35) ) {
            	        alt30=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 30, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:13: '*'
            	            {
            	            char_literal59=(Token)match(input,34,FOLLOW_34_in_mult510); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal59_tree = (CommonTree)adaptor.create(char_literal59);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal59_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:93:20: '/'
            	            {
            	            char_literal60=(Token)match(input,35,FOLLOW_35_in_mult515); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal60_tree = (CommonTree)adaptor.create(char_literal60);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal60_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult519);
            	    unary61=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary61.getTree());

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
    // $ANTLR end "mult"

    public static class unary_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unary"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:96:1: unary : ( '+' | negation )* arithmeticTerm ;
    public final setloopvarinsertsParser.unary_return unary() throws RecognitionException {
        setloopvarinsertsParser.unary_return retval = new setloopvarinsertsParser.unary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal62=null;
        setloopvarinsertsParser.negation_return negation63 = null;

        setloopvarinsertsParser.arithmeticTerm_return arithmeticTerm64 = null;


        CommonTree char_literal62_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:97:3: ( ( '+' | negation )* arithmeticTerm )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:97:5: ( '+' | negation )* arithmeticTerm
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:97:5: ( '+' | negation )*
            loop32:
            do {
                int alt32=3;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==32) ) {
                    alt32=1;
                }
                else if ( (LA32_0==33) ) {
                    alt32=2;
                }


                switch (alt32) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:97:6: '+'
            	    {
            	    char_literal62=(Token)match(input,32,FOLLOW_32_in_unary537); if (state.failed) return retval;

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:97:13: negation
            	    {
            	    pushFollow(FOLLOW_negation_in_unary542);
            	    negation63=negation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(negation63.getTree(), root_0);

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            pushFollow(FOLLOW_arithmeticTerm_in_unary547);
            arithmeticTerm64=arithmeticTerm();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm64.getTree());

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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:100:1: negation : '-' -> NEGATION ;
    public final setloopvarinsertsParser.negation_return negation() throws RecognitionException {
        setloopvarinsertsParser.negation_return retval = new setloopvarinsertsParser.negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal65=null;

        CommonTree char_literal65_tree=null;
        RewriteRuleTokenStream stream_33=new RewriteRuleTokenStream(adaptor,"token 33");

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:101:3: ( '-' -> NEGATION )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:101:5: '-'
            {
            char_literal65=(Token)match(input,33,FOLLOW_33_in_negation562); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_33.add(char_literal65);



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
            // 101:9: -> NEGATION
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:124:1: ee : ~ ( '#' | '?' ) ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' ) ;
    public final setloopvarinsertsParser.ee_return ee() throws RecognitionException {
        setloopvarinsertsParser.ee_return retval = new setloopvarinsertsParser.ee_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set66=null;
        Token NOTNEWLINE67=null;
        Token WS68=null;
        Token string_literal69=null;
        Token string_literal70=null;
        Token string_literal71=null;

        CommonTree set66_tree=null;
        CommonTree NOTNEWLINE67_tree=null;
        CommonTree WS68_tree=null;
        CommonTree string_literal69_tree=null;
        CommonTree string_literal70_tree=null;
        CommonTree string_literal71_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:3: (~ ( '#' | '?' ) ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:5: ~ ( '#' | '?' ) ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' )
            {
            root_0 = (CommonTree)adaptor.nil();

            set66=(Token)input.LT(1);
            if ( input.LA(1)==NEGATION||(input.LA(1)>=IDENT && input.LA(1)<=STRING)||(input.LA(1)>=REFERENCECHAR && input.LA(1)<=38) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set66));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:16: ( NOTNEWLINE | ( WS )* | '\\\\\"' | '\\\\#' | '\\\\?' )
            int alt34=5;
            switch ( input.LA(1) ) {
            case NOTNEWLINE:
                {
                alt34=1;
                }
                break;
            case EOF:
            case WS:
                {
                alt34=2;
                }
                break;
            case 36:
                {
                alt34=3;
                }
                break;
            case 37:
                {
                alt34=4;
                }
                break;
            case 38:
                {
                alt34=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:17: NOTNEWLINE
                    {
                    NOTNEWLINE67=(Token)match(input,NOTNEWLINE,FOLLOW_NOTNEWLINE_in_ee699); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    NOTNEWLINE67_tree = (CommonTree)adaptor.create(NOTNEWLINE67);
                    adaptor.addChild(root_0, NOTNEWLINE67_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:30: ( WS )*
                    {
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:30: ( WS )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==WS) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:0:0: WS
                    	    {
                    	    WS68=(Token)match(input,WS,FOLLOW_WS_in_ee703); if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) {
                    	    WS68_tree = (CommonTree)adaptor.create(WS68);
                    	    adaptor.addChild(root_0, WS68_tree);
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:36: '\\\\\"'
                    {
                    string_literal69=(Token)match(input,36,FOLLOW_36_in_ee708); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal69_tree = (CommonTree)adaptor.create(string_literal69);
                    adaptor.addChild(root_0, string_literal69_tree);
                    }

                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:44: '\\\\#'
                    {
                    string_literal70=(Token)match(input,37,FOLLOW_37_in_ee712); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal70_tree = (CommonTree)adaptor.create(string_literal70);
                    adaptor.addChild(root_0, string_literal70_tree);
                    }

                    }
                    break;
                case 5 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:125:52: '\\\\?'
                    {
                    string_literal71=(Token)match(input,38,FOLLOW_38_in_ee716); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    string_literal71_tree = (CommonTree)adaptor.create(string_literal71);
                    adaptor.addChild(root_0, string_literal71_tree);
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:137:1: ws : WS ;
    public final setloopvarinsertsParser.ws_return ws() throws RecognitionException {
        setloopvarinsertsParser.ws_return retval = new setloopvarinsertsParser.ws_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token WS72=null;

        CommonTree WS72_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:137:3: ( WS )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:137:5: WS
            {
            root_0 = (CommonTree)adaptor.nil();

            WS72=(Token)match(input,WS,FOLLOW_WS_in_ws789); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            WS72_tree = (CommonTree)adaptor.create(WS72);
            adaptor.addChild(root_0, WS72_tree);
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:138:1: nl : NL ;
    public final setloopvarinsertsParser.nl_return nl() throws RecognitionException {
        setloopvarinsertsParser.nl_return retval = new setloopvarinsertsParser.nl_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token NL73=null;

        CommonTree NL73_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:138:3: ( NL )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:138:5: NL
            {
            root_0 = (CommonTree)adaptor.nil();

            NL73=(Token)match(input,NL,FOLLOW_NL_in_nl795); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            NL73_tree = (CommonTree)adaptor.create(NL73);
            adaptor.addChild(root_0, NL73_tree);
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

    // $ANTLR start synpred5_setloopvarinserts
    public final void synpred5_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:24: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:24: ws
        {
        pushFollow(FOLLOW_ws_in_synpred5_setloopvarinserts131);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred5_setloopvarinserts

    // $ANTLR start synpred6_setloopvarinserts
    public final void synpred6_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:33: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:33: ws
        {
        pushFollow(FOLLOW_ws_in_synpred6_setloopvarinserts137);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_setloopvarinserts

    // $ANTLR start synpred7_setloopvarinserts
    public final void synpred7_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:50: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:50: ws
        {
        pushFollow(FOLLOW_ws_in_synpred7_setloopvarinserts144);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_setloopvarinserts

    // $ANTLR start synpred9_setloopvarinserts
    public final void synpred9_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:57: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:57: ws
        {
        pushFollow(FOLLOW_ws_in_synpred9_setloopvarinserts150);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred9_setloopvarinserts

    // $ANTLR start synpred10_setloopvarinserts
    public final void synpred10_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:62: ( nl )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:32:62: nl
        {
        pushFollow(FOLLOW_nl_in_synpred10_setloopvarinserts154);
        nl();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_setloopvarinserts

    // $ANTLR start synpred17_setloopvarinserts
    public final void synpred17_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:55:20: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:55:20: ws
        {
        pushFollow(FOLLOW_ws_in_synpred17_setloopvarinserts252);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred17_setloopvarinserts

    // $ANTLR start synpred20_setloopvarinserts
    public final void synpred20_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:60:20: ( nameExprTerm )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:60:20: nameExprTerm
        {
        pushFollow(FOLLOW_nameExprTerm_in_synpred20_setloopvarinserts285);
        nameExprTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred20_setloopvarinserts

    // $ANTLR start synpred22_setloopvarinserts
    public final void synpred22_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:65:5: ( REFERENCECHAR simpleExpr )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:65:5: REFERENCECHAR simpleExpr
        {
        match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_synpred22_setloopvarinserts309); if (state.failed) return ;
        pushFollow(FOLLOW_simpleExpr_in_synpred22_setloopvarinserts312);
        simpleExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred22_setloopvarinserts

    // $ANTLR start synpred27_setloopvarinserts
    public final void synpred27_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:80:12: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:80:12: ws
        {
        pushFollow(FOLLOW_ws_in_synpred27_setloopvarinserts384);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_setloopvarinserts

    // $ANTLR start synpred30_setloopvarinserts
    public final void synpred30_setloopvarinserts_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:81:16: ( ws )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\setloopvarinserts.g:81:16: ws
        {
        pushFollow(FOLLOW_ws_in_synpred30_setloopvarinserts406);
        ws();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred30_setloopvarinserts

    // Delegated rules

    public final boolean synpred10_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred20_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred20_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred17_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred17_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred9_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred9_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred30_setloopvarinserts() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred30_setloopvarinserts_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA16_eotS =
        "\5\uffff";
    static final String DFA16_eofS =
        "\5\uffff";
    static final String DFA16_minS =
        "\1\10\2\6\2\uffff";
    static final String DFA16_maxS =
        "\1\10\2\41\2\uffff";
    static final String DFA16_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA16_specialS =
        "\5\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1",
            "\1\4\2\uffff\1\3\1\4\2\uffff\1\2\12\uffff\1\4\7\uffff\2\4",
            "\1\4\2\uffff\1\3\1\4\2\uffff\1\2\12\uffff\1\4\7\uffff\2\4",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "53:1: nameExpression : ( EPRESSIONCHAR ( ws )* simpleExpr ( ws )* EPRESSIONCHAR | EPRESSIONCHAR ( ws )* freeExpression ( ws )* ( EPRESSIONCHAR )+ );";
        }
    }
    static final String DFA15_eotS =
        "\5\uffff";
    static final String DFA15_eofS =
        "\1\1\1\uffff\2\4\1\uffff";
    static final String DFA15_minS =
        "\1\5\1\uffff\2\5\1\uffff";
    static final String DFA15_maxS =
        "\1\16\1\uffff\2\41\1\uffff";
    static final String DFA15_acceptS =
        "\1\uffff\1\2\2\uffff\1\1";
    static final String DFA15_specialS =
        "\5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\1\1\1\uffff\1\1\1\2\4\uffff\2\1",
            "",
            "\1\4\1\1\2\4\2\1\2\uffff\1\3\1\4\11\uffff\1\1\7\uffff\2\1",
            "\1\4\1\1\2\uffff\2\1\2\uffff\1\3\1\4\11\uffff\1\1\7\uffff"+
            "\2\1",
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
            return "()+ loopback of 55:58: ( EPRESSIONCHAR )+";
        }
    }
 

    public static final BitSet FOLLOW_ws_in_evaluator89 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_nl_in_evaluator93 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_COMMANDCHAR_in_evaluator97 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_varDesc_in_evaluator101 = new BitSet(new long[]{0x0000000000006020L});
    public static final BitSet FOLLOW_EOF_in_evaluator108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_varDesc121 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_ws_in_varDesc123 = new BitSet(new long[]{0x0000000000002040L});
    public static final BitSet FOLLOW_IDENT_in_varDesc128 = new BitSet(new long[]{0x0000000000206022L});
    public static final BitSet FOLLOW_ws_in_varDesc131 = new BitSet(new long[]{0x0000000000206022L});
    public static final BitSet FOLLOW_21_in_varDesc135 = new BitSet(new long[]{0x00000003010025C0L});
    public static final BitSet FOLLOW_ws_in_varDesc137 = new BitSet(new long[]{0x00000003010025C0L});
    public static final BitSet FOLLOW_expression_in_varDesc142 = new BitSet(new long[]{0x0000000000006022L});
    public static final BitSet FOLLOW_ws_in_varDesc144 = new BitSet(new long[]{0x0000000000006022L});
    public static final BitSet FOLLOW_ws_in_varDesc150 = new BitSet(new long[]{0x0000000000006022L});
    public static final BitSet FOLLOW_nl_in_varDesc154 = new BitSet(new long[]{0x0000000000006022L});
    public static final BitSet FOLLOW_freeExpression_in_expression186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_expression192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameExpression_in_stringExpression208 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_STRING_in_stringExpression212 = new BitSet(new long[]{0x0000000000000182L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression229 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_ws_in_nameExpression232 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExpression236 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_ws_in_nameExpression238 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression249 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_ws_in_nameExpression252 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_freeExpression_in_nameExpression256 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_ws_in_nameExpression258 = new BitSet(new long[]{0x0000000000002100L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression262 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_simpleExpr282 = new BitSet(new long[]{0x0000000000002242L});
    public static final BitSet FOLLOW_nameExprTerm_in_simpleExpr285 = new BitSet(new long[]{0x0000000000002242L});
    public static final BitSet FOLLOW_IDENT_in_nameExprTerm303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_nameExprTerm309 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExprTerm312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExprTerm318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_freeExpression335 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_22_in_freeExpression339 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_23_in_freeExpression344 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_relation_in_freeExpression348 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm369 = new BitSet(new long[]{0x0000000001002440L});
    public static final BitSet FOLLOW_IDENT_in_arithmeticTerm373 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_24_in_arithmeticTerm381 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm384 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_freeExpression_in_arithmeticTerm388 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm390 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_25_in_arithmeticTerm394 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_INTEGER_in_arithmeticTerm403 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_ws_in_arithmeticTerm406 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_add_in_relation428 = new BitSet(new long[]{0x00000000FC000002L});
    public static final BitSet FOLLOW_26_in_relation432 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_27_in_relation437 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_28_in_relation442 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_29_in_relation447 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_30_in_relation452 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_31_in_relation457 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_add_in_relation461 = new BitSet(new long[]{0x00000000FC000002L});
    public static final BitSet FOLLOW_mult_in_add476 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_32_in_add480 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_33_in_add485 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_mult_in_add489 = new BitSet(new long[]{0x0000000300000002L});
    public static final BitSet FOLLOW_unary_in_mult506 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_34_in_mult510 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_35_in_mult515 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_unary_in_mult519 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_32_in_unary537 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_negation_in_unary542 = new BitSet(new long[]{0x0000000301002440L});
    public static final BitSet FOLLOW_arithmeticTerm_in_unary547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_negation562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_ee691 = new BitSet(new long[]{0x0000007000003002L});
    public static final BitSet FOLLOW_NOTNEWLINE_in_ee699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_ee703 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_36_in_ee708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ee712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ee716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_ws789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NL_in_nl795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred5_setloopvarinserts131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred6_setloopvarinserts137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred7_setloopvarinserts144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred9_setloopvarinserts150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nl_in_synpred10_setloopvarinserts154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred17_setloopvarinserts252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameExprTerm_in_synpred20_setloopvarinserts285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_synpred22_setloopvarinserts309 = new BitSet(new long[]{0x0000000000002200L});
    public static final BitSet FOLLOW_simpleExpr_in_synpred22_setloopvarinserts312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred27_setloopvarinserts384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ws_in_synpred30_setloopvarinserts406 = new BitSet(new long[]{0x0000000000000002L});

}