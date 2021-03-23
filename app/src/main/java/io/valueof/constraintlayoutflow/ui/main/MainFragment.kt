package io.valueof.constraintlayoutflow.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.Fragment
import io.valueof.constraintlayoutflow.R
import io.valueof.constraintlayoutflow.databinding.MainFragmentBinding

private const val TALLY_COUNT = 20

class MainFragment : Fragment(R.layout.main_fragment) {

  companion object {
    fun newInstance() = MainFragment()
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val binding = MainFragmentBinding.bind(view)

    (1..TALLY_COUNT).forEachIndexed { index, _ ->
      val tallyView = LayoutInflater.from(context).inflate(
        R.layout.view_tally_item,
        binding.tallyContainer,
        false
      ).apply {
        id = View.generateViewId()
      }

      binding.tallyContainer.addView(tallyView)
      binding.tally.addView(tallyView)

//      TODO: set custom color for each tally, if necessary
//      tallyView.background.colorFilter = PorterDuffColorFilter(
//        getTallyColor(index),
//        PorterDuff.Mode.SRC_ATOP
//      )
    }
  }
}