import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
        
		
        Solveur solve = new Solveur(20, "reservations.txt");
        
        System.out.println( " LISTE ENCLOS: " + '\n' +solve.getListeEnclos()+'\n'+"  " 
        + solve.getNbAnimauxEnclos()+ "  animaux sur les " +solve.getNbAnimaux()+" ont été assignés à des enclos "+ '\n'
        + "    pour un bénéfice total de  : "+ new DecimalFormat("#.##").format(solve.getBeneficeTotal()) +"€ " ); 		// comment afficher le float avec juste 2 décimal rapidement a été trouvé sur : https://stackoverflow.com/questions/7747469/
       

	}
}
