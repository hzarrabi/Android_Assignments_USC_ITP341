package ipt341.zarrabi.hooman.a7;

import java.util.Date;

/**
 * Created by Hooman Z on 10/27/2015.
 */
public class Note {

    private String title;
    private String content;
    private Date date;



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
