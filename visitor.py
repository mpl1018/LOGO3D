from turtle3d import Turtle3D
import sys

if __name__ is not None and "." in __name__:
    from .logo3dParser import logo3dParser
    from .logo3dVisitor import logo3dVisitor
else:
    from logo3dParser import logo3dParser
    from logo3dVisitor import logo3dVisitor


# Clase definida exclusivamente para guardar los datos asociados a una funcion. 
class RoutineData:
    def __init__(self, parameters, root):
        # En esta variable se guardaran los parametros que recibe la funcion al llamarla. 
        self.parameters = parameters
        # Aqui se guardara la raiz del arbol arbol de sintaxis abstracta en la que comienza la funcion. 
        self.root = root


class TreeVisitor(logo3dVisitor):
    # Función inicializadora de la clase.
    def __init__(self):
        #en este diccionario guardamos objetos de la clase RoutineData. 
        self.data = {}
        # instancia de la clase turtle 3d
        self.turtle = Turtle3D()
        # pila de entornos de ejecucion . Es una pila de diccionarios de entorno, cada diccionario guarda el nombre de las variables (como keys) y su valor asociado. 
        self.pilaDeEntorno = []

    # Funcion inicial para ejecutar una funcion en concreto. Si no se pasa nada por parametro se ejecutara la funcion main. 
    def execute(self, nomFunc, values):
        # Diccionario de variables para el entorno. 
        vars = {}
        for x,y in zip(self.data[nomFunc].parameters, values):
            vars[x] = float(y)
        # Añadimos el diccionario a la pila de entorno. 
        self.pilaDeEntorno.append(vars)
        # Visitamos el nodo raiz de la funcion.
        self.visit(self.data[nomFunc].root)


    # Funcion que visita la definicion de una rutina. Los datos asociados a esta runtina se guardarán en el diccionario data, usando como key el nombre de la funcion
    def visitRoutineDef(self, ctx):
        l = list(ctx.getChildren())
        routineName = l[1].getText()
        # Excepción: funcion definida varias veces
        if routineName in self.data: 
            print("Logo3D Error: La función con nombre " + routineName + " está definida varias veces")
            sys.exit()

        parameters = []
        i = 3
        while (l[i].getText() != ')'):
            x = l[i].getText()
            if x != ',':
                if x in parameters:
                    print("Logo3D Error: En la función " + routineName + " el parametro " + x + " aparece varias veces. ")
                    sys.exit()
                parameters.append(x)
            i += 1
        root = l[i + 2]
        data = RoutineData(parameters, root)
        # añadimos los parametros de la funcion y su raiz de ejecucion en nuestro diccionario
        self.data[routineName] = data

    # Funcion que visita una llamada a una rutina. Puede ser una funcion definida en el mismo archivo o puede ser una funcion de la clase turtle 3d
    def visitRoutineCall(self, ctx):
        l = list(ctx.getChildren())
        routineName = l[0].getText()
        params = []
        i = 2
        while (l[i].getText() != ')'):
            x = l[i].getText()
            if x != ',':
                x = self.visit(l[i])
                params.append(x)
            i += 1
        if (routineName == "forward"):
            self.turtle.forward(params[0])
        elif (routineName == "backward"):
            self.turtle.backward(params[0])
        elif (routineName == "left"):
            self.turtle.left(params[0])
        elif (routineName == "right"):
            self.turtle.right(params[0])
        elif (routineName == "up"):
            self.turtle.up(params[0])
        elif (routineName == "down"):
            self.turtle.down(params[0])
        elif (routineName == "color"):
            self.turtle.setColor(params[0], params[1], params[2])
        elif (routineName == "hide"):
            self.turtle.hide()
        elif (routineName == "show"):
            self.turtle.show()
        else:
            i = 2
            j = 0
            vars = {}
            while (l[i].getText() != ')'):
                x = l[i].getText()
                if x != ',':
                    x = self.visit(l[i])
                    try:
                        varName = self.data[routineName].parameters[j]
                        j += 1
                        vars[varName] = x
                    except KeyError: 
                        print("Logo3D Error: Llamada a función " + routineName + " no definida.")
                        sys.exit()

                i += 1
            if len(vars)!= len(self.data[routineName].parameters):
                    print("Logo3D Error: La función " + routineName + " esperaba " + str(len(self.data[routineName].parameters)) + " argumentos pero ha recibido " + str(len(vars)) + ".")
                    sys.exit()
            self.pilaDeEntorno.append(vars)
            self.visitChildren(self.data[routineName].root)
            self.pilaDeEntorno.pop()

    # Funcion que visita la operacion de asignacion
    def visitAsignacion(self, ctx):
        l = list(ctx.getChildren())
        var = l[0].getText()
        value = self.visit(l[2])
        self.pilaDeEntorno[-1][var] = value

    # Funcion que visita la operacion de lectura
    def visitRead(self, ctx):
        l = list(ctx.getChildren())
        var = l[1].getText()
        val = input()
        self.pilaDeEntorno[-1][var] = float(val)

    # Funcion que visita la operacion de escritura
    def visitWrite(self, ctx):
        l = list(ctx.getChildren())
        expr = self.visit(l[1])
        print(expr)

    # Funcion que visita la construccion if
    def visitIf(self, ctx):
        l = list(ctx.getChildren())
        condition = self.visit(l[1])
        if (condition < -1e-6 or condition > 1e-6):
            i = 3
            while (l[i].getText() != 'END'):
                self.visit(l[i])
                i += 1

    # Funcion que visita la construccion if else
    def visitIfElse(self, ctx):
        l = list(ctx.getChildren())
        condition = self.visit(l[1])
        if (condition < -1e-6 or condition > 1e-6):
            i = 3
            while (l[i].getText() != 'ELSE'):
                self.visit(l[i])
                i += 1
        else:
            i = 5
            while (l[i].getText() != 'END'):
                self.visit(l[i])
                i += 1

    # Funcion que visita la construccion while
    def visitWhile(self, ctx):
        l = list(ctx.getChildren())
        condition = self.visit(l[1])
        while (condition < -1e-6 or condition > 1e-6):
            i = 3
            while (l[i].getText() != 'END'):
                self.visit(l[i])
                i += 1
            condition = self.visit(l[1])

    # Funcion que visita la construccion for
    def visitFor(self, ctx):
        l = list(ctx.getChildren())
        fromNum = int(self.visit(l[3]))
        toNum = int(self.visit(l[5]))
        varIni = l[1].getText()
        self.pilaDeEntorno[-1][varIni] = fromNum

        while self.pilaDeEntorno[-1][varIni] <= toNum:
            i = 7
            while (l[i].getText() != 'END'):
                self.visit(l[i])
                i += 1
            self.pilaDeEntorno[-1][varIni] += 1

    # Funcion que visita la operacion de multiplicacion
    def visitMult(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a * b

    # Funcion que visita la operacion de division
    def visitDiv(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        try:
            return a / b
        except ZeroDivisionError: 
            print("Logo3D Error: No están permitidas las divisiones por cero.")
            sys.exit()
        except ZeroDivisionError: 
            print("Logo3D Error: Algo ha salido mal al hacer la división.")
            sys.exit()

    # Funcion que visita la operacion de suma
    def visitSum(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        # Aqui me saltaba un error al intentar hacerlo como en las transparencias, con la linea "ExprParser.symbolicNames[n.getSymbol().type]" y he encontrado esta otra manera. ⬇
        if (str(type(l[0])) == "<class 'logo3dParser.logo3dParser.StrContext'>" or str(type(a)) =="<class 'str'>"):
            return a[:-1] + b[1:]
        return a + b

    # Funcion que visita la operacion de resta
    def visitSub(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a - b

    # Funcion que visita el operador de igualdad
    def visitEq(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a == b

    # Funcion que visita el operador de mayor
    def visitGr(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a > b

    # Funcion que visita el operador de mayor igual
    def visitGrE(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a >= b

    # Funcion que visita el operador de no igualdad
    def visitNotEq(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a != b

    # Funcion que visita el operador de menor
    def visitLess(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a < b

    # Funcion que visita el operador de menor igual
    def visitLessEq(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a <= b
    
    # Funcion que visita la operacion de potencia
    def visitPower(self, ctx): 
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a ** b 
    
    # Funcion que visita las expresiones parentizadas
    def visitBraquets(self, ctx): 
        l = list(ctx.getChildren())
        return self.visit(l[1])

    # Funcion que visita los tipos de dato string
    def visitStr(self, ctx): 
        l = list(ctx.getChildren())
        return (l[0].getText())

    # Funcion que visita los numeros negativos
    def visitNeg(self,ctx): 
        l = list(ctx.getChildren())
        a = self.visit(l[1]); 
        return -a; 

    # Funcion que visita numeros 
    def visitVal(self, ctx):
        l = list(ctx.getChildren())
        return float(l[0].getText())

    # Funcion que visita variables
    def visitVar(self, ctx):
        l = list(ctx.getChildren())
        try:
            return self.pilaDeEntorno[-1][l[0].getText()]
        except KeyError: 
            print("Logo3D Error: La variable " + l[0].getText() + " no ha sido definida.")
            sys.exit()
