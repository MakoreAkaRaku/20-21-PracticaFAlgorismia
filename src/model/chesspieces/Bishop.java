package model.chesspieces;
import java.awt.Toolkit;

/**
 * This class represents the Bishop from the Chess Board Game.
 * It can be drawn by calling it's inherited methods from the ChessPiece class.
 */
public class Bishop extends ChessPiece{
    private static String BPATH = "Alfil.gif";
    public Bishop() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(BPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(BPATH)));
    }
}
