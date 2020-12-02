package model.chesspieces;
import java.awt.Toolkit;

/**
 * This class represents the Queen from the Chess Board Game.
 * It can be drawn by calling it's inherited methods from the ChessPiece class.
 */
public class Queen extends ChessPiece{
    private static final String  QPATH = "Reina.gif";
    public Queen() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(QPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(QPATH)));
    }
}
