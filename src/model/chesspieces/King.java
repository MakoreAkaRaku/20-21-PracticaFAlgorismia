package model.chesspieces;


import java.awt.*;

public class King extends ChessPiece{
    private static final String KPATH = "Rei.gif";
    public King() {
        super(Toolkit.getDefaultToolkit().createImage(Resources.WHITEPATH.concat(KPATH)),
                Toolkit.getDefaultToolkit().createImage(Resources.BLACKPATH.concat(KPATH)));
    }

}
