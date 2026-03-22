import java.util.Scanner;
public class SecondExersice {
    static int sum(int n, Scanner sc){
        if(n == 0) return 0;
        int x = sc.nextInt();
        return x + sum(n-1, sc);
    }
    public static void main (String[] args){
        System.out.println("2 exersice");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int total = sum(a, sc);
        double avg = (double) total / a;
        System.out.println(avg);

    }
}
