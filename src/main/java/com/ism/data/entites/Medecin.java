package com.ism.data.entites;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@ToString
@EqualsAndHashCode()

public class Medecin {
   


   
    
    private int id;
    private String nom;
    private String prenom;
   


    private Rv rv;



    public void setMedecin(Medecin medecin) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setMedecin'");
    }



    public Medecin getMedecin() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMedecin'");
    }



    public void setDate(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDate'");
    }



    public void setHeure(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setHeure'");
    }
}

