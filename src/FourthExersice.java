import java.util.Scanner;
public class FourthExersice {
    static long fact(int n){
        if(n == 0 || n == 1) return 1;
        return n * fact(n-1);
    }
    public static void main(String[] args) {
        System.out.println("4 exersice");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long result = fact(num);
        System.out.println(num + "! = " + result);
    }
}
