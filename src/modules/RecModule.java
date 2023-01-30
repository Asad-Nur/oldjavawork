package modules;

public class RecModule {

    public static int fac(int n) {
        if (n == 0) {
            return 1;
        }
        else {
            return n * fac(n - 1);
        }

    }

    public static boolean isPalindrome(String s) {
        if (s.length() <=1){
            return true;
        }
        else if (s.charAt(0) != s.charAt(s.length()-1)) {
            return false;
        }
        else{
            return isPalindrome(s.substring(1,s.length() -1));
        }
    }

    public static double pow(double x, int n) {
        if (n == 0) {
           return 1;
        }
        else {
            return x * pow(x, n - 1);
        }

    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return n + sum(n - 1);
        }
    }

}
