package Box;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        URLHandler urlHandler = new URLHandler();
        BlackBox BBox = new BlackBox(urlHandler);
        ValidateBlackBox VBlackBox = new ValidateBlackBox();


        BBox.check_ssl(urlHandler.getURL());
        BBox.URL(VBlackBox.validation_seeking(), urlHandler.getURL());
    }
}
