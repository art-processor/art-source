grammar command;

options {
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
  backtrack = true;
}

tokens {
  NEGATION;
  DEFINED;
  ARTVARCHAR;
}

@header {
  package antlrGen.command;
    
  import java.io.FileWriter;
  import java.io.IOException;
  
  import art.command.Command;
  import art.command.AdaptCommand;
  import art.command.AdaptCopy;
  import art.command.AdaptCopyBinary;
  import art.command.SetCommand;
  import art.command.OutputCommand;
  import art.command.OutdirCommand;
  import art.command.OutfileCommand;
  import art.command.RemoveCommand;
  import art.command.IfCommand;
  import art.command.SelectCommand;
  import art.command.OptionCommandPart;
  import art.command.InsertCommand;
  import art.command.BreakCommand;
  import art.command.WhileCommand;
  import art.command.SetLoopCommand;
  import art.command.SetLoopVarBreak;
  import art.command.SetLoopIterBreak;
  import art.utils.Utils;
  import art.utils.SelectInfo;
  import art.utils.SetLoopInfo;
  import art.type.InsertType;
  import art.type.LoopVariable;
  import art.exception.MissingVariableException;
  import art.exception.ARTSyntaxException;
  import art.stat.StatParam;
  import art.stat.ExprRecord;
  import art.stat.IfdefRecord;
  import art.stat.IfndefRecord;
}

@lexer::header {
  package antlrGen.command;
}

