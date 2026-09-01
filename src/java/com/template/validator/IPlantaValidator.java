package com.template.validator;

public interface IPlantaValidator {

    boolean validarPlanta(String nome, String porte, String classificacao);
    boolean validarNome(String nome);
    boolean validarPorte(String porte);
    boolean validarClassificacao(String classificacao);
}
