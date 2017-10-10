package mobi.mpk.chessandroid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import mobi.mpk.chessandroid.di.component.DaggerViewComponent;
import mobi.mpk.chessandroid.di.component.ViewComponent;
import mobi.mpk.chessandroid.di.module.BoardViewModule;
import mobi.mpk.chessandroid.di.module.ViewModule;

/**
 * Created by evgen on 10.10.17.
 */

public class GameView extends View {

    private int lengthSide;

    private Context context;
    private static ViewComponent component;

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        lengthSide = widthMeasureSpec;
        setMeasuredDimension(lengthSide, lengthSide);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        component = buildComponent(canvas);
    }

    protected ViewComponent buildComponent(Canvas canvas) {
        return DaggerViewComponent.builder()
                .viewModule(new ViewModule(context, canvas))
                .boardViewModule(new BoardViewModule(lengthSide))
                .build();
    }

    public static ViewComponent getComponent() {
        return component;
    }
}
