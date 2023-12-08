public class Dog extends Animal implements IAnimal, IWalkAnimal {
    private String name;
    private String type;
    @Override
    public void say() {
        System.out.println("Dog bark");
    }
    @Override
    public void eat() {
        System.out.println("Dog eat");
    }
    @Override
    public void walk() {
        System.out.println("Dog walk");
    }
    public Dog(String type, String name, double height, double weight) {
        super(weight, height);
        this.name = name;
        this.type = type;
    }
    public String getName() { return name; }
    public String getType() { return type; }
    
    public void setType(String type) { this.type = type; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Name: " + name + ", type: " + type + ", " + super.toString();
    }
    @Override
    public void makeNoise() {
        System.out.println("Dog make noise");
    }
}
