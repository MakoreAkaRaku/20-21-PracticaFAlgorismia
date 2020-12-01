package model.users;

import model.game.Partida;

import java.util.ArrayList;
import java.util.List;

public class Player extends User {

    private long numMatchesPlayed;
    private long numMatchesNotFinished;
    private long numMatchesWon;
    private long numMatchesLost;
    private List<Partida> matchesPlayed;
    /**
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param numAccess
     */
    public Player(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        numMatchesPlayed = 0;
        numMatchesNotFinished = 0;
        numMatchesLost = 0;
        numMatchesWon = 0;
        matchesPlayed = new ArrayList<>();
    }

    public void addMatchNotFinished() {
        numMatchesNotFinished++;
    }

    public void addMatchWon() {
        numMatchesWon++;
    }

    public void addMatchLost() {
        numMatchesLost++;
    }

    public void addMatchPlayed(Partida matchPlayed) {
        matchesPlayed.add(matchPlayed);
        numMatchesPlayed++;
    }

    public long getNumMatchesPlayed() {
        return numMatchesPlayed;
    }

    public long getNumMatchesNotFinished() {
        return numMatchesNotFinished;
    }

    public long getNumMatchesWon() {
        return numMatchesWon;
    }

    public long getNumMatchesLost() {
        return numMatchesLost;
    }

    public List<Partida> getMatchesPlayed() {
        return matchesPlayed;
    }

    @Override
    public String getType(){
        return "Player";
    }

    @Override
    public String toString() {
        String str;
        str = "Nom Complet: "+getName()+" "+getSurname()+"\nNombre de Accesos a la plataforma: "+getNumAccess()+
                "\nNombre de partides jugades: "+numMatchesPlayed+"\nNombre de partides guanyades: "+numMatchesWon+
                "\nNombre de partides no finalitzades: "+ numMatchesNotFinished;
        return str;
    }
}
