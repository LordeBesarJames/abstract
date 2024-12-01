abstract class MakhlukHidup {
    protected int posisiX;
    protected int posisiY;

    public MakhlukHidup(int x, int y) {
        this.posisiX = x;
        this.posisiY = y;
    }

    abstract void bergerak();

    public void tampilkanPosisi() {
        System.out.println("Posisi: (" + posisiX + ", " + posisiY + ")");
    }

    public int getPosisiX() {
        return posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }
}

class Rabbit extends MakhlukHidup {
    public Rabbit(int x, int y) {
        super(x, y);
    }

    @Override
    void bergerak() {
        posisiX += (Math.random() < 0.5) ? 1 : -1;
        posisiY += (Math.random() < 0.5) ? 1 : -1;

        // Pastikan tidak keluar dari grid
        posisiX = Math.max(0, Math.min(posisiX, Main.GRID_SIZE - 1));
        posisiY = Math.max(0, Math.min(posisiY, Main.GRID_SIZE - 1));

        System.out.println("Rabbit bergerak.");
    }
}

class Fox extends MakhlukHidup {
    public Fox(int x, int y) {
        super(x, y);
    }

    @Override
    void bergerak() {
        posisiX += (Math.random() < 0.5) ? 2 : -2;
        posisiY += (Math.random() < 0.5) ? 2 : -2;

        // Pastikan tidak keluar dari grid
        posisiX = Math.max(0, Math.min(posisiX, Main.GRID_SIZE - 1));
        posisiY = Math.max(0, Math.min(posisiY, Main.GRID_SIZE - 1));

        System.out.println("Fox bergerak.");
    }
}

public class Main {
    public static final int GRID_SIZE = 10; // Grid ukuran 10x10

    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit(0, 0);
        Fox fox = new Fox(5, 5);

        System.out.println("Posisi awal:");
        tampilkanGrid(rabbit, fox);

        for (int i = 0; i < 5; i++) {
            System.out.println("\nPergerakan ke-" + (i + 1) + ":");
            rabbit.bergerak();
            fox.bergerak();
            tampilkanGrid(rabbit, fox);
        }
    }

    private static void tampilkanGrid(Rabbit rabbit, Fox fox) {
        for (int y = 0; y < GRID_SIZE; y++) {
            for (int x = 0; x < GRID_SIZE; x++) {
                if (x == rabbit.getPosisiX() && y == rabbit.getPosisiY()) {
                    System.out.print("R "); // R untuk Rabbit
                } else if (x == fox.getPosisiX() && y == fox.getPosisiY()) {
                    System.out.print("F "); // F untuk Fox
                } else {
                    System.out.print(". "); // . untuk posisi kosong
                }
            }
            System.out.println();
        }
    }
}
