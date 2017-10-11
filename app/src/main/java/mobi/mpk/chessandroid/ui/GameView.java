package mobi.mpk.chessandroid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import javax.inject.Inject;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.controller.GameController;
import mobi.mpk.chessandroid.di.component.DaggerViewComponent;
import mobi.mpk.chessandroid.di.component.ViewComponent;
import mobi.mpk.chessandroid.di.module.BoardViewModule;
import mobi.mpk.chessandroid.di.module.GameControllerModule;
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
        this.context = context;
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
        component = buildComponent(canvas);
        BoardView boardView = new BoardView(lengthSide);
    }

    protected ViewComponent buildComponent(@NonNull Canvas canvas) {
        return DaggerViewComponent.builder()
                .viewModule(new ViewModule(context, canvas))
                .boardViewModule(new BoardViewModule(lengthSide))
                .gameControllerModule(new GameControllerModule())
                .build();
    }

    public static ViewComponent getComponent() {
        return component;
    }

}
