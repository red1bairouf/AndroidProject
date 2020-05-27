package com.ensias.ProjetAndroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.ensias.ProjetAndroid.Database.OrderDb;
import com.ensias.ProjetAndroid.Model.Food;
import com.ensias.ProjetAndroid.Model.Order;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class FoodDetail extends AppCompatActivity {
    static OrderDb orderdb;
    TextView food_name,food_price,food_Descriptipon;
    ImageView food_Image;
    CollapsingToolbarLayout collapsingToolbarLayout;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    String foodId= "";
    FirebaseDatabase database;
    DatabaseReference foods;
    Food currentFood ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        database = FirebaseDatabase.getInstance();
        foods= database.getReference("Foods");
        numberButton =(ElegantNumberButton)findViewById(R.id.number_button);
        orderdb = Room.databaseBuilder(getApplicationContext(),OrderDb.class, "order_db").allowMainThreadQueries().build() ;
        btnCart = (FloatingActionButton)findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orderdb.OrderDao().insertOrder(new Order(
                        foodId,
                    currentFood.getName(),
                    numberButton.getNumber(),
                    currentFood.getPrice(),
                    currentFood.getDiscount()));
                Toast.makeText(FoodDetail.this , "Added to cart" , Toast.LENGTH_SHORT ).show();
            }
        });

        food_Descriptipon = (TextView)findViewById(R.id.food_description);
        food_price = (TextView)findViewById(R.id.food_price);
        food_name = (TextView)findViewById(R.id.food_name);
        food_Image = (ImageView) findViewById(R.id.img_food);
        collapsingToolbarLayout= (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsedAppbar);
        if(getIntent()!=null)
            foodId=getIntent().getStringExtra("FoodId");
        if(!foodId.isEmpty()){
            getDetailFood(foodId);
        }


    }

    private void getDetailFood(String foodId) {
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentFood = dataSnapshot.getValue(Food.class);
                Picasso.with(getBaseContext()).load(currentFood.getImage()).into(food_Image);
                collapsingToolbarLayout.setTitle(currentFood.getName());
                food_price.setText(currentFood.getPrice());
                food_name.setText(currentFood.getName());
                food_Descriptipon.setText(currentFood.getDescription());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

