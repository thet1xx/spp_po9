public class Task_3 {
    public static void main(String[] args) {
        CommandList commandList = new CommandList();
        ATM atm = new ATM(150);
        commandList.push(new CommandGetMoney(atm));
        commandList.push(new CommandEnterPIN(atm));
        commandList.push(new CommandGetMoney(atm));
        commandList.push(new CommandGetMoney(atm));
        commandList.push(new CommandEnd(atm));
        commandList.push(new CommandGetMoney(atm));
        while (!commandList.isEmpty())
            commandList.exec();
    }
}