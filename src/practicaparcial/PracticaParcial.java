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
        Player p1;
        Player p2;
        Arbiter arb;
        EstatTauler et;
        long idMatch;
        List<Partida> partides = new ArrayList<>();
        List<DataLoader.GameData> gamesData = DataLoader.gamesLoader();
        for (DataLoader.GameData gameData : gamesData) {
            idMatch  = gameData.idPartida;
            p1 = (Player) users.findOne(gameData.jugador1);
            p2 = (Player) users.findOne(gameData.jugador2);
            arb = (Arbiter) users.findOne(gameData.arbitre);
            et = new EstatTauler(gameData.tauler);
            partides.add(new Partida(idMatch,p1,p2,arb,et));
            // TODO: Codi per emplenar la llista de partides
        }

        return partides;
    }

    private static UsersRepository loadUsers() throws Exception {
        String name, surnames, email;
        long id, nAccess;
        List<User> users = new ArrayList<>();
        List<DataLoader.UserData> usersData = DataLoader.usersLoader();
        for (DataLoader.UserData userData : usersData) {
            id = userData.id;
            name = userData.nom;
            surnames = userData.llinatges;
            email = userData.correuElectronic;
            nAccess = userData.numAccessos;
            switch (userData.tipus){
                case "0":
                    users.add(new Player(id, name, surnames, email, nAccess));
                    break;
                case "1":
                    users.add(new Member(id, name, surnames, email, nAccess));
                    break;
                case "2":
                    users.add(new Arbiter(id, name, surnames, email, nAccess));
                    break;
                default:
                    throw new Exception("Could not define user type");
            }

        }
        UsersRepository ur = new UserRepositoryImpl(users);
        // TODO: Construir i retornar l'objecte amb el repository
        return ur;
    }

    public static void main(String[] args) throws Exception {
        PracticaParcial m = new PracticaParcial();
        m.run();
    }

}
