package api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class Menu extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel pan, panNorth, panCenter, panSouth;
	private JLabel title, signature;
	private JButton addPokemon, deletePokemon, seePokedex, disconnect;
	
	public Menu(int user_ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Identification.class.getResource("/img/pokemonIcon.png")));
		setTitle("Pokedex : menu principal");
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		pan.setBackground(new Color(178, 34, 34));
		pan.setLayout(new BorderLayout(0, 0));
		setContentPane(pan);
		
		// North panel
		panNorth = new JPanel();
		panNorth.setBackground(new Color(178, 34, 34));
		pan.add(panNorth, BorderLayout.NORTH);
		
		title = new JLabel("");
		title.setIcon(new ImageIcon(Test.class.getResource("/img/PokemonTitle.png")));
		panNorth.add(title);
		
		// Center panel
		panCenter = new JPanel();
		panCenter.setBackground(new Color(178, 34, 34));
		panCenter.setLayout(new GridLayout(2, 2, 20, 40));
		pan.add(panCenter, BorderLayout.CENTER);
		
		addPokemon = new JButton("");
		addPokemon.setIcon(new ImageIcon(Menu.class.getResource("/img/buttonAdd.png")));
		addPokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addPokemon frame = new addPokemon(user_ID);
				frame.setVisible(true);
				dispose();
			}
		});
		panCenter.add(addPokemon);
		
		deletePokemon = new JButton("");
		deletePokemon.setIcon(new ImageIcon(Menu.class.getResource("/img/buttonDelete.png")));
		deletePokemon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				deletePokemon frame = new deletePokemon(user_ID);
				frame.setVisible(true);
				dispose();
			}
		});
		panCenter.add(deletePokemon);
		
		seePokedex = new JButton("");
		seePokedex.setIcon(new ImageIcon(Menu.class.getResource("/img/buttonPokedex.png")));
		seePokedex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seePokemonCard frame = new seePokemonCard(user_ID);
				frame.setVisible(true);
			}
		});
		panCenter.add(seePokedex);
		
		disconnect = new JButton("");
		disconnect.setIcon(new ImageIcon(Menu.class.getResource("/img/logout-sign.png")));
		disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Identification frame = new Identification();
				frame.setVisible(true);
				dispose();
			}
		});
		panCenter.add(disconnect);
		
		
		// South panel
		panSouth = new JPanel();
		panSouth.setBackground(new Color(178, 34, 34));
		pan.add(panSouth, BorderLayout.SOUTH);
		
		signature = new JLabel("Create by Hernandez Julien");
		signature.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		panSouth.add(signature);
	}
	
}
