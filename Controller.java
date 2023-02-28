import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Controller {
    private static Queue<Toy> toys = new LinkedList<>();

    static void clickButton() {

        boolean flag = true;

        while (true) {
            System.out.println(ToyMenu.getFirstMenu());
            int command = InPut.inputIntWithReturn("write command number: ");
            switch (command) {
                case (1) :
                    toys = autoGenToys();
                    break;
                case (2):
                    toys.add(createToy());
                    break;
                case (3):
                    play();
                    break;
                case (0):
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid command");

            }
        }
    }

    private static Queue<Toy> autoGenToys() {
        Queue <Toy> toys = new LinkedList<>();
        boolean flag = true;
        int numToys = InPut.inputIntWithReturn("write the number of toys created");
        for (int i = 0; i < numToys; i++) {
            toys.add(new Toy());
        }

        return toys;
    }

    private static Toy createToy() {
        String name = InPut.inputWithReturn("write toy's name: ");
        int chance = InPut.inputIntWithReturn("write toy's chance ");
        Toy toy = new Toy(name, chance);
        return toy;
    }

    private static void play() {
        String firstPlayer = InPut.inputWithReturn("write first player's name");
        String secondPlayer = InPut.inputWithReturn("write second player's name");
        Queue <Toy> prizesFP = new LinkedList<>();  // для сбора призов для дальнейшей записи в файл
        Queue <Toy> prizesSP = new LinkedList<>();
        boolean playerSwitcher = true;  // для переключения играков. TRUE - first pl, FALSE - second pl.
        int pointsFP = 0; // для определения победителя
        int pointsSP = 0;

        while (toys.size() > 0) {
            int stroke = MyRandom.getRandInt(1, 99);
            if (stroke <= toys.peek().getChanceWin()) {
                if (playerSwitcher) {
                    pointsFP += toys.peek().getPrice();
                    prizesFP.add(toys.poll());
                } else {
                    pointsSP += toys.peek().getPrice();
                    prizesSP.add(toys.poll());
                }
            }

            playerSwitcher = !playerSwitcher;  // после каждого прохода будет переключаться
        }

        FileCreator.fc(prizesFP, (firstPlayer));
        FileCreator.fc(prizesSP, (secondPlayer));

        if (pointsFP > pointsSP) System.out.println("WIN " + firstPlayer);
        else if (pointsFP < pointsSP) System.out.println("WIN " + secondPlayer);
        else System.out.println("dead heat");

        System.exit(0);
    }

}
