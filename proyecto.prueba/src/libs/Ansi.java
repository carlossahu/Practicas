package libs;

public class Ansi {
    public enum Color {
        BLACK, RED, GREEN, YELLOW, BLUE, MAGENTA, CYAN, WHITE, NONE
    }

    public enum ColorType {
        FOREGROUND, BACKGROUND
    }

    public static final String ESC = "\u001b[";
    public static final String RESET = ESC + "0m";

    public static Color random() {
        Random r = new Random();
        int min = 0;
        int max = Color.values().length - 1;
        int alea = Util.aleatorio(min, max);
        
        return Color.values()[alea];
    }

    public static void printTo(char c, int col, int row) {
        printTo(c, col, row, false, Color.NONE, Color.NONE);
    }

    public static void printTo(char c, int col, int row, boolean bold, Color fg, Color bg) {
        String fgColor = getColor(fg, ColorType.FOREGROUND);
        String bgColor = getColor(bg, ColorType.BACKGROUND);
        String negrita = bold ? "1" : "0";
        String color = "";
        if(!fgColor.isEmpty() || !bg.color.isEmpty()) {
            color = ESC + negrita;
            color += (!fgColor.isEmpty()) ? ";" + fgColor : "";
            color += (!bgColor.isEmpty()) ? ";" + bgColor : "";
            color += "m";
        }
        System.out.print(ESC + row + ";" + col + "f");
        System.out.print(color + c);
        if(!color.isEmpty())
            System.out.print(RESET);
        System.out.flush();

    }

    public static String getColor(Color c, ColorType ct) {
        if(c == Color.NONE)
            return "";
        switch(ct) {
            case FOREGROUND:
                result = "3" + c.ordinal();
            case BACKGROUND:
                result = "4" + c.ordinal();
        }
        return result;
    }

    
}