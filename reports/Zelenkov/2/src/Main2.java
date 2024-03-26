import java.io.*;

public class Main2 {

    private static final String OPTION_BLOCK_SIZE = "-b";
    private static final String OPTION_LINE_COUNT = "-l";
    private static final String OPTION_NUMERIC_SUFFIXES = "-d";

    public static void main(String[] args) {
        System.out.println(args.length);
        System.out.println(args[0]);
        if (args.length <= 2 || args.length > 6 || !args[0] .equals("split")) {
            System.out.println("Usage: java SplitUtility split [-b num | -l num] [-d] [input_file] [output_prefix]");
            System.exit(1);
        }

        int memorySize = 0;
        int lineCount = 10;
        boolean numericSuffix = false;
        String inputFile = null;
        String prefix = "x";

        try {
            for (int i = 1; i < args.length; i++) {
                switch (args[i]) {
                    case OPTION_BLOCK_SIZE:
                        memorySize = parseSizeArgument(args[++i]);
                        lineCount = 0;
                        break;
                    case OPTION_LINE_COUNT:
                        lineCount = Integer.parseInt(args[++i]);
                        break;
                    case OPTION_NUMERIC_SUFFIXES:
                        numericSuffix = true;
                        break;
                    default:
                        if (inputFile == null) {
                            inputFile = args[i];
                        } else {
                            prefix = args[i];
                        }
                        break;
                }
            }

            if (memorySize == 0 && lineCount == 0) {
                System.out.println("Error: You must specify either -b or -l option.");
                System.exit(1);
            }

            split(inputFile, prefix, memorySize, lineCount, numericSuffix);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("2Usage: java SplitUtility split [-b num | -l num] [-d] [input_file] [output_prefix]");
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

    private static void split(String inputFile, String outputPrefix, int blockSize, int lineCount, boolean useNumericSuffixes) throws IOException {
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

            if (!block.isEmpty()) {
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