import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Random;

public class Character {
	private int xCoord;
	private int yCoord;
	protected int health;
    protected int maxHealth;
    private String weapon = "";
    private TreeMap<String, ArrayList<Integer>> qResults;
    
    private int dir = 0;
    public static final int NORTH = 0, SOUTH = 2, EAST = 1, WEST = 3;

    public int xoff, yoff;

    private String imagePath = "assets/WGSpriteP1";

    public Character(String imagepath, Random r) {		
		xCoord = 0;
		yCoord = 0;
		xoff = r.nextInt(120);
		yoff = r.nextInt(40);
		health = 20;
		maxHealth = health;
		imagePath = imagepath;
		qResults = new TreeMap<String, ArrayList<Integer>>();
	}	

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yC) {
		yCoord = yC;
	}

	public void setxCoord(int xC) {
		xCoord = xC;
	}

    public String getImagePath(){
	switch(dir){
	case Character.NORTH:
	    return imagePath+"Back1.png";
	    
	case Character.SOUTH:
	    return imagePath+"Front1.png";
	    
	case Character.EAST:
	    return imagePath+"Right1.png";
	    
	case Character.WEST:
	    return imagePath+"Left1.png";
	    
	
	}
	return imagePath;
	    
    }

    public void setDir(int k)
    {
	if(0 <= k && k <= 3)
	    dir = k;
	else
	    System.out.println(k+" is not a valid direction number"); 
    }

    public int getDir(){ return dir; }
    
    public void setImagePath(String newImagePath){
    	this.imagePath = newImagePath;
    }
    
    public int getHealth() {
    	return health;
    }

    public int getMaxHealth() {
	return maxHealth;
    }
    
    public void setHealth(int newHealth) {
    	health = newHealth;
    }

    public void loseHealth(boolean s) {
	if(weapon.equals("Shield"))
	    health--;
	else
	    health -= 2;
    }
	
	public void setWeapon(String w){
	    weapon = w;
	}
	public String getWeapon(){
	    return weapon;
	}

    public void updateResults(String oppName, boolean correct) {
    	//If player has not encountered this opponent, add them to the results.
    	if (qResults.containsKey(oppName) == false) {
    		qResults.put(oppName, new ArrayList<Integer>());
    		qResults.get(oppName).add(0);
    		qResults.get(oppName).add(0);
    	}
    	//qResults[0] = Correct answers
    	//qResults[1] = Total questions answered of type
    	//If question is answered correctly, increment correct answers
    	if (correct == true) {
    		qResults.get(oppName).set(0, qResults.get(oppName).get(0) + 1);
    	}
    	//Always increment total questions answered
		qResults.get(oppName).set(1, qResults.get(oppName).get(1) + 1);

    }
    
    public TreeMap<String, ArrayList<Integer>> getResults() {
    	return qResults;
    }
}
