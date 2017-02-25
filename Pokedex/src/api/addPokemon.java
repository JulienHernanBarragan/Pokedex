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

public class addPokemon extends JFrame {
	
	JPanel pan, panNorth, panCenter, panSouth;
	JLabel rechercher;
	JTextField TFrechercher;
	JTable pokemon;
	JButton add, returnMenu, validrecherche;
	String pokemonSelectedID;
	
	public addPokemon(int ID_user) {
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
		pokemon = new JTable(new DataForPokedex().tableAddPokemon());
		pokemon.setAutoCreateRowSorter(true);
		pokemon.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pokemon.setRowHeight(30);
		pokemon.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint(); 
                int row = pokemon.rowAtPoint(p);  
                	pokemonSelectedID = pokemon.getValueAt(row,0).toString();
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
		panSouth.add(returnMenu);
		
		add = new JButton("Ajouter ce pok\u00E9mon \u00E0 mon Pokedex");
		panSouth.add(add);
		
		
	}
}
