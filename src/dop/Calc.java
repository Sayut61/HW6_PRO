package dop;


public class Calc {
    @Math(num1 = 100, num2 = 200)
    public void mathSum(int num1, int num2){
        System.out.println("Сумма = " + (num1 + num2));
    }
}
