package com.template.validator;

public class ClassificacaoValidador implements Validador<String>{

    private final String classificacao;

    public ClassificacaoValidador(String classificacao) {
        this.classificacao = classificacao;
    }

    @Override
    public boolean validar(String classificacao) {
        if(classificacao.toUpperCase().contains("ANGIOSPERMA") || classificacao.toUpperCase().contains("GIMNOSPERMA")
                || classificacao.toUpperCase().contains("PTERIDOFITAS") || classificacao.toUpperCase().contains("BRIOFITA")){
            return true;
        }
        return false;
    }

    @Override
    public String getMensagemErro() {
        return "Os únicos valores possíveis de classificação são briofita, pteridofita, gimnosperma, angiosperma.";
    }

    @Override
    public String getValor() {
        return this.classificacao;
    }
}


