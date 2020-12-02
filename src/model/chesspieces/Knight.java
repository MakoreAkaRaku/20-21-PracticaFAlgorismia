package model.chesspieces;
import java.awt.Toolkit;

/**
 * This class represents the Knight from the Chess Board Game.
 * It can be drawn by calling it's inherited methods from the ChessPiece class.
 */
public class Knight extends ChessPiece{
    private static final String  KNPATH = "Cavall.png";
    public Knight() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(KNPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(KNPATH)));
    }

}
