package app.bll;

public class BusinessException extends Exception {


    private String title;
	public BusinessException(String title, String message) {
            super(message);
            this.title = title;
        }

    public BusinessException(String message) {
        super(message);
        this.title = "Erreur";
    }

}
