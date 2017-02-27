package api;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import databaseProcessing.DataForPokedex;

public class seePokemonCard extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel pan;
	private JLabel titre, backgroundHomePage, backgroundEndPage, pokemonName, HP, pokemonPicture, logoType, pokemonLength, pokemonWeight;
	private JLabel logoTypeAttack, attack, damage, weakness, logoTypeWeakness;
	private JButton previous, next;
	private ArrayList<String> pokemon;
	private String[] pokemonData;
	private int i = 0;
	
	public seePokemonCard(int user_ID) {
		setBounds(100, 100, 677, 800);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Identification.class.getResource("/img/pokemonIcon.png")));
		setTitle("Pokedex");
		pan = new JPanel();
		pan.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pan);
		pan.setLayout(null);
		
		System.out.println(user_ID);
		pokemon = new DataForPokedex().pokemonUser(user_ID);
		
	// Objets Window component 
		titre = new JLabel("");
		titre.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/PokemonTitle.png")));
		titre.setBounds(347, 88, 279, 139);
		pan.add(titre);
	
		previous = new JButton("Précedent");
		previous.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		previous.setForeground(new Color(255, 204, 51));
		previous.setBackground(new Color(0, 0, 153));
		previous.setBounds(0, 692, 330, 61);
		previous.setEnabled(false);
		pan.add(previous);
		
		next = new JButton("Suivant");
		next.setFont(new Font("Trebuchet MS", Font.BOLD, 24));
		next.setForeground(new Color(255, 204, 51));
		next.setBackground(new Color(0, 0, 153));
		next.setBounds(329, 692, 330, 61);
		pan.add(next);
	
		backgroundHomePage = new JLabel("");
		backgroundHomePage.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/pokedexHome.jpg")));
		backgroundHomePage.setBounds(0, 0, 659, 753);
		pan.add(backgroundHomePage);
		
		backgroundEndPage = new JLabel("");
		backgroundEndPage.setVisible(false);
		backgroundEndPage.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/pokedexEnd.jpg")));
		backgroundEndPage.setBounds(22, 0, 610, 792);
		pan.add(backgroundEndPage);
		
		// Data pokemon
		pokemonName = new JLabel("");
		pokemonName.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		pokemonName.setBounds(48, 13, 241, 25);
		pan.add(pokemonName);
		
		HP = new JLabel("");
		HP.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		HP.setBounds(522, 13, 81, 25);
		pan.add(HP);
		
		pokemonPicture = new JLabel("");
		pokemonPicture.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
		pokemonPicture.setBackground(SystemColor.window);
		pokemonPicture.setBounds(26, 49, 603, 386);
		pan.add(pokemonPicture);
		
		logoType = new JLabel("");
		logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
		logoType.setBounds(598, 0, 50, 50);
		pan.add(logoType);
		
		pokemonLength = new JLabel("");
		pokemonLength.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		pokemonLength.setBounds(105, 439, 156, 25);
		pan.add(pokemonLength);
		
		pokemonWeight = new JLabel("");
		pokemonWeight.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		pokemonWeight.setBounds(414, 439, 119, 25);
		pan.add(pokemonWeight);
		
		logoTypeAttack = new JLabel("");
		logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
		logoTypeAttack.setBounds(26, 502, 111, 111);
		pan.add(logoTypeAttack);
		
		attack = new JLabel("");
		attack.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		attack.setBounds(238, 527, 257, 72);
		pan.add(attack);
		
		damage = new JLabel("");
		damage.setFont(new Font("Trebuchet MS", Font.BOLD, 26));
		damage.setBounds(542, 533, 61, 60);
		pan.add(damage);
		
		weakness = new JLabel("");
		weakness.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		weakness.setBounds(403, 618, 130, 49);
		pan.add(weakness);
		
		logoTypeWeakness = new JLabel("");
		logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
		logoTypeWeakness.setBounds(542, 618, 61, 49);
		pan.add(logoTypeWeakness);
		
	// Action when push button previous and next (Update data and view)
		previous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i <= pokemon.size()) {
					i--;
					pokemonData = pokemon.get(i).split(",");			
				// Last Page hidden
					backgroundEndPage.setVisible(false);
				// Enable button previous
					next.setEnabled(true);
					if (i == 0) {
						previous.setEnabled(false);
					// First Page visible
						titre.setVisible(true);
						backgroundHomePage.setVisible(true);
					// Update JLabels for they are not visible
						pokemonName.setText("");
						HP.setText("");
						logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
						logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
						pokemonLength.setText("");
						pokemonWeight.setText("");
						weakness.setText("");
						logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
						attack.setText("");
						damage.setText("");
						pokemonPicture.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
					} else {
						// Update JLabel data PokemonCard
						System.out.println(pokemon.get(i));
						System.out.println(pokemonData[0]);
						pokemonName.setText(pokemonData[1]);
						HP.setText(pokemonData[2]+" HP");
						// Logotype
						switch(pokemonData[3]) {
							case "Eau" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/water.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/water.png")));
								break;
							case "Feu" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fire.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/fire.png")));
								break;
							case "Plante" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/grass.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/grass.png")));
								break;
							case "Electrique" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/electric.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/electric.png")));
								break;
							case "Psy" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/psy.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/psy.png")));
								break;
							case "Normal" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/normal.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/normal.png")));
								break;
							case "Combat" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fighting.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/fighting.png")));
								break;
							case "Glace" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/ice.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/ice.png")));
								break;
							case "Vol" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fly.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/fly.png")));
								break;
							case "Dragon" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/dragon.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/dragon.png")));
								break;
							default :
								break;
						}
						pokemonLength.setText("Taille : " + pokemonData[4]);
						pokemonWeight.setText("Poids :" + pokemonData[5]);
						weakness.setText("Faiblesse :");
						// Logotype Weakness
						switch(pokemonData[6]) {
							case "Eau" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/water.png")));
								break;
							case "Feu" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fire.png")));
								break;
							case "Plante" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/grass.png")));
								break;
							case "Electrique" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/electric.png")));
								break;
							case "Psy" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/psy.png")));
								break;
							case "Normal" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/normal.png")));
								break;
							case "Combat" :
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fighting.png")));
								break;
							case "Glace" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/ice.png")));
								break;
							case "Vol" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fly.png")));
								break;
							case "Dragon" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/dragon.png")));
								break;
							default :
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
								break;
						}
						attack.setText(pokemonData[7]);
						damage.setText(pokemonData[8]);
						pokemonPicture.setIcon(new ImageIcon(seePokemonCard.class.getResource(pokemonData[9])));
					}
				}
			}
		});
		
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (i < pokemon.size()) {
					i++;
					pokemonData = pokemon.get(i).split(",");
				// First Page hidden
					titre.setVisible(false);
					backgroundHomePage.setVisible(false);
				// Enable button previous
					previous.setEnabled(true);
					if (i+1 == pokemon.size()) {
						next.setEnabled(false);
						System.out.println("Ici not visible");
					// Last Page visible
						backgroundEndPage.setVisible(true);
					// Update JLabels for they are not visible
						pokemonName.setText("");
						HP.setText("");
						logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
						logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
						pokemonLength.setText("");
						pokemonWeight.setText("");
						weakness.setText("");
						logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
						attack.setText("");
						damage.setText("");
						pokemonPicture.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
					} else {
						// Update JLabel data PokemonCard
						System.out.println(pokemonData[0]);
						pokemonName.setText(pokemonData[1]);
						HP.setText(pokemonData[2]+" HP");
						// Logotype
						switch(pokemonData[3]) {
							case "Eau" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/water.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/water.png")));
								break;
							case "Feu" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fire.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/fire.png")));
								break;
							case "Plante" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/grass.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/grass.png")));
								break;
							case "Electrique" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/electric.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/electric.png")));
								break;
							case "Psy" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/psy.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/psy.png")));
								break;
							case "Normal" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/normal.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/normal.png")));
								break;
							case "Combat" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fighting.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/fighting.png")));
								break;
							case "Glace" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/ice.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/ice.png")));
								break;
							case "Vol" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fly.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/fly.png")));
								break;
							case "Dragon" : 
								logoType.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/dragon.png")));
								logoTypeAttack.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeMedium/dragon.png")));
								break;
							default :
								break;
						}
						pokemonLength.setText("Taille : " + pokemonData[4]);
						pokemonWeight.setText("Poids :" + pokemonData[5]);
						weakness.setText("Faiblesse :");
						// Logotype Weakness
						switch(pokemonData[6]) {
							case "Eau" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/water.png")));
								break;
							case "Feu" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fire.png")));
								break;
							case "Plante" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/grass.png")));
								break;
							case "Electrique" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/electric.png")));
								break;
							case "Psy" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/psy.png")));
								break;
							case "Normal" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/normal.png")));
								break;
							case "Combat" :
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fighting.png")));
								break;
							case "Glace" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/ice.png")));
								break;
							case "Vol" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/fly.png")));
								break;
							case "Dragon" : 
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("/img/logoTypeSmall/dragon.png")));
								break;
							default :
								logoTypeWeakness.setIcon(new ImageIcon(seePokemonCard.class.getResource("")));
								break;
						}
						attack.setText(pokemonData[7]);
						damage.setText(pokemonData[8]);
						pokemonPicture.setIcon(new ImageIcon(seePokemonCard.class.getResource(pokemonData[9])));
					}
				}
			}
		});

	}
}
