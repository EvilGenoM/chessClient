package mobi.mpk.chessandroid.ui;

import javax.inject.Inject;

import mobi.mpk.chessandroid.ui.CellView;

/**
 * Created by evgen on 10.10.17.
 */

public class BoardView {

    private int AMOUNT_CELL = 8;

    private int top;
    private int left;
    private int lengthSide;

    private CellView[][] cellView;

    public BoardView(int lengthSide) {
        this(0, 0, lengthSide);
    }

    public BoardView(int top, int left, int lengthSide) {
        this.top = top;
        this.left = left;
        this.lengthSide = lengthSide;
        initBoard();
    }

    private void initBoard() {

        cellView = new CellView[AMOUNT_CELL][AMOUNT_CELL];

        int x = 0;
        int y = 0;
        int size = lengthSide/AMOUNT_CELL;

        for(int i = 0; i < AMOUNT_CELL; i++){

            for (int j = 0; j < AMOUNT_CELL; j++){
                cellView[i][j] = new CellView(x, y, size);
                x++;
            }

            x = 0;
            y++;

        }

    }

}