@parser::members {
  private FileWriter out;
  private Command command;
  private int lineNo;
  private StatParam statParam = StatParam.getInstance();
 
  private void write(String str){
  out = Utils.getActualOutput();
  
  String str2 = str.replace("\\\"", "\"");
  str2 = str2.replace("\\#", "#");
  str2 = str2.replace("\\?", "?");
  str2 = str2.replace("\\\%", "\%");
  str2 = str2.replace("\\$", "$");
   
    if (Utils.canWrite()){ 
      try {
            out.write(str2);
            out.flush();
      } catch (IOException e) {
          System.err.println(e.getMessage());
//          e.printStackTrace();
      }
    }   
  }
  
   private void writeText(String str){
  out = Utils.getActualOutput();
  
  String str2 = str.replace("\\\"", "\"");
  str2 = str2.replace("\\#", "#");
  str2 = str2.replace("\\?", "?");
  str2 = str2.replace("\\\%", "\%");
  str2 = str2.replace("\\$", "$");
   
      try {
            out.write(str2);
            out.flush();
      } catch (IOException e) {
          System.err.println(e.getMessage());
//          e.printStackTrace();
      } 
  }
  
  private void writeMessage(String message){
    if (Utils.canWrite()){
        System.out.print(message);
    }
  }
  
   private void writeExpressionMessage(String expr, int line){
    if (Utils.canWrite()){
        try {
            String res = Utils.getExpressionsVal(expr, line);
            System.out.print(res);
        } catch (MissingVariableException e) {
            System.err.println(e.getMessage());
//            e.printStackTrace();
        }
      }
  }
  
  private void writeExpression(String expr, int line){
      if (Utils.canWrite()){
        try {
            String res = Utils.getExpressionsVal(expr, line);
            out.write(res);
            out.flush();
            
            if(statParam.isStatEnabled()) {
              try {
                ExprRecord er = new ExprRecord();
                er.setLineNo(lineNo);
                er.setFileId(statParam.getCurrentFileId());
                er.setExpr(expr);
                er.setValue(res);
                er.setUsedSetIdList(statParam.getUsedSetIdList());
                er.save();
              } catch (Exception exp) {
                System.out.println("Error occured while processing statistics." + exp.getMessage());
                exp.printStackTrace();
              }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
//            e.printStackTrace();
        } catch (MissingVariableException e) {
            throw e;
        }
      }
  }
  
  private void append(StringBuilder sb, String text){
      if (!(null == text)){
          sb.append(text);
      }
  }
}

@rulecatch {
    catch (RecognitionException ex) {
          throw new ARTSyntaxException("Syntax error in File: " + Utils.getCurrentFile() + " line: " + (ex.line == 0 ? Utils.getExpressionLine() : ex.line) + " (" + ex.getStackTrace()[0].getMethodName() + ")");
    }
}

// Don't change global variables at the description of command. Make sure the statement has to be executed
// Utils.canWrite() tells if something has to be executed or not. Use it!

evaluator 
@init {  
        out = Utils.getActualOutput(); 
      } 
@after {
          try {  
              out.flush();   
          } catch (IOException ex) {
              System.err.println(ex.getMessage());
          }
       }
  :
  ( ws* c=command ws* NL?
  | se=nameExpression {writeExpression($se.text, se.tree.getLine()); }
//  | str=STRING { write($str.text);}
  | e=ee {write($e.text);}
  )* EOF 
  ;
  
//commands -->
command 
  : COMMANDCHAR {lineNo = $COMMANDCHAR.getLine();}
  ( set
  | adapt
  | outputCommand
  | insertCommand
  | insertBefCommand
  | insertAftCommand
  | breakCommand
  | removeCommand
  | ifCommand
  | ifDefCommand
  | ifnDefCommand
  | selectCommand
  | whileCommand
  | setLoopCommand
  | messageCommand
  | textCommand
  | IDENT w=ws* NL? 
      {
          String toWrite = $COMMANDCHAR.text;
          toWrite += $IDENT.text;
          if ($w.text != null) toWrite += $w.text;
          if ($NL.text != null) toWrite += $NL.text;
          write(toWrite);
      }
  )
  ;

adapt
  : simpleAdapt
  | extendedAdapt
  | adaptCopyBinary
  | adaptCopy
  ;
  
simpleAdapt
@init{ boolean sameLevel = false;}
  : (SIMPLEADAPT | ADAPTSAMELEVEL {sameLevel= true;}) ws* e=expression ws*
   {   
      //AdaptCommand code
      if (Utils.canWrite()){
          new AdaptCommand($e.text, sameLevel, lineNo).execute();
//          if (!sameLevel){
//              Utils.getFiles().pop();
//          }
      }
   }
  ;

extendedAdapt
@init{ boolean sameLevel = false; int adaptLineNo = lineNo;}
  : (EXTENDEDADAPT | EXTENDEDADAPTSAMELEVEL {sameLevel= true; Utils.getSameLevelAdapts().add(Utils.getCurrentFile());}) {if (Utils.canWrite()) {Utils.getExtendedAdapts().add(Utils.getCurrentFile());}} ws* e=expression
        //no text from inside extended adapt
       (command | str=ee {/* write($str.text); */})*
    COMMANDCHAR ENDADAPT
    
    {
        //ExtendedAdaptCommand code
        if (Utils.canWrite()){
            new AdaptCommand($e.text, sameLevel, adaptLineNo).execute();
//            Utils.getFiles().pop();
        }
    }
    
  ;
  
adaptCopy
  : ADAPTCOPY ws* e=expression ws*
   {
      //AdaptCopy code
      if (Utils.canWrite()){
          new AdaptCopy($e.text, lineNo).execute();
      }
   }
  ;
  
adaptCopyBinary
  : ADAPTCOPY ws* e1=expression ws* e2=expression ws*
   {
      //AdaptCopy code
      if (Utils.canWrite()){
          new AdaptCopyBinary($e1.text, $e2.text, lineNo).execute();
      }
   }
  ;
  
//set ant set-multi
set
@init{ List<String> valueList = new ArrayList<String>(); boolean defer = false;}
  :  (s1=SET | s2=SETDEFER {defer = true;} ) ws* i=IDENT ws* '=' ws* e1=expression {valueList.add($e1.text);} ws*
   ( ws* ',' ws* NL* ws* e2=expression {valueList.add($e2.text);} )* ws* NL?
    {
      //SetCommand code
      if (Utils.canWrite()){
          if (!(null == $s1)) {Utils.setExpressionLine($s1.getLine()); }
          if (!(null == $s2)) {Utils.setExpressionLine($s2.getLine()); }
          new SetCommand($i.text, valueList, defer, lineNo).execute();
      }
    }
  
  ;

outputCommand : fullOutputCommand | outdirCommand | outfileCommand;
  
fullOutputCommand
  : o=OUTPUT ws* e=expression ws* NL?
  
  {
      //Output command
      if (Utils.canWrite()){
          new OutputCommand($e.text, lineNo).execute();
            out = Utils.getActualOutput();
      }
  }
  ;
  
outdirCommand
  : OUTDIR ws* e=expression ws* NL?
  
  {
      //Output command
      if (Utils.canWrite()){
          new OutdirCommand($e.text, lineNo).execute();
            out = Utils.getActualOutput();
      }
  }
  ;
  
outfileCommand
  : OUTFILE ws* e=expression ws* NL?
  
  {
      //Output command
      if (Utils.canWrite()){
          new OutfileCommand($e.text, lineNo).execute();
            out = Utils.getActualOutput();
      }
  }
  ;
  
ifCommand
   : IF ws* '('? e=freeExpression ')'? NL?
  
  { 
      Utils.getSkipIfStack().add(false);
      Utils.getElseStack().add(false);
  }
   {
      //IfCommand code
      if (Utils.canWrite()){
          new IfCommand($e.text, lineNo).execute();
      } else {
          Utils.setSkipIf(true);
      }
   }
   
    (command
       | se=stringExpression { writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws* 
    
      (COMMANDCHAR elifPart)*
      (COMMANDCHAR elsePart)?
     COMMANDCHAR ENDIF NL?
   
   {  
     if (Utils.getElseStack().size() > 0){
        Utils.getElseStack().pop();
     }
     if (Utils.getSkipIfStack().size() > 0){
        Utils.getSkipIfStack().pop();
     }
     
     Utils.removeWriteblocker("if"); 
   }
   ;
   
elifPart
  : ELIF ws* '('? e=freeExpression ')'? NL?
 
 {Utils.removeWriteblocker("if");} 
 
  { 
  
  } 
  //TODO Utils.getExpressionsVal here can make errors
  { 
  if (Utils.isSkipElse() || Utils.isSkipIf() || !(Utils.getExpressionsVal($e.text, e.tree.getLine()).equals("true"))) {
           Utils.addWriteblocker("if");
     } else {
           Utils.setSkipElse(true);
     }
  }
   
    (command
       | se=stringExpression { writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws*  
  ;
  
elsePart
  : ELSE NL?
  
  { 
    Utils.removeWriteblocker("if");
  { 
  
  }
  if (Utils.isSkipElse() || Utils.isSkipIf() || !(Utils.canWrite())) {
           Utils.addWriteblocker("if");
     }
  }

    (command
       | se=stringExpression {  writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws* 
    
    {
      Utils.removeWriteblocker("if");
    }
  ;

ifDefCommand
  : IFDEF ws* i=IDENT
    {
        //IfDefCommand code
        if (!(Utils.getVariables().containsKey($i.text)) || !(Utils.canWrite())){
            Utils.addWriteblocker("if");
        }
        
        try {
          if(statParam.isStatEnabled()) {
            IfdefRecord idr = new IfdefRecord();
        idr.setFileId(statParam.getCurrentFileId());
        idr.setLineNo(lineNo);
        idr.setVarName($i.text);
        idr.save();
      }
    } catch (Exception e) {
      System.out.println("Error occured while processing statistics." + e.getMessage());
      // e.printStackTrace();
    }
    }
    (command
       | se=stringExpression {  writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws* 
    COMMANDCHAR ENDIF {Utils.removeWriteblocker("if");}
  ;
   
ifnDefCommand
  : IFNDEF ws* i=IDENT
    {
        //IfDefCommand code
        if (Utils.getVariables().containsKey($i.text) || !(Utils.canWrite())){
            Utils.addWriteblocker("if");
        }
        
        try {
          if(statParam.isStatEnabled()) {
            IfndefRecord idr = new IfndefRecord();
        idr.setFileId(statParam.getCurrentFileId());
        idr.setLineNo(lineNo);
        idr.setVarName($i.text);
        idr.save();
      }
    } catch (Exception e) {
      System.out.println("Error occured while processing statistics." + e.getMessage());
      // e.printStackTrace();
    }
    }
    (command
       | se=stringExpression {  writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws* 
    COMMANDCHAR ENDIF {Utils.removeWriteblocker("if");}
  ;
  
removeCommand
  : r=REMOVE ws* i=IDENT
  {
      //Remove command
      if (Utils.canWrite()){
          new RemoveCommand($i.text, r.getLine()).execute();
      }
  }
  ;
  
//here the expression has to lead to an existing variable
selectCommand
  : s=SELECT ws* e=expression (ws | nl)*
  
   {
      //SelectCommand code
      if (Utils.canWrite()){
          new SelectCommand($e.text, lineNo).execute();
      }
   }
   
      (COMMANDCHAR optionUndef)? (ws | nl)*
      (COMMANDCHAR option (ws | nl)* )*
      (COMMANDCHAR otherwise)? (ws | nl)*
       COMMANDCHAR ENDSELECT
   {  
     if (Utils.canWrite()){
        SelectInfo.popSelect();
     }
   }
   ;
   
optionUndef
  : OPTIONUNDEFINED
    {
        //Option undef code
        if (!SelectInfo.undefined() || !(Utils.canWrite())){
            Utils.addWriteblocker("option");
        } else {
            SelectInfo.setSkipOtherwise(true);
        }
    }
       
    (command
       | se=stringExpression {  writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws* 
    
    COMMANDCHAR ENDOPTION {Utils.removeWriteblocker("option");}
  ;
  
option
  @init{List<String> optionList = new ArrayList<String>();}
  : o=OPTION ws* e1=expression  {optionList.add($e1.text);}
    (ws* '|' ws* e2=expression {optionList.add($e2.text);} )*
  
  {
        //Option code
        if (Utils.canWrite()){
            new OptionCommandPart(optionList, o.getLine()).execute();
        }
  }
        
    (command
       | se=stringExpression {  writeExpression($se.text, se.tree.getLine()); }
       | str=ee  { write($str.text);}
    )* ws* 
   
    COMMANDCHAR ENDOPTION {Utils.removeWriteblocker("option");}
  ;
  
otherwise
@init{int numberofPops = 0;}
  : OTHERWISE

       //Option otherwise code
       {
         //the while and the insert are containing writeblockers, because they will insert the content after
         //parsing the command's body. This can stop the otherwise from emitting while or insert contnet inside
         //it's body. Here I pop insert and while writeblockers, and put them back after processing the otherwise
        
         //Just in the while commands happen

          while ((!Utils.getWriteblockStack().isEmpty()) && Utils.getWriteblockStack().peek().equals("while")) {
            Utils.removeWriteblocker("while");
            numberofPops++;
          }
              
         if (SelectInfo.undefined() || !(Utils.canWrite()) || SelectInfo.isSkipOtherwise()){
             Utils.addWriteblocker("option");
         }
       }
  
    (command
       | se=stringExpression {  writeExpression($se.text, se.tree.getLine()); }
       | str=ee { write($str.text); }
    )* ws*
    
    COMMANDCHAR ENDOTHERWISE 
    {
      Utils.removeWriteblocker("option");
      //putting back the writeBlockers
      for (int i = 0; i < numberofPops; i++) {
        Utils.addWriteblocker("while");
      }
    }
  ;
  
insertCommand
@init{ InsertType type = InsertType.INTO; StringBuilder sb = new StringBuilder(); int insertLineNo = lineNo;}
  : (INSERT ws* e=expression NL?
  
  { Utils.addWriteblocker("insert"); }
  
    (c=command w1=ws* { append(sb, $c.text); append(sb, $w1.text); }
       | cc1=COMMANDCHAR v=varDesc w2=ws* { append(sb, $cc1.text); append(sb, $v.text); append(sb, $w2.text); }
       | cc2=COMMANDCHAR i=iter w3=ws* { append(sb, $cc2.text); append(sb, $i.text); append(sb, $w3.text); }
       | se=stringExpression w4=ws* { append(sb, $se.text); append(sb, $w4.text);} 
       | str=ee w5=ws* { append(sb, $str.text); append(sb, $w5.text); }
    )* ws* 
    
    COMMANDCHAR ENDINSERT)
    
  { Utils.removeWriteblocker("insert"); }
  
     {
          //Insert command
          if (Utils.canWrite()){
              new InsertCommand($e.text, type, sb.toString(), insertLineNo).execute();
          }
     }
     
  ;
  
insertBefCommand
@init{ InsertType type = InsertType.INTO; StringBuilder sb = new StringBuilder(); int insertLineNo = lineNo;}
  : ( INSERTBEFORE {type = InsertType.BEFORE;} ws* e=expression
  
  { Utils.addWriteblocker("insert"); }
  
    (c=command w1=ws* { append(sb, $c.text); append(sb, $w1.text); }
       | se=stringExpression w2=ws* { append(sb, $se.text); append(sb, $w2.text);} 
       | str=ee w3=ws* { append(sb, $str.text); append(sb, $w3.text); }
    )* ws* 
    
    COMMANDCHAR ENDINSERT)
    
  { Utils.removeWriteblocker("insert"); }
  
     {
          //Insert command
          if (Utils.canWrite()){
              new InsertCommand($e.text, type, sb.toString(), insertLineNo).execute();
          }
     }
     
  ;
  
insertAftCommand
@init{ InsertType type = InsertType.INTO; StringBuilder sb = new StringBuilder(); int insertLineNo = lineNo;}
  : ( INSERTAFTER {type = InsertType.AFTER;} ws* e=expression 
  
  { Utils.addWriteblocker("insert"); }
  
    (c=command w1=ws* { append(sb, $c.text); append(sb, $w1.text); }
       | se=stringExpression w2=ws* { append(sb, $se.text); append(sb, $w2.text);} 
       | str=ee w3=ws* { append(sb, $str.text); append(sb, $w3.text); }
    )* ws* 
    
    COMMANDCHAR ENDINSERT)
    
  { Utils.removeWriteblocker("insert"); }
  
     {
          //Insert command
          if (Utils.canWrite()){
              new InsertCommand($e.text, type, sb.toString(), insertLineNo).execute();
          }
     }
     
  ;
  
breakCommand
@init{ StringBuilder sb = new StringBuilder(); }
  : (EXTENDEDBREAK ws* e1=expression
  
  { Utils.addWriteblocker("break"); }
  
     (c=command w1=ws* { append(sb, $c.text); append(sb, $w1.text); }
       | cc1=COMMANDCHAR v=varDesc w2=ws* { append(sb, $cc1.text); append(sb, $v.text); append(sb, $w2.text); }
       | cc2=COMMANDCHAR i=iter w3=ws* { append(sb, $cc2.text); append(sb, $i.text); append(sb, $w3.text); }
       | se=stringExpression w4=ws* { append(sb, $se.text); append(sb, $w4.text);} 
       | str=ee w5=ws* { append(sb, $str.text); append(sb, $w5.text); }
    )* ws* 
    
    COMMANDCHAR ENDBREAK)
   
  { Utils.removeWriteblocker("break"); }
    
     {
         //Break command (extended)
         if (Utils.canWrite()){
             new BreakCommand($e1.text, sb.toString(), lineNo).execute();
         } 
     }
  |
    BREAK ws* e2=expression
     
     {
          //Break command
          if (Utils.canWrite()){
              new BreakCommand($e2.text, lineNo).execute();
          }
     }
    
  ;
  
//here the expression has to lead to an existing variable
whileCommand
@init{List<String> iterVariableList = new ArrayList<String>(); StringBuilder sb = new StringBuilder(); int whileLineNo = lineNo;}
  : WHILE ws* e=expression {iterVariableList.add($e.text);}
  ( ws* ',' ws* e2=expression {iterVariableList.add($e2.text);} )* NL?
  
      { Utils.addWriteblocker("while"); }
      
      (c=command { append(sb, $c.text); }
       | se=stringExpression w2=ws* { append(sb, $se.text); append(sb, $w2.text);} 
       | str=ee w3=ws* { append(sb, $str.text); append(sb, $w3.text); }
      )* ws*
     
      { Utils.removeWriteblocker("while"); }
  
      {
          //WhileCommand code
          if (Utils.canWrite()){
              new WhileCommand(iterVariableList, sb.toString(), whileLineNo).execute();
          }
      }
      
      COMMANDCHAR ENDWHILE NL?
  ;
  
setLoopCommand
  : s=SETLOOP ws* i=IDENT          (ws | nl)*
  
      {   //initialize the setloop
          if (Utils.canWrite()){
              Utils.addSetLoopVar($i.text, new LoopVariable(Utils.getActualProcessor().getProcessData().getFiles().lastElement()));
          }
      }
   
      (COMMANDCHAR setloopVars)?    (ws | nl)*
      (  (COMMANDCHAR iterBreakCommand) (ws | nl)*
      |  (COMMANDCHAR iter)         (ws | nl)*
      )*
      COMMANDCHAR ENDSETLOOP
    
      {
         // execute the setloop after the data has been gathered
         if (Utils.canWrite()){
             new SetLoopCommand($i.text, s.getLine()).execute();
         }
      } 
  ;
  
setloopVars
    : VARS (ws | nl)*
      ( (COMMANDCHAR varDesc) (ws | nl)*
      | (COMMANDCHAR varBreakCommand) (ws | nl)*
      )*
      COMMANDCHAR ENDVARS
    ;

varDesc
  : VAR ws* i=IDENT  ws* ('=' ws* e=expression ws*)? (ws | nl)*
    
    {
         //add the new variable to the setloop
         if (Utils.canWrite()){
             SetLoopInfo.addVariableToSetLoop($i.text, $e.text);
         }
    }
  
  ;
  
iter
@init{Map<String, String> iterVars = new HashMap<String,String>();}
  : ITER ws* i=IDENT ws* '=' ws* e=expression ws*  { if (Utils.canWrite()){ iterVars.put($i.text, $e.text);} }
  (',' ws* i1=IDENT ws* '=' ws* e1=expression ws* { if (Utils.canWrite()){ iterVars.put($i1.text, $e1.text);} } )* (ws | nl)*
    {
        if (Utils.canWrite())
        { 
            SetLoopInfo.addIter(iterVars);
        } 
    }
  ;
  
iterBreakCommand 
    @init{ StringBuilder sb = new StringBuilder(); }
   :
     (EXTENDEDBREAK ws* e1=expression  (ws | nl)*
    
    { Utils.addWriteblocker("break"); }
    
       cc=COMMANDCHAR i=iter w=ws* { append(sb, $cc.text); append(sb, $i.text); append(sb, $w.text); }
       (ws | nl)*
      
      COMMANDCHAR ENDBREAK)
     
    { Utils.removeWriteblocker("break"); }
      
       {
           //Break command (extended)
           if (Utils.canWrite()){
               new SetLoopIterBreak($e1.text, sb.toString()).execute();
           } 
       }
    | 
      BREAK ws* e2=expression  (ws | nl)*
       
       {
            //Break command
            if (Utils.canWrite()){
                new SetLoopIterBreak($e2.text).execute();
            }
       }
    ;

varBreakCommand 
    @init{ StringBuilder sb = new StringBuilder(); }
   :
     (EXTENDEDBREAK ws* e1=expression  (ws | nl)*
    
    { Utils.addWriteblocker("break"); }
    
       cc=COMMANDCHAR v=varDesc w=ws* { append(sb, $cc.text); append(sb, $v.text); append(sb, $w.text); }
       (ws | nl)*
      
      COMMANDCHAR ENDBREAK)
     
    { Utils.removeWriteblocker("break"); }
      
       {
           //Break command (extended)
           if (Utils.canWrite()){
               new SetLoopVarBreak($e1.text, sb.toString()).execute();
           } 
       }
    |
      BREAK ws* e2=expression  (ws | nl)*
       
       {
            //Break command
            if (Utils.canWrite()){
                new SetLoopVarBreak($e2.text).execute();
            }
       }
    ;
    
messageCommand: shortMessage | extendedMessage | messageif | extendedMessageif | messagedebug | extendedMessagedebug;

shortMessage
  : m=MESSAGE
  ( 
  se=stringExpression { writeExpressionMessage($se.text, m.getLine()); } 
  | str=~(NL) { writeMessage($str.text);}
  )* ws* {writeMessage("\n");} NL?;

extendedMessage
  : em=EXTENDEDMESSAGE
  ( se=stringExpression {  writeExpressionMessage($se.text, em.getLine()); }
  | str=ee { writeMessage($str.text);} 
  )* 
  COMMANDCHAR ENDMESSAGE NL?;

messageif
  @init{ boolean accepted = false; }
  : mf=MESSAGEIF ws* '('? expr=freeExpression ')'?
  
  {
      String expRes = null;
      try {
	      expRes = Utils.getExpressionsVal($expr.text, mf.getLine());
	      if ((expRes.equals("true"))) {
	        accepted = true;
	      }  
      } catch (MissingVariableException e) {
          throw new ARTSyntaxException(e.getMessage());
      }
  
  }
  ( se=stringExpression { if (accepted) writeExpressionMessage($se.text, se.tree.getLine()); } 
  | str=~(NL) { if (accepted) writeMessage($str.text);} 
  )* ws* {writeMessage("\n");} NL?;
  
extendedMessageif
  @init{ boolean accepted = false; }
  : mf=EXTENDEDMESSAGEIF ws* '('? expr=freeExpression ')'?
  
  {
      String expRes = null;
      try {
        expRes = Utils.getExpressionsVal($expr.text, mf.getLine());
        if ((expRes.equals("true"))) {
          accepted = true;
        }  
      } catch (MissingVariableException e) {
          throw new ARTSyntaxException(e.getMessage());
      }
  
  }
  ( se=stringExpression { if (accepted) writeExpressionMessage($se.text, se.tree.getLine()); } 
  | str=ee { if (accepted) writeMessage($str.text);} 
  )* 
   COMMANDCHAR ENDMESSAGE NL?;


messagedebug
  : MESSAGEDEBUG 
  ( se=stringExpression { if (Utils.isDebugMode()) writeExpressionMessage($se.text, se.tree.getLine()); } 
  | str=ee { if (Utils.isDebugMode()) writeMessage($str.text);} 
  )*  ws* {writeMessage("\n");} NL?;

extendedMessagedebug
  : em=EXTENDEDMESSAGEDEBUG
  ( se=stringExpression {if (Utils.isDebugMode()) writeExpressionMessage($se.text, em.getLine()); }
  | str=ee {if (Utils.isDebugMode()) writeMessage($str.text);} 
  )* 
  COMMANDCHAR ENDMESSAGE NL?;
  
textCommand:
  TEXT (ws | NL)*
  {Utils.addWriteblocker("text");}
  ( se=stringExpression { writeText($se.text); }
  | c=command { writeText($c.text);}  
  | str=ee { writeText($str.text);} 
  )*  ws*
  COMMANDCHAR ENDTEXT NL?
  {Utils.removeWriteblocker("text");};
//<-- commands

//expressions -->
expression
  : freeExpression
  | stringExpression 
  | ws* STRING ws* 
  ;
  
stringExpression
  : (STRING* nameExpression+ STRING*)+
  ;
  
nameExpression
  : e = EPRESSIONCHAR! ws!* simpleExpr ws!* EPRESSIONCHAR! { lineNo = $e.getLine();}
  | e = EPRESSIONCHAR! ws!* freeExpression ws!* EPRESSIONCHAR!+ {lineNo = $e.getLine();}
  ;
  
simpleExpr
  : REFERENCECHAR^ nameExprTerm*
  ;
  
nameExprTerm 
  : (IDENT 
  | REFERENCECHAR^ simpleExpr 
  | simpleExpr) 
  ;
  
//can be araitmetic too @see: arithmeticTerm
freeExpression
  : ( r1=relation  (('&&'^ | '||'^) r2=relation )*)
  ;

//<-- expressions

//arithmetic expressions -->

arithmeticTerm
    : ws* (IDENT
    | '('! ws!* freeExpression ws!* ')'!
    | ('true' | 'false')
    | INTEGER) ws*
    ;  
    
relation
  : (add (('=='^ | '!='^ | '<'^ | '<='^ | '>='^ | '>'^) add)*)
  ;

add
  : mult (('+'^ | '-'^) mult)*
  ;
  
mult
  : unary (('*'^ | '/'^) unary)*
  ;
  
unary
  : ('+'! | negation^)* arithmeticTerm
  | ws* defined^ ws* arithmeticTerm
  | ws* bpv
  ;
  
//boolean process variable
bpv 
  : artvarchar^ ISLAST arithmeticTerm
  | artvarchar^ ISFIRST arithmeticTerm
  | artvarchar^ SIZE arithmeticTerm
  | artvarchar^ ISNUMERIC arithmeticTerm
  | artvarchar^ ULCAP arithmeticTerm
  | artvarchar^ LLCAP arithmeticTerm
  | artvarchar^ DEBUGMODE ws*
  | artvarchar^ CURRENTFILE ws*
  | artvarchar^ DEFAULTOUTPUT ws*
  | artvarchar^ OUTFILE ws*
  | artvarchar^ OUTDIR ws*
  ;

negation
  : '-' -> NEGATION
  ;

defined
  : 'defined' -> DEFINED
  ;
  
artvarchar
  : '$' -> ARTVARCHAR
  ;

//<-- arithmetic expressions

//Special chars
COMMANDCHAR: '#';
EPRESSIONCHAR: '?';
REFERENCECHAR: '@';
COMMENTCHAR: '%';
fragment QUOTATIONMARK: '"';
    
CURRENTFILE : 'currentfile';
DEFAULTOUTPUT :'defaultoutput';
DEBUGMODE : 'debugmode';
SIZE : 'size';
ISNUMERIC : 'isnumeric';
ULCAP: 'ulcap';
LLCAP: 'llcap';

islast: ISLAST '('! IDENT ')'!;
isfirst: ISFIRST '('! IDENT ')'!;
ISLAST: 'islast'; 
ISFIRST: 'isfirst';


//string has to be between quotation mark (") characters, can't have newline inside,
//and we can write quotation mark inside of a string escaping it (\")
STRING
    :  '"' 
    ( '\\"'
    | ~('"' | '\n' | '\r')
    )* 
    '"'
    ;

STRINGNOEND
    :  '"' 
    ( '\\"'
    | ~('"' | '\n' | '\r')
    )* 
    ;
   
fragment NOTNEWLINE : ~('\n' | '\r');

ee
  : ~('#'|'?') (NOTNEWLINE | QUOTATIONMARK (.*) | WS* | '\\"' | '\\#' | '\\?' | '\\%' | '\\$')
  ;
  
// We cannot ignore the white space characters, we need them in the output
WS  
    :   (' ' | '\t')//  {$channel = HIDDEN;}
    ;
    
NL 
    :   ( '\n' | '\r\n')
    ;
    
ws: WS;
nl: NL;

COMMENT
    : ((COMMENTCHAR '>' .* '<' COMMENTCHAR WS* NL?)
    | (COMMENTCHAR ~('>') (NOTNEWLINE)* NL?)
    | (COMMANDCHAR 'comment' .* COMMANDCHAR 'endcomment')
    | (COMMANDCHAR '(' .* ')' COMMANDCHAR))
    {$channel = HIDDEN;};

//COMMENT  
//  : (COMMENTCHAR ~('>') (NOTNEWLINE)* NL? {$channel = HIDDEN;}
//  | COMMENTCHAR '>' .* '<' COMMENTCHAR NL? {$channel = HIDDEN;} )
//  ;
  
ESCCOMMENT  : ('\\') COMMENTCHAR ( WS | NOTNEWLINE )*;
// --> command words (can be overrided)
//@command
SIMPLEADAPT: 'adapt';
//@command
EXTENDEDADAPT: 'adapt:';
//@command
ADAPTSAMELEVEL: 'adapt-samelevel';
//@command
ADAPTCOPY: 'adapt-copy';
//@command
EXTENDEDADAPTSAMELEVEL: 'adapt-samelevel:';
//@command
ENDADAPT: 'endadapt';
//@command
SET: 'set';
//@command
SETDEFER: 'set-defer';
//@command
REMOVE: 'remove';
//@command
OUTPUT: 'output';
//@command
OUTDIR: 'outdir';
//@command
OUTFILE: 'outfile';
//@command
INSERT: 'insert';
//@command
INSERTBEFORE: 'insert-before';
//@command
INSERTAFTER: 'insert-after';
//@command
ENDINSERT: 'endinsert';
//@command
EXTENDEDBREAK: 'break:';
//@command
BREAK: 'break';
//@command
ENDBREAK: 'endbreak';
//@command
WHILE: 'while';
//@command
ENDWHILE: 'endwhile';
//@command
SELECT: 'select';
//@command
ENDSELECT: 'endselect';
//@command
OPTIONUNDEFINED: 'option-undefined';
//@command
OPTION: 'option';
//@command
OTHERWISE: 'otherwise';
//@command
ENDOTHERWISE: 'endotherwise';
//@command
ENDOPTION: 'endoption';
//@command
IF: 'art.if';
//@command
ELIF: 'art.elif';
//@command
ELSE: 'art.else';
//@command
IFDEF: 'art.ifdef';
//@command
IFNDEF: 'art.ifndef';
//@command
ENDIF: 'art.endif';
//@command
SETLOOP: 'setloop';
//@command
ENDSETLOOP: 'endsetloop';
//@command
VARS: 'vars';
//@command
ENDVARS: 'endvars';
//@command
VAR: 'var';
//@command
ITER: 'iter';
//@command
MESSAGE:  'message';
//@command
EXTENDEDMESSAGE:  'message:';
//@command
MESSAGEIF:  'message-if';
//@command
EXTENDEDMESSAGEIF:  'message-if:';
//@command
MESSAGEDEBUG:  'message-debug';
//@command
EXTENDEDMESSAGEDEBUG:  'message-debug:';
//@command
ENDMESSAGE:  'endmessage';
//@command
TEXT:  'text';
//@command
ENDTEXT:  'endtext';
// <--

INTEGER : DIGIT+;
fragment SPECCHAR : (QUOTATIONMARK | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' | '>' | '<');
fragment LETTER : ('a'..'z' | 'A'..'Z');
fragment DIGIT : '0'..'9';
IDENT : (LETTER | '_')(LETTER | DIGIT | '_' | '.')*;
fragment DOT: '.';
ANYCHAR: .;