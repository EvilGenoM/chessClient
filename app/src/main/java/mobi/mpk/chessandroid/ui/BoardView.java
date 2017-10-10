package mobi.mpk.chessandroid.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import dagger.*;

import mobi.mpk.chessandroid.component.ViewComponent;
import mobi.mpk.chessandroid.module.ViewModule;
import mobi.mpk.chessandroid.view.CellView;

/**
 * Created by evgen on 10.10.17.
 */

public class BoardView {

    private int top;
    private int left;
    private int lengthSide;

    private CellView[][] cellView;

    public BoardView(int lengthSide){
        this.top = 0;
        this.left = 0;
        this.lengthSide = lengthSide;
    }

    public BoardView(int top, int left, int lengthSide){
        this.top = top;
        this.left = left;
        this.lengthSide = lengthSide;
    }

}
