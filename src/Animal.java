import java.util.Random;

public abstract class Animal implements Runnable {

    protected int weight;
    protected int speed;
    protected int cellsPerMove;
    protected int x;
    protected int y;
    protected Island island;

    public Animal(int weight, int speed, int cellsPerMove, Island island) {
        this.weight = weight;
        this.speed = speed;
        this.cellsPerMove = cellsPerMove;
        this.island = island;
        this.x = 0;
        this.y = 0;
    }

    public abstract void eat();

    public abstract Animal reproduce();

    public void move() {
        Random random = new Random();
        int moveCells = random.nextInt(cellsPerMove) + 1;

        for (int i = 0; i < moveCells; i++) {
            int newX = x;
            int newY = y;
            while (newX == x && newY == y) {
                newX = x + random.nextInt(3) - 1;
                newY = y + random.nextInt(3) - 1;
                if (newX < 0 || newX >= island.getWidth() || newY < 0 || newY >= island.getHeight()) {
                    newX = x;
                    newY = y;
                }
            }
            x = newX;
            y = newY;
        }
    }

    public int getWeight() {
        return weight;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(500);
                move();
                eat();
                reproduce();
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
