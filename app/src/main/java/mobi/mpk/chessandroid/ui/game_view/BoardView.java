package mobi.mpk.chessandroid.ui.game_view;


import java.util.List;

public class BoardView {

    private int AMOUNT_CELL = 8;

    private int top;
    private int left;
    private int lengthSide;

    private CellView[][] cellView;
    private List<String> listCoordinateCells;

    public BoardView(int lengthSide) {
        this(0, 0, lengthSide);
    }

    public BoardView(int left, int top, int lengthSide) {
        this.top = top;
        this.left = left;
        this.lengthSide = lengthSide;
        update();
    }

    private void initBoard() {

        cellView = new CellView[AMOUNT_CELL][AMOUNT_CELL];

        int x = 0;
        int y = 0;
        int size = lengthSide / 8;

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                cellView[i][j] = new CellView(x, y, size);
                x += size;
            }

            x = 0;
            y += size;

        }

    }

    public void onDrawBoard() {

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                cellView[i][j].onDrawCell();
            }

        }

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                cellView[i][j].onDrawFigure();
            }

        }

    }

    public String getCoordinateCell(int x, int y) {
        String coordinateCell = "";
        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                if (cellView[i][j].belongsCell(x, y)) {
                    coordinateCell = cellView[i][j].getCoordinateCell();
                }
            }

        }

        return coordinateCell;
    }

    public String highlightFigure(int x, int y) {
        String coordinateCell = "";
        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                if (cellView[i][j].belongsCell(x, y)) {
                    cellView[i][j].onDrawFigure(x, y);
                }
            }

        }

        return coordinateCell;
    }

    public void setListCoordinateCells(List<String> listCoordinateCells) {
        this.listCoordinateCells = listCoordinateCells;
    }

    public void update() {

        initBoard();

    }

    public void setHighLightCell(String coordinateCell) {

        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                String coordCell = cellView[i][j].getCoordinateCell();

                if(coordCell.equals(coordinateCell)){

                    cellView[i][j].setHeighLight();

                }

            }

        }

    }
}
