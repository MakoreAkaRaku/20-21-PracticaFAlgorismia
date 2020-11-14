package model.chesspieces;
import java.awt.Toolkit;

public class Bishop extends ChessPiece{
    private static String BPATH = "Alfil.gif";
    public Bishop() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(BPATH)),Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(BPATH)));
    }
}
