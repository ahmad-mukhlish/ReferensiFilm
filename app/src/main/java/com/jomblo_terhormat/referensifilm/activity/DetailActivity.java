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
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jomblo_terhormat.referensifilm.R;
import com.jomblo_terhormat.referensifilm.entity.Film;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by GOODWARE1 on 8/30/2017.
 */


public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bundle = getIntent().getExtras();


        TextView judul = (TextView) findViewById(R.id.judul);
        TextView tanggal = (TextView) findViewById(R.id.tanggal);
        TextView rating = (TextView) findViewById(R.id.rating_number);
        TextView deskripsi = (TextView) findViewById(R.id.deskripsi);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating);

        final ImageView imageView = (ImageView) findViewById(R.id.gambar);
        imageView.setVisibility(View.GONE);

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Picasso.with(this).
                load(Film.ROOT_IMAGE_PATH_DETAIL + bundle.getString("gambar")).
                error(R.drawable.detail)
                .into(imageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBar.setVisibility(View.GONE);
                        imageView.setVisibility(View.VISIBLE);
                        autoDirection(imageView, 80);
                    }

                    @Override
                    public void onError() {
                        progressBar.setVisibility(View.GONE);
                        autoDirection(imageView, 0);
                        imageView.setVisibility(View.VISIBLE);
                    }
                });


        judul.setText(bundle.getString("judul"));
        autoDirection(judul, 430);

        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");


        tanggal.setText(getFormattedDate(bundle.getString("tanggal"), input));
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

    private String getFormattedDate(String date, SimpleDateFormat sdf) {
        SimpleDateFormat output = new SimpleDateFormat("dd MMMM yyyy");
        Date oneWayTripDate = null;

        try {
            oneWayTripDate = sdf.parse(date);
        } catch (java.text.ParseException e) {
            Log.e("apa", "jelly", e);
        }

        DateFormat dayFormate = new SimpleDateFormat("EEEE");
        String dayFromDate = dayFormate.format(oneWayTripDate);

        return dayFromDate + ", " + output.format(oneWayTripDate);
    }

}
