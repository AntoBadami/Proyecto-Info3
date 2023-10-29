import java.util.Scanner;

/**
Imagina que estás trabajando en una pequeña tienda y necesitas un programa que te ayude
a llevar un registro de tu inventario. El programa debe permitir agregar nuevos productos,
eliminar productos, buscar productos por nombre y mostrar el inventario ordenado
alfabéticamente.
 */

//TODO hacer archivo README

public class Main{

    static void agregar(ArbolAVL<String> arbol, Scanner scanner) throws Exception{
        
        String nombre; 
        int stock = 0;
        
        System.out.println("Ingrese nombre del producto: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese stock: ");
        stock = Integer.parseInt(scanner.nextLine());
        
        arbol.insert(nombre,stock);
    }

    static void eliminar(ArbolAVL<String> arbol, Scanner scanner) throws Exception{
       
        String nombre; 

        System.out.println("Ingrese el nombre del producto a eliminar: ");
        nombre = scanner.nextLine();

        arbol.remove(nombre);
    }

    static void buscar(ArbolAVL<String> arbol, Scanner scanner) throws Exception{
        
        String nombre; 
        
        System.out.println("Ingrese el nombre del producto a buscar: ");
        nombre = scanner.nextLine();
        
        NodoAVL<String> nodoEncontrado = arbol.find(nombre);
        if (nodoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println("Nombre: " + nodoEncontrado.element);
            System.out.println("Stock: " + nodoEncontrado.stock);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    //TODO falta implementar: El usuario debe poder ver una lista de todos los productos en el inventario, ordenados
//alfabéticamente por nombre.
static void mostrar(ArbolAVL<String> arbol, ListQueue<String> cola) throws Exception {
    System.out.println("Inventario ordenado alfabéticamente por nombre:");

    // Llenar la cola con los elementos del árbol en orden alfabético
    inOrderLlenarCola(arbol.root, cola);

    // Imprimir los elementos en el orden en que se insertaron en la cola
    while (!cola.isEmpty()) {
        String nombre = cola.getFront();
        int stock = cola.getStock();
        System.out.println("Nombre: " + nombre + ", Stock: " + stock);
        try {
            cola.dequeue();
        } catch (Exception e) {
            System.out.println("Error al obtener el siguiente elemento de la cola: " + e.getMessage());
        }
    }
}

static void inOrderLlenarCola(NodoAVL<String> nodo, ListQueue<String> cola) {
    if (nodo != null) {
        inOrderLlenarCola(nodo.left, cola); // Recorre el subárbol izquierdo
        cola.enqueue(nodo.element, nodo.stock); // Agrega el elemento a la cola
        inOrderLlenarCola(nodo.right, cola); // Recorre el subárbol derecho
    }
}


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; 
        boolean salida = false;
        ArbolAVL<String> arbol = new ArbolAVL<String>();
        ListQueue<String> lista = new ListQueue();

        System.out.println("Main class");
        do{
            System.out.println("\nMenu: ");
            System.out.println("1. Agregar producto ");
            System.out.println("2. Eliminar producto ");
            System.out.println("3. Buscar producto ");
            System.out.println("4. Mostrar inventario ");
            System.out.println("5. Salir");

            System.out.println("\nIngrese una opcion: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Introduzca un número válido.");
                continue; // Salta al siguiente ciclo
            }
            switch(opcion){
                case 1:
                    //agregar producto
                    System.out.println("\nAgregar producto: ");
                    try {
                        agregar(arbol, scanner);
                    } catch (Exception e) {
                        System.out.println("Error al agregar el producto: " + e.getMessage());
                    }
                    break;
                case 2:
                    //eliminar producto
                    System.out.println("\nEliminar producto: ");
                    try {
                        eliminar(arbol, scanner);
                    } catch (Exception e) {
                        System.out.println("Producto no encontrado: ");
                    }
                    break;
                case 3:
                    //buscar producto
                    System.out.println("\nBuscar producto: ");
                    try {
                        buscar(arbol, scanner);
                    } catch (Exception e) {
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 4:
                    try {
                        mostrar(arbol, lista);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    lista.makeEmpty();
                    //mostrar inventario
                    //implementar con lista
                    break;
                case 5:
                    //salir
                    
                    salida = true;
                    break;
                default:
                    System.out.println("opcion no valida");
            }

        }while(salida == false);

        scanner.close();
    }
}



