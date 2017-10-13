package mobi.mpk.chessandroid.model.rules;


import java.util.List;

import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public interface InspectorRules {

    void checkMoveRules(Board board, Stroke stroke, Color color) throws Exception;

    List<Figure> getOrderFigure(Color color);
    
}
