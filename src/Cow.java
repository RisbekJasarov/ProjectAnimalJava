
class Cow extends Animal {
    public Cow(int weight, int speed) {
        super(weight, speed, 2, null);
    }

    @Override
    public void eat() {
        System.out.println("Cow is eating");
    }

    @Override
    public Animal reproduce() {
        return new Cow(weight, speed);
    }
}
