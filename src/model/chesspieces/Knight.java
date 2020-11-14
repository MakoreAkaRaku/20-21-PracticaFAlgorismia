package model.chesspieces;

import java.awt.*;

public class Knight extends ChessPiece{
    private static final String  KNPATH = "Cavall.gif";
    public Knight() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(KNPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(KNPATH)));
    }

}
