package com.example.johann.abuseu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    //add image to drawable and fetch here
    int imageNo[] = {R.drawable.male_avatar_black, R.drawable.male_avatar_chinese, R.drawable.male_avatar_white};
    int femaleImageNo[] = {R.drawable.female_avatar_black, R.drawable.female_avatar_chinese, R.drawable.female_avatar_white};
    int countImage = imageNo.length;
    int currentImage = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextImage = (Button) findViewById(R.id.button);
        final Button gender = (Button) findViewById(R.id.gender);
        final ImageSwitcher imageSwitcher = (ImageSwitcher) findViewById(R.id.imageChanger);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView () {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        /*Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        */
        nextImage.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                currentImage++;
                if(currentImage==countImage)
                    currentImage = 0;
                int imageArr[] = null;
                if(gender.getText().equals("Male"))
                    imageArr = imageNo;
                else
                    imageArr = femaleImageNo;

                imageSwitcher.setImageResource(imageArr[currentImage]);

            }
        });
    }
}
