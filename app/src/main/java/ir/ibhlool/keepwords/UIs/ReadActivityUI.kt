package ir.ibhlool.keepwords.UIs

import android.os.Build
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import ir.ibhlool.keepwords.R
import ir.ibhlool.keepwords.ReadActivity
import ir.ibhlool.keepwords.UIs.AddWordActivityUI.Companion.title
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ReadActivityUI : AnkoComponent<ReadActivity> {
    companion object {
        const val floatingButton =8
        const val back =9
        const val title =10
        const val RV =11
    }
    override fun createView(ui: AnkoContext<ReadActivity>): View {
        with(ui) {
            return relativeLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)

                relativeLayout {
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)

                    imageView {
                        setImageResource(R.drawable.back)
                        padding = dip(12)
                        id = back
                        backgroundColor = android.R.attr.selectableItemBackground
                    }.lparams(dip(56), matchParent){
                        alignParentLeft()
                    }

                    textView {
                        id = title
                        textSize = sp(6).toFloat()
                        textColor = ContextCompat.getColor(ctx, R.color.white)
                        gravity = Gravity.CENTER

                    }.lparams(matchParent, matchParent)


                }.lparams(matchParent, dip(56)) {
                    alignParentTop()
                }
                verticalLayout {

                    recyclerView{
                        id = RV
                    }.lparams(matchParent, matchParent){
                        topMargin = dip(56)
                    }
                }.lparams(matchParent, matchParent)

                imageView {
                    setImageResource(R.drawable.add_floating)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        elevation = dip(3).toFloat()
                    }
                    background = ContextCompat.getDrawable(ctx,R.drawable.orange_ripple)
                    isClickable =true
                    id = floatingButton
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        val outValue = TypedValue()
                        ctx.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true)
                        backgroundResource = outValue.resourceId
                    }


                }.lparams(dip(56), dip(56)) {
                    alignParentRight()
                    alignParentBottom()
                    margin = dip(5)
                }
            }
        }
    }

}