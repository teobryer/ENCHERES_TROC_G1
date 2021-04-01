package app.bll;



public class NoteManagerSingleton {

    private static NoteManager instance;

    public static INotesManager getInstance() {
        if (instance == null) {
            instance = new NoteManager();
        }
        return instance;
    }
}




