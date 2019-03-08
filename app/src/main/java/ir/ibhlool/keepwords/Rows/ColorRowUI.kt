package ir.ibhlool.keepwords.Rows

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import ir.ibhlool.keepwords.R
import org.jetbrains.anko.*

class ColorRowUI : AnkoComponent<ViewGroup> {
    companion object {
        const val pellate = 23
    }

    override fun createView(ui: AnkoContext<ViewGroup>): View {
        with(ui) {
            return relativeLayout {
                lparams(dip(50), dip(50))



                imageView {
                    setImageResource(R.drawable.color_pelatte)
                    id = pellate
                    scaleType = ImageView.ScaleType.FIT_XY
                }.lparams(matchParent, matchParent) {
                    margin = dip(3)
                }
                imageView {
                    setImageResource(R.drawable.just_border)
                }.lparams(matchParent, matchParent) {
                    margin = dip(2)
                }

            }
        }
    }

}