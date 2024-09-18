package com.ism.view;

import java.util.List;
import java.util.Scanner;
import com.ism.entites.Client;
import com.ism.entites.Dette;
import com.ism.repository.List.DetteRepository;
import com.ism.entites.Article;
import com.ism.entites.User;
import com.ism.services.Implemente.ArticleServiceImpl;
import com.ism.services.Implemente.ClientServiceImpl;
import com.ism.services.Implemente.DetteServiceImpl;
import com.ism.services.Implemente.UserServiceImpl;

import userService.create1;

public class Main {
    public static void main(String[] args) {

        ClientServiceImpl clientServiceImpl = new ClientServiceImpl();
        DetteServiceImpl detteService = new DetteServiceImpl(new DetteRepository());
        ArticleServiceImpl articleService = new ArticleServiceImpl();
        UserServiceImpl userService = new UserServiceImpl();

        int choix;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("1- Créer un utilisateur");
            System.out.println("2- Lister les utilisateurs");
            System.out.println("3- Créer un client");
            System.out.println("4- Lister les clients");
            System.out.println("5- Trouver un client par téléphone");
            System.out.println("6- Créer une dette");
            System.out.println("7- Lister les dettes");
            System.out.println("8- Créer un article ");
            System.out.println("9- Lister les articles");
            System.out.println("10- Quitter");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> {
                    System.out.println("Entrez l email : ");
                    String login = scanner.nextLine();
                    System.out.println("Entrez le mot de passe : ");
                    String password = scanner.nextLine();
                    System.out.println("Entrez le rôle : ");
                    String role = scanner.nextLine();

                   
                    User user = new User(login, password, role, role, role);
                    userService.createUser(user); 
                }
                case 2 -> {
                    List<User> listeUsers = userService.listUsers();
                    listeUsers.forEach(System.out::println);
                }
              
                case 3 -> {
                    Client client = new Client();

                    System.out.println("Entrez le nom : ");
                    client.setSurname(scanner.nextLine());
                    System.out.println("Entrez le numéro de téléphone : ");
                    client.setPhone(scanner.nextLine());
                    System.out.println("Entrez l'adresse : ");
                    client.setAddress(scanner.nextLine());

                    clientServiceImpl.create(client);
                }
                case 4 -> {
                    List<Client> listeClients = clientServiceImpl.findAll();
                    listeClients.forEach(System.out::println);
                }
                case 5 -> {
                    System.out.println("Entrez le numéro de téléphone pour trouver le client : ");
                    String telephone = scanner.nextLine();
                    Client client = clientServiceImpl.findByPhone(telephone);
                    if (client != null) {
                        System.out.println(client);
                    } else {
                        System.out.println("Client non trouvé.");
                    }
                }
                case 6 -> {
                    Dette dette = new Dette(null, choix, choix, null);

                    System.out.println("Entrez le montant total : ");
                    dette.setMontant(scanner.nextDouble());
                    System.out.println("Entrez le montant versé : ");
                    dette.setMontantVerser(scanner.nextDouble());
                    scanner.nextLine(); 

                    List<Article> articles = articleService.findAll();  
                    dette.setArticles(articles);

                    detteService.ajouterNouvelleDette(dette);
                }
                case 7 -> {
                    List<Dette> listeDettes = detteService.obtenirToutesLesDettes();
                    listeDettes.forEach(System.out::println);
                }
                case 8 -> {
                    Article article = new Article(null, choix, choix);

                    System.out.println("Entrez le nom de l'article : ");
                    article.setNom(scanner.nextLine());
                    System.out.println("Entrez le prix de l'article : ");
                    article.setPrice(scanner.nextDouble());
                    System.out.println("Entrez la quantité en stock de l'article : ");
                    article.setQteStock(scanner.nextInt());

                    articleService.create(article);
                }
                case 9 -> {
                    List<Article> listeArticles = articleService.findAll();
                    listeArticles.forEach(System.out::println);
                }
                case 10 -> {
                    System.out.println("Quitter...");
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 10);

        scanner.close();
    }
}
