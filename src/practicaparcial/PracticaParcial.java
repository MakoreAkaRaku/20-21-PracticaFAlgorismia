package practicaparcial;

import java.util.ArrayList;
import java.util.List;

import model.game.EstatTauler;
import model.game.Partida;
import model.users.*;
import repository.*;
import view.UsersWindow;

/**
 *
 * @author Bernat Galmés Rubert
 */
public class PracticaParcial {

    UsersRepository users;
    List<Partida> partides;

    public PracticaParcial() throws Exception {
        this.users = loadUsers();
        this.partides = loadGames();
    }

    public void run() {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UsersWindow(users).setVisible(true);
            }
        });
    }

    private List<Partida> loadGames() throws Exception {
        Partida match;
        Player p1;
        Player p2;
        Arbiter arb;
        EstatTauler et;
        long idMatch;
        boolean p1HasKing;
        boolean p2HasKing;
        boolean matchNotFinished;
        List<Partida> partides = new ArrayList<>();
        List<DataLoader.GameData> gamesData = DataLoader.gamesLoader();
        for (DataLoader.GameData gameData : gamesData) {
            idMatch  = gameData.idPartida;
            p1 = (Player) users.findOne(gameData.jugador1);
            p2 = (Player) users.findOne(gameData.jugador2);
            arb = (Arbiter) users.findOne(gameData.arbitre);
            et = new EstatTauler(gameData.tauler);
            p1HasKing = et.isWhiteKingPieceAlive();     //  Checking and filling info about which player has won.
            p2HasKing = et.isBlackKingPieceAlive();     //
            matchNotFinished = p1HasKing && p2HasKing;  //
            if (matchNotFinished){                      //  If the match has not finished, then increment the number of
                p1.addMatchNotFinished();               //  games not finished to it's respective players.
                p2.addMatchNotFinished();               //
            }else if(p1HasKing) {                       //  Else, look if one of the two players is the winner.
                p1.addMatchWon();                       //  In case it's player 1, increment the number of games he has
                p2.addMatchLost();                      //  won and for player 2, increment the number of games he has lost.
            }else if(p2HasKing) {                       //  Do the same thing but right now checking player 2 instead of
                    p2.addMatchWon();                   //  player 1.
                    p1.addMatchLost();                  //
            }else{                                      //  In case nobody has a King, everyone wins.
                    p2.addMatchWon();                   //
                    p1.addMatchWon();                   //
            }                                           //
            match = new Partida(idMatch,p1,p2,arb,et);  //  Creating the Match with it's respective data.
            p1.addMatchPlayed(match);                   //  Add the loaded Match to the Player's, Arbiter's and Loaded
            p2.addMatchPlayed(match);                   //  Matches List.
            arb.addArbitragedMatch(match);              //
            partides.add(match);                        //
        }
        return partides;                                //  And finally, return the List of Loaded Matches.
    }

    private static UsersRepository loadUsers() throws Exception {
        String name, surnames, email;
        long id, nAccess;
        List<User> users = new ArrayList<>();
        List<DataLoader.UserData> usersData = DataLoader.usersLoader();
        for (DataLoader.UserData userData : usersData) {    //Create a new user for every userData.
            id = userData.id;
            name = userData.nom;
            surnames = userData.llinatges;
            email = userData.correuElectronic;
            nAccess = userData.numAccessos;
            switch (userData.tipus){
                case "0":   //If string equals to 0, create a new Player and add it to User's List..
                    users.add(new Player(id, name, surnames, email, nAccess));
                    break;
                case "1":   //If string equals to 1, create a new Member and add it to User's List.
                    users.add(new Member(id, name, surnames, email, nAccess));
                    break;
                case "2":   //If string equals to 2, create a new Arbiter and add it to User's List.
                    users.add(new Arbiter(id, name, surnames, email, nAccess));
                    break;
                default:
                    throw new Exception("Could not define user type");
            }

        }
        UsersRepository ur = new UserRepositoryImpl(users); //Create a new UsersRepository
        return ur;
    }

    public static void main(String[] args) throws Exception {
        PracticaParcial m = new PracticaParcial();
        m.run();
    }

}
