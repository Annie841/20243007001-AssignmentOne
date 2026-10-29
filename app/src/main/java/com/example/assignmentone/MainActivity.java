package com.example.assignmentone;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Keep content clear of the system bars and display cutout.
        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                                    | WindowInsetsCompat.Type.displayCutout()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );
    } // onCreate ends here.

    /** Show feedback when the Facilities image button is clicked. */
    public void onFacilitiesClick(View view) {
        Toast.makeText(
                this,
                R.string.facilities_clicked,
                Toast.LENGTH_SHORT
        ).show();
    }

    /** Show feedback when the Events image button is clicked. */
    public void onEventsClick(View view) {
        Toast.makeText(
                this,
                R.string.events_clicked,
                Toast.LENGTH_SHORT
        ).show();
    }

    /** Show feedback when the Clubs image button is clicked. */
    public void onClubsClick(View view) {
        Toast.makeText(
                this,
                R.string.clubs_clicked,
                Toast.LENGTH_SHORT
        ).show();
    }

    /** Show feedback when the Support image button is clicked. */
    public void onSupportClick(View view) {
        Toast.makeText(
                this,
                R.string.support_clicked,
                Toast.LENGTH_SHORT
        ).show();
    }
}