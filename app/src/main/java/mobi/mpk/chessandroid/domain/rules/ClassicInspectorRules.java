package mobi.mpk.chessandroid.domain.rules;


import java.util.ArrayList;
import java.util.List;

import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.domain.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chessandroid.domain.exception.rule.PossibleMoveException;
import mobi.mpk.chessandroid.domain.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chessandroid.domain.figure.Figure;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMoveDiagonalRule;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMoveKnightRule;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMoveLineRule;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMovePawnRule;
import mobi.mpk.chessandroid.domain.rules.rule.obstacle.move.ObstacleMoveRule;
import mobi.mpk.chessandroid.domain.rules.rule.order.figure.ClassicOrderFigureRule;
import mobi.mpk.chessandroid.domain.rules.rule.order.figure.OrderFigureRule;
import mobi.mpk.chessandroid.domain.rules.rule.possiblemove.ClassicPossibleMoveRule;
import mobi.mpk.chessandroid.domain.rules.rule.possiblemove.PossibleMoveRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeBishopRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeFigureRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeKingRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeKnightRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokePawnRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeQueenRule;
import mobi.mpk.chessandroid.domain.rules.rule.stoke.figure.StrokeRookRule;
import mobi.mpk.chessandroid.type.Color;

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
