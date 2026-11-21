public class ObjVehiculo {
    private String Placa;
    private String Marca;
    private int Modelo;
    private Double PrecioDiario;
    private String Estado; // 1 Disponible, 2 Alquilado
    private String Tipo; // 1 Sedan, 2 Camioneta
    private String TipoCombustible; // 1 Gasolina, 2 Diesel, 3 Electrico
    private String Transmision; // 1 Manual, 2 Automatica
    private String Traccion; // 1 4x2, 2 4x4
    private double CapacidadMaletero; // En listros

    public ObjVehiculo(String placa, String marca, int modelo, Double precioDiario, String estado, String tipo,
            String tipoCombustible, String transmision, String traccion, double capacidadMaletero) {
        Placa = placa;
        Marca = marca;
        Modelo = modelo;
        PrecioDiario = precioDiario;
        Estado = estado;
        Tipo = tipo;
        TipoCombustible = tipoCombustible;
        Transmision = transmision;
        Traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }
    public String getPlaca() {
        return Placa;
    }
    public void setPlaca(String placa) {
        Placa = placa;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public int getModelo() {
        return Modelo;
    }
    public void setModelo(int modelo) {
        Modelo = modelo;
    }
    public Double getPrecioDiario() {
        return PrecioDiario;
    }
    public void setPrecioDiario(Double precioDiario) {
        PrecioDiario = precioDiario;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
    public String getTipoCombustible() {
        return TipoCombustible;
    }
    public void setTipoCombustible(String tipoCombustible) {
        TipoCombustible = tipoCombustible;
    }
    public String getTransmision() {
        return Transmision;
    }
    public void setTransmision(String transmision) {
        Transmision = transmision;
    }
    public String getTraccion() {
        return Traccion;
    }
    public void setTraccion(String traccion) {
        Traccion = traccion;
    }
    public double getCapacidadMaletero() {
        return CapacidadMaletero;
    }
    public void setCapacidadMaletero(double capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

    
}