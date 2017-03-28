// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g 2017-03-28 11:47:32

  package antlrGen.expression;
  import art.utils.Utils;
  import art.exception.MissingVariableException;
  import art.type.MultiValVariable;
  import art.type.ProcessVariable;
  import art.stat.SetRecord;
  import art.stat.StatParam;
  import java.io.IOException;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class expressionWalker extends TreeParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NEGATION", "DEFINED", "ARTVARCHAR", "DEBUGMODECOMMAND", "STRING", "EPRESSIONCHAR", "REFERENCECHAR", "IDENT", "INTEGER", "ISLAST", "ISFIRST", "SIZE", "ISNUMERIC", "ULCAP", "LLCAP", "DEBUGMODE", "CURRENTFILE", "OUTFILE", "DEFAULTOUTPUT", "OUTDIR", "COMMANDCHAR", "COMMENTCHAR", "NOTNEWLINE", "WS", "NL", "COMMENT", "DIGIT", "SPECCHAR", "LETTER", "ANYCHAR", "'&&'", "'||'", "'('", "')'", "'true'", "'false'", "'=='", "'!='", "'<'", "'<='", "'>='", "'>'", "'+'", "'-'", "'*'", "'/'", "'defined'", "'$'"
    };
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


        public expressionWalker(TreeNodeStream input) {
            this(input, new RecognizerSharedState());
        }
        public expressionWalker(TreeNodeStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return expressionWalker.tokenNames; }
    public String getGrammarFileName() { return "C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g"; }


      boolean notdefined = false;
      String notDefVarName = null;
      
      private List<Long> usedSetIdList = new ArrayList<Long>();
      private StatParam statParam = StatParam.getInstance();
      
      public List<Long> getUsedSetIdList() {
        return this.usedSetIdList;
      }




    // $ANTLR start "evaluator"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:34:1: evaluator returns [String result] : e= stringExpression ;
    public final String evaluator() throws RecognitionException {
        String result = null;

        String e = null;


        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:35:3: (e= stringExpression )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:35:6: e= stringExpression
            {
            pushFollow(FOLLOW_stringExpression_in_evaluator74);
            e=stringExpression();

            state._fsp--;
            if (state.failed) return result;
            if ( state.backtracking==0 ) {
               result = e;
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "evaluator"


    // $ANTLR start "simpleExpr"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:38:1: simpleExpr returns [String result] : ( ^(r= REFERENCECHAR e= simpleExpr ) | ^( REFERENCECHAR i= IDENT ) | ^( REFERENCECHAR i2= IDENT e= simpleExpr ) );
    public final String simpleExpr() throws RecognitionException {
        String result = null;

        CommonTree r=null;
        CommonTree i=null;
        CommonTree i2=null;
        String e = null;


        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:40:3: ( ^(r= REFERENCECHAR e= simpleExpr ) | ^( REFERENCECHAR i= IDENT ) | ^( REFERENCECHAR i2= IDENT e= simpleExpr ) )
            int alt1=3;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==REFERENCECHAR) ) {
                int LA1_1 = input.LA(2);

                if ( (LA1_1==DOWN) ) {
                    int LA1_2 = input.LA(3);

                    if ( (LA1_2==IDENT) ) {
                        int LA1_3 = input.LA(4);

                        if ( (LA1_3==UP) ) {
                            alt1=2;
                        }
                        else if ( (LA1_3==REFERENCECHAR) ) {
                            alt1=3;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return result;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 1, 3, input);

                            throw nvae;
                        }
                    }
                    else if ( (LA1_2==REFERENCECHAR) ) {
                        alt1=1;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return result;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 1, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return result;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return result;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:40:6: ^(r= REFERENCECHAR e= simpleExpr )
                    {
                    r=(CommonTree)match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_simpleExpr99); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_simpleExpr_in_simpleExpr103);
                    e=simpleExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       
                              if (null == Utils.getVariables().get(e)){
                                  throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine() + ": Variable " + e + " is not defined.");
                              } else {
                                  String value = String.valueOf(Utils.getVariables().get(e).getValue());
                                  try {
                                    if(statParam.isStatEnabled()) {
                                      Long setId = SetRecord.findSetId(e, value);
                                      if(setId != null) {
                                        usedSetIdList.add(setId);
                                      }
                                    }
                                  } catch (Exception exp) {
                                    System.out.println("Error occured while processing statistics." + exp.getMessage());
                      //              expc.printStackTrace();
                                  }
                              result = String.valueOf(Utils.getVariables().get(e).getValue());
                              }
                              
                          
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:61:6: ^( REFERENCECHAR i= IDENT )
                    {
                    match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_simpleExpr118); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    i=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_simpleExpr122); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                              String varName = (i!=null?i.getText():null);
                              if (null == Utils.getVariables().get(varName)){
                                 throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine() + ": Variable " + varName + " is not defined.");
                              } else {
                                  String value = null;
                                  if ((Utils.getVariables().get(varName)).isDeferred()){
                                      value = Utils.getExpressionsVal(Utils.getVariables().get(varName).getValue(), Utils.getExpressionLine());
                                  } else {
                                      value = Utils.getVariables().get(varName).getValue();
                                  }
                                  try {
                                    if(statParam.isStatEnabled()) {
                                      Long setId = SetRecord.findSetId(varName, value);
                                      if(setId != null) {
                                        usedSetIdList.add(setId);
                                      }
                                    }
                                  } catch (Exception exp) {
                                    System.out.println("Error occured while processing statistics." + exp.getMessage());
                      //              exp.printStackTrace();
                                  }
                                  String str2 = value.replace("\\\"", "\"");
                                  result = str2;
                              }
                          
                    }

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:88:6: ^( REFERENCECHAR i2= IDENT e= simpleExpr )
                    {
                    match(input,REFERENCECHAR,FOLLOW_REFERENCECHAR_in_simpleExpr137); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    i2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_simpleExpr141); if (state.failed) return result;
                    pushFollow(FOLLOW_simpleExpr_in_simpleExpr145);
                    e=simpleExpr();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       
                              String varName = (i2!=null?i2.getText():null);
                               if (null == Utils.getVariables().get(varName + e)){
                                  throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine() + ": Variable " + (varName + e) + " is not defined.");
                              } else {
                                  String value = Utils.getVariables().get(varName + e).getValue();
                                  result = value; 
                              } 
                          
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "simpleExpr"


    // $ANTLR start "stringExpression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:100:1: stringExpression returns [String result] : (e= expression | str= STRING )+ ;
    public final String stringExpression() throws RecognitionException {
        String result = null;

        CommonTree str=null;
        String e = null;


         StringBuilder sb = new StringBuilder();
        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:102:3: ( (e= expression | str= STRING )+ )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:103:3: (e= expression | str= STRING )+
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:103:3: (e= expression | str= STRING )+
            int cnt2=0;
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=NEGATION && LA2_0<=ARTVARCHAR)||(LA2_0>=REFERENCECHAR && LA2_0<=INTEGER)||(LA2_0>=34 && LA2_0<=35)||(LA2_0>=38 && LA2_0<=40)||(LA2_0>=42 && LA2_0<=49)) ) {
                    alt2=1;
                }
                else if ( (LA2_0==STRING) ) {
                    int LA2_3 = input.LA(2);

                    if ( (synpred3_expressionWalker()) ) {
                        alt2=1;
                    }
                    else if ( (synpred4_expressionWalker()) ) {
                        alt2=2;
                    }


                }


                switch (alt2) {
            	case 1 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:103:5: e= expression
            	    {
            	    pushFollow(FOLLOW_expression_in_stringExpression183);
            	    e=expression();

            	    state._fsp--;
            	    if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       sb.append(e); 
            	    }

            	    }
            	    break;
            	case 2 :
            	    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:104:5: str= STRING
            	    {
            	    str=(CommonTree)match(input,STRING,FOLLOW_STRING_in_stringExpression194); if (state.failed) return result;
            	    if ( state.backtracking==0 ) {
            	       sb.append(str); 
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return result;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            if ( state.backtracking==0 ) {
               result = sb.toString(); 
            }

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "stringExpression"


    // $ANTLR start "expression"
    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:108:1: expression returns [String result] : (se= simpleExpr | ^(o= '+' op1= expression op2= expression ) | ^(o= '-' op1= expression op2= expression ) | ^(o= '*' op1= expression op2= expression ) | ^(o= '/' op1= expression op2= expression ) | ^(o= '==' op1= expression op2= expression ) | ^(o= '<=' op1= expression op2= expression ) | ^(o= '>=' op1= expression op2= expression ) | ^(o= '<' op1= expression op2= expression ) | ^(o= '>' op1= expression op2= expression ) | ^(o= '&&' op1= expression op2= expression ) | ^(o= '||' op1= expression op2= expression ) | ^(n= NEGATION e= expression ) | ^( DEFINED e= expression ) | ^( ARTVARCHAR ISLAST id= IDENT ) | ^( ARTVARCHAR ISFIRST id= IDENT ) | ^( ARTVARCHAR LLCAP id= IDENT ) | ^( ARTVARCHAR ULCAP id= IDENT ) | ^( ARTVARCHAR SIZE id= IDENT ) | ^( ARTVARCHAR ISNUMERIC id= IDENT ) | i2= IDENT | INTEGER | ^( ARTVARCHAR DEBUGMODE ) | ^( ARTVARCHAR OUTFILE ) | ^( ARTVARCHAR OUTDIR ) | ^( ARTVARCHAR CURRENTFILE ) | ^( ARTVARCHAR DEFAULTOUTPUT ) | 'true' | 'false' | STRING ) ;
    public final String expression() throws RecognitionException {
        String result = null;

        CommonTree o=null;
        CommonTree n=null;
        CommonTree id=null;
        CommonTree i2=null;
        CommonTree INTEGER1=null;
        CommonTree STRING2=null;
        String se = null;

        String op1 = null;

        String op2 = null;

        String e = null;


        try {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:109:3: ( (se= simpleExpr | ^(o= '+' op1= expression op2= expression ) | ^(o= '-' op1= expression op2= expression ) | ^(o= '*' op1= expression op2= expression ) | ^(o= '/' op1= expression op2= expression ) | ^(o= '==' op1= expression op2= expression ) | ^(o= '<=' op1= expression op2= expression ) | ^(o= '>=' op1= expression op2= expression ) | ^(o= '<' op1= expression op2= expression ) | ^(o= '>' op1= expression op2= expression ) | ^(o= '&&' op1= expression op2= expression ) | ^(o= '||' op1= expression op2= expression ) | ^(n= NEGATION e= expression ) | ^( DEFINED e= expression ) | ^( ARTVARCHAR ISLAST id= IDENT ) | ^( ARTVARCHAR ISFIRST id= IDENT ) | ^( ARTVARCHAR LLCAP id= IDENT ) | ^( ARTVARCHAR ULCAP id= IDENT ) | ^( ARTVARCHAR SIZE id= IDENT ) | ^( ARTVARCHAR ISNUMERIC id= IDENT ) | i2= IDENT | INTEGER | ^( ARTVARCHAR DEBUGMODE ) | ^( ARTVARCHAR OUTFILE ) | ^( ARTVARCHAR OUTDIR ) | ^( ARTVARCHAR CURRENTFILE ) | ^( ARTVARCHAR DEFAULTOUTPUT ) | 'true' | 'false' | STRING ) )
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:109:5: (se= simpleExpr | ^(o= '+' op1= expression op2= expression ) | ^(o= '-' op1= expression op2= expression ) | ^(o= '*' op1= expression op2= expression ) | ^(o= '/' op1= expression op2= expression ) | ^(o= '==' op1= expression op2= expression ) | ^(o= '<=' op1= expression op2= expression ) | ^(o= '>=' op1= expression op2= expression ) | ^(o= '<' op1= expression op2= expression ) | ^(o= '>' op1= expression op2= expression ) | ^(o= '&&' op1= expression op2= expression ) | ^(o= '||' op1= expression op2= expression ) | ^(n= NEGATION e= expression ) | ^( DEFINED e= expression ) | ^( ARTVARCHAR ISLAST id= IDENT ) | ^( ARTVARCHAR ISFIRST id= IDENT ) | ^( ARTVARCHAR LLCAP id= IDENT ) | ^( ARTVARCHAR ULCAP id= IDENT ) | ^( ARTVARCHAR SIZE id= IDENT ) | ^( ARTVARCHAR ISNUMERIC id= IDENT ) | i2= IDENT | INTEGER | ^( ARTVARCHAR DEBUGMODE ) | ^( ARTVARCHAR OUTFILE ) | ^( ARTVARCHAR OUTDIR ) | ^( ARTVARCHAR CURRENTFILE ) | ^( ARTVARCHAR DEFAULTOUTPUT ) | 'true' | 'false' | STRING )
            {
            // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:109:5: (se= simpleExpr | ^(o= '+' op1= expression op2= expression ) | ^(o= '-' op1= expression op2= expression ) | ^(o= '*' op1= expression op2= expression ) | ^(o= '/' op1= expression op2= expression ) | ^(o= '==' op1= expression op2= expression ) | ^(o= '<=' op1= expression op2= expression ) | ^(o= '>=' op1= expression op2= expression ) | ^(o= '<' op1= expression op2= expression ) | ^(o= '>' op1= expression op2= expression ) | ^(o= '&&' op1= expression op2= expression ) | ^(o= '||' op1= expression op2= expression ) | ^(n= NEGATION e= expression ) | ^( DEFINED e= expression ) | ^( ARTVARCHAR ISLAST id= IDENT ) | ^( ARTVARCHAR ISFIRST id= IDENT ) | ^( ARTVARCHAR LLCAP id= IDENT ) | ^( ARTVARCHAR ULCAP id= IDENT ) | ^( ARTVARCHAR SIZE id= IDENT ) | ^( ARTVARCHAR ISNUMERIC id= IDENT ) | i2= IDENT | INTEGER | ^( ARTVARCHAR DEBUGMODE ) | ^( ARTVARCHAR OUTFILE ) | ^( ARTVARCHAR OUTDIR ) | ^( ARTVARCHAR CURRENTFILE ) | ^( ARTVARCHAR DEFAULTOUTPUT ) | 'true' | 'false' | STRING )
            int alt3=30;
            alt3 = dfa3.predict(input);
            switch (alt3) {
                case 1 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:109:6: se= simpleExpr
                    {
                    pushFollow(FOLLOW_simpleExpr_in_expression228);
                    se=simpleExpr();

                    state._fsp--;
                    if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = se;
                    }

                    }
                    break;
                case 2 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:110:5: ^(o= '+' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,46,FOLLOW_46_in_expression239); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression246);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression250);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = String.valueOf(Integer.parseInt(op1) + Integer.parseInt(op2)); Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 3 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:119:5: ^(o= '-' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,47,FOLLOW_47_in_expression267); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression274);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression278);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else { 
                              result = String.valueOf(Integer.parseInt(op1) - Integer.parseInt(op2)); Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 4 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:128:5: ^(o= '*' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,48,FOLLOW_48_in_expression295); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression302);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression306);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = String.valueOf(Integer.parseInt(op1) * Integer.parseInt(op2)); Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 5 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:137:5: ^(o= '/' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,49,FOLLOW_49_in_expression323); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression330);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression334);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                               result = String.valueOf(Integer.parseInt(op1) / Integer.parseInt(op2)); Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 6 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:146:5: ^(o= '==' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,40,FOLLOW_40_in_expression351); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression357);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression361);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = op1.equals(op2) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 7 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:155:5: ^(o= '<=' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,43,FOLLOW_43_in_expression378); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression384);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression388);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = Integer.parseInt(op1) <= Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 8 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:164:5: ^(o= '>=' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,44,FOLLOW_44_in_expression405); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression411);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression415);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = Integer.parseInt(op1) >= Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 9 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:173:5: ^(o= '<' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,42,FOLLOW_42_in_expression432); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression439);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression443);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = Integer.parseInt(op1) < Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 10 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:182:5: ^(o= '>' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,45,FOLLOW_45_in_expression460); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression467);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression471);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = Integer.parseInt(op1) > Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 11 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:191:5: ^(o= '&&' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,34,FOLLOW_34_in_expression488); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression494);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression498);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else { 
                              result = (op1.equals("true") && op2.equals("true")) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 12 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:200:5: ^(o= '||' op1= expression op2= expression )
                    {
                    o=(CommonTree)match(input,35,FOLLOW_35_in_expression514); if (state.failed) return result;

                    if ( state.backtracking==0 ) {
                      Utils.setArithmetic(true);
                    }

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression520);
                    op1=expression();

                    state._fsp--;
                    if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression524);
                    op2=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = (op1.equals("true") || op2.equals("true")) ? "true" : "false"; Utils.setArithmetic(false);
                            }
                          
                    }

                    }
                    break;
                case 13 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:209:5: ^(n= NEGATION e= expression )
                    {
                    n=(CommonTree)match(input,NEGATION,FOLLOW_NEGATION_in_expression541); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression545);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            if (notdefined) {
                              Utils.setArithmetic(false);
                              throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
                            } else {
                              result = String.valueOf(Integer.parseInt(e) * -1);
                            }
                          
                    }

                    }
                    break;
                case 14 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:218:5: ^( DEFINED e= expression )
                    {
                    match(input,DEFINED,FOLLOW_DEFINED_in_expression560); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    pushFollow(FOLLOW_expression_in_expression564);
                    e=expression();

                    state._fsp--;
                    if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                      notdefined = false;
                    }
                    if ( state.backtracking==0 ) {

                            //we have to watch out if we are in arithmetic exception or not
                            String res = null;
                            if (Utils.isArithmetic()){
                              res = !(null == e) ? "true" : "false";
                            } else {
                              res = !(null == Utils.getVariables().get(e)) ? "true" : "false";
                            }
                            if (res == null) 
                            {
                                throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
                            }
                            result = res;
                          
                    }

                    }
                    break;
                case 15 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:233:5: ^( ARTVARCHAR ISLAST id= IDENT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression580); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,ISLAST,FOLLOW_ISLAST_in_expression582); if (state.failed) return result;
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression586); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                          String res = null;
                          if (!(null == Utils.getVariables().get((id!=null?id.getText():null)))) {
                                ProcessVariable var = Utils.getVariables().get((id!=null?id.getText():null));
                                if (var instanceof MultiValVariable) {
                                     if (((MultiValVariable) var).isInIteration()) {
                                         if (((MultiValVariable) var).getAllValues().size() == ((MultiValVariable) var).getActualIter() + 1) {
                                            res = "true";
                                         } else res = "false";
                                     } else {
                                     res = "false";
                                     }
                                }  else {
                                 throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +   (id!=null?id.getText():null) + " is not a multi-value variable");       
                                }
                            } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  (id!=null?id.getText():null) + " is not defined");
                            if (res == null) 
                            {
                                throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  (id!=null?id.getText():null) + " is not defined.");
                            }
                            result = res;
                          
                    }

                    }
                    break;
                case 16 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:256:5: ^( ARTVARCHAR ISFIRST id= IDENT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression600); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,ISFIRST,FOLLOW_ISFIRST_in_expression602); if (state.failed) return result;
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression606); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                          String res = null;
                          if (!(null == Utils.getVariables().get((id!=null?id.getText():null)))) {
                                ProcessVariable var = Utils.getVariables().get((id!=null?id.getText():null));
                                if (var instanceof MultiValVariable) {
                                     if (((MultiValVariable) var).isInIteration()) {
                                         if (((MultiValVariable) var).getActualIter() == 0){
                                            res = "true";
                                         } else res = "false";
                                     } else {
                                     res = "false";
                                     }
                                }  else {
                                 throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +   (id!=null?id.getText():null) + " is not a multi-value variable");       
                                }
                            } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  (id!=null?id.getText():null) + " is not defined");
                            if (res == null) 
                            {
                                throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
                            }
                            result = res;
                          
                    }

                    }
                    break;
                case 17 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:279:6: ^( ARTVARCHAR LLCAP id= IDENT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression621); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,LLCAP,FOLLOW_LLCAP_in_expression623); if (state.failed) return result;
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression627); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                      		    String res = null;
                      		    if (!(null == Utils.getVariables().get((id!=null?id.getText():null)))) {
                      		        ProcessVariable var = Utils.getVariables().get((id!=null?id.getText():null));
                      		        res = var.getValue();
                      				    if (res.length() > 0) {
                      				        String beginning = res.substring(0, 1).toLowerCase();
                      		            res = beginning + res.substring(1, res.length());
                      				    }
                      		    }
                      		        if (res == null) 
                      	      {
                      	          throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
                      	      }
                      	      result = res;
                          
                    }

                    }
                    break;
                case 18 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:296:6: ^( ARTVARCHAR ULCAP id= IDENT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression642); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,ULCAP,FOLLOW_ULCAP_in_expression644); if (state.failed) return result;
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression648); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                              String res = null;
                              if (!(null == Utils.getVariables().get((id!=null?id.getText():null)))) {
                                  ProcessVariable var = Utils.getVariables().get((id!=null?id.getText():null));
                                  res = var.getValue();
                                  if (res.length() > 0) {
                                      String beginning = res.substring(0, 1).toUpperCase();
                                      res = beginning + res.substring(1, res.length());
                                  }
                              }
                                  if (res == null) 
                              {
                                  throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
                              }
                              result = res;
                          
                    }

                    }
                    break;
                case 19 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:313:6: ^( ARTVARCHAR SIZE id= IDENT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression663); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,SIZE,FOLLOW_SIZE_in_expression665); if (state.failed) return result;
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression669); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                          String res = null;
                          if (!(null == Utils.getVariables().get((id!=null?id.getText():null)))) {
                                ProcessVariable var = Utils.getVariables().get((id!=null?id.getText():null));
                                if (var instanceof MultiValVariable) {
                                   res = String.valueOf(((MultiValVariable) var).getAllValues().size());
                                }  else {
                                   res = String.valueOf(1);
                                }
                            } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  (id!=null?id.getText():null) + " is not defined");
                            if (res == null) 
                            {
                                throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
                            }
                            result = res;
                          
                    }

                    }
                    break;
                case 20 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:330:6: ^( ARTVARCHAR ISNUMERIC id= IDENT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression684); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,ISNUMERIC,FOLLOW_ISNUMERIC_in_expression686); if (state.failed) return result;
                    id=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression690); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                            String res = "false";
                            boolean allDigit = true;
                            if (!(null == Utils.getVariables().get((id!=null?id.getText():null)))) {
                      	         ProcessVariable var = Utils.getVariables().get((id!=null?id.getText():null));
                      	         String a = var.getValue();
                      	         for (int i = 0 ; i < a.length() ; i++) {
                                    if (!Character.isDigit(a.charAt(i))){
                                      allDigit = false;
                                    }
                                 }
                                 if (allDigit){
                                   res = "true";
                                 }
                             } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  (id!=null?id.getText():null) + " is not defined");
                             result = res;
                          
                    }

                    }
                    break;
                case 21 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:348:5: i2= IDENT
                    {
                    i2=(CommonTree)match(input,IDENT,FOLLOW_IDENT_in_expression705); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                           //if we use the IDENT in arithmetic expression
                           //-----------------
                              if (Utils.isArithmetic()) {
                                  if (null == Utils.getVariables().get((i2!=null?i2.getText():null))){
                                      throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  (i2!=null?i2.getText():null) + " is not defined.");
                                  } else {
                                      String returnThis = Utils.getVariables().get((i2!=null?i2.getText():null)).getValue();
                                      result = returnThis;
                                  }
                              } else {
                                  result = (i2!=null?i2.getText():null);
                              }
                           //-------------------
                          
                    }

                    }
                    break;
                case 22 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:364:5: INTEGER
                    {
                    INTEGER1=(CommonTree)match(input,INTEGER,FOLLOW_INTEGER_in_expression716); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = (INTEGER1!=null?INTEGER1.getText():null);
                    }

                    }
                    break;
                case 23 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:366:5: ^( ARTVARCHAR DEBUGMODE )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression728); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,DEBUGMODE,FOLLOW_DEBUGMODE_in_expression730); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = String.valueOf(Utils.isDebugMode());
                    }

                    }
                    break;
                case 24 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:367:5: ^( ARTVARCHAR OUTFILE )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression740); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,OUTFILE,FOLLOW_OUTFILE_in_expression742); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                         try {
                            System.out.println("AAAAAAAAAAAAa");
                            result = Utils.getCurrentOutput();     
                            } catch (IOException ex) {
                                System.err.println(ex);
                            }
                         
                    }

                    }
                    break;
                case 25 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:375:5: ^( ARTVARCHAR OUTDIR )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression752); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,OUTDIR,FOLLOW_OUTDIR_in_expression754); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {

                        try {
                            result = Utils.getOutputDir(); 
                            } catch (IOException ex) {
                                System.err.println(ex);
                            }
                         
                    }

                    }
                    break;
                case 26 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:382:5: ^( ARTVARCHAR CURRENTFILE )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression766); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,CURRENTFILE,FOLLOW_CURRENTFILE_in_expression768); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = Utils.getCurrentFile();
                    }

                    }
                    break;
                case 27 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:383:5: ^( ARTVARCHAR DEFAULTOUTPUT )
                    {
                    match(input,ARTVARCHAR,FOLLOW_ARTVARCHAR_in_expression778); if (state.failed) return result;

                    match(input, Token.DOWN, null); if (state.failed) return result;
                    match(input,DEFAULTOUTPUT,FOLLOW_DEFAULTOUTPUT_in_expression780); if (state.failed) return result;

                    match(input, Token.UP, null); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       result = Utils.getDefaultOutput();
                    }

                    }
                    break;
                case 28 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:385:5: 'true'
                    {
                    match(input,38,FOLLOW_38_in_expression792); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                      result = "true";
                    }

                    }
                    break;
                case 29 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:386:5: 'false'
                    {
                    match(input,39,FOLLOW_39_in_expression800); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                      result = "false";
                    }

                    }
                    break;
                case 30 :
                    // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:387:5: STRING
                    {
                    STRING2=(CommonTree)match(input,STRING,FOLLOW_STRING_in_expression808); if (state.failed) return result;
                    if ( state.backtracking==0 ) {
                       
                                      result = (STRING2!=null?STRING2.getText():null).substring(1, (STRING2!=null?STRING2.getText():null).length()-1); 
                                  
                    }

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expression"

    // $ANTLR start synpred3_expressionWalker
    public final void synpred3_expressionWalker_fragment() throws RecognitionException {   
        String e = null;


        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:103:5: (e= expression )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:103:5: e= expression
        {
        pushFollow(FOLLOW_expression_in_synpred3_expressionWalker183);
        e=expression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_expressionWalker

    // $ANTLR start synpred4_expressionWalker
    public final void synpred4_expressionWalker_fragment() throws RecognitionException {   
        CommonTree str=null;

        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:104:5: (str= STRING )
        // C:\\work\\art\\latest-code\\vclang-code-dd0a89f0d579f02ec8c3d8cd398ea8f7cbb445aa\\src\\art\\grammar\\expressionWalker.g:104:5: str= STRING
        {
        str=(CommonTree)match(input,STRING,FOLLOW_STRING_in_synpred4_expressionWalker194); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_expressionWalker

    // Delegated rules

    public final boolean synpred4_expressionWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_expressionWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_expressionWalker() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_expressionWalker_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA3 dfa3 = new DFA3(this);
    static final String DFA3_eotS =
        "\41\uffff";
    static final String DFA3_eofS =
        "\41\uffff";
    static final String DFA3_minS =
        "\1\4\16\uffff\1\2\5\uffff\1\15\13\uffff";
    static final String DFA3_maxS =
        "\1\61\16\uffff\1\2\5\uffff\1\27\13\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1"+
        "\15\1\16\1\uffff\1\25\1\26\1\34\1\35\1\36\1\uffff\1\17\1\20\1\21"+
        "\1\22\1\23\1\24\1\27\1\30\1\31\1\32\1\33";
    static final String DFA3_specialS =
        "\41\uffff}>";
    static final String[] DFA3_transitionS = {
            "\1\15\1\16\1\17\1\uffff\1\24\1\uffff\1\1\1\20\1\21\25\uffff"+
            "\1\13\1\14\2\uffff\1\22\1\23\1\6\1\uffff\1\11\1\7\1\10\1\12"+
            "\1\2\1\3\1\4\1\5",
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
            "\1\25",
            "",
            "",
            "",
            "",
            "",
            "\1\26\1\27\1\32\1\33\1\31\1\30\1\34\1\37\1\35\1\40\1\36",
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

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "109:5: (se= simpleExpr | ^(o= '+' op1= expression op2= expression ) | ^(o= '-' op1= expression op2= expression ) | ^(o= '*' op1= expression op2= expression ) | ^(o= '/' op1= expression op2= expression ) | ^(o= '==' op1= expression op2= expression ) | ^(o= '<=' op1= expression op2= expression ) | ^(o= '>=' op1= expression op2= expression ) | ^(o= '<' op1= expression op2= expression ) | ^(o= '>' op1= expression op2= expression ) | ^(o= '&&' op1= expression op2= expression ) | ^(o= '||' op1= expression op2= expression ) | ^(n= NEGATION e= expression ) | ^( DEFINED e= expression ) | ^( ARTVARCHAR ISLAST id= IDENT ) | ^( ARTVARCHAR ISFIRST id= IDENT ) | ^( ARTVARCHAR LLCAP id= IDENT ) | ^( ARTVARCHAR ULCAP id= IDENT ) | ^( ARTVARCHAR SIZE id= IDENT ) | ^( ARTVARCHAR ISNUMERIC id= IDENT ) | i2= IDENT | INTEGER | ^( ARTVARCHAR DEBUGMODE ) | ^( ARTVARCHAR OUTFILE ) | ^( ARTVARCHAR OUTDIR ) | ^( ARTVARCHAR CURRENTFILE ) | ^( ARTVARCHAR DEFAULTOUTPUT ) | 'true' | 'false' | STRING )";
        }
    }
 

    public static final BitSet FOLLOW_stringExpression_in_evaluator74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_simpleExpr99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_simpleExpr_in_simpleExpr103 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_simpleExpr118 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_simpleExpr122 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_REFERENCECHAR_in_simpleExpr137 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_IDENT_in_simpleExpr141 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_simpleExpr_in_simpleExpr145 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_expression_in_stringExpression183 = new BitSet(new long[]{0x0003FDCC00001D72L});
    public static final BitSet FOLLOW_STRING_in_stringExpression194 = new BitSet(new long[]{0x0003FDCC00001D72L});
    public static final BitSet FOLLOW_simpleExpr_in_expression228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_expression239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression246 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression250 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_47_in_expression267 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression274 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression278 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_48_in_expression295 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression302 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression306 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_49_in_expression323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression330 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression334 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_40_in_expression351 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression357 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression361 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_43_in_expression378 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression384 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression388 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_44_in_expression405 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression411 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression415 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_42_in_expression432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression439 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression443 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_45_in_expression460 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression467 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression471 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_34_in_expression488 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression494 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression498 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_35_in_expression514 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression520 = new BitSet(new long[]{0x0003FDCC00001D70L});
    public static final BitSet FOLLOW_expression_in_expression524 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_NEGATION_in_expression541 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression545 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DEFINED_in_expression560 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_expression_in_expression564 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression580 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ISLAST_in_expression582 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_expression586 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression600 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ISFIRST_in_expression602 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_expression606 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression621 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_LLCAP_in_expression623 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_expression627 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression642 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ULCAP_in_expression644 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_expression648 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression663 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SIZE_in_expression665 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_expression669 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression684 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_ISNUMERIC_in_expression686 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_IDENT_in_expression690 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_IDENT_in_expression705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_expression716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression728 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DEBUGMODE_in_expression730 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression740 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OUTFILE_in_expression742 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression752 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_OUTDIR_in_expression754 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression766 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_CURRENTFILE_in_expression768 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ARTVARCHAR_in_expression778 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DEFAULTOUTPUT_in_expression780 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_38_in_expression792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_expression800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_expression808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_synpred3_expressionWalker183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_synpred4_expressionWalker194 = new BitSet(new long[]{0x0000000000000002L});

}