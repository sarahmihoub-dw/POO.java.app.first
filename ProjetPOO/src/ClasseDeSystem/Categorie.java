/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasseDeSystem;


/**
 *
 * @author ya22y
 */
public class Categorie {
    private Integer code;
    private String nom;
    
    public Categorie(String id,String nom){
        this.code= Integer.parseInt(id);
        this.nom=nom;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Integer getCode(){
        return this.code;
    }
    public  String getNom(){
       return nom;
   }
}
