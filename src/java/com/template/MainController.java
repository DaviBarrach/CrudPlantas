package com.template;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class MainController {

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

    // Primeiro a rodar assim que a tela abre
    @FXML
    private void initialize() {

        // Relacionando as colunas da tabela com os atributos EXATOS (getters) do PlantaDTO
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colClassificacao.setCellValueFactory(new PropertyValueFactory<>("classificacao"));
        colPorte.setCellValueFactory(new PropertyValueFactory<>("porte"));
        colGostaAgua.setCellValueFactory(new PropertyValueFactory<>("gostaAgua"));

        carregarPlantas();

        // Listener opcional: preenche os campos de texto automaticamente ao clicar em uma linha da tabela
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

        PlantaDTO objPlantaDTO = new PlantaDTO();
        objPlantaDTO.setNome(nome);
        objPlantaDTO.setClassificacao(classificacao);
        objPlantaDTO.setPorte(porte);
        objPlantaDTO.setGostaAgua(gostaAgua);

        PlantaDAO objPlantaDAO = new PlantaDAO();
        objPlantaDAO.cadastrarPlanta(objPlantaDTO);

        carregarPlantas();
        btnLimparAction(null); // Limpa os campos após salvar
        lblAviso.setText("Planta cadastrada com sucesso");
    }

    @FXML
    private void btnAtualizarAction(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());
        String nome = txtNome.getText();
        String classificacao = txtClassificacao.getText();
        String porte = txtPorte.getText();
        Boolean gostaAgua = chkGostaAgua.isSelected();

        PlantaDTO objPlantaDTO = new PlantaDTO();
        objPlantaDTO.setId(id);
        objPlantaDTO.setNome(nome);
        objPlantaDTO.setClassificacao(classificacao);
        objPlantaDTO.setPorte(porte);
        objPlantaDTO.setGostaAgua(gostaAgua);

        PlantaDAO objPlantaDAO = new PlantaDAO();
        objPlantaDAO.atualizarPlanta(objPlantaDTO);

        carregarPlantas();
        btnLimparAction(null);
        lblAviso.setText("Planta atualizada com sucesso");
    }

    @FXML
    private void btnDeletarAction(ActionEvent event) {
        int id = Integer.parseInt(txtId.getText());

        PlantaDAO objPlantaDAO = new PlantaDAO();
        objPlantaDAO.deletarPlanta(id);

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
        PlantaDAO objPlantaDAO = new PlantaDAO();
        // Buscando dados do banco
        ArrayList<PlantaDTO> listaPlanta = objPlantaDAO.selecionarPlanta();
        // Atualizando a tabela na tela
        tblPlanta.setItems(FXCollections.observableArrayList(listaPlanta));
    }

    @FXML
    private void carregarCampos() {
        // Pega a linha selecionada na tabela
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