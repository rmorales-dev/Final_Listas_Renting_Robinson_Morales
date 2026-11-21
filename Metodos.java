import java.util.Scanner;

public class Metodos {

    public int MenuPrincipal(Scanner sc) {
        System.out.println("________________________________________");
        System.out.println("   Sistema de Renting de Vehiculos Nacho Lee Final");
        System.out.println("________________________________________");
        System.out.println("1. Gestion de clientes");
        System.out.println("2. Gestion de vehiculos");
        System.out.println("3. Gestion de contratos de renting");
        System.out.println("4. Imprimir informe general");
        System.out.println("5. Salir del sistema");
        System.out.println("Seleccione una opcion:");
        int opt = sc.nextInt();
        return opt;
    }

    public boolean SubMenuClientes(Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("________________________________________");
            System.out.println("        1. Gestion de clientes Nacho Lee Final");
            System.out.println("________________________________________");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Volver al menu principal");
            System.out.println("Seleccione una opcion:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("1.1 Registrar cliente (en Construccion)");
                    break;
                case 2:
                    System.out.println("1.2 Modificar cliente (en Construccion)");
                    break;
                case 3:
                    System.out.println("1.3 Eliminar cliente (en Construccion)");
                    break;
                case 4:
                    System.out.println("1.4 Buscar cliente (en Construccion)");
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    break;
            }
        }
        return volver;
    }

    public boolean SubMenuVehiculos(Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("________________________________________");
            System.out.println("        2. Gestion de vehiculos Nacho Lee Final");
            System.out.println("________________________________________");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Buscar vehiculo");
            System.out.println("5. Volver al menu principal");
            System.out.println("Seleccione una opcion:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("2.1 Registrar vehiculo (en Construccion)");
                    break;
                case 2:
                    System.out.println("2.2 Modificar vehiculo (en Construccion)");
                    break;
                case 3:
                    System.out.println("2.3 Eliminar vehiculo (en Construccion)");
                    break;
                case 4:
                    System.out.println("2.4 Buscar vehiculo (en Construccion)");
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    break;
            }
        }
        return volver;
    }

    public boolean SubMenuContratos(Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("________________________________________");
            System.out.println("   3. Gestion de contratos de renting Nacho Lee Final");
            System.out.println("________________________________________");
            System.out.println("1. Registrar nuevo contrato");
            System.out.println("2. Modificar contrato");
            System.out.println("3. Finalizar contrato (devolucion)");
            System.out.println("4. Buscar contrato");
            System.out.println("5. Volver al menu principal");
            System.out.println("Seleccione una opcion:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.println("3.1 Registrar nuevo contrato (en Construccion)");
                    break;
                case 2:
                    System.out.println("3.2 Modificar contrato (en Construccion)");
                    break;
                case 3:
                    System.out.println("3.3 Finalizar contrato (devolucion) (en Construccion)");
                    break;
                case 4:
                    System.out.println("3.4 Buscar contrato (en Construccion)");
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    break;
            }
        }
        return volver;
    }
}