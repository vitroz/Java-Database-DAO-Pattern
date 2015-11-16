
package controllers;

import DAO.DAOCampus;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelos.Campus;

/**
 *
 * @author vitor
 */
public class CtrlCampus {
    
    public int salvarCtrl(Campus campus){
        return new DAOCampus().salvarDAO(campus);
    }
    
    public DefaultTableModel getCtrl(){
        return new DAOCampus().getCampus();
    }
    
    public boolean excluirCtrl(int id){
        return new DAOCampus().excluirDAO(id);
    }
    
    public boolean updateCtrl(Campus campus){
        return new DAOCampus().updateDAO(campus);
    }
    
}
