package com.ism.entites;

import java.util.Date;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Dette<paiement> {
    private Date date;               
    private double montant;           
    private double montantVerser;     
    private double montantRestant;    
    private List<Article> articles;   
        

    public Dette(Date date, double montant, double montantVerser, List<Article> articles) {
        this.date = date;
        this.montant = montant;
        this.montantVerser = montantVerser;
        this.montantRestant = montant - montantVerser;
        this.articles = articles;
    }

    public boolean estSoldee() {
        return this.montantRestant == 0;
    }

    public boolean isPaid() {

        throw new UnsupportedOperationException("Unimplemented method 'isPaid'");
    }
}



