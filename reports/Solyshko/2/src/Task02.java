import java.io.*;

public class Task02 {
    public static void main(String[] args) {
        if (args.length < 4 || !args[0].equals("split")) {
            System.out.println("Usage: java SplitUtility split [-b num | -l num] [-d] [input_file] [output_prefix]");
            System.exit(1);
        }

        int blockSize = 0;
        int lineCount = 10;
        boolean useNumericSuffixes = false;
        String inputFile = null;
        String outputPrefix = "x";

        try {
            int i = 1;
            while (i < args.length) {
                switch (args[i]) {
                    case "-b":
                        blockSize = parseSizeArgument(args[++i]);
                        lineCount = 0;
                        break;
                    case "-l":
                        lineCount = Integer.parseInt(args[++i]);
                        break;
                    case "-d":
                        useNumericSuffixes = true;
                        break;
                    default:
                        if (inputFile == null) {
                            inputFile = args[i];
                        } else {
                            outputPrefix = args[i];
                        }
                        break;
                }
                i++;
            }

            if (blockSize == 0 && lineCount == 0) {
                System.out.println("Error: You must specify either -b or -l option.");
                System.exit(1);
            }

            splitFile(inputFile, outputPrefix, blockSize, lineCount, useNumericSuffixes);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

    private static int parseSizeArgument(String size) {
        size = size.toLowerCase();
        if (size.endsWith("b")) {
            return Integer.parseInt(size.substring(0, size.length() - 1));
        } else if (size.endsWith("k")) {
            return Integer.parseInt(size.substring(0, size.length() - 1)) * 1024;
        } else if (size.endsWith("m")) {
            return Integer.parseInt(size.substring(0, size.length() - 1)) * 1024 * 1024;
        } else {
            return Integer.parseInt(size);
        }
    }

    private static void splitFile(String inputFile, String outputPrefix, int blockSize, int lineCount, boolean useNumericSuffixes) throws IOException {
        BufferedReader reader = null;
        try {
            reader = (inputFile == null || inputFile.equals("-")) ?
                    new BufferedReader(new InputStreamReader(System.in)) :
                    new BufferedReader(new FileReader(inputFile));

            StringBuilder block = new StringBuilder();
            int blockNumber = 0;
            int tempLineCount = lineCount;

            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;

                if (tempLineCount > 0) {
                    block.append(character);
                    if (character == '\n') {
                        tempLineCount--;
                        if (tempLineCount == 0) {
                            writeBlock(outputPrefix, block.toString(), blockNumber++, useNumericSuffixes);
                            block.setLength(0);
                            tempLineCount = lineCount;
                        }
                    }
                } else if (blockSize > 0) {
                    int charSize = Character.toString(character).getBytes("UTF-8").length;
                    if (block.length() + charSize > blockSize) {
                        writeBlock(outputPrefix, block.toString(), blockNumber++, useNumericSuffixes);
                        block.setLength(0);
                    }
                    block.append(character);
                }
            }

            if (block.length() > 0) {
                writeBlock(outputPrefix, block.toString(), blockNumber, useNumericSuffixes);
            }
        }
        finally {
            if (reader != null && inputFile != null && !inputFile.equals("-")) {
                reader.close();
            }
        }
    }

    private static void writeBlock(String outputPrefix, String block, int blockNumber, boolean useNumericSuffixes) throws IOException {
        String suffix = useNumericSuffixes ? String.format("%02d", blockNumber) : getAlphabeticSuffix(blockNumber);
        String outputFileName = outputPrefix + suffix + ".txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(block);
        }
        System.out.println("Created: " + outputFileName);
    }

    private static String getAlphabeticSuffix(int number) {
        StringBuilder suffix = new StringBuilder();
        do {
            suffix.insert(0, (char) ('a' + number % 26));
            number /= 26;
        } while (number > 0);
        return suffix.toString();
    }
}
