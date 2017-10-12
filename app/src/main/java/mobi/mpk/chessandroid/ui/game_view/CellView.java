package mobi.mpk.chessandroid.ui.game_view;

import java.util.Map;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

/**
 * Created by evgen on 10.10.17.
 */

public class CellView {

    private int x;
    private int y;
    private int size;

    private Color color;

    private FigureView figureView;

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
        onDraw();
    }

    private void identifyColor() {

        int x = (this.x / size) + 1;
        int y = (this.y / size) + 1;

        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 == 1 && y % 2 == 1)){
            color = Color.white;
        } else {
            color = Color.black;
        }

    }

    private void onDraw() {

        int color = 0;
        if (this.color == Color.white) {
            color = R.color.whiteCell;
        } else {
            color = R.color.blackCell;
        }

        drawer.drawRect(x, y, x + size, y + size, color);

        drawFigure();

    }

    private void drawFigure() {

        char x = identifyXtoCell();
        int y = identifyYtoCell();

        if (controller.checkExistFigure(x, y)) {

            Map<String, Enum> figureData = controller.getFigureData(x, y);
            FigureType figureType = (FigureType) figureData.get("figure");
            Color figureColor = (Color) figureData.get("color");

            figureView = new FigureView(x, y, size, figureType, figureColor);

        }

    }

    private char identifyXtoCell() {
        int x = (this.x / size) - 1;
        char letter = 'a';
        for (int i = 0; i < x; i++) {
            letter++;
        }
        return letter;
    }

    private int identifyYtoCell() {
        int y = 8 - (this.y/size);
        return y;
    }

}