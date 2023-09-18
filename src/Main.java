import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 1 размер острова: ");
        int razmer = sc.nextInt();
        System.out.println("Введите 2 размер острова: ");
        int razmer2 = sc.nextInt();
        Island island = new Island(razmer, razmer2);
        for (int i = 0; i < 10; i++) {
            island.addAnimal(new Horse(50,5));
            island.addAnimal(new Rabbit(10, 10));
            island.addAnimal(new Cow(100, 3));

        }
        for (int i = 0; i < 5; i++) {
            island.addAnimal(new Wolf(80, 8));
//            island.addAnimal(new Bear(200, 4));
//            island.addAnimal(new Fox(30, 6));
        }

        int numberOfSteps = 100;
        for (int i = 0; i < numberOfSteps; i++) {
            island.printStatistics();
            island.moveAnimals();
            island.reproduceAnimal();
            island.eatPrey();
        }

        try {
            Thread.sleep(15000);
        } catch (InterruptedException e){
            System.out.println("Программа стоп");
        }
    }
}