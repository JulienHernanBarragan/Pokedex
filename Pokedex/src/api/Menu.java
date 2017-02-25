package api;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pan, panNord, panCentre, panSud;
	JLabel title, signature;
	JButton addPokemon, deletePokemon, seePokedex, disconnect;
	
	public Menu(int user_ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 800);
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		pan.setLayout(new BorderLayout(0, 0));
		setContentPane(pan);
		
		// North panel
		panNord = new JPanel();
		pan.add(panNord, BorderLayout.NORTH);
		
		title = new JLabel("Pokedex");
		title.setFont(new Font("Trebuchet MS", Font.BOLD, 99));
		panNord.add(title);
		
		// Center panel
		panCentre = new JPanel();
		panCentre.setLayout(new GridLayout(2, 2, 20, 40));
		pan.add(panCentre, BorderLayout.CENTER);
		
		addPokemon = new JButton("Ajouter un pokémon à mon pokedex");
		addPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPokemon frame = new addPokemon(2);
				frame.setVisible(true);
				dispose();
			}
		});
		panCentre.add(addPokemon);
		
		deletePokemon = new JButton("Supprimer un pokémon de mon pokedex");
		panCentre.add(deletePokemon);
		
		seePokedex = new JButton("Voir mon pokedex");
		panCentre.add(seePokedex);
		
		disconnect = new JButton("Déconnexion");
		panCentre.add(disconnect);
		
		
		// South panel
		panSud = new JPanel();
		pan.add(panSud, BorderLayout.SOUTH);
		
		signature = new JLabel("Create by Hernandez Julien");
		signature.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panSud.add(signature);
	}
	
}
