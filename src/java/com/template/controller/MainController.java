package com.template.controller;

import com.template.model.PlantaDAO;
import com.template.model.PlantaDTO;
import com.template.service.PlantaService;
import com.template.validator.IPlantaValidator;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;


public class MainController {

    private final IPlantaValidator pValidator;

    public MainController(IPlantaValidator pValidator) {
        this.pValidator = pValidator;
    }

    @FXML private TextField txtId;
    @FXML private TextField txtNome;
    @FXML private TextField txtClassificacao;
    @FXML private TextField txtPorte;
    @FXML private Button btnSalvar;
    @FXML private Button btnAtualizar;
    @FXML private Button btnDeletar;
    @FXML private Button btnLimpar;
    @FXML private TableView<PlantaDTO> tblPlanta;
    @FXML private TableColumn<PlantaDTO, Integer> colId;
    @FXML private TableColumn<PlantaDTO, String> colNome;
    @FXML private TableColumn<PlantaDTO, String> colClassificacao;
    @FXML private TableColumn<PlantaDTO, String> colPorte;
    @FXML private TableColumn<PlantaDTO, Boolean> colGostaAgua;
    @FXML private CheckBox chkGostaAgua;
    @FXML private Label lblAviso;

    @FXML
    private void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        colPorte.setCellValueFactory(new PropertyValueFactory<>("porte"));
        colGostaAgua.setCellValueFactory(new PropertyValueFactory<>("gostaAgua"));

        carregarPlantas();

        tblPlanta.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                carregarCampos();
            }
        });
    }

    @FXML
    private void btnSalvarAction(ActionEvent event) {
        String nome = txtNome.getText();
        String classificacao = txtClassificacao.getText();
        String porte = txtPorte.getText();
        Boolean gostaAgua = chkGostaAgua.isSelected();

        if(!pValidator.validarPlanta(nome, porte, classificacao)){
            return;
        }

        PlantaService service = new PlantaService();
        PlantaDTO objPlantaDTO = new PlantaDTO();
        objPlantaDTO.setNome(nome);
        objPlantaDTO.setClassificacao(classificacao);
        objPlantaDTO.setPorte(porte);
        objPlantaDTO.setGostaAgua(gostaAgua);

        service.salvarPlanta(objPlantaDTO);
        carregarPlantas();
        btnLimparAction(null);
        lblAviso.setText("Planta cadastrada com sucesso");
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String classificacao = txtClassificacao.getText();
        String porte = txtPorte.getText();
        Boolean gostaAgua = chkGostaAgua.isSelected();

        if(!pValidator.validarPlanta(nome, porte, classificacao)){
            return;
        }

        PlantaService service = new PlantaService();
        PlantaDTO objPlantaDTO = new PlantaDTO();
        objPlantaDTO.setId(id);
        objPlantaDTO.setNome(nome);
        objPlantaDTO.setClassificacao(classificacao);
        objPlantaDTO.setPorte(porte);
        objPlantaDTO.setGostaAgua(gostaAgua);

        service.modificarPlanta(objPlantaDTO);
        carregarPlantas();
        btnLimparAction(null);
        lblAviso.setText("Planta atualizada com sucesso.");
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        PlantaService service = new PlantaService();
        int id = Integer.parseInt(txtId.getText());

        service.apagarPlanta(id);
        carregarPlantas();
        btnLimparAction(null);
        lblAviso.setText("Planta deletada com sucesso");
    }

    @FXML
    private void btnLimparAction(ActionEvent event) {
        txtId.clear();
        txtNome.clear();
        txtClassificacao.clear();
        txtPorte.clear();
        chkGostaAgua.setSelected(false);
    }

    @FXML
    private void carregarPlantas() {
        PlantaService service = new PlantaService();
        ArrayList<PlantaDTO> listaPlanta = service.listarTodas();
        tblPlanta.setItems(FXCollections.observableArrayList(listaPlanta));
    }

    @FXML
    private void carregarCampos() {
        PlantaDTO plantaDTO = tblPlanta.getSelectionModel().getSelectedItem();

        if (plantaDTO != null) {
            txtId.setText(String.valueOf(plantaDTO.getId()));
            txtNome.setText(plantaDTO.getNome());
            txtClassificacao.setText(plantaDTO.getClassificacao());
            txtPorte.setText(plantaDTO.getPorte());
            chkGostaAgua.setSelected(plantaDTO.getGostaAgua());
        }
    }
}