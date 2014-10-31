public class MartialArtist extends Adventurer{
    public int Qi;

    public MartialArtist(){
	setName("Chuck");
	setStrength(15);
	setIntelligence(9);
	setDexterity(15);
	setQi(25);
    }

    public MartialArtist(String n){
	super(n);
	setStrength(15);
	setIntelligence(9);
	setDexterity(15);
	setQi(25);
    }

    public void setQi(int q){
	Qi = q;
    }

    public int getQi(){
	return Qi;
    }

    public void attack(Adventurer other){
	if (hit(other)){
	    other.setHP(other.getHP() - this.getStrength());
	    System.out.println(other.getName() + " smacked for " + this.getStrength() + " damage by " + this.getName() + "\n");
	}
	else{
	    System.out.println("Attack missed. \n");
	}
    }

    public void specialAttack(Adventurer other){
	if (Qi >= 6){
	    if (hitSpecial(other)){
		other.setHP(other.getHP() - (3 * this.getStrength()));
		System.out.println(other.getName() + " hit with nunchaku for " + (3 * this.getStrength()) + " damage by " + this.getName() + "\n");
		setQi(this.getQi() - 6);
	    }
	    else{
		setQi(this.getQi() - 6);
		System.out.println("Attack missed. \n");
	    }
	}
	else{
	    System.out.println("Not enough Qi. \n");
	    this.attack(other);
	}	
    }

    public Adventurer reset(String name, int STR, int INT, int DEX){
	Adventurer healed = new MartialArtist(name);
	this.setStrength(STR);
	this.setIntelligence(INT);
	this.setDexterity(DEX);
	return healed;
    }    
}
    
