package mobi.mpk.chessandroid.model.rules.rule.possiblemove;

import mobi.mpk.chessServerSpring.domain.Color;
import mobi.mpk.chessServerSpring.domain.Stroke;

public interface PossibleMoveRule {

    boolean checkPossibleMove(Color color, Stroke stroke);

}
