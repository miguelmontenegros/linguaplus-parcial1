package co.edu.uniquindio.linguaplus.modelo.modalidad;

public class CarneDigital implements Credencial{

    @Override

    public String getTipoCredencial() {
        return "Carné Digital Dinámico con Código QR";
    }
}
