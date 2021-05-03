package app.bll;

import app.bo.Enchere;

import java.util.Date;
import java.util.List;

public interface IEncheresManager {

    Enchere insererNouvelleEnchere(Date date_enchere, int montant_enchere,
                                   int no_article, int no_utilisateur) throws BusinessException;

    Enchere recupererEnchereParId(int no_enchere) throws BusinessException;

    List<Enchere> recupererToutesLesEncheres() throws BusinessException;

    Enchere mettreAJourUneEnchere(int no_enchere, Date date_enchere, int montant_enchere,
                                  int no_article, int no_utilisateur) throws  BusinessException;

    void supprimerUneEnchere(int no_enchere) throws  BusinessException;

}
