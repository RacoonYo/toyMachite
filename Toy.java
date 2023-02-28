public class Toy {
    private static int toyId = 0;
    private String name;
    private int chanceWin;  // вероятность выпода данной игрушки
    private int price;  // для возможности определения побеителя, чем выше вероятность выпадения, тем ниже цена


    // ручной конструктор
    public Toy(String name, int chanceWin) {
        toyId += 1;  // каждая игрушка имеет уникальный ID
        this.name = name;
        // исключается вероятность возникновения игрушки со 100% и 0% верояностями выпандания
        if (chanceWin > 0 && chanceWin < 100) this.chanceWin = chanceWin;
        else {
            System.out.println("no valid chance win, chance win become 50");
            this.chanceWin = 50;
        }
        this.price = 100 - this.chanceWin;
    }

    // автоматический конструктор
    public Toy() {
        toyId += 1;
        this.name = ToyNameGenerator.getToy();
        this.chanceWin = MyRandom.getRandInt(1, 99);
        this.price = 100 - this.chanceWin;
    }

    public int getChanceWin() {
        return chanceWin;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Toy " + name +
                ", chanceWin=" + chanceWin +
                ", price=" + price;
    }
}
