from antlr4 import *
from ExprLexer import ExprLexer
from ExprParser import ExprParser
from visitor import TreeVisitor
import sys
input_stream = FileStream(sys.argv[1])
lexer = ExprLexer(input_stream)
token_stream = CommonTokenStream(lexer)
parser = ExprParser(token_stream)
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
