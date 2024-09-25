package com.ism.data.entites;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter 
@Setter
@ToString
@EqualsAndHashCode()


public class Rv {


    private int id;
    private String date;
    private String heure;
   


    private Rv rv;
}

