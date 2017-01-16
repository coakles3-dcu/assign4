package com.example.shane.assignment4shanecoakley;

/**
 * Created by shane on 06/01/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NavUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MenuFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.menutab2, container, false);


        // getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setContentView(R.layout.activity_pizza_menu);
        final ArrayList<Pizza> pizzas = new ArrayList<Pizza>();


        pizzas.add(new Pizza(R.drawable.hawaiian, R.string.pizza1,R.string.example_description1));
        pizzas.add(new Pizza(R.drawable.margeherita, R.string.pizza2,R.string.example_description2));
        pizzas.add(new Pizza(R.drawable.pepperoni_pizza,R.string.pizza3,R.string.example_description3));
        pizzas.add(new Pizza(R.drawable.spinach_pizza, R.string.pizza4,R.string.example_description4));
        pizzas.add(new Pizza(R.drawable.meat_lovers, R.string.pizza5,R.string.example_description5));
        pizzas.add(new Pizza(R.drawable.mushroom_pizza, R.string.pizza6,R.string.example_description6));
        pizzas.add(new Pizza(R.drawable.fiery_hawaiian, R.string.pizza8,R.string.example_description8));
        pizzas.add(new Pizza(R.drawable.margeherita, R.string.pizza2,R.string.example_description2));
        pizzas.add(new Pizza(R.drawable.pepperoni_pizza,R.string.pizza3,R.string.example_description3));
        pizzas.add(new Pizza(R.drawable.hawaiian, R.string.pizza1,R.string.example_description1));



        PizzaAdapter adapter = new PizzaAdapter(getActivity(), pizzas, R.color.category_colors);

        ListView listView = (ListView) rootView.findViewById(R.id.listView);


        listView.setAdapter(adapter);

        // Set a click listener to show the toast message
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                // Get the {@link Pizza} object at the given position the user clicked on . Use created array
                Pizza word = pizzas.get(position);
                String colourWord = getActivity().getBaseContext().getResources().getString(word.getPizzaDescId() );
                Toast.makeText(getActivity().getApplicationContext(), colourWord, Toast.LENGTH_LONG).show();
            }


        });

        return rootView;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == android.R.id.home) {

            NavUtils.navigateUpFromSameTask(getActivity());
        }

        return super.onOptionsItemSelected(item);

    }

}