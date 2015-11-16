/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexoes.Conectar;
import conexoes.ConnectionFactory;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.table.DefaultTableModel;
import modelos.Campus;
import modelos.Paciente;

/**
 *
 * @author vitor
 */
public class DAOPaciente implements intDAOPaciente {
    
    Connection connection;
    public DAOPaciente() throws ClassNotFoundException{
        connection = ConnectionFactory.getConnection();
    }

    public int salvarDAO(Paciente paciente) {

        Conectar conn = new Conectar();

        try {

            conn.conectar();

            String sql
                    = "INSERT INTO paciente (nome) VALUES ("
                    + "'" + paciente.getNome() + "',"
                    + "'" + paciente.getDataNasc() + "',"
                    + "'" + paciente.getTurma() + "',"
                    + "'" + paciente.getNaturalidade() + "',"
                    + "'" + paciente.getTelefone() + "',"
                    + "'" + paciente.getSexo() + "',"
                    + "'" + paciente.getRaca() + "',"
                    + "'" + paciente.getMatricula() + "',"
                    + "'" + paciente.getCampus() + "'"
                    + ");";

            return conn.insertSQL(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            conn.fecharConexao();
        }

    }

    public DefaultTableModel getPacientes() {
        Paciente paciente = new Paciente();
        Campus campus = new Campus();
        Conectar conexao = new Conectar();
        
        String catalog = null;
        String schemaPattern = null;
        String tableNamePattern = null;
        String[] types = null;

        DefaultTableModel model = null;
        try {

            conexao.conectar();

            String sql
                    = "SELECT campus.id,paciente.nome,campus.nome "
                    + "FROM paciente INNER JOIN campus "
                    + "WHERE paciente.campus_id = campus.id"
                    + ";";

            conexao.executarSQL(sql);
            DatabaseMetaData databaseMetaData = conexao.getCon().getMetaData();
            
            ResultSet myRs = null;
            myRs = databaseMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
            
            System.out.println("Tabelas do Banco de dados:");
            while(myRs.next()){
                System.out.println(myRs.getString("TABLE_NAME"));
            }
            
            model = new DefaultTableModel(new String[]{"Campus ID", "Nome", "Campus"}, 0);

            while (conexao.getResultSet().next()) {
                model.addRow(new Object[]{conexao.getResultSet().getInt("campus.id"), conexao.getResultSet().getString("paciente.nome"), conexao.getResultSet().getString("campus.nome")});
                //System.out.println(conexao.getResultSet().getString("nome"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.fecharConexao();
        }

        return model;

    }
}
