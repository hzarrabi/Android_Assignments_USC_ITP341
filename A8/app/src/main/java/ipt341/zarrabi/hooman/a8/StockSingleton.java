package ipt341.zarrabi.hooman.a8;

import android.content.Context;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Hooman Z on 11/8/2015.
 */
public class StockSingleton {

    private Context context;
    private ArrayList<Stock> stocks;
    private static StockSingleton stockSingleton;
    //private JSONSerializer mSerializer;

    private StockSingleton(Context context) {
        this.context = context;

        stocks=new ArrayList<Stock>();
    }


    public static StockSingleton get(Context c) {
        if (stockSingleton == null) {
            stockSingleton = new StockSingleton(c.getApplicationContext());
        }
        return stockSingleton;
    }

    public ArrayList<Stock> getStocks()
    {
        return stocks;
    }

    public Stock getStock(int position)
    {
        return stocks.get(position);
    }

    public void addStock(Stock s)
    {
        stocks.add(s);
        //TODO sorttttttt
    }

    public void deleteStock (int position)
    {
        stocks.remove(position);//
        //TODO sorttttt
    }

}
