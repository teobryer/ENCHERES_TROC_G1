package app.bo;

import lombok.Data;

import java.util.Date;

@Data
public class Enchere {
    private int no_enchere;
    private Date date_enchere;
    private int montant_enchere;
    private int no_article;
    private int no_utilisateur;
}
