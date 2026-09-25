package co.edu.uniquindio.linguaplus.modelo;

public class ProgramaPersonalizado extends ProgramaFormacion {
    private int cantidadSesionesTutor;
    private String nivelIdiomaRequerido;
    private String objetivosEstudiante;

    public ProgramaPersonalizado(String codigo, String nombre, String idioma, String descripcion, int duracionMeses, double valorMensual, String estado, String beneficios, int cuposDisponibles, int cantidadSesionesTutor, String nivelIdiomaRequerido, String objetivosEstudiante) {

        super(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual, estado, beneficios, cuposDisponibles);
        this.cantidadSesionesTutor = cantidadSesionesTutor;
        this.nivelIdiomaRequerido = nivelIdiomaRequerido;
        this.objetivosEstudiante = objetivosEstudiante;
    }

    @Override
    public double calcularValorFinalPrograma() {
        double costoSesionesTutor = cantidadSesionesTutor * 45000.0;
        return calcularValorBaseTotal() + costoSesionesTutor;
    }

    public int getCantidadSesionesTutor() {
        return cantidadSesionesTutor;
    }

    public String getNivelIdiomaRequerido() {
        return nivelIdiomaRequerido;
    }

    public String getObjetivosEstudiante() {
        return objetivosEstudiante;
    }
}