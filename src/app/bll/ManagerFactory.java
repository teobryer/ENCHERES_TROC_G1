package app.bll;

public class ManagerFactory {

    public static IUtilisateurManager utilisateurManager() {
        return new UtilisateurManager();
    }

    public static IArticles_VendusManager articlesVendusManager() {
        return new Articles_VendusManager();
    }

    public static ICategoriesManager categoriesManager(){return new CategoriesManager();}
}
