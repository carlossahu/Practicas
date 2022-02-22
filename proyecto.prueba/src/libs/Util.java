package libs;
import java.util.Random;

public class Util {
    public static int aleatorio(int min, int max) {
        random r = new Random();
        return r.nextInt(max - min + 1) + min;
    }
}