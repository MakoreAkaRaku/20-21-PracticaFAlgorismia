package model.chesspieces;

import java.awt.*;

public class Pawn extends ChessPiece{
    private static final String  PPATH = "Gat.gif";

    public Pawn() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(PPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(PPATH)));
    }
}
