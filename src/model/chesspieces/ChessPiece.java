package model.chesspieces;
import view.CellDrawable;
import java.awt.Image;

/**
 * This abstract class represents any Chess Piece from the Chess Board Game.
 * It can be drawn by calling the inherited methods from the interface CellDrawable.
 */
public abstract class   ChessPiece implements CellDrawable {
    /**
     * This static class represents the Resources needed to get any Image from any Chess Piece.
     */
    public static class Resources{
        public static final String BLACKPATH = "resources/imatges/Peces_Negres/";
        public static final String WHITEPATH = "resources/imatges/Peces_Blanques/";
    }
    private Image pieceImage;

    public ChessPiece(Image w,Image b, boolean isWhite){
        if (isWhite){
            pieceImage = w;
        }else{
            pieceImage = b;
        }
    }

    @Override
    public Image getPieceImage() {
        return pieceImage;
    }
}
