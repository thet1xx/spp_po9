import java.util.Scanner;

public class CommandEnterPIN extends Command{
    CommandEnterPIN(ATM atm){
        super(atm);
    }
    @Override
    public boolean execute(){
        if(atm.getMode()==Mode.BLOCKED){
            return false;
        }
        atm.setMode(Mode.AUTH);
        System.out.println("Введите пин");
        Scanner scanner=new Scanner(System.in);
        if(ATM.Verivication_prototype(scanner.nextInt())) {
            atm.setMode(Mode.IN_PROCESS);
            return true;
        }
        else {
            atm.setMode(Mode.WAIT);
            return false;
        }
    }
}
