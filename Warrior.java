public class Warrior extends Adventurer{
    private int rage;

    public Warrior(){
	setName("Sasuke");
	setStrength(20);
	setIntelligence(5);
	setDexterity(15);
	setRage(5);
    }

    public Warrior(String n){
	super(n);
	setStrength(20);
	setIntelligence(5);
	setDexterity(15);
	setRage(5);
    }

    public void setRage(int r){
	rage = r;
    }

    public int getRage(){
	return rage;
    }

    public void attack(Adventurer other){
	if (hit(other)){
	    other.setHP(other.getHP() - this.getStrength());
	    System.out.println(other.getName() + " punched for " + this.getStrength() + " damage by " + this.getName() + "\n");
	}
	else{
	    System.out.println("Attack missed. \n");
	}
    }

    public void specialAttack(Adventurer other){
	if (hitSpecial(other)){
	    other.setHP(other.getHP() - (int)((.5 + (rage * .5)) * this.getStrength()));
	    System.out.println(other.getName() + " hit with rage attack for " + (int)((.5 + (rage * .5)) * this.getStrength()) + " damage by " + this.getName()+ "\n");
	    setRage(0);
	}
	else{
	    setRage(0);
	    System.out.println("Attack missed. \n");
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
