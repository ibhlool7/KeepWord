package ir.ibhlool.keepwords.UIs

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import ir.ibhlool.keepwords.MainActivity
import ir.ibhlool.keepwords.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivityUI : AnkoComponent<MainActivity> {
    companion object {
        const val RV = 0
        const val icon = 1
        const val empty = 2
    }

    override fun createView(ui: AnkoContext<MainActivity>): View {
        with(ui) {
            return relativeLayout {
                lparams(width = matchParent, height = matchParent)
                backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)

                //search part
                verticalLayout {

                    linearLayout {

                        relativeLayout {


                            imageView {
                                setImageResource(R.drawable.search_background)
                                scaleType = ImageView.ScaleType.FIT_XY
                            }.lparams(matchParent, matchParent) {
                                leftMargin = dip(20)
                                rightMargin = dip(20)
                            }

                            //inside search part
                            linearLayout {
                                orientation = LinearLayout.HORIZONTAL


                                editText {
                                    hint = "search ..."
                                    hintTextColor = ContextCompat.getColor(ctx, R.color.hintColor)
                                    textSize = 19f
                                    textColor = ContextCompat.getColor(ctx, R.color.white)
                                    gravity = Gravity.CENTER_VERTICAL
                                    singleLine = true
                                    backgroundColor = ContextCompat.getColor(ctx, R.color.transparent)
                                }.lparams(dip(0), wrapContent) {
                                    weight = 5f
                                    leftMargin = dip(40)
                                    rightMargin = dip(80)
                                    setPadding(0, 8, 0, 0)
                                }
                            }.lparams(matchParent, matchParent)


                        }.lparams(matchParent, matchParent)

                    }.lparams(width = matchParent, height = dip(56)) {
                        topMargin = dip(10)
                    }

                }.lparams(width = matchParent, height = dip(76))


                //center part
                relativeLayout {
                    recyclerView {
                        id = RV
                    }
                        .lparams(wrapContent, wrapContent) {
                            centerInParent()
                        }
                }.lparams(matchParent, matchParent) {
                    topMargin = dip(76)
                }

            }
        }
    }

}