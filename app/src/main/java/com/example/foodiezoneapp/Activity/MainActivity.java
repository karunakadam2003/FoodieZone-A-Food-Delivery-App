package com.example.foodiezoneapp.Activity;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.foodiezoneapp.Adapter.CategoryAdapter;
import com.example.foodiezoneapp.Adapter.RecommendedAdapter;
import com.example.foodiezoneapp.Domain.CategoryDomain;
import com.example.foodiezoneapp.Domain.FoodDomain;

import com.example.foodiezoneapp.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter1,adapter2;
    private  RecyclerView recyclerViewCategoryList, recyclerViewPopularList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        System.out.println("RecyclerViewCategory");
        recyclerViewPopular();
        System.out.println("RecyclerViewPopular");
    }

   private void recyclerViewPopular() {
       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
       recyclerViewPopularList = findViewById(R.id.rvPopular);
       recyclerViewPopularList.setLayoutManager(linearLayoutManager);

       ArrayList<FoodDomain> arrayFood = new ArrayList<>();
       arrayFood.add(new FoodDomain("Pepperoni pizza", "pizza1", "slices pepperoni,mozzerella cheese, fresh oregano, ground black pepper, pizza sauce", 8.76, 100, 4, 1000));
       arrayFood.add(new FoodDomain("Cheese Burger", "pizza2", "beef, Gouda Cheese, Special Sauce, Lettuce, tomato", 9.16, 100, 5, 900));
       arrayFood.add(new FoodDomain("Vegetable pizza", "pizza1", "olive oil, Vegetable oil, pitted kalamata, cherry tomatoes, fresh oregano, basil", 10.76, 100, 5, 1200));

       adapter2 = new RecommendedAdapter(arrayFood);
       recyclerViewPopularList.setAdapter(adapter2);
   }

    private void recyclerViewCategory(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.rvCategories);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);


        ArrayList<CategoryDomain> arrayList = new ArrayList();
        arrayList.add(new CategoryDomain("Pizza","cat_1"));
        arrayList.add(new CategoryDomain("Burger","cat_2"));
        arrayList.add(new CategoryDomain("Hotdog","cat_3"));
        arrayList.add(new CategoryDomain("Drink","cat_4"));
        arrayList.add(new CategoryDomain("Donut","cat_5"));
        adapter1 = new CategoryAdapter(arrayList);
        recyclerViewCategoryList.setAdapter(adapter1);




    }
}