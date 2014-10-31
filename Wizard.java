public class Wizard extends Adventurer{
    private int mana;

    public Wizard(){
	setName("Tim");
	setStrength(8);
	setIntelligence(20);
	setDexterity(10);
	setMana(25);
    }

    public Wizard(String n){
	super(n);
	setStrength(8);
	setIntelligence(20);
	setDexterity(10);
	setMana(25);
    }

    public void setMana(int m){
	mana = m;
    }

    public int getMana(){
	return mana;
    }

    public void attack(Adventurer other){
	if (hit(other)){
	    other.setHP(other.getHP() - this.getStrength());
	    System.out.println(other.getName() + " poked for " + this.getStrength() + " damage by " + this.getName() + "\n");
	}
	else{
	    System.out.println("Attack missed. \n");
	}
    }

    public void specialAttack(Adventurer other){
	if (mana >= 8){
	    if (hitSpecial(other)){
		other.setHP(other.getHP() - (int)(1.5 * this.getIntelligence()));
		setMana(this.getMana() - 8);
		System.out.println(other.getName()+ " was hit with a magic attack for " +
				   (int)(1.5 * this.getIntelligence()) + " damage by " + this.getName()+ "\n");
	    }
	    else{
		setMana(this.getMana() - 8);
		System.out.println("Attack missed. \n");
	    }
	}
	else{
	    System.out.println("Not enough mana. \n");
	    this.attack(other);
	}
    }

    public boolean hitSpecial(Adventurer other){
	return rand.nextInt(this.getIntelligence() + other.getDexterity()) < this.getIntelligence();
    }

    public Adventurer reset(String name, int STR, int INT, int DEX){
	Adventurer healed = new MartialArtist(name);
	this.setStrength(STR);
	this.setIntelligence(INT);
	this.setDexterity(DEX);
	return healed;
    }       
}
