// Generated by view binder compiler. Do not edit!
package com.example.finals.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.finals.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityPendingOrdersBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final ListView AdminList1;

  @NonNull
  public final BottomNavigationView navBar3;

  @NonNull
  public final SwipeRefreshLayout swipeRefresh;

  private ActivityPendingOrdersBinding(@NonNull RelativeLayout rootView,
      @NonNull ListView AdminList1, @NonNull BottomNavigationView navBar3,
      @NonNull SwipeRefreshLayout swipeRefresh) {
    this.rootView = rootView;
    this.AdminList1 = AdminList1;
    this.navBar3 = navBar3;
    this.swipeRefresh = swipeRefresh;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityPendingOrdersBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityPendingOrdersBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_pending_orders, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityPendingOrdersBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AdminList1;
      ListView AdminList1 = ViewBindings.findChildViewById(rootView, id);
      if (AdminList1 == null) {
        break missingId;
      }

      id = R.id.nav_bar3;
      BottomNavigationView navBar3 = ViewBindings.findChildViewById(rootView, id);
      if (navBar3 == null) {
        break missingId;
      }

      id = R.id.swipeRefresh;
      SwipeRefreshLayout swipeRefresh = ViewBindings.findChildViewById(rootView, id);
      if (swipeRefresh == null) {
        break missingId;
      }

      return new ActivityPendingOrdersBinding((RelativeLayout) rootView, AdminList1, navBar3,
          swipeRefresh);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}