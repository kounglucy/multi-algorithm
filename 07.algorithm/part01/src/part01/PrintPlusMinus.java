package part01;

class PrintPlusMinus {

    public static void main(String[] args) {
        int n;

        System.out.println("+, - 출력");

        do {
           n = 5;
        } while (n <= 0);

        // ver1
//        for (int i = 1; i <= n; i++) {
//            if (i % 2 == 0) {                    
//                System.out.print("+");
//            } else {                              
//                System.out.print("-");
//            }
//        }
        
        // ver2
        for(int i = 1; i <= n / 2; i++) {
        	System.out.print("+-");
        }
        
        if(n % 2 != 0) {
        	System.out.println("+");
        }
        
    }
}