package com.example.poststatus.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poststatus.R;
import com.example.poststatus.activity.PostDetailActivity;
import com.example.poststatus.model.Status;

import java.util.List;

public class StatusListAdapter extends RecyclerView.Adapter<StatusListAdapter.ViewHolder> {

    //MainActivity StatusList;
    private Context context;
    private List<Status> statusList;

    public StatusListAdapter(Context context, List<Status> statusList) {
        this.context = context;
        this.statusList = statusList;
    }

    @NonNull
    @Override
    public StatusListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatusListAdapter.ViewHolder holder, int position) {
        Status status = statusList.get(position);

        holder.imgUserAvatar.setImageResource(status.getAvartar());
        holder.txtUserName.setText(status.getName());
    }

    @Override
    public int getItemCount() {
        return statusList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public LinearLayout llContent;
        public ImageView imgUserAvatar;
        public TextView txtUserName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            llContent = itemView.findViewById(R.id.llContent);
            imgUserAvatar = itemView.findViewById(R.id.imgUserAvatar);
            txtUserName = itemView.findViewById(R.id.txtUserName);

            llContent.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int postion = this.getAdapterPosition();
            Status status = statusList.get(postion);

            int avartar = status.getAvartar();
            String name = status.getName();
            int post = status.getPost();
            int noOfComment = status.getNoOfComments();

            Intent intent = new Intent(context, PostDetailActivity.class);
            intent.putExtra("avartar", avartar);
            intent.putExtra("name", name);
            intent.putExtra("post", post);
            intent.putExtra("noOfComment", noOfComment);
            context.startActivity(intent);
        }
    }
}
