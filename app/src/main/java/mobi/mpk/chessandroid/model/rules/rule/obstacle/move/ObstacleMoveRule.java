package mobi.mpk.chessandroid.model.rules.rule.obstacle.move;


import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.model.Stroke;

public interface ObstacleMoveRule {

    boolean checkRule(Stroke stroke, Board board);

}
