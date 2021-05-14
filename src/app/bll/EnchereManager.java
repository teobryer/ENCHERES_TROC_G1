package app.bll;



import app.bo.Articles_Vendus;
import app.bo.Enchere;
import app.bo.Utilisateurs;
import app.dal.DALException;
import app.dal.DAOFact;

import java.util.Date;
import java.util.List;

public class EnchereManager implements IEncheresManager {

    @Override
    public Enchere insererNouvelleEnchere(Date date_enchere, int montant_enchere,
                                          int no_article, int no_utilisateur) throws BusinessException {
        Utilisateurs user;
        try{

             user =  DAOFact.getUtilisateursDAO().selectById(no_utilisateur);
            if(user.getCredit()-montant_enchere <0 ){
                throw new BusinessException("Action impossible", "Vous ne disposez pas assez de credits");
            }

        }
        catch (Exception e){
            throw new BusinessException("Erreur", "Erreur inconnue");
        }

        Enchere nouvelleEnchere = new Enchere();
        nouvelleEnchere.setDate_enchere(date_enchere);
        nouvelleEnchere.setMontant_enchere(montant_enchere);
        nouvelleEnchere.setNo_article(no_article);
        nouvelleEnchere.setNo_utilisateur(no_utilisateur);

        try {
          Articles_Vendus article =  DAOFact.getArticlesDAO().selectById(no_article); //  récupération de l'article
            try {
                Enchere ancienneEnchereMax = article.getEnchereMax(); // récupération de l'ancienne enchere Max avant cette enchère
                Utilisateurs utilisateurPrecedenteEnchereMax = DAOFact.getUtilisateursDAO().selectById(ancienneEnchereMax.getNo_utilisateur()); //récupération de l'utilisateur de la précédente meilleure offre
                utilisateurPrecedenteEnchereMax.setCredit(utilisateurPrecedenteEnchereMax.getCredit() + ancienneEnchereMax.getMontant_enchere()); // recreditation des points de l'enchère
                DAOFact.getUtilisateursDAO().update(utilisateurPrecedenteEnchereMax); // mise à jour de l'utilisateur

            }
            catch (Exception e){

            }
            Enchere e  = DAOFact.getEncheresDAO().insert(nouvelleEnchere); // Insertion de la nouvelle enchère
            user =  DAOFact.getUtilisateursDAO().selectById(no_utilisateur);
            int newcredit = user.getCredit() -montant_enchere;
            user.setCredit(newcredit);
            DAOFact.getUtilisateursDAO().update(user);
            return  e;
        } catch (Exception e) {
            throw new BusinessException("BLL insererNouvelleEnchere");
        }
    }

    @Override
    public Enchere recupererEnchereParId(int no_enchere) throws BusinessException {
        try {
            return DAOFact.getEncheresDAO().selectById(no_enchere);
        } catch (DALException e) {
            throw new BusinessException("BLL recupererEnchereParId");
        }
    }

    @Override
    public List<Enchere> recupererToutesLesEncheres() throws BusinessException {
        try {
            return DAOFact.getEncheresDAO().selectAll();
        } catch (DALException e) {
            throw new BusinessException("BLL recupererToutesLesEncheres");
        }
    }

    @Override
    public Enchere mettreAJourUneEnchere(int no_enchere, Date date_enchere, int montant_enchere,
                                         int no_article, int no_utilisateur) throws BusinessException {
        Enchere majEnchere = new Enchere();
        majEnchere.setDate_enchere(date_enchere);
        majEnchere.setMontant_enchere(montant_enchere);
        majEnchere.setNo_article(no_article);
        majEnchere.setNo_utilisateur(no_utilisateur);
        majEnchere.setNo_enchere(no_enchere);
        try {
            DAOFact.getEncheresDAO().update(majEnchere);
        } catch (DALException e) {
            throw new BusinessException("BLL mettreAJourUneEnchere");
        }
        return majEnchere;
    }

    @Override
    public void supprimerUneEnchere(int no_enchere) throws BusinessException {
        try {
            DAOFact.getEncheresDAO().delete(no_enchere);
        } catch (Exception e) {
            throw new BusinessException("BLL supprimerUneEnchere");
        }
    }
}
