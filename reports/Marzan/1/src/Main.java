import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.text.DecimalFormat;


public class Main
{
    static List<Integer> rep(int start, int end, int step)
    {
        List<Integer> arr = new ArrayList<Integer>();

        for(int i = start; i < end; i += step)
        {
            arr.add(i);
        }
        return arr;
    }
    static double[] subArray(double[] array, int startIndex, int endIndex)
    {
        double[] new_arr = new double[endIndex - startIndex + 1];

        for(int i = startIndex, j = 0; i <= endIndex; ++i, ++j)
        {
            new_arr[j] = array[i];
        }

        return new_arr;
    }
    static double[] subArrayExclude(double[] array, int startIndex, int endIndex)
    {
        double[] new_arr = new double[array.length - (endIndex - startIndex + 1)];

        for (int i = 0, j = 0; i < startIndex; ++i, ++j)
        {
            new_arr[j] = array[i];
        }

        for (int i = endIndex + 1, j = startIndex; i < array.length; ++i, ++j)
        {
            new_arr[j] = array[i];
        }

        return new_arr;
    }

    public static String shiftRight(String str, int shift)
    {
        if (str == null)
        {
            return null;
        }
        String newStr = "";

        if(Math.abs(shift) > str.length())
        {
            shift %= str.length();
        }

        if(shift > 0)
        {
            newStr = str.substring(str.length() - shift) + str.substring(0, str.length() - shift);
        }
        else if (shift < 0)
        {
            shift = Math.abs(shift);
            newStr = str.substring(shift) + str.substring(0, shift);
        }
        else
        {
            return str;
        }

        return newStr;
    }

    public static void main(String[] args)
    {
        int start = Integer.parseInt(args[0]), end = Integer.parseInt(args[1]), step = Integer.parseInt(args[2]);
        System.out.print("Function rep: ");

        List<Integer> arr = rep(start, end, step);

        for(int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();



        System.out.print("Function task 2:\nEnter array size: ");
        int arrSize = 0;
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        Random random = new Random();

        int decimalPlaces = 2;
        DecimalFormat df = new DecimalFormat("0." + "0".repeat(decimalPlaces));

        double []arr2 = new double[arrSize];
        for (int i = 0; i < arrSize; ++i)
        {
            arr2[i] = random.nextDouble();
            System.out.print(df.format(arr2[i]) + " ");
        }

        System.out.println();

        int startIndex = 0, endIndex = 0;
        System.out.print("Enter startIndex: ");
        startIndex = sc.nextInt();
        System.out.print("Enter endIndex: ");
        endIndex = sc.nextInt();

        double []arr3 = subArray(arr2, startIndex, endIndex);
        System.out.println("Function subArray: ");
        for(double i : arr3)
        {
            System.out.print(df.format(i) + " ");
        }

        System.out.println();
        double []arr4 = subArrayExclude(arr2, startIndex, endIndex);
        System.out.println("Function subArrayExclude: ");
        for(double i : arr4)
        {
            System.out.print(df.format(i) + " ");
        }

        System.out.println();

        int shift = 0;

        System.out.print("Enter string: ");
        String str = sc.next();
        System.out.print("Enter shift: ");
        shift = sc.nextInt();

        System.out.println(shiftRight(str, shift));
        System.out.println(shiftRight(str, -shift));
        sc.close();
    }
}