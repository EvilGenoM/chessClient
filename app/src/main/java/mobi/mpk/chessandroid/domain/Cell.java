package mobi.mpk.chessandroid.domain;

/**
 * Created by evgen on 03.10.17.
 */

public class Cell {

    private int x;
    private int y;
    private Color color;

    public Cell(int x, int y){

        this.x = x;
        this.y = y;
        countColor(x, y);

    }

    private void countColor(int x, int y){

        if(y % 2 == 0){

            if(x % 2 == 0){
                this.color = Color.black;
            } else {
                this.color = Color.white;
            }

        } else {

            if(x % 2 == 0){
                this.color = Color.white;
            } else {
                this.color = Color.black;
            }

        }

    }

    public Color getColor() {
        return color;
    }
}
