package app;

import app.bll.BusinessException;
import app.bll.NoteManagerSingleton;
import app.bo.Note;

import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

@Path("/notes")
public class GestionData {


    @GET
    public List<Note> getNotes() throws Exception {
        try {
            return NoteManagerSingleton.getInstance().recupererToutesLesNotes();
        } catch (BusinessException e) {
            throw new Exception("Erreur webservice getNotes");
        }
    }


    @GET
    @Path("/{id: \\d+}")
    public Note getNoteId(@PathParam("id") int id) throws Exception {
        try {
            return NoteManagerSingleton.getInstance().recupererNoteParId(id);
        } catch (BusinessException e) {
            throw new Exception("Erreur webservice getNoteId");
        }
    }


    @POST
    public void ajouterUneNote(@FormParam("noteTexte") String noteTexte) throws Exception {
        try {
            NoteManagerSingleton.getInstance().insererNouvelleNote(noteTexte);
        } catch (BusinessException e) {
            throw new Exception("Erreur webservice ajouterUneNote");
        }
    }

    @PUT
    public void modifierUneNote(@FormParam("noteTexte") String noteTexte, @FormParam("idNote") int idNote) throws Exception {
        try {
            NoteManagerSingleton.getInstance().mettreAJourUneNote(idNote, noteTexte);
        } catch (BusinessException e) {
            throw new Exception("Erreur webservice modifierUneNote");
        }
    }

    @DELETE
    public void supprimerUneNote(@FormParam("idNote") int idNote) throws Exception {
        try {
            NoteManagerSingleton.getInstance().supprimerUneNote(idNote);
        } catch (BusinessException e) {
            throw new Exception("Erreur webservice supprimerUneNote");
        }
    }
}
