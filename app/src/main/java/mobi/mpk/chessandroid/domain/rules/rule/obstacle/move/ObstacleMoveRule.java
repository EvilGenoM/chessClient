package mobi.mpk.chessandroid.domain.rules.rule.obstacle.move;


import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Stroke;

public interface ObstacleMoveRule {

    boolean checkRule(Stroke stroke, Board board);

}
