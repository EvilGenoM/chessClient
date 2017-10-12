package mobi.mpk.chessandroid.ui.game_view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.App;

public class GameView extends View {

    private int lengthSide;

    @Inject
    Drawer drawer;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        App.getComponent().inject(this);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        lengthSide = getMeasuredWidth();
        setMeasuredDimension(lengthSide, lengthSide);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawer.setCanvas(canvas);
        BoardView boardView = new BoardView(lengthSide);
    }

}
