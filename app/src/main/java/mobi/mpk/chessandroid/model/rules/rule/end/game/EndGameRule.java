package mobi.mpk.chessandroid.model.rules.rule.end.game;

import mobi.mpk.chessServerSpring.domain.Board;
import mobi.mpk.chessServerSpring.domain.Color;

public interface EndGameRule {

    boolean checkRule(Board board);

    Color getColorWinner();

}
