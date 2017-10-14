package com.jephy.recyclerviewpractice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by jfyang on 10/14/17.
 */

public class MainPresenterImp implements IMainPresenter{

    public static class MyAdapter extends RecyclerView.Adapter<MainActivity.MyViewHolder> {
        private String[] dataArray;
        private Context context;

        public MyAdapter(Context context, String[] dataArray) {
            this.context = context;
            this.dataArray = dataArray;
        }

        @Override
        public MainActivity.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view  = LayoutInflater.from(context).inflate(R.layout.list_text_item, parent, false);
            final MainActivity.MyViewHolder viewHolder = new MainActivity.MyViewHolder(view);
//            final int positon = (int) viewHolder.view.getTag();
            viewHolder.setOnChildViewClickListener(new MainActivity.MyViewHolder.OnChildViewClickListener() {
                @Override
                public void onTextView(TextView textView) {
                    Toast.makeText(context,"click"+textView.getText().toString(),Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onButton1(Button button) {
                    Toast.makeText(context,"click"+button.getText().toString(),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onButton2(Button button) {
                    Toast.makeText(context,"click"+button.getText().toString(),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onButton3(Button button) {
                    Toast.makeText(context,"click"+button.getText().toString(),Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onButton4(Button button) {
                    Toast.makeText(context,"click"+button.getText().toString(),Toast.LENGTH_SHORT).show();

                }
            });

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MainActivity.MyViewHolder holder, final int position) {
            holder.textView.setText(dataArray[position]);
        }

        @Override
        public int getItemCount() {
            return dataArray.length;
        }

    }
}
