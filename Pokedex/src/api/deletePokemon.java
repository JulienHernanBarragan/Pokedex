package api;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import databaseProcessing.DataForPokedex;

public class deletePokemon extends JFrame {
	
	private JPanel pan, panNorth, panCenter, panSouth;
	private JLabel rechercher;
	private JTextField TFrechercher;
	private JTable pokemon;
	private JButton delete, returnMenu, validrecherche;
	private int pokemonSelectedID;
	
	public deletePokemon(int user_ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 800);
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pan);
		pan.setLayout(new BorderLayout(0, 0));
		
		// North panel
		panNorth = new JPanel();
		pan.add(panNorth, BorderLayout.NORTH);
		
		rechercher = new JLabel("Rechercher :");
		panNorth.add(rechercher);
		
		TFrechercher = new JTextField();
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
		pokemon = new JTable(new DataForPokedex().tableDeletePokemon(user_ID));
		pokemon.setAutoCreateRowSorter(true);
		pokemon.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
		
		returnMenu = new JButton("Retour");
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu(2);
				frame.setVisible(true);
				dispose();
			}
		});
		panSouth.add(returnMenu);
		
		delete = new JButton("Supprimer ce pok\u00E9mon de mon Pokedex");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new DataForPokedex().deletePokemon(pokemonSelectedID, user_ID);
				// Update Pokemon
				new DataForPokedex().tableDeletePokemon(user_ID).fireTableDataChanged();
				pokemon.setModel(new DataForPokedex().tableDeletePokemon(user_ID));
			}
		});
		panSouth.add(delete);
	}
}