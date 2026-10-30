package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Store the current Toast so previous feedback can be canceled.
    private Toast currentToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Keep content clear of system bars and display cutouts.
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
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

    /** Cancel previous feedback and show the latest message. */
    private void showFeedback(int messageResId) {
        if (currentToast != null) {
            currentToast.cancel();
        }

        currentToast = Toast.makeText(
                this,
                messageResId,
                Toast.LENGTH_SHORT
        );
        currentToast.show();
    }

    /** Show feedback and open Facilities details with topic index zero. */
    public void onFacilitiesClick(View view) {
        showFeedback(R.string.facilities_clicked);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, 0);
        startActivity(intent);
    }

    /** Show feedback and open Events details with topic index one. */
    public void onEventsClick(View view) {
        showFeedback(R.string.events_clicked);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, 1);
        startActivity(intent);
    }

    /** Show feedback and open Clubs details with topic index two. */
    public void onClubsClick(View view) {
        showFeedback(R.string.clubs_clicked);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, 2);
        startActivity(intent);
    }

    /** Show feedback and open Support details with topic index three. */
    public void onSupportClick(View view) {
        showFeedback(R.string.support_clicked);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_TOPIC_INDEX, 3);
        startActivity(intent);
    }

    /** Remove feedback when this Activity is destroyed. */
    @Override
    protected void onDestroy() {
        if (currentToast != null) {
            currentToast.cancel();
        }
        super.onDestroy();
    }
}