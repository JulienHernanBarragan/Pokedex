package api;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import databaseProcessing.ConnectDB;

public class Identification extends JFrame {
		
	private static final long serialVersionUID = 1L;
	private JPanel pan;
	private JLabel logo, user, password;
	private JTextField TFuser;
	private JPasswordField TFpassword;
	private JButton connect;
	private String Duser,Dmdp;
		
	public Identification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Identification.class.getResource("/img/pokemonIcon.png")));
		setTitle("Pokedex : identifiez-vous");
		setResizable(false);
		pan = new JPanel();
	    pan.setLayout(null);
		pan.setBackground(new Color(178, 34, 34));
		setSize(700,400);
		setContentPane(pan);
		setLocationRelativeTo(null);
			
		logo = new JLabel();
		logo.setIcon(new ImageIcon(Identification.class.getResource("/img/pokemonIcon.png")));
		logo.setBounds(190, 5, 300, 128);
		pan.add(logo);
			
		user = new JLabel("Utilisateur :");
		user.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		user.setBounds(86, 142, 151, 24);
		pan.add(user);
			
		password = new JLabel ("Mot de Passe :");
		password.setFont(new Font("Trebuchet MS", Font.BOLD, 21));
		password.setBounds(86, 198, 142, 24);
		pan.add(password);
			
		TFuser = new JTextField();
		TFuser.setBounds(250, 145, 275, 26);
		TFuser.setColumns(10);
		pan.add(TFuser);
			
		TFpassword = new JPasswordField();
		TFpassword.addKeyListener(new KeyAdapter() {
			@SuppressWarnings("deprecation")
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					Duser = TFuser.getText();
		    		Dmdp = TFpassword.getText();
		    		String admin = new ConnectDB().connectAPI(Duser, Dmdp);
		    		String[] adminData = admin.split(";");
		    			if (admin.indexOf("accept") >= 0) {
		    				Menu session = new Menu(Integer.parseInt(adminData[1]));
		    				session.setVisible(true);
		    				dispose();
		    			}
				}
			}
		});
		TFpassword.setBounds(250, 200, 275, 26);
		TFpassword.setColumns(10);
		pan.add(TFpassword);
			
		connect = new JButton ("Connexion");
		connect.setBackground(new Color(0, 0, 0));
		connect.setForeground(Color.WHITE);
		connect.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		connect.setBounds(229, 265, 257, 46);
		connect.addActionListener(new ActionListener()  {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e)  {
				Duser = TFuser.getText();
	    		Dmdp = TFpassword.getText();
	    		String admin = new ConnectDB().connectAPI(Duser, Dmdp);
	    		String[] adminData = admin.split(";");
	    			if (admin.indexOf("accept") >= 0) {
	    				Menu session = new Menu(Integer.parseInt(adminData[1]));
	    				session.setVisible(true);
	    				dispose();
	    			}
		    	}
			});
			pan.add(connect);
			
		}
}