package com.jarvis.poi.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.jarvis.poi.model.PlacesofinterestItem
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class DetailFragmentArgs(
  public val poi: PlacesofinterestItem
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): DetailFragmentArgs {
      bundle.setClassLoader(DetailFragmentArgs::class.java.classLoader)
      val __poi : PlacesofinterestItem?
      if (bundle.containsKey("poi")) {
        if (Parcelable::class.java.isAssignableFrom(PlacesofinterestItem::class.java) ||
            Serializable::class.java.isAssignableFrom(PlacesofinterestItem::class.java)) {
          __poi = bundle.get("poi") as PlacesofinterestItem?
        } else {
          throw UnsupportedOperationException(PlacesofinterestItem::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__poi == null) {
          throw IllegalArgumentException("Argument \"poi\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"poi\" is missing and does not have an android:defaultValue")
      }
      return DetailFragmentArgs(__poi)
    }
  }
}
