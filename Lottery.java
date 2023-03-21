import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lottery {

    public static Integer sumWeightToys(Integer sumWeight) throws IOException {
        List toysCollection = Files.readAllLines(Paths.get("Stock.txt"));
        for (Object line : toysCollection) {
            String[] toys = ((String) line).split(",");
            sumWeight = sumWeight + Integer.parseInt(toys[3]);
        }
        return sumWeight;
    }


    public static void roll(Integer winnerNums, Toys winner) throws IOException {
        List toysCollection = Files.readAllLines(Paths.get("Stock.txt"));
        for (Object line : toysCollection) {
            String[] toys = ((String) line).split(",");
            if (winnerNums <= Integer.parseInt(toys[3])) {
                winner.id = Integer.parseInt(toys[0]);
                winner.name = toys[1];
                winner.quantity = Integer.parseInt(toys[2])-1;
                winner.chance = Integer.parseInt(toys[3]);
                Toys.changeNums(winner);
                break;
            } else {
                winnerNums = winnerNums - Integer.parseInt(toys[3]);
            }
        }
        System.out.println(winner.name);
    }

    public static void draw() throws IOException {
        Integer sumWeight = 0;
        sumWeight = sumWeightToys(sumWeight);
        Integer winnerNums = (int) ((Math.random()*(sumWeight-1)) + 1);
        Toys winner = new Toys(null, null, null, null);
        roll(winnerNums, winner);
    }
}