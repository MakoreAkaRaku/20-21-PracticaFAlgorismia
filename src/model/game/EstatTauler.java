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

    /**
     * Defines the board state by having a bidimensional array of ChessPieces, which form
     * the Chess pieces position into the board and two booleans that it tells if there's a white or black king into the
     * board.
     * @param state
     */
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
        boolean isWhite = false;
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
            if (pieceData[2].equals("0")){
                isWhite = true;
            }else{
                isWhite = false;
            }
            piece = getPieceType(pieceData[1],isWhite);             //Getting piece Type.
            boardPieces[row][column] = piece;
            if (piece instanceof King){                     //Look for King's chess piece.
                if (isWhite){
                    whiteKingPieceAlive = true;
                }else{
                    blackKingPieceAlive = true;
                }
            }
        }
    }

    /**
     * Returns true if there's a black king alive.
     * If not, returns false.
     * @return
     */
    public boolean isBlackKingPieceAlive() {
        return blackKingPieceAlive;
    }

    /**
     * Returns true if there's a white king alive.
     * If not, returns false.
     * @return
     */
    public boolean isWhiteKingPieceAlive() {
        return whiteKingPieceAlive;
    }

    /**
     * Returns the chess piece type on the string.
     * In case Chess piece type could not be identified, returns null.
     * @param pieceType
     * @return
     */
    private ChessPiece getPieceType(String pieceType, boolean isWhite){
        switch (pieceType){
            case "bishop":
                return new Bishop(isWhite);
            case "kight":
                return new Knight(isWhite);
            case "pawnn":
                return new Pawn(isWhite);
            case "king":
                return new King(isWhite);
            case "queen":
                return new Queen(isWhite);
            case "rook":
                return new Rook(isWhite);
            default:
                return null;
        }
    }

    /**
     * Returns the bidimensional array of the loaded Chess Pieces into Table state, referring to the  position of the
     * pieces inside the Chess Board.
     * @return
     */
    public ChessPiece[][] getBoardPieces() {
        return boardPieces;
    }
}
