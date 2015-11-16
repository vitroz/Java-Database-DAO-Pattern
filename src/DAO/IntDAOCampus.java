/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import javax.swing.table.DefaultTableModel;
import modelos.Campus;

/**
 *
 * @author Daniel
 */
public interface IntDAOCampus {
    public int salvarDAO(Campus campus);
    public DefaultTableModel getCampus();
    public boolean excluirDAO(int id);
    public boolean updateDAO(Campus campus);   
    
    
}
