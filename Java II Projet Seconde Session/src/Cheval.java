
public class Cheval extends Animal {

	
	private float prixNourriture;
	
	
	public Cheval(int id, float poids,String nom, String cout) {
		super(id, poids, nom, 1);
        this.prixNourriture = Float.parseFloat(cout.replaceAll("[^0-9.]", "")); //parse rapide trouvé sur https://stackoverflow.com/questions/27645648/
	}
	
	
	public float getPrixNourriture() {return prixNourriture; }

	@Override
	public float getBenefice() {
		
		return 50 - prixNourriture;
	}
	
	 @Override
	    public String toString(){
	        return super.toString() + '\n' +" Prix nourriture : " + getPrixNourriture() + '\n' + "Bénéfice : " + getBenefice() + '\n';
	    }
	

}
