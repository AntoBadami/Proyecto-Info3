import java.util.Scanner;

public class Funciones {
    
    static void agregar(ArbolAVL arbol, Scanner scanner) throws Exception {
        String nombre;
        int stock = 0;

        System.out.println("Ingrese nombre del producto: ");
        nombre = scanner.nextLine();
        nombre = nombre.toLowerCase();

        System.out.println("Ingrese stock: ");
        stock = Integer.parseInt(scanner.nextLine());

        Producto producto = new Producto(nombre, stock);
        arbol.insert(producto);
    }

    static void eliminar(ArbolAVL arbol, Scanner scanner) throws Exception {
        String nombre;

        System.out.println("Ingrese el nombre del producto a eliminar: ");
        nombre = scanner.nextLine();

        arbol.remove(nombre);
    }

    static void buscar(ArbolAVL arbol, Scanner scanner) throws Exception {
        String nombre;

        System.out.println("Ingrese el nombre del producto a buscar: ");
        nombre = scanner.nextLine();

        NodoAVL nodoEncontrado = arbol.find(nombre);
        if (nodoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println("Nombre: " + nodoEncontrado.element.nombre);
            System.out.println("Stock: " + nodoEncontrado.element.stock);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    static void mostrar(ArbolAVL arbol, ListQueue cola) throws Exception {
        System.out.println("Inventario ordenado alfabéticamente por nombre:");

        // Llenar la cola con los elementos del árbol en orden alfabético
        inOrderLlenarCola(arbol.root, cola);

        // Imprimir los elementos en el orden en que se insertaron en la cola
        while (!cola.isEmpty()) {
            Producto producto = cola.getFront();
            System.out.println("Nombre: " + producto.nombre + ", Stock: " + producto.stock);
            try {
                cola.dequeue();
            } catch (Exception e) {
                System.out.println("Error al obtener el siguiente elemento de la cola: " + e.getMessage());
            }
        }
    }

    static void inOrderLlenarCola(NodoAVL nodo, ListQueue cola) {
        if (nodo != null) {
            inOrderLlenarCola(nodo.left, cola);
            cola.enqueue(nodo.element, nodo.stock);
            inOrderLlenarCola(nodo.right, cola);
        }
    }
}
