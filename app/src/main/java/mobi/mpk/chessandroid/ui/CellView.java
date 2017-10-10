package mobi.mpk.chessandroid.ui;

import javax.inject.Inject;

/**
 * Created by evgen on 10.10.17.
 */

public class CellView {

    private int x;
    private int y;
    private int size;

    @Inject
    private Drawer drawer;

    public CellView(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    private char identifyXtoCell(){
        int x = (this.x/size)-1;
        char letter = 'a';
        for(int i = 0; i < x; i++){
            letter++;
        }
        return letter;
    }

    private int identifyYtoCell(){
        return x/size;
    }



}