grammar ProgLang;

@header{
    // To be completed
}

@members {
    // To be completed
}

program
    : // To be completed
    ;





/***
 * You can use the lexical analyzer defined
 * below.  No modification is necessary, but
 * you are permitted to change it as you like.
 */

fragment Letter
    : ('a' .. 'z') 
    | ('A' .. 'Z') 
    | '_'
    ;

fragment Digit
    : '0' .. '9'
    ;

ID  : Letter (Letter | Digit)*
    ;

Number
    : '-'? Digit+ ('.' Digit+)?
    ;

Whitespace
    : (' ' | '\t' | '\r' | '\n')+ -> skip
    ;
