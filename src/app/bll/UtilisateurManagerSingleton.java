package app.bll;

public class UtilisateurManagerSingleton {
    private static UtilisateurManager instance;

    public static IUtilisateurManager getInstance() {
        if (instance == null) {
            instance = new UtilisateurManager();
        }
        return instance;
    }
}
