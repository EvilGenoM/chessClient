package mobi.mpk.chessandroid.ui.game_view;

import java.util.Map;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;


public class CellView {

    private int x;
    private int y;
    private int size;

    private Color color;

    private FigureView figureView;
    private boolean isHeighLight = false;

    @Inject
    Drawer drawer;
    @Inject
    GameController controller;

    public CellView(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        App.getComponent().inject(this);
        identifyColor();
        findFigure();
    }

    private void identifyColor() {

        int x = (this.x / size) + 1;
        int y = (this.y / size) + 1;

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)) {
            color = Color.white;
        } else {
            color = Color.black;
        }

    }

    public void onDrawCell() {

        int color = 0;
        if (this.color == Color.white) {
            color = R.color.whiteCell;
        } else {
            color = R.color.blackCell;
        }

        if(isHeighLight){
            color = R.color.yellowCell;
        }

        drawer.drawRect(x, y, x + size, y + size, color);

        if(figureView != null){
            figureView.onDraw();
        }

    }

    private void findFigure() {

        char x = identifyXtoCell();
        int y = identifyYtoCell();

        if (controller.checkExistFigure(x, y)) {

            Map<String, Enum> figureData = controller.getFigureData(x, y);
            FigureType figureType = (FigureType) figureData.get("FigureType");
            Color figureColor = (Color) figureData.get("Color");

            figureView = new FigureView(this.x, this.y, size, figureType, figureColor);

        }

    }

    private char identifyXtoCell() {
        int x = (this.x / size);
        char letter = 'a';
        for (int i = 0; i < x; i++) {
            letter++;
        }
        return letter;
    }

    private int identifyYtoCell() {
        int y = 8 - (this.y / size);
        return y;
    }

    public boolean belongsCell(int x, int y) {

        if (this.y < y && (this.y + size) > y && this.x < x && (this.x + size) > x) {
            return true;
        } else {
            return false;
        }

    }

    public String getCoordinateCell() {

        String coordinateCell = "" + identifyXtoCell();
        coordinateCell += identifyYtoCell();

        return coordinateCell;

    }

    public void setHeighLight() {

        this.isHeighLight = true;

    }
}