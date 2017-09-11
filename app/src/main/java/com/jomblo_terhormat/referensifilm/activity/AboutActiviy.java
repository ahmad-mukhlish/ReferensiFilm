package com.jomblo_terhormat.referensifilm.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.jomblo_terhormat.referensifilm.R;

public class AboutActiviy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.about_activity);

        ImageButton fb = (ImageButton) findViewById(R.id.klikfb);
        fb.setOnClickListener(new linkButton("https://web.facebook.com/ahmadmukhlis.saputra"));

        ImageButton github = (ImageButton) findViewById(R.id.klikgithub);
        github.setOnClickListener(new linkButton("https://github.com/ahmad-mukhlish"));

        ImageButton gplus = (ImageButton) findViewById(R.id.klikgplus);
        gplus.setOnClickListener(new linkButton("https://plus.google.com/u/0/116489913115605252616"));

        ImageView tmdb = (ImageView) findViewById(R.id.tmdb);
        tmdb.setOnClickListener(new linkButton("https://www.themoviedb.org/"));

    }


    private class linkButton implements View.OnClickListener {

        private String mLink;

        public linkButton(String link) {
            this.mLink = link;
        }

        @Override
        public void onClick(View view) {
            Uri uriUrl = Uri.parse(mLink);
            startActivity(new Intent(Intent.ACTION_VIEW, uriUrl));
        }
    }
}