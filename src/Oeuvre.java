import java.util.ArrayList;

public class Oeuvre {
	
	String titre;
	String auteur;
	int nombreExemplaire;
	static ArrayList <Exemplaire> numEx;
	
	public Oeuvre(String t, String a,int nb){
		titre=t;
		auteur=a;
		nombreExemplaire=nb;
		numEx=this.creer(nb);
	}
	
	public ArrayList<Exemplaire> creer (int nb){
		ArrayList<Exemplaire> tab =new ArrayList<Exemplaire>();
		for(int i=0;i<nb;i++){
			tab.add(new Exemplaire(i,this));
		}
		return tab;
	}
	
	public static int exemplairesRestants(){
		return(numEx.size());
	}
	
	public static void empruntExemp(int i){
		numEx.remove(i);
	}
	
	public static void ramenerExemp(Exemplaire examp){
		numEx.add(examp);
	}
	
	public String toString() {
		return "Titre : "+titre+", Auteur: "+auteur;
	}

}
