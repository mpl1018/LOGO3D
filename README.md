## PRÁCTICA DE PYTHON Y COMPILADORES

## Índice de contenidos

- Descripción
- Requisitos
  - Instalación
  - Generación de archivos necesarios
  - Como ejecutar un programa en logo3d
- Cómo funciona
  - Implementación de la clase turtle 3d
  - Implementación del intérprete de logo3d
  - Excepciones
  - Extensiones
  - Visión general

## Descripción

Esta es mi solución a la práctica de Python y compiladores de la asignatura de Lenguajes de Programación. Enunciado disponible [aqui](https://github.com/jordi-petit/lp-logo3d-2021)

## Requisitos

**Importante: debemos tener java instalado.** Podemos comprobarlo abriendo escribiendo el siguiente comando en una terminal: `java --version`.

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
python logo3d.py programa.l3d
```

O si queremos ejecutar una función en concreto, por ejemplo _foo(par1, par2)_ con _par1_=10 y _par2_=15, deberemos ejecutar:

```
python logo3d.py programa.l3d foo 10 15
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

- NUM reconoce todos los números tanto enteros como con decimales. Los números negativos también son reconocidos gracias a la expresión Neg.
- VAR reconoce los nombres de las variables de entorno. Estas variables serán las claves del diccionario de variables de entorno en el archivo [visitor.py](https://github.com/mpl1018/LOGO3D/blob/main/visitor.py). Como restricción, estas variables han de estar formadas por letras de la a a la z, por el símbolo "\_" y solo puede tener números al final del nombre.
- STRING reconoce las strings, que siempre han de ser escritas entre comillas, así: "_string de ejemplo_".

#### [logo3D.py](https://github.com/mpl1018/LOGO3D/blob/main/logo3d.py)

Este sería el archivo principal de nuestro intérprete, el que deberemos ejecutar para ejecutar un programa en l3d. No obstante, este es el archivo más sencillo.

Desde aquí leeremos nuestro programa en l3d y llamaremos al la función _visit_ y _execute_ de la clase visitor, que leerá ejecutará el programa en l3d. El funcionamiento más detallado de este proceso se encuentra en la siguiente sección.

Por defecto ejecuta la función _main_, a no ser que se le indique otra función a ejecutar.

#### [visitor.py](https://github.com/mpl1018/LOGO3D/blob/main/visitor.py)

Este archivo es el que hace la mayor parte del trabajo de nuestro intérprete: guarda el estado de la ejecución, comprueba algunas excepciones y, lo más importante, interpreta cada una de las instrucciones codificadas en logo3d y ejecuta el código necesario en python para que se cumplan.

En este documento se explicará una visión global del funcionamiento del interprete, para información más detallada sobre el funcionamiento de una función concreta se recomienda leer los comentarios escritos en el propio archivo.

##### Pila de entornos.

Para entender como funciona el intérprete es importante aclarar el concepto de pila de entornos, que tiene cierta similitud con la pila de llamadas o _call stack_ al que estamos acostumbrados en bajo nivel.

En el lenguaje logo3d, cada rutina tiene su propio entorno o _scope_, que no comparte con nadie más. Además no existen las variables ni valores globales. Esto nos permite crear una pila de entornos, donde el primer elemento de la pila será el entorno de la primera función ejecutada, por defecto, _main_. Cuando hagamos una llamada a una rutina, añadiremos a la pila un nuevo entorno (que al principio solo tendrá las variables que le pasamos como parámetro a la función). Cuando retornemos a la función desde la que hicimos la llamada, haremos _pop_ del entorno de la función llamada, como se puede ver en el siguiente fragmento de código de la función _visitRoutineCall_:

```python
....

# Añadimos el entorno de la nueva función a la pila
self.pilaDeEntorno.append(vars)
# Ejecutamos la función
self.visitChildren(self.data[routineName].root)
# Borramos el entorno de la pila (el entorno anterior vuelve a estar en la cima de la pila)
self.pilaDeEntorno.pop()
```

Cabe mencionar que entorno usado será siempre el que esté en la cima de la pila. La implementació de un entorno simplemente consiste en un diccionario con key=nombreVariable valor=valorVariable.

##### Funcionamiento

Desde el archivo logo3d.py podemos ver que se hacen dos llamadas a funciones de la clase TreeVisitor, la primera es `visitor.visit(tree)` y la segunda es `visitor.execute(nomFunc, parameters)`. Podemos entenderlo como que la primera llamada lee el programa viendo que funciones hay definidas y que parametros necesita y la segunda llamada ejecuta una función concreta, por defecto _main_. Veámoslo con más detalle:

Como hemos visto en la parte de la gramática del lenguaje, un programa en logo3d está formado por un conjunto de _statements_ . Si el programa es correcto, estos _statements_ más exteriores serán la definición de una o más funciones. En la primera llamada `visitor.visit(tree)`, visitaremos cada una de estas definiciones usando la función _visitRoutineDef_. Esta función lo que hará será crear para cada función un objeto del siguiente tipo:

```python
# Clase definida exclusivamente para guardar los datos asociados a una funcion.
class RoutineData:
    def __init__(self, parameters, root):
        # En esta variable se guardaran los parametros que recibe la funcion al llamarla.
        self.parameters = parameters
        # Aqui se guardara la raiz del arbol arbol de sintaxis abstracta en la que comienza la funcion.
        self.root = root
```

Como se lee en los comentarios, guardaremos dos datos para cada definición: una lista con los parámetros de la función y la raíz del árbol de sintaxis asociada al inicio del cuerpo de la función.

Cada uno de estos objetos RoutineData los guarderemos en un diccionario llamado data, en la clase TreeVisitor. Las claves del diccionario serán los nombres de las funciones, como podemos ver en el siguiente fragmento de la función _visitRoutineDef_:

```python
...
data = RoutineData(parameters, root)
self.data[routineName] = data
```

Ahora, cuando ejecutemos la llamada `visitor.execute(nomFunc, parameters)` desde el archivo logo3d.py, ya tendremos en el diccionario _this.data_ todos los datos que necesitamos para ejecutar cualquier función del programa. Por defecto ejecutaremos la función _main_, pero podemos ejecutar cualquier otra.

Lo que hace la función _execute_ es lo siguiente:

- Cargar el nuevo entorno de la función, añadiendo las variables que se hayan pasado como parámetros si es necesario.
- Visitar la raíz del AST donde comienza el cuerpo de la rutina. Este objeto lo habíamos guardado con anterioridad en el diccionario data. Recursivamente se irán visitando cada uno de los _statements_ y expresiones por las que está formada la rutina.

Esta sería la visión general del funcionamiento de la clase TreeVisitor.

Cabe mencionar que, para el correcto funcionamiento del intérprete, para cada una de los diferentes _statements_ y expresiones de la gramática se ha de crear una función que la visite. Todas estas funciones están comentadas en el propio código.

### Excepciones

Pese a que logo3d es un lenguaje muy simple, se pueden cometer númerosos errores a la hora de programar. En está práctica se han implementado algunas excepciones, aunque se podrían implementar muchas más.

- Una función no puede estar definida varias veces. [Link al código](https://github.com/mpl1018/LOGO3D/blob/f781a07e75cb22b97661f6830c0dc24844da3f6a/visitor.py#L48).
- Un parámetro no puede aparecer varias veces en la definición de una función. [Link al código](https://github.com/mpl1018/LOGO3D/blob/f781a07e75cb22b97661f6830c0dc24844da3f6a/visitor.py#L57).
- Llamada a una función no definida. [Link al código](https://github.com/mpl1018/LOGO3D/blob/f781a07e75cb22b97661f6830c0dc24844da3f6a/visitor.py#L108).
- Llamada a una función con un número de argumentos erróneo. [Link al código](https://github.com/mpl1018/LOGO3D/blob/f781a07e75cb22b97661f6830c0dc24844da3f6a/visitor.py#L113).
- División por 0. [Link al código](https://github.com/mpl1018/LOGO3D/blob/f781a07e75cb22b97661f6830c0dc24844da3f6a/visitor.py#L205).

### Extensiones

Para completar la práctica se han realizado un par de extensiones sencillas. Los tests asociados a cada una de las extensiones se pueden encontrar en la carpeta _TESTS_.

1. String como tipo de dato. Además existen varias operaciones que podemos hacer con ellas, como leer, escribir y concatenar dos srtings (con el operados de suma). Ejemplo:

```
PROC main() IS
    x:="Hola"
    << x + " mundo."
    // output "Hola mundo."
END
```

2. Operación de potencia. Implementada con el símbolo _#_. Podemos elevar un número a otro de la siguiente manera.

```
PROC main() IS
    << 5.4 # 3
    // output 157.46400000000003
END
```

### Visión general.

Ahora que ya conocemos el funcionamiento tanto de la clase Turtle3D como el de la clase TreeVisitor, es mucho más sencillo entender como funciona el intérprete en su conjunto.

La única integración que se ha de hacer en TreeVisitor para incorporar a Turtle3D es comprobar, en cada llamada a subrutina (en la función _visitRoutineCall_) si la función a la que se está haciendo la llamada es alguna de las de la clase Turtle3d (_forward, backward, left, setColor..._). En caso afirmativo se llamará a la instancia de la clase Turtle3D para ejecute dicha función.
