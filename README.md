# Proyecto-Info3
 
El siguiente proyecto tiene como objetivo desarrollar un sistema de gestión de inventario en Java utilizando conceptos de recursividad, algoritmos de búsqueda y árboles binarios.
Para la implementación del proyecto en java, usamos las clases:
Main: Se encarga de mostrar el menú con las diferentes selección de funciones.

ArbolAVL: Se encarga de generar un árbol binario de búsqueda y ordenarlo a medida que se ingresan datos.

NodoAVL: Genera los nodos del árbol y atributos de los elementos ingresados.

ListQueue: Genera una lista enlazada con cola
Nodo: Genera un nodo con atributos de cada elemento del árbol.

El programa realiza funciones de:
   Agregar producto
   Eliminar producto
   Buscar producto
   Mostrar inventario

Para realizar la carga de los productos, decidimos utilizar un Árbol Binario de búsqueda Avl, cada producto es de tipo “string”, si el producto ingresado es una letra o símbolo, seguirá un orden en código ascii de menor a mayor, de la misma manera si es número, pero siempre se ordenarán primero los números y luego los caracteres. A cada producto se le corresponde un nodo del árbol, y dicho nodo tendrá un stock que es la cantidad que existe de dicho producto.
Con el árbol binario de búsqueda AVL, realizamos un ordenamiento a medida que se ingresa cada producto, usando distintas operaciones de rotación doble y simple con el objetivo de que al momento de realizar una búsqueda o eliminación de un producto nos aproximamos a obtener tiempos logarítmicos.

Para la función de mostrar, se utiliza una lista enlazada con cola, cada vez que se llama a la función mostrar, pasamos cada nodo del árbol ya ordenado a un nodo de la lista y luego la mostramos. Luego de mostrar, eliminamos la lista, el objetivo de hacer esto es debido a que el árbol está en constante actualización.

En la función eliminar y buscar, decidimos trabajar todos los productos con caracteres en minúsculas, ya que así evitamos problemas de comparar caracteres en mayúsculas y minúsculas al momento de borrar.

INSTRUCCIONES PARA EJECUTAR:

Se comienza ejecutando la clase “Main”, esto genera un menú con diferentes opciones que 
corresponden a las funciones agregar, buscar, eliminar, mostrar y salir.

-Agregar: En función agregar, se solicita un producto (tipo string) y una cantidad (tipo int) y se crea un nuevo nodo para el producto.

-Al elegir la función buscar y eliminar se solicitará el nombre de un producto agregado, esto 
borrará el producto junto con su cantidad del árbol (borrará el nodo completo).

-La función mostrar mostrará todos los productos que se agregan al árbol generando una lista enlazada con cola y a su vez la borrara luego de mostrarla.

En caso de cualquier error, deberá saltar una excepción con un mensaje asociado al error que se está ejecutando.
