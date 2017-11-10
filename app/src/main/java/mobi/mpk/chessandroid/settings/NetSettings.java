package mobi.mpk.chessandroid.settings;


import java.util.Random;

public class NetSettings {

    private boolean connection;

    private String username;
    private String address;

    public NetSettings() {

        username = "" + new Random(1000);

    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

        if(!username.equals("Anonymous")) {
            this.username = username;
        }

    }
}
