package mobi.mpk.chessandroid.model.rules;

import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.figure.Figure;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InspectorRules {

    void checkMoveRules(Board board, Stroke stroke, Color colorPlayer) throws Exception;

    List<Figure> getOrderFigure(Color color);

}
