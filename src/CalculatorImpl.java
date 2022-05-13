public class CalculatorImpl implements Calculator {

    Roman roman = new Roman();

    @Override
    public int calculation(int i1, int i2, String x) {
        int res;
        if ((i1 > 10 || i2 > 10) | (i1 < 0 || i2 < 0 )) {
            throw new IllegalArgumentException("Переменные должны быть не больше 10 и не меньше 0!");
        }
        switch (x){
            case "+" :
               res = i1 + i2;
               break;
            case  "-" :
                res = i1 - i2;
                break;
            case "/" :
                res = i1 / i2;
                break;
            case "*" :
                res = i1 * i2;
                break;
            default: throw new IllegalArgumentException("Ошибка! Неверно введенён оператор");
        }
        return res;
    }

    @Override
    public String calculate(String[] exp) {
        int exp0 = 0;
        int exp2 = 0;
        String exp1 = exp[1];
        try {
            exp0 = Integer.parseInt(exp[0]);
            exp2 = Integer.parseInt(exp[2]);
        } catch (NumberFormatException e){
            exp0 = roman.transformToInt(exp[0]);
            exp2 = roman.transformToInt(exp[2]);//
            int result = calculation(exp0, exp2, exp1);
            return roman.transformToRoman(result);
        }
        return String.valueOf(calculation(exp0, exp2, exp1));
    }
}
