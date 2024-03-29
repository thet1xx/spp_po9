import java.util.Scanner;

public class CommandGetMoney extends Command{
    CommandGetMoney(ATM atm){
        super(atm);
    }
    @Override
    public boolean execute(){
        if(atm.getMode()!=Mode.IN_PROCESS){
            System.out.println("Не можем дать денег");
            return false;
        }
        System.out.println("денег есть " + atm.getAllMoney());
        System.out.println("сколько хочешь снять?");
        Scanner scanner=new Scanner(System.in);
        double money = scanner.nextDouble();
        if(money> atm.getAllMoney()){
            atm.setMode(Mode.IN_PROCESS);
            System.out.println("Нет столько денег");
            if(atm.getAllMoney()<1){
                atm.setMode(Mode.BLOCKED);
                System.out.println("Денег нет, больше не выдаем");
            }
            return false;
        }
        else {
            atm.setAllMoney(atm.getAllMoney()-money);
            System.out.println("Вот ваши деньги");
            if(atm.getAllMoney()<1){
                atm.setMode(Mode.BLOCKED);
                System.out.println("Денег нет, больше не выдаем");
            }
            return true;
        }
    }
}

