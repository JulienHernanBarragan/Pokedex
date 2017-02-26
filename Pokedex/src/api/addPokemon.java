package api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import databaseProcessing.DataForPokedex;

public class addPokemon extends JFrame {
	
	private JPanel pan, panNorth, panCenter, panSouth;
	private JLabel rechercher;
	private JTextField TFrechercher;
	private JTable pokemon;
	private JButton add, returnMenu, validrecherche;
	private int pokemonSelectedID;
	
	public addPokemon(int user_ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Identification.class.getResource("/img/pokemonIcon.png")));
		setTitle("Pokedex : ajouter un pokémon à votre pokedex");
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		pan.setBackground(new Color(178, 34, 34));
		setContentPane(pan);
		pan.setLayout(new BorderLayout(0, 0));
		
		// North panel
		panNorth = new JPanel();
		pan.add(panNorth, BorderLayout.NORTH);
		
		rechercher = new JLabel("Rechercher :");
		panNorth.add(rechercher);
		
		TFrechercher = new JTextField();
		TFrechercher.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		panNorth.add(TFrechercher);
		TFrechercher.setColumns(10);
		
		validrecherche = new JButton("OK");
		validrecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("jjjjj");
			}
		});
		panNorth.add(validrecherche);
	
		// Center panel
		pokemon = new JTable(new DataForPokedex().tableAddPokemon(user_ID));
		pokemon.setAutoCreateRowSorter(true);
		pokemon.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pokemon.setFont(new Font("Trebuchet MS", Font.PLAIN, 18));
		pokemon.setRowHeight(30);
		pokemon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint(); 
                int row = pokemon.rowAtPoint(p);  
                	pokemonSelectedID = Integer.parseInt(pokemon.getValueAt(row,0).toString());
                	String name = pokemon.getValueAt(row,1).toString();
                	
	                System.out.println(name + pokemonSelectedID);
            }	           
        });
		JScrollPane SCtable = new JScrollPane(pokemon);		
		pan.add(SCtable, BorderLayout.CENTER);
		
		// South panel
		panSouth = new JPanel();
		pan.add(panSouth, BorderLayout.SOUTH);
		panSouth.setLayout(new GridLayout(0, 2, 0, 0));
		
		returnMenu = new JButton("   Retour");
		returnMenu.setIcon(new ImageIcon(addPokemon.class.getResource("/img/return.png")));
		returnMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu(user_ID);
				frame.setVisible(true);
				dispose();
			}
		});
		panSouth.add(returnMenu);
		
		add = new JButton("Ajouter ce pok\u00E9mon");
		add.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DataForPokedex().addPokemon(pokemonSelectedID, user_ID);
				// Update Pokemon
				new DataForPokedex().tableAddPokemon(user_ID).fireTableDataChanged();
				pokemon.setModel(new DataForPokedex().tableAddPokemon(user_ID));
			}
		});
		panSouth.add(add);
		
		
	}
}
