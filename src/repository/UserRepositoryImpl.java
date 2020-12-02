package repository;

import model.users.Player;
import model.users.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents which operations can you do with a User's List.
 */
public class UserRepositoryImpl implements UsersRepository {
    private List<User> userList;

    /**
     * Defines UserRepositoryImpl by giving a User's List.
     * @param users
     */
    public UserRepositoryImpl(List<User> users){
        this.userList = users;
    }


    @Override
    public User findOne(long id) throws NotFoundException {
        int listSize = userList.size();
        int index = 0;
        while(index < listSize && userList.get(index).getId() != id){
            index++;
        }
        if(index == listSize){
            return null;
        }
        return userList.get(index);
    }

    @Override
    public List<User> findAll() {
        return userList;
    }

    @Override
    public float[] meanAccessByClass() {
        float[] mean = new float[3]; //0 Arbiters mean, 1 Player mean, 2 User Mean.
        int[] numOfTypes = new int[3]; // 0 Arbiters count, 1 Player count, 2 User count.
        int listSize = userList.size();
        for (int i = 0; i < listSize; i++){
            switch (userList.get(i).getType()){
                case "Arbiter":
                    mean[0]+= userList.get(i).getNumAccess();
                    numOfTypes[0]++;
                    break;
                case "Player":
                    mean[1]+= userList.get(i).getNumAccess();
                    numOfTypes[1]++;
                    break;
                case "Member":
                    mean[2]+= userList.get(i).getNumAccess();
                    numOfTypes[2]++;
                    break;
                default:
                    return null;
            }
        }
        mean[0] /= numOfTypes[0];
        mean[1] /= numOfTypes[1];
        mean[2] /= numOfTypes[2];
        return mean;
    }

    @Override
    public String findUserWithMaxAccess() {
        int listSize = userList.size();
        User u = userList.get(0);
        for (int i = 1; i < listSize; i++){
            if (u.getNumAccess() < userList.get(i).getNumAccess()){
                u = userList.get(i);
            }
        }
        return u.getName() + " " +  u.getSurname();
    }


    @Override
    public List<String> findUsersWithNoAccess() {
        List<String> usersNames = new ArrayList<>();
        User u = null;
        int listSize = userList.size();
        for (int i = 0;i < listSize; i++){
            if (userList.get(i).getNumAccess() == 0){
                usersNames.add(userList.get(i).getName() + " " + userList.get(i).getSurname());
            }
        }
        return usersNames;
    }

    @Override
    public String findUserWithMaxWins() {
        Player pTemp;
        Player pwithMostMatchesWon  = new Player(-1,"","","",-1);
        int listSize = userList.size();
        for (int i = 0; i < listSize; i++){
            if (userList.get(i) instanceof Player){
                pTemp = (Player) userList.get(i);
                if (pwithMostMatchesWon.getNumWonMatches() < pTemp.getNumWonMatches()){
                    pwithMostMatchesWon = pTemp;
                }
            }
        }
        return pwithMostMatchesWon.getName() + " " + pwithMostMatchesWon.getSurname();
    }
}
