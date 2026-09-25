package co.edu.uniquindio.linguaplus.modelo;

public class ProgramaIntensivo extends ProgramaFormacion {
    public ProgramaIntensivo(String codigo, String nombre, String idioma, String descripcion, int duracionMeses, double valorMensual, String estado, String beneficios, int cuposDisponibles) {

        super(codigo, nombre, idioma, descripcion, duracionMeses, valorMensual, estado, beneficios, cuposDisponibles);
    }

    @Override
    public double calcularValorFinalPrograma() {
        return calcularValorBaseTotal() * 1.10;
    }
}