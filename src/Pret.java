public class Pret {
	public final String Oeuvre = null;
	int numero=1;
	String debut;
	String fin;
	
	public Pret(int n, String d,String f){
		numero=n;
		debut=d;
		fin=f;
	}
	
	public Pret(int i) {
		numero=i;
		debut="0";
		fin="14";//adherent peut garder un exemplaire pour 14 jours
	}
	
	private String getNum() {
		return Integer.toString(numero);
	}
	
	private String getdebut() {
		return debut;
	}
	
	private String getfin() {
		return fin;
	}
	
	public String toString() {
		return "Pret : "+getNum()+", debut:	"+getdebut()+" fin:	"+getfin();
	}
}
