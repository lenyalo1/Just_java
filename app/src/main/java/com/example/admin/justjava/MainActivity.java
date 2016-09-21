package com.example.admin.justjava;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffes=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * this method is called when the order button is clicked....
     */

    public void SubmitOrder(View view){
        int price =numberOfCoffes*5;
    String pricemessage="Total : $" + price;
        pricemessage=pricemessage + "\nThank you!";
        displayMessage(pricemessage);

    }

    /**
     * this method displays the given price value....
     */
    private void display(int number){
        TextView quantityTextView=(TextView)findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * this method displays the given price.....
     */
    public void displayPrice (int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(String.valueOf(number));
    }

    /**
     * this method displays the given text on the screen...
     */
        private void displayMessage(String message){
            TextView priceTextView=(TextView)findViewById(R.id.price_text_view);
           priceTextView.setText(message);
        }

    /**
     * this method is called when the plus button is clicked......
     */
    public void increment(View view){
        numberOfCoffes=numberOfCoffes +1;
        display(numberOfCoffes);
    }



    /**
     * this method is called when the plus button os clucked......
     */
     public void decrement(View view){
         numberOfCoffes=numberOfCoffes -2;
         display(numberOfCoffes);
     }


}
