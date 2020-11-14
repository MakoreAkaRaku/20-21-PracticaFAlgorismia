package model.chesspieces;

import view.CellDrawable;
import java.awt.*;

public abstract class ChessPiece implements CellDrawable {
    public static class Resources{
        public static final String BLACKPATH = "resources/imatges/Fons_Negre/";
        public static final String WHITEPATH = "resources/imatges/Fons_Blanc/";
    }
    private Image white;
    private Image black;

    public ChessPiece(Image w, Image b){
        white = w;
        black = b;
    }

    @Override
    public Image FiguraFBlanc(){
        return white;
    }

    @Override
    public Image FiguraFNegre(){
        return black;
    }
}
