
public class Rabbit extends Animal {
    public Rabbit(int weight, int speed) {
        super(weight, speed, 1, null);
    }

    @Override
    public void eat() {
        System.out.println("Rabbit is eating");
    }

    @Override
    public Animal reproduce() {
        return new Rabbit(weight, speed);
    }
}
