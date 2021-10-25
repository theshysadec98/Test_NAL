import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Result {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int x = Integer.parseInt(firstMultipleInput[0]);

        int e = Integer.parseInt(firstMultipleInput[1]);

        // Write your code here
        // trien khai ((x/100)^e)100
        double x1=Double.parseDouble(String.valueOf(x));
        double soChia=1;
        double soBiChia=1;
        for(int i=0;i<e;i++){
            soBiChia=soBiChia*x1;
            soBiChia=soBiChia*100;
        }
        double result=soBiChia/soBiChia*100;


        System.out.println(String.format("%.6f",result));

        bufferedReader.close();
    }
}
