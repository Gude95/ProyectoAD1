package model;

public class Session {
    private User user;

    public Session() {
        this.user = null;
    }

    public void login(String user, String pass) {
      Users map = new Users();
        for (User usuario : map.getUsers().values()
             ) {
            if(user.equals(usuario.getName()) && pass.equals(usuario.getPasswordHash())){
                System.out.println("datos correctos");
                this.user=usuario;
            }
        }
    }

    public boolean isSignIn() {
        return user != null;
    }
}
