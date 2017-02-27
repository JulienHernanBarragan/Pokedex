package api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

public class deletePokemon extends JFrame {
	
	private JPanel pan, panNorth, panCenter, panSouth;
	private JLabel search;
	private JTextField TFsearch;
	private JTable pokemon;
	private JButton delete, returnMenu, validsearch;
	private int pokemonSelectedID;
	
	public deletePokemon(int user_ID) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Identification.class.getResource("/img/pokemonIcon.png")));
		setTitle("Pokedex : supprimer un de vos pokémon");
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		pan.setBackground(new Color(178, 34, 34));
		setContentPane(pan);
		pan.setLayout(new BorderLayout(0, 0));
		
		// North panel
		panNorth = new JPanel();
		pan.add(panNorth, BorderLayout.NORTH);
		
		search = new JLabel("Rechercher :");
		panNorth.add(search);
		
		TFsearch = new JTextField();
		TFsearch.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		TFsearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					String rechercher= TFsearch.getText();
	                pokemon.setModel(new DataForPokedex().tableDeletePokemonSearch(user_ID, rechercher));
		    	}
			}
		});
		panNorth.add(TFsearch);
		TFsearch.setColumns(10);
		
		validsearch = new JButton("OK");
		validsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rechercher= TFsearch.getText();
                pokemon.setModel(new DataForPokedex().tableDeletePokemonSearch(user_ID, rechercher));
           }
		});
		panNorth.add(validsearch);
	
		// Center panel
		pokemon = new JTable(new DataForPokedex().tableDeletePokemon(user_ID));
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
		returnMenu.setIcon(new ImageIcon(deletePokemon.class.getResource("/img/return.png")));
		returnMenu.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		returnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Menu frame = new Menu(2);
				frame.setVisible(true);
				dispose();
			}
		});
		panSouth.add(returnMenu);
		
		delete = new JButton("Supprimer ce pok\u00E9mon");
		delete.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
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