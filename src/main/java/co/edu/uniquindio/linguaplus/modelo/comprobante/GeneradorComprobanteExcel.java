package co.edu.uniquindio.linguaplus.modelo.comprobante;

public class GeneradorComprobanteExcel extends GeneradorComprobante {
    @Override
    protected Comprobante crearComprobante() {
        return new ComprobanteExcel();
    }
}