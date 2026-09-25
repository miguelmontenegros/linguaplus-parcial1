package co.edu.uniquindio.linguaplus.modelo;

public class ServicioAdicional {
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final double precio;
    private final boolean disponible;

    public ServicioAdicional(String codigo, String nombre, String descripcion, double precio, boolean disponible) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public boolean isDisponible() { return disponible; }

    @Override
    public String toString() {
        return nombre + " ($" + String.format("%.2f", precio) + ")";
    }
}