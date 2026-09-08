package com.template.validator;

import java.util.ArrayList;
import java.util.List;

import static com.template.util.DialogUtil.mostrarAviso;

public class PlantaValidator implements IPlantaValidator{

    @Override
    public boolean validarPlanta(String nome, String porte, String classificacao){
        List<Validador<String>> validadores = new ArrayList<>();

        validadores.add(new CampoObrigatorioValidador("nome", nome));
        validadores.add(new CampoObrigatorioValidador("porte", porte));
        validadores.add(new CampoObrigatorioValidador("classificacao", classificacao));
        validadores.add(new PorteValidador(porte));
        validadores.add(new ClassificacaoValidador(classificacao));

        for(Validador<String> validador : validadores){
            if(!validador.validar(validador.getValor())){
                mostrarAviso(validador.getMensagemErro());
                return false;
            }
        }
        return true;
    }
}