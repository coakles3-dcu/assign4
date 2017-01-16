package com.example.shane.assignment4shanecoakley;

/**
 * Created by shane on 16/01/2017.
 */
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter class to display different types of pizzas
 *
 * Created by shane on 16/01/2017.
 * Taken from answer to assignment 3 from Colette Kirwan
 */

public class PizzaAdapter extends ArrayAdapter<Pizza>
{

    /**
     * Resource ID for the background color for this list of colours
     */
    private int mColorResourceId;


    public PizzaAdapter(Context context, ArrayList<Pizza> pizzas, int colorResourceId)
    {
        super(context, 0, pizzas);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View listItemView = convertView;
        if (listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.listview, parent, false);
        }


        Pizza currentWord = getItem(position);


        TextView cTextView = (TextView) listItemView.findViewById(R.id.pizzaName_text_view);

        cTextView.setText(currentWord.getPizzaNameId());

        TextView dTextView = (TextView) listItemView.findViewById(R.id.pizzaDesc_text_view);

        dTextView.setText(currentWord.getPizzaDescId());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if (currentWord.hasImage())
        {

            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else
        {

            imageView.setVisibility(View.GONE);
        }


        View textContainer = listItemView.findViewById(R.id.text_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);


        return listItemView;
    }
}
