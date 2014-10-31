public class Rogue extends Adventurer{
    private int stamina;

    public Rogue(){
	setName("Chaos");
	setStrength(9);
	setIntelligence(11);
	setDexterity(20);
	setStamina(10);
    }

    public Rogue(String n){
	super(n);
	setStrength(9);
	setIntelligence(11);
	setDexterity(20);
	setStamina(10);
    }

    public void setStamina(int s){
	stamina = s;
    }

    public int getStamina(){
	return stamina;
    }

    public void attack(Adventurer other){
	if (hit(other)){
	    other.setHP(other.getHP() - this.getStrength());
	    System.out.println(other.getName() + " slashed for " + this.getStrength() + " damage by " + this.getName() + "\n");
	}
	else{
	    System.out.println("Attack missed. \n");
	}
    }

    public void specialAttack(Adventurer other){
	if (stamina >= 5){
	    if (hitSpecial(other)){
		other.setHP(other.getHP() - (3 * this.getStrength()));
		System.out.println(other.getName() + " hit with sneak attack for " + (3 * this.getStrength()) + " damage by " + this.getName() + "\n");
		setStamina(this.getStamina() - 5);
	    }
	    else{
		setStamina(this.getStamina() - 5);
		System.out.println("Attack missed. \n");
	    }
	}
	else{
	    System.out.println("Not enough stamina. \n");
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
