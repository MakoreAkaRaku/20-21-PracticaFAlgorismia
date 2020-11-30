package model.game;


import model.users.Arbiter;
import model.users.Player;

/**
 * Classe que representa una partida del joc.
 * 
 * Aquesta classe conté els jugadors que estan jugant la partida i l'estat del
 * tauler en aquest instant de la partida.
 * 
 * @author Bernat Galmés Rubert
 */
public class Partida {
    private long id;
    private EstatTauler estatActual;
    private Player player1;
    private Player player2;
    private Arbiter arbiter;
    private EstatTauler state;
    private Player winner;

    /**
     * Defines a Match by inserting Match's id, player one, player two, the arbiter and the state of the ChessBoard.
     * Player one plays white chess pieces, while player 2 black chess pieces.
     * @param identifier
     * @param p1
     * @param p2
     * @param arb
     * @param et
     */
    public Partida(long identifier,Player p1, Player p2, Arbiter arb, EstatTauler et){
        this.id = identifier;
        player1 = p1;
        player2 = p2;
        arbiter = arb;
        state =  et;
        boolean p1HasKing = state.iswKingPieceAlive();
        boolean p2HasKing = state.isbKingPieceAlive();
        boolean matchNotFinished = p1HasKing &&  p2HasKing;

        if (matchNotFinished){
            winner = null;
            player2.addMatchNotFinished();
            player1.addMatchNotFinished();
        }else if (p1HasKing){
            winner = player1;
            player1.addMatchWon();
        }else{
            winner = player2;
            player2.addMatchWon();
        }
        player1.addMatchPlayed();
        player2.addMatchPlayed();
        arbiter.addArbitedMatch();
    }

    /**
     * Returns the Player that has won the match. Returns null in case nobody has finished the game yet.
     * @return
     */
    public Player getWinner(){
        return winner;
    }
}
