package mobi.mpk.chessandroid.settings;


import mobi.mpk.chessandroid.R;

public class CellTextureSettings {

    private int whiteCell;
    private int blackCell;

    public CellTextureSettings() {

        initCellsClassic();

    }

    public void initCellsClassic() {

        whiteCell = R.color.whiteCell;
        blackCell = R.color.blackCell;

    }

    public void initCellsBlue() {

        whiteCell = R.color.whiteCellBlue;
        blackCell = R.color.blackCellBlue;

    }


    public int getBlackCell() {
        return blackCell;
    }

    public int getWhiteCell() {
        return whiteCell;
    }
}
