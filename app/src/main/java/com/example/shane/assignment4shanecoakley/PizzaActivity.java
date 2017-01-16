package com.example.shane.assignment4shanecoakley;

/**
 * Created by shane on 16/01/2017.
 */

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class PizzaActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener,
        AdapterView.OnItemSelectedListener {

    TextView mtextView;
    String mSummary ="";
    int mQuantity = 1;
    double mPrice = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pizza_activity);

        ((CheckBox) findViewById(R.id.checkBox1))
                .setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkBox2))
                .setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkBox3))
                .setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.checkBox4))
                .setOnCheckedChangeListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.spinnerInputType);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ui_number_entries, R.layout.spinner_1);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        mtextView = (TextView) findViewById(R.id.textView1);

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

    public void submitOrder(View view) {

        //incase of caching
        if (getIntent()!= null)
        {
            getIntent().removeExtra(Intent.EXTRA_TEXT);
        }
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        String summary = "";
        summary = createOrderSummary();
        intent.putExtra(Intent.EXTRA_TEXT, summary);


        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(intent, "Send email..."));
        }
    }

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

    /**
     * Create summary of the order.
     *

     */

    private String createOrderSummary( ) {

        EditText editText = (EditText) findViewById(R.id.name_field);
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

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using

        mQuantity =  pos + 1;
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void Summary(View view) {

        Toast.makeText(getApplicationContext(), createOrderSummary(), Toast.LENGTH_LONG).show();
    }
}