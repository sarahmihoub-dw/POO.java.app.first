/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ClasseDeSystem;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author ya22y
 */
public class Produit {
    private AtomicInteger code;
    private String nom, desc;
    private Integer qte;
    private Categorie cat;

    public Produit(String nom, Integer qte,Categorie cat,String desc) {
        this.nom = nom;
        this.desc = desc;
        this.qte = qte;
        this.cat=cat;
        
    }

      public String toStringRow(){
        return "'"+nom+"',"+Integer.toString(qte)+","+cat.getCode().toString()+",'"+desc+"'";
    }
      
    public void setCode(AtomicInteger code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setQte(Integer qte) {
        this.qte = qte;
    }

    public void setCat(Categorie cat) {
        this.cat = cat;
    }

    public AtomicInteger getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getQte() {
        return qte;
    }

    public Categorie getCat() {
        return cat;
    }
    
   
    
}
