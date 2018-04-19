package com.example.user.OpusRimor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Displays job postings that match chosen terms
 */
public class Main3Activity extends AppCompatActivity {

    // converts string list into a list of jobPost objects
    // uses a recycler view display objects on XML
    private List<JobPost> jobList2 = new ArrayList<>();
    private RecyclerView recyclerView2;
    private JobPostsAdapter jAdapter2;

    /**
     *
     * @param savedInstanceState
     *
     * Initializes recycler view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);

        // interface to recycler view

        //Initializes JobPostsAdapter object
        jAdapter2 = new JobPostsAdapter(jobList2);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView2.setLayoutManager(mLayoutManager);
        recyclerView2.setItemAnimator(new DefaultItemAnimator());
        recyclerView2.setAdapter(jAdapter2);

        compileJobs2();


        //Check which row user has clicked and sends information to next activity
        recyclerView2.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView2, new RecyclerTouchListener.ClickListener() {

            /**
             *
             * @param view Row content
             * @param position Row number
             *
             * Passes clicked job and its contents to next activity
             */
            @Override
            public void onClick(View view, int position) {
                JobPost PostList2 = jobList2.get(position);

                String JobBody;
                JobBody = PostList2.getDesc();
                if(JobBody.length() != 0) {
                    Intent DescDisplay = new Intent(getBaseContext(), Main4Activity.class);
                    DescDisplay.putExtra("BodyOfJob", JobBody);
                    DescDisplay.putExtra("TitlePick", PostList2.getTitle());
                    DescDisplay.putExtra("origLink", PostList2.getJLink());
                    startActivity(DescDisplay);
                }else{
                    JobBody = "Sorry bub";
                        Intent DescDisplay = new Intent(getBaseContext(), Main4Activity.class);
                        DescDisplay.putExtra("BodyOfJob", JobBody);
                        startActivity(DescDisplay);
                }
            }

            /**
             *
             * @param view
             * @param position
             */
            @Override
            public void onLongClick(View view, int position) {

            }

        }));


    }

    /**
     * Generates content for each job posting
     */
    private void compileJobs2(){

        Intent passJobList = getIntent();
        ArrayList<String> AllJobs = passJobList.getStringArrayListExtra("ALLJOBS");


        String[] AllJPosts = new String[AllJobs.size()];

        for(int i=0; i < AllJobs.size(); i++){
            AllJPosts[i] = AllJobs.get(i);
        }

        if(AllJobs.size() == 0){
            JobPost jobPost = new JobPost("Didn't work", "Site", "now", "BackLink", "BackDesc");
            jobList2.add(jobPost);
        }else {

            for (int i = 0; i < AllJobs.size(); i = i + 5) {
                                        //Job title       Site Source         Post Date         Link                Desc
                JobPost jobpost = new JobPost(AllJPosts[i], AllJPosts[i + 1], AllJPosts[i + 2],AllJPosts[i + 3], AllJPosts[i + 4]);
                jobList2.add(jobpost);
            }
        }
        jAdapter2.notifyDataSetChanged();
    }


}
