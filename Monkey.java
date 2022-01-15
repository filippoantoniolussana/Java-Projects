
public class Monkey extends RescueAnimal {

    // Instance variable
    private float tailLength;
    private float height;
    private float bodyLength;
    private String species;
    private float torsoSize;
    private float skullSize;
    private float neckSize;
    

    // Constructor
    public Monkey() {
    }

    // Accessor Method
    public float getTailLength() {
        return tailLength;
    }
    
    public float getHeight() {
    	return height;
    }
    
    public float getBodyLength() {
    	return bodyLength;
    }
    
    public String getSpecies() {
    	return species;
    }
    
    public float getTorsoSize() {
    	return torsoSize;
    }
    
    public float getSkullSize() {
    	return skullSize;
    }
    
    public float getNeckSize() {
    	return neckSize;
    }

    
    // Mutator Method
    public void setTailLength(float tailLength) {
        this.tailLength = tailLength;
    }
    
    public void setHeight(float height) {
    	this.height = height;
    }
    
    public void setBodyLength(float bodyLength) {
    	this.bodyLength = bodyLength;
    }
    
    public void setSpecies(String species) {
    	this.species = species;
    }
    
    public void setTorsoSize(float torsoSize) {
    	this.torsoSize = torsoSize;
    }
    
    public void setSkullSize(float skullSize) {
    	this.skullSize = skullSize;
    }
    
    public void setNeckSize(float neckSize) {
    	this.neckSize = neckSize;
    }

}
