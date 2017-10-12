package mobi.mpk.chessandroid.model;

import mobi.mpk.chessServerSpring.User;
import mobi.mpk.chessServerSpring.domain.*;
import mobi.mpk.chessServerSpring.domain.exception.CellCorrectException;
import mobi.mpk.chessServerSpring.domain.exception.FigureNotFindException;
import mobi.mpk.chessServerSpring.domain.exception.StrokeCorrectException;
import mobi.mpk.chessServerSpring.domain.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chessServerSpring.domain.exception.rule.PossibleMoveException;
import mobi.mpk.chessServerSpring.domain.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chessServerSpring.domain.figure.Figure;
import mobi.mpk.chessServerSpring.domain.rules.ClassicInspectorRules;
import mobi.mpk.chessServerSpring.domain.rules.InspectorRules;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class ClassicGame extends Game {

    private Color nowStroke = Color.white;

    @Autowired
    private InspectorRules inspectorRules;

    public ClassicGame(User user1, User user2) {

        super(user1, user2);
        initBoard();

    }

    @Override
    public void initBoard() {

        Cell[][] cells = getBoard().getMassiveCell();

        List<Figure> orderWhiteFigure = inspectorRules.getOrderFigure(Color.white);
        putWhiteFigures(cells, orderWhiteFigure);

        List<Figure> orderBlackFigure = inspectorRules.getOrderFigure(Color.black);
        putBlackFigures(cells, orderBlackFigure);

    }

    private void putWhiteFigures(Cell[][] cells, List<Figure> orderFigures) {

        int x = 0;
        int y = 0;

        for (Figure figure : orderFigures) {
            cells[x][y].setFigure(figure);
            x++;
            if (x == 8) {
                x = 0;
                y++;
            }
        }

    }

    private void putBlackFigures(Cell[][] cells, List<Figure> orderFigures) {

        int x = 0;
        int y = 7;

        for (Figure figure : orderFigures) {
            cells[x][y].setFigure(figure);
            x++;
            if (x == 8) {
                x = 0;
                y--;
            }
        }

    }

    @Override
    public ResultStroke doStroke(User user, String strokeStr) {

        Player player = getPlayer(user);

        try {

            Stroke stroke = new Stroke(strokeStr);
            stroke.findFigure(getBoard());

            if (player.getColorFigures() == nowStroke) {

                player.move(stroke, getBoard(), inspectorRules);
                nextStroke();
                return new ResultStroke("Success move", true);

            } else {
                return new ResultStroke("Now is not your move", false);
            }

        } catch (CellCorrectException e) {
            return new ResultStroke("An incorrect cell is entered", false);
        } catch (StrokeCorrectException e) {
            return new ResultStroke("Incorrect move entered", false);
        } catch (FigureNotFindException e) {
            return new ResultStroke("This cell does not have a shape", false);
        } catch (FigureCanNotMoveException e) {
            return new ResultStroke("The figure does not know how to walk like that", false);
        } catch (PossibleMoveException e) {
            return new ResultStroke("This cell does not have your shape", false);
        } catch (WayFigureHaveObstaclesException e) {
            return new ResultStroke("The movement of the figure is prevented by other figures", false);
        } catch (Exception e) {
            return new ResultStroke("Exception", false);
        }

    }

    private Player getPlayer(User user) {

        if(getPlayer1().getUser().equals(user)){

            return getPlayer1();

        } else {

            return getPlayer2();

        }

    }

    private void nextStroke() {

        if (nowStroke == Color.white) {
            nowStroke = Color.black;
        } else {
            nowStroke = Color.white;
        }

    }

    public List<Figure> getListFiguresOnBoard() {

        List<Figure> board = new LinkedList<Figure>();

        Cell[][] cells = getBoard().getMassiveCell();
        for (int y = 0; y < 8; y++) {

            for (int x = 0; x < 8; x++) {
                board.add(cells[x][y].getFigure());
            }

        }

        return board;
    }

}
