import java.util.Scanner;
public class SeventhExersice {
    static void revers(int n, Scanner sc){
        if(n == 0 )return;
        int x = sc.nextInt();
        revers(n-1, sc);
        System.out.print(x + " ");
    }
    public static void main(String[] args) {
        System.out.println("7 exersice");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        revers(n, sc);
    }
}

