package api;

import java.util.ArrayList;

import databaseProcessing.ConnectDB;
import databaseProcessing.DataForPokedex;

public class Main {

	public static void main(String[] args) {

		Pokemon test = new Pokemon("name",20,  "elementary",  "attack",  15, "String weight", 
 			  " String length", "String pathPic", "String weakness");
		
		System.out.println(test.getName());
		
		ArrayList pokemon = new databaseProcessing.DataForPokedex().pokemonUser(2);
		Menu frame = new Menu();
		frame.setVisible(true);
	}

}
