package model;

public class Session {
    private User user;

    public Session() {
        this.user = null;
    }

    public void login(String user, String pass) {
        //this.user = new User("admin","admin", 60, "admin@admin.local");
    }

    public boolean isSignIn() {
        return user != null;
    }
}
