import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;


public class Adherents implements Runnable, Serializable{
	
	
	private ArrayList <Adherent> adherents;
	
	public Adherents() {
		adherents=new ArrayList<Adherent>();
	}
	
	public void addAdherent(Adherent a) {
		adherents.add(a);
	}
	
	public Adherent getAdherent(String nom, String prenom, String adresse) {
		for(int i = 0; i<adherents.size();i++) {
			if(adherents.get(i).getNom()==nom && adherents.get(i).getPrenom()==prenom && adherents.get(i).getAdresse()==adresse) {
			    //si le nom le prenom et l'adresse match, alors on retourne cet adherent
				return adherents.get(i);
			}
		}
		return null;//sinon, on le trouve pas, on retourne rien
	}
	
	public void addDelaiRestitutionDepasseListener( DelaiRestitutionDepasseListener l ){
		for (int i=0;i< adherents.size();i++) {
			Adherent ad= adherents.get(i); //on v�rifie tous les adherents
			for( Enumeration<Pret> e= Adherent.emprunts.elements() ;e.hasMoreElements();){ 
				Pret pret = (Pret)e.nextElement() ;		
			}
		}
	}
	
	
	public void sauvegarder() {
		String filename = "infoAdherent.txt";
		try {
			//sauvegarder objet dans un fichier
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(filename,true));
			os.writeObject(this);
			System.out.println("objet est s�rialis�");
			os.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Adherent> restaurer() {
		String filename = "infoAdherent.txt";
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream ois = new ObjectInputStream(file);
			
			adherents = (ArrayList<Adherent>) ois.readObject();
			
			ois.close();
			file.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adherents;
	}
	

	@Override
	public void run() {
		
	}

}
