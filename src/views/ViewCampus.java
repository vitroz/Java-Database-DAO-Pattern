    package views;

import controllers.CtrlPaciente;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author vitor
 */
public class ViewCampus {

    public static void main(String args[]) {

        JFrame frameView = new JFrame();
        frameView.setVisible(true);
        frameView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        

        //CtrlCampus ctrlCampus = new CtrlCampus();         
          
        //Campus campus = new Campus();
        //Pessoa pessoa = new Pessoa();
        //campus.setNome("Interior"); Inserir Registros!!        
        //ctrlCampus.salvarCtrl(campus);

        //JTable tabelaCampus = new JTable(ctrlCampus.getCtrl());
        //frameView.add(new JScrollPane(tabelaCampus));
        
        //TableRowSorter sorter = new TableRowSorter(ctrlCampus.getCtrl());
        //tabelaCampus.setRowSorter(new TableRowSorter(ctrlCampus.getCtrl()));
        //tabelaCampus.setRowSorter(sorter);
        
         CtrlPaciente ctrlPaciente = new CtrlPaciente();
         JTable tabelaPacCampus = new JTable(ctrlPaciente.getCtrl());
         frameView.add(new JScrollPane(tabelaPacCampus));        
         frameView.pack();
        
        
        TableRowSorter sorter = new TableRowSorter(ctrlPaciente.getCtrl());
        tabelaPacCampus.setRowSorter(new TableRowSorter(ctrlPaciente.getCtrl()));
        tabelaPacCampus.setRowSorter(sorter);
        

    }

}
