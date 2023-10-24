//FUNCIONALIDADES

import java.util.Scanner;

public class Funciones {
    
    //agrega producto
    public void agregar() throws Exception{
        ArbolAVL<String> arbol = new ArbolAVL<String>();
        Scanner scanner = new Scanner(System.in);
        String nombre; 
        int stock = 0;

        System.out.println("\nAgregar producto: ");
        System.out.println("Ingrese nombre del producto: ");
        nombre = scanner.nextLine();
        System.out.println("Ingrese stock: ");
        stock = Integer.parseInt(scanner.nextLine());
        
        arbol.insert(nombre,stock);

        scanner.close();
    }
    //elimina producto
    public void eliminar(){

    }
    //buscar producto
    public void buscar(){

    }
    //muestra inventario
    public void mostrar(){

    }
}
