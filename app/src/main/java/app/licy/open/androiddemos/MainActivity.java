package app.licy.open.androiddemos;

import androidx.annotation.ContentView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.licy.open.androiddemos.ui.IntentTestActivity;
import app.licy.open.androiddemos.ui.PermissionTestActivity;
import app.licy.open.androiddemos.ui.ServiceTestActivity;
import app.licy.open.androiddemos.ui.TestActivity;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private Context mContext;

    private List<String> mTitles = new ArrayList<>();
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        mRecyclerView = findViewById(R.id.rv_content);

        initRv();
    }


    private void initRv() {

        mTitles.add("权限控制");
        mTitles.add("测试");
        mTitles.add("Intent测试");
        mTitles.add("IntentService测试");

        mMyAdapter = new MyAdapter(mTitles, mContext);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mMyAdapter);

        mMyAdapter.setClickListener(new RecycleViewItemClickListener<String>() {
            @Override
            public void onItemClick(int position, List<String> data) {
                switch (position) {
                    case 0:
                        // 权限控制
                        startActivity(new Intent(mContext, PermissionTestActivity.class));
                        break;
                    case 1:
                        // 权限控制
                        startActivity(new Intent(mContext, TestActivity.class));
                        break;
                    case 2:
                        // 权限控制
                        startActivity(new Intent(mContext, IntentTestActivity.class));
                        break;
                    case 3:
                        // 权限控制
                        startActivity(new Intent(mContext, ServiceTestActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }


    private static class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

        private List<String> data;
        private Context mMyContext;

        private RecycleViewItemClickListener<String> mClickListener;

        public void setClickListener(RecycleViewItemClickListener<String> clickListener) {
            mClickListener = clickListener;
        }

        public MyAdapter(List<String> data, Context context) {
            this.data = data;
            this.mMyContext = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mMyContext).inflate(R.layout.item_rv_main, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
            holder.mTextView.setText(data.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mClickListener != null) {
                        mClickListener.onItemClick(position, data);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.tv_name);
        }
    }

    private interface RecycleViewItemClickListener<T> {
        void onItemClick(int position, List<T> data);
    }
}
