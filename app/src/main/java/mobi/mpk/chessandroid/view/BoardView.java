package mobi.mpk.chessandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.content.ContextCompat;
import android.support.v4.hardware.display.DisplayManagerCompat;
import android.view.Display;
import android.view.WindowManager;

import java.util.LinkedList;
import java.util.List;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.domain.Board;
import mobi.mpk.chessandroid.domain.Cell;
import mobi.mpk.chessandroid.domain.Color;
import mobi.mpk.chessandroid.view.figure.BishopFigureView;
import mobi.mpk.chessandroid.view.figure.FigureView;
import mobi.mpk.chessandroid.view.figure.KingFigureView;
import mobi.mpk.chessandroid.view.figure.KnightFigureView;
import mobi.mpk.chessandroid.view.figure.PawnFigureView;
import mobi.mpk.chessandroid.view.figure.QueenFigureView;
import mobi.mpk.chessandroid.view.figure.RookFigureView;

/**
 * Created by evgen on 03.10.17.
 */

public class BoardView {

    private Board board;
    private List<FigureView> whiteFigureViews;
    private List<FigureView> blackFigureViews;
    private CellView[][] cellViews;
    private int size = 90;

    private Context context;
    private Paint paint;

    public BoardView(Context context, Board board){

        this.context = context;

        this.board = board;
        blackFigureViews = new LinkedList<>();
        whiteFigureViews = new LinkedList<>();

        initWhiteFigureViews();
        initBlackFigureViews();

        cellViews = new CellView[board.lengthBoard()][board.lengthBoard()];
        initCellViews(board.lengthBoard());

        this.paint = new Paint();
        initPaint();

    }

    private void initWhiteFigureViews() {

        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));
        whiteFigureViews.add(new PawnFigureView(Color.white));

        whiteFigureViews.add(new RookFigureView(Color.white));
        whiteFigureViews.add(new KnightFigureView(Color.white));
        whiteFigureViews.add(new BishopFigureView(Color.white));
        whiteFigureViews.add(new QueenFigureView(Color.white));
        whiteFigureViews.add(new KingFigureView(Color.white));
        whiteFigureViews.add(new BishopFigureView(Color.white));
        whiteFigureViews.add(new KnightFigureView(Color.white));
        whiteFigureViews.add(new RookFigureView(Color.white));

    }

    private void initBlackFigureViews() {

        blackFigureViews.add(new RookFigureView(Color.black));
        blackFigureViews.add(new KnightFigureView(Color.black));
        blackFigureViews.add(new BishopFigureView(Color.black));
        blackFigureViews.add(new QueenFigureView(Color.black));
        blackFigureViews.add(new KingFigureView(Color.black));
        blackFigureViews.add(new BishopFigureView(Color.black));
        blackFigureViews.add(new KnightFigureView(Color.black));
        blackFigureViews.add(new RookFigureView(Color.black));

        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));
        blackFigureViews.add(new PawnFigureView(Color.black));


    }

    private void initCellViews(int length){

        for(int i = 0; i < length; i++){

            for (int j = 0; j < length; j++){

                cellViews[i][j] = new CellView(i, j, size);

            }

        }

    }

    private void initPaint(){

        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

    }

    public void onDraw(Canvas canvas){

        Cell[][] cells = this.board.getCells();

        for (int i = 0; i < board.lengthBoard(); i++){

            for (int j = 0; j < board.lengthBoard(); j++){

                int color = countColor(cells[i][j].getColor());
                cellViews[i][j].onDraw(canvas, paint, color);

                if( j < 2) {
                    FigureView figureView = getFigureView(i+1, j, blackFigureViews);
                    figureView.onDraw(cellViews[i][j].getLeft(), cellViews[i][j].getTop(), canvas, context);
                }

                if( j > 5 ){
                    FigureView figureView = getFigureView(i+1, 7-j, whiteFigureViews);
                    figureView.onDraw(cellViews[i][j].getLeft(), cellViews[i][j].getTop(), canvas, context);
                }


            }

        }

    }

    public FigureView getFigureView(int i, int j, List<FigureView> figureViews){

        int k = i+(j*8);
        int sum = 0;
        for(FigureView figureView : figureViews){
            ++sum;
            if(k == sum){
                return figureView;
            }

        }

        return null;

    }

    private int countColor(Color color){

        if(color == Color.white){
            return ContextCompat.getColor(context, R.color.whiteCell);
        } else {
            return ContextCompat.getColor(context, R.color.blackCell);
        }

    }

}
