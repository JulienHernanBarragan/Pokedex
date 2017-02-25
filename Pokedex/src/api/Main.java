package api;

import java.util.ArrayList;

import databaseProcessing.ConnectDB;
import databaseProcessing.DataForPokedex;

public class Main {

	public static void main(String[] args) {
		
		ArrayList pokemon = new databaseProcessing.DataForPokedex().pokemonUser(2);
		Menu frame = new Menu(2);
		frame.setVisible(true);
	
		
		for(int i = 0; i < pokemon.size(); i++) {
			String pokemona [] = ((String) pokemon.get(i)).split(",");
			System.out.println(pokemona[2]);
		}
		
		Pokemon test = new Pokemon("name",20,  "elementary",  "attack",  15, "String weight", 
	 			  " String length", "String pathPic", "String weakness");
			
			System.out.println(test.getName());
	}

}
