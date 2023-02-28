import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;

public class FileCreator {

    static <T> void fc(Queue<T> textsQue, String fileName) {
        String text = "";
        try (FileWriter fw = new FileWriter(fileName + ".txt", false)) {
            for (T line:textsQue) {
                text += line.toString() + "\n";
            }
            fw.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
