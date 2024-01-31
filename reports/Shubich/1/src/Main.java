import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (String itr : args) {
            sum += Integer.parseInt(itr);
        }
        double mid = (double) sum / args.length;
        int count = 0;
        for (String itr : args) {
            if (Double.parseDouble(itr) > mid) {
                count++;
            }
        }
        double percent = ((double) count/ args.length) * 100;
        System.out.println("Percent of numbers in args which more than mid:  " + percent);
    }


}