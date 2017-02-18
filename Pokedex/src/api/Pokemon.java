package api;

public class Pokemon {
	
	private String name;
    private String HP;
    private String elementary;
    private String attack;
    private String damage;
    private String weight;
    private String length;
    private String pathPic;
    private String weakness;

    public Pokemon(String name, String HP, String elementary, String attack, String damage, String weight, 
    			   String length, String pathPic, String weakness) {
    	
            this.name = name;
            this.HP = HP;
            this.elementary = elementary;
            this.attack = attack;
            this.damage = damage;
            this.weight = weight;
            this.length = length;
            this.pathPic = pathPic;
            this.weakness = weakness;
    }

    public String getName() {
    	return this.name;
    }
    
    public String getHP() {
    	return this.HP;
    }
    
    public String getElementary() {
    	return this.elementary;
    }
    
    public String getAttack() {
    	return this.attack;
    }
    
    public String getDamage() {
    	return this.damage;
    }
    
    public String getWeight() {
    	return this.weight;
    }
    
    public String getLength() {
    	return this.length;
    }
    
    public String getPathPic() {
    	return this.pathPic;
    }
    
    public String getWeakness() {
    	return this.weakness;
    }

     
}
