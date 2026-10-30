package com.example.assignmentone;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;

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

        // Facilities 0, Events 1, Clubs 2 and Support 3.
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

        // Category labels use the same order as the supplied arrays.
        int[] categoryLabels = {
                R.string.facilities,
                R.string.events,
                R.string.clubs,
                R.string.support
        };

        // Explicit resource references allow compile-time checking.
        Map<String, Integer> topicImages = new HashMap<>();
        topicImages.put(
                "img_btn_facilities", R.drawable.img_btn_facilities
        );
        topicImages.put(
                "img_btn_events", R.drawable.img_btn_events
        );
        topicImages.put(
                "img_btn_clubs", R.drawable.img_btn_clubs
        );
        topicImages.put(
                "img_btn_support", R.drawable.img_btn_support
        );

        ImageView topicImage = findViewById(R.id.ivDetailTopic);
        TextView categoryView = findViewById(R.id.tvDetailCategory);
        TextView titleView = findViewById(R.id.tvDetailTitle);
        TextView contentView = findViewById(R.id.tvDetailContent);

        // Resolve the image name from the supplied array.
        // Every supplied name must have a matching entry in topicImages.
        Integer imageResId = topicImages.get(
                imageNames[topicIndex].trim()
        );

        // Populate every view using the same topic index.
        topicImage.setImageResource(
                java.util.Objects.requireNonNull(
                        imageResId,
                        "Missing drawable mapping for the selected topic"
                )
        );
        categoryView.setText(categoryLabels[topicIndex]);
        titleView.setText(titles[topicIndex].trim());
        contentView.setText(contents[topicIndex].trim());
    }
}