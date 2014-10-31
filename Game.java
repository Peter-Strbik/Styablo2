import java.util.Scanner;
import java.util.Random;

public class Game{
    
    public static void main(String[]args){
	System.out.println("Welcome to Styablo \n");
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	if (isParty()){
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    Adventurer[] party = createParty();
	    Adventurer opponent = oppoPartySelClass();
	    combatparty(party, opponent);
	    
	}
	else{
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    Adventurer player = userSelClass();
	    Adventurer opponent = oppoSelClass();
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    combat(player, opponent);
	}
    }

    public static Adventurer[] createParty(){
	Scanner in = new Scanner(System.in);
	Adventurer[] party = new Adventurer[4];
	System.out.println("Would you like to: \nA. Create a party of Adventurers? \nB. Use a default party?");
	String sel = "";
	while (!sel.equalsIgnoreCase("a") && !sel.equalsIgnoreCase("b")){
	    sel = in.nextLine();
	    if (!sel.equalsIgnoreCase("a") && !sel.equalsIgnoreCase("b")){
		System.out.println("Invalid input. Please select again.");
	    }
	}
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println();
	if (sel.equalsIgnoreCase("a")){
	    for (int i = 0; i < party.length; i++){
		party[i] = userSelClass();
	    }
	}
	else if (sel.equalsIgnoreCase("b")){
	    party[0] = new Warrior("Ralph");
	    party[1] = new Wizard("Gandolf");
	    party[2] = new Rogue("Slash");
	    party[3] = new MartialArtist("Bruce Lee");
	}
	return party;
    }

    public static boolean isParty(){
	boolean res = false;
	Scanner input = new Scanner(System.in);
	System.out.println("Would you like to play with: \nA. A Single Adventurer \nB. A party of Adventurers");
	String choice = "";
	while(!choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("b")){
	    choice = input.nextLine();
	    if (!choice.equalsIgnoreCase("a") && !choice.equalsIgnoreCase("b")){
		System.out.println("Invalid input. Please select again.");
	    }
	}
	System.out.println();
	if (choice.equalsIgnoreCase("a")){
	    res = false;
	}
	else if (choice.equalsIgnoreCase("b")){
	    res = true;
	}
	return res;
    }

