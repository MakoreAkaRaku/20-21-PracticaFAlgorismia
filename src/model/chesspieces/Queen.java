package model.chesspieces;

import java.awt.*;

public class Queen extends ChessPiece{
    private static final String  QPATH = "Reina.gif";
    public Queen() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(QPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(QPATH)));
    }
}
