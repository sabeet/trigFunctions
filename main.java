public class main {
    public static void main(String[] args) {
        //I had an interview question asking me how to create a
        //sin, cos, and tan functions without any java math libraries
        //Since no java math libraries are available, i'll be creating
        //2 helper math functions from scratch:
        //A factorial function and a exponent function

        System.out.println(sinFunc(30));
        System.out.println(cosFunc(0));
        System.out.println(tanFunc(45));

    }

    public static double sinFunc(double degree){
        //we have to use the Power series
        //i'm just going to have a max of 5 terms
        //Formula: x - (x^3)/(3!) + (x^5)/(5!) - (x^7)/(7!) + (x^9)/(9!) - (x^11)/(11!)

        //convert degree to radians
        final double PI = 3.14159265;
        double radian = (PI/180)*degree;

        double sineValue =
                radian - (powerFunc(radian,3))/(factorial(3)) +
                        (powerFunc(radian,5))/(factorial(5)) -
                        (powerFunc(radian,7))/(factorial(7)) +
                        (powerFunc(radian,9))/(factorial(9)) -
                        (powerFunc(radian,11))/(factorial(11));

        return sineValue;
    }

    public static double cosFunc(double degree){
        //Formula: 1 - (x^2)/(2!) + (x^4)/(4!) - ....

        final double PI = 3.14159265;
        double radian = (PI/180)*degree;

        double cosValue = 
                1 - (powerFunc(radian,2))/(factorial(2)) +
                        (powerFunc(radian,4))/(factorial(4)) -
                        (powerFunc(radian,6))/(factorial(6)) +
                        (powerFunc(radian,8))/(factorial(8)) -
                        (powerFunc(radian,10))/(factorial(10));

        return cosValue;
    }

    public static double tanFunc(double degree){

        final double PI = 3.14159265;
        double radian = (PI/180)*degree;

        double tanValue = radian + (powerFunc(radian,3))/3 +
                2*(powerFunc(radian,5))/15 + 17*(powerFunc(radian,7))/315;

        return tanValue;
    }

    public static long factorial(int nums){
        if(nums >= 1){
            return nums * factorial(nums - 1);
        }
        else{
            return 1;
        }
    }

    public static double powerFunc(double base,int exp){
        double result = 1;

        for(int i=0; i<exp; i++){
            result *= base;
        }

        return result;
    }
}
