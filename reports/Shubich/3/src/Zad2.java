package org.example;
import java.util.Stack;
import java.util.HashMap;

public class Zad2 {
    private Stack<Double> stack;
    private HashMap<String, Double> parameters;

    public Zad2() {
        stack = new Stack<>();
        parameters = new HashMap<>();
    }

    public void executeCommand(String command) {
        String[] tokens = command.split("\\s+");

        if (tokens.length == 0) {
            return;
        }

        String operator = tokens[0];

        try {
            switch (operator) {
                case "#":
                    // Комментарий, игнорируем
                    break;
                case "POP":
                    pop();
                    break;
                case "PUSH":
                    if (tokens.length > 1) {
                        double value = Double.parseDouble(tokens[1]);
                        push(value);
                    } else {
                        throw new IllegalArgumentException("\nНедостаточно аргументов для команды PUSH");
                    }
                    break;
                case "+":
                    add();
                    break;
                case "-":
                    subtract();
                    break;
                case "*":
                    multiply();
                    break;
                case "/":
                    divide();
                    break;
                case "SQRT":
                    sqrt();
                    break;
                case "PRINT":
                    print();
                    break;
                case "CLEAR":
                    stack.clear();
                    break;
                case "DEFINE":
                    if (tokens.length > 2) {
                        String parameterName = tokens[1];
                        double parameterValue = Double.parseDouble(tokens[2]);
                        define(parameterName, parameterValue);
                    } else {
                        throw new IllegalArgumentException("\nНедостаточно аргументов для команды DEFINE");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("\nНекорректная команда: " + operator);
            }
        } catch (Exception e) {
            System.out.println("\nОшибка выполнения команды: " + e.getMessage());
        }
    }

    private void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        } else {
            throw new IllegalStateException("\nСтек пуст");
        }
    }

    private void push(double value) {
        stack.push(value);
    }

    private void add() {
        if (stack.size() >= 2) {
            double operand2 = stack.pop();
            double operand1 = stack.pop();
            double result = operand1 + operand2;
            stack.push(result);
        } else {
            throw new IllegalStateException("\nНедостаточно операндов для операции +");
        }
    }

    private void subtract() {
        if (stack.size() >= 2) {
            double operand2 = stack.pop();
            double operand1 = stack.pop();
            double result = operand1 - operand2;
            stack.push(result);
        } else {
            throw new IllegalStateException("\nНедостаточно операндов для операции -");
        }
    }

    private void multiply() {
        if (stack.size() >= 2) {
            double operand2 = stack.pop();
            double operand1 = stack.pop();
            double result = operand1 * operand2;
            stack.push(result);
        } else {
            throw new IllegalStateException("\nНедостаточно операндов для операции *");
        }
    }

    private void divide() {
        if (stack.size() >= 2) {
            double operand2 = stack.pop();
            if (operand2 != 0) {
                double operand1 = stack.pop();
                double result = operand1 / operand2;
                stack.push(result);
            } else {
                throw new IllegalArgumentException("\nДеление на ноль");
            }
        } else {
            throw new IllegalStateException("\nНедостаточно операндов для операции /");
        }
    }

    private void sqrt() {
        if (!stack.isEmpty()) {
            double operand = stack.pop();
            if (operand >= 0) {
                double result = Math.sqrt(operand);
                stack.push(result);
            } else {
                throw new IllegalArgumentException("\nИзвлечение квадратного корня из отрицательного числа");
            }
        } else {
            throw new IllegalStateException("\nСтек пуст");
        }
    }

    private void print() {
        if (!stack.isEmpty()) {
            double value = stack.peek();
            System.out.println(value);
        } else {
            throw new IllegalStateException("\nСтек пуст");
        }
    }

    private void define(String parameterName, double parameterValue) {
        parameters.put(parameterName, parameterValue);
    }
}