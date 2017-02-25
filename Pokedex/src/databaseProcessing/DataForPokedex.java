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
		ResultSet rset;
		try{
	    	Statement st = new ConnectDB().connexion.createStatement();
			String query="SELECT P.* FROM pokemon as P, user as U, havepokemon as H WHERE P.ID=H.ID_pokemon AND H.ID_user=U.ID AND U.ID="+ID_user; 
			rset=st.executeQuery(query);
	
			while(rset.next()) {
				String ligne = rset.getInt("ID")+","+rset.getString("name")+","+rset.getInt("HP")+","+rset.getString("elementary")+
							   ","+rset.getString("length")+","+rset.getString("weight")+","+rset.getString("weakness")+","+
							   rset.getString("attack")+","+rset.getInt("damage")+","+rset.getString("pathPicture");
				System.out.println(ligne);
				pokemon.add(ligne);
			}
			rset.close();
			
	    } catch(SQLException ex){
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null,"Not Found","Message d’avertissement",JOptionPane.ERROR_MESSAGE);			
		}	
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
			String query="SELECT P.ID, P.name, P.elementary FROM pokemon as P, user as U, havepokemon as H WHERE P.ID=H.ID_pokemon AND H.ID_user=U.ID AND U.ID="+ID_user;
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
	
	// Table containing pokemon for add to pokedex
		public DefaultTableModel tableAddPokemon(){
			
			DefaultTableModel dt = new DefaultTableModel();
			ResultSet rset;
			try{
				dt.addColumn("ID");
				dt.addColumn("Nom");
				dt.addColumn("Type");
		    	Statement st = new ConnectDB().connexion.createStatement();
				String query="SELECT ID, name, elementary FROM pokemon";
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
	
}
