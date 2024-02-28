import java.io.IOException;
import java.io.RandomAccessFile;

public class Zad2 {
    private static final int DEFAULT_NUM_LINES = 10;

    public static void main(String[] args) {
       if (args.length < 1 || args.length > 3) {
           System.out.println("Uncorrected numbers of args. Try: tail [-n] file");
       }
       int numLines = DEFAULT_NUM_LINES;
       String filename = null;

       if (args.length == 1){
           filename = args[0];
       } else if (args.length == 3 && args[0].equals("-n")) {
           try {
               numLines = Integer.parseInt(args[1]);
               filename = args[2];
           } catch (NumberFormatException e){
               System.out.println("Uncorrected value for numbers of stings");
           }
       } else {
           System.out.println("Uncorrected format of args. Try: tail [-n] file");
       }

       try(RandomAccessFile file = new RandomAccessFile(filename, "r")) {
           long fileLength = file.length();
           long position = fileLength - 1;
           int linesFound = 0;

           StringBuilder output = new StringBuilder();

           while (position >= 0 && linesFound < numLines) {
               file.seek(position);
               char c = (char) file.read();

               if (c == '\n') {
                   output.insert(0, c);
                   linesFound++;
               } else if (position == 0) {
                   output.insert(0, c);
                   linesFound++;
               } else {
                   output.insert(0, c);
               }

               position--;
           }

           System.out.print(output);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
