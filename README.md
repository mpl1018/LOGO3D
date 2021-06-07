## PRÁCTICA DE PYTHON Y COMPILADORES

## Descripción

Esta es mi solución a la práctica de Python y compiladores de la asignatura de Lenguajes de Programación. Enunciado disponible [aqui](https://github.com/jordi-petit/lp-logo3d-2021)

## Requisitos

**Debemos tener java instalado.**

### Instalación

Antes de correr la práctica en local debemos instalar algunas extensiones.

1.- Descargar en instalar el archivo jar de ANTLR4 tal y como se indica en el siguiente [link](https://www.antlr.org/).

2.- Desde la carpeta raiz ejecutar el siguiente comando.

```
pip install -r requirements.txt
```

### Generación de los archivos necesarios

Una vez hecha la instalación del paso anterior debemos ejecutar el siguiente comando:

```
antlr4 -Dlanguage=Python3 -no-listener -visitor  logo3d.g
```

Dependiendo del SO que tengamos es posible que en vez de usar el commando antrl4 directamente tengamos que generar un .bat, o ejecutar java org.antlr.v4.Tool, dependiendo de los pasos que hayamos seguido en el punto 1 del apartado anterior.

Y ya estamos listos para ejecutar la práctica :)

### Como ejecutar un progrma de logo3d

Antes de nada debemos tener un programa válido en logo3d, como el siguiente programa.l3d:

```
PROC cercle(mida, costats) IS
    FOR i FROM 1 TO costats DO
        forward(mida)
        left(360 / costats)
    END
END

PROC espiral(cercles) IS
    IF cercles > 0 THEN
        cercle(1, 12)
        up(5)
        espiral(cercles - 1)
    END
END

PROC main() IS
    espiral(5)
END
```

Ahora simplemente tenemos que ejecutar

```
pthon logo3d.py programa.l3d
```

## Cómo funciona.

La práctica cuenta con dos partes principales, como se indica en el [enunciado](https://github.com/jordi-petit/lp-logo3d-2021):

- Interprete de logo3d, a la que le corresponden los archivos: [logo3D.g](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.g), [logo3D.py](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.py) y [visitor.py](https://github.com/mpl1018/LOGO3D/blob/main/visitor.py).
- Implementació nde la clase turtle3d, a la que le corresponde el archivo [turtle3d.py](https://github.com/mpl1018/LOGO3D/blob/main/turtle3d.py).

A continuación describiré cada uno de los dos puntos, explicando con detalle cada uno de los archivos y el funcionamiento de su conjunto.

### Implementación de la clase turtle 3d.

Correspondiente al archivo [turtle3d.py](https://github.com/mpl1018/LOGO3D/blob/main/turtle3d.py). Esta clase ha sido documentada con docstrings, de modo que podemos consultar información sobre cada una de las funciones haciendo _help(\_nombre_func)_ o leyendo el código directamente.

De todas formas, explicaré a grandes rasgos en qué consiste esta clase y las operaciones que puede realizar.

El objetivo de esta clase es simular el escenario 3D creado por una tortuga que deja un rastro al caminar, como en los típicos lenguajes de programación visual para niños, pero en 3D.

Para ello, se ha utilizado la librería de vpython (desarrollada en la universidad Carnegie Mellon), que ha facilitado la mayor parte del trabajo.

Esta clase implementa diversas funciones públicas (todas documentadas en el mismo código) que nos permiten mover a la tortuga por todo el espacio 3d.

- _forward (numero de pasos)_ y _backward ( numero de pasos )_, las cuales permiten que la tortuga se mueva.
- _up(grados)_, _down(grados)_, _left(grados)_ y _write(grados)_ para cambiar de dirección.
- _show_ y _hide_ para pintar o no al mover a la tortuga.
- _setColor(r,g,b)_ para definir el color con el cual quieres que la tortuga pinte al moverse.

Para llevar a cabo todas estas operaciones, la clase mantiene un estado interno en el que se guarda el punto del espacio 3d en el que está la tortuga, la dirección a la que está mirando, si está pintando o no al avanzar y el color con el que está pintando.

Por otra parte, también hay implementada una operación privada \_paint (utilizada por las funciones _forward_ y _backward_) que dado un punto en el espacio 3d mueve la tortuga hasta ese punto.

### Implementación del intérprete de logo3d.

Correspondiente a los archivos [logo3d.g](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.g), [logo3D.py](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.py) y [visitor.py](https://github.com/mpl1018/LOGO3D/blob/main/visitor.py).

Entre todos los archivos correspondientes a este apartado existe una estrecha relación. Empezaré describiendo cada uno de ellos y terminaré dando una visión general del conjunto.

#### [logo3d.g](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.g)

Correspondiente a [este archivo](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.g).

Este archivo corresponde a la gramática del lenguaje que queremos crear, logo3d.

Como podemos ver en el archivo, el lenguaje que aceptará nuestra gramática será un conjunto de _statements_.

`root : statements* EOF ;`

Cada uno de estos statements puede representar distintas operaciones, veámoslas:

```
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
```

En general los diferentes _statements_ son bastante descriptivos por si mismos, pero merece la pena explicar la diferencia entre los dos primeros.

El primer tipo de _statement_ corresponde a la definición de una rutina. Como podemos ver, entre la palabra IS y la palabra END se encuentra el _routineBody_, que se define de la siguiente manera:

```
routineBody: statements *;
```

Es decir, el cuerpo de una rutina está formado por cero o más _statements_.

Por otra parte el segundo statement corresponde a la llamada a una rutina, que ha de estar definida en el mismo archivo a menos que sea una rutina de la clase tortuga.

Además, podemos ver que los _statements_ utilizan expresiones, definidos de la siguiente manera:

```
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
     | '-' expr      #Neg
     | NUM           # Val
     | VAR           # Var
     | STRING        # Str
     ;
```

Es decir, las expresiones corresponden a valores, expresados como valores en sí mismos (NUM, VAR, STRING) o como resultados de aplicar operadores lógicos y matemáticos.

Finalmente, la expresiones NUM, VAR y STRING, quedan definidos de la siguiente manera, utilizando condiciones regex:

```
NUM : [0-9]+[.]*[0-9]* ;
VAR : [_a-zA-Z]+[0-9]*;
STRING : '"' ( '\\' [\\"] | ~[\\"\r\n] )* '"';
```

- NUM reconoce todos los números tanto enteros como con decimales. Los números negativos también son reconocidos gracias a la expresión

#### [logo3D.py](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.py)

Este sería el archivo principal de nuestro "compilador". Desde aquí leeremos nuestro programa en l3d y llamaremos al la función _execute_ de la clase visitor, que ejecutará el programa en l3d.

#### [visitor.py](https://github.com/mpl1018/LOGO3D/blob/main/visitor.py)

### Extensiones
