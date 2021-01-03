package com.omniwyse.custombottomsheetdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback

class MainActivity : AppCompatActivity() {

    var behavior: BottomSheetBehavior<View>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setBottomSheetBehavior()
        findViewById<View>(R.id.v_btn_normal).setOnClickListener {
            ViewUtils.showBottomSheetDialog(
                this,
                ViewUtils.getView(this, R.layout.bottom_sheet_layout)
            )
        }
    }

    private fun setBottomSheetBehavior() {
        val customBottomSheetView = findViewById<View>(R.id.v_custom_bottom_sheet)
        behavior = BottomSheetBehavior.from(customBottomSheetView)
        behavior!!.addBottomSheetCallback(object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                // React to state change
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    findViewById<View>(R.id.v_parent_coor).setBackgroundColor(
                        ContextCompat.getColor(
                            this@MainActivity,
                            R.color.white
                        )
                    )
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                // React to dragging events
            }
        })

        findViewById<View>(R.id.v_bottom_layout).setOnClickListener {
            findViewById<View>(R.id.v_parent_coor).setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.transparent_black
                )
            )
            behavior?.setState(BottomSheetBehavior.STATE_EXPANDED)
        }

        findViewById<View>(R.id.v_mbtn_one).setOnClickListener {
            behavior?.state = BottomSheetBehavior.STATE_COLLAPSED
            findViewById<View>(R.id.v_parent_coor).setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
        }

        findViewById<View>(R.id.v_parent_coor).setOnClickListener {
            behavior?.state = BottomSheetBehavior.STATE_COLLAPSED
            findViewById<View>(R.id.v_parent_coor).setBackgroundColor(
                ContextCompat.getColor(
                    this,
                    R.color.white
                )
            )
        }
    }
}
