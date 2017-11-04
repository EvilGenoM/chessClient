package mobi.mpk.chessandroid.settings;


import java.util.HashMap;
import java.util.Map;

import mobi.mpk.chessandroid.R;
import mobi.mpk.chessandroid.type.Color;
import mobi.mpk.chessandroid.type.FigureType;

public class PiecesTextureSettings {

    private Map<FigureType, Integer> piecesWhiteTexture;
    private Map<FigureType, Integer> piecesBlackTexture;

    public PiecesTextureSettings() {

        piecesWhiteTexture = new HashMap<>();
        piecesBlackTexture = new HashMap<>();

        initPiecesClassic();

    }

    public void initPiecesClassic() {

        piecesWhiteTexture.clear();
        piecesBlackTexture.clear();

        piecesWhiteTexture.put(FigureType.KING, R.drawable.white_king);
        piecesWhiteTexture.put(FigureType.QUEEN, R.drawable.white_queen);
        piecesWhiteTexture.put(FigureType.BISHOP, R.drawable.white_bishop);
        piecesWhiteTexture.put(FigureType.KNIGHT, R.drawable.white_knight);
        piecesWhiteTexture.put(FigureType.ROOK, R.drawable.white_rook);
        piecesWhiteTexture.put(FigureType.PAWN, R.drawable.white_pawn);

        piecesBlackTexture.put(FigureType.KING, R.drawable.black_king);
        piecesBlackTexture.put(FigureType.QUEEN, R.drawable.black_queen);
        piecesBlackTexture.put(FigureType.BISHOP, R.drawable.black_bishop);
        piecesBlackTexture.put(FigureType.KNIGHT, R.drawable.black_knight);
        piecesBlackTexture.put(FigureType.ROOK, R.drawable.black_rook);
        piecesBlackTexture.put(FigureType.PAWN, R.drawable.black_pawn);

    }

    public int getPiece(FigureType figureType, Color color) {

        int address;

        if (color == Color.white) {
            address = piecesWhiteTexture.get(figureType);
        } else {
            address = piecesBlackTexture.get(figureType);
        }

        return address;

    }

}
