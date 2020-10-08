

public abstract class Animal {
	
	
	private int id;
	private int maxParEnclos;
	
	private float poids;
	private String nom;
	
	public Animal(int id, float poids, String nom,  int maxParEnclos) {
		super();
		this.id = id;
		this.maxParEnclos = maxParEnclos;
		this.nom = nom;
		this.poids = poids;
	}

	
	public String getNom() {return nom;}
    public int getId(){return id;}
    public int getMaxParEnclos(){return maxParEnclos;}
    public float getPoids(){return poids;}


	public abstract float getBenefice();
	public abstract float getPrixNourriture();
	
	
	@Override
    public String toString(){
        return "" + this.getClass() + '\n' + "Id : " + id + '\n' + "Nom : " + nom + '\n' + "Poids : " + poids + '\n' + "max par enclos : " + maxParEnclos;
    }


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (id != other.id)
			return false;
		return true;
	}


}
