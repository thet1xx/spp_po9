class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final int year;
    private final String color;
    private final double price;
    private final String registrationNumber;
    private final String plateNumber;
    private final String renterName;
    private final String renterPassport;

    public Car(int id, String brand, String model, int year, String color, double price, String registrationNumber, String plateNumber, String renterName, String renterPassport) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.plateNumber = plateNumber;
        this.renterName = renterName;
        this.renterPassport = renterPassport;
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }


    public double getPrice() {
        return price;
    }


    public String getRenterName() {
        return renterName;
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id=").append(id)
                .append(", brand='").append(brand).append('\'')
                .append(", model='").append(model).append('\'')
                .append(", year=").append(year)
                .append(", color='").append(color).append('\'')
                .append(", price=").append(price)
                .append(", registrationNumber='").append(registrationNumber).append('\'')
                .append(", plateNumber='").append(plateNumber).append('\'');

        if (!renterName.isEmpty()) {
            builder.append(", renterName='").append(renterName).append('\'');
        }
        if (!renterPassport.isEmpty()) {
            builder.append(", renterPassport='").append(renterPassport).append('\'');
        }

        return builder.toString();
    }

}







