package com.example.foodiezoneapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.foodiezoneapp.Helper.ManagementClass;
import com.example.foodiezoneapp.R;


public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private  RecyclerView recyclerViewList;
    private  ManagementClass managementClass;
    private TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
    private  double tax;
    private ScrollView scrollView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementClass = new ManagementClass(this);
        initView();
        initList();

        

    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
    }

    private void calculateCard() {
        double percentageTax = 0.02;
        double delivery = 5.2;
        tax = Math.round((managementClass.getTotalFee()*percentageTax)*100.0)/100.0;
        double total = Math.round((managementClass.getTotalFee()+tax+delivery)*100.0)/100.0;
        double itemTotal = Math.round(managementClass.getTotalFee()*100.0)/100.0;
        totalFeeTxt.setText("$" + itemTotal);
        taxTxt.setText("$"+tax);
        deliveryTxt.setText("$" + delivery);
        totalTxt.setText("$" + total);

    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt =findViewById(R.id.deliveryTxt);
        totalTxt  = findViewById(R.id.taxTxt);
        recyclerViewList = findViewById(R.id.view);
        scrollView = findViewById(R.id.scrollView);
        emptyTxt  = findViewById(R.id.emptyTxt);



    }
}