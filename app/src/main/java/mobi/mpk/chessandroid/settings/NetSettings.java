package mobi.mpk.chessandroid.settings;


public class NetSettings {

    private boolean connection;

    private String username;
    private String address;

    public NetSettings() {

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
        this.username = username;
    }
}
