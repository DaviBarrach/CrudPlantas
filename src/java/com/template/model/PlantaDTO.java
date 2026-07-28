package com.template.model;

public class PlantaDTO {

        private int id;
        private String nome;
        private String classificacao;
        private String porte;
        private boolean gostaAgua;


        public int getId(){
            return id;
        }

        public void setId(int id){
            this.id = id;
        }

        public String getNome(){
            return nome;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

        public String getClassificacao(){
            return classificacao;
        }

        public void setClassificacao(String classificacao){
            this.classificacao = classificacao;
        }

        public String getPorte(){
            return porte;
        }

        public void setPorte(String porte){
            this.porte = porte;
        }

        public boolean getGostaAgua(){
            return gostaAgua;
        }

        public void setGostaAgua(boolean gostaAgua){
            this.gostaAgua = gostaAgua;
        }
    }

