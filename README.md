## PRÁCTICA DE PYTHON Y COMPILADORES

## Descripción

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
