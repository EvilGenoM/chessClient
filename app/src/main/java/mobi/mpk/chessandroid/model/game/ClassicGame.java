package mobi.mpk.chessandroid.model.game;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import mobi.mpk.chessandroid.model.Cell;
import mobi.mpk.chessandroid.model.Player;
import mobi.mpk.chessandroid.model.Stroke;
import mobi.mpk.chessandroid.model.User;
import mobi.mpk.chessandroid.model.exception.CellCorrectException;
import mobi.mpk.chessandroid.model.exception.FigureNotFindException;
import mobi.mpk.chessandroid.model.exception.StrokeCorrectException;
import mobi.mpk.chessandroid.model.exception.rule.FigureCanNotMoveException;
import mobi.mpk.chessandroid.model.exception.rule.PossibleMoveException;
import mobi.mpk.chessandroid.model.exception.rule.WayFigureHaveObstaclesException;
import mobi.mpk.chessandroid.model.figure.Figure;
import mobi.mpk.chessandroid.model.rules.ClassicInspectorRules;
import mobi.mpk.chessandroid.model.rules.InspectorRules;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.ResultType;

public class ClassicGame extends Game {

    private Color nowStroke = Color.white;

    private InspectorRules inspectorRules;

    public ClassicGame(User user1, User user2) {

        super(user1, user2);
        inspectorRules = new ClassicInspectorRules();
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
    public ResultType doStroke(User user, String strokeStr) {

        Player player = getPlayer(user);

        try {

            Stroke stroke = new Stroke(strokeStr);
            stroke.findFigure(getBoard());

            if (player.getColorFigures() == nowStroke) {

                boolean attack = false;
                Cell cell = getBoard().getCell(stroke.getTo());
                if(cell.getFigure() != null && cell.getFigure().getColor() != nowStroke){
                    attack = true;
                }

                player.move(stroke, getBoard(), inspectorRules);
                nextStroke();
                if (attack) {
                    return ResultType.ATTACK;
                }
                return ResultType.SUCCESS;

            } else {
                return ResultType.ERROR_NOT_YOU_MOVE;
            }

        } catch (CellCorrectException e) {
            return ResultType.ERROR_INCORECT_CELL;
        } catch (StrokeCorrectException e) {
            return ResultType.ERROR_INCORECT_MOVE;
        } catch (FigureNotFindException e) {
            return ResultType.ERROR_CELL_HAVE_NOT_FIGURE;
        } catch (FigureCanNotMoveException e) {
            return ResultType.ERROR_FIGURE_CAN_NOT_MOVE_THIS;
        } catch (PossibleMoveException e) {
            return ResultType.ERROR_CELL_HAVE_NOT_YOUR_FIGURE;
        } catch (WayFigureHaveObstaclesException e) {
            return ResultType.ERROR_OBSTACLES_WAY;
        } catch (Exception e) {
            return ResultType.ERROR;
        }

    }

    private Player getPlayer(User user) {

        User user1 = getPlayer1().getUser();
        String name = user1.getName();

        if(name.equals(user.getName())){

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
    public boolean checkExistFigure(char x, int y, Color color) {

        boolean checkFigure = false;

        Cell cell = getBoard().getCell(x, y);
        if(cell != null){
            Figure figure = cell.getFigure();
            if(figure != null && figure.getColor() == color){
                checkFigure = true;
            }
        }

        return checkFigure;
    }

    @Override
    public Map<String, Enum> getFigureData(char x, int y) {

        Figure figure = null;

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

    @Override
    public List<String> getListCoordinateCells(String coordinateCell) {

        char letter = coordinateCell.charAt(0);
        int number = coordinateCell.charAt(1);

        Cell cell = getBoard().getCell(letter, number);

        return null;

    }

}
