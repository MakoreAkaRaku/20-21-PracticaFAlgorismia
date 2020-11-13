package model.users;

public class Player extends User {

    private long numGamesPlayed;
    private long numGamesNotFinished;
    private long numGamesWinned;

    public Player(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
    }
}
