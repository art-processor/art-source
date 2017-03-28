tree grammar expressionWalker;

options {
  language = Java;
  tokenVocab = expression;
  ASTLabelType = CommonTree;
  backtrack = true;
}

@header {
  package antlrGen.expression;
  import art.utils.Utils;
  import art.exception.MissingVariableException;
  import art.type.MultiValVariable;
  import art.type.ProcessVariable;
  import art.stat.SetRecord;
  import art.stat.StatParam;
  import java.io.IOException;
}

@members {
  boolean notdefined = false;
  String notDefVarName = null;
  
  private List<Long> usedSetIdList = new ArrayList<Long>();
  private StatParam statParam = StatParam.getInstance();
  
  public List<Long> getUsedSetIdList() {
    return this.usedSetIdList;
  }

}

evaluator returns [String result]
  :  e=stringExpression { $result = e;} 
  ;

simpleExpr returns [String result]

  :  ^(r=REFERENCECHAR e=simpleExpr)
    { 
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
        $result = String.valueOf(Utils.getVariables().get(e).getValue());
        }
        
    }
  |  ^(REFERENCECHAR i=IDENT)
    {
        String varName = $i.text;
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
            $result = str2;
        }
    }
  |  ^(REFERENCECHAR i2=IDENT e=simpleExpr) 
    { 
        String varName = $i2.text;
         if (null == Utils.getVariables().get(varName + e)){
            throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine() + ": Variable " + (varName + e) + " is not defined.");
        } else {
            String value = Utils.getVariables().get(varName + e).getValue();
            $result = value; 
        } 
    }
  ;
  
stringExpression returns [String result]
@init{ StringBuilder sb = new StringBuilder();}
  : 
  ( e=expression { sb.append(e); } 
  | str=STRING   { sb.append(str); }
  )+ { $result = sb.toString(); } 
  ;
  
