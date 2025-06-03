public class Pet {

    private String name;
    private int hunger;
    private int thirst;
    private int bladder;
 
    public Pet(String name) {
        this.name = name;
        hunger = 50;
        thirst = 1;
        bladder = 0;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getThirst() {
        return thirst;
    }

    public int getBladder() {
        return bladder;
    }

    // Setters
    public void setName(String newName) {
        name = newName;
    }

    public void setHunger(int hunger){
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    public void setBladder(int bladder) {
        this.bladder = bladder;
    }

}
