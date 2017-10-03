package mobi.mpk.chessandroid.domain;

/**
 * Created by evgen on 03.10.17.
 */

public class Board {

    private final int MAX_LENGTH_MASSIVE = 8;

    private Cell[][] cells;

    public Board(){
        cells = new Cell[MAX_LENGTH_MASSIVE][MAX_LENGTH_MASSIVE];
        createCells();
    }

    private void createCells(){

        for (int i = 0; i < 8; i++){

            for (int j = 0; j <8; j++){

                cells[i][j] = new Cell(j, i);

            }

        }

    }

    public Cell[][] getCells() {
        return cells;
    }

    public int lengthBoard(){
        return MAX_LENGTH_MASSIVE;
    }

}
