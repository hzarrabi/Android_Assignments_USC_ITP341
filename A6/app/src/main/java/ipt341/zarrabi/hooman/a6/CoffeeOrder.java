package ipt341.zarrabi.hooman.a6;

/**
 * Created by Hooman Z on 10/20/2015.
 */
public class CoffeeOrder {

    String name;
    int size;// 0 for small, 1 for medium, 2 for large
    Boolean sugar;
    Boolean milk;


    public CoffeeOrder(Boolean milk, Boolean sugar, int size, String name) {
        this.milk = milk;
        this.sugar = sugar;
        this.size = size;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", sugar=" + sugar +
                ", milk=" + milk +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getMilk() {
        return milk;
    }

    public void setMilk(Boolean milk) {
        this.milk = milk;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Boolean getSugar() {
        return sugar;
    }

    public void setSugar(Boolean sugar) {
        this.sugar = sugar;
    }
}
