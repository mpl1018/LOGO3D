from vpython import *
import math


class Turtle3D:
    """Esta es la clase Turtle3D, en la que se especifican todos los metodos, atributos de clase, operaciones publicas y operaciones privadas """
    def __init__(self):
        """Esta es la funcion inicializadora de la clase Turtle3D. Aqui inicializamos todos los atributos privados asi como los parametros de la escena. Horizontal y vertical degrees indican hacia donde 'apunta' la tortuga, indican la direccion en grados  respecto al eje horizontal y vertical respectivamente. El atributo coordenadas nos indica la posicion de la tortuga en el espacio 3d. El atributo color indica el color con el que esta pintando la tortuga. Por ultimo, el atributo isPainting indica si la tortuga pintara o no al avanzar. """
        self.__horizontalDegrees = 0
        self.__verticalDegrees = 0
        self.__coordenadas = (0, 0, 0)
        self.__color = (1, 0, 0)
        self.__isPainting = True
        scene.height = scene.width = 1000
        scene.autocenter = True

    def __paint(self, finishVector):
        """Funcion privada que, dadas unas coordenadas finales, pinta un un cilindro del color correspondiente al atributo privado color, desde las coordenadas actuales del atributo privado coordenadas hasta las coordenadas finales pasadas como parametro."""
        startVector = vector(
            self.__coordenadas[0],
            self.__coordenadas[1],
            self.__coordenadas[2])
        colorVector = vector(self.__color[0], self.__color[1], self.__color[2])
        cylinder(
            pos=startVector,
            axis=finishVector -
            startVector,
            radius=0.1).color = colorVector
        sphere(pos=startVector, radius=0.2).color = colorVector
        sphere(pos=finishVector, radius=0.2).color = colorVector

    def forward(self, units):
        """Funcion publica que, dadas x de unidades, avanza la tortuga x unidades en la direccion en la que este mirando. Si el atributo isPainting esta activado, dejara un cilidro del color del atributo color a su rastro."""
        horizontalRadians = math.radians(self.__horizontalDegrees)
        verticalRadians = math.radians(self.__verticalDegrees)
        finishVector = (
            self.__coordenadas[0] +
            math.cos(horizontalRadians) *
            math.cos(verticalRadians) *
            units,
            self.__coordenadas[1] +
            math.sin(verticalRadians) *
            units,
            self.__coordenadas[2] +
            math.sin(horizontalRadians) *
            math.cos(verticalRadians) *
            units)
        if (self.__isPainting):
            self.__paint(
                vector(
                    finishVector[0],
                    finishVector[1],
                    finishVector[2]))
        self.__coordenadas = finishVector

    def backward(self, units):
        """Funcion publica que, dadas x de unidades, retrocede la tortuga x unidades en la direccion opuesta a la que este mirando. Si el atributo isPainting esta activado, dejara un cilidro del color del atributo color a su rastro."""
        horizontalRadians = math.radians(self.__horizontalDegrees)
        verticalRadians = math.radians(self.__verticalDegrees)
        finishVector = (
            self.__coordenadas[0] -
            math.cos(horizontalRadians) *
            math.cos(verticalRadians) *
            units,
            self.__coordenadas[1] -
            math.sin(verticalRadians) *
            units,
            self.__coordenadas[2] -
            math.sin(horizontalRadians) *
            math.cos(verticalRadians) *
            units)
        if (self.__isPainting):
            self.__paint(
                vector(
                    finishVector[0],
                    finishVector[1],
                    finishVector[2]))
        self.__coordenadas = finishVector

    def left(self, degrees):
        """Funcion publica que, dados x grados, cambia la direccion horizontal de la tortuga x grados hacia la izquierda"""
        self.__horizontalDegrees -= degrees

    def right(self, degrees):
        """Funcion publica que, dados x grados, cambia la direccion horizontal de la tortuga x grados hacia la derecha"""
        self.__horizontalDegrees += degrees

    def up(self, degrees):
        """Funcion publica que, dados x grados, cambia la direccion vertical de la tortuga x grados hacia arriba"""
        self.__verticalDegrees += degrees

    def down(self, degrees):
        """Funcion publica que, dados x grados, cambia la direccion vertical de la tortuga x grados hacia abajo"""
        self.__verticalDegrees -= degrees

    def setColor(self, r, g, b):
        """Funcion publica que, dado un color expresado en rgb, lo asigna al atributo privado color de la clase"""
        self.__color = (r, g, b)

    def hide(self):
        """Funcion publica sin parametros que, al llamarse, pone el atributo isPainting a falso. Mientras isPainting sea falso, la tortuga no pintara al avanzar o retroceder."""
        self.__isPainting = False

    def show(self):
        """Funcion publica sin parametros que, al llamarse, pone el atributo isPainting a verdadero. Mientras isPainting sea verdadero, la tortuga pintara al avanzar o retroceder. El color utilizado para pintar sera el que haya en el atributo privado color. """
        self.__isPainting = True


# t = Turtle3D()
# help(t)