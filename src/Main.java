import java.util.Scanner;
public class Main{
    static void num(int n){
        if(n == 0) return;
        num(n/10);
        System.out.println(n%10);
    }
    public static void main(String[] args){
        System.out.println("1 exersice");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        num(n);

    }
}


