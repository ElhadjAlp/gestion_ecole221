package com.ism.entites;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

public class Article {

    private String nom;
    private double prix;
    private int qteStock;

    
    public Article(String nom, double prix, int qteStock) {
        this.nom = nom;
        this.prix = prix;
        this.qteStock = qteStock;
    }

    public void setPrice(double nextDouble) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setPrice'");
    }

}
 
