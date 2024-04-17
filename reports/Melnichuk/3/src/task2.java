import java.util.*;
import java.io.*;


class InvalidCommandException extends Exception {
    public InvalidCommandException(String message) {
        super(message);
    }
}

class OperationExecutionException extends Exception {
    public OperationExecutionException(String message) {
        super(message);
    }
}

class ExecutionContext {
    private Stack<Double> stack;
    private Map<String, Double> parameters;

    public ExecutionContext() {
        stack = new Stack<>();
        parameters = new HashMap<>();
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public Map<String, Double> getParameters() {
        return parameters;
    }
}

public class task2 {
    public static void main(String[] args) {
        ExecutionContext context = new ExecutionContext();
        Scanner scanner = null;

        try {
            if (args.length > 0) {
                scanner = new Scanner(new File(args[0]));
            } else {
                scanner = new Scanner(System.in);
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                if (line.isEmpty() || line.startsWith("#")) {
                    continue;
                }

                executeCommand(line, context);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void executeCommand(String command, ExecutionContext context) {
        String[] parts = command.split("\\s+");
        double operand1, operand2;

        try {
            switch (parts[0]) {
                case "POP":
                    if (context.getStack().isEmpty()) {
                        throw new OperationExecutionException("Стек пуст");
                    }
                    context.getStack().pop();
                    break;
                case "PUSH":
                    if (parts.length < 2) {
                        throw new InvalidCommandException("Отсутствует аргумент для PUSH");
                    }
                    context.getStack().push(Double.parseDouble(parts[1]));
                    break;
                case "+":
                    operand1 = context.getStack().pop();
                    if(context.getParameters().containsKey("+")) {
                        operand2 = context.getParameters().get("+");
                    } else{
                        if (context.getStack().isEmpty()) {
                            throw new OperationExecutionException("Недостаточно элементов в стеке для операции +");
                        }
                        operand2 = context.getStack().pop();
                    }
                    context.getStack().push(operand1 + operand2);
                    break;
                case "-":
                    operand1 = context.getStack().pop();
                    if(context.getParameters().containsKey("-")) {
                        operand2 = context.getParameters().get("-");
                    } else{
                        if (context.getStack().isEmpty()) {
                            throw new OperationExecutionException("Недостаточно элементов в стеке для операции -");
                        }
                        operand2 = context.getStack().pop();
                    }
                    context.getStack().push(operand1 - operand2);
                    break;
                case "*":
                    operand1 = context.getStack().pop();
                    if(context.getParameters().containsKey("*")) {
                        operand2 = context.getParameters().get("*");
                    } else{
                        if (context.getStack().isEmpty()) {
                            throw new OperationExecutionException("Недостаточно элементов в стеке для операции *");
                        }
                        operand2 = context.getStack().pop();
                    }
                    context.getStack().push(operand1 * operand2);
                    break;
                case "/":
                    operand1 = context.getStack().pop();
                    if(context.getParameters().containsKey("/")) {
                        operand2 = context.getParameters().get("/");
                    } else{
                        if (context.getStack().isEmpty()) {
                            throw new OperationExecutionException("Недостаточно элементов в стеке для операции /");
                        }
                        operand2 = context.getStack().pop();
                    }
                    if (operand2 == 0) {
                        throw new OperationExecutionException("Деление на ноль");
                    }

                    context.getStack().push(operand1 / operand2);
                    break;
                case "SQRT":
                    if (context.getStack().isEmpty()) {
                        throw new OperationExecutionException("Стек пуст");
                    }
                    operand1 = context.getStack().pop();
                    if (operand1 < 0) {
                        throw new OperationExecutionException("Извлечение квадратного корня из отрицательного числа");
                    }
                    context.getStack().push(Math.sqrt(operand1));
                    break;
                case "PRINT":
                    if (context.getStack().isEmpty()) {
                        throw new OperationExecutionException("Стек пуст");
                    }
                    System.out.println(context.getStack().peek());
                    break;
                case "DEFINE":
                    if (parts.length < 3) {
                        throw new InvalidCommandException("Некорректное количество аргументов для DEFINE");
                    }
                    String paramName = parts[1];
                    double paramValue = Double.parseDouble(parts[2]);
                    context.getParameters().put(paramName, paramValue);
                    break;
                default:
                    throw new InvalidCommandException("Неизвестная команда: " + parts[0]);
            }
        } catch (InvalidCommandException | OperationExecutionException e) {
            System.out.println("Ошибка выполнения команды: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования числа: " + e.getMessage());
        }
    }
}
