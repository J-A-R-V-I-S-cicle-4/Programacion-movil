// Generated by view binder compiler. Do not edit!
package com.jarvis.poi.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.jarvis.poi.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardViewPoiItemBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView descriptionTextView;

  @NonNull
  public final TextView nameTextView;

  @NonNull
  public final ImageView pictureImageView;

  @NonNull
  public final TextView scoreTextView;

  private CardViewPoiItemBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView descriptionTextView, @NonNull TextView nameTextView,
      @NonNull ImageView pictureImageView, @NonNull TextView scoreTextView) {
    this.rootView = rootView;
    this.descriptionTextView = descriptionTextView;
    this.nameTextView = nameTextView;
    this.pictureImageView = pictureImageView;
    this.scoreTextView = scoreTextView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CardViewPoiItemBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardViewPoiItemBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.card_view_poi_item, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardViewPoiItemBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.description_text_view;
      TextView descriptionTextView = ViewBindings.findChildViewById(rootView, id);
      if (descriptionTextView == null) {
        break missingId;
      }

      id = R.id.name_text_view;
      TextView nameTextView = ViewBindings.findChildViewById(rootView, id);
      if (nameTextView == null) {
        break missingId;
      }

      id = R.id.picture_image_view;
      ImageView pictureImageView = ViewBindings.findChildViewById(rootView, id);
      if (pictureImageView == null) {
        break missingId;
      }

      id = R.id.score_text_view;
      TextView scoreTextView = ViewBindings.findChildViewById(rootView, id);
      if (scoreTextView == null) {
        break missingId;
      }

      return new CardViewPoiItemBinding((ConstraintLayout) rootView, descriptionTextView,
          nameTextView, pictureImageView, scoreTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
