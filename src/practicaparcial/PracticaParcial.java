package practicaparcial;

import java.util.ArrayList;
import java.util.List;
import model.game.Partida;
import model.users.Arbiter;
import model.users.Player;
import model.users.User;
import repository.UserRepositoryImpl;
import repository.UsersRepository;
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
        List<Partida> partides = new ArrayList<>();
        List<DataLoader.GameData> gamesData = DataLoader.gamesLoader();
        for (DataLoader.GameData gameData : gamesData) {
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
            nAccess = userData.numAccessos;
            switch (userData.tipus){
                case "0":
                    users.add(new Arbiter(id, name, surnames, email, nAccess));
                    break;
                case "1":
                    users.add(new Arbiter(id, name, surnames, email, nAccess));
                    break;
                case "2":
                    users.add(new Arbiter(id, name, surnames, email, nAccess));
                    break;
                default:
                    throw new Exception("Could not define user type");
            }
        }
        UsersRepository ur = new UserRepositoryImpl(users);
        // TODO: Contruir i retornar l'objecte amb el repository
        return ur;
    }

    public static void main(String[] args) throws Exception {
        PracticaParcial m = new PracticaParcial();
        m.run();
    }

}
