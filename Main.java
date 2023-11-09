import java.util.Scanner;


public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        boolean salida = false;
        ArbolAVL arbol = new ArbolAVL();
        ListQueue lista = new ListQueue();

        System.out.println("Main class");
        do {
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
            switch (opcion) {
                case 1:
                    // agregar producto
                    System.out.println("\nAgregar producto: ");
                    try {
                        Funciones.agregar(arbol, scanner);
                    } catch (Exception e) {
                        System.out.println("Error al agregar el producto: " + e.getMessage());
                    }
                    break;
                case 2:
                    // eliminar producto
                    System.out.println("\nEliminar producto: ");
                    try {
                        Funciones.eliminar(arbol, scanner);
                    } catch (Exception e) {
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 3:
                    // buscar producto
                    System.out.println("\nBuscar producto: ");
                    try {
                        Funciones.buscar(arbol, scanner);
                    } catch (Exception e) {
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 4:
                    // mostrar inventario
                    try {
                        Funciones.mostrar(arbol, lista);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    lista.makeEmpty();
                    break;
                case 5:
                    // salir
                    salida = true;
                    break;
                default:
                    System.out.println("Opción no válida");
            }

        } while (!salida);

        scanner.close();
    }
}



