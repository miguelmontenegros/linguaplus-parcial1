package co.edu.uniquindio.linguaplus.modelo.modalidad;

public class ServicioEntregaModalidad {

    public String prepararPaquete(FabricaModalidad fabrica) {

        MaterialEntrega material = fabrica.crearMaterial();
        Credencial credencial = fabrica.crearCredencial();

        return "PAQUETE ENTREGADO:\n - Material: " + material.getDescripcion() +
                "\n - Credencial: " + credencial.getTipoCredencial();
    }
}