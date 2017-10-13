package mobi.mpk.chessandroid.model.figure;

import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public abstract class Figure {

    private Color color;
    private FigureType figureType;

    public Figure() {
        this(Color.white);
    }

    public Figure(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    protected void setFigureType(FigureType figureType) {
        this.figureType = figureType;
    }

    public FigureType getFigureType() {
        return figureType;
    }

    @Override
    public boolean equals(Object o) {

        if (this == null || o == null) {
            return false;
        }

        if (this.getClass().getSimpleName().equals(o.getClass().getSimpleName())) {

            return true;

        } else {
            return false;
        }

    }

}
