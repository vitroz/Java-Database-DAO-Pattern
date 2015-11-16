/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.Conectar;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Campus;

/**
 *
 * @author vitor
 */
public class DAOCampus implements IntDAOCampus {
    
    
    public int salvarDAO(Campus campus){
        
        Conectar conn = new Conectar();
        
        try {

            conn.conectar();

            String sql
                    = "INSERT INTO campus (nome) VALUES ("
                    + "'" + campus.getNome() + "'"
                    + ");";

            return conn.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conn.fecharConexao();
        }
        
    }
    
     public DefaultTableModel getCampus() {
        Campus campus = new Campus();
        Conectar conexao = new Conectar();        
       
        DefaultTableModel model = null;
        try {

            conexao.conectar();

            String sql
                    = "SELECT * FROM campus ";
                    
            
            conexao.executarSQL(sql);   
            model = new DefaultTableModel(new String[]{"ID","Unidade"},0);
            

            while (conexao.getResultSet().next()) {                
                model.addRow(new Object[]{conexao.getResultSet().getInt("id"),conexao.getResultSet().getString("nome")});
                //System.out.println(conexao.getResultSet().getString("nome"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return model;

    }
     
     public boolean excluirDAO(int id){
        
        Conectar conexao = new Conectar();
        
        try{
            
            conexao.conectar();
            
            String sql = 
                    "DELETE FROM campus WHERE id = '" + id + "';";
            
            conexao.executarUpdateDeleteSQL(sql);
            
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            conexao.fecharConexao();
        }
        
    }
     
     public boolean updateDAO(Campus campus){
        Conectar conexao = new Conectar();
        
        try{
            
            conexao.conectar();
            
            String sql = 
                    "UPDATE campus SET "                    
                    + " nome = '" + campus.getNome() + "'"                   
                    + " WHERE id = '" + campus.getId() + "';";
            
            conexao.executarUpdateDeleteSQL(sql);
            
            return true;
            
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            conexao.fecharConexao();
        }
        
    }
    
}
