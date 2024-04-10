public class Bus {

    String Driver_Name;
    int Bus_Number;
    int Route_Number;
    String Brand;
    int Year;
    long Mileage;
    boolean In_Park;

    public Bus(int Bus_Number, int Route_Number , String Brand, int Year, long Mileage){

        this.Driver_Name = "NONE";
        this.Bus_Number = Bus_Number;
        this.Route_Number = Route_Number;
        this.Brand = Brand;
        this.Year = Year;
        this.Mileage = Mileage;
        this.In_Park = true;
    }

    public Bus(Bus temp){

        this.Driver_Name = temp.Driver_Name;
        this.Bus_Number = temp.Bus_Number;
        this.Route_Number = temp.Route_Number;
        this.Brand = temp.Brand;
        this.Year = temp.Year;
        this.Mileage = temp.Mileage;
        this.In_Park = temp.In_Park;
    }

    public void setRoute_Number(int route_Number) {
        Route_Number = route_Number;
    }

    public void setDriver_Name(String driver_Name) {
        Driver_Name = driver_Name;
    }

    public void setIn_Park() {
        In_Park = !In_Park;
    }

    public long getMileage() {
        return Mileage;
    }

    public int getRoute_Number() {
        return Route_Number;
    }

    public int getYear() {
        return Year;
    }

    public boolean isIn_Park() {
        return In_Park;
    }

    public int getBus_Number() {
        return Bus_Number;
    }

    public String getBrand() {
        return Brand;
    }

    public String getDriver_Name() {
        return Driver_Name;
    }
    public void output(){
        System.out.println("Year " + this.Year);
        System.out.println("Brand " + this.Brand);
        System.out.println("Bus_Number "+this.Bus_Number);
        System.out.println("Driver_Name "+this.Driver_Name);
        System.out.println("Mileage "+this.Mileage);
        System.out.println("Route_Number "+this.Route_Number);
        System.out.println("In_Park "+ this.In_Park);
        System.out.println();

    }
}
