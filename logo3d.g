grammar logo3d;
root : statements* EOF ;

routineBody: statements *; 

statements :'PROC' VAR '(' VAR* (','VAR)*  ')' 'IS' routineBody  'END' #RoutineDef
           | VAR '(' expr* (','expr)*  ')' #RoutineCall
           |'IF' expr 'THEN' statements+ 'END' #If
           | 'IF' expr 'THEN' statements+ 'ELSE' statements+ 'END' #IfElse
           | 'WHILE' expr 'DO' statements+ 'END' #While
           | 'FOR' VAR 'FROM' expr 'TO' expr 'DO' statements+ 'END' #For
           |  VAR ':=' expr # Asignacion
           | '>>' VAR  # Read
           | '<<' expr # Write
           ; 

expr :'(' expr ')' #Braquets
     | expr '#' expr #Power
     | expr '*' expr # Mult
     | expr '/' expr # Div
     | expr '+' expr # Sum
     | expr '-' expr # Sub
     | expr '==' expr #Eq
     | expr '>' expr #Gr
     | expr '>=' expr #GrE
     | expr '!=' expr #NotEq
     | expr '<' expr #Less
     | expr '<=' expr #LessEq
     | NUM           # Val
     | VAR           # Var
     ;
NUM : [0-9]+[.]*[0-9]* ;
VAR : [_a-zA-Z]+[0-9]*;
WS  : [ \n\r]+ -> skip ;
COMMENT : '//' ~[\n\r]* -> skip ;