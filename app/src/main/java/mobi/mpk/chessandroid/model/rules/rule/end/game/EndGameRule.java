package mobi.mpk.chessandroid.model.rules.rule.end.game;


import mobi.mpk.chessandroid.model.Board;
import mobi.mpk.chessandroid.type.Color;

public interface EndGameRule {

    boolean checkRule(Board board);

    Color getColorWinner();

}
