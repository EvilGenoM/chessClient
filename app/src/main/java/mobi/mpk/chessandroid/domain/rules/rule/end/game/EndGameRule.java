package mobi.mpk.chessandroid.domain.rules.rule.end.game;


import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.type.Color;

public interface EndGameRule {

    boolean checkRule(Board board);

    Color getColorWinner();

}
