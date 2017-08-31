package com.jomblo_terhormat.referensifilm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.squareup.picasso.Picasso;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();

        ImageView imageView = (ImageView) findViewById(R.id.gambar);
        TextView judul = (TextView) findViewById(R.id.judul);
        TextView tanggal = (TextView) findViewById(R.id.tanggal);
        TextView rating = (TextView) findViewById(R.id.rating_number);
        TextView deskripsi = (TextView) findViewById(R.id.deskripsi);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);

        if (bundle.getString("gambar") != null) {
            Picasso.with(this).
                    load(Film.ROOT_IMAGE_PATH_DETAIL + bundle.getString("gambar")).
                    placeholder(R.drawable.film)
                    .into(imageView);
        } else {
            Picasso.with(this).
                    load(Film.ROOT_IMAGE_PATH_POSTER + bundle.getString("cadangan")).
                    placeholder(R.drawable.film)
                    .into(imageView);
            Log.v("kena", bundle.getString("gambar"));

        }

        autoDirection(imageView, 80);


        judul.setText(bundle.getString("judul"));
        autoDirection(judul, 430);

        tanggal.setText(bundle.getString("tanggal"));
        ratingBar.setRating(bundle.getFloat("rating"));

        rating.setText("Rating : " + bundle.getFloat("rating"));
        deskripsi.setText(bundle.getString("deskripsi"));

    }

    private void autoDirection(View view, int top) {

        ViewGroup.MarginLayoutParams marginParams =
                (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();

        if (display.getRotation() == Surface.ROTATION_90
                || display.getRotation() == Surface.ROTATION_270) {
            marginParams.setMargins(marginParams.leftMargin, top,
                    marginParams.rightMargin, marginParams.bottomMargin);
        }

    }


}
