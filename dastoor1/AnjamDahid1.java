public class AnjamDahid1 {
    public static void main(String args []){
        int num1 = 10, num2 = 21 , maxNum , i;
        boolean avalBeHam = true;
        if(num1>num2)
        {
             maxNum = num1;
        }
        else {
            maxNum = num2;
        }
        for(i=2 ; i<maxNum ; i++) {
            if( num1 % i == 0 && num2 % i == 0){
                avalBeHam = false ;
            }
        }

        if(avalBeHam){
            System.out.println("aval be ham and !");
        }
        else{
            System.out.println("aval be ham nistand !");
        }
    }
}
