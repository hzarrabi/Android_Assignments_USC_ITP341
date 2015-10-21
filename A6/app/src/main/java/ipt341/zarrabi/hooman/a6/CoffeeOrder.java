package ipt341.zarrabi.hooman.a6;

/**
 * Created by Hooman Z on 10/20/2015.
 */
public class CoffeeOrder {

    String brew;
    int size;// 0 for small, 1 for medium, 2 for large
    Boolean sugar;
    Boolean milk;
    String instruction;


    public CoffeeOrder(Boolean milk, Boolean sugar, int size, String brew, String instruction) {
        this.milk = milk;
        this.sugar = sugar;
        this.size = size;
        this.brew =  brew;
        this.instruction=instruction;
    }



    public String getBrew() {
        return brew;
    }

    public void setBrew(String name) {
        this.brew = name;
    }

    public Boolean getMilk() {
        return milk;
    }

    @Override
    public String toString() {
        return "CoffeeOrder{" +
                "brew='" + brew + '\'' +
                ", size=" + size +
                ", sugar=" + sugar +
                ", milk=" + milk +
                ", instruction='" + instruction + '\'' +
                '}';
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
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
