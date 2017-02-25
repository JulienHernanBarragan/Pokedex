package databaseProcessing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConnectDB {

	public Connection connexion;
	String url;
		
	// Connexion base de données
	public ConnectDB()	{
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
	
	// Identification 
    public String connectAPI(String user, String password) {	
    	String acceptConnectingPokedex ="";
    	
	    try 
	    {
	    	Statement st = new ConnectDB().connexion.createStatement();
	    	ResultSet request = st.executeQuery("SELECT * FROM user WHERE pseudo='"+user+"' AND password='"+password+"'");
	    	if (request.next()){
	    		acceptConnectingPokedex = "accept;"+ request.getInt("ID");
	    		//request.getString("ID");
	    	} else {
	    		JOptionPane.showMessageDialog(null,"Données Incorrect !");
	    	}
	    		request.close();
	    }
	    catch (Exception e)
	    {
	    	System.out.println("Connexion Impossible");
	    e.printStackTrace();
	    }
	    return acceptConnectingPokedex;
    }
	
}
