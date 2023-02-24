/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasseDeSystem;
import DatabaseClass.DatabaseManager;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author ya22y
 */
public class Notification {
    private List<String[]> productList=null;
  
    private DatabaseManager db;
    private JOptionPane pane;
    private JDialog dialog;
    public Notification(){
                notifier();
            }
    
    private void createPane(){
        pane=new JOptionPane();
        pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        dialog= pane.createDialog("Rupture de stock");
        
    }
    private void notifier(){
        this.db=DatabaseManager.getInstance();
        productList=db.retournerRuptureDeStock();
      if(productList!=null)
        if(!productList.isEmpty()){
            String text="";
           createPane();
            for(int i=0;i<productList.size();i++){
               text= text+productList.get(i)[1]+"\n";
            }
            pane.setMessage(text);
            dialog.setVisible(true);
        }

    }
}
