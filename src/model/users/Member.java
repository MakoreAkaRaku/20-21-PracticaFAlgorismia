package model.users;

/**
 * This class represents a Member that at the same time is a User from the platform.
 */
public class Member extends User {
    /**
     * Defines Member as a User that has the capability to have access the platform.
     * @param id
     * @param name
     * @param surname
     * @param email
     * @param numAccess
     */
    public Member(long id, String name, String surname, String email, long numAccess) {
        super(id, name, surname, email, numAccess);
    }

    @Override
    public String getType(){
        return "Member";
    }
}
