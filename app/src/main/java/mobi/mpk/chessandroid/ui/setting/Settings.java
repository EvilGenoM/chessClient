package mobi.mpk.chessandroid.ui.setting;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;
import mobi.mpk.chessandroid.ui.game.drawer.Drawer;

public class Settings {

    @Inject
    Drawer drawer;

    private Map<FigureType, Integer> piecesWhiteTexture;
    private Map<FigureType, Integer> piecesBlackTexture;

    private int whiteCell;
    private int blackCell;

    private boolean dragAndDrop;
    private boolean coordinateBoard;
    private boolean volume;

    public Settings() {

        piecesWhiteTexture = new HashMap<>();
        piecesBlackTexture = new HashMap<>();

        dragAndDrop = true;
        coordinateBoard = true;

        volume = true;

        initCellsClassic();
        initPiecesClassic();

    }

    private void initCellsClassic() {

        whiteCell = R.color.whiteCell;
        blackCell = R.color.blackCell;

    }

    private void initCellsBlue() {

        whiteCell = R.color.whiteCellBlue;
        blackCell = R.color.blackCellBlue;

    }

    private void initPiecesClassic() {

        piecesWhiteTexture.clear();
        piecesBlackTexture.clear();

        piecesWhiteTexture.put(FigureType.KING, R.drawable.white_king);
        piecesWhiteTexture.put(FigureType.QUEEN, R.drawable.white_queen);
        piecesWhiteTexture.put(FigureType.BISHOP, R.drawable.white_bishop);
        piecesWhiteTexture.put(FigureType.KNIGHT, R.drawable.white_knight);
        piecesWhiteTexture.put(FigureType.ROOK, R.drawable.white_rook);
        piecesWhiteTexture.put(FigureType.PAWN, R.drawable.white_pawn);

        piecesBlackTexture.put(FigureType.KING, R.drawable.black_king);
        piecesBlackTexture.put(FigureType.QUEEN, R.drawable.black_queen);
        piecesBlackTexture.put(FigureType.BISHOP, R.drawable.black_bishop);
        piecesBlackTexture.put(FigureType.KNIGHT, R.drawable.black_knight);
        piecesBlackTexture.put(FigureType.ROOK, R.drawable.black_rook);
        piecesBlackTexture.put(FigureType.PAWN, R.drawable.black_pawn);

    }

    public int getPiece(FigureType figureType, Color color) {

        int address;

        if (color == Color.white) {
            address = piecesWhiteTexture.get(figureType);
        } else {
            address = piecesBlackTexture.get(figureType);
        }

        return address;

    }

    public int getWhiteCell() {
        return whiteCell;
    }

    public int getBlackCell() {
        return blackCell;
    }

    public void setClassicCell() {
        initCellsClassic();
    }

    public void setBlueCell() {
        initCellsBlue();
    }

    public void setClassicPieces() {
        initPiecesClassic();
    }

    public void setDragAndDrop(boolean dragAndDrop) {
        this.dragAndDrop = dragAndDrop;
    }

    public boolean getDragAndDrop() {
        return dragAndDrop;
    }

    public void setCoordinateBoard(boolean coordinateBoard) {
        this.coordinateBoard = coordinateBoard;
    }

    public boolean getCoordinateBoard() {
        return coordinateBoard;
    }

    public boolean getVolume() {
        return volume;
    }

    public void setVolume(boolean volume) {
        this.volume = volume;
    }

}
