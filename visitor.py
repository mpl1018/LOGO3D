from turtle3d import Turtle3D
import sys

if __name__ is not None and "." in __name__:
    from .logo3dParser import logo3dParser
    from .logo3dVisitor import logo3dVisitor
else:
    from logo3dParser import logo3dParser
    from logo3dVisitor import logo3dVisitor



class RoutineData:
    def __init__(self, parameters, root):
        self.parameters = parameters
        self.root = root


class TreeVisitor(logo3dVisitor):
    def __init__(self):
        self.data = {}
        self.turtle = Turtle3D()
        self.nivell = 0 
        self.pilaDeEntorno = []

    def execute(self, nomFunc, values):
        vars = {}
        for x,y in zip(self.data[nomFunc].parameters, values):
            vars[x] = float(y)
        self.pilaDeEntorno.append(vars)
        self.visit(self.data[nomFunc].root)

    def visitRoutineDef(self, ctx):
        l = list(ctx.getChildren())
        routineName = l[1].getText()
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
        self.data[routineName] = data

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

    def visitAsignacion(self, ctx):
        l = list(ctx.getChildren())
        var = l[0].getText()
        value = self.visit(l[2])
        self.pilaDeEntorno[-1][var] = value
        # print(self.vars)

    def visitRead(self, ctx):
        l = list(ctx.getChildren())
        var = l[1].getText()
        val = input()
        self.pilaDeEntorno[-1][var] = float(val)
        # print(self.vars)

    def visitWrite(self, ctx):
        l = list(ctx.getChildren())
        expr = self.visit(l[1])
        print(expr)

    def visitIf(self, ctx):
        l = list(ctx.getChildren())
        condition = self.visit(l[1])
        if (condition < -1e-6 or condition > 1e-6):
            i = 3
            while (l[i].getText() != 'END'):
                self.visit(l[i])
                i += 1

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

    def visitWhile(self, ctx):
        l = list(ctx.getChildren())
        condition = self.visit(l[1])
        # print(l)
        while (condition < -1e-6 or condition > 1e-6):
            i = 3
            while (l[i].getText() != 'END'):
                self.visit(l[i])
                i += 1
            condition = self.visit(l[1])

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

    def visitMult(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a * b

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

    def visitSum(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a + b

    def visitSub(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a - b

    def visitEq(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a == b

    def visitGr(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a > b

    def visitGrE(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a >= b

    def visitNotEq(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a != b

    def visitLess(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a < b

    def visitLessEq(self, ctx):
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a <= b
    
    def visitPower(self, ctx): 
        l = list(ctx.getChildren())
        a = self.visit(l[0])
        b = self.visit(l[2])
        return a ** b 
    
    def visitBraquets(self, ctx): 
        l = list(ctx.getChildren())
        return self.visit(l[1])

    def visitVal(self, ctx):
        l = list(ctx.getChildren())
        return float(l[0].getText())

    def visitVar(self, ctx):
        l = list(ctx.getChildren())
        try:
            return self.pilaDeEntorno[-1][l[0].getText()]
        except KeyError: 
            print("Logo3D Error: La variable " + l[0].getText() + " no ha sido definida.")
            sys.exit()
