package model;

public class App {
    private final String filename = "usuarios.bin";
    private Users users;
    private Session session;
    private FileHandler fileHandler;
    private ZIP zip;
    private XML xml;
    private JSON json;
    private PDF pdf;
    private CSV csv;


    public App() {
        this.fileHandler = new FileHandler(this.filename);
        this.users = fileHandler.leerUsuarios();
        this.session = new Session();
        this.xml = new XML();
        this.json = new JSON();
        this.zip= new ZIP();
        this.pdf = new PDF();
        this.csv = new CSV();
    }

    public String getFilename() {
        return filename;
    }

    public JSON getJson() {
        return json;
    }

    public PDF getPdf() {
        return pdf;
    }

    public CSV getCsv() {
        return csv;
    }

    public XML getXml() {
        return xml;
    }

    public ZIP getZIP() {
        return zip;
    }

    public Users getUsers() {
        return users;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public boolean login(String username, String password) {
        User user = users.getUser(username);
        if(user == null) {
            return false;
        }
        return user.checkPassword(password);
    }

    public Session getSession() {
        return session;
    }

    public void createUser(String username, String password, int age, String mail) {
        users.addUser(new User(username,password,age,mail));
        fileHandler.almacenarUsuarios(users);
        System.out.println("Usuario " + username + " creado correctamente.");
    }

    public void deleteUser(String username){
        User user = users.getUser(username);
        users.getUsers().remove(username);
        System.out.println(username + " ha sido borrado");
    }

    public void changePassword(String username,String newPassword){
        User user = users.getUser(username);
        user.setPassword(newPassword);
    }

}
