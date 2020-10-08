
public class Chien extends Animal {

	
	private String age;
	
	
	public Chien(int id, float poids, String nom, String age) {
	  
        super(id, poids, nom, 2);
        this.age = age;
	}

	
	public float getPrixNourriture() {
		int prix = 0;
		if (age.equals("jeune")) {
		  prix = 3;
		} else if (age.equals("moyen")) {
		  prix = 2;
		} else {
		  prix = 4;
		}
		return prix;
		
	}
	
	
	@Override
	public float getBenefice() {
		// TODO Auto-generated method stub
		return 20-calculerCout(getPoids(), 5, getPrixNourriture() );
	}
	
	
	public  float calculerCout(float poids, int consoPoids, float prixCroquette ) {
		
		return (poids/100)*consoPoids*prixCroquette;	
	}
	
	
	 @Override
	    public String toString(){
	        return super.toString() + '\n' +" age : " + age + '\n' + "Prix nourriture : " + getPrixNourriture() + '\n' + "Bénéfice : " + getBenefice() + '\n';
	    }


}
