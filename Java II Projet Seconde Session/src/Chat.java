
public class Chat extends Animal {
	
	
    private boolean estRace;
    
    
	public Chat(int id, float poids, String nom, boolean estRace) {
	    super(id, poids, nom, 4);
        this.estRace = estRace;
	}

	
	public float getPrixNourriture() {
		if (estRace) {
		  return 3;
		} else {
		  return 2;
		}				
	}
	

	@Override
	public float getBenefice() {
		return 10-calculerCout(getPoids(), 10, getPrixNourriture() );
	}
	
	
	public  float calculerCout(float poids, int consoPoids, float prixCroquette ) {
		
		return (poids/100)*consoPoids*prixCroquette;	
	}

	
	 @Override
	    public String toString(){
	        return super.toString() + '\n' + " est de race? : " + estRace + '\n' + "Prix nourriture : " + getPrixNourriture() + '\n' + "Bénéfice : " + getBenefice() + '\n';
	    }
}



