package mobi.mpk.chessandroid.view;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Canvas;

import java.util.LinkedList;
import java.util.List;

import mobi.mpk.chessandroid.view.figure.BishopView;
import mobi.mpk.chessandroid.view.figure.FigureView;
import mobi.mpk.chessandroid.view.figure.KingView;
import mobi.mpk.chessandroid.view.figure.KnightView;
import mobi.mpk.chessandroid.view.figure.PawnView;
import mobi.mpk.chessandroid.view.figure.QueenView;
import mobi.mpk.chessandroid.view.figure.RookView;

/**
 * Created by evgen on 04.10.17.
 */

public class BoardView {

    private CellView[][] cellViews;

    private List<FigureView> whiteFigureViewList;
    private List<FigureView> blackFigureViewList;

    private int left;
    private int top;

    private int right;
    private int bottom;


    private GameView gameView;

    public BoardView(int left, int top, int right, int bottom, GameView gameView){

        this.left = left;
        this.top = top;

        this.right = right;
        this.bottom = bottom;

        this.gameView = gameView;

        initWhiteFigureView();
        initBlackFigureView();

        int size = initSizeCell();
        initBoard(size);

    }

    private void initWhiteFigureView() {

        whiteFigureViewList = new LinkedList<>();

        whiteFigureViewList.add(new RookView(Colors.white));
        whiteFigureViewList.add(new KnightView(Colors.white));
        whiteFigureViewList.add(new BishopView(Colors.white));
        whiteFigureViewList.add(new QueenView(Colors.white));
        whiteFigureViewList.add(new KingView(Colors.white));
        whiteFigureViewList.add(new BishopView(Colors.white));
        whiteFigureViewList.add(new KnightView(Colors.white));
        whiteFigureViewList.add(new RookView(Colors.white));

        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));
        whiteFigureViewList.add(new PawnView(Colors.white));


    }

    private void initBlackFigureView() {

        blackFigureViewList = new LinkedList<>();

        blackFigureViewList.add(new RookView(Colors.black));
        blackFigureViewList.add(new KnightView(Colors.black));
        blackFigureViewList.add(new BishopView(Colors.black));
        blackFigureViewList.add(new QueenView(Colors.black));
        blackFigureViewList.add(new KingView(Colors.black));
        blackFigureViewList.add(new BishopView(Colors.black));
        blackFigureViewList.add(new KnightView(Colors.black));
        blackFigureViewList.add(new RookView(Colors.black));

        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));
        blackFigureViewList.add(new PawnView(Colors.black));

    }

    private void initBoard(int size) {

        cellViews = new CellView[8][8];
        int x = left;
        int y = top;

        FigureView figureView = null;

        for (int i = 0; i < 8; i++){

            for (int j = 0; j < 8; j++){

                if( i < 2) {
                    figureView = getFigureView(i, j+1, blackFigureViewList);
                }

                if( i > 5 ){
                    figureView = getFigureView(7-i, j+1, whiteFigureViewList);
                }

                cellViews[i][j] = new CellView(x, y, size, figureView);
                x += size;
                figureView = null;

            }

            x = left;
            y += size;

        }

    }

    private FigureView getFigureView(int i, int j, List<FigureView> figureViews){

        int k = j+(i*8);
        int sum = 0;
        for(FigureView figureView : figureViews){
            ++sum;
            if(k == sum){
                return figureView;
            }

        }

        return null;

    }

    private int initSizeCell() {

        if((right-left) < (bottom-top)){

            return (right-left)/8;

        } else {

            return (bottom-top)/8;

        }

    }


    public void onDraw(Canvas canvas, Context context) {

        for (int i = 0; i < 8; i++){

            for (int j = 0; j < 8; j++){

                cellViews[i][j].onDraw(canvas, context);

            }

        }

    }
}
