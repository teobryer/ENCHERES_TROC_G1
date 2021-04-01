package app.bll;


import app.bo.Note;

import java.util.Date;
import java.util.List;

public interface INotesManager {

    Note insererNouvelleNote(String texte) throws BusinessException;

    Note recupererNoteParId(int id) throws BusinessException;

    List<Note> recupererToutesLesNotes() throws BusinessException;

    Note mettreAJourUneNote(int id, String nouveauText) throws  BusinessException;

    void supprimerUneNote(int id) throws  BusinessException;

}
