package mobi.mpk.chessandroid.ui.game_view;


public class BoardView {

    private int AMOUNT_CELL = 8;

    private int top;
    private int left;
    private int lengthSide;

    private CellView[][] cellView;

    public BoardView(int lengthSide) {
        this(0, 0, lengthSide);
    }

    public BoardView(int left, int top, int lengthSide) {
        this.top = top;
        this.left = left;
        this.lengthSide = lengthSide;
    }

    public void onDrawBoard() {

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

    public String getCoordinateCell(int x, int y) {
        String coordinateCell = "";
        for (int i = 0; i < AMOUNT_CELL; i++) {

            for (int j = 0; j < AMOUNT_CELL; j++) {
                if (cellView[i][j].belongsCell(x, y)) {
                    coordinateCell = cellView[i][j].getCoordinateCell(x, y);
                }
            }

        }

        return coordinateCell;
    }
}
