package model.users;


/**
 * Classe que representa un usuari de l'aplicació.
 * 
 * @author Bernat Galmés Rubert
 */
public abstract class User{

    private long id;
    private String name;
    private String surname;
    private String email;
    private long numAccess;

    /**
     * Defines a User by assigning an id, name, surname, email and the number of access into the platform.
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param numAccess
     */
    public User(long id, String name, String surname, String email, long numAccess) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.numAccess = numAccess;
    }

    /**
     * Returns the User's characteristics into a String.
     * @return
     */
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

    /**
     * Returns which type of user is.
     * Returns Arbiter in case the user is an Arbiter.
     * Returns Member in case the user is a Member.
     * Returns Player in case the user is a Player.
     * @return
     */
    public abstract String getType();

    /**
     * Returns the Identifier of the User.
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the User Name.
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the User Surname.
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns the User Email.
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the number of Access the User has made into the platform.
     * @return
     */
    public long getNumAccess() {
        return numAccess;
    }
}
