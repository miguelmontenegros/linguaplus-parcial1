package co.edu.uniquindio.linguaplus.modelo.modalidad;

public class FabricaVirtual implements FabricaModalidad {

    @Override
    public MaterialEntrega crearMaterial() { return new LicenciaPlataforma(); }

    @Override
    public Credencial crearCredencial() { return new CarneDigital(); }
}