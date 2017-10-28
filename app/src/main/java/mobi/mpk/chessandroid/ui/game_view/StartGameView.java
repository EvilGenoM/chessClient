package mobi.mpk.chessandroid.ui.game_view;


import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;
import mobi.mpk.chessandroid.iterator.Iterator;

public class StartGameView extends View {

    @Inject
    Drawer drawer;
    @Inject
    Iterator iterator;

    private Context context;
    private BoardView boardView;

    public StartGameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        App.getComponent().inject(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int lengthSide;

        if (getMeasuredHeight() > getMeasuredWidth()) {
            lengthSide = getMeasuredWidth();
        } else {
            lengthSide = getMeasuredHeight();
        }

        setMeasuredDimension(lengthSide, lengthSide);
        boardView = new BoardView(lengthSide);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        iterator.startRandomGame();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawer.setCanvas(canvas);
        boardView.onDrawBoard(false);
    }

}
