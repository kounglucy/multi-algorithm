package part01;

public class Median2 {
    static int med(int a, int b, int c) {
        if (a >= b)
            if (b >= c)
                return b;
            else if (a <= c)
                return a;
            else
                return c;
        else if (a > c)
            return a;
        else if (b > c)
            return c;
        else
            return b;
    }

    static int med2(int a, int b, int c) {
      if ((b >= a && c <= a) || (b <= a && c >= a))
        return a;
      else if ((a > b && c < b) || (a < b && c > b))
        return b;
      return c;
    }

    public static void main(String[] args) {

    	int result = med(2, 5, 1);
        System.out.println("중앙값은 " + result + "입니다.");
    }
}
