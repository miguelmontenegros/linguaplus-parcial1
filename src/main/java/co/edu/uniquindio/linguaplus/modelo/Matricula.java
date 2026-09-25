package co.edu.uniquindio.linguaplus.modelo;

import java.util.ArrayList;
import java.util.List;

public class Matricula {

    private final int numeroMatricula;
    private final Estudiante estudiante;
    private final ProgramaFormacion programa;
    private final String fechaInicio;
    private final Docente docenteTutor;
    private final List<ServicioAdicional> serviciosAdicionales;
    private final double descuento;
    private final String observaciones;

    private Matricula(Builder builder) {

        this.estudiante = builder.estudiante;
        this.programa = builder.programa;
        this.fechaInicio = builder.fechaInicio;
        this.docenteTutor = builder.docenteTutor;
        this.serviciosAdicionales = new ArrayList<>(builder.serviciosAdicionales);
        this.descuento = builder.descuento;
        this.observaciones = builder.observaciones;
        this.numeroMatricula = ConsecutivoMatricula.getInstancia().siguiente();
        this.programa.ocuparCupo();
    }

    public double calcularValorTotal() {

        double valorPrograma = programa.calcularValorFinalPrograma();
        double sumaServicios = 0.0;

        for (ServicioAdicional s : serviciosAdicionales) {
            sumaServicios += s.getPrecio();
        }

        double subtotal = valorPrograma + sumaServicios;
        return subtotal * (1.0 - descuento);
    }

    public int getNumeroMatricula() { return numeroMatricula; }
    public Estudiante getEstudiante() { return estudiante; }
    public ProgramaFormacion getPrograma() { return programa; }
    public String getFechaInicio() { return fechaInicio; }
    public Docente getDocenteTutor() { return docenteTutor; }
    public List<ServicioAdicional> getServiciosAdicionales() { return serviciosAdicionales; }
    public double getDescuento() { return descuento; }
    public String getObservaciones() { return observaciones; }

    @Override

    public String toString() {
        return "Matrícula #" + numeroMatricula + " | " + estudiante.getNombreCompleto() +
                " | " + programa.getNombre() + " | Total: $" + String.format("%.2f", calcularValorTotal());
    }

    public static class Builder {

        private Estudiante estudiante;
        private ProgramaFormacion programa;
        private String fechaInicio;
        private Docente docenteTutor;
        private List<ServicioAdicional> serviciosAdicionales = new ArrayList<>();
        private double descuento = 0.0;
        private String observaciones;

        public Builder conEstudiante(Estudiante estudiante) {
            this.estudiante = estudiante;
            return this;
        }

        public Builder conPrograma(ProgramaFormacion programa) {
            this.programa = programa;
            return this;
        }

        public Builder conFechaInicio(String fechaInicio) {
            this.fechaInicio = fechaInicio;
            return this;
        }

        public Builder conDocenteTutor(Docente docenteTutor) {
            this.docenteTutor = docenteTutor;
            return this;
        }

        public Builder agregarServicioAdicional(ServicioAdicional servicio) {
            if (servicio != null) {
                this.serviciosAdicionales.add(servicio);
            }
            return this;
        }

        public Builder conDescuento(double descuento) {
            this.descuento = descuento;
            return this;
        }

        public Builder conObservaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }

        public Matricula build() {

            if (estudiante == null) {
                throw new IllegalStateException("La matrícula requiere un estudiante obligatorio.");
            }

            if (programa == null) {
                throw new IllegalStateException("La matrícula requiere un programa obligatorio.");
            }

            if (fechaInicio == null || fechaInicio.isBlank()) {
                throw new IllegalStateException("La matrícula requiere una fecha de inicio obligatoria.");
            }

            if (descuento < 0.0 || descuento > 0.30) {
                throw new IllegalStateException("El descuento no puede superar el 30% (0.30) del valor del programa.");
            }

            return new Matricula(this);
        }
    }
}