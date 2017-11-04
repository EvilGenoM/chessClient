package mobi.mpk.chessandroid.ui.game.view;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;
import mobi.mpk.chessandroid.ui.setting.Settings;
import mobi.mpk.chessandroid.ui.game.drawer.Drawer;


public class FigureView {

    private int x;
    private int y;
    private int size;

    private Color color;

    private FigureType figureType;

    @Inject
    Drawer drawer;
    @Inject
    Settings settings;

    public FigureView(FigureType figureType, Color color, int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.figureType = figureType;
        this.color = color;
        App.getComponent().inject(this);
    }

    public void setLocation(int x, int y, int size){

        this.x = x;
        this.y = y;
        this.size = size;

    }


    public void onDraw() {

        drawer.drawImg(settings.getPiece(figureType, color), x, y, size);

    }

    public Color getColor() {
        return color;
    }

}
