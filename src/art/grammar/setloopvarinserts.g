grammar setloopvarinserts;

options {
  language = Java;
  output = AST;
  ASTLabelType = CommonTree;
  backtrack = true;
}

tokens {
  NEGATION;
}
 
@header {
  package antlrGen.command;
  
  import art.utils.Utils;
  import art.utils.SetLoopInfo;
}

@lexer::header {
  package antlrGen.command;
}

evaluator 
@init{StringBuilder sb = new StringBuilder();}
  :
  ( (ws | nl)* COMMANDCHAR v=varDesc {sb.append($v.text);} )* EOF
  ;

varDesc
  : 'var' ws* i=IDENT  ws* ('=' ws* e=expression ws*)? (ws | nl)*
  
   {
         //add the new variable to the setloop
         if (Utils.canWrite()){
             SetLoopInfo.addVariableToSetLoop($i.text, $e.text);
         }
    }
    
  ;

//expressions -->
expression   
  : freeExpression
  | stringExpression
  ;
  
stringExpression
  : (nameExpression | STRING)+
  ;
  
nameExpression
  : EPRESSIONCHAR! ws!* simpleExpr ws!* EPRESSIONCHAR!
  | EPRESSIONCHAR! ws!* freeExpression ws!* EPRESSIONCHAR!+
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
  : relation (('&&'^ | '||'^) relation)*
  ;

//<-- expressions

//arithmetic expressions -->

arithmeticTerm
    : ws* (IDENT
    | '('! ws!* freeExpression ws!* ')'!
    | INTEGER) ws*
    ;  
    
relation
  : add (('=='^ | '!='^ | '<'^ | '<='^ | '>='^ | '>'^) add)*
  ;

add
  : mult (('+'^ | '-'^) mult)*
  ;
  
mult
  : unary (('*'^ | '/'^) unary)*
  ;
  
unary
  : ('+'! | negation^)* arithmeticTerm
  ;  

negation
  : '-' -> NEGATION
  ;

//<-- arithmetic expressions

//Special chars
COMMANDCHAR: '#';
EPRESSIONCHAR: '?';
REFERENCECHAR: '@';
fragment QUOTATIONMARK: '"';

//string has to be between quotation mark (") characters, can't have newline inside,
//and we can write quotation mark inside of a string escaping it (\")
STRING
    :  '"' 
    ( '\\"'
    | ~('"' | '\n' | '\r')
    )* 
    '"'
    ;
   
fragment NOTNEWLINE : ~('\n' | '\r');

ee
  : ~('#'|'?') (NOTNEWLINE | WS* | '\\"' | '\\#' | '\\?')
  ;

// We cannot ignore the white space characters, we need them in the output
WS  
    :   (' ' | '\t')//  {$channel = HIDDEN;}
    ;
    
NL 
    :   ('\r' | '\n')
    ;
    
ws: WS;
nl: NL;

INTEGER : DIGIT+;
SPECCHAR : (QUOTATIONMARK | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ' | '>' | '<');
fragment LETTER : ('a'..'z' | 'A'..'Z');
fragment DIGIT : '0'..'9';
IDENT : (LETTER | DIGIT | '_' | '.')*;
fragment DOT: '.';
ANYCHAR: .;