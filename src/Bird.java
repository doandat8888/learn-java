public class Bird extends Animal implements IAnimal, IFlyAnimal {
    private String type;
    private String name;
    @Override
    public void say() {
        System.out.println("Bird sing");
    }
    @Override
    public void eat() {
        System.out.println("Bird eat");
    }
    @Override
    public void fly() {
        System.out.println("Bird fly");
    }
    public Bird(String type, String name, int height, int weight) {
        super(weight, height);
        this.type = type;
        this.name = name;
    }
    public String getName() { return name; }
    public String getType() { return type; }
    @Override
    public void makeNoise() {
        System.out.println("Bird make noise");
    }
}
