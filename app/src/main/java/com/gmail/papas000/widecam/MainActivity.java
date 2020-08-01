package com.gmail.papas000.widecam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.jmolsmobile.landscapevideocapture.VideoCaptureActivity;
import com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Choose one of both
        CaptureConfiguration.Builder builder = new CaptureConfiguration.Builder(1920, 1080, 1500);

        // Optional
        //builder.maxDuration(maxDurationSec);
        //builder.maxFileSize(maxFileSizeMb);
        //builder.frameRate(framesPerSec);
        builder.showRecordingTime();         // Show the elapsed recording time
        builder.noCameraToggle();            // Remove button to toggle between front and back camera

        // Get the CaptureConfiguration
        CaptureConfiguration configuration = builder.build();

        final Intent intent = new Intent(this, VideoCaptureActivity.class);
        intent.putExtra(VideoCaptureActivity.EXTRA_CAPTURE_CONFIGURATION, configuration);
        //intent.putExtra(VideoCaptureActivity.EXTRA_OUTPUT_FILENAME, filename);
        startActivityForResult(intent, 1);
    }
}
