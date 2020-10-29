package com.example.np.retrofitgitlab;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityGetPostAdapter extends RecyclerView.Adapter<ActivityGetPostAdapter.ViewHolder> {

    public List<ActivityListPost> activityListPosts = new ArrayList<>();
    Context context;
    boolean maxLines;

    public ActivityGetPostAdapter(Context context, List<ActivityListPost> activityListPosts) {
        this.activityListPosts = activityListPosts;
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_list_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final ActivityListPost activityListPost = activityListPosts.get(position);
        holder.id.setText(activityListPost.getId());
        holder.userId.setText(activityListPost.getUserId());
        holder.title.setText(activityListPost.getTitle());
        holder.body.setText(activityListPost.getBody());
        holder.linearClickPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!maxLines) {
                    holder.title.setMaxLines(1);
                    holder.body.setMaxLines(2);
                    maxLines = true;

                }else{
                    holder.title.setMaxLines(Integer.MAX_VALUE);
                    holder.body.setMaxLines(Integer.MAX_VALUE);
                    maxLines = false;

                }

            }
        });

        holder.imgComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), ActivityCommentPost.class);
                intent.putExtra(ActivityCommentPost.ID,activityListPost.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view.getContext().startActivity(intent);
            }
        });

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

                Intent intent1 = new Intent(view1.getContext(), ActivityEditPost.class);
                intent1.putExtra(ActivityEditPost.id, activityListPost.getId());
                intent1.putExtra(ActivityEditPost.userId, activityListPost.getId());
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view1.getContext().startActivity(intent1);

            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent2 = new Intent(view2.getContext(), ActivityDeletePost.class);
                intent2.putExtra(ActivityDeletePost.ID, activityListPost.getId());
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                view2.getContext().startActivity(intent2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return activityListPosts.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView id;
        public TextView title;
        public TextView body;
        public TextView userId;
        public ImageView imgComment;
        public ImageView imgEdit;
        public ImageView imgDelete;
        public LinearLayout linearClickPost;
        public LinearLayout linearClickTitle;
        public LinearLayout linearClickBody;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.id);
            title = (TextView) itemView.findViewById(R.id.tiTle);
            body = (TextView) itemView.findViewById(R.id.body);
            userId = (TextView) itemView.findViewById(R.id.userId);
            imgComment = (ImageView) itemView.findViewById(R.id.imgComment);
            imgEdit = (ImageView) itemView.findViewById(R.id.imgEdit);
            imgDelete = (ImageView) itemView.findViewById(R.id.imgDelete);
            linearClickPost = (LinearLayout) itemView.findViewById(R.id.linearClickPost);
            linearClickTitle = (LinearLayout) itemView.findViewById(R.id.linearClickTitle);
            linearClickBody = (LinearLayout) itemView.findViewById(R.id.linearClickBody);

        }

    }
}
