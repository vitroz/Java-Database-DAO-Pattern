/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.swing.table.DefaultTableModel;
import modelos.Paciente;

/**
 *
 * @author Daniel
 */
public interface intDAOPaciente {
    
    public int salvarDAO(Paciente paciente);
    public DefaultTableModel getPacientes();
    
}
