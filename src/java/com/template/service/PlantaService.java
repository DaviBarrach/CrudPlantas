package com.template.service;

import com.template.model.PlantaDAO;
import com.template.model.PlantaDTO;
import java.util.ArrayList;

public class PlantaService {

    private final PlantaDAO plantaDAO = new PlantaDAO();

    public void salvarPlanta(PlantaDTO planta) {
        plantaDAO.cadastrarPlanta(planta);
    }

    public void modificarPlanta(PlantaDTO planta) {
        plantaDAO.atualizarPlanta(planta);
    }

    public void apagarPlanta(int id) {
        plantaDAO.deletarPlanta(id);
    }

    public ArrayList<PlantaDTO> listarTodas() {
        return plantaDAO.selecionarPlanta();
    }
}