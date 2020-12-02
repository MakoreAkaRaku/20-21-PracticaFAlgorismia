package model.chesspieces;
import java.awt.Toolkit;

/**
 * This class represents the Rook from the Chess Board Game.
 * It can be drawn by calling it's inherited methods from the ChessPiece class.
 */
public class Rook extends ChessPiece{
    private static final String  RPATH = "Torre.gif";

    public Rook() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(RPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(RPATH)));
    }
}
