package com.example.np.retrofitgitlab;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityCommentAdapter extends RecyclerView.Adapter<ActivityCommentAdapter.CommentViewHolder> {

    public List<ActivityListComment> activityListComments = new ArrayList<>();
    Context context;
    boolean maxLines;

    public ActivityCommentAdapter(Context context, List<ActivityListComment> activityListComments) {
        this.activityListComments = activityListComments;
        this.context=context;

    }


    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view1 = LayoutInflater.from(context).inflate(R.layout.list_comment, parent, false);
        return new CommentViewHolder(view1);
    }

    @Override
    public void onBindViewHolder(final CommentViewHolder holder, int position) {
        final ActivityListComment activityListComment = activityListComments.get(position);
        holder.postId.setText(activityListComment.getPostId());
        holder.id1.setText(activityListComment.getId());
        holder.name1.setText(activityListComment.getName());
        holder.email.setText(activityListComment.getEmail());
        holder.body1.setText(activityListComment.getBody());
        holder.linearClickComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!maxLines) {
                    holder.body1.setMaxLines(1);
                    maxLines = true;

                } else {
                    holder.body1.setMaxLines(Integer.MAX_VALUE);
                    maxLines = false;

                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return activityListComments.size();
    }


    public class CommentViewHolder extends RecyclerView.ViewHolder {

        public TextView postId;
        public TextView id1;
        public TextView name1;
        public TextView email;
        public TextView body1;
        public LinearLayout linearClickComment;

        public CommentViewHolder(View itemView) {
            super(itemView);

            postId = (TextView) itemView.findViewById(R.id.postId);
            id1 = (TextView) itemView.findViewById(R.id.id1);
            name1 = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
            body1 = (TextView) itemView.findViewById(R.id.body1);
            linearClickComment = (LinearLayout) itemView.findViewById(R.id.linearClickComment);

        }
    }

}
