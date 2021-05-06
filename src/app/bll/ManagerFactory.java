package app.bll;

public class ManagerFactory {

    public static IUtilisateurManager utilisateurManager() {
        return new UtilisateurManager();
    }
}
