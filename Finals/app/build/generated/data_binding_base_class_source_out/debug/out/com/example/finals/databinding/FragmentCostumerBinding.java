// Generated by view binder compiler. Do not edit!
package com.example.finals.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finals.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentCostumerBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final LinearLayout blank;

  @NonNull
  public final ImageView fifthMenu;

  @NonNull
  public final ImageView firstMenu;

  @NonNull
  public final ImageView fourthMenu;

  @NonNull
  public final ImageView secondMenu;

  @NonNull
  public final ImageView sixthMenu;

  @NonNull
  public final ImageView thirdMenu;

  private FragmentCostumerBinding(@NonNull FrameLayout rootView, @NonNull LinearLayout blank,
      @NonNull ImageView fifthMenu, @NonNull ImageView firstMenu, @NonNull ImageView fourthMenu,
      @NonNull ImageView secondMenu, @NonNull ImageView sixthMenu, @NonNull ImageView thirdMenu) {
    this.rootView = rootView;
    this.blank = blank;
    this.fifthMenu = fifthMenu;
    this.firstMenu = firstMenu;
    this.fourthMenu = fourthMenu;
    this.secondMenu = secondMenu;
    this.sixthMenu = sixthMenu;
    this.thirdMenu = thirdMenu;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentCostumerBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentCostumerBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_costumer, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentCostumerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.blank;
      LinearLayout blank = ViewBindings.findChildViewById(rootView, id);
      if (blank == null) {
        break missingId;
      }

      id = R.id.fifthMenu;
      ImageView fifthMenu = ViewBindings.findChildViewById(rootView, id);
      if (fifthMenu == null) {
        break missingId;
      }

      id = R.id.firstMenu;
      ImageView firstMenu = ViewBindings.findChildViewById(rootView, id);
      if (firstMenu == null) {
        break missingId;
      }

      id = R.id.fourthMenu;
      ImageView fourthMenu = ViewBindings.findChildViewById(rootView, id);
      if (fourthMenu == null) {
        break missingId;
      }

      id = R.id.secondMenu;
      ImageView secondMenu = ViewBindings.findChildViewById(rootView, id);
      if (secondMenu == null) {
        break missingId;
      }

      id = R.id.sixthMenu;
      ImageView sixthMenu = ViewBindings.findChildViewById(rootView, id);
      if (sixthMenu == null) {
        break missingId;
      }

      id = R.id.thirdMenu;
      ImageView thirdMenu = ViewBindings.findChildViewById(rootView, id);
      if (thirdMenu == null) {
        break missingId;
      }

      return new FragmentCostumerBinding((FrameLayout) rootView, blank, fifthMenu, firstMenu,
          fourthMenu, secondMenu, sixthMenu, thirdMenu);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
