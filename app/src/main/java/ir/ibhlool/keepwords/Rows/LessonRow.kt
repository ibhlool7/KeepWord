package ir.ibhlool.keepwords.Rows

import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewParent
import android.widget.LinearLayout
import ir.ibhlool.keepwords.R
import org.jetbrains.anko.*

class LessonRow : AnkoComponent<ViewParent> {
    companion object {
        const val name = 30
        const val last = 31
        const val palate = 32
    }
    override fun createView(ui: AnkoContext<ViewParent>): View {
        with(ui) {
            return relativeLayout {
                lparams(matchParent, dip(56)) {
                    leftMargin = dip(3)
                    rightMargin = dip(3)
                    bottomMargin = dip(2)
                }
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL

                    textView {
                        textColor = ContextCompat.getColor(ctx, R.color.white)
                        textSize = sp(6).toFloat()
                        text = "dfsma"
                        gravity = Gravity.LEFT or Gravity.CENTER_HORIZONTAL
                        id = name
                    }.lparams(width = dip(0),height =   matchParent, weight = 3f) {
                        leftPadding = dip(5)
                    }
                    textView {
                        textColor = ContextCompat.getColor(ctx, R.color.white)
                        textSize = sp(5).toFloat()
                        gravity = Gravity.LEFT or Gravity.CENTER_HORIZONTAL
                        id = last
                    }.lparams(width = dip(0), height =  matchParent, weight = 1f) {
                        leftPadding = dip(5)
                    }
                }.lparams(matchParent, matchParent)

                imageView {
                    id = palate
                    setImageResource(R.drawable.color_pelatte)
                }.lparams(matchParent, matchParent) {
                    margin = dip(1)
                }
                imageView {
                    setImageResource(R.drawable.just_border)
                }.lparams(matchParent, matchParent){
                    topMargin = dip(56)
                }
            }
        }
    }
}