import java.util.Scanner;
public class EighthExersice {
    public static boolean numcheck(String i, int n){
        if(n == i.length())return true;
        if (!Character.isDigit(i.charAt(n))) return false;
        return numcheck(i,n+1);
    }
    public static void main(String[] args) {
        System.out.println("8 exersice");
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        if(numcheck(s,0)){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
