import java.util.ArrayList;
import java.util.Vector;

public class Account {
    final static short in_type=0,out_type=1,to_type=2;
    int id;
    int money;
    ArrayList<History> history;

    Account(){
        this.history=new ArrayList<History>();
    }

    public int getId() {
        return id;
    }

    public void refresh(){
        System.out.println("id " + this.id);
        System.out.println("money " +this.money);

    }
    public void output_history(){
        for(int i=0;i<this.history.size();i++){
            System.out.println("////////////////////////////////////////////////////");
            System.out.println("История пользователя "+ this.id);
            System.out.println("////////////////////////////////////////////////////");
            if(this.history.get(i).type == in_type) System.out.println("Поступление средств");
            if(this.history.get(i).type == out_type) System.out.println("Вывод средств");
            if(this.history.get(i).type == to_type) System.out.println("Перечисление средств");
            System.out.println("дата "+this.history.get(i).date.toString());
            System.out.println("величина "+this.history.get(i).size);
            System.out.println("от "+this.history.get(i).from_id);
            System.out.println("к "+this.history.get(i).to_id);
            System.out.println();
            System.out.println();
        }
    }
}
