package com.eljo.skhye05.custombottomsheet;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class CustomBottomSheetFragment extends BottomSheetDialogFragment {

    private int mTitleIcon;
    private String mTitleText;
    private LinearLayout mTitleContainer;
    private TextView mTitleTextView;

    private RecyclerView mRecyclerView;
    private CustomBottomSheetAdapter mAdapter;

    private View mView;
    private List<CustomBottomSheetItem> mItems = new ArrayList<>();
    private OnItemClickListener listener;

    private int mTheme = R.style.BottomSheetDialogTheme;

    @SuppressLint("ValidFragment")
    public CustomBottomSheetFragment(int tIcn, String tTxt, List<CustomBottomSheetItem> items) {
        mTitleIcon = tIcn;
        mTitleText = tTxt;
        mItems = items;
        this.listener = null;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mView = inflater.inflate(R.layout.fragment_bottom_sheet_dialog, container, false);
        TextView title = mView.findViewById(R.id.textTitle);
        title.setText(mTitleText);

        ImageView iconTitle = mView.findViewById(R.id.iconTitle);
        iconTitle.setImageResource(mTitleIcon);

        mTitleContainer = mView.findViewById(R.id.titleContainer);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.item_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mAdapter = new CustomBottomSheetAdapter(this.mItems);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mView.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new CustomBottomSheetTouchListener(mView.getContext(), mRecyclerView, new CustomBottomSheetTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if (listener != null)
                    listener.onClick(position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return mView;
    }

//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        return new BottomSheetDialog(requireContext(), );
//    }

    public void setTitleContainerBg(int color) {
//        titleContainer.setBackgroundColor(Color.parseColor("red"));
    }

    public void setTitleTextColor(int color) {
        mTitleTextView.setTextColor(color);
    }

    public void setItems(List<CustomBottomSheetItem> items) {
        this.mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public RecyclerView getmRecyclerView() {
        return mRecyclerView;
    }

    public interface OnItemClickListener {
        public void onClick(int position);
    }

}

