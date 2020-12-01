package model.users;

import model.game.Partida;

import java.util.ArrayList;
import java.util.List;

public class Arbiter extends User{
//Crear Llista de partides
    private long numArbitragedMatches;
    private List<Partida> arbitragedMatches;
    public  Arbiter(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        this.numArbitragedMatches = 0;
        arbitragedMatches = new ArrayList<>();
    }

    public void addArbitragedMatch(Partida match){
        arbitragedMatches.add(match);
        numArbitragedMatches++;
    }

    public long getNumArbitragedMatches(){
        return numArbitragedMatches;
    }

    public List<Partida> getArbitragedMatches() {
        return arbitragedMatches;
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
