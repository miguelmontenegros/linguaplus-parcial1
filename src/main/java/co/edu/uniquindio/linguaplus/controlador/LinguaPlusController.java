package co.edu.uniquindio.linguaplus.controlador;

import co.edu.uniquindio.linguaplus.modelo.*;
import co.edu.uniquindio.linguaplus.modelo.comprobante.*;
import co.edu.uniquindio.linguaplus.modelo.modalidad.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LinguaPlusController {

    @FXML private TextField txtNombre;
    @FXML private TextField txtDocumento;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> cmbPrograma;
    @FXML private ComboBox<String> cmbModalidad;
    @FXML private TextField txtDescuento;
    @FXML private Label lblMensaje;
    @FXML private TableView<Matricula> tblMatriculas;
    @FXML private TableColumn<Matricula, Integer> colNumero;
    @FXML private TableColumn<Matricula, String> colEstudiante;
    @FXML private TableColumn<Matricula, String> colPrograma;
    @FXML private TableColumn<Matricula, Double> colTotal;

    private Academia academia;
    private PeriodoAcademico periodoActual;
    private ObservableList<Matricula> listaMatriculas;

    @FXML
    public void initialize() {
        academia = new Academia("LinguaPlus", "900.123.456", "Armenia", "6067359900", "info@linguaplus.edu.co", "www.linguaplus.edu.co");

        PeriodoAcademico base = new PeriodoAcademico("Base", "2026-01");
        base.cargarOfertaBase();
        periodoActual = base.clone();
        periodoActual.setNombrePeriodo("2026-1");

        cmbPrograma.setItems(FXCollections.observableArrayList(
                "Inglés Básico A1", "Inglés Intensivo B2", "Francés Personalizado C1"
        ));
        cmbModalidad.setItems(FXCollections.observableArrayList("Presencial", "Virtual"));
        cmbModalidad.setValue("Presencial");

        listaMatriculas = FXCollections.observableArrayList();
        tblMatriculas.setItems(listaMatriculas);

        colNumero.setCellValueFactory(cellData -> new javafx.beans.property.SimpleIntegerProperty(cellData.getValue().getNumeroMatricula()).asObject());
        colEstudiante.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEstudiante().getNombreCompleto()));
        colPrograma.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getPrograma().getNombre()));
        colTotal.setCellValueFactory(cellData -> new javafx.beans.property.SimpleDoubleProperty(cellData.getValue().calcularValorTotal()).asObject());
    }

    @FXML
    private void onRegistrarMatricula() {
        try {
            String nombre = txtNombre.getText();
            String doc = txtDocumento.getText();
            String tel = txtTelefono.getText();
            String progNom = cmbPrograma.getValue();
            String modalidad = cmbModalidad.getValue();
            String descTexto = txtDescuento.getText();

            double desc = 0.0;
            if (descTexto != null && !descTexto.isBlank()) {
                desc = Double.parseDouble(descTexto);
            }

            Estudiante est = new Estudiante(nombre, doc, tel, "correo@temp.com", 20, "2026-01-01");

            ProgramaFormacion seleccionado = null;
            for (ProgramaFormacion p : periodoActual.getOfertaProgramas()) {
                if (p.getNombre().equals(progNom)) {
                    seleccionado = p;
                    break;
                }
            }

            FabricaModalidad fabrica;
            if ("Virtual".equalsIgnoreCase(modalidad)) {
                fabrica = new FabricaVirtual();
            } else {
                fabrica = new FabricaPresencial();
            }

            ServicioEntregaModalidad servicioEntrega = new ServicioEntregaModalidad();
            String infoModalidad = servicioEntrega.prepararPaquete(fabrica);

            Matricula matricula = new Matricula.Builder()
                    .conEstudiante(est)
                    .conPrograma(seleccionado)
                    .conFechaInicio("2026-02-01")
                    .conDescuento(desc)
                    .build();

            academia.registrarEstudiante(est);
            academia.registrarMatricula(matricula);
            listaMatriculas.add(matricula);

            lblMensaje.setStyle("-fx-text-fill: green;");
            lblMensaje.setText("Matrícula #" + matricula.getNumeroMatricula() + " (" + modalidad + ") registrada. Paquete: " + infoModalidad);

        } catch (Exception e) {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("Error: " + e.getMessage());
        }
    }

    @FXML
    private void onBuscarTelefono() {
        String tel = txtTelefono.getText();
        Estudiante est = academia.buscarEstudiantePorTelefono(tel);
        if (est != null) {
            try {
                long num = Long.parseLong(tel);
                boolean perf = academia.esNumeroPerfecto(num);
                lblMensaje.setStyle("-fx-text-fill: blue;");
                lblMensaje.setText("Estudiante: " + est.getNombreCompleto() + " | ¿Teléfono perfecto?: " + perf);
            } catch (NumberFormatException e) {
                lblMensaje.setText("Estudiante hallado: " + est.getNombreCompleto() + " (Teléfono no numérico)");
            }
        } else {
            lblMensaje.setStyle("-fx-text-fill: red;");
            lblMensaje.setText("No existe estudiante registrado con el teléfono: " + tel);
        }
    }
}