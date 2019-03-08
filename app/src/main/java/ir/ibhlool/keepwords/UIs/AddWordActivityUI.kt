package ir.ibhlool.keepwords.UIs

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import ir.ibhlool.keepwords.AddWordActivity
import ir.ibhlool.keepwords.R
import org.jetbrains.anko.*

class AddWordActivityUI : AnkoComponent<AddWordActivity> {
    companion object {
        const val title = 0
        const  val arrow = "U+1F53B"
        const val back = 1
        const val word = 2
        const val definition = 3
        const val wordInUse = 4
        const val means = 5
        const val done = 6

    }

    override fun createView(ui: AnkoContext<AddWordActivity>): View {
        with(ui) {

            return relativeLayout {
                lparams(matchParent, matchParent)

                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)

                    imageView {
                        setImageResource(R.drawable.back)
                        padding = dip(12)
                        id = back
                        backgroundColor = android.R.attr.selectableItemBackground
                    }.lparams(dip(56), matchParent)

                    textView {
                        id = title
                        textSize = sp(6).toFloat()
                        textColor = ContextCompat.getColor(ctx, R.color.white)
                        gravity = Gravity.END or Gravity.CENTER_VERTICAL

                    }.lparams(matchParent, matchParent)


                }.lparams(matchParent, dip(56)) {
                    alignParentTop()
                }

                scrollView {
                    backgroundColor = ContextCompat.getColor(ctx, R.color.colorPrimaryDark)

                    verticalLayout {
                        gravity = Gravity.CENTER_HORIZONTAL

                        verticalLayout {
                            backgroundColor = ContextCompat.getColor(ctx,R.color.orange )
                            gravity = Gravity.CENTER_HORIZONTAL

                            //word
                            linearLayout {
                                orientation = LinearLayout.VERTICAL
                                background = ContextCompat.getDrawable(ctx, R.drawable.light_rounded_background)
                                gravity = Gravity.CENTER
                                minimumWidth = dip(200)
                                editText {
                                    textSize = sp(7).toFloat()
                                    gravity = Gravity.CENTER
                                    textColor = ContextCompat.getColor(ctx, R.color.textColorLight)
                                    id = word
                                    hint = " Word "
                                    backgroundColor = ContextCompat.getColor(ctx, R.color.transparent)
                                    hintTextColor = ContextCompat.getColor(ctx, R.color.hintColor)
                                    singleLine = true
                                }.lparams(wrapContent, wrapContent) {
                                    leftMargin = dip(5)
                                    rightMargin = dip(5)
                                }

                            }.lparams(wrapContent, wrapContent){
                                topPadding = dip(15)
                                bottomPadding = dip(15)
                            }

                            //definition
                            linearLayout {
                                orientation = LinearLayout.VERTICAL
                                background = ContextCompat.getDrawable(ctx, R.drawable.light_rounded_background)
                                gravity = Gravity.CENTER
                                minimumWidth = dip(300)
                                editText {
                                    textSize = sp(6).toFloat()
                                    gravity = Gravity.CENTER
                                    textColor = ContextCompat.getColor(ctx, R.color.textColorLight)
                                    hint = " Definition "
                                    id = definition
                                    backgroundColor = ContextCompat.getColor(ctx, R.color.transparent)
                                    hintTextColor = ContextCompat.getColor(ctx, R.color.hintColor)
                                }.lparams(wrapContent, wrapContent) {
                                    leftMargin = dip(5)
                                    rightMargin = dip(5)
                                }

                            }.lparams(wrapContent, wrapContent) {
                                topMargin = dip(10)
                            }


                        }.lparams(matchParent, wrapContent)

                        //more
                        textView {
                            textColor = ContextCompat.getColor(ctx, R.color.orange)
                            text = " Advanced "
                            gravity = Gravity.CENTER
                            textSize = sp(6).toFloat()
                        }.lparams(matchParent, wrapContent) {
                            topMargin = dip(10)
                        }
                        //example
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            background = ContextCompat.getDrawable(ctx, R.drawable.orange_round_background)
                            minimumHeight = dip(200)
                            editText {
                                textSize = sp(6).toFloat()
                                id = wordInUse
                                gravity = Gravity.LEFT or Gravity.TOP
                                textColor = ContextCompat.getColor(ctx, R.color.textColorLight)
                                hint = " word in use "
                                backgroundColor = ContextCompat.getColor(ctx, R.color.transparent)
                                hintTextColor = ContextCompat.getColor(ctx, R.color.hintColor)
                            }.lparams(matchParent, matchParent) {
                                leftMargin = dip(5)
                                rightMargin = dip(5)
                            }

                        }.lparams(matchParent, wrapContent) {
                            topMargin = dip(5)
                            rightMargin = dip(5)
                            leftMargin = dip(5)
                        }

                        //means
                        linearLayout {
                            orientation = LinearLayout.VERTICAL
                            background = ContextCompat.getDrawable(ctx, R.drawable.orange_round_background)
                            gravity = Gravity.CENTER
                            minimumWidth = dip(300)
                            editText {
                                textSize = sp(6).toFloat()
                                gravity = Gravity.CENTER
                                id = means
                                textColor = ContextCompat.getColor(ctx, R.color.textColorLight)
                                hint = " Means "
                                backgroundColor = ContextCompat.getColor(ctx, R.color.transparent)
                                hintTextColor = ContextCompat.getColor(ctx, R.color.hintColor)
                            }.lparams(wrapContent, wrapContent) {
                                leftMargin = dip(5)
                                rightMargin = dip(5)
                            }

                        }.lparams(wrapContent, wrapContent) {
                            topMargin = dip(5)
                        }

                        imageView {
                            setImageResource(R.drawable.done)
                            id = done
                        }.lparams(dip(50) , dip(50)){
                            margin = dip(7)
                        }
                    }.lparams(matchParent, matchParent)

                }.lparams(matchParent, matchParent) {
                    topMargin = dip(56)
                }
            }

        }
    }

}