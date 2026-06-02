package com.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

    //Classe com os métodos de Crud
    public class PlantaDAO {

        public void cadastrarPlanta(PlantaDTO planta) {
            String sql = "INSERT INTO plantas (nome, classificacao, porte, gosta_agua) VALUES (?, ?, ?, ?)";

            try (Connection c = new Conexao().ConectaBD(); PreparedStatement ps = c.prepareStatement(sql);){
                ps.setString(1, planta.getNome());
                ps.setString(2, planta.getClassificacao());
                ps.setString(3, planta.getPorte());
                ps.setBoolean(4, planta.getGostaAgua()); // Aqui passamos o valor booleano (true ou false)
                ps.execute();
            } catch (SQLException ex){
                Logger.getLogger(PlantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        public ArrayList<PlantaDTO> selecionarPlanta() {
            String sql = "select * from plantas";
            ArrayList<PlantaDTO> listaPlantas = new ArrayList<>();

            try (Connection c = new Conexao().ConectaBD(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery();){
                while (rs.next())
                {
                    PlantaDTO planta = new PlantaDTO();
                    planta.setId(rs.getInt("id"));
                    planta.setNome(rs.getString("nome"));
                    planta.setClassificacao(rs.getString("classificacao"));
                    planta.setPorte(rs.getString("porte"));
                    planta.setGostaAgua(rs.getBoolean("gosta_agua"));
                    listaPlantas.add(planta);

                }
            } catch (SQLException ex) {
                Logger.getLogger(PlantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

            return listaPlantas;
        }

        public void atualizarPlanta(PlantaDTO planta) {
            String sql = "UPDATE plantas SET nome = ?, classificacao = ?, porte = ?, gosta_agua = ? WHERE id = ?";

            try(Connection c = new Conexao().ConectaBD(); PreparedStatement ps = c.prepareStatement(sql);) {
                ps.setString(1, planta.getNome());
                ps.setString(2, planta.getClassificacao());
                ps.setString(3, planta.getPorte());
                ps.setBoolean(4, planta.getGostaAgua());
                ps.setInt(5, planta.getId()); // O ID é o 5º parâmetro (WHERE id = ?)
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(PlantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        public void deletarPlanta(int idPlanta) {
            String sql = "DELETE FROM plantas WHERE id = ?";
            try (Connection c = new Conexao().ConectaBD(); PreparedStatement ps = c.prepareStatement(sql);){
                ps.setInt(1, idPlanta);
                ps.execute();
            } catch (SQLException ex) {
                Logger.getLogger(PlantaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


