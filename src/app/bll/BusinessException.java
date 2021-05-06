package app.bll;

public class BusinessException extends Exception {


    public String title;
	public BusinessException(String title, String message) {
            super(message);
            this.title = title;
        }

    public BusinessException(String message) {
        super(message);
        this.title = "Erreur";
    }

}
