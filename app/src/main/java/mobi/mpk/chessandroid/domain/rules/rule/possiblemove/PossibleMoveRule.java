package mobi.mpk.chessandroid.domain.rules.rule.possiblemove;


import mobi.mpk.chessandroid.domain.Stroke;
import mobi.mpk.chessandroid.type.Color;

public interface PossibleMoveRule {

    boolean checkPossibleMove(Color color, Stroke stroke);

}