public class Test {

	public static void main(String[] args) {
		try{
			Adherent adherent1 = new Adherent("Albert","Durant","2 allee tataouine");
			Adherent adherent2 = new Adherent("Joseph","Beauve","14 rue de la grange");
			
			String titre= "BestOfLouisMariano";
			String auteur= "Louis Mariano";
			int nombreExemplaire = 3;
			Varietee varietee1= new Varietee(titre ,auteur, nombreExemplaire);
			System.out.println("Adherent 1 avant emprunt = "+adherent1);
			
			Exemplaire exemplaire = adherent1.emprunter(varietee1);
			System.out.println("Adherent 1 apres emprunt = "+ adherent1);
			
			adherent1.ramener(exemplaire);
			System.out.println("Adherent 1 apres restitution = "+ adherent1);
			
			Adherents adherents=new Adherents();
			adherents.addAdherent(adherent1);
			adherents.addAdherent(adherent2);
			
			Bibliothecaire bibliothecaire = new Bibliothecaire() ;
			Adherents adherents1 = new Adherents() ;
			adherents1.addDelaiRestitutionDepasseListener(bibliothecaire) ;
			
			adherents.sauvegarder() ;
			//adherents.restaurer() ;
			
			InterfaceGraphique fenetre = new InterfaceGraphique();
			fenetre.setVisible(true);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
