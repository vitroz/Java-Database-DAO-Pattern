/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexoes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conectar {
    
    public Statement st;
    public ResultSet rs;
    public Connection conn = null;
    
    private String servidor = "localhost";
    private String nomeDoBanco = "odontoifma";
    private String usuario = "root";
    private String senha = "";
    
    public Conectar(){}
    
    public Conectar(String pServidor, String pNomeDoBanco, String pUsuario, String pSenha){
        this.servidor = pServidor;
        this.nomeDoBanco = pNomeDoBanco;
        this.usuario = pUsuario;
        this.senha = pSenha;
    }
    
    public Connection conectar(){
        try {
            //Driver do Mysql
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            //local do banco, nome do banco, usuario e senha
            String url = "jdbc:mysql://" + servidor + "/" + nomeDoBanco;
            this.setCon((Connection) DriverManager.getConnection(url, usuario, senha));

            //se ocorrer tudo bem, ou seja, se conectar a linha a segui é executada
            System.out.println("Conectado com sucesso.");
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Conexao com banco de dados falhou.");
        }
        return this.getCon();
    }
    
    /**
     * Executa consultas SQL
     * @param pSQL
     * @return int
     */
    public boolean executarSQL(String pSQL){
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.setResultSet(getStatement().executeQuery(pSQL));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean executarUpdateDeleteSQL(String pSQL){
        try {
            
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            getStatement().executeUpdate(pSQL);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * Executa insert SQL
     * @param pSQL
     * @return boolean
     */
    public int insertSQL(String pSQL){
        int status = 0;
        try {
            //createStatement de con para criar o Statement
            this.setStatement(getCon().createStatement());

            // Definido o Statement, executamos a query no banco de dados
            this.getStatement().executeUpdate(pSQL);
            
            //consulta o ultimo id inserido
            this.setResultSet(this.getStatement().executeQuery("SELECT last_insert_id();"));
            
            //recupera o ultimo id inserido
            while(this.rs.next()){
                status = this.rs.getInt(1);
            }
            
            //retorna o ultimo id inserido
            return status;
        } catch (SQLException ex) {
            return status;
        }
    }

    /**
     * encerra a conexão corrente
     * @return boolean
     */
    public boolean fecharConexao(){
       try {
           if((this.getResultSet() != null) && (this.st != null)){
               this.getResultSet().close();
               this.st.close();
           }
           this.getCon().close();
           return true;
       } catch(SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       return false;
    }
      

    
    
    
    
    
    /**
     * @return the statement
     */
    public Statement getStatement() {
        return st;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return rs;
    }

    /**
     * @return the con
     */
    public Connection getCon() {
        return conn;
    }

    /**
     * @param conn the con to set
     */
    public void setCon(Connection conn) {
        this.conn = conn;
    }

    /**
     * @param st the statement to set
     */
    public void setStatement(Statement st) {
        this.st = st;
    }

    /**
     * @param rs the resultSet to set
     */
    public void setResultSet(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * @return the servidor
     */
    public String getServidor() {
        return servidor;
    }

    /**
     * @param servidor the servidor to set
     */
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    /**
     * @return the nomeDoBanco
     */
    public String getNomeDoBanco() {
        return nomeDoBanco;
    }

    /**
     * @param nomeDoBanco the nomeDoBanco to set
     */
    public void setNomeDoBanco(String nomeDoBanco) {
        this.nomeDoBanco = nomeDoBanco;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
