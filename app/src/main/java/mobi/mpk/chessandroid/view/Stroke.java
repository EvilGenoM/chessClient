package mobi.mpk.chessandroid.view;

import mobi.mpk.chessandroid.view.figure.FigureView;

/**
 * Created by evgen on 06.10.17.
 */

public class Stroke {

    private CellView from;

    public void move(int x, int y, BoardView boardView){

        CellView cellView = boardView.getCellView(x, y);

        FigureView figureView = null;
        if(cellView != null){
            figureView = cellView.getFigureView();
        }


        if(figureView != null && from == null){

            from = cellView;

        } else if(figureView == null && from != null){

            cellView.setFigureView(from.getFigureView());
            from.setFigureView(null);

            from = null;

            boardView.onDraw();

        }

    }

}
