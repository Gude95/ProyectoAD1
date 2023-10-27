package model;

import org.mindrot.jbcrypt.BCrypt;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String passwordHash;
    private int age;
    private String email;

    public User(String name, String password, int age, String email) {
        this.name = name;
        setPassword(password);
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, passwordHash);
    }

    public void setPassword(String password) {
        this.passwordHash = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public int getAge() {
        return age;
    }


    public String getEmail() {
        return email;
    }

}
