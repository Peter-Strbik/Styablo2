import java.util.Random;

abstract class Adventurer{
    private String name;
    private int HP, Strength, Intelligence, Dexterity;
    private boolean alive;

    Random rand = new Random();
    
    public Adventurer(){
	setName("Lester");
	setHP(75);
	setStrength(13);
	setIntelligence(13);
	setDexterity(13);
	setAlive(true);
	
    }

    public Adventurer(String n){
	this();
	setName(n);
    }

    public void setName(String n){
	name = n;
    }

    public String getName(){
	return name;
    }

    public void setHP(int h){
	HP = h;
    }

    public int getHP(){
	return HP;
    }

    public void setAlive(boolean a){
	alive = a;
    }

    public boolean getAlive(){
	return alive;
    }

    public void setStrength(int s){
	Strength = s;
    }

    public int getStrength(){
	return Strength;
    }

    public void setIntelligence(int i){
	Intelligence = i;
    }

    public int getIntelligence(){
	return Intelligence;
    }

    public void setDexterity(int d){
	Dexterity = d;
    }    

    public int getDexterity(){
	return Dexterity;
    }
    
    abstract void attack(Adventurer other);

    abstract void specialAttack(Adventurer other);

    public boolean hit(Adventurer other){
	return rand.nextInt(this.getDexterity() + other.getDexterity()) < this.getDexterity();
    }

    public boolean hitSpecial(Adventurer other){
	return rand.nextInt(this.getDexterity() + other.getDexterity()) < (this.getDexterity() - 5);
    }
    
    public String toString(){
	return "Name: " + name + "\n" + "HP: " + HP + "\n";
    }

    public String getStats(){
	return getName() + " HP" + getHP() + " STR" + getStrength() + " INT" + getIntelligence() + " DEX" + getDexterity();
    }

    abstract Adventurer reset(String name, int STR, int INT, int DEX);
	
}
