package model;

import gui.Login;

public class Main {

	public static void main(String[] args) 	{
		User u1 = new User("Gude","abc123.",27,"gude.crujeiras.carlos.ald@gmail.com");
		Users.addUser(u1);
		FileHandler.almacenarUsuarios(Users.users);
		App app = new App();
		new Login(app);


	}

}