    public static void setStats(Adventurer player, int statPoints){
	int left = statPoints;
	int STRPoints, INTPoints;
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nYou have " + statPoints + " points to allocate to stats. \n");
	Scanner in1 = new Scanner(System.in);
	try {
	    Thread.sleep(250);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println("How many points would you like to allocate to Strength?");
	do{
	    System.out.println("Please input a number greater than 0 but less than the points you have left to allocate.");
	    STRPoints = in1.nextInt();
	}while(STRPoints <= 0 || STRPoints > left);
	player.setStrength(STRPoints);
	left -= STRPoints;
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nYou now have " + left + " points left to allocate.\n \nHow many points would you like to allocate to Intelligence?");
	do{
	    System.out.println("Please input a number greater than 0 but less than the points you have left to allocate.");
	    INTPoints = in1.nextInt();
	}while(INTPoints <= 0 || INTPoints > left);
	player.setIntelligence(INTPoints);
	left -= INTPoints;
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println("\nThe rest of the points will be allocated to Dexterity.");
	player.setDexterity(left);
    }
    
    public static Adventurer userSelClass(){	
	Adventurer player = null;
	Scanner in = new Scanner(System.in);
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println("Choose a class for this player: \n" + "a. Warrior \n" + "b. Wizard \n" + "c. Rogue \n" + "d. Martial Artist");
	String line = "";
	while (!line.equalsIgnoreCase("a") && !line.equalsIgnoreCase("b") && !line.equalsIgnoreCase("c") && !line.equalsIgnoreCase("d")){
	    line = in.nextLine();
	    if	(!line.equalsIgnoreCase("a") && !line.equalsIgnoreCase("b") && !line.equalsIgnoreCase("c") && !line.equalsIgnoreCase("d")){
		System.out.println("Invalid input. Please select again.");
	    }
	}
	try {
	    Thread.sleep(500);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println();
	if (line.equalsIgnoreCase("a")){
	    System.out.println("Type a name for your Warrior:");
	    String lineA = in.nextLine();
	    player = new Warrior(lineA);
	}
	else if (line.equalsIgnoreCase("b")){
	    System.out.println("Type a name for your Wizard:");
	    String lineB = in.nextLine();
	    player = new Wizard(lineB);
	}
	else if (line.equalsIgnoreCase("c")){
	    System.out.println("Type a name for your Rogue:");
	    String lineC = in.nextLine();
	    player = new Rogue(lineC);
	}
	else if (line.equalsIgnoreCase("d")){
	    System.out.println("Type a name for your Martial Artist:");
	    String lineD = in.nextLine();
	    player = new MartialArtist(lineD);
	}
	//Reset Stats to 1 before user selects stats
	player.setStrength(1);
	player.setIntelligence(1);
	player.setDexterity(1);
	
	setStats(player, 40);
	return player;
    }

    public static Adventurer oppoSelClass(){
	Random rand1 = new Random(System.currentTimeMillis());
	int Oppo = rand1.nextInt(4);
	Adventurer opponent = null;
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	if (Oppo == 0){
	    System.out.println("\nYour opponent is the warrior Sasuke \n");
	    opponent = new Warrior();
	}
	else if (Oppo == 1){
	    System.out.println("\nYour opponent is the wizard Tim \n");
	    opponent = new Wizard();
	}
        else if (Oppo == 2){
	    System.out.println("\nYour opponent is the rogue Chaos \n");
	    opponent = new Rogue();           
	}
	else if (Oppo == 3){
	    System.out.println("\nYour opponent is the martial artist Chuck \n");
	    opponent = new MartialArtist();
	}
	return opponent;
    }

    public static Adventurer oppoPartySelClass(){
	Adventurer opponent = oppoSelClass();
	opponent.setHP(300);
	return opponent;
    }
    
	//Action sequence
    public static void combat(Adventurer player, Adventurer opponent){
	Random rand2 = new Random(System.currentTimeMillis());
	Scanner in = new Scanner(System.in);
	String playerSel = "";
	while (player.getHP() > 0 && opponent.getHP() > 0){
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("*****************NEW ROUND***************** \n");
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("********************YOU******************** \n");
	    try {
		Thread.sleep(500);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println(player);
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("******************OPPONENT***************** \n");
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println(opponent);
	    boolean first = rand2.nextBoolean();
	    //Player attacks first
	    if (first){
		System.out.println("You attack first this round. \n");
		try {
		    Thread.sleep(250);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Choose your course of action: \n" + "a. Attack \n" + "b. Special Attack \n" + "c. Commit Seppuku");
		while (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
		    playerSel = in.nextLine();
		    if (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
			System.out.println("Invalid input. Please select again.");
		    }
		}
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println();
		if (playerSel.equals("a")){
		    System.out.println("\n" + player.getName() + ":");
		    player.attack(opponent);
		}
		else if (playerSel.equals("b")){
		    System.out.println("\n" + player.getName() + ":");
		    player.specialAttack(opponent);
		}
		else if(playerSel.equals("c")){
		    player.setHP(0);
		    System.out.println("\n You commited Seppuku \n");
		}
		else{}

		if (player.getHP() <= 0 || opponent.getHP() <= 0){
		    break;
		}
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		boolean OppoSel = rand2.nextBoolean();
		if (OppoSel){
		    System.out.println("\n" + opponent.getName() + ":");
		    opponent.specialAttack(player);
		}
		else{
		    System.out.println("\n" + opponent.getName() + ":");
		    opponent.attack(player);
		}
	    }
	    //Opponent attacks first
	    else{

		System.out.println("Your opponent attacks first this round.");
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}

		boolean OppoSel = rand2.nextBoolean();
		if (OppoSel){
		    System.out.println(opponent.getName() + ":");
		    opponent.specialAttack(player);
		}
		else{
		    System.out.println(opponent.getName() + ":");
		    opponent.attack(player);
		}

		if (player.getHP() <= 0 || opponent.getHP() <= 0){
		    break;
		}
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		
		System.out.println("Choose your course of action: \n" + "a. Attack \n" + "b. Special Attack \n" + "c. Commit Seppuku");
		while (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
		    playerSel = in.nextLine();
		    if (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
			System.out.println("Invalid input. Please select again.");
		    }
		}
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		if (playerSel.equals("a")){
		    System.out.println(player.getName() + ":");
		    player.attack(opponent);
		}
		else if (playerSel.equals("b")){
		    System.out.println(player.getName() + ":");
		    player.specialAttack(opponent);
		}
		else if (playerSel.equals("c")){
		    player.setHP(0);
		    System.out.println("You commited Seppuku");
		}
		else{}
	    }
	    
	    playerSel = "";
	}
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}

	//Result once fight is over
	if (player.getHP() <= 0){
	    System.out.println("YOU LOSE.");
	}
	else{
	    System.out.println("YOU WIN.");
	}
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	String playAgain = "";
	System.out.println("Would you like to fight another opponent:\nA. Yes \nB. No");
	while(!playAgain.equalsIgnoreCase("a") && !playAgain.equalsIgnoreCase("b")){
	    playAgain = in.nextLine();
	    if (!playAgain.equalsIgnoreCase("a") && !playAgain.equalsIgnoreCase("b")){
		System.out.println("Invalid input. Please select again.");
	    }
	}
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println();
	if (playAgain.equalsIgnoreCase("a")){
	    Adventurer newplayer = player.reset(player.getName(), player.getStrength(), player.getIntelligence(), player.getDexterity());
	    Adventurer newOpponent = oppoSelClass();
	    combat(newplayer, newOpponent);
	}
	else{
	    System.out.println("Hope to see you fight another day");
	}
    }

    public static boolean isPartyAlive(Adventurer[] party){
	boolean[] alive = new boolean[party.length];
	for (int i = 0; i < party.length; i++){
	    alive[i] = party[i].getAlive();
	}
	return alive[0] || alive[1] || alive[2] || alive[3];
    }    
    
    public static void combatparty(Adventurer[] user, Adventurer opponent){
	Random rand2 = new Random(System.currentTimeMillis());
	Scanner in = new Scanner(System.in);
	String playerSel = "";
	while(isPartyAlive(user) && opponent.getHP() > 0){
	    boolean first = rand2.nextBoolean();
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("*****************NEW ROUND***************** \n");
	    try {
	    Thread.sleep(1000);
	    }
	    catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("*****************YOUR TEAM***************** \n");
	    for (int j = 0; j < user.length; j++){
		System.out.println(user[j] + "\n");
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	    }
	    System.out.println("*****************OPPONENT****************** \n");
	    System.out.println(opponent);

	    if (first){
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("You attack first this round. \n");
		try {
		    Thread.sleep(250);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		for(int i = 0; i < user.length; i++){
		    if (user[i].getAlive()){
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println("Choose a course of action for " + user[i].getName() + ": \n" + "a. Attack \n" + "b. Special Attack \n" + "c. Commit Seppuku");
			while (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
			    playerSel = in.nextLine();
			    if (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
				System.out.println("Invalid input. Please select again.");
			    }
			}
			System.out.println();
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			if (playerSel.equals("a")){
			    System.out.println("\n" + user[i].getName() + ":");
			    user[i].attack(opponent);
			}
			else if (playerSel.equals("b")){
			    System.out.println("\n" + user[i].getName() + ":");
			    user[i].specialAttack(opponent);
			}
			else if(playerSel.equals("c")){
			    user[i].setHP(0);
			    System.out.println("\n" + user[i].getName() + " commited Seppuku \n");
			    user[i].setAlive(false);
			}
			else{}
			
			playerSel = "";
		    }
		    else{
			System.out.println(user[i].getName() + " is dead and cannot attack. \n");
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		    }
		}
		if (!isPartyAlive(user) || opponent.getHP() <= 0){
		    break;
		}


		boolean OppoAttackSel = rand2.nextBoolean();
		int OppoPlayerSel = rand2.nextInt(4);
		boolean hasAttacked = false;
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		while(!hasAttacked){
		    if (!user[OppoPlayerSel].getAlive()){
			OppoPlayerSel = rand2.nextInt(4);
		    }
		    else if(user[OppoPlayerSel].getAlive()){
			if (OppoAttackSel){
			    System.out.println(opponent.getName() + ":"); 
			    opponent.specialAttack(user[OppoPlayerSel]);
			    hasAttacked = true;
			}
			else{
			    System.out.println(opponent.getName() + ":");
			    opponent.attack(user[OppoPlayerSel]);
			    hasAttacked = true;
			}
		    }
		}
		hasAttacked = false;
		if (!isPartyAlive(user) || opponent.getHP() <= 0){
		    break;
		}
	    }
	    else{
		try {
		    Thread.sleep(1000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		System.out.println("Your opponent attacks first this round. \n");
		boolean OppoAttackSel = rand2.nextBoolean();
		int OppoPlayerSel = rand2.nextInt(4);
		boolean hasAttacked = false;
		try {
		    Thread.sleep(500);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		while(!hasAttacked){
		    if (!user[OppoPlayerSel].getAlive()){
			OppoPlayerSel = rand2.nextInt(4);
		    }
		    else if(user[OppoPlayerSel].getAlive()){
			if (OppoAttackSel){
			    System.out.println(opponent.getName() + ":"); 
			    opponent.specialAttack(user[OppoPlayerSel]);
			    hasAttacked = true;
			}
			else{
			    System.out.println(opponent.getName() + ":");
			    opponent.attack(user[OppoPlayerSel]);
			    hasAttacked = true;
			}
		    }
		}
		hasAttacked = false;
		if (!isPartyAlive(user) || opponent.getHP() <= 0){
		    break;
		}
		for(int i = 0; i < user.length; i++){
		    if (user[i].getAlive()){
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println("Choose a course of action for " + user[i].getName() + ": \n" + "a. Attack \n" + "b. Special Attack \n" + "c. Commit Seppuku");
			while (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
			    playerSel = in.nextLine();
			    if (!playerSel.equals("a") && !playerSel.equals("b") && !playerSel.equals("c")){
				System.out.println("Invalid input. Please select again.");
			    }
			}
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println();			
			if (playerSel.equals("a")){
			    System.out.println(user[i].getName() + ":");
			    user[i].attack(opponent);
			}
			else if (playerSel.equals("b")){
			    System.out.println(user[i].getName() + ":");
			    user[i].specialAttack(opponent);
			}
			else if(playerSel.equals("c")){
			    user[i].setHP(0);
			    System.out.println(user[i].getName() + " commited Seppuku \n");
			    user[i].setAlive(false);
			}
			else{}

			playerSel = "";
		    }
		    else{
			System.out.println(user[i].getName() + " is dead and cannot attack. \n");
			try {
			    Thread.sleep(1000);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
		    }
		}
		if (!isPartyAlive(user) || opponent.getHP() <= 0){
		    break;
		}

	    }
	}
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	if (isPartyAlive(user)){
	    System.out.println("YOU WIN!");
	}
	else{
	    System.out.println("YOU LOSE!");
	}
	String playAgain = "";
	System.out.println("Would you like to fight another opponent:\nA. Yes \nB. No");
	while(!playAgain.equalsIgnoreCase("a") && !playAgain.equalsIgnoreCase("b")){
	    playAgain = in.nextLine();
	    if (!playAgain.equalsIgnoreCase("a") && !playAgain.equalsIgnoreCase("b")){
		System.out.println("Invalid input. Please select again.");
	    }
	}
	try {
	    Thread.sleep(1000);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	System.out.println();	
	if (playAgain.equalsIgnoreCase("a")){
	    healparty(user);
	    Adventurer newOpponent = oppoPartySelClass();
	    System.out.println("Your party has been healed. Prepare for another battle. \n");
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    combatparty(user, newOpponent);
	}
	else{
	    try {
		Thread.sleep(1000);
	    } catch(InterruptedException ex) {
		Thread.currentThread().interrupt();
	    }
	    System.out.println("Hope to see you fight another day");
	}
    }

    public static void healparty(Adventurer[] party){
	for (int i = 0; i < party.length; i++){
	    party[i] = party[i].reset(party[i].getName(), party[i].getStrength(), party[i].getIntelligence(), party[i].getDexterity());
	}
    }
}
