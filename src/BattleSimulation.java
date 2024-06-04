import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BattleSimulation extends JPanel {
    private static final int TILE_SIZE = 40;
    private static final int BOARD_WIDTH = 10;
    private static final int BOARD_HEIGHT = 10;
    private AArmy[][] board = new AArmy[BOARD_WIDTH][BOARD_HEIGHT];
    private List<AArmy> armies = new ArrayList<>();
    private List<AArmy> armies2 = new ArrayList<>();
    private Random random = new Random();

    public BattleSimulation() {
        initializeBoard();
        Timer timer = new Timer(1000, e -> {
            moveUnits();
            repaint();
        });
        timer.start();
    }

    private void initializeBoard() {
        // Inicjalizacja tablicy i dodanie jednostek pierwszej armii
        Infantry infantry1 = new Infantry("Infantry1", Color.RED);
        Cavalry cavalry1 = new Cavalry("Cavalry1", Color.RED);
        Doctor doctor1 = new Doctor("Doctor1", Color.RED);
        General general1 = new General("General1", Color.RED);
        Artillery artillery1 = new Artillery("Artillery1", Color.RED);

        // Dodanie jednostek pierwszej armii do tablicy i listy
        board[0][0] = infantry1;
        board[2][0] = cavalry1;
        board[4][0] = doctor1;
        board[6][0] = general1;
        board[8][0] = artillery1;

        armies.add(infantry1);
        armies.add(cavalry1);
        armies.add(doctor1);
        armies.add(general1);
        armies.add(artillery1);

        // Inicjalizacja tablicy i dodanie jednostek drugiej armii
        Infantry infantry2 = new Infantry("Infantry2", Color.BLUE);
        Cavalry cavalry2 = new Cavalry("Cavalry2", Color.BLUE);
        Doctor doctor2 = new Doctor("Doctor2", Color.BLUE);
        General general2 = new General("General2", Color.BLUE);
        Artillery artillery2 = new Artillery("Artillery2", Color.BLUE);

        // Dodanie jednostek drugiej armii do tablicy i listy
        board[0][9] = infantry2;
        board[2][9] = cavalry2;
        board[4][9] = doctor2;
        board[6][9] = general2;
        board[8][9] = artillery2;

        armies2.add(infantry2);
        armies2.add(cavalry2);
        armies2.add(doctor2);
        armies2.add(general2);
        armies2.add(artillery2);
    }

    private void moveUnits() {
        for (AArmy army : armies) {
            int currentX = -1, currentY = -1;

            // Znajdź aktualną pozycję armii
            for (int x = 0; x < BOARD_WIDTH; x++) {
                for (int y = 0; y < BOARD_HEIGHT; y++) {
                    if (board[x][y] == army) {
                        currentX = x;
                        currentY = y;
                        break;
                    }
                }
            }

            if (currentX != -1 && currentY != -1) {
                int newX = currentX + random.nextInt(3) - 1;
                int newY = currentY + random.nextInt(3) - 1;

                if (newX >= 0 && newX < BOARD_WIDTH && newY >= 0 && newY < BOARD_HEIGHT && board[newX][newY] == null) {
                    board[newX][newY] = army;
                    board[currentX][currentY] = null;
                }
            }
        }

        for (AArmy army : armies2) {
            int currentX = -1, currentY = -1;

            // Znajdź aktualną pozycję armii
            for (int x = 0; x < BOARD_WIDTH; x++) {
                for (int y = 0; y < BOARD_HEIGHT; y++) {
                    if (board[x][y] == army) {
                        currentX = x;
                        currentY = y;
                        break;
                    }
                }
            }

            if (currentX != -1 && currentY != -1) {
                int newX = currentX + random.nextInt(3) - 1;
                int newY = currentY + random.nextInt(3) - 1;

                if (newX >= 0 && newX < BOARD_WIDTH && newY >= 0 && newY < BOARD_HEIGHT && board[newX][newY] == null) {
                    board[newX][newY] = army;
                    board[currentX][currentY] = null;
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int x = 0; x < BOARD_WIDTH; x++) {
            for (int y = 0; y < BOARD_HEIGHT; y++) {
                g.drawRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                if (board[x][y] != null) {
                    g.setColor(board[x][y].getColor());
                    g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawString(board[x][y].name.substring(0, 1), x * TILE_SIZE + TILE_SIZE / 2, y * TILE_SIZE + TILE_SIZE / 2);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Battle Simulation");
        BattleSimulation battleSimulation = new BattleSimulation();
        frame.add(battleSimulation);
        frame.setSize(BOARD_WIDTH * TILE_SIZE, BOARD_HEIGHT * TILE_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
