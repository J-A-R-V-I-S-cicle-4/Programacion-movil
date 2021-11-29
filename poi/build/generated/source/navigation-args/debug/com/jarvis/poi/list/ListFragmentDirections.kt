package com.jarvis.poi.list

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.jarvis.poi.R
import com.jarvis.poi.model.PlacesofinterestItem
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ListFragmentDirections private constructor() {
  private data class ActionListFragmentToDetailFragment(
    public val poi: PlacesofinterestItem
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_listFragment_to_detailFragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    public override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(PlacesofinterestItem::class.java)) {
        result.putParcelable("poi", this.poi as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(PlacesofinterestItem::class.java)) {
        result.putSerializable("poi", this.poi as Serializable)
      } else {
        throw UnsupportedOperationException(PlacesofinterestItem::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  public companion object {
    public fun actionListFragmentToDetailFragment(poi: PlacesofinterestItem): NavDirections =
        ActionListFragmentToDetailFragment(poi)

    public fun actionListFragmentToSettingsFragment4(): NavDirections =
        ActionOnlyNavDirections(R.id.action_listFragment_to_settingsFragment4)
  }
}
