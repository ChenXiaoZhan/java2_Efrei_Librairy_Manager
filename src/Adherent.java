import java.util.Hashtable;
import java.io.Serializable;
import java.util.ArrayList;

public class Adherent implements Serializable{
	
	String prenom;
	String nom;
	String adresse;
	static Hashtable<Exemplaire,Pret> emprunts=new Hashtable<Exemplaire,Pret>();
	ArrayList<Exemplaire> empruntsEx = new ArrayList<Exemplaire>();
	
	public Adherent(String p,String n,String a){
		prenom=p;
		nom=n;
		adresse=a;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String getPrenom() {
		return prenom;
	}
	
	public String getAdresse() {
		return adresse;
	}
	
	public Exemplaire emprunter(Oeuvre o){
		Exemplaire e=null;
		if (Oeuvre.exemplairesRestants()==0) { //s'il n'y plus d'exemplaire, alors on affiche l'oeuvre n'est pas dispo
			System.out.println("Plus d'exemplaire disponible");
			return e;
		}
		else {
			Pret pret=new Pret(Oeuvre.numEx.get(0).numero);
			emprunts.put(Oeuvre.numEx.get(0),pret);
			Oeuvre.empruntExemp(0);
			empruntsEx.add(Oeuvre.numEx.get(0));
			return empruntsEx.get(0);
		}
	}
	
	public void ramener(Exemplaire e) {
		Oeuvre.ramenerExemp(e);//on ajoute l'exemplaire dans ArrayList <Exemplaire> numEx, donc le nbr d'exemplaire incremente
		emprunts.remove(e); // dans Hashtable<Exemplaire,Pret> emprunts, on retire cet exemplaire
		empruntsEx.remove(e);//dans ArrayList<Exemplaire> empruntsEx, on retire cet exemplaire
	}
	
	public String toString(){
		String txt="";
		if (empruntsEx.size()>0){ //si l'adherent a au moins un emprunt, alors on affiche le ou les emprunt(s)
		for (int i=0;i<empruntsEx.size();i++){ //avec une boucle for
		txt+="Emprunts en cours:\n";
		txt+=""+empruntsEx.get(i).toString()+"\n";
		}
		}else{ // sinon, on affiche qu'il n'emprunte aucun exemplaire
			txt+="N'emprunte aucun exemplaire actuellement";
		}
		String affichage="Nom : "+getNom()+" Prenom : "+getPrenom()+" Adresse : "+getAdresse()+"\n";
		affichage+=txt;
		return(affichage);
	
	}
}
