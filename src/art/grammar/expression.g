grammar expression;

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
  DEBUGMODECOMMAND;
}

@header {
  package antlrGen.expression;
}

@lexer::header {
  package antlrGen.expression;
}

evaluator 
  : 
  (stringExpression 
  | freeExpression
  | STRING  
  )*
  ;

//expressions -->
expression   
  : freeExpression
  | stringExpression
  ;
  
stringExpression
  : (STRING* nameExpression+ STRING*)+
  ;
  
nameExpression
  : EPRESSIONCHAR! simpleExpr^ EPRESSIONCHAR!
  | EPRESSIONCHAR! freeExpression EPRESSIONCHAR!+
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
  : ( r1=relation  (('&&'^ | '||'^) r2=relation)*)
  ;

//<-- expressions

//arithmetic expressions -->

arithmeticTerm
    : (IDENT
    | '('! freeExpression ')'!
    | ('true' | 'false')
    | INTEGER)
    ;  
    
relation
  : (add (('=='^ | '!='^ | '<'^ | '<='^ | '>='^ | '>'^) add)* )
  ;

add
  : mult (('+'^ | '-'^) mult)*
  ;
  
mult
  : unary (('*'^ | '/'^) unary)*
  ;
  
unary
  : ('+'! | negation^)* arithmeticTerm
  | defined^ arithmeticTerm
  | bpv
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
  
//debugmode
//  : '$' DEBUGMODE -> '(' '$' DEBUGMODE ')'
//  ;
  
//boolean process variable
bpv 
  : artvarchar^ ISLAST arithmeticTerm
  | artvarchar^ ISFIRST arithmeticTerm
  | artvarchar^ SIZE arithmeticTerm
  | artvarchar^ ISNUMERIC arithmeticTerm
  | artvarchar^ ULCAP arithmeticTerm
  | artvarchar^ LLCAP arithmeticTerm
  | artvarchar^ DEBUGMODE
  | artvarchar^ CURRENTFILE
  | artvarchar^ OUTFILE
  | artvarchar^ DEFAULTOUTPUT
  | artvarchar^ OUTDIR
  ;

//<-- arithmetic expressions

//Special chars
COMMANDCHAR: '#';
EPRESSIONCHAR: '?';
REFERENCECHAR: '@';
COMMENTCHAR: '%';

CURRENTFILE : 'currentfile';
DEFAULTOUTPUT :'defaultoutput';
DEBUGMODE : 'debugmode';
OUTFILE : 'outfile';
OUTDIR : 'outdir';
SIZE : 'size';
ISNUMERIC : 'isnumeric';
ULCAP: 'ulcap';
LLCAP: 'llcap';

islast: ISLAST '('! IDENT ')'!;
isfirst: ISFIRST '('! IDENT ')'!;
ISLAST: 'islast'; 
ISFIRST: 'isfirst';


//string has to be between quotation mark (") characters, can't have new line inside,
//and we can write quotation mark inside of a string escaping it (\")
STRING
    :  '"' 
    ( '\\"'
    | ~('"' | '\n' | '\r')
    )* 
    '"'
    ;
   
fragment NOTNEWLINE : ~('\n' | '\r');
 
/* We're going to ignore all white space characters */
WS  
    :   (' ' | '\t' )  {$channel = HIDDEN;}
    ;

NL 
    :   ( '\n' | '\r\n')
    ;
        
COMMENT
    : ((COMMENTCHAR '>' .* '<' COMMENTCHAR WS* NL?)
    | (COMMENTCHAR ~('>') (NOTNEWLINE)* NL?)
    | (COMMANDCHAR 'comment' .* COMMANDCHAR 'endcomment')
    | (COMMANDCHAR '(' .* ')' COMMANDCHAR))
    {$channel = HIDDEN;};

INTEGER : DIGIT+;
SPECCHAR : ('"' | REFERENCECHAR | COMMANDCHAR | EPRESSIONCHAR | '+' | '-' | '*' | '/' | '(' | ')' | ',' | '|' | ' ');
fragment LETTER : ('a'..'z' | 'A'..'Z');
fragment DIGIT : '0'..'9';
IDENT : (LETTER | DIGIT | '_' | '.')*;
ANYCHAR: .;