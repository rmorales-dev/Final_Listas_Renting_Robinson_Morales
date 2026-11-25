import java.util.LinkedList;
import java.util.Scanner;

public class Metodos {
    Validaciones v = new Validaciones();

    public int MenuPrincipal(Scanner sc) {
        System.out.println("__________________________________________________");
        System.out.println("Sistema de Renting de Vehiculos Nacho Lee Final");
        System.out.println("__________________________________________________");
        System.out.println("1. Gestion de clientes");
        System.out.println("2. Gestion de vehiculos");
        System.out.println("3. Gestion de contratos de renting");
        System.out.println("4. Imprimir informe general");
        System.out.println("5. Salir del sistema");
        System.out.println("Seleccione una opcion:");
        int opt = sc.nextInt();
        return opt;
    }

    public boolean SubMenuClientes(LinkedList<ObjCliente> cl, LinkedList<ObjContratoRenting> co, LinkedList<ObjVehiculo> ve, Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("__________________________________________________");
            System.out.println("1. Gestion de clientes Nacho Lee Final");
            System.out.println("__________________________________________________");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Modificar cliente");
            System.out.println("3. Eliminar cliente");
            System.out.println("4. Buscar cliente");
            System.out.println("5. Volver al menu principal");
            System.out.println("Seleccione una opcion:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    cl = LlenarListaClientes(cl, sc);
                    break;
                case 2:
                    cl = ModificarCliente(cl, sc);
                    break;
                case 3:
                    cl = EliminarCliente(cl, co, ve, sc);
                    break;
                case 4:
                    System.out.println(BuscarCliente(cl, sc));
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    System.out.println("__________________________________________________");
                    System.out.println("");
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    System.out.println("__________________________________________________");
                    System.out.println("");
                    break;
            }
        }
        return volver;
    }

    public boolean SubMenuVehiculos(LinkedList<ObjVehiculo> ve, Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("__________________________________________________");
            System.out.println("2. Gestion de vehiculos Nacho Lee Final");
            System.out.println("__________________________________________________");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Modificar vehiculo");
            System.out.println("3. Eliminar vehiculo");
            System.out.println("4. Buscar vehiculo");
            System.out.println("5. Volver al menu principal");
            System.out.println("Seleccione una opcion:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    ve = LlenarListaVehiculos(ve, sc);
                    break;
                case 2:
                    ve = ModificarVehiculo(ve, sc);
                    break;
                case 3:
                    ve = EliminarVehiculo(ve, sc);
                    break;
                case 4:
                    System.out.println(BuscarVehiculo(ve, sc));
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    System.out.println("__________________________________________________");
                    System.out.println("");
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    System.out.println("__________________________________________________");
                    System.out.println("");
                    break;
            }
        }
        return volver;
    }

    public boolean SubMenuContratos(LinkedList<ObjContratoRenting> co, LinkedList<ObjContratoRenting> coFinalizados, LinkedList<ObjCliente> cl, LinkedList<ObjVehiculo> ve, Scanner sc) {
        boolean volver = false;
        while (!volver) {
            System.out.println("__________________________________________________");
            System.out.println("3. Gestion de contratos de renting Nacho Lee Final");
            System.out.println("__________________________________________________");
            System.out.println("1. Registrar nuevo contrato");
            System.out.println("2. Modificar contrato");
            System.out.println("3. Finalizar contrato (devolucion)");
            System.out.println("4. Buscar contrato");
            System.out.println("5. Volver al menu principal");
            System.out.println("Seleccione una opcion:");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    co = LlenarListaContratos(co, cl, ve, sc);
                    break;
                case 2:
                    co = ModificarContrato(co, ve, sc);
                    break;
                case 3:
                    co = FinalizarContrato(co, coFinalizados, ve, sc);
                    break;
                case 4:
                    System.out.println(BuscarContrato(co, sc));
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    System.out.println("__________________________________________________");
                    System.out.println("");
                    volver = true;
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
                    System.out.println("__________________________________________________");
                    System.out.println("");
                    break;
            }
        }
        return volver;
    }

    public LinkedList<ObjCliente> LlenarListaClientes(LinkedList<ObjCliente> cl, Scanner sc) {
        System.out.println("__________________________________________________");
        System.out.println("Registro de clientes Nacho Lee Final");
        System.out.println("__________________________________________________");
        System.out.println("Ingrese la cedula del cliente:");
        String cedula = v.ValidarString(sc);

        for (ObjCliente o : cl) {
            if (o.getCedula().equalsIgnoreCase(cedula)) {
                System.out.println("Error: Ya existe un cliente con esa cedula.");
                System.out.println("__________________________________________________");
                System.out.println("");
                return cl;
            }
        }

        System.out.println("Ingrese el nombre:");
        String nombre = v.ValidarString(sc);

        System.out.println("Ingrese el apellido:");
        String apellido = v.ValidarString(sc);

        System.out.println("Ingrese el telefono:");
        String telefono = v.ValidarString(sc);

        System.out.println("Ingrese la direccion:");
        String direccion = v.ValidarString(sc);

        System.out.println("Ingrese la licencia de conduccion:");
        String licencia = v.ValidarString(sc);

        ObjCliente o = new ObjCliente(cedula, nombre, apellido, telefono, direccion, licencia);
        cl.add(o);

        System.out.println("Cliente registrado exitosamente.");
        System.out.println("__________________________________________________");
        System.out.println("");
        return cl;
    }

    public String BuscarCliente(LinkedList<ObjCliente> cl, Scanner sc) {
        String mensaje = "";
        if (cl.isEmpty()) {
            mensaje = "No hay clientes registrados en el sistema.";
            return mensaje;
        }
        System.out.println("Ingrese la cedula del cliente a buscar:");
        String cedula = v.ValidarString(sc);

        ObjCliente encontrado = null;
        for (ObjCliente o : cl) {
            if (o.getCedula().equalsIgnoreCase(cedula)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            mensaje = "No se encontro ningun cliente con la cedula: " + cedula;
            return mensaje;
        }

        System.out.println("__________________________________________________");
        System.out.println("Informacion del cliente:");
        System.out.println("Cedula: " + encontrado.getCedula());
        System.out.println("Nombre: " + encontrado.getNombre());
        System.out.println("Apellido: " + encontrado.getApellido());
        System.out.println("Telefono: " + encontrado.getTelefono());
        System.out.println("Direccion: " + encontrado.getDireccion());
        System.out.println("Licencia: " + encontrado.getLicenciaConduccion());
        mensaje = "Busqueda completada con exito.";
        return mensaje;
    }

    public LinkedList<ObjCliente> ModificarCliente(LinkedList<ObjCliente> cl, Scanner sc) {
        if (cl.isEmpty()) {
            System.out.println("No hay clientes registrados para modificar.");
            System.out.println("________________________________________");
            System.out.println("");
            return cl;
        }
        System.out.println("Ingrese la cedula del cliente a modificar:");
        String cedula = v.ValidarString(sc);

        ObjCliente encontrado = null;
        for (ObjCliente o : cl) {
            if (o.getCedula().equalsIgnoreCase(cedula)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun cliente con la cedula: " + cedula);
            System.out.println("________________________________________");
            System.out.println("");
            return cl;
        }

        System.out.println("Ingrese nuevo nombre (Actual: " + encontrado.getNombre() + "):");
        encontrado.setNombre(v.ValidarString(sc));

        System.out.println("Ingrese nuevo apellido (Actual: " + encontrado.getApellido() + "):");
        encontrado.setApellido(v.ValidarString(sc));

        System.out.println("Ingrese nuevo telefono (Actual: " + encontrado.getTelefono() + "):");
        encontrado.setTelefono(v.ValidarString(sc));

        System.out.println("Ingrese nueva direccion (Actual: " + encontrado.getDireccion() + "):");
        encontrado.setDireccion(v.ValidarString(sc));

        System.out.println("Ingrese nueva licencia (Actual: " + encontrado.getLicenciaConduccion() + "):");
        encontrado.setLicenciaConduccion(v.ValidarString(sc));

        System.out.println("Cliente modificado exitosamente.");
        System.out.println("________________________________________");
        System.out.println("");
        return cl;
    }

    public LinkedList<ObjCliente> EliminarCliente(LinkedList<ObjCliente> cl, LinkedList<ObjContratoRenting> co, LinkedList<ObjVehiculo> ve, Scanner sc) {
        if (cl.isEmpty()) {
            System.out.println("No hay clientes registrados para eliminar.");
            System.out.println("________________________________________");
            System.out.println("");
            return cl;
        }
        System.out.println("Ingrese la cedula del cliente a eliminar:");
        String cedula = v.ValidarString(sc);

        ObjCliente encontrado = null;
        for (ObjCliente o : cl) {
            if (o.getCedula().equalsIgnoreCase(cedula)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun cliente con la cedula: " + cedula);
            System.out.println("________________________________________");
            System.out.println("");
            return cl;
        }

        for (int i = 0; i < co.size(); i++) {
            if (co.get(i).getCedulaCliente().equalsIgnoreCase(cedula)) {
                String placaAuto = co.get(i).getPlacaVehiculo();
                for (ObjVehiculo vh : ve) {
                    if (vh.getPlaca().equalsIgnoreCase(placaAuto)) {
                        vh.setEstado("Disponible");
                        break;
                    }
                }
                co.remove(i);
                System.out.println("Sincronizacion: Se elimino el contrato asociado al cliente.");
                break;
            }
        }

        cl.remove(encontrado);
        System.out.println("Cliente eliminado exitosamente.");
        System.out.println("________________________________________");
        System.out.println("");
        return cl;
    }

    public String TipoVehiculo(Scanner sc) {
        String Tipo = "";
        System.out.println("Seleccione el tipo de vehiculo:");
        System.out.println("1) Sedan");
        System.out.println("2) Camioneta");
        int opt = v.ValidarEntero(sc);
        while (opt < 1 || opt > 2) {
            System.out.println("Opcion no valida. Seleccione 1 o 2:");
            opt = v.ValidarEntero(sc);
        }
        switch (opt) {
            case 1: 
                Tipo = "Sedan"; 
                break;
            case 2: 
                Tipo = "Camioneta"; 
                break;
        }
        return Tipo;
    }

    public String Combustible(Scanner sc) {
        String Tipo = "";
        System.out.println("Seleccione tipo de combustible:");
        System.out.println("1) Gasolina");
        System.out.println("2) Diesel");
        System.out.println("3) Electrico");
        int opt = v.ValidarEntero(sc);
        while (opt < 1 || opt > 3) {
            System.out.println("Opcion no valida. Seleccione 1, 2 o 3:");
            opt = v.ValidarEntero(sc);
        }
        switch (opt) {
            case 1: 
                Tipo = "Gasolina"; 
                break;
            case 2: 
                Tipo = "Diesel"; 
                break;
            case 3: 
                Tipo = "Electrico"; 
                break;
        }
        return Tipo;
    }

    public String Transmision(Scanner sc) {
        String Tipo = "";
        System.out.println("Seleccione la transmision:");
        System.out.println("1) Manual");
        System.out.println("2) Automatica");
        int opt = v.ValidarEntero(sc);
        while (opt < 1 || opt > 2) {
            System.out.println("Opcion no valida. Seleccione 1 o 2:");
            opt = v.ValidarEntero(sc);
        }
        switch (opt) {
            case 1: 
                Tipo = "Manual"; 
                break;
            case 2: 
                Tipo = "Automatica"; 
                break;
        }
        return Tipo;
    }

    public String Traccion(Scanner sc) {
        String Tipo = "";
        System.out.println("Seleccione la traccion:");
        System.out.println("1) 4x2");
        System.out.println("2) 4x4");
        int opt = v.ValidarEntero(sc);
        while (opt < 1 || opt > 2) {
            System.out.println("Opcion no valida. Seleccione 1 o 2:");
            opt = v.ValidarEntero(sc);
        }
        switch (opt) {
            case 1: 
                Tipo = "4x2"; 
                break;
            case 2: 
                Tipo = "4x4"; 
                break;
        }
        return Tipo;
    }

    public LinkedList<ObjVehiculo> LlenarListaVehiculos(LinkedList<ObjVehiculo> ve, Scanner sc) {
        System.out.println("________________________________________");
        System.out.println("         Registro de vehiculos Nacho Lee Final");
        System.out.println("________________________________________");
        System.out.println("Ingrese la placa del vehiculo:");
        String placa = v.ValidarString(sc);

        for (ObjVehiculo o : ve) {
            if (o.getPlaca().equalsIgnoreCase(placa)) {
                System.out.println("Error: Ya existe un vehiculo con esa placa.");
                System.out.println("________________________________________");
                System.out.println("");
                return ve;
            }
        }

        System.out.println("Ingrese la marca:");
        String marca = v.ValidarString(sc);

        System.out.println("Ingrese el modelo (anio):");
        int modelo = v.ValidarEntero(sc);

        System.out.println("Ingrese el precio diario de alquiler:");
        Double precioDiario = v.ValidarDouble(sc);

        String estado = "Disponible";
        String tipo = TipoVehiculo(sc);
        String tipoCombustible = Combustible(sc);
        String transmision = Transmision(sc);
        String traccion = Traccion(sc);

        System.out.println("Ingrese capacidad del maletero en litros:");
        Double capacidadMaletero = v.ValidarDouble(sc);

        ObjVehiculo o = new ObjVehiculo(placa, marca, modelo, precioDiario, estado, tipo, tipoCombustible, transmision, traccion, capacidadMaletero);
        ve.add(o);

        System.out.println("Vehiculo registrado exitosamente.");
        System.out.println("________________________________________");
        System.out.println("");
        return ve;
    }

    public String BuscarVehiculo(LinkedList<ObjVehiculo> ve, Scanner sc) {
        String mensaje = "";
        if (ve.isEmpty()) {
            mensaje = "No hay vehiculos registrados en el sistema.";
            return mensaje;
        }
        System.out.println("Ingrese la placa del vehiculo a buscar:");
        String placa = v.ValidarString(sc);

        ObjVehiculo encontrado = null;
        for (ObjVehiculo o : ve) {
            if (o.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            mensaje = "No se encontro ningun vehiculo con la placa: " + placa;
            return mensaje;
        }

        System.out.println("________________________________________");
        System.out.println("Informacion del vehiculo:");
        System.out.println("Placa: " + encontrado.getPlaca());
        System.out.println("Marca: " + encontrado.getMarca());
        System.out.println("Modelo: " + encontrado.getModelo());
        System.out.println("Precio Diario: " + encontrado.getPrecioDiario());
        System.out.println("Estado: " + encontrado.getEstado());
        System.out.println("Tipo: " + encontrado.getTipo());
        System.out.println("Combustible: " + encontrado.getTipoCombustible());
        System.out.println("Transmision: " + encontrado.getTransmision());
        System.out.println("Traccion: " + encontrado.getTraccion());
        System.out.println("Capacidad Maletero: " + encontrado.getCapacidadMaletero() + " L");
        mensaje = "Busqueda completada con exito.";
        return mensaje;
    }

    public LinkedList<ObjVehiculo> ModificarVehiculo(LinkedList<ObjVehiculo> ve, Scanner sc) {
        if (ve.isEmpty()) {
            System.out.println("No hay vehiculos registrados para modificar.");
            System.out.println("________________________________________");
            System.out.println("");
            return ve;
        }
        System.out.println("Ingrese la placa del vehiculo a modificar:");
        String placa = v.ValidarString(sc);

        ObjVehiculo encontrado = null;
        for (ObjVehiculo o : ve) {
            if (o.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun vehiculo con la placa: " + placa);
            System.out.println("________________________________________");
            System.out.println("");
            return ve;
        }

        System.out.println("Ingrese nueva marca (Actual: " + encontrado.getMarca() + "):");
        encontrado.setMarca(v.ValidarString(sc));

        System.out.println("Ingrese nuevo modelo (Actual: " + encontrado.getModelo() + "):");
        encontrado.setModelo(v.ValidarEntero(sc));

        System.out.println("Ingrese nuevo precio diario (Actual: " + encontrado.getPrecioDiario() + "):");
        encontrado.setPrecioDiario(v.ValidarDouble(sc));

        System.out.println("Vehiculo modificado exitosamente.");
        System.out.println("________________________________________");
        System.out.println("");
        return ve;
    }

    public LinkedList<ObjVehiculo> EliminarVehiculo(LinkedList<ObjVehiculo> ve, Scanner sc) {
        if (ve.isEmpty()) {
            System.out.println("No hay vehiculos registrados para eliminar.");
            System.out.println("________________________________________");
            System.out.println("");
            return ve;
        }
        System.out.println("Ingrese la placa del vehiculo a eliminar:");
        String placa = v.ValidarString(sc);

        ObjVehiculo encontrado = null;
        for (ObjVehiculo o : ve) {
            if (o.getPlaca().equalsIgnoreCase(placa)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun vehiculo con la placa: " + placa);
            System.out.println("________________________________________");
            System.out.println("");
            return ve;
        }

        ve.remove(encontrado);
        System.out.println("Vehiculo eliminado exitosamente.");
        System.out.println("________________________________________");
        System.out.println("");
        return ve;
    }

    public LinkedList<ObjContratoRenting> LlenarListaContratos(LinkedList<ObjContratoRenting> co, LinkedList<ObjCliente> cl, LinkedList<ObjVehiculo> ve, Scanner sc) {
        System.out.println("________________________________________");
        System.out.println("   Registro de Contrato Nacho Lee Final");
        System.out.println("________________________________________");
        System.out.println("Ingrese el Id del contrato:");
        String idContrato = v.ValidarString(sc);

        for (ObjContratoRenting o : co) {
            if (o.getIdContrato().equalsIgnoreCase(idContrato)) {
                System.out.println("Error: Ya existe un contrato con ese Id.");
                System.out.println("________________________________________");
                System.out.println("");
                return co;
            }
        }

        System.out.println("Ingrese la cedula del cliente:");
        String cedula = v.ValidarString(sc);
        boolean clienteExiste = false;
        for (ObjCliente c : cl) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                clienteExiste = true;
                break;
            }
        }
        if (!clienteExiste) {
            System.out.println("Error: El cliente no se encuentra registrado.");
            System.out.println("_____________________________________________");
            System.out.println("");
            return co;
        }

        for (ObjContratoRenting o : co) {
            if (o.getCedulaCliente().equalsIgnoreCase(cedula)) {
                System.out.println("Error: El cliente ya tiene un contrato de alquiler activo.");
                System.out.println("__________________________________________________________");
                System.out.println("");
                return co;
            }
        }

        System.out.println("Ingrese la placa del vehiculo:");
        String placa = v.ValidarString(sc);
        ObjVehiculo vehiculoSeleccionado = null;
        for (ObjVehiculo vh : ve) {
            if (vh.getPlaca().equalsIgnoreCase(placa)) {
                vehiculoSeleccionado = vh;
                break;
            }
        }
        if (vehiculoSeleccionado == null) {
            System.out.println("Error: El vehiculo no se encuentra registrado.");
            System.out.println("______________________________________________");
            System.out.println("");
            return co;
        }
        if (!vehiculoSeleccionado.getEstado().equalsIgnoreCase("Disponible")) {
            System.out.println("Error: El vehiculo no esta disponible, se encuentra alquilado.");
            System.out.println("______________________________________________________________");
            System.out.println("");
            return co;
        }

        System.out.println("Ingrese fecha de inicio (DD/MM/AAAA):");
        String fechaInicio = v.ValidarString(sc);

        System.out.println("Ingrese fecha de fin (DD/MM/AAAA):");
        String fechaFin = v.ValidarString(sc);

        System.out.println("Ingrese el total de dias de alquiler:");
        int totalDias = v.ValidarEntero(sc);
        while (totalDias <= 0) {
            System.out.println("Error: La cantidad de dias debe ser mayor a cero. Ingrese nuevamente:");
            totalDias = v.ValidarEntero(sc);
        }

        Double valorTotal = totalDias * vehiculoSeleccionado.getPrecioDiario();

        vehiculoSeleccionado.setEstado("Alquilado");

        ObjContratoRenting nuevoContrato = new ObjContratoRenting(idContrato, cedula, placa, fechaInicio, fechaFin, totalDias, valorTotal);
        co.add(nuevoContrato);

        System.out.println("Contrato registrado exitosamente.");
        System.out.println("Valor total a pagar: $" + valorTotal);
        System.out.println("________________________________________");
        System.out.println("");
        return co;
    }

    public String BuscarContrato(LinkedList<ObjContratoRenting> co, Scanner sc) {
        String mensaje = "";
        if (co.isEmpty()) {
            mensaje = "No hay contratos registrados en el sistema.";
            return mensaje;
        }
        System.out.println("Ingrese el Id del contrato a buscar:");
        String idContrato = v.ValidarString(sc);

        ObjContratoRenting encontrado = null;
        for (ObjContratoRenting o : co) {
            if (o.getIdContrato().equalsIgnoreCase(idContrato)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            mensaje = "No se encontro ningun contrato con el Id: " + idContrato;
            return mensaje;
        }

        System.out.println("________________________________________");
        System.out.println("Informacion del Contrato:");
        System.out.println("Id Contrato: " + encontrado.getIdContrato());
        System.out.println("Cedula Cliente: " + encontrado.getCedulaCliente());
        System.out.println("Placa Vehiculo: " + encontrado.getPlacaVehiculo());
        System.out.println("Fecha Inicio: " + encontrado.getFechaInicio());
        System.out.println("Fecha Fin: " + encontrado.getFechaFin());
        System.out.println("Total Dias: " + encontrado.getTotalDias());
        System.out.println("Valor Total: $" + encontrado.getValorTotal());
        mensaje = "Busqueda completada con exito.";
        return mensaje;
    }

    public LinkedList<ObjContratoRenting> ModificarContrato(LinkedList<ObjContratoRenting> co, LinkedList<ObjVehiculo> ve, Scanner sc) {
        if (co.isEmpty()) {
            System.out.println("No hay contratos registrados para modificar.");
            System.out.println("________________________________________");
            System.out.println("");
            return co;
        }
        System.out.println("Ingrese el Id del contrato a modificar:");
        String idContrato = v.ValidarString(sc);

        ObjContratoRenting encontrado = null;
        for (ObjContratoRenting o : co) {
            if (o.getIdContrato().equalsIgnoreCase(idContrato)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun contrato con el Id: " + idContrato);
            System.out.println("________________________________________");
            System.out.println("");
            return co;
        }

        System.out.println("Ingrese nueva fecha de inicio (Actual: " + encontrado.getFechaInicio() + "):");
        encontrado.setFechaInicio(v.ValidarString(sc));

        System.out.println("Ingrese nueva fecha de fin (Actual: " + encontrado.getFechaFin() + "):");
        encontrado.setFechaFin(v.ValidarString(sc));

        System.out.println("Ingrese nuevo total de dias (Actual: " + encontrado.getTotalDias() + "):");
        int nuevosDias = v.ValidarEntero(sc);
        while (nuevosDias <= 0) {
            System.out.println("Error: La cantidad de dias debe ser mayor a cero. Ingrese nuevamente:");
            nuevosDias = v.ValidarEntero(sc);
        }
        encontrado.setTotalDias(nuevosDias);

        for (ObjVehiculo vh : ve) {
            if (vh.getPlaca().equalsIgnoreCase(encontrado.getPlacaVehiculo())) {
                encontrado.setValorTotal(nuevosDias * vh.getPrecioDiario());
                break;
            }
        }

        System.out.println("Contrato modificado exitosamente. Nuevo valor total: $" + encontrado.getValorTotal());
        System.out.println("________________________________________");
        System.out.println("");
        return co;
    }

    public LinkedList<ObjContratoRenting> FinalizarContrato(LinkedList<ObjContratoRenting> co, LinkedList<ObjContratoRenting> coFinalizados, LinkedList<ObjVehiculo> ve, Scanner sc) {
        if (co.isEmpty()) {
            System.out.println("No hay contratos activos para finalizar.");
            System.out.println("________________________________________");
            System.out.println("");
            return co;
        }
        System.out.println("Ingrese el Id del contrato a finalizar (devolucion):");
        String idContrato = v.ValidarString(sc);

        ObjContratoRenting encontrado = null;
        for (ObjContratoRenting o : co) {
            if (o.getIdContrato().equalsIgnoreCase(idContrato)) {
                encontrado = o;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("No se encontro ningun contrato con el Id: " + idContrato);
            System.out.println("________________________________________");
            System.out.println("");
            return co;
        }

        for (ObjVehiculo vh : ve) {
            if (vh.getPlaca().equalsIgnoreCase(encontrado.getPlacaVehiculo())) {
                vh.setEstado("Disponible");
                break;
            }
        }

        coFinalizados.add(encontrado);
        co.remove(encontrado);
        System.out.println("Contrato finalizado y vehiculo devuelto exitosamente.");
        System.out.println("________________________________________");
        System.out.println("");
        return co;
    }

    //INFORMES

    public String Mostrar(ObjCliente o) {
        System.out.println("Cedula: " + o.getCedula());
        System.out.println("Nombre: " + o.getNombre() + " " + o.getApellido());
        System.out.println("Telefono: " + o.getTelefono());
        System.out.println("Direccion: " + o.getDireccion());
        System.out.println("Licencia: " + o.getLicenciaConduccion());
        System.out.println("--------------------------------------------------");
        return "";
    }

    public String Mostrar(ObjVehiculo o) {
        System.out.println("Placa: " + o.getPlaca());
        System.out.println("Marca: " + o.getMarca());
        System.out.println("Modelo: " + o.getModelo());
        System.out.println("Precio Diario: $" + o.getPrecioDiario());
        System.out.println("Estado: " + o.getEstado());
        System.out.println("Tipo: " + o.getTipo());
        System.out.println("Combustible: " + o.getTipoCombustible());
        System.out.println("Transmision: " + o.getTransmision());
        System.out.println("Traccion: " + o.getTraccion());
        System.out.println("Maletero: " + o.getCapacidadMaletero() + " L");
        System.out.println("--------------------------------------------------");
        return "";
    }

    public String Mostrar(ObjContratoRenting o) {
        System.out.println("Id Contrato: " + o.getIdContrato());
        System.out.println("Cedula Cliente: " + o.getCedulaCliente());
        System.out.println("Placa Vehiculo: " + o.getPlacaVehiculo());
        System.out.println("Fecha Inicio: " + o.getFechaInicio());
        System.out.println("Fecha Fin: " + o.getFechaFin());
        System.out.println("Total Dias: " + o.getTotalDias());
        System.out.println("Valor Total: $" + o.getValorTotal());
        System.out.println("--------------------------------------------------");
        return "";
    }

    public Double TotalIngresos(LinkedList<ObjContratoRenting> co, LinkedList<ObjContratoRenting> coFinalizados) {
        Double total = 0.0;
        for (ObjContratoRenting o : co) {
            total = total + o.getValorTotal();
        }
        for (ObjContratoRenting o : coFinalizados) {
            total = total + o.getValorTotal();
        }
        return total;
    }

    public String MostrarInformeGeneral(LinkedList<ObjCliente> cl, LinkedList<ObjVehiculo> ve, LinkedList<ObjContratoRenting> co, LinkedList<ObjContratoRenting> coFinalizados) {
        System.out.println("______________________________________________________");
        System.out.println("Informe General del Sistema de Renting Nacho Lee Final");
        System.out.println("______________________________________________________");

        System.out.println("Listado de clientes:");
        if (cl.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (ObjCliente o : cl) {
                Mostrar(o);
            }
        }

        System.out.println("Listado de vehiculos:");
        if (ve.isEmpty()) {
            System.out.println("No hay vehiculos registrados.");
        } else {
            for (ObjVehiculo o : ve) {
                Mostrar(o);
            }
        }

        System.out.println("Contratos activos:");
        if (co.isEmpty()) {
            System.out.println("No hay contratos activos.");
        } else {
            for (ObjContratoRenting o : co) {
                Mostrar(o);
            }
        }

        System.out.println("Contratos finalizados:");
        if (coFinalizados.isEmpty()) {
            System.out.println("No hay contratos finalizados.");
        } else {
            for (ObjContratoRenting o : coFinalizados) {
                Mostrar(o);
            }
        }

        Double total = TotalIngresos(co, coFinalizados);
        System.out.println("Total Ingresos por Contratos: $" + total);
        System.out.println("______________________________________________________");
        System.out.println("");
        return "Informe general generado exitosamente.";
    }
}