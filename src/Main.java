import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator =new CalculatorImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода введите Выход");
        System.out.println("Введите пример : ");

        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] str2 = new String[3];
            if (str.equals("Выход")){
                break;
            }
            try {
                str2 = splitExp(str);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
            System.out.println(calculator.calculate(str2));
        }



    }

    public static String[] splitExp (String exp){
        String[] a = exp.split(" ");
        if(a.length < 3) {
            throw new IllegalArgumentException("Введены не корректные данные");
        }
        return a;
    }
}
