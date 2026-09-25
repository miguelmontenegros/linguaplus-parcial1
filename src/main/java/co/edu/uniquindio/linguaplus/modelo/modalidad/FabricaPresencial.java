package co.edu.uniquindio.linguaplus.modelo.modalidad;

public class FabricaPresencial implements FabricaModalidad {

    @Override
    public MaterialEntrega crearMaterial() { return new MaterialImpreso(); }

    @Override
    public Credencial crearCredencial() { return new CarneFisico(); }
}