package model.chesspieces;
import java.awt.Toolkit;

/**
 * This class represents the Pawn from the Chess Board Game.
 * It can be drawn by calling it's inherited methods from the ChessPiece class.
 */
public class Pawn extends ChessPiece{
    private static final String  PPATH = "Gat.png";

    public Pawn() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(PPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(PPATH)));
    }
}
