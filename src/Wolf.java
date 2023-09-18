
public class Wolf extends Animal {
    public Wolf(int weight, int speed) {
        super(weight, speed, 3, null);
    }

    @Override
    public void eat() {
        if(island.animalExists(x,y,Rabbit.class)&&Math.random()<0.6){
            island.removeAnimal(island.getAnimal(x,y,Rabbit.class));
            System.out.println("Wolf is eating a rabbit");
        }
    }

    @Override
    public Animal reproduce() {
        return new Wolf(weight, speed);
    }
}
