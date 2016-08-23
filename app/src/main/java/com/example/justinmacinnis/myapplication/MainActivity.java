package com.example.justinmacinnis.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    final private int coffeePrice = 5;
    final private int whippedPrice = 1;
    final private int chocolatePrice = 2;
    private int finalPrice = 0;
    private String customerName = "";
    private int quantity;
    private Boolean isWhippedChecked = false;
    private Boolean isChocolateChecked = false;

    public Boolean getChocolateChecked() {
        return isChocolateChecked;
    }

    public Boolean getWhippedChecked() {
        return isWhippedChecked;
    }

    public void setWhippedChecked(CheckBox whippedChecked) {
        if (whippedChecked.isChecked()) {
            isWhippedChecked = true;
        } else {
            isWhippedChecked = false;
        }
    }

    public void setChocolateChecked(CheckBox chocolateChecked) {
        if (chocolateChecked.isChecked()) {
            isChocolateChecked = true;
        } else {
            isChocolateChecked = false;
        }
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(View view) {
        if (view.getId() == R.id.button_plus) {
            this.quantity += 1;
        } else {
            this.quantity -= 1;
        }
        TextView numberView = (TextView) findViewById(R.id.quantity_view);
        numberView.setText(Integer.toString(this.quantity));
    }



    public int getCoffeePrice() {
        return coffeePrice;
    }

    public int getWhippedPrice() {
        return whippedPrice;
    }

    public int getChocolatePrice() {
        return chocolatePrice;
    }

    public int getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice() {
        this.finalPrice += this.getCoffeePrice();
        if (getWhippedChecked()) { this.finalPrice += this.getWhippedPrice(); }
        if (getChocolateChecked()) { this.finalPrice += this.getChocolatePrice(); }
        this.finalPrice *= this.getQuantity();
    }

    public void submitOrder(View view) {
        finalPrice = 0;
        TextView outputView = (TextView) findViewById(R.id.submit_text_view);
        setCustomerName((EditText) findViewById(R.id.name_field));
        setChocolateChecked((CheckBox) findViewById(R.id.chocolate_checkbox));
        setWhippedChecked((CheckBox) findViewById(R.id.whipped_checkbox));
        setFinalPrice();

        String submitText = "Name: " + this.getCustomerName() +
                "\nNumber of Coffee(s): " + this.getQuantity() +
                "\nPrice: $" + getFinalPrice() +
                "\nThank you for your order!";

        outputView.setText(submitText);
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(EditText name) {
        this.customerName = name.getText().toString();
    }


}
