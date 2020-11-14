package model.chesspieces;

import java.awt.*;

public class Rook extends ChessPiece{
    private static final String  RPATH = "Torre.gif";

    public Rook() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(RPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(RPATH)));
    }
}
