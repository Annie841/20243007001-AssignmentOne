package com.example.assignmentone;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/** Display the topic header and scrollable detail content. */
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Keep the detail layout clear of system bars and display cutouts.
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.detailRoot),
                (view, insets) -> {
                    Insets safeInsets = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                                    | WindowInsetsCompat.Type.displayCutout()
                    );

                    view.setPadding(
                            safeInsets.left,
                            safeInsets.top,
                            safeInsets.right,
                            safeInsets.bottom
                    );

                    return insets;
                }
        );
    }
}