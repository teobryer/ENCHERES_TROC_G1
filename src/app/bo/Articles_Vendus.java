package app.bo;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Articles_Vendus {

    private int no_article;
    private String nom_article;
    private String description;
    private LocalDate date_debut_encheres;
    private LocalDate date_fin_encheres;
    private int prix_initial;
    private int prix_vente;
    private Utilisateurs utilisateur;
    private Categories categorie;
    private int no_categorie;
    private Retraits retrait;
    private Enchere enchereMax;
    private List<Enchere> listEnchere;

}
