import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import javax.swing.*;


public class InterfaceGraphique extends JFrame implements ActionListener {
	
	private Hashtable<String, String> dicoNom_Adr = new Hashtable<String, String>();
	private Hashtable<String, String> dicoNom_Prenom = new Hashtable<String, String>();
	private Hashtable<String, String> dicoOeuvre = new Hashtable<String, String>();
	private Hashtable<String, String> dicoPret = new Hashtable<String, String>();
	private Hashtable<String, Integer> dicoNbrexemplaire = new Hashtable<String, Integer>();
	private Hashtable<String, String> dicoEmpruntePar = new Hashtable<String, String>();
	
	public InterfaceGraphique() {
		super();
		build();
	}
	
	private void build() {		
		//on met qlq cl�s et valeurs dans les dictionnaires afin d'avoir du contenu
		
		//dicoNom_Adr: cl� nom, valeur adresse
		dicoNom_Adr.put("Durant","2 allee tataouine");
		dicoNom_Adr.put("Beauve","14 rue de la grange");
		
		//dicoNom_Prenom: cl� nom, valeur pr�nom
		dicoNom_Prenom.put("Durant", "Albert");
		dicoNom_Prenom.put("Beauve","Joseph");
		
		//dicoOeuvre: cl� titre, valeur auteur
		dicoOeuvre.put("Programmer en Java","Jacque Delannoy");
		dicoOeuvre.put("Programmer en C","Claude Dupays");
		dicoOeuvre.put("Programmer en Python","Phenix Demaison");
		
		//dicoPret: cl� nom de l'adherent, valeur livre emprunt� par l'adherent
		dicoPret.put("Durant", "Programmer en Java");
		dicoPret.put("Beauve", "Programmer en Python");
		
		//dicoEmpruntePar: cl� livre emprunt�, valeur: nom de l'adherent qui l'a emprunt�(reciproque du dicoPret)
		dicoEmpruntePar.put("Programmer en Java", "Durant Albert");
		dicoEmpruntePar.put("Programmer en Python", "Beauve Joseph");
		
		//dicoNbrexemplaire: cl� titre, valeur nombre d'exemplaires
		dicoNbrexemplaire.put("Programmer en Java",10);
		dicoNbrexemplaire.put("Programmer en C",15);
		dicoNbrexemplaire.put("Programmer en Python",20);
		
		
		setTitle("Mediatheque");//titre
		setSize(400,400);//taille de la fenetre
		setLocationRelativeTo(null);//fenetre centr�e
		setResizable(false);//redimmensionnement interdit
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //on peut fermer au moyen de croix
		setJMenuBar(buildMenu());
	}

