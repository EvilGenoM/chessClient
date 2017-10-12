package mobi.mpk.chessandroid.model.game;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Player;
import mobi.mpk.chessandroid.model.ResultStroke;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.exception.FigureNotFindException;
import mobi.mpk.chessandroid.model.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.model.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chessandroid.model.exception.rule.PossibleMoveException;
import mobi.mpk.chessandroid.model.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.rules.InspectorRules;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class ClassicGame extends Game {

    private Color nowStroke = Color.white;

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

    @Override
    public boolean checkExistFigure(char x, int y) {

        boolean checkFigure = false;

        Cell cell = getBoard().getCell(x, y);
        if(cell != null){
            checkFigure = cell.existFigure();
        }

        return checkFigure;
    }

    @Override
    public Map<String, Enum> getFigureData(char x, int y) {

        Figure figure = null;
        FigureType figureType;
        Color color;

        Map<String, Enum> figureData = new HashMap<>();

        Cell cell = getBoard().getCell(x, y);
        if(cell != null){
            figure = cell.getFigure();
        }

        if(figure != null){
            figureData.put("FigureType", figure.getFigureType());
            figureData.put("Color", figure.getColor());
        }

        return figureData;
    }

}
