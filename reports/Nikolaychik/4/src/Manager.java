import java.util.ArrayList;

public class Manager {
    static ArrayList<Account> stored_accounts = null;
    static void addAccount(Account account){
        account.id=0;
        if(stored_accounts==null){
            stored_accounts=new ArrayList<Account>();
        }
        stored_accounts.add(account);
        boolean flag=true;
        for (int i=1;account.id==0;i++){
            flag=true;
            for(int j=0;j<stored_accounts.size();j++){
                if(stored_accounts.get(j).id == i)
                {
                    flag=false;
                }
            }
            if(flag) {
                account.id = i;
            }
        }
        account.money=0;
    }

    static public void Operation_in(Account myAccount, int size){
        if(stored_accounts==null){
            stored_accounts=new ArrayList<Account>();
        }
        myAccount.money+=size;
        myAccount.history.add(new History(size,Account.in_type,myAccount.id,myAccount.id));
    }
    static public boolean Operation_out(Account myAccount,int size){
        if(stored_accounts==null){
            stored_accounts=new ArrayList<Account>();
        }
        if(myAccount.money>size) {
            myAccount.money -= size;
            myAccount.history.add(new History(size, Account.out_type, myAccount.id, myAccount.id));
            return true;
        }
        else {
            System.out.println("Нет денюх");
            return false;
        }
    }
    static public boolean Operation_to(Account myAccount,int size, int to_id){
        if(stored_accounts==null){
            stored_accounts=new ArrayList<Account>();
        }
        Account temp=null;
        for(int i=0; i<stored_accounts.size();i++){
            if(stored_accounts.get(i).id==to_id)
                temp = stored_accounts.get(i);
        }
        if(temp==null){
            System.out.println("Нет такого пользователя");
            return false;
        }
        if(myAccount.money>size) {
            myAccount.money -= size;
            temp.money += size;
            myAccount.history.add(new History(size, Account.to_type, myAccount.id, temp.id));
            temp.history.add(new History(size, Account.in_type, myAccount.id, temp.id));
            return true;
        }
        else {
            System.out.println("Нет денюх");
            return false;
        }
    }
}
