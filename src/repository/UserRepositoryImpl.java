package repository;

import model.users.User;

import java.util.List;

public class UserRepositoryImpl implements UsersRepository {
    private List<User> userList;
    public UserRepositoryImpl(List<User> users){
        this.userList = users;
    }

    @Override
    public User findOne(long id) throws NotFoundException {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public float[] meanAccessByClass() {
        return new float[0];
    }

    @Override
    public String findUserWithMaxAccess() {
        return null;
    }

    @Override
    public List<String> findUsersWithNoAccess() {
        return null;
    }

    @Override
    public String findUserWithMaxWins() {
        return null;
    }
}
