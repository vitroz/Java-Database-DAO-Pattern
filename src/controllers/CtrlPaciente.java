/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.DAOCampus;
import DAO.DAOPaciente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vitor
 */
public class CtrlPaciente {
    
    public DefaultTableModel getCtrl() throws ClassNotFoundException{
        return new DAOPaciente().getPacientes();
    }
    
}
