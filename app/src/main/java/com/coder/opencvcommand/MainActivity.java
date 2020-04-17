package com.coder.opencvcommand;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.coder.opencv.cmd.BlurryCmd;
import com.coder.opencvcommand.utils.FileUtils;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.

    private String inputPath, outputPath;
    private TextView mTimeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        FileUtils.copy2Memory(this, "ic_avatar.jpeg");
        inputPath = new File(getExternalCacheDir(), "ic_avatar.jpeg").getAbsolutePath();
        outputPath = getExternalCacheDir() + File.separator + "target1.jpg";
        Button tv = findViewById(R.id.btn);
        mTimeText = findViewById(R.id.tv_time);
        final ImageView imageView = findViewById(R.id.iv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long currentTime = System.currentTimeMillis();
                int ret = BlurryCmd.blurImage(inputPath, outputPath, 21,1);
                if (ret == 1) {
                    mTimeText.setText(String.format("时长:%s",
                            System.currentTimeMillis() - currentTime));
                    RequestOptions options =
                            RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)
                                    .skipMemoryCache(true);
                    Glide.with(MainActivity.this)
                            .applyDefaultRequestOptions(options)
                            .load(outputPath).into(imageView);
                }
            }
        });
    }
}
