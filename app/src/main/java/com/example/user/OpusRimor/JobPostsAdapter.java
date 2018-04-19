package com.example.user.OpusRimor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * JobPostsAdapter object
 */
public class JobPostsAdapter extends RecyclerView.Adapter<JobPostsAdapter.MyViewHolder> {

    private List<JobPost> postingList;

    /**
     * MyViewHolder object
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, site, PostDate;

        /**
         *
         * @param view Link to xml code
         *
         * Displays job postings to screen
         */
        public MyViewHolder(View view) {
            // connects a variable to an XML text view
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            PostDate = (TextView) view.findViewById(R.id.PostDate);
            site = (TextView) view.findViewById(R.id.site);
        }
    }

    /**
     *
     * @param postingList
     *
     * Constructor to initialize object
     */
    public JobPostsAdapter(List<JobPost> postingList) {
        this.postingList = postingList;
    }

    /**
     *
     * @param parent
     * @param viewType Shows which position the post is at
     * @return All rows needed for xml
     *
     * Sends job post object's information to textView
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_post_row, parent, false);

        return new MyViewHolder(itemView);
    }

    /**
     *
     * @param holder Content in xml rows
     * @param position Position in recycler list
     *
     * Generates content for each row in the list
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        JobPost PostList = postingList.get(position);
        holder.title.setText(PostList.getTitle());
        holder.site.setText(PostList.getSite());
        holder.PostDate.setText(PostList.getPostDate());
    }

    /**
     *
     * @return Size of job posting object list
     */
    @Override
    public int getItemCount() {
        return postingList.size();
    }



}
