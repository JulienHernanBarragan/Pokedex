package api;

public class Main {

	public static void main(String[] args) {

		Pokemon test = new Pokemon("name",20,  "elementary",  "attack",  15, "String weight", 
 			  " String length", "String pathPic", "String weakness");
		
		System.out.println(test.getName());
		
		DatabaseProcessing connectDB = new DatabaseProcessing();
		Menu frame = new Menu();
		frame.setVisible(true);
	}

}
