package com.eljo.skhye05.modalbottomsheet_example;

import android.graphics.Color;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.eljo.skhye05.custombottomsheet.CustomBottomSheetFragment;
import com.eljo.skhye05.custombottomsheet.CustomBottomSheetItem;
import com.eljo.skhye05.custombottomsheet.CustomBottomSheetTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<CustomBottomSheetItem> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn_bottom_sheet);

        CustomBottomSheetItem item = new CustomBottomSheetItem("LUI", android.R.drawable.ic_dialog_map);
        itemList.add(item);

        item = new CustomBottomSheetItem("VOUS", android.R.drawable.ic_dialog_map);
        itemList.add(item);

        item = new CustomBottomSheetItem("NOUS", android.R.drawable.ic_dialog_map);
        itemList.add(item);

        item = new CustomBottomSheetItem("VOUS", android.R.drawable.ic_dialog_map);
        itemList.add(item);

        item = new CustomBottomSheetItem("NOUS", android.R.drawable.ic_dialog_map);
        itemList.add(item);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomBottomSheetFragment bottomSheetFragment = new CustomBottomSheetFragment(android.R.drawable.ic_dialog_email, "MOI MEME", itemList);
                bottomSheetFragment.setTitleContainerBg(Color.parseColor("red"));
                bottomSheetFragment.show(getSupportFragmentManager(), bottomSheetFragment.getTag());

            }
        });
    }

    private void prepareData() {


    }
}
