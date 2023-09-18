
public class Horse extends Animal {
    public Horse(int weight, int speed) {
        super(weight, speed, 2, null);
    }

    @Override
    public void eat() {
        System.out.println("Horse is eating");
    }

    @Override
    public Animal reproduce() {
        return new Horse(weight, speed);
    }
}
