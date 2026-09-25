package co.edu.uniquindio.linguaplus.modelo;

import java.util.ArrayList;
import java.util.List;

public class Academia {
    private final String nombreComercial;
    private final String nit;
    private final String direccion;
    private final String telefono;
    private final String correoElectronico;
    private final String paginaWeb;

    private final List<Estudiante> estudiantes;
    private final List<Docente> docentes;
    private final List<PeriodoAcademico> periodos;
    private final List<Matricula> matriculas;

    public Academia(String nombreComercial, String nit, String direccion, String telefono, String correoElectronico, String paginaWeb) {
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.paginaWeb = paginaWeb;

        this.estudiantes = new ArrayList<>();
        this.docentes = new ArrayList<>();
        this.periodos = new ArrayList<>();
        this.matriculas = new ArrayList<>();
    }

    public void registrarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void registrarDocente(Docente d) {
        docentes.add(d);
    }

    public void agregarPeriodo(PeriodoAcademico p) {
        periodos.add(p);
    }

    public void registrarMatricula(Matricula m) {
        matriculas.add(m);
    }

    public Estudiante buscarEstudiantePorTelefono(String tel) {
        for (Estudiante e : estudiantes) {
            if (e.getTelefono().equals(tel)) {
                return e;
            }
        }
        return null;
    }

    public boolean esNumeroPerfecto(long numero) {
        if (numero <= 1) return false;
        long sumaDivisores = 0;
        for (long i = 1; i <= numero / 2; i++) {
            if (numero % i == 0) {
                sumaDivisores += i;
            }
        }
        return sumaDivisores == numero;
    }

    public double calcularIngresosTotales() {
        double acumulado = 0.0;
        for (Matricula m : matriculas) {
            acumulado += m.calcularValorTotal();
        }
        return acumulado;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public List<PeriodoAcademico> getPeriodos() {
        return periodos;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

}