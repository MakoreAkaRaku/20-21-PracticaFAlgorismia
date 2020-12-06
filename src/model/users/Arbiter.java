package model.users;

import model.game.Partida;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an Arbiter that at the same time is a User from the platform.
 */
public class Arbiter extends User{

    private long numArbitragedMatches;
    private List<Partida> arbitragedMatches;

    /**
     * Defines an Arbiter as a User with the capability to Arbitrage
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param numAccess
     */
    public  Arbiter(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        this.numArbitragedMatches = 0;
        arbitragedMatches = new ArrayList<>();
    }

    /**
     * Increment in 1 the number of arbitraged Matches and adds the arbitraged Match to the List of Matches.
     * @param match
     */
    public void addArbitragedMatch(Partida match){
        arbitragedMatches.add(match);
        numArbitragedMatches++;
    }

    @Override
    public String getType(){
        return "Arbiter";
    }

    @Override
    public String toString() {
        String str;
        str = "Fullname: "+getName()+" "+getSurname()+"\nNumber of Access: "+getNumAccess()+
                "\nNumber of Arbitraged Matches: "+ numArbitragedMatches;
        return str;
    }
}