expression returns [String result]
  : (se=simpleExpr { $result = se;}
  | ^(o='+'  {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = String.valueOf(Integer.parseInt(op1) + Integer.parseInt(op2)); Utils.setArithmetic(false);
      }
    }
  | ^(o='-'  {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else { 
        $result = String.valueOf(Integer.parseInt(op1) - Integer.parseInt(op2)); Utils.setArithmetic(false);
      }
    }
  | ^(o='*'  {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = String.valueOf(Integer.parseInt(op1) * Integer.parseInt(op2)); Utils.setArithmetic(false);
      }
    }
  | ^(o='/'  {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
         $result = String.valueOf(Integer.parseInt(op1) / Integer.parseInt(op2)); Utils.setArithmetic(false);
      }
    }
  | ^(o='==' {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = op1.equals(op2) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(o='<=' {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = Integer.parseInt(op1) <= Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(o='>=' {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = Integer.parseInt(op1) >= Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(o='<'  {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = Integer.parseInt(op1) < Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(o='>'  {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = Integer.parseInt(op1) > Integer.parseInt(op2) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(o='&&' {Utils.setArithmetic(true);} op1=expression op2=expression)
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else { 
        $result = (op1.equals("true") && op2.equals("true")) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(o='||' {Utils.setArithmetic(true);} op1=expression op2=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = (op1.equals("true") || op2.equals("true")) ? "true" : "false"; Utils.setArithmetic(false);
      }
    }
  | ^(n=NEGATION e=expression) 
    {
      if (notdefined) {
        Utils.setArithmetic(false);
        throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  notDefVarName + " is not defined.");
      } else {
        $result = String.valueOf(Integer.parseInt(e) * -1);
      }
    }
  | ^(DEFINED e=expression) {notdefined = false;}
    {
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
      $result = res;
    }
  | ^(ARTVARCHAR ISLAST id=IDENT)
    {
    String res = null;
    if (!(null == Utils.getVariables().get($id.text))) {
          ProcessVariable var = Utils.getVariables().get($id.text);
          if (var instanceof MultiValVariable) {
               if (((MultiValVariable) var).isInIteration()) {
                   if (((MultiValVariable) var).getAllValues().size() == ((MultiValVariable) var).getActualIter() + 1) {
                      res = "true";
                   } else res = "false";
               } else {
               res = "false";
               }
          }  else {
           throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +   $id.text + " is not a multi-value variable");       
          }
      } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  $id.text + " is not defined");
      if (res == null) 
      {
          throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  $id.text + " is not defined.");
      }
      $result = res;
    }
  | ^(ARTVARCHAR ISFIRST id=IDENT)
    {
    String res = null;
    if (!(null == Utils.getVariables().get($id.text))) {
          ProcessVariable var = Utils.getVariables().get($id.text);
          if (var instanceof MultiValVariable) {
               if (((MultiValVariable) var).isInIteration()) {
                   if (((MultiValVariable) var).getActualIter() == 0){
                      res = "true";
                   } else res = "false";
               } else {
               res = "false";
               }
          }  else {
           throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +   $id.text + " is not a multi-value variable");       
          }
      } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  $id.text + " is not defined");
      if (res == null) 
      {
          throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
      }
      $result = res;
    }
   | ^(ARTVARCHAR LLCAP id=IDENT)
    {
		    String res = null;
		    if (!(null == Utils.getVariables().get($id.text))) {
		        ProcessVariable var = Utils.getVariables().get($id.text);
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
	      $result = res;
    }
   | ^(ARTVARCHAR ULCAP id=IDENT)
    {
        String res = null;
        if (!(null == Utils.getVariables().get($id.text))) {
            ProcessVariable var = Utils.getVariables().get($id.text);
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
        $result = res;
    }
   | ^(ARTVARCHAR SIZE id=IDENT)
    {
    String res = null;
    if (!(null == Utils.getVariables().get($id.text))) {
          ProcessVariable var = Utils.getVariables().get($id.text);
          if (var instanceof MultiValVariable) {
             res = String.valueOf(((MultiValVariable) var).getAllValues().size());
          }  else {
             res = String.valueOf(1);
          }
      } else throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  $id.text + " is not defined");
      if (res == null) 
      {
          throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  e + " is not defined.");
      }
      $result = res;
    }
   | ^(ARTVARCHAR ISNUMERIC id=IDENT)
    {
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
       $result = res;
    }
  | i2=IDENT {
     //if we use the IDENT in arithmetic expression
     //-----------------
        if (Utils.isArithmetic()) {
            if (null == Utils.getVariables().get($i2.text)){
                throw new MissingVariableException("Error in file: " + Utils.getCurrentFile() + " line: " + Utils.getExpressionLine()  +  ": Variable " +  $i2.text + " is not defined.");
            } else {
                String returnThis = Utils.getVariables().get($i2.text).getValue();
                $result = returnThis;
            }
        } else {
            $result = $i2.text;
        }
     //-------------------
    }
  
  | INTEGER { $result = $INTEGER.text;}
  // ART Processor Variables -->
  | ^(ARTVARCHAR DEBUGMODE) { $result = String.valueOf(Utils.isDebugMode());}
  | ^(ARTVARCHAR OUTFILE) {
   try {
      System.out.println("AAAAAAAAAAAAa");
      $result = Utils.getCurrentOutput();     
      } catch (IOException ex) {
          System.err.println(ex);
      }
   }
  | ^(ARTVARCHAR OUTDIR)   {
  try {
      $result = Utils.getOutputDir(); 
      } catch (IOException ex) {
          System.err.println(ex);
      }
   }
  | ^(ARTVARCHAR CURRENTFILE) { $result = Utils.getCurrentFile();}
  | ^(ARTVARCHAR DEFAULTOUTPUT) { $result = Utils.getDefaultOutput();}
  // <--
  | 'true' {$result = "true";}
  | 'false' {$result = "false";}
  | STRING  { 
                $result = $STRING.text.substring(1, $STRING.text.length()-1); 
            }
       )
  ;