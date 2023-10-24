import java.util.Scanner;

/**
Imagina que estás trabajando en una pequeña tienda y necesitas un programa que te ayude
a llevar un registro de tu inventario. El programa debe permitir agregar nuevos productos,
eliminar productos, buscar productos por nombre y mostrar el inventario ordenado
alfabéticamente.
 */

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0; 
        boolean salida = false;

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
                    Funciones accion = new Funciones();
                    try {
                        accion.agregar();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    //eliminar producto
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