package com.varshayadv.justjava;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.TextView;

        import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity=quantity+1;//for double use *2
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity=quantity-1;//for double use/2
        displayQuantity(quantity);
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate=chocolateCheckBox.isChecked();
        CheckBox whippedCreamCheackBox =(CheckBox) findViewById(R.id.whipped_cream_checkbox);

        /** we are calling a method on the whippedCreamCheckBox java object
         *  and the method is called isChecked this has a return value of boolen
         *  and is stored in haswhippedCream
         */
        boolean hasWhippedCream=whippedCreamCheackBox.isChecked();
        Log.v("MainActivity","Hascream"+hasWhippedCream);
        int price=calculatePrice();
        String priceMessage= createOrderSummary(price,hasWhippedCream,hasChocolate);;
        displayMessage(priceMessage);

    }
    /**
     * Calculates the price of the order.
     *
     */
    private int calculatePrice() {
        int price=  quantity * 5;
        return price;
    }
    private String createOrderSummary(int price ,boolean addWhippedCream ,boolean addChocolate){
        String priceMessage= "Name: Kunal";
        priceMessage+="\nAdd whippedCream " +addWhippedCream;
        priceMessage+="\nAdd chocolate "+addChocolate;
        priceMessage+="\nQuantity: "+quantity;
        priceMessage=priceMessage+"\nTotal: $"+price;
        priceMessage=priceMessage+"\nThanku!";
        return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numbers ) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numbers);
    }

    private void displayMessage(String message) {
        TextView orderTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderTextView.setText(message);
    }
}