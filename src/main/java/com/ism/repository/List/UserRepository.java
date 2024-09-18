
package com.ism.repository.List;

import com.ism.entites.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserRepository {

    private static final List<User> List = null;
    private List<User> utilisateurs = new ArrayList<>();

    public void insert(User utilisateur) {
        utilisateurs.add(utilisateur);
    }

    public List<User> selectAll() {
        return List;
    }

    public Optional<User> trouverParLogin(String login) {
        return utilisateurs.stream()
                .filter(utilisateur -> utilisateur.getLogin().equalsIgnoreCase(login))
                .findFirst();
    }

    public boolean desactiverUtilisateur(String login) {
        Optional<User> utilisateur = trouverParLogin(login);
        if (utilisateur.isPresent() && utilisateur.get().isActive()) {
            utilisateur.get().setActive(false);
            return true;
        }
        return false;
    }

    public boolean activerUtilisateur(String login) {
        Optional<User> utilisateur = trouverParLogin(login);
        if (utilisateur.isPresent() && !utilisateur.get().isActive()) {
            utilisateur.get().setActive(true);
            return true;
        }
        return false;
    }

    public List<User> listerUtilisateursActifs() {
        return utilisateurs.stream()
                .filter(User::isActive)
                .collect(Collectors.toList());
    }

    public List<User> listerUtilisateursParRole(String role) {
        return utilisateurs.stream()
                .filter(utilisateur -> utilisateur.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

    public boolean supprimerUtilisateur(String login) {
        return utilisateurs.removeIf(utilisateur -> utilisateur.getLogin().equalsIgnoreCase(login));
    }

    
}
