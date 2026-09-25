package co.edu.uniquindio.linguaplus.modelo.comprobante;

public class GeneradorComprobantePDF extends GeneradorComprobante {
    @Override
    protected Comprobante crearComprobante() {
        return new ComprobantePDF();
    }
}