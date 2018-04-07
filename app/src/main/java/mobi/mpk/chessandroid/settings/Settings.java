package mobi.mpk.chessandroid.settings;


import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class Settings {

    private PiecesTextureSettings piecesTextureSettings;
    private CellTextureSettings cellTextureSettings;

    private NetSettings netSettings;

    private boolean dragAndDrop;
    private boolean coordinateBoard;

    private SoundSettings soundSettings;

    public Settings() {

        piecesTextureSettings = new PiecesTextureSettings();
        cellTextureSettings = new CellTextureSettings();

        netSettings = new NetSettings();

        dragAndDrop = true;
        coordinateBoard = true;

        soundSettings = new SoundSettings();

    }

    public int getPiece(FigureType figureType, Color color) {

        return piecesTextureSettings.getPiece(figureType, color);

    }

    public int getWhiteCell() {
        return cellTextureSettings.getWhiteCell();
    }

    public int getBlackCell() {
        return cellTextureSettings.getBlackCell();
    }

    public void setClassicPieces() {
        piecesTextureSettings.initPiecesClassic();
    }

    public void setClassicCell() {
        cellTextureSettings.initCellsClassic();
    }

    public void setBlueCell() {
        cellTextureSettings.initCellsBlue();
    }

    public boolean getDragAndDrop() {
        return dragAndDrop;
    }

    public void setDragAndDrop(boolean dragAndDrop) {
        this.dragAndDrop = dragAndDrop;
    }

    public boolean getCoordinateBoard() {
        return coordinateBoard;
    }

    public void setCoordinateBoard(boolean coordinateBoard) {
        this.coordinateBoard = coordinateBoard;
    }

    public boolean getVolume() {
        return soundSettings.isVolume();
    }

    public void setVolume(boolean volume) {
        soundSettings.setVolume(volume);
    }

    public boolean getConnection() {
        return netSettings.isConnection();
    }

    public void setConnection(boolean connection) {
        this.netSettings.setConnection(connection);
    }

    public void setUsername(String username) {
        netSettings.setUsername(username);
    }

    public String getUsername() {
        return netSettings.getUsername();
    }


    public void setAddress(String address) {
        netSettings.setAddress(address);
    }

    public String getAddress() {
        return netSettings.getAddress();
    }

}
