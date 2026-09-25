package co.edu.uniquindio.linguaplus.modelo;

import java.util.ArrayList;
import java.util.List;

public class PeriodoAcademico implements Cloneable {
    private String nombrePeriodo;
    private String fechaInicio;
    private List<ProgramaFormacion> ofertaProgramas;

    public PeriodoAcademico(String nombrePeriodo, String fechaInicio) {
        this.nombrePeriodo = nombrePeriodo;
        this.fechaInicio = fechaInicio;
        this.ofertaProgramas = new ArrayList<>();
    }

    public void cargarOfertaBase() {
        ofertaProgramas.clear();
        ofertaProgramas.add(new ProgramaBasico("PB-01", "Inglés Básico A1", "Inglés", "Fundamentos de gramática y vocabulario", 4, 150000.0, "Activo", "Acceso a Plataforma Virtual", 15));

        ofertaProgramas.add(new ProgramaIntensivo("PI-02", "Inglés Intensivo B2", "Inglés", "Acelerado con inmersión semanal", 3, 280000.0, "Activo", "Plataforma Virtual + Clubes de Conversación", 10));

        ofertaProgramas.add(new ProgramaPersonalizado("PP-03", "Francés Personalizado C1", "Francés", "Preparación examen DALF C1", 2, 350000.0, "Activo", "Tutor Individual + Material Digital", 5, 10, "B2", "Certificación Oficial"));
    }

    @Override
    public PeriodoAcademico clone() {
        PeriodoAcademico copia = new PeriodoAcademico(this.nombrePeriodo, this.fechaInicio);
        copia.ofertaProgramas = new ArrayList<>();

        for (ProgramaFormacion p : this.ofertaProgramas) {
            copia.ofertaProgramas.add(p.clone());
        }
        return copia;
    }

    public boolean compartenLista(PeriodoAcademico otro) {
        return this.ofertaProgramas == otro.ofertaProgramas;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public List<ProgramaFormacion> getOfertaProgramas() {
        return ofertaProgramas;
    }

}