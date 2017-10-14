package com.jephy.recyclerviewpractice;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

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
        RecyclerView.Adapter mAdapter = new MyAdapter(this,dataArray);
        listView.setAdapter(mAdapter);

    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>  {
        private String[] dataArray;
        private Context context;

        public MyAdapter(Context context, String[] dataArray) {
            this.context = context;
            this.dataArray = dataArray;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view  =LayoutInflater.from(context).inflate(R.layout.list_text_item, parent, false);
            final MyViewHolder viewHolder = new MyViewHolder(view);
//            final int positon = (int) viewHolder.view.getTag();
            viewHolder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getLayoutPosition();
                    Toast.makeText(context,"点击了"+position,Toast.LENGTH_SHORT).show();
                }
            });

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.textView.setText(dataArray[position]);
        }

        @Override
        public int getItemCount() {
            return dataArray.length;
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public View view;
        public MyViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            textView = itemView.findViewById(R.id.text_tv);
        }
    }
}
