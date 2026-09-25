package co.edu.uniquindio.linguaplus.modelo;

public class Estudiante {
    private final String nombreCompleto;
    private final String documentoIdentidad;
    private final String telefono;
    private final String correoElectronico;
    private final int edad;
    private final String fechaRegistro;

    public Estudiante(String nombreCompleto, String documentoIdentidad, String telefono,
                      String correoElectronico, int edad, String fechaRegistro) {
        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public String getTelefono() { return telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
    public int getEdad() { return edad; }
    public String getFechaRegistro() { return fechaRegistro; }

    @Override
    public String toString() {
        return nombreCompleto + " (Doc: " + documentoIdentidad + " | Tel: " + telefono + ")";
    }
}