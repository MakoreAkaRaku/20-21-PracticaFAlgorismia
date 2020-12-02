package model.users;

import model.game.Partida;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a Player that at the same time is a User from the platform.
 */
public class Player extends User {

    private long numPlayedMatches;
    private long numNotFinishedMatches;
    private long numWonMatches;
    private long numMatchesLost;
    private List<Partida> playedMatches;
    /**
     * Defines a Player as a User with capabilities of playing matches, where he can win, loose or not finish the match.
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param numAccess
     */
    public Player(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        numPlayedMatches = 0;
        numNotFinishedMatches = 0;
        numMatchesLost = 0;
        numWonMatches = 0;
        playedMatches = new ArrayList<>();
    }

    /**
     * Increment in 1 the counter of Matches not Finished of the Player.
     */
    public void addMatchNotFinished() {
        numNotFinishedMatches++;
    }

    /**
     * Increment in 1 the counter of Matches Won of the Player.
     */
    public void addMatchWon() {
        numWonMatches++;
    }

    /**
     * Increment in 1 the counter of Matches Lost of the Player.
     */
    public void addMatchLost() {
        numMatchesLost++;
    }

    /**
     * Increment in 1 the counter of Matches Played of the Player and Adds the Match to the Match List.
     */
    public void addMatchPlayed(Partida matchPlayed) {
        playedMatches.add(matchPlayed);
        numPlayedMatches++;
    }

    /**
     * Returns the number of Played Matches.
     * @return
     */
    public long getNumPlayedMatches() {
        return numPlayedMatches;
    }

    /**
     * Returns the number of Not Finished Matches.
     * @return
     */
    public long getNumNotFinishedMatches() {
        return numNotFinishedMatches;
    }

    /**
     * Returns the number of Won Matches.
     * @return
     */
    public long getNumWonMatches() {
        return numWonMatches;
    }

    /**
     * Returns the number of Lost Matches
     * @return
     */
    public long getNumLostMatches() {
        return numMatchesLost;
    }

    /**
     * Returns a Match List where the Player has played.
     * @return
     */
    public List<Partida> getPlayedMatches() {
        return playedMatches;
    }

    @Override
    public String getType(){
        return "Player";
    }

    /**
     * Returns the Player characteristic into a String, containing it's full name, numAccess,NumPlayedMatches,
     * NumLostMatches,NumWonMatches and NumNotFinishedMatches.
     * @return
     */
    @Override
    public String toString() {
        String str;
        str = "Nom Complet: "+getName()+" "+getSurname()+"\nNombre de Accesos a la plataforma: "+getNumAccess()+
                "\nNombre de partides jugades: "+numPlayedMatches+"\nNombre de partides guanyades: "+numWonMatches+
                "\nNombre de partides no finalitzades: "+numNotFinishedMatches+"\nNombre de partides perdudes: "+
                numMatchesLost;
        return str;
    }
}
