package com.template.validator;

public class PorteValidador implements  Validador<String>{

    private final String porte;

    public PorteValidador(String porte) {
        this.porte = porte;
    }

    @Override
    public boolean validar(String valor) {
        if(porte.toUpperCase().contains("GRANDE") || porte.toUpperCase().contains("MEDIO") || porte.toUpperCase().contains("PEQUENO")){
            return true;
        }
        return false;
    }

    @Override
    public String getMensagemErro() {
        return "Preencha o porte com pequeno, medio ou grande!";
    }

    @Override
    public String getValor() {
        return this.porte;
    }
}
