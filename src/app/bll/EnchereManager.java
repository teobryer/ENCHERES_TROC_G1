package app.bll;



import app.bo.Enchere;
import app.dal.DALException;
import app.dal.DAOFact;

import java.util.Date;
import java.util.List;

public class EnchereManager implements IEncheresManager {

    @Override
    public Enchere insererNouvelleEnchere(Date date_enchere, int montant_enchere,
                                          int no_article, int no_utilisateur) throws BusinessException {
        Enchere nouvelleEnchere = new Enchere();
        nouvelleEnchere.setDate_enchere(date_enchere);
        nouvelleEnchere.setMontant_enchere(montant_enchere);
        nouvelleEnchere.setNo_article(no_article);
        nouvelleEnchere.setNo_utilisateur(no_utilisateur);

        try {
            return DAOFact.getEncheresDAO().insert(nouvelleEnchere);
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
