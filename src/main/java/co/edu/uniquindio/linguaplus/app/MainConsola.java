package co.edu.uniquindio.linguaplus.app;

import co.edu.uniquindio.linguaplus.modelo.*;
import co.edu.uniquindio.linguaplus.modelo.comprobante.*;
import co.edu.uniquindio.linguaplus.modelo.modalidad.*;

public class MainConsola {

    public static void main(String[] args) {

        System.out.println("PRUEBAS DE LINGUAPLUS\n");

        Academia academia = new Academia("LinguaPlus HQ", "900.987.654-3",
                "Calle 10 #14-25, Armenia", "6067359900", "info@linguaplus.edu.co", "www.linguaplus.edu.co");

        // 1. Singleton y Builder
        System.out.println("1. Prueba Singleton y Builder:");
        Estudiante est1 = new Estudiante("Carlos Mendoza", "10948576", "28", "carlos@gmail.com", 20, "2026-01-10");
        Estudiante est2 = new Estudiante("Maria Lopez", "10949999", "3101234567", "maria@gmail.com", 22, "2026-01-12");

        ProgramaFormacion progBase = new ProgramaBasico("PB-01", "Inglés A1", "Inglés", "Básico", 4, 150000, "Activo", "Plataforma", 10);

        Matricula m1 = new Matricula.Builder()
                .conEstudiante(est1)
                .conPrograma(progBase)
                .conFechaInicio("2026-02-01")
                .build();

        Matricula m2 = new Matricula.Builder()
                .conEstudiante(est2)
                .conPrograma(progBase)
                .conFechaInicio("2026-02-01")
                .conDescuento(0.15)
                .build();

        System.out.println(m1);
        System.out.println(m2);

        // Prueba de la regla del descuento
        try {
            new Matricula.Builder()
                    .conEstudiante(est1)
                    .conPrograma(progBase)
                    .conFechaInicio("2026-02-01")
                    .conDescuento(0.40)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Error capturado (descuento invalido): " + e.getMessage());
        }

        // 2. Prototype
        System.out.println("\n2. Prueba Prototype:");
        PeriodoAcademico periodoPlantilla = new PeriodoAcademico("Base", "2026-01-01");
        periodoPlantilla.cargarOfertaBase();

        PeriodoAcademico p2026_1 = periodoPlantilla.clone();
        p2026_1.setNombrePeriodo("2026-1");

        PeriodoAcademico p2026_2 = periodoPlantilla.clone();
        p2026_2.setNombrePeriodo("2026-2");

        p2026_1.getOfertaProgramas().get(0).ocuparCupo();
        p2026_1.getOfertaProgramas().get(0).ocuparCupo();

        System.out.println("Cupos en 2026-1: " + p2026_1.getOfertaProgramas().get(0).getCuposDisponibles());
        System.out.println("Cupos en 2026-2: " + p2026_2.getOfertaProgramas().get(0).getCuposDisponibles());
        System.out.println("Comparten la misma lista: " + p2026_1.compartenLista(p2026_2));

        // 3. Factory Method
        System.out.println("\n3. Prueba Factory Method:");
        GeneradorComprobante genPDF = new GeneradorComprobantePDF();
        GeneradorComprobante genExcel = new GeneradorComprobanteExcel();

        System.out.println(genPDF.emitir(m1));
        System.out.println(genExcel.emitir(m2));

        // 4. Abstract Factory
        System.out.println("\n4. Prueba Abstract Factory:");
        ServicioEntregaModalidad entrega = new ServicioEntregaModalidad();
        System.out.println("Modalidad presencial:");
        System.out.println(entrega.prepararPaquete(new FabricaPresencial()));
        System.out.println("\nModalidad virtual:");
        System.out.println(entrega.prepararPaquete(new FabricaVirtual()));

        // 5. Búsqueda y Número Perfecto
        System.out.println("\n5. Busqueda de estudiante y numero perfecto:");
        academia.registrarEstudiante(est1);
        academia.registrarEstudiante(est2);

        Estudiante encontrado = academia.buscarEstudiantePorTelefono("28");

        if (encontrado != null) {

            long numTel = Long.parseLong(encontrado.getTelefono());
            boolean esPerfecto = academia.esNumeroPerfecto(numTel);
            System.out.println("Estudiante encontrado: " + encontrado.getNombreCompleto());
            System.out.println("Telefono: " + numTel + " | Es perfecto: " + esPerfecto);
        }

        System.out.println("\nFin de las pruebas.");
    }
}