package model.users;

public class Arbiter extends User{

    private long numArbitedGames;

    public  Arbiter(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        this.numArbitedGames = numArbitedGames;
    }

    @Override
    public String getType(){
        return "Arbitre";
    }
}
