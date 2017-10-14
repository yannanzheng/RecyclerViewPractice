package com.jephy.recyclerviewpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IMainView{

    @BindView(R.id.recycler_view)
    RecyclerView listView;

    String[] dataArray = {"1","2","3","4","5","6","7","8","9","10"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        listView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(listView.getContext(),
                LinearLayoutManager.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        listView.addItemDecoration(dividerItemDecoration);
        RecyclerView.Adapter mAdapter = new MainPresenterImp.MyAdapter(this,dataArray);
        listView.setAdapter(mAdapter);

    }

     static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public Button button1;
        public Button button2;
        public Button button3;
        public Button button4;

        private OnChildViewClickListener onChildViewClickListener;

        public void setOnChildViewClickListener(OnChildViewClickListener onChildViewClickListener) {
            this.onChildViewClickListener = onChildViewClickListener;
        }

        public  MyViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_tv);
            button1 = itemView.findViewById(R.id.button_1_bt);
            button2 = itemView.findViewById(R.id.button_2_bt);
            button3 = itemView.findViewById(R.id.button_3_bt);
            button4 = itemView.findViewById(R.id.button_4_bt);

            textView.setOnClickListener(this);
            button1.setOnClickListener(this);
            button2.setOnClickListener(this);
            button3.setOnClickListener(this);
            button4.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.text_tv:
                    onChildViewClickListener.onTextView(textView);
                    break;
                case R.id.button_1_bt:
                    onChildViewClickListener.onButton1(button1);
                    break;
                case R.id.button_2_bt:
                    onChildViewClickListener.onButton2(button2);
                    break;
                case R.id.button_3_bt:
                    onChildViewClickListener.onButton3(button3);
                    break;
                case R.id.button_4_bt:
                    onChildViewClickListener.onButton4(button4);
                    break;
                default:
            }
        }

        interface OnChildViewClickListener {
            void onTextView(TextView textView);
            void onButton1(Button button);
            void onButton2(Button button);
            void onButton3(Button button);
            void onButton4(Button button);
        }
    }
}
