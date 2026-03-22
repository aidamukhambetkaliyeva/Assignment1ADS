import java.util.Scanner;
public class NinthExersice {
    static int count(String s) {
        if (s.equals("")) return 0;
        return 1 + count(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println("9 exersice");
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int result = count(s);
        System.out.println(result);

    }
}

