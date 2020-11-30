package model.users;

public class Arbiter extends User{

    private long numArbitedGames;

    public  Arbiter(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        this.numArbitedGames = 0;
    }

    public void addArbitedMatch(){
        numArbitedGames++;
    }

    public long getNumArbitedGames(){
        return numArbitedGames;
    }
    @Override
    public String getType(){
        return "Arbitre";
    }
}
