package main.java.com.company.app;

import java.util.Scanner;
import main.java.com.company.classes.Pescado;

public class App {
    private static int idxPescado = 0;
    private static int idxEmpleado = 0;
    private static int empleadoSeleccionado = -1;
    private static Pescado[] pescados = new Pescado[50];
    private static Scanner sc = new Scanner(System.in);
    private static String[] empleados = new String[50];
    public static void main(String[] args) throws Exception {
        int opt;
        final String menu = "1. Agregar empleado\n" +
            "2. Listar empleados\n" +
            "3. Seleccionar empleado\n" +
            "4. Gestionar productos\n" +
            "0. Salir\n" +
            "Seleccione una opción: ";
        do {
            System.out.print("\n"+ menu);
            opt = sc.nextInt();
            // Agregar empleado
            if (opt == 1) {
                agregarEmpleado();
            }//Listar empleados
            else if (opt == 2) {
                listarEmpleados();
            }//Seleccionar empleado 
            else if (opt == 3) {
                seleccionarEmpleado();
            }//Gestionar productos
            else if (opt == 4) {
                gestionarProductos();
            } else {
                if (opt != 0) {
                    System.out.println("\nError: Debe ingresar una opción válida.");
                }
            }
        } while (opt != 0);
    }

    public static boolean agregarEmpleado() {
        if (idxEmpleado >= empleados.length) {
            System.out.println("\nError: Has superado el límite de empleados.");
            return false;
        }
        System.out.print("\nIngrese el nombre del empleado: ");
        empleados[idxEmpleado] = sc.next();
        empleadoSeleccionado = idxEmpleado;
        idxEmpleado++;
        System.out.println("Empleado agregado correctamente!");
        return true;
    }

    public static boolean listarEmpleados() {
        if (idxEmpleado == 0) {
            System.out.println("\nError: Aún no se ha agregado empleados.");
            return false;
        }
        System.out.println("\n=== Empleados ===");
        for (int i = 0; i < idxEmpleado; i++) {
            System.out.println("ID["+ i +"] - "+ empleados[i]);
        }
        System.out.println("=================");
        return true;
    }

    public static boolean seleccionarEmpleado() {
        if (!listarEmpleados()) return false;
        if (idxEmpleado == 1) {
            System.out.println("\nError: Solo existe un empleado");
            return false;
        }
        System.out.print("\nDigite el id del empleado que desea seleccionar: ");
        empleadoSeleccionado = sc.nextInt();
        if (empleadoSeleccionado >= idxEmpleado) {
            System.out.println("\nError: El ID que ha ingresado no existe, se ha seleccionado el ID[0] por defecto.");
            empleadoSeleccionado = 0;
        } else {
            System.out.println("Se ha seleccionado el empleado: ID["+ empleadoSeleccionado +"] - "+
                empleados[empleadoSeleccionado]);
        }
        return true;
    }

    public static void gestionarProductos() {
        if (empleadoSeleccionado == -1) {
            System.out.println("\nError: Debe seleccionar un empleado para gestionar los productos.");
            return;
        }
        String menu = "1. Agregar pescado\n" +
            "2. Ver lista de pescados\n" +
            "3. Envasar pescado\n" +
            "4. Ver lista de pescados enlatados\n" +
            "0. Salir\n" +
            "Seleccione una opción: ";
        int opt;
        String tipoPescado, proveedor;
        float peso;
        int numLoteProveedor, numLotePropio, indiceCalidad;
        do {
            System.out.print("\n"+ menu);
            opt = sc.nextInt();
            //Agregar pescado
            if (opt == 1) {
                if (idxPescado < pescados.length) {
                    System.out.print("\nIngresa el tipo de pescado: ");
                    tipoPescado = sc.next();
                    System.out.print("Ingresa el nombre del proveedor: ");
                    proveedor = sc.next();
                    System.out.print("Ingresa el peso del pescado: ");
                    peso = sc.nextFloat();
                    System.out.print("Ingresa el lote del proveedor: ");
                    numLoteProveedor = sc.nextInt();
                    System.out.print("Ingresa el lote propio: ");
                    numLotePropio = sc.nextInt();
                    System.out.print("Ingresa el indice de calidad: ");
                    indiceCalidad = sc.nextInt();
                    pescados[idxPescado] = new Pescado(tipoPescado, proveedor, empleados[empleadoSeleccionado],
                        peso, numLotePropio, numLoteProveedor, indiceCalidad);
                    idxPescado++;
                } else {
                    System.out.println("Error: No puedes agregar más pescados.");
                }
            } //Ver lista de pescados
            else if (opt == 2) {
                if (idxPescado > 0) {
                    String msg = String.format("%-20s | %-20s | %-20s | %-20s | %-25s",
                        "Pescado", "Peso", "Número lote", "Indice de calidad", "Proveedor");
                    for (int i = 0; i < idxPescado; i++) {
                        msg += "\n" + pescados[i].toString();
                    }
                    System.out.println("\n============================================================ Lista de pescados ========================================");
                    System.out.println(msg);
                    System.out.println("=======================================================================================================================");
                } else {
                    System.out.println("\nError: La lista se encuentra vacía.");
                }
            }
        } while (opt != 0);
    }

}

