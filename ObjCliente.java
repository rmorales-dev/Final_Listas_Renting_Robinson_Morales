public class ObjCliente {
    private String Cedula; //sin caracteres especiales.
    private String Nombre; //sin números ni caracteres especiales.
    private String Apellido; //sin números ni caracteres especiales.
    private String Telefono; //solo números.
    private String Direccion;
    private String LicenciaConduccion;

    public ObjCliente(String cedula, String nombre, String apellido, String telefono, String direccion,
            String licenciaConduccion) {
        Cedula = cedula;
        Nombre = nombre;
        Apellido = apellido;
        Telefono = telefono;
        Direccion = direccion;
        LicenciaConduccion = licenciaConduccion;
    }
    public ObjCliente() {
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getLicenciaConduccion() {
        return LicenciaConduccion;
    }

    public void setLicenciaConduccion(String licenciaConduccion) {
        LicenciaConduccion = licenciaConduccion;
    }

}
