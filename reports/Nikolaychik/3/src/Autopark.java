import java.util.*;

public class Autopark {
    ArrayList<Bus> busList;

    public Autopark(){
        this.busList = new ArrayList<Bus>();
    }

    public ArrayList<Bus> allBus(){
        ArrayList<Bus> temp = new ArrayList<Bus>();
        for (int i = 0; i < this.busList.size(); i++) {
            temp.add(new Bus(busList.get(i)));
        }
        return temp;
    }

    public ArrayList<Bus> allBusNotInPark(){
        ArrayList<Bus> temp = new ArrayList<Bus>();
        for (int i = 0; i < this.busList.size(); i++) {
            if(!busList.get(i).isIn_Park()){
                temp.add(new Bus(busList.get(i)));
            }
        }
        return temp;
    }

    public ArrayList<Bus> allBusInPark(){
        ArrayList<Bus> temp = new ArrayList<Bus>();
        for (int i = 0; i < this.busList.size(); i++) {
            if(busList.get(i).isIn_Park()){
                temp.add(new Bus(busList.get(i)));
            }
            else continue;
        }
        return temp;
    }

    public ArrayList<Bus> allBusOnRoute(int Route){
        ArrayList<Bus> temp = new ArrayList<Bus>();
        for (int i = 0; i < this.busList.size(); i++) {
            if(busList.get(i).getRoute_Number() == Route){
                temp.add(new Bus(busList.get(i)));
            }
        }
        return temp;
    }

    public ArrayList<Bus> allBusOld(){
        ArrayList<Bus> temp = new ArrayList<Bus>();
        for (int i = 0; i < this.busList.size(); i++) {
            if( new Date().getYear() + 1900 - busList.get(i).getYear()  > 10){
                temp.add(new Bus(busList.get(i)));
            }
        }
        return temp;
    }

    public ArrayList<Bus> allBusManyKm(){
        ArrayList<Bus> temp = new ArrayList<Bus>();
        for (int i = 0; i < this.busList.size(); i++) {
            if(busList.get(i).getMileage()  >= 100000){
                temp.add(new Bus(busList.get(i)));
            }
        }
        return temp;
    }

    public void out_NotInPark(){
        ArrayList<Bus> temp = allBusNotInPark();
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).output();
        }
    }

    public void out_InPark(){
        ArrayList<Bus> temp = this.allBusInPark();
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).output();
        }
    }

    static public void out(ArrayList<Bus> temp){
        for (int i = 0; i < temp.size(); i++) {
            temp.get(i).output();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
    void AddBus(int Bus_Number, int Route_Number , String Brand, int Year, long Mileage){
        this.busList.add(new Bus(Bus_Number,  Route_Number ,  Brand,  Year,  Mileage));
    }
}
