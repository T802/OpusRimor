package com.example.user.OpusRimor;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Displays job description content
 */
public class Main4Activity extends AppCompatActivity {
    /**
     *
     * @param savedInstanceState
     *
     * Creates job content to display to page
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Intent DescDisplay = getIntent();
        String JobBody = DescDisplay.getStringExtra("BodyOfJob");
        String JobTitle = DescDisplay.getStringExtra("TitlePick");



        TextView Description;
        Description = findViewById(R.id.DescBox);
        Description.setMovementMethod(new ScrollingMovementMethod());
        Description.setText(Html.fromHtml(JobBody));

        TextView Title;
        Title = findViewById(R.id.jobTitle);
        Title.setText(JobTitle);
    }

    /**
     *
     * @param view
     *
     * Allows user to click job title to redirect to actual job posting to its respective site
     */
        public void VisitSite(android.view.View view){
            Intent DescDisplay = getIntent();
            String JobLink = DescDisplay.getStringExtra("origLink");
            Intent visitPage = new Intent(Intent.ACTION_VIEW, Uri.parse(JobLink));
            startActivity(visitPage);
        }


}
