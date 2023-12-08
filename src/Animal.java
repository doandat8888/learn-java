public abstract class Animal {
    protected double weight;
    protected double height;
    public Animal(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    public double getWeight() { return weight; }
    public double getHeight() { return height; }

    public double setWeight() { return weight; }
    public double setHeight() { return height; }
    
    public abstract void makeNoise();
    @Override
    public String toString() {
        return "weight: " + weight + ", height: " + height;
    }
}
