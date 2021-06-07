from antlr4 import *
from logo3dLexer import logo3dLexer
from logo3dParser import logo3dParser
from visitor import TreeVisitor
import sys

# Leemos el programa l3d.
input_stream = FileStream(sys.argv[1])

# Visitamos el arbol del programa. 
lexer = logo3dLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = logo3dParser(token_stream)
tree = parser.root()
visitor = TreeVisitor()
visitor.visit(tree)

# Para ver como se crea el arbol del programa descomentar la siguiente linea. 
#print(tree.toStringTree(recog=parser))

# Funcion a ejecutar por defecto
nomFunc = "main"
parameters = []

# en caso de que se quiera ejecutar una funcion concreta entraremos en el if, por defecto ejecutamos la funcion main. 
if len(sys.argv)>2:
    nomFunc = sys.argv[2] 
    parameters = sys.argv[3:] 

# Finalmente llamamos a la función execute del visitor con la funcion que deseamos ejecutar y sus parámetros. 
visitor.execute(nomFunc, parameters)
