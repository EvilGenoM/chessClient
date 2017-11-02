package mobi.mpk.chessandroid.domain.rules;


import java.util.List;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.type.Color;

public interface InspectorRules {

    void checkMoveRules(Board board, Stroke stroke, Color color) throws Exception;

    List<Figure> getOrderFigure(Color color);
    
}
