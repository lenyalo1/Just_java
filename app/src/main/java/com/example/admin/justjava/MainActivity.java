package com.example.admin.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when the order button is clicked....
     */

    public void SubmitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        //figure out if the user wants whipped cream topping...
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        //figure out if the user wants chocolate topping...
        CheckBox chocolateCreamCheckBox = (CheckBox) findViewById(R.id.chocolate_cream_checkbox);
        boolean haschocolateCream = chocolateCreamCheckBox.isChecked();

        int price = calculatePrice(haschocolateCream, hasWhippedCream);
        String pricemessage = OrderSummary(name, price, hasWhippedCream, haschocolateCream);
        displayMessage(pricemessage);
    }
    /**
     * calculate the price order......
     * return the total price.....
     * return text summary.....
     * addwhippedCream is whether or not the user wants whipped cream topping
     * haschocolate is wether or not the user wants chocolate topping....
     */
    private int calculatePrice(boolean addwhippedCream, boolean haschocolate) {
        // price of one coffee
        int baseprice = 5;
        //add $2 if the user wants whipped cream
        if (addwhippedCream) {
            baseprice = baseprice + 2;

        }
        //add $1 if the user wants chocolate cream
        if (haschocolate) {
            baseprice = baseprice + 1;

        }
        // calculate the total order price by multiplying by number of coffees
        return baseprice * numberOfCoffes;
    }


    /**
     * @param addwhippedCream is whether or not the user wants whipped cream topping
     * @return text summary
     * name of the customer
     */
    private String OrderSummary(String name, int price, boolean addwhippedCream, boolean haschocolate) {
        String pricemessage = "Name: " + name;
        pricemessage += "\nAdd whipped cream?" + addwhippedCream;
        pricemessage += "\nAdd chocolate?" + haschocolate;
        pricemessage = pricemessage + "\nquantity : " + numberOfCoffes;
        pricemessage = pricemessage + "\nTotal : $" + price;
        pricemessage = pricemessage + "\nThank you!";
        return pricemessage;

    }

    /**
     * this method displays the given price value....
     */
    private void display(int numberOfCoffes) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffes);
    }

    /**
     * this method displays the given price.....
     */
    public void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(String.valueOf(number));
    }

    /**
     * this method displays the given text on the screen...
     */
    private void displayMessage(String message) {
        TextView orderSummary = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummary.setText(message);
    }

    /**
     * this method is called when the plus button is clicked......
     */
    public void increment(View view) {
        if (numberOfCoffes==100){
            //show an  error message as a toast
            Toast.makeText(this,"you cannot have less than one coffee",Toast.LENGTH_SHORT).show();
            //Exit this method early beacause there's nothing left to do
            return;
        }
        numberOfCoffes = numberOfCoffes + 1;
        display(numberOfCoffes);
    }

    /**
     * this method is called when the plus button os clucked......
     */
    public void decrement(View view) {
        if (numberOfCoffes==1){
            return;
        }
        numberOfCoffes = numberOfCoffes - 1;
        display(numberOfCoffes);
    }


}
