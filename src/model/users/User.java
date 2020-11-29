package model.users;
/**
 * Classe que representa un usuari de l'aplicació.
 * 
 * @author Bernat Galmés Rubert
 */
public abstract class User {

    private long id;
    private String name;
    private String surname;
    private String email;
    private long numAccess;

    public User(long id, String name, String surname, String email, long numAccess) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.numAccess = numAccess;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", numAccess=" + numAccess +
                '}';
    }

    public abstract String getType();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public long getNumAccess() {
        return numAccess;
    }
}
