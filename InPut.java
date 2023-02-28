import java.util.Scanner;

public class InPut {

    static String inputWithReturn(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    static int inputIntWithReturn(String text) {
        System.out.println(text);

        boolean flag = true;
        int result = 0;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            try {
                result = Integer.parseInt(scanner.nextLine());
                flag = false;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect command, please write integer");
            }
        }
        return result;
    }
}
