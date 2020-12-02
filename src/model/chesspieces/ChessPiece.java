package model.chesspieces;
import view.CellDrawable;
import java.awt.Image;

/**
 * This abstract class represents any Chess Piece from the Chess Board Game.
 * It can be drawn by calling the inherited methods from the interface CellDrawable.
 */
public abstract class ChessPiece implements CellDrawable {
    /**
     * This static class represents the Resources needed to get any Image from any Chess Piece.
     */
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
