public class Main {
    public static void main(String[] args) {
        boolean value = true;
        int[] arr = convertArray(args);

        for(int i = 0; i < args.length; i++){
            if(arr[0] != arr[i]){
                value = false;
            }
        }
        System.out.println(convertValue(value));
    }

    public static int[] convertArray(String[] args) {
        int[] result = new int[args.length];
        for(int i = 0; i < result.length; i++){
            result[i] = Integer.parseInt(args[i]);
        }
        return result;
    }

    public static String convertValue(boolean value){
        if(value){
            return "Равны";
        }
        return "Не равны";
    }



}