package model.users;

public class Player extends User {

    private long numGamesPlayed;
    private long numGamesNotFinished;
    private long numGamesWon;

    /**
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param numAccess
     */
    public Player(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
        numGamesWon = 0;
        numGamesPlayed = 0;
        numGamesNotFinished = 0;
    }
    public void addMatchPlayed(){
        numGamesPlayed++;
    }
    public void addMatchNotFinished(){
        numGamesNotFinished++;
    }
    public void addMatchWon(){
        numGamesWon++;
    }

    public long getNumGamesPlayed() {
        return numGamesPlayed;
    }

    public long getNumGamesNotFinished() {
        return numGamesNotFinished;
    }

    public long getNumGamesWon() {
        return numGamesWon;
    }

    @Override
    public String getType(){
        return "Jugador";
    }
}
