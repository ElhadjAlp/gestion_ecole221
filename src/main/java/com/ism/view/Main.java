package com.ism.view;

import java.util.List;
import java.util.Scanner;

import com.ism.core.factory.Factory;
import com.ism.data.entites.Medecin;
import com.ism.services.MedecinService;
import com.ism.services.RvService;
import com.ism.services.Impl.MedecinServiceImpl;
import com.ism.services.Impl.RvServiceImpl;

public class Main {
    public static void main(String[] args) {
        int choix;
        Scanner scanner = new Scanner(System.in);

        // Service pour les médecins
        MedecinService medecinServiceImpl = new MedecinServiceImpl(
                Factory.getInstanceMedecinRepository());

        // Service pour les rendez-vous
        RvService rvServiceImpl = new RvServiceImpl(Factory.getInstanceRvRepository());

        Medecin medecin;
        do {
            System.out.println("1-Creer medecin");
            System.out.println("2-Lister Medecins");
            System.out.println("3-Filtrer par Telephone");
            System.out.println("4-Creer un Rv");
            System.out.println("5-Lister les Rv");
            System.out.println("6-Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();  
            
            switch (choix) {
                case 1:
                   
                    medecin = new Medecin();
                    System.out.println("Entrer le surnom");
                    String surname = scanner.nextLine();
                    Object nom;
                    if (medecinServiceImpl.searchMedecinByDate(nom) != null) {
                        System.out.println("Le nom existe déjà");
                    } else {
                        medecin.setNom(surname);
                        System.out.println("Entrer le NOM");
                        medecin.setNom(scanner.nextLine());
                        System.out.println("Entrer Prenom");
                        medecin.setPrenom(scanner.nextLine());
                        System.out.println("Voulez-vous associer un compte à ce médecin ? O/N");
                        char res = scanner.next().charAt(0);
                        scanner.nextLine();
                        if (res == 'O') {
                            System.out.println("Entrer le nom ");
                            medecin.setNom(scanner.nextLine());
                            System.out.println("Entrer le prénom");
                            medecin.setPrenom(scanner.nextLine());
                        }

                        medecinServiceImpl.createMedecin(medecin);
                    }
                    break;
                case 2:
                    
                    List<Medecin> list = medecinServiceImpl.findAllMedecins();
                    list.forEach(System.out::println);
                    break;
                case 3:
                    
                    System.out.println("Entrer le téléphone");
                    String tel = scanner.nextLine();
                    medecin = medecinServiceImpl.searchMedecin(tel);
                    if (medecin == null) {
                        System.out.println("Pas de médecin trouvé");
                    } else {
                        System.out.println(medecin);
                    }
                    break;
                case 4:
                    
                    break;
                case 5:
                    
                    List<Medecin> listMedecins = rvServiceImpl.findAllMedecins();
                    listMedecins.forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }

        } while (choix != 6);

        scanner.close();
    }
}
