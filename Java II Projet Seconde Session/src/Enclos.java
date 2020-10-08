import java.util.ArrayList;

public class Enclos {
	
	
	private int id;
	private ArrayList<Animal> listeAnimauxEnclos ;
	

	public Enclos( ArrayList<Animal> listeAnimauxEnclos) {
		this.listeAnimauxEnclos = listeAnimauxEnclos;
	}
	
	
	public ArrayList<Animal> getListeAnimaux(){
		return listeAnimauxEnclos;
	}
	
	
	public float getBeneficeEnclos(){
		float beneficeTotal = 0;

		for (Animal a : listeAnimauxEnclos) {
			beneficeTotal += a.getBenefice();
		}		
		return beneficeTotal;	
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String toString(){
        return  (+ '\n'+ " Id enclos : " + id + '\n' + "benefice enclos : " + getBeneficeEnclos() + '\n' + " Nombre animaux dans l'enclos: " + getListeAnimaux().size() + '\n' + " Liste animaux dans enclos : " + getListeAnimaux() + '\n');
    }
	

}
