package mobi.mpk.chess.cli;

public class Request {

    private String name;
    private String text;

    public Request(){

    }

    public void setText(String text) {
        this.text = text;
    }

    public void setName(String name) {
        this.name = name;
    }
}
