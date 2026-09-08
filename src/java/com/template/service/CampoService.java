package com.template.service;

import com.template.model.PlantaDTO;
import javafx.collections.FXCollections;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CampoService {

    public void carregarPlantas(TableView<PlantaDTO> tblPlanta) {
        PlantaService service = new PlantaService();
        ArrayList<PlantaDTO> listaPlanta = service.listarTodas();
        tblPlanta.setItems(FXCollections.observableArrayList(listaPlanta));
    }

    public void limparCampos(TextField txtId, TextField txtNome, TextField txtClassificacao,
                             TextField txtPorte, CheckBox chkGostaAgua) {
        txtId.clear();
        txtNome.clear();
        txtClassificacao.clear();
        txtPorte.clear();
        chkGostaAgua.setSelected(false);
    }
}