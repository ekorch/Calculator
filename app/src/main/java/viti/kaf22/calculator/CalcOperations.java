package viti.kaf22.calculator;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by korch on 13.11.17.
 */

public class CalcOperations {
    private static String TAG = "LOG";
    private static List<Double> numbers;
    private static List<String> operations;

    public static double getResult(String str) throws ArithmeticException{
        setExpression(str);

        int index = -1;
        double a = 0;
        double b = 0;
        while (numbers.size() > 1 && operations.size() > 0) {
            Log.d(TAG, "index x :" + operations.indexOf("x"));
            Log.d(TAG, "index / :" + operations.indexOf("/"));
            Log.d(TAG, "index + :" + operations.indexOf("+"));
            Log.d(TAG, "index - :" + operations.indexOf("-"));


            while (operations.indexOf("x") != -1 || operations.indexOf("/") != -1) {
                if ((operations.indexOf("x") < operations.indexOf("/") && operations.indexOf("x") > -1)
                        || (operations.indexOf("x") > -1 && operations.indexOf("/") == -1)) {
                    index = operations.indexOf("x");
                    a = numbers.get(index);
                    b = numbers.get(index + 1);
                    a *= b;
                    numbers.remove(index + 1);
                    numbers.remove(index);
                    numbers.add(index, a);
                    operations.remove(index);
                    a = 0;
                    b = 0;
                    index = 0;
                    Log.d(TAG, "Numbers after 'x': " + numbers);
                    Log.d(TAG, "Operations after 'x': " + operations);
                    Log.d(TAG, "index x :" + operations.indexOf("x"));
                    Log.d(TAG, "index / :" + operations.indexOf("/"));
                    Log.d(TAG, "index + :" + operations.indexOf("+"));
                    Log.d(TAG, "index - :" + operations.indexOf("-"));
                } else if ((operations.indexOf("x") > operations.indexOf("/") && operations.indexOf("/") > -1)
                        || (operations.indexOf("/") > -1 && operations.indexOf("x") == -1)){
                    index = operations.indexOf("/");
                    a = numbers.get(index);
                    b = numbers.get(index + 1);
                    try {
                        a /= b;
                    } catch (ArithmeticException e) {
                        Log.d(TAG, "ERROR: " + e.getMessage());
                    }
                    numbers.remove(index + 1);
                    numbers.remove(index);
                    numbers.add(index, a);
                    operations.remove(index);
                    a = 0;
                    b = 0;
                    index = 0;
                    Log.d(TAG, "Numbers after '/' :" + numbers);
                    Log.d(TAG, "Operations after '/': " + operations);
                    Log.d(TAG, "index x :" + operations.indexOf("x"));
                    Log.d(TAG, "index / :" + operations.indexOf("/"));
                    Log.d(TAG, "index + :" + operations.indexOf("+"));
                    Log.d(TAG, "index - :" + operations.indexOf("-"));
                }
            }

            while (operations.indexOf("+") != -1 || operations.indexOf("-") != -1) {
                if ((operations.indexOf("+") < operations.indexOf("-") && operations.indexOf("+") > -1)
                        || (operations.indexOf("+") > -1 && operations.indexOf("-") == -1)) {
                    index = operations.indexOf("+");
                    a = numbers.get(index);
                    b = numbers.get(index + 1);
                    a += b;
                    numbers.remove(index + 1);
                    numbers.remove(index);
                    numbers.add(index, a);
                    operations.remove(index);
                    a = 0;
                    b = 0;
                    index = 0;
                    Log.d(TAG, "Numbers after '+': " + numbers);
                    Log.d(TAG, "Operations after '+': " + operations);
                    Log.d(TAG, "index x :" + operations.indexOf("x"));
                    Log.d(TAG, "index / :" + operations.indexOf("/"));
                    Log.d(TAG, "index + :" + operations.indexOf("+"));
                    Log.d(TAG, "index - :" + operations.indexOf("-"));
                } else if ((operations.indexOf("+") > operations.indexOf("-") && operations.indexOf("-") > -1)
                        || (operations.indexOf("-") > -1 && operations.indexOf("+") == -1)){
                    index = operations.indexOf("-");
                    a = numbers.get(index);
                    b = numbers.get(index + 1);
                    a -= b;
                    numbers.remove(index + 1);
                    numbers.remove(index);
                    numbers.add(index, a);
                    operations.remove(index);
                    a = 0;
                    b = 0;
                    index = 0;
                    Log.d(TAG, "Numbers after '-': " + numbers);
                    Log.d(TAG, "Operations after '-': " + operations);
                    Log.d(TAG, "index x :" + operations.indexOf("x"));
                    Log.d(TAG, "index / :" + operations.indexOf("/"));
                    Log.d(TAG, "index + :" + operations.indexOf("+"));
                    Log.d(TAG, "index - :" + operations.indexOf("-"));
                }
            }
        }
        return numbers.get(0);

    }

    private static void setExpression(String str){
        Log.d(TAG, "Set expression: " + str);
        numbers = new ArrayList<>();
        operations = new ArrayList<>();
        for (int i = 0; i < str.split("[x,*,/,+,\\-]").length; i++){
            numbers.add(Double.valueOf(str.split("[x,*,/,+,\\-]")[i]));
        }

        Pattern pattern = Pattern.compile("[x,*,/,+,\\-]");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            operations.add(matcher.group());
        }
    }
}
