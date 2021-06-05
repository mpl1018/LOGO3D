from antlr4 import *
from logo3dLexer import logo3dLexer
from logo3dParser import logo3dParser
from visitor import TreeVisitor
import sys
input_stream = FileStream(sys.argv[1])
lexer = logo3dLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = logo3dParser(token_stream)
tree = parser.root()
visitor = TreeVisitor()
visitor.visit(tree)
print(tree.toStringTree(recog=parser))

nomFunc = "main"
parameters = []

if len(sys.argv)>2:
    nomFunc = sys.argv[2] 
    parameters = sys.argv[3:] 

visitor.execute(nomFunc, parameters)
