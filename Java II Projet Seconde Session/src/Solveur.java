import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solveur {
	

    private int nbAnimaux;
    private int nbAnimauxEnclos;
    private float beneficeTotal;
    
    
    private ArrayList<Animal> listeAnimaux;
    private ArrayList<Enclos> listeEnclos;
    
    
	public ArrayList<Animal> getListeAnimaux(){return listeAnimaux;} 
	public ArrayList<Enclos> getListeEnclos(){return listeEnclos;} 



	public Solveur(int nbEnclos, String nomFichierReservation) {
		
		
		listeAnimaux = new ArrayList<Animal>();
		
		init("src/"+nomFichierReservation);
       
		this.nbAnimaux = listeAnimaux.size();
		
        this.listeEnclos = remplirListeEnclos(listeAnimaux, nbEnclos);
        this.beneficeTotal = calculerBeneficeTotal(listeEnclos);
        this.nbAnimauxEnclos = calculerNbAnimaux(listeEnclos);   
	}

	
	
	public int getNbAnimauxEnclos() {
		return nbAnimauxEnclos;
	}
	public int getNbAnimaux() {
		return nbAnimaux;
	}
	public float getBeneficeTotal() {
		return beneficeTotal;
	}
	
	
	private float calculerBeneficeTotal(ArrayList<Enclos> listeEnclos2) {
		
		float benef = 0;
		
		for( Enclos e : listeEnclos2) {
			benef += e.getBeneficeEnclos();	
		}
		return benef;
	}
	
	
	private int calculerNbAnimaux(ArrayList<Enclos> listeEnclos2) {
		
		int nbAnimauxEnclos = 0;
		
		for(Enclos e : listeEnclos2) {
			nbAnimauxEnclos += e.getListeAnimaux().size();
		}
		return nbAnimauxEnclos;
	}
	
	
	private ArrayList<Enclos> remplirListeEnclos(ArrayList<Animal> listeAnimaux, int nbEnclos){
		
		
		ArrayList<Enclos> listeEnclos = new ArrayList<Enclos>();
		
        for(int i = 0; i<nbEnclos; i++) {
        	
        	
            Enclos enclosTempChats = new Enclos(trierTopAnimaux("cat", 4 , listeAnimaux));
    		Enclos enclosTempChiens = new Enclos(trierTopAnimaux("dog", 2 , listeAnimaux));	  		// On remplit nos enclos temporaires avec les animaux restants dans la liste qui valent le plus de bénéfice pour chaque type d'animal
            Enclos enclosTempChevaux = new Enclos(trierTopAnimaux("horse", 1 , listeAnimaux));
  	

        	if ((enclosTempChats.getBeneficeEnclos() < enclosTempChiens.getBeneficeEnclos()) && (enclosTempChevaux.getBeneficeEnclos() < enclosTempChiens.getBeneficeEnclos())){
        		
        		enclosTempChiens.setId(i+1);
        		listeEnclos.add(enclosTempChiens);
        		listeAnimaux = trimAnimaux(listeAnimaux, enclosTempChiens.getListeAnimaux());		// On compare quel type d'animal vaut le plus, et on le rajoute dans un enclos en le supprimant de la liste d',animaux
        		
        		
        	}else if (enclosTempChats.getBeneficeEnclos() < enclosTempChevaux.getBeneficeEnclos()){
        		enclosTempChevaux.setId(i+1);
        		listeEnclos.add(enclosTempChevaux);
        		listeAnimaux = trimAnimaux(listeAnimaux, enclosTempChevaux.getListeAnimaux());
        		
        		
        	}else {
        		enclosTempChats.setId(i+1);
        		listeEnclos.add(enclosTempChats);
        		listeAnimaux = trimAnimaux(listeAnimaux, enclosTempChats.getListeAnimaux());
        	}
        }
			return listeEnclos;
	}
	
	
	
	private static ArrayList<Animal> trimAnimaux(ArrayList<Animal> listeAnimaux, ArrayList<Animal> listeToTrim) {
		
		for (int i = (listeAnimaux.size()-1); i>-1 ; i--) {
			
			for (Animal a : listeToTrim) {												//On retire de la liste les membres passés en paramètre
				listeAnimaux.remove(a);		
			}
		}
		return listeAnimaux;
	}
	
	
	
	private  ArrayList<Animal> trierTopAnimaux(String nom, int maxParEnclos, ArrayList<Animal> listeAnimauxTri){
		
		boolean estDedans;
		ArrayList<Animal> listeTriee = new ArrayList<Animal>();		
			
		for (Animal a : listeAnimauxTri) {
			
			estDedans = false;

			  if (a.getNom().equals(nom)) {    											//On verifie que c'est le bon animal
				  
				 if (listeTriee.isEmpty()) {											
 
					  listeTriee.add(a);												//on commence la liste avec le premier animal valide 
				  				  					  					  
				  }else {
					  for(int j = 0; j<=(listeTriee.size()-1); j++) {						  
						  							
						  if(!estDedans && !a.equals(listeTriee.get(j))) {				//On vérifie que l'animal ne fait pas déjà parti de la liste triée	
							  if (a.getBenefice()>(listeTriee.get(j).getBenefice())) {  //On vérifie si l'animal vaut plus de bénefice que ceux déjà présent dans la liste
								  														//On rajoute le nouvel animal qui vaut plus à l'index de celui dont il vaut plus
								  listeTriee.add(j, a);									// La liste va donc se décaler (en incrémentation)
								  estDedans=true;
								  if (listeTriee.size()>=(maxParEnclos+1)) {
									  
									  listeTriee.remove(maxParEnclos);					// On retire le membre qui vaut le moins si la liste était complète	  
								  }
								  
							  }else if(maxParEnclos > listeTriee.size()) {				// Si la liste n'est pas de la taille max on rajoute d'office l'animal à la fin de la liste si il ne vaut pas plus que ceux déjàa présent dans la liste
								  														// Cela permet que tous les animaux de ce type soient comparés les uns aux autres
								  listeTriee.add(a);
								  estDedans=true;							  
							  }
						  }else {estDedans=true;}  
					  }
				  }
			  }		
		}
		return listeTriee;
	}
	
	 public static Animal getAnimalDepuisLigne(String ligne){  							// récuperé dans la correction de l'exercice du cours 12
		  
	        Animal monAnimal ; 
	        String[] split = ligne.split(";");
	        int id = Integer.parseInt(split[0]);
	        String type = split[1];
	        float poids = Float.parseFloat(split[2]);

	        if(type.contains("cat")){
	            boolean estRace = (split[3].equals("True"));
	            monAnimal = new Chat(id, poids, type, estRace);  
	        }else if(type.contains("dog")){
	            String age = split[3];
	            monAnimal = new Chien(id, poids, type, age);  
	        }else{
	            String cout =split[3];
	            monAnimal = new Cheval(id, poids, type, cout); 
	        }
	        return monAnimal;
	    }
	
    public void init(String filename) 													// récuperé dans la correction de l'exercice du cours 12
    { 
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Animal nouvelAnimal = getAnimalDepuisLigne(data);
                listeAnimaux.add(nouvelAnimal);
            }
            myReader.close();
         } catch (FileNotFoundException e) {
              System.out.println("An error occurred.");
              e.printStackTrace();
         }


    } 

}
