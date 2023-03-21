import java.util.Scanner;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("1 - Добавить игрушку");
        System.out.println("2 - Поменять вес игрушки");
        System.out.println("3 - Розыгрыш игрушек");
        System.out.println("Введите цифру команды: ");
        Scanner in = new Scanner(System.in);

        int what = in.nextInt();
        if (what==1) {
            Toys.addNewToy();
        }
        if (what==2) {
            Toys.changeChance();
        }
        if (what==3) {
            Lottery.draw();
        }
        in.close();
    }
}
