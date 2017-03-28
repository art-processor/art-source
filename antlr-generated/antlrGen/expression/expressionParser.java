// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g 2017-03-28 11:47:33

  package antlrGen.expression;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class expressionParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATION", "DEFINED", "ARTVARCHAR", "DEBUGMODECOMMAND", "STRING", "EPRESSIONCHAR", "REFERENCECHAR", "IDENT", "INTEGER", "ISLAST", "ISFIRST", "SIZE", "ISNUMERIC", "ULCAP", "LLCAP", "DEBUGMODE", "CURRENTFILE", "OUTFILE", "DEFAULTOUTPUT", "OUTDIR", "COMMANDCHAR", "COMMENTCHAR", "NOTNEWLINE", "WS", "NL", "COMMENT", "DIGIT", "SPECCHAR", "LETTER", "ANYCHAR", "'&&'", "'||'", "'('", "')'", "'true'", "'false'", "'=='", "'!='", "'<'", "'<='", "'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'defined'", "'$'"
    };
    public static final int COMMANDCHAR=24;
    public static final int LETTER=32;
    public static final int SPECCHAR=31;
    public static final int EOF=-1;
    public static final int T__51=51;
    public static final int ARTVARCHAR=6;
    public static final int ANYCHAR=33;
    public static final int IDENT=11;
    public static final int LLCAP=18;
    public static final int OUTFILE=21;
    public static final int DIGIT=30;
    public static final int NL=28;
    public static final int COMMENT=29;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int INTEGER=12;
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
    public static final int CURRENTFILE=20;
    public static final int OUTDIR=23;
    public static final int NOTNEWLINE=26;
    public static final int ISLAST=13;
    public static final int SIZE=15;
    public static final int STRING=8;

    // delegates
    // delegators


        public expressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public expressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return expressionParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g"; }


    public static class evaluator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "evaluator"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:25:1: evaluator : ( stringExpression | freeExpression | STRING )* ;
    public final expressionParser.evaluator_return evaluator() throws RecognitionException {
        expressionParser.evaluator_return retval = new expressionParser.evaluator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING3=null;
        expressionParser.stringExpression_return stringExpression1 = null;

        expressionParser.freeExpression_return freeExpression2 = null;


        CommonTree STRING3_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:26:3: ( ( stringExpression | freeExpression | STRING )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:3: ( stringExpression | freeExpression | STRING )*
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:3: ( stringExpression | freeExpression | STRING )*
            loop1:
            do {
                int alt1=4;
                switch ( input.LA(1) ) {
                case STRING:
                    {
                    int LA1_2 = input.LA(2);

                    if ( (synpred1_expression()) ) {
                        alt1=1;
                    }
                    else if ( (synpred3_expression()) ) {
                        alt1=3;
                    }


                    }
                    break;
                case EPRESSIONCHAR:
                    {
                    alt1=1;
                    }
                    break;
                case IDENT:
                case INTEGER:
                case 36:
                case 38:
                case 39:
                case 46:
                case 47:
                case 50:
                case 51:
                    {
                    alt1=2;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:4: stringExpression
            	    {
            	    pushFollow(FOLLOW_stringExpression_in_evaluator98);
            	    stringExpression1=stringExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, stringExpression1.getTree());

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:28:5: freeExpression
            	    {
            	    pushFollow(FOLLOW_freeExpression_in_evaluator105);
            	    freeExpression2=freeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression2.getTree());

            	    }
            	    break;
            	case 3 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:29:5: STRING
            	    {
            	    STRING3=(Token)match(input,STRING,FOLLOW_STRING_in_evaluator111); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    STRING3_tree = (CommonTree)adaptor.create(STRING3);
            	    adaptor.addChild(root_0, STRING3_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
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
    // $ANTLR end "evaluator"

    public static class expression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "expression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:34:1: expression : ( freeExpression | stringExpression );
    public final expressionParser.expression_return expression() throws RecognitionException {
        expressionParser.expression_return retval = new expressionParser.expression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        expressionParser.freeExpression_return freeExpression4 = null;

        expressionParser.stringExpression_return stringExpression5 = null;



        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:35:3: ( freeExpression | stringExpression )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=IDENT && LA2_0<=INTEGER)||LA2_0==36||(LA2_0>=38 && LA2_0<=39)||(LA2_0>=46 && LA2_0<=47)||(LA2_0>=50 && LA2_0<=51)) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=STRING && LA2_0<=EPRESSIONCHAR)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:35:5: freeExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_freeExpression_in_expression135);
                    freeExpression4=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression4.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:36:5: stringExpression
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_stringExpression_in_expression141);
                    stringExpression5=stringExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, stringExpression5.getTree());

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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:39:1: stringExpression : ( ( STRING )* ( nameExpression )+ ( STRING )* )+ ;
    public final expressionParser.stringExpression_return stringExpression() throws RecognitionException {
        expressionParser.stringExpression_return retval = new expressionParser.stringExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token STRING6=null;
        Token STRING8=null;
        expressionParser.nameExpression_return nameExpression7 = null;


        CommonTree STRING6_tree=null;
        CommonTree STRING8_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:3: ( ( ( STRING )* ( nameExpression )+ ( STRING )* )+ )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:5: ( ( STRING )* ( nameExpression )+ ( STRING )* )+
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:5: ( ( STRING )* ( nameExpression )+ ( STRING )* )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==STRING) ) {
                    int LA6_2 = input.LA(2);

                    if ( (synpred8_expression()) ) {
                        alt6=1;
                    }


                }
                else if ( (LA6_0==EPRESSIONCHAR) ) {
                    int LA6_3 = input.LA(2);

                    if ( (synpred8_expression()) ) {
                        alt6=1;
                    }


                }


                switch (alt6) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:6: ( STRING )* ( nameExpression )+ ( STRING )*
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:6: ( STRING )*
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==STRING) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: STRING
            	    	    {
            	    	    STRING6=(Token)match(input,STRING,FOLLOW_STRING_in_stringExpression157); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    STRING6_tree = (CommonTree)adaptor.create(STRING6);
            	    	    adaptor.addChild(root_0, STRING6_tree);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop3;
            	        }
            	    } while (true);

            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:14: ( nameExpression )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==EPRESSIONCHAR) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( (synpred6_expression()) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: nameExpression
            	    	    {
            	    	    pushFollow(FOLLOW_nameExpression_in_stringExpression160);
            	    	    nameExpression7=nameExpression();

            	    	    state._fsp--;
            	    	    if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameExpression7.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	    	    if (state.backtracking>0) {state.failed=true; return retval;}
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:30: ( STRING )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==STRING) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( (synpred7_expression()) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: STRING
            	    	    {
            	    	    STRING8=(Token)match(input,STRING,FOLLOW_STRING_in_stringExpression163); if (state.failed) return retval;
            	    	    if ( state.backtracking==0 ) {
            	    	    STRING8_tree = (CommonTree)adaptor.create(STRING8);
            	    	    adaptor.addChild(root_0, STRING8_tree);
            	    	    }

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:43:1: nameExpression : ( EPRESSIONCHAR simpleExpr EPRESSIONCHAR | EPRESSIONCHAR freeExpression ( EPRESSIONCHAR )+ );
    public final expressionParser.nameExpression_return nameExpression() throws RecognitionException {
        expressionParser.nameExpression_return retval = new expressionParser.nameExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token EPRESSIONCHAR9=null;
        Token EPRESSIONCHAR11=null;
        Token EPRESSIONCHAR12=null;
        Token EPRESSIONCHAR14=null;
        expressionParser.simpleExpr_return simpleExpr10 = null;

        expressionParser.freeExpression_return freeExpression13 = null;


        CommonTree EPRESSIONCHAR9_tree=null;
        CommonTree EPRESSIONCHAR11_tree=null;
        CommonTree EPRESSIONCHAR12_tree=null;
        CommonTree EPRESSIONCHAR14_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:44:3: ( EPRESSIONCHAR simpleExpr EPRESSIONCHAR | EPRESSIONCHAR freeExpression ( EPRESSIONCHAR )+ )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==EPRESSIONCHAR) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==REFERENCECHAR) ) {
                    alt8=1;
                }
                else if ( ((LA8_1>=IDENT && LA8_1<=INTEGER)||LA8_1==36||(LA8_1>=38 && LA8_1<=39)||(LA8_1>=46 && LA8_1<=47)||(LA8_1>=50 && LA8_1<=51)) ) {
                    alt8=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:44:5: EPRESSIONCHAR simpleExpr EPRESSIONCHAR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EPRESSIONCHAR9=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression181); if (state.failed) return retval;
                    pushFollow(FOLLOW_simpleExpr_in_nameExpression184);
                    simpleExpr10=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(simpleExpr10.getTree(), root_0);
                    EPRESSIONCHAR11=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression187); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:45:5: EPRESSIONCHAR freeExpression ( EPRESSIONCHAR )+
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    EPRESSIONCHAR12=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression194); if (state.failed) return retval;
                    pushFollow(FOLLOW_freeExpression_in_nameExpression197);
                    freeExpression13=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression13.getTree());
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:45:48: ( EPRESSIONCHAR )+
                    int cnt7=0;
                    loop7:
                    do {
                        int alt7=2;
                        alt7 = dfa7.predict(input);
                        switch (alt7) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: EPRESSIONCHAR
                    	    {
                    	    EPRESSIONCHAR14=(Token)match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_nameExpression199); if (state.failed) return retval;

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt7 >= 1 ) break loop7;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(7, input);
                                throw eee;
                        }
                        cnt7++;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:49:1: simpleExpr : REFERENCECHAR ( nameExprTerm )* ;
    public final expressionParser.simpleExpr_return simpleExpr() throws RecognitionException {
        expressionParser.simpleExpr_return retval = new expressionParser.simpleExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token REFERENCECHAR15=null;
        expressionParser.nameExprTerm_return nameExprTerm16 = null;


        CommonTree REFERENCECHAR15_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:50:3: ( REFERENCECHAR ( nameExprTerm )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:50:5: REFERENCECHAR ( nameExprTerm )*
            {
            root_0 = (CommonTree)adaptor.nil();

            REFERENCECHAR15=(Token)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_simpleExpr219); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            REFERENCECHAR15_tree = (CommonTree)adaptor.create(REFERENCECHAR15);
            root_0 = (CommonTree)adaptor.becomeRoot(REFERENCECHAR15_tree, root_0);
            }
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:50:20: ( nameExprTerm )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==IDENT) ) {
                    int LA9_2 = input.LA(2);

                    if ( (synpred11_expression()) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==REFERENCECHAR) ) {
                    int LA9_3 = input.LA(2);

                    if ( (synpred11_expression()) ) {
                        alt9=1;
                    }


                }


                switch (alt9) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: nameExprTerm
            	    {
            	    pushFollow(FOLLOW_nameExprTerm_in_simpleExpr222);
            	    nameExprTerm16=nameExprTerm();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, nameExprTerm16.getTree());

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:53:1: nameExprTerm : ( IDENT | REFERENCECHAR simpleExpr | simpleExpr ) ;
    public final expressionParser.nameExprTerm_return nameExprTerm() throws RecognitionException {
        expressionParser.nameExprTerm_return retval = new expressionParser.nameExprTerm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT17=null;
        Token REFERENCECHAR18=null;
        expressionParser.simpleExpr_return simpleExpr19 = null;

        expressionParser.simpleExpr_return simpleExpr20 = null;


        CommonTree IDENT17_tree=null;
        CommonTree REFERENCECHAR18_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:54:3: ( ( IDENT | REFERENCECHAR simpleExpr | simpleExpr ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:54:5: ( IDENT | REFERENCECHAR simpleExpr | simpleExpr )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:54:5: ( IDENT | REFERENCECHAR simpleExpr | simpleExpr )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==IDENT) ) {
                alt10=1;
            }
            else if ( (LA10_0==REFERENCECHAR) ) {
                int LA10_2 = input.LA(2);

                if ( (LA10_2==REFERENCECHAR) ) {
                    int LA10_3 = input.LA(3);

                    if ( (synpred13_expression()) ) {
                        alt10=2;
                    }
                    else if ( (true) ) {
                        alt10=3;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 3, input);

                        throw nvae;
                    }
                }
                else if ( (LA10_2==EOF||LA10_2==EPRESSIONCHAR||LA10_2==IDENT) ) {
                    alt10=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:54:6: IDENT
                    {
                    IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_nameExprTerm240); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT17_tree = (CommonTree)adaptor.create(IDENT17);
                    adaptor.addChild(root_0, IDENT17_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:55:5: REFERENCECHAR simpleExpr
                    {
                    REFERENCECHAR18=(Token)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_nameExprTerm246); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    REFERENCECHAR18_tree = (CommonTree)adaptor.create(REFERENCECHAR18);
                    root_0 = (CommonTree)adaptor.becomeRoot(REFERENCECHAR18_tree, root_0);
                    }
                    pushFollow(FOLLOW_simpleExpr_in_nameExprTerm249);
                    simpleExpr19=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr19.getTree());

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:56:5: simpleExpr
                    {
                    pushFollow(FOLLOW_simpleExpr_in_nameExprTerm255);
                    simpleExpr20=simpleExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, simpleExpr20.getTree());

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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:60:1: freeExpression : (r1= relation ( ( '&&' | '||' ) r2= relation )* ) ;
    public final expressionParser.freeExpression_return freeExpression() throws RecognitionException {
        expressionParser.freeExpression_return retval = new expressionParser.freeExpression_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal21=null;
        Token string_literal22=null;
        expressionParser.relation_return r1 = null;

        expressionParser.relation_return r2 = null;


        CommonTree string_literal21_tree=null;
        CommonTree string_literal22_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:3: ( (r1= relation ( ( '&&' | '||' ) r2= relation )* ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:5: (r1= relation ( ( '&&' | '||' ) r2= relation )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:5: (r1= relation ( ( '&&' | '||' ) r2= relation )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:7: r1= relation ( ( '&&' | '||' ) r2= relation )*
            {
            pushFollow(FOLLOW_relation_in_freeExpression276);
            r1=relation();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, r1.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:20: ( ( '&&' | '||' ) r2= relation )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=34 && LA12_0<=35)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:21: ( '&&' | '||' ) r2= relation
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:21: ( '&&' | '||' )
            	    int alt11=2;
            	    int LA11_0 = input.LA(1);

            	    if ( (LA11_0==34) ) {
            	        alt11=1;
            	    }
            	    else if ( (LA11_0==35) ) {
            	        alt11=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 11, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt11) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:22: '&&'
            	            {
            	            string_literal21=(Token)match(input,34,FOLLOW_34_in_freeExpression281); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal21_tree = (CommonTree)adaptor.create(string_literal21);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal21_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:61:30: '||'
            	            {
            	            string_literal22=(Token)match(input,35,FOLLOW_35_in_freeExpression286); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relation_in_freeExpression292);
            	    r2=relation();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, r2.getTree());

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


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
    // $ANTLR end "freeExpression"

    public static class arithmeticTerm_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arithmeticTerm"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:68:1: arithmeticTerm : ( IDENT | '(' freeExpression ')' | ( 'true' | 'false' ) | INTEGER ) ;
    public final expressionParser.arithmeticTerm_return arithmeticTerm() throws RecognitionException {
        expressionParser.arithmeticTerm_return retval = new expressionParser.arithmeticTerm_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IDENT23=null;
        Token char_literal24=null;
        Token char_literal26=null;
        Token set27=null;
        Token INTEGER28=null;
        expressionParser.freeExpression_return freeExpression25 = null;


        CommonTree IDENT23_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree set27_tree=null;
        CommonTree INTEGER28_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:69:5: ( ( IDENT | '(' freeExpression ')' | ( 'true' | 'false' ) | INTEGER ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:69:7: ( IDENT | '(' freeExpression ')' | ( 'true' | 'false' ) | INTEGER )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:69:7: ( IDENT | '(' freeExpression ')' | ( 'true' | 'false' ) | INTEGER )
            int alt13=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt13=1;
                }
                break;
            case 36:
                {
                alt13=2;
                }
                break;
            case 38:
            case 39:
                {
                alt13=3;
                }
                break;
            case INTEGER:
                {
                alt13=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:69:8: IDENT
                    {
                    IDENT23=(Token)match(input,IDENT,FOLLOW_IDENT_in_arithmeticTerm315); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENT23_tree = (CommonTree)adaptor.create(IDENT23);
                    adaptor.addChild(root_0, IDENT23_tree);
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:70:7: '(' freeExpression ')'
                    {
                    char_literal24=(Token)match(input,36,FOLLOW_36_in_arithmeticTerm323); if (state.failed) return retval;
                    pushFollow(FOLLOW_freeExpression_in_arithmeticTerm326);
                    freeExpression25=freeExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, freeExpression25.getTree());
                    char_literal26=(Token)match(input,37,FOLLOW_37_in_arithmeticTerm328); if (state.failed) return retval;

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:71:7: ( 'true' | 'false' )
                    {
                    set27=(Token)input.LT(1);
                    if ( (input.LA(1)>=38 && input.LA(1)<=39) ) {
                        input.consume();
                        if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set27));
                        state.errorRecovery=false;state.failed=false;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:72:7: INTEGER
                    {
                    INTEGER28=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_arithmeticTerm351); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    INTEGER28_tree = (CommonTree)adaptor.create(INTEGER28);
                    adaptor.addChild(root_0, INTEGER28_tree);
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
    // $ANTLR end "arithmeticTerm"

    public static class relation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relation"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:75:1: relation : ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* ) ;
    public final expressionParser.relation_return relation() throws RecognitionException {
        expressionParser.relation_return retval = new expressionParser.relation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal30=null;
        Token string_literal31=null;
        Token char_literal32=null;
        Token string_literal33=null;
        Token string_literal34=null;
        Token char_literal35=null;
        expressionParser.add_return add29 = null;

        expressionParser.add_return add36 = null;


        CommonTree string_literal30_tree=null;
        CommonTree string_literal31_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree string_literal33_tree=null;
        CommonTree string_literal34_tree=null;
        CommonTree char_literal35_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:3: ( ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:5: ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* )
            {
            root_0 = (CommonTree)adaptor.nil();

            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:5: ( add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:6: add ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )*
            {
            pushFollow(FOLLOW_add_in_relation374);
            add29=add();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, add29.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:10: ( ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=40 && LA15_0<=45)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:11: ( '==' | '!=' | '<' | '<=' | '>=' | '>' ) add
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:11: ( '==' | '!=' | '<' | '<=' | '>=' | '>' )
            	    int alt14=6;
            	    switch ( input.LA(1) ) {
            	    case 40:
            	        {
            	        alt14=1;
            	        }
            	        break;
            	    case 41:
            	        {
            	        alt14=2;
            	        }
            	        break;
            	    case 42:
            	        {
            	        alt14=3;
            	        }
            	        break;
            	    case 43:
            	        {
            	        alt14=4;
            	        }
            	        break;
            	    case 44:
            	        {
            	        alt14=5;
            	        }
            	        break;
            	    case 45:
            	        {
            	        alt14=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt14) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:12: '=='
            	            {
            	            string_literal30=(Token)match(input,40,FOLLOW_40_in_relation378); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal30_tree = (CommonTree)adaptor.create(string_literal30);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal30_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:20: '!='
            	            {
            	            string_literal31=(Token)match(input,41,FOLLOW_41_in_relation383); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal31_tree = (CommonTree)adaptor.create(string_literal31);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal31_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:28: '<'
            	            {
            	            char_literal32=(Token)match(input,42,FOLLOW_42_in_relation388); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal32_tree = (CommonTree)adaptor.create(char_literal32);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal32_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:35: '<='
            	            {
            	            string_literal33=(Token)match(input,43,FOLLOW_43_in_relation393); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal33_tree = (CommonTree)adaptor.create(string_literal33);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal33_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:43: '>='
            	            {
            	            string_literal34=(Token)match(input,44,FOLLOW_44_in_relation398); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            string_literal34_tree = (CommonTree)adaptor.create(string_literal34);
            	            root_0 = (CommonTree)adaptor.becomeRoot(string_literal34_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:76:51: '>'
            	            {
            	            char_literal35=(Token)match(input,45,FOLLOW_45_in_relation403); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal35_tree = (CommonTree)adaptor.create(char_literal35);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal35_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_add_in_relation407);
            	    add36=add();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, add36.getTree());

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


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
    // $ANTLR end "relation"

    public static class add_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "add"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:79:1: add : mult ( ( '+' | '-' ) mult )* ;
    public final expressionParser.add_return add() throws RecognitionException {
        expressionParser.add_return retval = new expressionParser.add_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal38=null;
        Token char_literal39=null;
        expressionParser.mult_return mult37 = null;

        expressionParser.mult_return mult40 = null;


        CommonTree char_literal38_tree=null;
        CommonTree char_literal39_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:3: ( mult ( ( '+' | '-' ) mult )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:5: mult ( ( '+' | '-' ) mult )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_mult_in_add424);
            mult37=mult();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, mult37.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:10: ( ( '+' | '-' ) mult )*
            loop17:
            do {
                int alt17=2;
                alt17 = dfa17.predict(input);
                switch (alt17) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:11: ( '+' | '-' ) mult
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:11: ( '+' | '-' )
            	    int alt16=2;
            	    int LA16_0 = input.LA(1);

            	    if ( (LA16_0==46) ) {
            	        alt16=1;
            	    }
            	    else if ( (LA16_0==47) ) {
            	        alt16=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 16, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt16) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:12: '+'
            	            {
            	            char_literal38=(Token)match(input,46,FOLLOW_46_in_add428); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal38_tree = (CommonTree)adaptor.create(char_literal38);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal38_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:19: '-'
            	            {
            	            char_literal39=(Token)match(input,47,FOLLOW_47_in_add433); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal39_tree = (CommonTree)adaptor.create(char_literal39);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal39_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mult_in_add437);
            	    mult40=mult();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, mult40.getTree());

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
    // $ANTLR end "add"

    public static class mult_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mult"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:83:1: mult : unary ( ( '*' | '/' ) unary )* ;
    public final expressionParser.mult_return mult() throws RecognitionException {
        expressionParser.mult_return retval = new expressionParser.mult_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal42=null;
        Token char_literal43=null;
        expressionParser.unary_return unary41 = null;

        expressionParser.unary_return unary44 = null;


        CommonTree char_literal42_tree=null;
        CommonTree char_literal43_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:3: ( unary ( ( '*' | '/' ) unary )* )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:5: unary ( ( '*' | '/' ) unary )*
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_unary_in_mult454);
            unary41=unary();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unary41.getTree());
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:11: ( ( '*' | '/' ) unary )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=48 && LA19_0<=49)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:12: ( '*' | '/' ) unary
            	    {
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:12: ( '*' | '/' )
            	    int alt18=2;
            	    int LA18_0 = input.LA(1);

            	    if ( (LA18_0==48) ) {
            	        alt18=1;
            	    }
            	    else if ( (LA18_0==49) ) {
            	        alt18=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 18, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt18) {
            	        case 1 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:13: '*'
            	            {
            	            char_literal42=(Token)match(input,48,FOLLOW_48_in_mult458); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal42_tree = (CommonTree)adaptor.create(char_literal42);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal42_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:84:20: '/'
            	            {
            	            char_literal43=(Token)match(input,49,FOLLOW_49_in_mult463); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            char_literal43_tree = (CommonTree)adaptor.create(char_literal43);
            	            root_0 = (CommonTree)adaptor.becomeRoot(char_literal43_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unary_in_mult467);
            	    unary44=unary();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unary44.getTree());

            	    }
            	    break;

            	default :
            	    break loop19;
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
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:87:1: unary : ( ( '+' | negation )* arithmeticTerm | defined arithmeticTerm | bpv );
    public final expressionParser.unary_return unary() throws RecognitionException {
        expressionParser.unary_return retval = new expressionParser.unary_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal45=null;
        expressionParser.negation_return negation46 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm47 = null;

        expressionParser.defined_return defined48 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm49 = null;

        expressionParser.bpv_return bpv50 = null;


        CommonTree char_literal45_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:88:3: ( ( '+' | negation )* arithmeticTerm | defined arithmeticTerm | bpv )
            int alt21=3;
            switch ( input.LA(1) ) {
            case IDENT:
            case INTEGER:
            case 36:
            case 38:
            case 39:
            case 46:
            case 47:
                {
                alt21=1;
                }
                break;
            case 50:
                {
                alt21=2;
                }
                break;
            case 51:
                {
                alt21=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:88:5: ( '+' | negation )* arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:88:5: ( '+' | negation )*
                    loop20:
                    do {
                        int alt20=3;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==46) ) {
                            alt20=1;
                        }
                        else if ( (LA20_0==47) ) {
                            alt20=2;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:88:6: '+'
                    	    {
                    	    char_literal45=(Token)match(input,46,FOLLOW_46_in_unary485); if (state.failed) return retval;

                    	    }
                    	    break;
                    	case 2 :
                    	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:88:13: negation
                    	    {
                    	    pushFollow(FOLLOW_negation_in_unary490);
                    	    negation46=negation();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(negation46.getTree(), root_0);

                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    pushFollow(FOLLOW_arithmeticTerm_in_unary495);
                    arithmeticTerm47=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm47.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:89:5: defined arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_defined_in_unary501);
                    defined48=defined();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(defined48.getTree(), root_0);
                    pushFollow(FOLLOW_arithmeticTerm_in_unary504);
                    arithmeticTerm49=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm49.getTree());

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:90:5: bpv
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_bpv_in_unary510);
                    bpv50=bpv();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, bpv50.getTree());

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
    // $ANTLR end "unary"

    public static class negation_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "negation"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:93:1: negation : '-' -> NEGATION ;
    public final expressionParser.negation_return negation() throws RecognitionException {
        expressionParser.negation_return retval = new expressionParser.negation_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal51=null;

        CommonTree char_literal51_tree=null;
        RewriteRuleTokenStream stream_47=new RewriteRuleTokenStream(adaptor,"token 47");

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:94:3: ( '-' -> NEGATION )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:94:5: '-'
            {
            char_literal51=(Token)match(input,47,FOLLOW_47_in_negation523); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_47.add(char_literal51);



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
            // 94:9: -> NEGATION
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

    public static class defined_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "defined"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:97:1: defined : 'defined' -> DEFINED ;
    public final expressionParser.defined_return defined() throws RecognitionException {
        expressionParser.defined_return retval = new expressionParser.defined_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal52=null;

        CommonTree string_literal52_tree=null;
        RewriteRuleTokenStream stream_50=new RewriteRuleTokenStream(adaptor,"token 50");

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:98:3: ( 'defined' -> DEFINED )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:98:5: 'defined'
            {
            string_literal52=(Token)match(input,50,FOLLOW_50_in_defined542); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_50.add(string_literal52);



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
            // 98:15: -> DEFINED
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(DEFINED, "DEFINED"));

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
    // $ANTLR end "defined"

    public static class artvarchar_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "artvarchar"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:101:1: artvarchar : '$' -> ARTVARCHAR ;
    public final expressionParser.artvarchar_return artvarchar() throws RecognitionException {
        expressionParser.artvarchar_return retval = new expressionParser.artvarchar_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal53=null;

        CommonTree char_literal53_tree=null;
        RewriteRuleTokenStream stream_51=new RewriteRuleTokenStream(adaptor,"token 51");

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:102:3: ( '$' -> ARTVARCHAR )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:102:5: '$'
            {
            char_literal53=(Token)match(input,51,FOLLOW_51_in_artvarchar561); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_51.add(char_literal53);



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
            // 102:9: -> ARTVARCHAR
            {
                adaptor.addChild(root_0, (CommonTree)adaptor.create(ARTVARCHAR, "ARTVARCHAR"));

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
    // $ANTLR end "artvarchar"

    public static class bpv_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "bpv"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:110:1: bpv : ( artvarchar ISLAST arithmeticTerm | artvarchar ISFIRST arithmeticTerm | artvarchar SIZE arithmeticTerm | artvarchar ISNUMERIC arithmeticTerm | artvarchar ULCAP arithmeticTerm | artvarchar LLCAP arithmeticTerm | artvarchar DEBUGMODE | artvarchar CURRENTFILE | artvarchar OUTFILE | artvarchar DEFAULTOUTPUT | artvarchar OUTDIR );
    public final expressionParser.bpv_return bpv() throws RecognitionException {
        expressionParser.bpv_return retval = new expressionParser.bpv_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ISLAST55=null;
        Token ISFIRST58=null;
        Token SIZE61=null;
        Token ISNUMERIC64=null;
        Token ULCAP67=null;
        Token LLCAP70=null;
        Token DEBUGMODE73=null;
        Token CURRENTFILE75=null;
        Token OUTFILE77=null;
        Token DEFAULTOUTPUT79=null;
        Token OUTDIR81=null;
        expressionParser.artvarchar_return artvarchar54 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm56 = null;

        expressionParser.artvarchar_return artvarchar57 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm59 = null;

        expressionParser.artvarchar_return artvarchar60 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm62 = null;

        expressionParser.artvarchar_return artvarchar63 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm65 = null;

        expressionParser.artvarchar_return artvarchar66 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm68 = null;

        expressionParser.artvarchar_return artvarchar69 = null;

        expressionParser.arithmeticTerm_return arithmeticTerm71 = null;

        expressionParser.artvarchar_return artvarchar72 = null;

        expressionParser.artvarchar_return artvarchar74 = null;

        expressionParser.artvarchar_return artvarchar76 = null;

        expressionParser.artvarchar_return artvarchar78 = null;

        expressionParser.artvarchar_return artvarchar80 = null;


        CommonTree ISLAST55_tree=null;
        CommonTree ISFIRST58_tree=null;
        CommonTree SIZE61_tree=null;
        CommonTree ISNUMERIC64_tree=null;
        CommonTree ULCAP67_tree=null;
        CommonTree LLCAP70_tree=null;
        CommonTree DEBUGMODE73_tree=null;
        CommonTree CURRENTFILE75_tree=null;
        CommonTree OUTFILE77_tree=null;
        CommonTree DEFAULTOUTPUT79_tree=null;
        CommonTree OUTDIR81_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:111:3: ( artvarchar ISLAST arithmeticTerm | artvarchar ISFIRST arithmeticTerm | artvarchar SIZE arithmeticTerm | artvarchar ISNUMERIC arithmeticTerm | artvarchar ULCAP arithmeticTerm | artvarchar LLCAP arithmeticTerm | artvarchar DEBUGMODE | artvarchar CURRENTFILE | artvarchar OUTFILE | artvarchar DEFAULTOUTPUT | artvarchar OUTDIR )
            int alt22=11;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:111:5: artvarchar ISLAST arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv588);
                    artvarchar54=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar54.getTree(), root_0);
                    ISLAST55=(Token)match(input,ISLAST,FOLLOW_ISLAST_in_bpv591); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ISLAST55_tree = (CommonTree)adaptor.create(ISLAST55);
                    adaptor.addChild(root_0, ISLAST55_tree);
                    }
                    pushFollow(FOLLOW_arithmeticTerm_in_bpv593);
                    arithmeticTerm56=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm56.getTree());

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:112:5: artvarchar ISFIRST arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv599);
                    artvarchar57=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar57.getTree(), root_0);
                    ISFIRST58=(Token)match(input,ISFIRST,FOLLOW_ISFIRST_in_bpv602); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ISFIRST58_tree = (CommonTree)adaptor.create(ISFIRST58);
                    adaptor.addChild(root_0, ISFIRST58_tree);
                    }
                    pushFollow(FOLLOW_arithmeticTerm_in_bpv604);
                    arithmeticTerm59=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm59.getTree());

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:113:5: artvarchar SIZE arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv610);
                    artvarchar60=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar60.getTree(), root_0);
                    SIZE61=(Token)match(input,SIZE,FOLLOW_SIZE_in_bpv613); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SIZE61_tree = (CommonTree)adaptor.create(SIZE61);
                    adaptor.addChild(root_0, SIZE61_tree);
                    }
                    pushFollow(FOLLOW_arithmeticTerm_in_bpv615);
                    arithmeticTerm62=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm62.getTree());

                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:114:5: artvarchar ISNUMERIC arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv621);
                    artvarchar63=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar63.getTree(), root_0);
                    ISNUMERIC64=(Token)match(input,ISNUMERIC,FOLLOW_ISNUMERIC_in_bpv624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ISNUMERIC64_tree = (CommonTree)adaptor.create(ISNUMERIC64);
                    adaptor.addChild(root_0, ISNUMERIC64_tree);
                    }
                    pushFollow(FOLLOW_arithmeticTerm_in_bpv626);
                    arithmeticTerm65=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm65.getTree());

                    }
                    break;
                case 5 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:115:5: artvarchar ULCAP arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv632);
                    artvarchar66=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar66.getTree(), root_0);
                    ULCAP67=(Token)match(input,ULCAP,FOLLOW_ULCAP_in_bpv635); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ULCAP67_tree = (CommonTree)adaptor.create(ULCAP67);
                    adaptor.addChild(root_0, ULCAP67_tree);
                    }
                    pushFollow(FOLLOW_arithmeticTerm_in_bpv637);
                    arithmeticTerm68=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm68.getTree());

                    }
                    break;
                case 6 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:116:5: artvarchar LLCAP arithmeticTerm
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv643);
                    artvarchar69=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar69.getTree(), root_0);
                    LLCAP70=(Token)match(input,LLCAP,FOLLOW_LLCAP_in_bpv646); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LLCAP70_tree = (CommonTree)adaptor.create(LLCAP70);
                    adaptor.addChild(root_0, LLCAP70_tree);
                    }
                    pushFollow(FOLLOW_arithmeticTerm_in_bpv648);
                    arithmeticTerm71=arithmeticTerm();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arithmeticTerm71.getTree());

                    }
                    break;
                case 7 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:117:5: artvarchar DEBUGMODE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv654);
                    artvarchar72=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar72.getTree(), root_0);
                    DEBUGMODE73=(Token)match(input,DEBUGMODE,FOLLOW_DEBUGMODE_in_bpv657); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEBUGMODE73_tree = (CommonTree)adaptor.create(DEBUGMODE73);
                    adaptor.addChild(root_0, DEBUGMODE73_tree);
                    }

                    }
                    break;
                case 8 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:118:5: artvarchar CURRENTFILE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv663);
                    artvarchar74=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar74.getTree(), root_0);
                    CURRENTFILE75=(Token)match(input,CURRENTFILE,FOLLOW_CURRENTFILE_in_bpv666); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CURRENTFILE75_tree = (CommonTree)adaptor.create(CURRENTFILE75);
                    adaptor.addChild(root_0, CURRENTFILE75_tree);
                    }

                    }
                    break;
                case 9 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:119:5: artvarchar OUTFILE
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv672);
                    artvarchar76=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar76.getTree(), root_0);
                    OUTFILE77=(Token)match(input,OUTFILE,FOLLOW_OUTFILE_in_bpv675); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTFILE77_tree = (CommonTree)adaptor.create(OUTFILE77);
                    adaptor.addChild(root_0, OUTFILE77_tree);
                    }

                    }
                    break;
                case 10 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:120:5: artvarchar DEFAULTOUTPUT
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv681);
                    artvarchar78=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar78.getTree(), root_0);
                    DEFAULTOUTPUT79=(Token)match(input,DEFAULTOUTPUT,FOLLOW_DEFAULTOUTPUT_in_bpv684); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    DEFAULTOUTPUT79_tree = (CommonTree)adaptor.create(DEFAULTOUTPUT79);
                    adaptor.addChild(root_0, DEFAULTOUTPUT79_tree);
                    }

                    }
                    break;
                case 11 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:121:5: artvarchar OUTDIR
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_artvarchar_in_bpv690);
                    artvarchar80=artvarchar();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) root_0 = (CommonTree)adaptor.becomeRoot(artvarchar80.getTree(), root_0);
                    OUTDIR81=(Token)match(input,OUTDIR,FOLLOW_OUTDIR_in_bpv693); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    OUTDIR81_tree = (CommonTree)adaptor.create(OUTDIR81);
                    adaptor.addChild(root_0, OUTDIR81_tree);
                    }

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
    // $ANTLR end "bpv"

    public static class islast_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "islast"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:142:1: islast : ISLAST '(' IDENT ')' ;
    public final expressionParser.islast_return islast() throws RecognitionException {
        expressionParser.islast_return retval = new expressionParser.islast_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ISLAST82=null;
        Token char_literal83=null;
        Token IDENT84=null;
        Token char_literal85=null;

        CommonTree ISLAST82_tree=null;
        CommonTree char_literal83_tree=null;
        CommonTree IDENT84_tree=null;
        CommonTree char_literal85_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:142:7: ( ISLAST '(' IDENT ')' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:142:9: ISLAST '(' IDENT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            ISLAST82=(Token)match(input,ISLAST,FOLLOW_ISLAST_in_islast792); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ISLAST82_tree = (CommonTree)adaptor.create(ISLAST82);
            adaptor.addChild(root_0, ISLAST82_tree);
            }
            char_literal83=(Token)match(input,36,FOLLOW_36_in_islast794); if (state.failed) return retval;
            IDENT84=(Token)match(input,IDENT,FOLLOW_IDENT_in_islast797); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENT84_tree = (CommonTree)adaptor.create(IDENT84);
            adaptor.addChild(root_0, IDENT84_tree);
            }
            char_literal85=(Token)match(input,37,FOLLOW_37_in_islast799); if (state.failed) return retval;

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
    // $ANTLR end "islast"

    public static class isfirst_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "isfirst"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:143:1: isfirst : ISFIRST '(' IDENT ')' ;
    public final expressionParser.isfirst_return isfirst() throws RecognitionException {
        expressionParser.isfirst_return retval = new expressionParser.isfirst_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ISFIRST86=null;
        Token char_literal87=null;
        Token IDENT88=null;
        Token char_literal89=null;

        CommonTree ISFIRST86_tree=null;
        CommonTree char_literal87_tree=null;
        CommonTree IDENT88_tree=null;
        CommonTree char_literal89_tree=null;

        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:143:8: ( ISFIRST '(' IDENT ')' )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:143:10: ISFIRST '(' IDENT ')'
            {
            root_0 = (CommonTree)adaptor.nil();

            ISFIRST86=(Token)match(input,ISFIRST,FOLLOW_ISFIRST_in_isfirst806); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            ISFIRST86_tree = (CommonTree)adaptor.create(ISFIRST86);
            adaptor.addChild(root_0, ISFIRST86_tree);
            }
            char_literal87=(Token)match(input,36,FOLLOW_36_in_isfirst808); if (state.failed) return retval;
            IDENT88=(Token)match(input,IDENT,FOLLOW_IDENT_in_isfirst811); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENT88_tree = (CommonTree)adaptor.create(IDENT88);
            adaptor.addChild(root_0, IDENT88_tree);
            }
            char_literal89=(Token)match(input,37,FOLLOW_37_in_isfirst813); if (state.failed) return retval;

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
    // $ANTLR end "isfirst"

    // $ANTLR start synpred1_expression
    public final void synpred1_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:4: ( stringExpression )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:27:4: stringExpression
        {
        pushFollow(FOLLOW_stringExpression_in_synpred1_expression98);
        stringExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_expression

    // $ANTLR start synpred3_expression
    public final void synpred3_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:29:5: ( STRING )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:29:5: STRING
        {
        match(input,STRING,FOLLOW_STRING_in_synpred3_expression111); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_expression

    // $ANTLR start synpred6_expression
    public final void synpred6_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:14: ( nameExpression )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:14: nameExpression
        {
        pushFollow(FOLLOW_nameExpression_in_synpred6_expression160);
        nameExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred6_expression

    // $ANTLR start synpred7_expression
    public final void synpred7_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:30: ( STRING )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:30: STRING
        {
        match(input,STRING,FOLLOW_STRING_in_synpred7_expression163); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred7_expression

    // $ANTLR start synpred8_expression
    public final void synpred8_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:6: ( ( STRING )* ( nameExpression )+ ( STRING )* )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:6: ( STRING )* ( nameExpression )+ ( STRING )*
        {
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:6: ( STRING )*
        loop23:
        do {
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==STRING) ) {
                alt23=1;
            }


            switch (alt23) {
        	case 1 :
        	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: STRING
        	    {
        	    match(input,STRING,FOLLOW_STRING_in_synpred8_expression157); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop23;
            }
        } while (true);

        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:14: ( nameExpression )+
        int cnt24=0;
        loop24:
        do {
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==EPRESSIONCHAR) ) {
                alt24=1;
            }


            switch (alt24) {
        	case 1 :
        	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: nameExpression
        	    {
        	    pushFollow(FOLLOW_nameExpression_in_synpred8_expression160);
        	    nameExpression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt24 >= 1 ) break loop24;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(24, input);
                    throw eee;
            }
            cnt24++;
        } while (true);

        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:40:30: ( STRING )*
        loop25:
        do {
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==STRING) ) {
                alt25=1;
            }


            switch (alt25) {
        	case 1 :
        	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:0:0: STRING
        	    {
        	    match(input,STRING,FOLLOW_STRING_in_synpred8_expression163); if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    break loop25;
            }
        } while (true);


        }
    }
    // $ANTLR end synpred8_expression

    // $ANTLR start synpred10_expression
    public final void synpred10_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:45:35: ( EPRESSIONCHAR )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:45:35: EPRESSIONCHAR
        {
        match(input,EPRESSIONCHAR,FOLLOW_EPRESSIONCHAR_in_synpred10_expression199); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred10_expression

    // $ANTLR start synpred11_expression
    public final void synpred11_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:50:20: ( nameExprTerm )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:50:20: nameExprTerm
        {
        pushFollow(FOLLOW_nameExprTerm_in_synpred11_expression222);
        nameExprTerm();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred11_expression

    // $ANTLR start synpred13_expression
    public final void synpred13_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:55:5: ( REFERENCECHAR simpleExpr )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:55:5: REFERENCECHAR simpleExpr
        {
        match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_synpred13_expression246); if (state.failed) return ;
        pushFollow(FOLLOW_simpleExpr_in_synpred13_expression249);
        simpleExpr();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred13_expression

    // $ANTLR start synpred27_expression
    public final void synpred27_expression_fragment() throws RecognitionException {   
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:11: ( ( '+' | '-' ) mult )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expression.g:80:11: ( '+' | '-' ) mult
        {
        if ( (input.LA(1)>=46 && input.LA(1)<=47) ) {
            input.consume();
            state.errorRecovery=false;state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            throw mse;
        }

        pushFollow(FOLLOW_mult_in_synpred27_expression437);
        mult();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred27_expression

    // Delegated rules

    public final boolean synpred11_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred11_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred27_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred27_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred13_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred8_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred10_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred10_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_expression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_expression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA17 dfa17 = new DFA17(this);
    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA7_eotS =
        "\15\uffff";
    static final String DFA7_eofS =
        "\1\1\14\uffff";
    static final String DFA7_minS =
        "\1\10\2\uffff\1\0\11\uffff";
    static final String DFA7_maxS =
        "\1\63\2\uffff\1\0\11\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\2\12\uffff\1\1";
    static final String DFA7_specialS =
        "\3\uffff\1\0\11\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\3\1\uffff\2\1\27\uffff\1\1\1\uffff\2\1\6\uffff\2\1\2"+
            "\uffff\2\1",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()+ loopback of 45:48: ( EPRESSIONCHAR )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_3 = input.LA(1);

                         
                        int index7_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred10_expression()) ) {s = 12;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index7_3);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA17_eotS =
        "\26\uffff";
    static final String DFA17_eofS =
        "\1\1\25\uffff";
    static final String DFA17_minS =
        "\1\10\13\uffff\2\0\10\uffff";
    static final String DFA17_maxS =
        "\1\63\13\uffff\2\0\10\uffff";
    static final String DFA17_acceptS =
        "\1\uffff\1\2\23\uffff\1\1";
    static final String DFA17_specialS =
        "\14\uffff\1\0\1\1\10\uffff}>";
    static final String[] DFA17_transitionS = {
            "\2\1\1\uffff\2\1\25\uffff\14\1\1\14\1\15\2\uffff\2\1",
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
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA17_eot = DFA.unpackEncodedString(DFA17_eotS);
    static final short[] DFA17_eof = DFA.unpackEncodedString(DFA17_eofS);
    static final char[] DFA17_min = DFA.unpackEncodedStringToUnsignedChars(DFA17_minS);
    static final char[] DFA17_max = DFA.unpackEncodedStringToUnsignedChars(DFA17_maxS);
    static final short[] DFA17_accept = DFA.unpackEncodedString(DFA17_acceptS);
    static final short[] DFA17_special = DFA.unpackEncodedString(DFA17_specialS);
    static final short[][] DFA17_transition;

    static {
        int numStates = DFA17_transitionS.length;
        DFA17_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA17_transition[i] = DFA.unpackEncodedString(DFA17_transitionS[i]);
        }
    }

    class DFA17 extends DFA {

        public DFA17(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 17;
            this.eot = DFA17_eot;
            this.eof = DFA17_eof;
            this.min = DFA17_min;
            this.max = DFA17_max;
            this.accept = DFA17_accept;
            this.special = DFA17_special;
            this.transition = DFA17_transition;
        }
        public String getDescription() {
            return "()* loopback of 80:10: ( ( '+' | '-' ) mult )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA17_12 = input.LA(1);

                         
                        int index17_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_expression()) ) {s = 21;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index17_12);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA17_13 = input.LA(1);

                         
                        int index17_13 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred27_expression()) ) {s = 21;}

                        else if ( (true) ) {s = 1;}

                         
                        input.seek(index17_13);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 17, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA22_eotS =
        "\15\uffff";
    static final String DFA22_eofS =
        "\15\uffff";
    static final String DFA22_minS =
        "\1\63\1\15\13\uffff";
    static final String DFA22_maxS =
        "\1\63\1\27\13\uffff";
    static final String DFA22_acceptS =
        "\2\uffff\1\13\1\3\1\6\1\10\1\12\1\5\1\1\1\4\1\2\1\11\1\7";
    static final String DFA22_specialS =
        "\15\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\1",
            "\1\10\1\12\1\3\1\11\1\7\1\4\1\14\1\5\1\13\1\6\1\2",
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
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "110:1: bpv : ( artvarchar ISLAST arithmeticTerm | artvarchar ISFIRST arithmeticTerm | artvarchar SIZE arithmeticTerm | artvarchar ISNUMERIC arithmeticTerm | artvarchar ULCAP arithmeticTerm | artvarchar LLCAP arithmeticTerm | artvarchar DEBUGMODE | artvarchar CURRENTFILE | artvarchar OUTFILE | artvarchar DEFAULTOUTPUT | artvarchar OUTDIR );";
        }
    }
 

    public static final BitSet FOLLOW_stringExpression_in_evaluator98 = new BitSet(new long[]{0x000CC0D000001B02L});
    public static final BitSet FOLLOW_freeExpression_in_evaluator105 = new BitSet(new long[]{0x000CC0D000001B02L});
    public static final BitSet FOLLOW_STRING_in_evaluator111 = new BitSet(new long[]{0x000CC0D000001B02L});
    public static final BitSet FOLLOW_freeExpression_in_expression135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_expression141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_stringExpression157 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_nameExpression_in_stringExpression160 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_STRING_in_stringExpression163 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression181 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExpression184 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression194 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_freeExpression_in_nameExpression197 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_nameExpression199 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_simpleExpr219 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_nameExprTerm_in_simpleExpr222 = new BitSet(new long[]{0x0000000000000C02L});
    public static final BitSet FOLLOW_IDENT_in_nameExprTerm240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_nameExprTerm246 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExprTerm249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_simpleExpr_in_nameExprTerm255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_freeExpression276 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_34_in_freeExpression281 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_35_in_freeExpression286 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_relation_in_freeExpression292 = new BitSet(new long[]{0x0000000C00000002L});
    public static final BitSet FOLLOW_IDENT_in_arithmeticTerm315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_arithmeticTerm323 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_freeExpression_in_arithmeticTerm326 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_arithmeticTerm328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_arithmeticTerm337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_arithmeticTerm351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_add_in_relation374 = new BitSet(new long[]{0x00003F0000000002L});
    public static final BitSet FOLLOW_40_in_relation378 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_41_in_relation383 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_42_in_relation388 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_43_in_relation393 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_44_in_relation398 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_45_in_relation403 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_add_in_relation407 = new BitSet(new long[]{0x00003F0000000002L});
    public static final BitSet FOLLOW_mult_in_add424 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_46_in_add428 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_47_in_add433 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_mult_in_add437 = new BitSet(new long[]{0x0000C00000000002L});
    public static final BitSet FOLLOW_unary_in_mult454 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_48_in_mult458 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_49_in_mult463 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_unary_in_mult467 = new BitSet(new long[]{0x0003000000000002L});
    public static final BitSet FOLLOW_46_in_unary485 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_negation_in_unary490 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_unary495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_defined_in_unary501 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_unary504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_bpv_in_unary510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_negation523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_defined542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_artvarchar561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv588 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_ISLAST_in_bpv591 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_bpv593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv599 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ISFIRST_in_bpv602 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_bpv604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv610 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SIZE_in_bpv613 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_bpv615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv621 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_ISNUMERIC_in_bpv624 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_bpv626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv632 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_ULCAP_in_bpv635 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_bpv637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv643 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_LLCAP_in_bpv646 = new BitSet(new long[]{0x0000C0D000001800L});
    public static final BitSet FOLLOW_arithmeticTerm_in_bpv648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv654 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_DEBUGMODE_in_bpv657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv663 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_CURRENTFILE_in_bpv666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv672 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_OUTFILE_in_bpv675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv681 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_DEFAULTOUTPUT_in_bpv684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_artvarchar_in_bpv690 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_OUTDIR_in_bpv693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ISLAST_in_islast792 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_islast794 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_islast797 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_islast799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ISFIRST_in_isfirst806 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_isfirst808 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_isfirst811 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_isfirst813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stringExpression_in_synpred1_expression98 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred3_expression111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameExpression_in_synpred6_expression160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred7_expression163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred8_expression157 = new BitSet(new long[]{0x0000000000000300L});
    public static final BitSet FOLLOW_nameExpression_in_synpred8_expression160 = new BitSet(new long[]{0x0000000000000302L});
    public static final BitSet FOLLOW_STRING_in_synpred8_expression163 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_EPRESSIONCHAR_in_synpred10_expression199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_nameExprTerm_in_synpred11_expression222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_synpred13_expression246 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_simpleExpr_in_synpred13_expression249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_synpred27_expression427 = new BitSet(new long[]{0x000CC0D000001800L});
    public static final BitSet FOLLOW_mult_in_synpred27_expression437 = new BitSet(new long[]{0x0000000000000002L});

}