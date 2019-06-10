public class Exemplaire {
	int numero;
	Oeuvre oeuvre;
		
	public Exemplaire(int i, Oeuvre o){
		numero=i;
		oeuvre=o;
	}
	
	private String getNum() {
		return Integer.toString(numero);
	}
	
	public void ramener() {
		
	}
		public String toString() {
			return "Oeuvre [ " + oeuvre.toString() +", Numero :"+ getNum()+ " ]";
	}
}
