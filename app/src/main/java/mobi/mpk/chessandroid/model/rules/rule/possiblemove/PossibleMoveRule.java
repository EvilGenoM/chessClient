package mobi.mpk.chessandroid.model.rules.rule.possiblemove;


import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.type.Color;

public interface PossibleMoveRule {

    boolean checkPossibleMove(Color color, Stroke stroke);

}