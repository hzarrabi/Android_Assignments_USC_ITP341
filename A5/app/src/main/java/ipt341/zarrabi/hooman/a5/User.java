package ipt341.zarrabi.hooman.a5;

/**
 * Created by Hooman Z on 10/2/2015.
 */
public class User {
    public String name;
    public String email;
    public String phone;
    public String address;
    public String notes;
    int pic;

    User(String [] info, int picID)
    {
        this.name=info[0];
        this.email=info[1];
        this.phone=info[2];
        this.address=info[3];
        this.notes=info[4];
        pic=picID;
    }

}
