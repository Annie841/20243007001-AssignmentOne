package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/** Display the selected topic using the supplied resource arrays. */
public class DetailActivity extends AppCompatActivity {

    // Shared key for the topic index supplied by MainActivity.
    public static final String EXTRA_TOPIC_INDEX =
            "com.example.assignmentone.TOPIC_INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        // Keep content clear of system bars and display cutouts.
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

        // Retrieve the selected index: Facilities 0, Events 1,
        // Clubs 2 and Support 3.
        int topicIndex = getIntent().getIntExtra(EXTRA_TOPIC_INDEX, 0);

        // Load the supplied parallel arrays in their original order.
        String[] imageNames = getResources().getStringArray(
                R.array.string_array_images
        );
        String[] titles = getResources().getStringArray(
                R.array.string_array_titles
        );
        String[] contents = getResources().getStringArray(
                R.array.string_array_content
        );

        // Category labels follow the same order as the supplied arrays.
        int[] categoryLabels = {
                R.string.facilities,
                R.string.events,
                R.string.clubs,
                R.string.support
        };

        ImageView topicImage = findViewById(R.id.ivDetailTopic);
        TextView categoryView = findViewById(R.id.tvDetailCategory);
        TextView titleView = findViewById(R.id.tvDetailTitle);
        TextView contentView = findViewById(R.id.tvDetailContent);

        // Remove surrounding spaces before resolving the drawable name.
        int imageResId = getResources().getIdentifier(
                imageNames[topicIndex].trim(),
                "drawable",
                getPackageName()
        );

        // Populate every view using the same topic index.
        topicImage.setImageResource(imageResId);
        categoryView.setText(categoryLabels[topicIndex]);
        titleView.setText(titles[topicIndex].trim());
        contentView.setText(contents[topicIndex].trim());
    }
}