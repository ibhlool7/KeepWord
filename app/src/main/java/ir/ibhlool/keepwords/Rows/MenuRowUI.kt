package ir.ibhlool.keepwords.Rows

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import ir.ibhlool.keepwords.R
import org.jetbrains.anko.*

class MenuRowUI : AnkoComponent<ViewParent> {
    companion object {
        const val root = 0
        const val icon = 1
    }
    override fun createView(ui: AnkoContext<ViewParent>): View {
        with(ui) {
            return relativeLayout {
                lparams(dip(150), dip(150)){
                    margin = dip(10)
                }

                imageView {
                    scaleType = ImageView.ScaleType.FIT_XY
                    setImageResource(R.drawable.menu_roe_background)
                    id = root
                }.lparams(matchParent, matchParent){
                    centerInParent()
                }

                imageView {
                    scaleType = ImageView.ScaleType.FIT_CENTER
                    setImageResource(R.drawable.addword)
                    id = icon
                }.lparams(dip(100), dip(100)){
                    centerInParent()
                }


            }
        }
    }

}