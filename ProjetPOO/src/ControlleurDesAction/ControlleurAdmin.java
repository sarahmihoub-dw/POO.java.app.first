/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ControlleurDesAction;

import DatabaseClass.DatabaseManager;
import InterfaceGraphique.InterfaceAdmin;
import InterfaceGraphique.InterfaceSaisitQuantité;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ya22y
 */
public class ControlleurAdmin {
    private InterfaceAdmin interfaceAdmin;
    private InterfaceSaisitQuantité interfaceSaisit;
    private DatabaseManager db;
    
    public ControlleurAdmin(InterfaceAdmin interfaceAdmin,InterfaceSaisitQuantité interfaceSaisit){
        this.interfaceAdmin=interfaceAdmin;
        this.interfaceSaisit=interfaceSaisit;
        db=DatabaseManager.getInstance();
        mise_à_jour();
        interfaceAdmin.SuppButton.addActionListener(e->supprimer());
        interfaceAdmin.searchButton.addActionListener(e->rechercher());
        interfaceSaisit.ModifyButton.addActionListener(e->modifier());
    }
    
    void modifier(){
        Integer value=null,code=null;
        try{
        value=Integer.parseInt(interfaceSaisit.getValue());
        code=Integer.parseInt(interfaceAdmin.getSelected());
        }catch(Exception E){
            JOptionPane.showConfirmDialog(null,"Error while parsing !");
        }
        if(code != null){
           try{ db.modifierQuantite(code,value);
           interfaceSaisit.setVisible(false);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(null,"Error while altering !");
        }}
            mise_à_jour();
    }
    
    
    void supprimer(){
        Integer code=null;
       if(interfaceAdmin.selected!=null){
        try{
         code= Integer.parseInt(interfaceAdmin.getSelected());
        }catch(Exception E){
            JOptionPane.showConfirmDialog(null,"Error while getting value !");
        }
        if(code != null){
            db.supprimerProduit(code);
        }
           }
        mise_à_jour();
        interfaceAdmin.selected=null;
    }
    
    void rechercher(){
        String keyword=interfaceAdmin.searchField.getText();
        List<String[]> resultByCat=db.retournerProduitParCat(keyword);
        String[] resultByName=db.retournerProduit(keyword);
        if(!keyword.equals("")){
        if(resultByName!=null){   
        if(resultByName.length>0){
            DefaultTableModel model=(DefaultTableModel) interfaceAdmin.ProductTabel.getModel();
           int rows = model.getRowCount(); 
           for(int i=rows-1;i>=0;i--){
                model.removeRow(i); 
           }
          
           Object[] tableRow= (Object [])resultByName;
         
           interfaceAdmin.showAllProduct(tableRow);
       }}
        if(resultByCat!=null){
        if(!resultByCat.isEmpty()){
   
             DefaultTableModel model=(DefaultTableModel) interfaceAdmin.ProductTabel.getModel();
           int rows = model.getRowCount(); 
           for(int i=rows-1;i>=0;i--){
                model.removeRow(i); }
           
           for(int i=0;i<resultByCat.size();i++){
            Object[] tableRow= (Object [])resultByCat.get(i);
            interfaceAdmin.showAllProduct(tableRow); }
        }}
        }else{
            mise_à_jour();
        }
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
       }
       
    }
}
