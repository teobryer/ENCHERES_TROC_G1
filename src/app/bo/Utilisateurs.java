package app.bo;

import lombok.Data;
@Data
public class Utilisateurs {
    int no_utilisateur;
    String pseudo;
    String prenom;
    String nom;
    String email;
    String telephone;
    String rue;
    String code_postal;
    String ville;
    String mot_de_passe;
    int credit;
    boolean administrateur;

}
