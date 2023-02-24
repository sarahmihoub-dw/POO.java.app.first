/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlleurDesAction;
import ClasseDeSystem.Categorie;
import ClasseDeSystem.Produit;
import DatabaseClass.DatabaseManager;
import InterfaceGraphique.InterfaceAdmin;
import InterfaceGraphique.InterfaceSaisit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ya22y
 */
public class ControlleurDesSaisit implements ActionListener{
    
    private InterfaceSaisit interfaceSaisit;
    private InterfaceAdmin interfaceAdmin;
    private Produit produit;
    private DatabaseManager db=null;
    private final static int NAME=0,QTE=1,CAT=2,DESC=3;
    public ControlleurDesSaisit(InterfaceSaisit inputView,InterfaceAdmin adminView){
        this.interfaceSaisit=inputView;
        this.interfaceAdmin=adminView;
        db=DatabaseManager.getInstance();
        inputView.addButton.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String[] data=interfaceSaisit.getData();
        Categorie categorie;
        String[] categorie_query=db.retournerCat(data[CAT]);
        if(categorie_query==null){
            categorie=new Categorie("0",data[CAT]);
            db.ajouterCat(categorie);
            categorie_query=db.retournerCat(data[CAT]);
        }
            categorie=new Categorie(categorie_query[0],data[CAT]);
             produit= new Produit(data[NAME],Integer.parseInt(data[QTE]),categorie,data[DESC]);
             String[] queryResult=db.retournerProduit(data[NAME]);
        if(queryResult==null){
            db.ajouterProduit(produit);
            interfaceSaisit.setVisible(false);
            }else{
             JOptionPane.showMessageDialog(null, "Produit existe déja!");
             }
        
        mise_à_jour();
        
        
    }
    
     void mise_à_jour(){
         
          DefaultTableModel model=(DefaultTableModel) interfaceAdmin.ProductTabel.getModel();
         int rows = model.getRowCount();  
          for(int i=rows-1;i>=0;i--){
                model.removeRow(i); 
           }
       List<String[]> allResult= db.retournerTousProduit();
       
       if(allResult!=null){
           
          
       for(int i=0;i<allResult.size();i++){
           Object[] tableRow= (Object [])allResult.get(i);
           interfaceAdmin.showAllProduct(tableRow);
       }
       }else{
          JOptionPane.showMessageDialog(null,"Empty Database!");
       }
       
    }
    
    
}
