import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private String model;
    private String color;
    private int year;
    private int weight;
    private int price;
    private int serial_number;

    public Car() {
        year = 0;
        model= "";
        color= "";
        weight= 0;
        price= 0;
        serial_number= 0;
        brand= "";
    }
    public Car(int year, String model, String color, int weight, int price, int serial_number,String Brand )
    {
        setYear(year);
        setModel(model);
        setColor(color);
        setWeight(weight);
        setPrice(price);
        setSerial_number(serial_number);
        setBrand(Brand);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(int serial_number) {
        this.serial_number = serial_number;
    }

}
