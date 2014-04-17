package CommonSource;

public class Organism {
    protected String name;
    
    public Organism(String name){
        this.name = name;
    }

    public void metabolism(){
        System.out.println("All living matter undergoes a process of metabolism.");
    }

    public void heredity(){
        System.out.println("Heredity is the passing of traits to offspring from its parents or ancestor.");
    }

    public void myName(){
        System.out.println("My name is " + this.name + ".");
    }

    public void move(){
        System.out.println("Maybe I can move.");
    }
}
