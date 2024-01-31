public class task03 {
    public static void main(String[] args) {
        String str = "";
        System.out.println(capitalize(str));
    }
    static String capitalize(String str){
        if (!str.isEmpty()) {
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        } else return str;
    }
}
