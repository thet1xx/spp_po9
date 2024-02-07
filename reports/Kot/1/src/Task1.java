public class Task1 {
    public static void main(String[] args) {
        int[] numbers = new int[args.length];

        try {
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Integer.parseInt(args[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода. Ввведите N целых чисел через пробел.");
        }

        int[] counts = new int[max(numbers) + 1];

        for (int i : numbers) {
            counts[i]++;
        }

        System.out.println("Числа, встречающиеся только единожды: ");
        for (int number : numbers) {
            if (counts[number] == 1) System.out.print(number + " ");
        }
    }

    public static int max(int[] array){
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (i > max) max = i;
        }
        return max;
    }
}
