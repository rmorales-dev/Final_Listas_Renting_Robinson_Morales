import java.util.LinkedList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Metodos m = new Metodos();
        LinkedList<ObjCliente> cl = new LinkedList<>();
        LinkedList<ObjVehiculo> ve = new LinkedList<>();
        LinkedList<ObjContratoRenting> co = new LinkedList<>();
        boolean continuar = true;
        while (continuar) {
            switch (m.MenuPrincipal(sc)) {
                case 1:
                    m.SubMenuClientes(cl, co, ve, sc);
                    break;
                case 2:
                    m.SubMenuVehiculos(ve, sc);
                    break;
                case 3:
                    m.SubMenuContratos(co, cl, ve, sc);
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