	private JMenuBar buildMenu(){
		
		JMenuBar menubar = new JMenuBar();//barre de Menu
		
		JMenu menuAd = new JMenu("Adherents");//Menu Adherents
		JMenu menuOeu = new JMenu("Oeuvres");//Menu Oevures
		
		JMenuItem Nouveau = new JMenuItem("Nouveau");//sous-menu Nouveau d'adherents
		menuAd.add(Nouveau);
		
		JMenuItem Consulter = new JMenuItem("Consulter");//sous-menu Consulter d'adherents
		menuAd.add(Consulter);
		
		JMenuItem Supprimer = new JMenuItem("Supprimer");//sous-menu Supprimer d'adherents
		menuAd.add(Supprimer);
		
		JMenuItem NouveauOe = new JMenuItem("Nouveau");//sous-menu Nouveau d'Oeuvre
		menuOeu.add(NouveauOe);
		
		JMenuItem ConsulterOe = new JMenuItem("Consulter");//sous-menu Consulter d'Oeuvre
		menuOeu.add(ConsulterOe);
		
		JMenuItem SupprimerOe = new JMenuItem("Supprimer");//sous-menu supprimer d'Oeuvre
		menuOeu.add(SupprimerOe);
		
		menubar.add(menuAd);
		menubar.add(menuOeu);
		

	    Nouveau.addActionListener(new ActionListener() { //action li�e au sous-menu nouveau
	        @Override
	        public void actionPerformed(ActionEvent evt) {
	        	final JFrame NouvelAd = new JFrame();
	            NouvelAd.setVisible(true);
	            NouvelAd.setTitle("Nouvel Adh�rent");
	            NouvelAd.setSize(450,250);
	            NouvelAd.setLocationRelativeTo(null);
	            NouvelAd.setResizable(false);
	            NouvelAd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	            JPanel panel = new JPanel();

	            JLabel labelnom = new JLabel("nom :   ");
	            JLabel labelprenom = new JLabel("prenom :   ");
	            JLabel labeladr = new JLabel("adressse :   ");
	         
	            labelnom.setOpaque(true);
	            labelprenom.setOpaque(true);
	            labeladr.setOpaque(true);
	         
	            labelnom.setBackground(Color.white);
	            labelprenom.setBackground(Color.white);
	            labeladr.setBackground(Color.white);
	         
	            JTextField nom_texteField = new JTextField(15);
	            JTextField prenom_texteField = new JTextField(15);
	            JTextField adresse_texteField = new JTextField(20);
	         
	            JButton Annuler = new JButton("Annuler");
	            JButton Valider = new JButton("Valider");
	         
	            panel.setLayout(new GridBagLayout());
	         
	            GridBagConstraints gbc = new GridBagConstraints();
	         
	            gbc.insets = new Insets(8,0,15,0);
	            gbc.gridx=0;
	            gbc.gridy=0;
	            panel.add(labelnom,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=0;
	            panel.add(nom_texteField,gbc);
	         
	            gbc.gridx=0;
	            gbc.gridy=1;
	            panel.add(labelprenom,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=1;
	            panel.add(prenom_texteField,gbc);
	         
	            gbc.gridx=0;
	            gbc.gridy=2;
	            panel.add(labeladr,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=2;
	            panel.add(adresse_texteField,gbc);
	         
	            gbc.gridx=0;
	            gbc.gridy=3;
	            panel.add(Annuler,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=3;
	            panel.add(Valider,gbc);
	         
	            NouvelAd.add(panel);
	         
	            Annuler.addActionListener(new ActionListener() {//action li�e au bouton Annuler

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						NouvelAd.dispose(); //quand on clique sur le bouton Annuler, la fenetre disparait
					}
	            });
	         
	            Valider.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
					    // TODO Auto-generated method stub
				    	if (prenom_texteField.getText()!= null && nom_texteField.getText() != null && adresse_texteField.getText()!= null) {
				    		//on peut enregistrer un nouvel adherent si et seulement si les champs nom, prenom et adresse sont tous remplis !
				    		//on enregistre le nouvel adherent dans dico
				    		dicoNom_Adr.put(nom_texteField.getText(),adresse_texteField.getText());
				    		dicoNom_Prenom.put(nom_texteField.getText(),prenom_texteField.getText());
				    		
				        	JFrame enregistre = new JFrame();
				        	enregistre.setVisible(true);
				        	enregistre.setTitle("Nouvel Adh�rent");
				        	enregistre.setSize(350,150);
				        	enregistre.setLocationRelativeTo(null);
				        	enregistre.setResizable(false);
				        	enregistre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

				            JPanel panel = new JPanel();

				            JLabel label_info = new JLabel("Nouvel adh�rent enregistr� avec succ�s !");
				            JButton ok = new JButton("OK");
				     
				            panel.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				            
				            gbc.insets = new Insets(10,0,10,0);
				            
				            gbc.gridy=0;
				            panel.add(label_info,gbc);
				            
				            gbc.gridy=1;
				            panel.add(ok,gbc);
				            enregistre.add(panel);
				            
				            ok.addActionListener(new ActionListener() {
				            	public void actionPerformed(ActionEvent e) {
				            		enregistre.dispose();
				            	}
				            });
				    		NouvelAd.dispose(); 
				    	}
				    }
	             });
	        }
	    });

	    Consulter.addActionListener(new ActionListener() {	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFrame ConsulterAd = new JFrame();
				ConsulterAd.setVisible(true);
				ConsulterAd.setTitle("Consulter les adh�rents");
				ConsulterAd.setSize(500,250);
				ConsulterAd.setLocationRelativeTo(null);
				ConsulterAd.setResizable(false);
				ConsulterAd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		        JPanel panel = new JPanel();
		        
		        JComboBox<String> listenoms = new JComboBox<String>();
		        
		        for(String nom:dicoNom_Adr.keySet()) {
		        	listenoms.addItem(nom);
		        }
		        
		        JLabel labellisteAd = new JLabel("Liste des adherents :  ");
		        JLabel labelafficoor = new JLabel("Afficher les coordonn�es de l'adherent");
		        JLabel labelaffipret = new JLabel("Afficher les les prets en cours"); 
		        
		        JCheckBox checkbox_coord = new JCheckBox();
		        JCheckBox checkbox_pret = new JCheckBox();
		        
		        
	            JButton Annuler = new JButton("Annuler");
	            JButton Valider = new JButton("Valider");
		         
		        labellisteAd.setOpaque(true);
		        labelafficoor.setOpaque(true);
		        labelaffipret.setOpaque(true);
		         
		        labellisteAd.setBackground(Color.white);
		        labelafficoor.setBackground(Color.white);
		        labelaffipret.setBackground(Color.white);
		        
	            panel.setLayout(new GridBagLayout());
		         
	            GridBagConstraints gbc_2 = new GridBagConstraints();
	         
	            gbc_2.insets = new Insets(10,0,10,0);
	            
	            gbc_2.gridx=0;
	            gbc_2.gridy=0;
		        panel.add(labellisteAd,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=0;
		        panel.add(listenoms,gbc_2);
		        
		        gbc_2.gridx=0;
		        gbc_2.gridy=1;
		        panel.add(checkbox_coord,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=1;
		        panel.add(labelafficoor,gbc_2);
		        
		        gbc_2.gridx=0;
		        gbc_2.gridy=2;
		        panel.add(checkbox_pret,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=2;
		        panel.add(labelaffipret,gbc_2);
		        
		        gbc_2.gridx=0;
		        gbc_2.gridy=5;
		        panel.add(Annuler,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=5;
		        panel.add(Valider,gbc_2);
		        
		        ConsulterAd.add(panel);
		        
	            Annuler.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ConsulterAd.dispose();
					}
	            });
	         
	            Valider.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
					    // TODO Auto-generated method stub
					    if(checkbox_coord.isSelected() && checkbox_pret.isSelected()) {
					    	
					    	JFrame coor_pret = new JFrame();
					    	coor_pret.setVisible(true);
					    	coor_pret.setTitle("les coordonn�es et les prets de l'adherent selectionn�: ");
					    	coor_pret.setSize(400,200);
					    	coor_pret.setLocationRelativeTo(null);
					    	coor_pret.setResizable(false);
					    	coor_pret.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					    	
					    	JLabel nom_string = new JLabel("Nom et pr�nom:");
					    	JLabel nom_concret = new JLabel((String)listenoms.getSelectedItem()+" "+dicoNom_Prenom.get(listenoms.getSelectedItem()));
					    	JLabel adresse = new JLabel("Adresse:");
					    	JLabel coor_concret = new JLabel((String) dicoNom_Adr.get(listenoms.getSelectedItem()));
					    	JLabel pret_en_cours_string = new JLabel("Pr�t en cours: ");
					    	JLabel pres_en_cours = new JLabel((String) dicoPret.get(listenoms.getSelectedItem()));
					    	
					    	coor_pret.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				    
				            gbc.insets = new Insets(10,0,10,0);
					    	
				            gbc.gridx=0;
				            gbc.gridy=0;
				            coor_pret.add(nom_string,gbc);
				            
				            gbc.gridx=1;
					    	coor_pret.add(nom_concret,gbc);
				            
					    	gbc.gridx=0;
				            gbc.gridy=1;
					    	coor_pret.add(adresse,gbc);
					    	
					    	gbc.gridx=1;
				            gbc.gridy=1;
				            coor_pret.add(coor_concret,gbc);
				            
				            gbc.gridx=0;
					    	gbc.gridy=2;
					    	coor_pret.add(pret_en_cours_string,gbc);
					    	
					    	gbc.gridx=1;
					    	gbc.gridy=2;
					    	coor_pret.add(pres_en_cours,gbc);
					    }else if(checkbox_coord.isSelected()) {
					    	
					    	JFrame coor = new JFrame();
					    	coor.setVisible(true);
					    	coor.setTitle("les coordonn�es de l'adherent selectionn�: ");
					    	coor.setSize(300,150);
					    	coor.setLocationRelativeTo(null);
					    	coor.setResizable(false);
					    	coor.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					    	
					    	JLabel nom_string = new JLabel("Nom et pr�nom: ");
					    	JLabel nom_concret = new JLabel((String) listenoms.getSelectedItem()+" "+dicoNom_Prenom.get(listenoms.getSelectedItem()));
					    	JLabel adr_string = new JLabel("Adresse:");
					    	JLabel coor_concret = new JLabel((String) dicoNom_Adr.get(listenoms.getSelectedItem()));
					    	
					    	coor.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				    
				            gbc.insets = new Insets(10,0,10,0);
					    	
				            gbc.gridx=0;
				            coor.add(nom_string,gbc);
				            
				            gbc.gridx=1;
					    	coor.add(nom_concret,gbc);
					    	
					    	gbc.gridx=0;
					    	gbc.gridy=1;
					    	coor.add(adr_string,gbc);
					    	
					    	gbc.gridx=1;
				            gbc.gridy=1;
					    	coor.add(coor_concret,gbc);
					    }
					    else if (checkbox_pret.isSelected()) {
					    	
					    	JFrame coor_pret = new JFrame();
					    	coor_pret.setVisible(true);
					    	coor_pret.setTitle("les prets de l'adherent selectionn�: ");
					    	coor_pret.setSize(350,180);
					    	coor_pret.setLocationRelativeTo(null);
					    	coor_pret.setResizable(false);
					    	coor_pret.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					    	
					    	JLabel nom_string = new JLabel("Nom et pr�nom:");
					    	JLabel nom_concret = new JLabel((String)listenoms.getSelectedItem()+" "+dicoNom_Prenom.get(listenoms.getSelectedItem()));
					    	JLabel pret_en_cours_string = new JLabel("Pr�t en cours:    ");
					    	JLabel pres_en_cours = new JLabel((String) dicoPret.get(listenoms.getSelectedItem()));
					    	
					    	coor_pret.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				    
				            gbc.insets = new Insets(10,0,10,0);
				            
				            gbc.gridx=0;
				            coor_pret.add(nom_string,gbc);
				            
				            gbc.gridx=1;
					    	coor_pret.add(nom_concret,gbc);
					    	
					    	gbc.gridx=0;
					    	gbc.gridy=1;
					    	coor_pret.add(pret_en_cours_string,gbc);
					    	
					    	gbc.gridx=1;
					    	gbc.gridy=1;
					    	coor_pret.add(pres_en_cours,gbc);
					    }
				    }
				    
	             });
			}
	    });
	    
	    Supprimer.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFrame suppriAd = new JFrame();
				suppriAd.setVisible(true);
				suppriAd.setTitle("Supprimer adherent");
				suppriAd.setSize(350,250);
				suppriAd.setLocationRelativeTo(null);
				suppriAd.setResizable(false);
				suppriAd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				JPanel panel = new JPanel();
				
				JLabel labellisteAd = new JLabel("liste des adherents :  ");
				
				labellisteAd.setOpaque(true);
		         
		        labellisteAd.setBackground(Color.white);
		        
		        JComboBox<String> listenoms = new JComboBox<String>();
		        
		        for(String nom:dicoNom_Adr.keySet()) {
		        	listenoms.addItem(nom);
		        }
		        
		        JButton Annuler = new JButton("Annuler");
	            JButton Valider = new JButton("Valider");
	            
	            panel.setLayout(new GridBagLayout());
		         
	            GridBagConstraints gbc_3 = new GridBagConstraints();
	         
	            gbc_3.insets = new Insets(30,0,30,0);
	            gbc_3.gridx=0;
		        gbc_3.gridy=0;
	            panel.add(labellisteAd,gbc_3);
	            
	            gbc_3.gridx=1;
		        gbc_3.gridy=0;
	            panel.add(listenoms,gbc_3);
	            
	            gbc_3.gridx=0;
		        gbc_3.gridy=1;
	            panel.add(Annuler,gbc_3);
	            
	            gbc_3.gridx=1;
		        gbc_3.gridy=1;
		        panel.add(Valider,gbc_3);
		        
		        suppriAd.add(panel);
		        
	            Annuler.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						suppriAd.dispose();
					}
	            });
	         
	            Valider.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	// TODO Auto-generated method stub
				    	dicoNom_Adr.remove(listenoms.getSelectedItem()); //on retire l'element dans le dico
				    	dicoNom_Prenom.remove(listenoms.getSelectedItem());
				    	
				    	JFrame suppriAdsucces = new JFrame();
				    	suppriAdsucces.setVisible(true);
				    	suppriAdsucces.setTitle("Un adherent est supprim�: ");
				    	suppriAdsucces.setSize(300,150);
				    	suppriAdsucces.setLocationRelativeTo(null);
				    	suppriAdsucces.setResizable(false);
				    	suppriAdsucces.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				    	
			            JPanel panel = new JPanel();

			            JLabel label_info = new JLabel("Adh�rent supprim� avec succ�s !");
			            JButton ok = new JButton("OK");
			            
			            panel.setLayout(new GridBagLayout());
				         
			            GridBagConstraints gbc_supp = new GridBagConstraints();
			            
			            gbc_supp.insets = new Insets(10,0,10,0);
			            
			            gbc_supp.gridy=0;
			            panel.add(label_info,gbc_supp);
			            
			            gbc_supp.gridy=1;
			            panel.add(ok,gbc_supp);
			            suppriAdsucces.add(panel);
			            
			            ok.addActionListener(new ActionListener() {
			            	public void actionPerformed(ActionEvent e) {
			            		suppriAdsucces.dispose();
			            		suppriAd.dispose();
			            	}
			            });
				    }
	             });
			}
	    });
	    
	    NouveauOe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent eve) {
				// TODO Auto-generated method stub
				final JFrame newOeuvre = new JFrame();
				newOeuvre.setVisible(true);
				newOeuvre.setTitle("Nouvel Oeuvre");
				newOeuvre.setSize(450,250);
				newOeuvre.setLocationRelativeTo(null);
				newOeuvre.setResizable(false);
				newOeuvre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

	            JPanel panel = new JPanel();

	            JLabel label_titre = new JLabel("Titre :   ");
	            JLabel label_auteur = new JLabel("Auteur :   ");
	            JLabel label_nbr_exemp = new JLabel("Nombre d'exemplaire :   ");
	         
	            label_titre.setOpaque(true);
	            label_auteur.setOpaque(true);
	            label_nbr_exemp.setOpaque(true);
	         
	            label_titre.setBackground(Color.white);
	            label_auteur.setBackground(Color.white);
	            label_nbr_exemp.setBackground(Color.white);
	         
	            JTextField titre_texteField = new JTextField(15);
	            JTextField auteur_texteField = new JTextField(15);
	            JTextField nbr_exemp_texteField = new JTextField(15);
	         
	            JButton Annuler = new JButton("Annuler");
	            JButton Valider = new JButton("Valider");
	         
	            panel.setLayout(new GridBagLayout());
	         
	            GridBagConstraints gbc = new GridBagConstraints();//objet gbc: mise en page
	         
	            gbc.insets = new Insets(8,0,15,0);
	            gbc.gridx=0;
	            gbc.gridx=0;
	            panel.add(label_titre,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=0;
	            panel.add(titre_texteField,gbc);
	         
	            gbc.gridx=0;
	            gbc.gridy=1;
	            panel.add(label_auteur,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=1;
	            panel.add(auteur_texteField,gbc);
	         
	            gbc.gridx=0;
	            gbc.gridy=2;
	            panel.add(label_nbr_exemp,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=2;
	            panel.add(nbr_exemp_texteField,gbc);
	         
	            gbc.gridx=0;
	            gbc.gridy=3;
	            panel.add(Annuler,gbc);
	         
	            gbc.gridx=1;
	            gbc.gridy=3;
	            panel.add(Valider,gbc);
	         
	            newOeuvre.add(panel);
	         
	            Annuler.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						newOeuvre.dispose();
					}
	            });
	         
	            Valider.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
					    // TODO Auto-generated method stub
				    	//si la bibliotheque a deja cet oeuvre, alors on a actualiser le nombre d'exemplaires
				    	if (dicoNbrexemplaire.containsKey(titre_texteField.getText())) {
				    		int nouvelle_valeur = dicoNbrexemplaire.get(titre_texteField.getText())+Integer.parseInt(nbr_exemp_texteField.getText());
				    		dicoNbrexemplaire.put(titre_texteField.getText(),nouvelle_valeur);
				    		
				    		JFrame enregistre = new JFrame();
				        	enregistre.setVisible(true);
				        	enregistre.setTitle("Nouvel Adh�rent");
				        	enregistre.setSize(350,150);
				        	enregistre.setLocationRelativeTo(null);
				        	enregistre.setResizable(false);
				        	enregistre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

				            JPanel panel = new JPanel();

				            JLabel label_info = new JLabel("Le nombre d'exemplaires est actualis�!");
				            JButton ok = new JButton("OK");
				     
				            panel.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();//objet gbc: mise en page
				            
				            gbc.insets = new Insets(10,0,10,0);
				            
				            gbc.gridy=0;
				            panel.add(label_info,gbc);
				            
				            gbc.gridy=1;
				            panel.add(ok,gbc);
				            enregistre.add(panel);
				            
				            ok.addActionListener(new ActionListener() {
				            	public void actionPerformed(ActionEvent e) {
				            		enregistre.dispose();
				            	}
				            });

				            newOeuvre.dispose(); 
				    	}
				    	//sinon on va ajouter le nouvel oeuvre
				    	else {
				    		dicoNbrexemplaire.put(titre_texteField.getText(),Integer.parseInt(nbr_exemp_texteField.getText()));	
				    		dicoOeuvre.put(titre_texteField.getText(),auteur_texteField.getText());
				    		JFrame enregistre = new JFrame();
				        	enregistre.setVisible(true);
				        	enregistre.setTitle("Nouvel Adh�rent");
				        	enregistre.setSize(350,150);
				        	enregistre.setLocationRelativeTo(null);
				        	enregistre.setResizable(false);
				        	enregistre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

				            JPanel panel = new JPanel();

				            JLabel label_info = new JLabel("Nouvel oeuvre enregistr� avec succ�s!");
				            JButton ok = new JButton("OK");
				     
				            panel.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				            
				            gbc.insets = new Insets(10,0,10,0);
				            
				            gbc.gridy=0;
				            panel.add(label_info,gbc);
				            
				            gbc.gridy=1;
				            panel.add(ok,gbc);
				            enregistre.add(panel);
				            
				            ok.addActionListener(new ActionListener() {
				            	public void actionPerformed(ActionEvent e) {
				            		enregistre.dispose();
				            	}
				            });

				            newOeuvre.dispose(); 
				    	}
				    }
	            });
	            
			} 
			
	    });
	    ConsulterOe.addActionListener(new ActionListener() {	    	    	
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFrame ConOeuvre = new JFrame();
				ConOeuvre.setVisible(true);
				ConOeuvre.setTitle("Consulter les Oeuvres");
				ConOeuvre.setSize(500,250);
				ConOeuvre.setLocationRelativeTo(null);
				ConOeuvre.setResizable(false);
				ConOeuvre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		        JPanel panel = new JPanel();
		        
		        JComboBox<String> listeOeuvres = new JComboBox<String>();
		        
		        //le menu deroulant(Combobox) prend toutes les cl�s du dicoOeuvre
		        for(String titre:dicoOeuvre.keySet()) {
		        	listeOeuvres.addItem(titre);
		        }
		        
		        JLabel label_Oeuvre = new JLabel("liste des Oeuvres :  ");
		        JLabel label_info = new JLabel("Afficher les informations de l'oeuvre");
		        JLabel label_pret_encours = new JLabel("Afficher les prets en cours"); 
		        
		        JCheckBox checkbox_info = new JCheckBox();
		        JCheckBox checkbox_pret_encours = new JCheckBox();
		        
		        
	            JButton Annuler = new JButton("Annuler");
	            JButton Valider = new JButton("Valider");
		         
	            label_Oeuvre.setOpaque(true);
	            label_info.setOpaque(true);
	            label_pret_encours.setOpaque(true);
		         
	            label_Oeuvre.setBackground(Color.white);
	            label_info.setBackground(Color.white);
	            label_pret_encours.setBackground(Color.white);
		        
	            panel.setLayout(new GridBagLayout());
		         
	            GridBagConstraints gbc_2 = new GridBagConstraints();
	         
	            gbc_2.insets = new Insets(10,0,10,0);
	            
	            gbc_2.gridx=0;
	            gbc_2.gridy=0;
		        panel.add(label_Oeuvre,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=0;
		        panel.add(listeOeuvres,gbc_2);
		        
		        gbc_2.gridx=0;
		        gbc_2.gridy=1;
		        panel.add(checkbox_info,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=1;
		        panel.add(label_info,gbc_2);
		        
		        gbc_2.gridx=0;
		        gbc_2.gridy=2;
		        panel.add(checkbox_pret_encours,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=2;
		        panel.add(label_pret_encours,gbc_2);
		        
		        gbc_2.gridx=0;
		        gbc_2.gridy=5;
		        panel.add(Annuler,gbc_2);
		        
		        gbc_2.gridx=1;
		        gbc_2.gridy=5;
		        panel.add(Valider,gbc_2);
		        
		        ConOeuvre.add(panel);
		        
	            Annuler.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						ConOeuvre.dispose();
					}
	            });
	         
	            Valider.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
					    // TODO Auto-generated method stub
					    if(checkbox_info.isSelected() && checkbox_pret_encours.isSelected()) {
					    	
					    	JFrame info_oeuvre = new JFrame();
					    	info_oeuvre.setVisible(true);
					    	info_oeuvre.setTitle("Les information sur l'oeuvre selectionn�: ");
					    	info_oeuvre.setSize(400,230);
					    	info_oeuvre.setLocationRelativeTo(null);
					    	info_oeuvre.setResizable(false);
					    	info_oeuvre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					    	
					    	JLabel titre_string = new JLabel("Titre:");
					    	JLabel titre = new JLabel("<< " +listeOeuvres.getSelectedItem() +" >>");
					    	JLabel auteur_string = new JLabel("Auteur:");
					    	JLabel auteur = new JLabel(dicoOeuvre.get(listeOeuvres.getSelectedItem()));
					    	JLabel nbrexemplaire_string = new JLabel("Nombre d'exemplaires:");
					    	JLabel nbrexemplaire = new JLabel(dicoNbrexemplaire.get(listeOeuvres.getSelectedItem()).toString());
					    	JLabel emprunte_par_string = new JLabel("Emprunt� par: ");
					    	JLabel emprunt = new JLabel(dicoEmpruntePar.get(listeOeuvres.getSelectedItem()));
					    	
					    	info_oeuvre.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				            
				            gbc.insets = new Insets(10,10,10,10);
				    
				            gbc.gridx=0;
				            gbc.gridy=0;
				            info_oeuvre.add(titre_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=0;
				            info_oeuvre.add(titre,gbc);
					    	
					    	gbc.gridx=0;
				            gbc.gridy=1;
				            info_oeuvre.add(auteur_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=1;
				            info_oeuvre.add(auteur,gbc);
				            
					    	gbc.gridx=0;
				            gbc.gridy=2;
				            info_oeuvre.add(nbrexemplaire_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=2;
				            info_oeuvre.add(nbrexemplaire,gbc);
				            
				            gbc.gridx=0;
				            gbc.gridy=3;
				            info_oeuvre.add(emprunte_par_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=3;
				            info_oeuvre.add(emprunt,gbc);
					    } else if (checkbox_info.isSelected()) {
					    	
					    	JFrame info_oeuvre = new JFrame();
					    	info_oeuvre.setVisible(true);
					    	info_oeuvre.setTitle("Les information sur l'oeuvre selectionn�: ");
					    	info_oeuvre.setSize(400,210);
					    	info_oeuvre.setLocationRelativeTo(null);
					    	info_oeuvre.setResizable(false);
					    	info_oeuvre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					    	
					    	JLabel titre_string = new JLabel("Titre:");
					    	JLabel titre = new JLabel("<< " +listeOeuvres.getSelectedItem() +" >>");
					    	JLabel auteur_string = new JLabel("Auteur:");
					    	JLabel auteur = new JLabel(dicoOeuvre.get(listeOeuvres.getSelectedItem()));
					    	JLabel nbrexemplaire_string = new JLabel("Nombre d'exemplaires:");
					    	JLabel nbrexemplaire = new JLabel(dicoNbrexemplaire.get(listeOeuvres.getSelectedItem()).toString());
					    	
					    	info_oeuvre.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				            
				            gbc.insets = new Insets(10,10,10,10);
				    
				            gbc.gridx=0;
				            gbc.gridy=0;
				            info_oeuvre.add(titre_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=0;
				            info_oeuvre.add(titre,gbc);
					    	
					    	gbc.gridx=0;
				            gbc.gridy=1;
				            info_oeuvre.add(auteur_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=1;
				            info_oeuvre.add(auteur,gbc);
				            
					    	gbc.gridx=0;
				            gbc.gridy=2;
				            info_oeuvre.add(nbrexemplaire_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=2;
				            info_oeuvre.add(nbrexemplaire,gbc);
					    }else if (checkbox_pret_encours.isSelected()) {
					    	
					    	JFrame info_oeuvre = new JFrame();
					    	info_oeuvre.setVisible(true);
					    	info_oeuvre.setTitle("Les information sur l'oeuvre selectionn�: ");
					    	info_oeuvre.setSize(350,180);
					    	info_oeuvre.setLocationRelativeTo(null);
					    	info_oeuvre.setResizable(false);
					    	info_oeuvre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					    	
					    	JLabel titre_string = new JLabel("Titre:");
					    	JLabel titre = new JLabel("<< " +listeOeuvres.getSelectedItem() +" >>");
					    	JLabel emprunte_par_string = new JLabel("Emprunt� par: ");
					    	JLabel emprunt = new JLabel(dicoEmpruntePar.get(listeOeuvres.getSelectedItem()));
					    	
					    	info_oeuvre.setLayout(new GridBagLayout());
					         
				            GridBagConstraints gbc = new GridBagConstraints();
				            
				            gbc.insets = new Insets(10,10,10,10);
				    
				            gbc.gridx=0;
				            gbc.gridy=0;
				            info_oeuvre.add(titre_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=0;
				            info_oeuvre.add(titre,gbc);
				            
				            gbc.gridx=0;
				            gbc.gridy=1;
				            info_oeuvre.add(emprunte_par_string,gbc);
				            
				            gbc.gridx=1;
				            gbc.gridy=1;
				            info_oeuvre.add(emprunt,gbc);
					    }
					    
				    }
	             });
			}
			
	    });
	    SupprimerOe.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final JFrame suppriOe = new JFrame();
				suppriOe.setVisible(true);
				suppriOe.setTitle("Supprimer Oeuvres");
				suppriOe.setSize(350,250);
				suppriOe.setLocationRelativeTo(null);
				suppriOe.setResizable(false);
				suppriOe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				
				JPanel panel = new JPanel();
				
				JLabel label_listeOe = new JLabel("Liste des Oeuvres :  ");
				
				label_listeOe.setOpaque(true);
		         
				label_listeOe.setBackground(Color.white);
		        
		        JComboBox<String> combobox_listeOeuvres = new JComboBox<String>();
		        
		        for(String nom:dicoOeuvre.keySet()) {
		        	combobox_listeOeuvres.addItem(nom);
		        }
		        
		        JButton Annuler = new JButton("Annuler");
	            JButton Valider = new JButton("Valider");
	            
	            panel.setLayout(new GridBagLayout());
		         
	            GridBagConstraints gbc_3 = new GridBagConstraints();
	         
	            gbc_3.insets = new Insets(30,0,30,0);
	            gbc_3.gridx=0;
		        gbc_3.gridy=0;
	            panel.add(label_listeOe,gbc_3);
	            
	            gbc_3.gridx=1;
		        gbc_3.gridy=0;
	            panel.add(combobox_listeOeuvres,gbc_3);
	            
	            gbc_3.gridx=0;
		        gbc_3.gridy=1;
	            panel.add(Annuler,gbc_3);
	            
	            gbc_3.gridx=1;
		        gbc_3.gridy=1;
		        panel.add(Valider,gbc_3);
		        
		        suppriOe.add(panel);
		        
	            Annuler.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						suppriOe.dispose();
					}
	            });
	         
	            Valider.addActionListener(new ActionListener() {

				    @Override
				    public void actionPerformed(ActionEvent e) {
					    // TODO Auto-generated method stub
				    	dicoOeuvre.remove(combobox_listeOeuvres.getSelectedItem());
				    	dicoNbrexemplaire.remove(combobox_listeOeuvres.getSelectedItem());
				    	
				    	JFrame suppriOevsucces = new JFrame();
				    	suppriOevsucces.setVisible(true);
				    	suppriOevsucces.setTitle("Un oeuvre est supprim�: ");
				    	suppriOevsucces.setSize(300,150);
				    	suppriOevsucces.setLocationRelativeTo(null);
				    	suppriOevsucces.setResizable(false);
				    	suppriOevsucces.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				    	
			            JPanel panel = new JPanel();

			            JLabel label_info = new JLabel("Oeuvre supprim� avec succ�s !");
			            JButton ok = new JButton("OK");
			            
			            panel.setLayout(new GridBagLayout());
				         
			            GridBagConstraints gbc_supp = new GridBagConstraints();
			            
			            gbc_supp.insets = new Insets(10,0,10,0);
			            
			            gbc_supp.gridy=0;
			            panel.add(label_info,gbc_supp);
			            
			            gbc_supp.gridy=1;
			            panel.add(ok,gbc_supp);
			            suppriOevsucces.add(panel);
			            
			            ok.addActionListener(new ActionListener() {
			            	public void actionPerformed(ActionEvent e) {
			            		suppriOevsucces.dispose();
			            		suppriOe.dispose();
			            		
			            	}
			            });
				    }
	             });
				
			}
	    	
	    });
	    
		return menubar;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}

		
		

	


