package databaseProcessing;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import databaseProcessing.ConnectDB;

public class DataForPokedex {
	
	// Arraylist that containt pokemon informations of the user
	public ArrayList<String> pokemonUser (int ID_user) {
		ArrayList<String> pokemon = new ArrayList<String>();
		pokemon.add("Page Accueil");
		ResultSet rset;
		try{
	    	Statement st = new ConnectDB().connexion.createStatement();
			String query="SELECT P.* FROM pokemon as P, user as U, havepokemon as H WHERE P.ID=H.ID_pokemon AND H.ID_user=U.ID AND U.ID="+ID_user+" GROUP BY P.ID"; 
			rset=st.executeQuery(query);
	
			while(rset.next()) {
				String ligne = rset.getInt("ID")+","+rset.getString("name")+","+rset.getInt("HP")+","+rset.getString("elementary")+
							   ","+rset.getString("length")+","+rset.getString("weight")+","+rset.getString("weakness")+","+
							   rset.getString("attack")+","+rset.getInt("damage")+","+rset.getString("pathPicture");
				pokemon.add(ligne);
			}
			rset.close();
			
	    } catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Message d’avertissement",JOptionPane.ERROR_MESSAGE);			
		}	
		pokemon.add("Fin");
		return pokemon;
	}
	
	// Table containing pokemon that the user have
	public DefaultTableModel tableDeletePokemon(int ID_user){
		
		DefaultTableModel dt = new DefaultTableModel();
		ResultSet rset;
		try{
			dt.addColumn("ID");
			dt.addColumn("Nom");
			dt.addColumn("Type");
	    	Statement st = new ConnectDB().connexion.createStatement();
			String query="SELECT P.ID, P.name, P.elementary FROM pokemon as P, user as U, havepokemon as H WHERE P.ID=H.ID_pokemon AND H.ID_user=U.ID AND U.ID="+ID_user+" GROUP BY P.ID";
			rset=st.executeQuery(query);

			while(rset.next()) {
				Object []tableau={rset.getInt("ID"),rset.getString("name"),rset.getString("elementary")};
				dt.addRow(tableau);
			}
			rset.close();
			
	    } catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Message d’avertissement",JOptionPane.ERROR_MESSAGE);			
		}	
		return dt;
	}
	
	// Table containing pokemon that the user haven't
	public DefaultTableModel tableAddPokemon(int user_ID){
			
		DefaultTableModel dt = new DefaultTableModel();
		ResultSet rset;
		try{
			dt.addColumn("ID");
			dt.addColumn("Nom");
			dt.addColumn("Type");
		   	Statement st = new ConnectDB().connexion.createStatement();
			String query="SELECT P.ID, P.name, P.elementary FROM pokemon as P WHERE P.ID NOT IN (SELECT P.ID FROM pokemon as P, user as U, havepokemon as H WHERE P.ID=H.ID_pokemon AND H.ID_user=U.ID AND H.ID_user="+user_ID+")";
			rset=st.executeQuery(query);

			while(rset.next()) {
				Object []tableau={rset.getInt("ID"),rset.getString("name"),rset.getString("elementary")};
				dt.addRow(tableau);
			}
			rset.close();
				
	    } catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Message d’avertissement",JOptionPane.ERROR_MESSAGE);			
		}	
		return dt;
	}
		
	// Add Pokemon
	public void addPokemon(int pokemonID, int userID) {
		
		try 
		{
		Statement st = new ConnectDB().connexion.createStatement();
		st.executeUpdate("INSERT INTO havepokemon(ID_pokemon, ID_user) VALUES("+pokemonID+", "+userID+")");  
		JOptionPane.showMessageDialog(null,"Pokémon Ajouté !"); 
		}
		catch (Exception e)
		{
		JOptionPane.showMessageDialog(null,"Erreur"); 
		e.printStackTrace();
		}
	}
	
	// Delete Pokemon
		public void deletePokemon(int pokemonID, int userID) {
			
			try 
			{
			Statement st = new ConnectDB().connexion.createStatement();
			st.executeUpdate("DELETE FROM `havepokemon` WHERE ID_pokemon="+pokemonID+" AND ID_user="+userID);  
			JOptionPane.showMessageDialog(null,"Pokémon Supprimé !"); 
			}
			catch (Exception e)
			{
			JOptionPane.showMessageDialog(null,"Erreur"); 
			e.printStackTrace();
			}
		}
	
}
