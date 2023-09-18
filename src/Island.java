import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Island {
    private int width;
    private int height;
    private List<Animal> animals;

    public Island(int width, int height) {
        this.width = width;
        this.height = height;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        Random random = new Random();
        int x = random.nextInt(width);
        int y = random.nextInt(height);
        animal.x = x;
        animal.y = y;
        animal.island = this; // не понятно пока
        animals.add(animal);
        Thread thread = new Thread(animal);
        thread.start();
    }

    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }

    public boolean animalExists(int x, int y, Class<? extends Animal> animalClass) {
        for (Animal animal : animals) {
            if (animal.getX() == x && animal.getY() == y && animal.getClass() == animalClass) {
                return true;
            }
        }
        return false;
    }

    public Animal getAnimal(int x, int y, Class<? extends Animal> animalClass) {
        for (Animal animal : animals) {
            if (animal.getX() == x && animal.getY() == y && animal.getClass() == animalClass) {
                return animal;
            }
        }
        return null;
    }

    public void moveAnimals() {
        for (Animal animal : animals) {
            animal.move();
        }
    }

    public void eatPrey() {
        for (Animal animal : animals) {
            animal.eat();
        }
    }

    public void reproduceAnimal() {
        List<Animal> newborns = new ArrayList<>();
        for (Animal animal : animals) {
            Animal newborn = animal.reproduce();
            int x = animal.getX();
            int y = animal.getY();
            int newX = x;
            int newY = y;
            while (newX == x && newY == y) {
                Random random = new Random();
                newX = x + random.nextInt(3) - 1;
                newY = y + random.nextInt(3) - 1;
                if (newX < 0 || newX >= width || newY < 0 || newY >= height) {
                    newX = x;
                    newY = y;
                }
            }
            newborn.x = newX;
            newborn.y = newY;
            newborn.island = this;
            newborns.add(newborn);
            Thread thread = new Thread(newborn);
            thread.start();
        }
        animals.addAll(newborns);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void printStatistics() {
        int horseCount = getAnimalCount(Horse.class);
        int rabbitCount = getAnimalCount(Rabbit.class);
        int cowCount = getAnimalCount(Cow.class);
        int wolfCount = getAnimalCount(Wolf.class);
//        int bearCount = getAnimalCount(Bear.class);
//        int foxCount = getAnimalCount(Fox.class);

        System.out.println("Horse count: " + horseCount);
        System.out.println("Rabbit count: " + rabbitCount);
        System.out.println("Cow count: " + cowCount);
        System.out.println("Wolf count: " + wolfCount);
//        System.out.println("Bear count: " + bearCount);
//        System.out.println("Fox count: " + foxCount);
    }


    private int getAnimalCount(Class<? extends Animal> animalClass) {
        int count = 0;
        for (Animal animal : animals) {
            if (animal.getClass() == animalClass) {
                count++;
            }
        }
        return count;
    }
}
