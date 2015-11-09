package ipt341.zarrabi.hooman.a8;

/**
 * Created by Hooman Z on 11/8/2015.
 */
public class Stock {

    String name;
    String brand;
    String color;
    String price;
    int stockNumber;




    public void decreaseStock()
    {
        stockNumber--;
    }

    public void increaseStock()
    {
        stockNumber++;
    }

    public Stock(String name, String brand, String color, String price, int stockNumber) {
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.price = price;
        this.stockNumber = stockNumber;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", stockNumber=" + stockNumber +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }
}
