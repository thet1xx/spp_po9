import java.util.Scanner;

public class CommandEnd extends Command{
    CommandEnd(ATM atm){
        super(atm);
    }
    @Override
    public boolean execute(){
        if(atm.getMode()!=Mode.IN_PROCESS){
            return false;
        }

        System.out.println("Работа завершена");
        atm.setMode(Mode.WAIT);
        if(atm.getAllMoney()<1){
            atm.setMode(Mode.BLOCKED);
            System.out.println("Денег нет, больше не выдаем");
        }
        return true;
    }
}