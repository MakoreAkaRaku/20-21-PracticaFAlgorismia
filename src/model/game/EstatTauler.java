package model.game;

import model.chesspieces.*;
import utils.PositionCode;
import view.ChessBoardPanel;

/**
 * Representació de l'estat d'un tauler d'escacs en un instant donat.
 * 
 * Aquesta classe conté la posició de les peces sobre un tauler d'escacs
 * en un moment donat.
 * 
 * @author Bernat Galmés Rubert
 */
public class EstatTauler extends ChessBoardPanel {
    private static final int BOARDSIZE = 8;
    private boolean wKingPieceAlive;
    private boolean bKingPieceAlive;

    public EstatTauler(String state){
        super(BOARDSIZE);
        wKingPieceAlive = false;
        bKingPieceAlive = false;
        defineBoardState(state);
    }

    /**
     * Defines the state of the loaded board from memory by reading string state and tokenizated.
     */
    public void defineBoardState(String st){
        PositionCode position;
        ChessPiece piece;
        int row = 0;
        int column = 0;
        String[] piecesDataCoded = st.split(" ");    //Getting an array of pieces data.
        for (String pieceDataCoded : piecesDataCoded){
            String[] pieceData = pieceDataCoded.split("-");
            position = new PositionCode(pieceData[0]);      //Getting the position of The piece.
            piece = getTypePiece(pieceData[1]);             //Getting piece Type.
            this.colocarPesa(position.getRow(),position.getColumn(),piece);
            if (piece instanceof King){                     //Look for King's chess piece.
                if (pieceData[2] == "0"){
                    wKingPieceAlive = true;
                }else{
                    bKingPieceAlive = true;
                }
            }
        }
    }


    public boolean isbKingPieceAlive() {
        return bKingPieceAlive;
    }

    public boolean iswKingPieceAlive() {
        return wKingPieceAlive;
    }

    /**
     * Returns the chess piece named on the string.
     * @param namePiece
     * @return
     */
    public ChessPiece getTypePiece(String namePiece){
        switch (namePiece){
            case "bishop":
                return new Bishop();
            case "kight":
                return new Knight();
            case "pawnn":
                return new Pawn();
            case "king":
                return new King();
            case "queen":
                return new Queen();
            case "rook":
                return new Rook();
            default:
                return null;
        }
    }
}
