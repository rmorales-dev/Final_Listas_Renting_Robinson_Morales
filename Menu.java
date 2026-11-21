import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        boolean continuar = true;
        while (continuar) {
            switch (m.MenuPrincipal(sc)) {
                case 1:
                    m.SubMenuClientes(sc);
                    break;
                case 2:
                    m.SubMenuVehiculos(sc);
                    break;
                case 3:
                    m.SubMenuContratos(sc);
                    break;
                case 4:
                    System.out.println("Imprimir informe general (en Construccion)");
                    break;
                case 5:
                    System.out.println("Gracias por usar el sistema de renting Nacho Lee Final. Vuelva pronto.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    break;
            }
        }
    }
}
