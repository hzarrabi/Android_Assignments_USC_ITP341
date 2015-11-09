package ipt341.zarrabi.hooman.a8;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Hooman Z on 11/8/2015.
 */
public class StockAdapter  extends ArrayAdapter<Stock> {
    TextView brand;
    TextView stockAmount;

    ImageView stockIcon;

    public StockAdapter (Context c, ArrayList<Stock> stocks){
        super(c,0,stocks);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Stock stock = StockSingleton.get(getContext()).getStock(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.stock_item, parent, false);
        }

        brand=(TextView) convertView.findViewById(R.id.Brand);
        stockAmount = (TextView) convertView.findViewById(R.id.stockAmount);
        stockIcon = (ImageView) convertView.findViewById(R.id.imageView);

        brand.setText(stock.getBrand());
        stockAmount.setText(Integer.toString(stock.getStockNumber()));

        if(stock.getBrand().equalsIgnoreCase("apple"))
        {
            stockIcon.setImageResource(R.drawable.apple);
        }
        else if(stock.getBrand().equalsIgnoreCase("microsoft"))
        {
            stockIcon.setImageResource(R.drawable.microsoft);
        }
        else if(stock.getBrand().equalsIgnoreCase("samsung"))
        {
            stockIcon.setImageResource(R.drawable.samsung);
        }
        else
        {
            stockIcon.setImageResource(R.drawable.logo);
            Log.d("Brandddd",stock.getBrand());
        }
        return convertView;
    }


}
