package app.bo;

import lombok.Data;

import java.util.Date;

@Data
public class Articles_Vendus {

    private int no_article;
    private String nom_article;
    private String description;
    private Date date_debut_encheres;
    private Date date_fin_encheres;
    private int prix_initial;
    private int prix_vente;
    private Utilisateurs utilisateur;
    private int no_categorie;
    private Retraits retrait;

}
