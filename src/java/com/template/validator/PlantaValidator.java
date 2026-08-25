package com.template.validator;

import java.util.ArrayList;
import java.util.List;

import static com.template.util.DialogUtil.mostrarAviso;

public class PlantaValidator {

    /*OCP é aberto para integração, mas fechado para manutenção*/

    public static boolean validarPlanta(String nome, String classificacao, String porte){

        //lista que herda a interface e guarda seus objetos
        List<Validador<String>> validadores = new ArrayList<>();

        validadores.add(new CampoObrigatorioValidador("nome", nome));
        validadores.add(new CampoObrigatorioValidador("porte", porte));
        validadores.add(new CampoObrigatorioValidador("classificacao", classificacao));
        validadores.add(new PorteValidador(porte));
        validadores.add(new ClassificacaoValidador(classificacao));

        //foreach na lista de validador
        for(Validador<String> validador : validadores){
            if(!validador.validar(validador.getValor())){
                mostrarAviso(validador.getMensagemErro());
                return false;
            }

        }
        return true;
    }


}

