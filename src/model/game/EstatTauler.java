package model.game;

import model.chesspieces.*;
import utils.PositionCode;

/**
 * Representació de l'estat d'un tauler d'escacs en un instant donat.
 * 
 * Aquesta classe conté la posició de les peces sobre un tauler d'escacs
 * en un moment donat.
 * 
 * @author Bernat Galmés Rubert
 */
public class EstatTauler{
    private static final int BOARDSIZE = 8;
    private ChessPiece[][] boardPieces;
    private boolean whiteKingPieceAlive;
    private boolean blackKingPieceAlive;

    public EstatTauler(String state){
        boardPieces =  new ChessPiece[BOARDSIZE][BOARDSIZE];
        whiteKingPieceAlive = false;
        blackKingPieceAlive = false;
        defineBoardState(state);
    }

    /**
     * Defines the state of the loaded board from memory by reading string state and tokenizated.
     */
    private void defineBoardState(String st){
        PositionCode position;
        ChessPiece piece;
        int row = 0;
        int column = 0;
        String[] piecesDataCoded = st.split(" ");    //Getting an array of pieces data.
        for (String pieceDataCoded : piecesDataCoded){
            String[] pieceData = pieceDataCoded.split("-");
            position = new PositionCode(pieceData[0]);      //Getting the position of The piece.
            row = position.getRow() - 1;
            column = position.getColumn() - 1;
            piece = getPieceType(pieceData[1]);             //Getting piece Type.
            boardPieces[row][column] = piece;
            if (piece instanceof King){                     //Look for King's chess piece.
                if (pieceData[2].equals("0")){
                    whiteKingPieceAlive = true;
                }else{
                    blackKingPieceAlive = true;
                }
            }
        }
    }


    public boolean isBlackKingPieceAlive() {
        return blackKingPieceAlive;
    }

    public boolean isWhiteKingPieceAlive() {
        return whiteKingPieceAlive;
    }

    /**
     * Returns the chess piece named on the string.
     * @param pieceName
     * @return
     */
    private ChessPiece getPieceType(String pieceName){
        switch (pieceName){
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

    public ChessPiece[][] getBoardPieces() {
        return boardPieces;
    }
}
