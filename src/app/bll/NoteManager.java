package app.bll;


import app.bo.Note;
import app.dal.DALException;
import app.dal.DAOFact;

import java.util.List;

public class NoteManager implements INotesManager {

    @Override
    public Note insererNouvelleNote(String texte) throws BusinessException {
        Note nouvelleNote = new Note();
        nouvelleNote.setTexteNote(texte);

        try {
            return DAOFact.getNotesDAO().insert(nouvelleNote);
        } catch (Exception e) {
            throw new BusinessException("BLL insererNouvelleNote");
        }
    }

    @Override
    public Note recupererNoteParId(int id) throws BusinessException {
        try {
            return DAOFact.getNotesDAO().selectById(id);
        } catch (DALException e) {
            throw new BusinessException("BLL recupererNoteParId");
        }
    }

    @Override
    public List<Note> recupererToutesLesNotes() throws BusinessException {
        try {
            return DAOFact.getNotesDAO().selectAll();
        } catch (DALException e) {
            throw new BusinessException("BLL recupererToutesLesNotes");
        }
    }

    @Override
    public Note mettreAJourUneNote(int id, String nouveauText) throws BusinessException {
        Note majNote = new Note();
        majNote.setTexteNote(nouveauText);
        majNote.setId(id);
        try {
            DAOFact.getNotesDAO().update(majNote);
        } catch (DALException e) {
            throw new BusinessException("BLL mettreAJourUneNote");
        }
        return majNote;
    }

    @Override
    public void supprimerUneNote(int id) throws BusinessException {
        try {
            DAOFact.getNotesDAO().delete(id);
        } catch (Exception e) {
            throw new BusinessException("BLL supprimerUneNote");
        }
    }
}
