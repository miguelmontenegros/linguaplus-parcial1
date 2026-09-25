package co.edu.uniquindio.linguaplus.modelo.comprobante;

import co.edu.uniquindio.linguaplus.modelo.Matricula;

public class ComprobantePDF implements Comprobante {
    @Override
    public String generar(Matricula matricula) {
        return "Comprobante PDF - Matricula No. " + matricula.getNumeroMatricula() +
                "\nEstudiante: " + matricula.getEstudiante().getNombreCompleto() +
                "\nPrograma: " + matricula.getPrograma().getNombre() +
                "\nTotal pagado: $" + matricula.calcularValorTotal();
    }
}