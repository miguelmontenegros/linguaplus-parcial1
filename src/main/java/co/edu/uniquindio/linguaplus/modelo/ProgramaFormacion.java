package co.edu.uniquindio.linguaplus.modelo;

public abstract class ProgramaFormacion implements Cloneable {
    private String codigo;
    private String nombre;
    private String idioma;
    private String descripcion;
    private int duracionMeses;
    private double valorMensual;
    private String estado;
    private String beneficios;
    private int cuposDisponibles;

    public ProgramaFormacion(String codigo, String nombre, String idioma, String descripcion, int duracionMeses, double valorMensual, String estado, String beneficios, int cuposDisponibles) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.idioma = idioma;
        this.descripcion = descripcion;
        this.duracionMeses = duracionMeses;
        this.valorMensual = valorMensual;
        this.estado = estado;
        this.beneficios = beneficios;
        this.cuposDisponibles = cuposDisponibles;
    }

    public void ocuparCupo() {
        if (cuposDisponibles <= 0) {
            throw new IllegalStateException("No hay cupos disponibles para el programa: " + nombre);
        }
        cuposDisponibles--;
    }

    public double calcularValorBaseTotal() {
        return duracionMeses * valorMensual;
    }

    public abstract double calcularValorFinalPrograma();

    @Override
    public ProgramaFormacion clone() {
        try {
            return (ProgramaFormacion) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Error clonando el programa de formación", e);
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public String getEstado() {
        return estado;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) { this.cuposDisponibles = cuposDisponibles; }

    @Override
    public String toString() {
        return nombre + " [" + idioma + "] - Cupos: " + cuposDisponibles;
    }
}