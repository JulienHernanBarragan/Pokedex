package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseProcessing {

	public Connection connexion;
	String url;
		
	// Connexion base de données
	public DatabaseProcessing()	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			url = new String("jdbc:mysql://localhost:3306/pokedex"); // 
			connexion = (Connection) DriverManager.getConnection(url,"root","");
			System.out.println("Connexion réussie");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
}