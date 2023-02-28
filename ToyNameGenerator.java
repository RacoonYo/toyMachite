public class ToyNameGenerator {
    private static String[] toyNames = {
            "robot", "ball", "toy car", "toy train", "dinosaur", "doll", "plane", "eddy bear", "spinning top"
    };

    private static String[] toyColors = {
            "Yellow", "Green", "Blue", "Brown", "White", "Red", "Orange", "Pink", "Gray", "Black"
    };

    private static String[] toyFirm = {
            "Playskool", "Playmobil", "Mega", "Brands", "Disney", "Hasbro", "Mattel", "Полесье"
    };

    static String getToy() {
        return MyRandom.getRandomElArray(toyColors) + " " +  MyRandom.getRandomElArray(toyNames) + " "
                +  MyRandom.getRandomElArray(toyFirm);
    }
}

