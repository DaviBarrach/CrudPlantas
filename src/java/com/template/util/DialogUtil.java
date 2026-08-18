package com.template.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//classe só para alertas e avisos
public class DialogUtil {

    public static void mostrarErro(String mensagem){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    public static void mostrarInformacao(String mensagem){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Confirmacao");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    public static void mostrarAviso(String mensagem){
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }


}

