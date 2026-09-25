package co.edu.uniquindio.linguaplus.modelo.comprobante;

import co.edu.uniquindio.linguaplus.modelo.Matricula;

public class ComprobanteExcel implements Comprobante {
    @Override
    public String generar(Matricula matricula) {
        return "Comprobante Excel - Matricula: " + matricula.getNumeroMatricula() +
                ", Estudiante: " + matricula.getEstudiante().getNombreCompleto() +
                ", Documento: " + matricula.getEstudiante().getDocumentoIdentidad() +
                ", Programa: " + matricula.getPrograma().getNombre() +
                ", Total: $" + matricula.calcularValorTotal();
    }
}