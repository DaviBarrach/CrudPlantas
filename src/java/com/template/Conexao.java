package com.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//classe responsável pela conexão do Java ao Banco de dados
public class Conexao {
    static String conexao = "jdbc:postgresql://localhost:5432/Planta";
    static String usuario = "postgres";
    static String senha = "postgres";

    public Connection ConectaBD(){
        try {
            return DriverManager.getConnection(conexao,usuario,senha);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}