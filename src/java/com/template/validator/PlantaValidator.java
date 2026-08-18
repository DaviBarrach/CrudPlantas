package com.template.validator;

import static com.template.util.DialogUtil.mostrarAviso;

public class PlantaValidator {

    /*OCP é aberto para integração, mas fechado para manutenção*/

    public static boolean validarPlanta(String nome, String classificacao, String porte){
        if(nome.isEmpty() || classificacao.isEmpty() || porte.isEmpty()){
            mostrarAviso("Preencha todos os campos!");
            return false;
        }
        if(!validarClassificacao(classificacao)){
            mostrarAviso("Preencha a classificacao com angiosperma, gimnosperma, pteridofita ou briofita!!");
            return false;
        }
        if(!validarPorte(porte)){
            mostrarAviso("Preencha o porte com pequeno, medio ou grande!");
            return false;
        }
        return true;
    }

    public static boolean validarClassificacao(String classificacao){
        if(classificacao.toUpperCase().contains("ANGIOSPERMA") || classificacao.toUpperCase().contains("GIMNOSPERMA")
        || classificacao.toUpperCase().contains("PTERIDOFITAS") || classificacao.toUpperCase().contains("BRIOFITA")){
            return true;
        }
        return false;
    }

    public static boolean validarPorte(String porte){
        if(porte.toUpperCase().contains("GRANDE") || porte.toUpperCase().contains("MEDIO") || porte.toUpperCase().contains("PEQUENO")){
            return true;
        }
        return false;
    }


}

