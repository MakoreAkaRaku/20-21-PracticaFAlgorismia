package model.chesspieces;
import java.awt.Toolkit;

/**
 * This class represents the King from the Chess Board Game.
 * It can be drawn by calling it's inherited methods from the ChessPiece class.
 */
public class King extends ChessPiece{
    private static final String KPATH = "Rei.gif";
    public King() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(KPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(KPATH)));
    }

}
