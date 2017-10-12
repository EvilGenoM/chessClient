package mobi.mpk.chessandroid.model.rules;


import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;
import mobi.mpk.chessServerSpring.domain.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chessServerSpring.domain.exception.rule.PossibleMoveException;
import mobi.mpk.chessServerSpring.domain.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chessServerSpring.domain.figure.Figure;
import mobi.mpk.chessServerSpring.domain.rules.rule.obstacle.move.*;
import mobi.mpk.chessServerSpring.domain.rules.rule.order.figure.ClassicOrderFigureRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.order.figure.OrderFigureRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.possiblemove.ClassicPossibleMoveRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.possiblemove.PossibleMoveRule;
import mobi.mpk.chessServerSpring.domain.rules.rule.stoke.figure.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassicInspectorRules implements InspectorRules {

    List<StrokeFigureRule> strokeFigureRules;
    List<ObstacleMoveRule> obstacleMoveRules;

    public ClassicInspectorRules() {

        strokeFigureRules = new ArrayList<>();

        strokeFigureRules.add(new StrokePawnRule());
        strokeFigureRules.add(new StrokeKingRule());
        strokeFigureRules.add(new StrokeQueenRule());
        strokeFigureRules.add(new StrokeBishopRule());
        strokeFigureRules.add(new StrokeKnightRule());
        strokeFigureRules.add(new StrokeRookRule());

        obstacleMoveRules = new ArrayList<>();

        obstacleMoveRules.add(new ObstacleMoveLineRule());
        obstacleMoveRules.add(new ObstacleMoveDiagonalRule());
        obstacleMoveRules.add(new ObstacleMovePawnRule());
        obstacleMoveRules.add(new ObstacleMoveKnightRule());

    }

    @Override
    public void checkMoveRules(Board board, Stroke stroke, Color colorPlayer) throws Exception {

        stroke.findFigure(board);

        PossibleMoveRule possibleMoveRule = new ClassicPossibleMoveRule();
        if (!possibleMoveRule.checkPossibleMove(colorPlayer, stroke)) {
            throw new PossibleMoveException();
        }

        boolean isCheckStrokeRule = false;

        for (StrokeFigureRule rule : strokeFigureRules) {

            if (rule.checkRule(stroke)) {
                isCheckStrokeRule = true;
            }

        }

        if (!isCheckStrokeRule) {
            throw new FigureCanNotMoveException();
        }

        boolean isCheckObstacles = false;

        for (ObstacleMoveRule rule : obstacleMoveRules) {

            if (rule.checkRule(stroke, board)) {
                isCheckObstacles = true;
            }

        }

        if (!isCheckObstacles) {
            throw new WayFigureHaveObstaclesException();
        }


    }

    @Override
    public List<Figure> getOrderFigure(Color color) {

        OrderFigureRule rule = new ClassicOrderFigureRule();
        return rule.orderFigure(color);

    }

}
