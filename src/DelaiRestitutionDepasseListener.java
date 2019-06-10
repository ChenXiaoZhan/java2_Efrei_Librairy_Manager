import java.util.EventListener;

public class DelaiRestitutionDepasseListener implements EventListener{
	
	public void exemplaireNonRestitue(DelaiDepasseEvent l){
		System.out.println("il y a un probleme");
	}

}
