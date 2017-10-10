package mobi.mpk.chessandroid.ui;

import java.util.Map;

import javax.inject.Inject;

import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.controller.GameController;
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
    private Drawer drawer;
    @Inject
    private GameController controller;

    public CellView(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
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

        if(checkExistFigure()){

            Map<String, Enum> figureData = controller.getFigureData(x, y);
            FigureType figureType = (FigureType) figureData.get("figure");
            Color figureColor = (Color) figureData.get("color");

            figureView = new FigureView(x, y, size, figureType, figureColor);
        }

    }

    private boolean checkExistFigure() {

        char x = identifyXtoCell();
        int y = identifyYtoCell();

        return controller.checkExistFigure(x, y);
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
        return x / size;
    }

}