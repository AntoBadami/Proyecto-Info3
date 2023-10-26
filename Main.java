import java.util.Scanner;

/**
Imagina que estás trabajando en una pequeña tienda y necesitas un programa que te ayude
a llevar un registro de tu inventario. El programa debe permitir agregar nuevos productos,
eliminar productos, buscar productos por nombre y mostrar el inventario ordenado
alfabéticamente.
 */

public class Main{

    static void agregar(ArbolAVL<String> arbol) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String nombre; 
        int stock = 0;
        
        System.out.println("Ingrese nombre del producto: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese stock: ");
        stock = Integer.parseInt(scanner.nextLine());
        
        arbol.insert(nombre,stock);

        scanner.close();
    }

    static void eliminar(ArbolAVL<String> arbol) throws Exception{
        Scanner scanner = new Scanner(System.in);
        String nombre; 

        System.out.println("Ingrese el nombre del producto a eliminar: ");
        nombre = scanner.nextLine();

        arbol.remove(nombre);
        
        scanner.close();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; 
        boolean salida = false;
        ArbolAVL<String> arbol = new ArbolAVL<String>();

        System.out.println("Main class");
        do{
            System.out.println("\nMenu: ");
            System.out.println("1. Agregar producto ");
            System.out.println("2. Eliminar producto ");
            System.out.println("3. Buscar producto ");
            System.out.println("4. Mostrar inventario ");
            System.out.println("5. Salir");

            System.out.println("\nIngrese una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch(opcion){
                case 1:
                    //agregar producto
                    System.out.println("\nAgregar producto: ");
                    try {
                        agregar(arbol);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //eliminar producto
                    System.out.println("\nEliminar producto: ");
                    try {
                        eliminar(arbol);
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("Producto no encontrado");
                    }
                    break;
                case 3:
                    //buscar producto
                    break;
                case 4:
                    //mostrar inventario
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