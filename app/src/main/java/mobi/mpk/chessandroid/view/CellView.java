package mobi.mpk.chessandroid.view;


import mobi.mpk.chessandroid.view.figure.FigureView;

/**
 * Created by evgen on 04.10.17.
 */

public class CellView {

    private int locationX;
    private int locationY;
    private int size;

    private int x;
    private int y;

    private Colors color;

    private FigureView figureView;

    public CellView(int x, int y, int locationX, int locationY, int size, FigureView figureView){

        this.locationX = locationX;
        this.locationY = locationY;
        this.size = size;

        this.x = x;
        this.y = y;

        initColor();

        this.figureView = figureView;

    }

    private void initColor() {

        if((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)){
            color = Colors.black;
        } else {
            color = Colors.white;
        }

    }

    public void onDraw(GameView gameView){

        gameView.onDrawCell(locationX, locationY, size, color);

        if(figureView != null) {
            figureView.onDraw(gameView, locationX, locationY, size);
        }

    }

    public int getLocationX() {
        return locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public FigureView getFigureView() {
        return figureView;
    }

    public void setFigureView(FigureView figureView) {
        this.figureView = figureView;
    }

    public boolean existPoint(int x, int y) {

        if(x>=this.x && x<=(this.x+size) && y>=this.y && y<=(this.y+size)){
            return true;
        } else {
            return false;
        }

    }
}
