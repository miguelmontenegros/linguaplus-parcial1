package co.edu.uniquindio.linguaplus.modelo.modalidad;

class CarneFisico implements Credencial {

    @Override
    public String getTipoCredencial() {
        return "Carné Físico en PVC con Banda Magnética";
    }
}