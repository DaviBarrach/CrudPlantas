package com.template.service;

import com.template.model.PlantaDAO;
import com.template.model.PlantaDTO;
import java.util.ArrayList;

import static com.template.validator.PlantaValidator.validarPlanta;

public class PlantaService {

    PlantaDAO objPlantaDAO = new PlantaDAO();

    private final PlantaDAO plantaDAO = new PlantaDAO();

    public void salvarPlanta(PlantaDTO planta) {
        PlantaDAO objPlantaDAO = new PlantaDAO();
        objPlantaDAO.cadastrarPlanta(planta);
    }

    public void modificarPlanta(PlantaDTO planta) {
        PlantaDAO objPlantaDAO = new PlantaDAO();
        objPlantaDAO.atualizarPlanta(planta);
    }

    public void apagarPlanta(int id) {
        plantaDAO.deletarPlanta(id);
    }

    public ArrayList<PlantaDTO> listarTodas() {
        return plantaDAO.selecionarPlanta();
    }
}