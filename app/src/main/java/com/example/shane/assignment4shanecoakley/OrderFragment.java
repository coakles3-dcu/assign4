package com.example.shane.assignment4shanecoakley;

/**
 * Created by shane on 06/01/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple view.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * Activity to inflate Order Fragment
 * Main body taken from assignment 3 answer provided by Colette Kirwan
 */

public class OrderFragment extends Fragment implements CompoundButton.OnCheckedChangeListener {

    TextView mtextView;
    String mSummary ="";
    int mQuantity = 1;
    double mPrice = 0.0;
    Button order;
    Button summary;
    EditText editText;
    CheckBox checkBox1, checkBox2, checkBox3, checkBox4 ;


    /**
     * Layout for the Order tab is displayed
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ordertab3, container, false);




        checkBox1 = (CheckBox) rootView.findViewById(R.id.checkBox1);
        checkBox1.setChecked(false);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            /**
             * if a checkbox is selectedthe value associated with that checkbox is added to a string
             * @param box
             * @param isChecked
             */
            @Override
            public void onCheckedChanged(CompoundButton box, boolean isChecked) {

                {
                    StringBuilder str =
                            new StringBuilder(mtextView.getText());
                    CharSequence boxText = box.getText();
                    if (isChecked) {
                        str.append(" " + boxText + ",");
                    } else {
                        int start = str.indexOf(boxText.toString() + ",");
                        int length = boxText.length()+ 1;
                        str.replace(start, start + length, "");
                    }

                    mtextView.setText(str.toString().trim());
                }

            }




        });

        checkBox2 = (CheckBox) rootView.findViewById(R.id.checkBox2);
        checkBox2.setChecked(false);

        checkBox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {


            /**
             * if a checkbox is selectedthe value associated with that checkbox is added to a string
             * @param box
             * @param isChecked
             */
            @Override
            public void onCheckedChanged(CompoundButton box, boolean isChecked) {

                {
                    StringBuilder str =
                            new StringBuilder(mtextView.getText());
                    CharSequence boxText = box.getText();
                    if (isChecked) {
                        str.append(" " + boxText + ",");
                    } else {
                        int start = str.indexOf(boxText.toString() + ",");
                        int length = boxText.length()+ 1;
                        str.replace(start, start + length, "");
                    }

                    mtextView.setText(str.toString().trim());
                }
            }
        });

        checkBox3 = (CheckBox) rootView.findViewById(R.id.checkBox3);
        checkBox3.setChecked(false);

        checkBox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            /**
             * if a checkbox is selectedthe value associated with that checkbox is added to a string
             * @param box
             * @param isChecked
             */

            @Override
            public void onCheckedChanged(CompoundButton box, boolean isChecked) {
                {
                    StringBuilder str =
                            new StringBuilder(mtextView.getText());
                    CharSequence boxText = box.getText();
                    if (isChecked) {
                        str.append(" " + boxText + ",");
                    } else {
                        int start = str.indexOf(boxText.toString() + ",");
                        int length = boxText.length()+ 1;
                        str.replace(start, start + length, "");
                    }

                    mtextView.setText(str.toString().trim());
                }
            }
        });

        checkBox4 = (CheckBox) rootView.findViewById(R.id.checkBox4);
        checkBox4.setChecked(false);

        checkBox4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            /**
             * if a checkbox is selectedthe value associated with that checkbox is added to a string
             * @param box
             * @param isChecked
             */

            @Override
            public void onCheckedChanged(CompoundButton box, boolean isChecked) {

                {
                    StringBuilder str =
                            new StringBuilder(mtextView.getText());
                    CharSequence boxText = box.getText();
                    if (isChecked) {
                        str.append(" " + boxText + ",");
                    } else {
                        int start = str.indexOf(boxText.toString() + ",");
                        int length = boxText.length()+ 1;
                        str.replace(start, start + length, "");
                    }

                    mtextView.setText(str.toString().trim());
                }
            }
        });



        order= (Button)rootView.findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitOrder(v);
            }
        });

        summary= (Button)rootView.findViewById(R.id.summary);
        summary.setOnClickListener(new View.OnClickListener() {

            /**
             * Once selected a summary of all checkboxes is displayed
             * @param v
             */

            @Override
            public void onClick(View v) {
                Summary(v);
            }
        });


        Spinner spinner = (Spinner) rootView.findViewById(R.id.spinnerInputType);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.ui_number_entries, R.layout.spinner_1);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //http://stackoverflow.com/questions/23449270/setonitemselectedlistener-for-spinner-in-fragment
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mQuantity =  position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        mtextView = (TextView) rootView.findViewById(R.id.textView1);
        editText = (EditText) rootView.findViewById(R.id.name_field);




        return rootView;




    }
    @Override
    public void onCheckedChanged(CompoundButton box, boolean isChecked)
    {
        StringBuilder str =
                new StringBuilder(mtextView.getText());
        CharSequence boxText = box.getText();
        if (isChecked) {
            str.append(" " + boxText + ",");
        } else {
            int start = str.indexOf(boxText.toString() + ",");
            int length = boxText.length()+ 1;
            str.replace(start, start + length, "");
        }

        mtextView.setText(str.toString().trim());
    }

    /**
     * customers order is submitted
     * @param view
     */

    public void submitOrder(View view) {

        //incase of caching
        if (getActivity().getIntent()!= null)
        {
            getActivity().getIntent().removeExtra(Intent.EXTRA_TEXT);
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        String summary = "";
        summary = createOrderSummary();
        intent.putExtra(Intent.EXTRA_TEXT, summary);


        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send email..."));
        }
    }

    /**
     * calculate the price of the pizza
     * @param toppings
     * @return
     */
    private double calculatePrice( String toppings) {
        // First calculate the price of pizza
        double basePrice = 10.0;


        // If the user wants Mushrooms, add €1 per topping
        if (toppings.contains("Mushrooms")) {
            basePrice = basePrice + 1 ;
        }

        // If the user wants Pepperoni, add €1 per topping
        if (toppings.contains("Pepperoni")) {
            basePrice = basePrice + 1;

        }
        // If the user wants Extra Cheese, add €1 per topping
        if (toppings.contains("Extra Cheese")) {
            basePrice = basePrice + 1 ;
        }

        // If the user wants Onions, add €1 per topping
        if (toppings.contains("Onions")) {
            basePrice = basePrice + 1;
        }
        // Calculate the total order price by multiplying by the quantity
        return basePrice * mQuantity;
    }




    private String createOrderSummary( ) {


        String toppings = mtextView.getText().toString();
        mPrice = calculatePrice(toppings);

/** the below text heading , should in the strings.xml file, but taken out to show you the contents */
        String priceMessage = "Name:" + " " + editText.getText().toString();
        priceMessage += "\n" + "Standard Margherita Pizza";
        priceMessage += "\n" + "Extra Toppings: " + mtextView.getText().toString();
        priceMessage += "\n" + "Quantity: " + mQuantity;
        priceMessage += "\n" + "Price: " + NumberFormat.getCurrencyInstance().format(mPrice);
        //priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;

        //update screen
    }


    public void Summary(View v) {

        Toast.makeText(getActivity().getApplicationContext(), createOrderSummary(), Toast.LENGTH_LONG).show();
    }



}