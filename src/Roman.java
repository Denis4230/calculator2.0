import java.util.Map;
import java.util.TreeMap;

public class Roman {
    private final TreeMap<Integer, String> romanNumbers;

    public Roman(){
        romanNumbers = new TreeMap<>();
        romanNumbers.put(1, "I");
        romanNumbers.put(4, "IV");
        romanNumbers.put(5, "V");
        romanNumbers.put(9, "IX");
        romanNumbers.put(10, "X");
        romanNumbers.put(40, "XL");
        romanNumbers.put(50, "L");
        romanNumbers.put(90, "XC");
        romanNumbers.put(100, "C");
    }
    public String transformToRoman(int num){
        int key = romanNumbers.floorKey(num);
        if(num == key){
            return romanNumbers.get(key);
        }
        return romanNumbers.get(key) + transformToRoman(num - key);
    }

    public int transformToInt(String roman) {
        try {
            Integer.parseInt(roman);
            throw new IllegalArgumentException("Данные введены не корректно");
        }catch (NumberFormatException e){
        }
        int maxValuePosition = getMaxPosition(roman);

        int result = getKey(String.valueOf(roman.charAt(maxValuePosition)));

        for (int i = 0; i < roman.length(); i++) {
            if (maxValuePosition == i){
                continue;
            }
            if (i > maxValuePosition){
                result = result + getKey(String.valueOf(roman.charAt(i)));
            } else {
                result = result - getKey(String.valueOf(roman.charAt(i)));
            }
        }
        return result;
    }

    private int getKey(String v){
        int num = 0;

        for (Map.Entry<Integer, String> entry : romanNumbers.entrySet()){

            if(entry.getValue().equals(v)) {
                num = entry.getKey();
                break;
            }
        }
        return num;
    }

    private int getMaxPosition(String romanNum) {
        int maxPos = 0;
        int maxInt = 1;
        for (int i = 0; i < romanNum.length(); i++){
            int n = getKey(String.valueOf(romanNum.charAt(i)));
            if (n > maxInt){
                maxInt = n;
                maxPos = i;
            }
        }
        return maxPos;
    }
}
