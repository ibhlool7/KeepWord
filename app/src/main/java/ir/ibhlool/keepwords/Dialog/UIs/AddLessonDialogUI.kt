package ir.ibhlool.keepwords.Dialog.UIs

import android.os.Build
import android.support.v4.content.ContextCompat
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import ir.ibhlool.keepwords.Dialog.AddReadLessonDialog
import ir.ibhlool.keepwords.R
import ir.ibhlool.keepwords.UIs.AddWordActivityUI.Companion.done
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class AddLessonDialogUI : AnkoComponent<AddReadLessonDialog> {
    companion object {
        const val cancel = 20
        const val RV = 21
        const val name = 22
        const val done = 23
    }

    override fun createView(ui: AnkoContext<AddReadLessonDialog>): View {
        with(ui) {
            return relativeLayout {
                lparams(matchParent, matchParent)
                backgroundColor = ContextCompat.getColor(ctx, R.color.transparent)

                verticalLayout {
                    background = ContextCompat.getDrawable(ctx, R.drawable.dialog_background)
                    gravity = Gravity.CENTER_HORIZONTAL

                    relativeLayout {
                        imageView {
                            setImageResource(R.drawable.cross)
                            padding = dip(15)
                            id = cancel
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                val outValue = TypedValue()
                                ctx.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true)
                                backgroundResource = outValue.resourceId
                            }
                        }.lparams(dip(50), matchParent) {
                            alignParentRight()
                        }

                        textView {
                            gravity = Gravity.CENTER_VERTICAL or Gravity.LEFT
                            textSize = sp(5).toFloat()
                            textColor = ContextCompat.getColor(ctx, R.color.white)
                            text = "Add Lesson"

                        }.lparams(matchParent, matchParent) {
                            padding = dip(5)
                            rightMargin = dip(10)
                            leftMargin = dip(10)
                        }
                    }.lparams(matchParent, dip(56))

                    editText {
                        gravity = Gravity.CENTER_VERTICAL or Gravity.LEFT
                        textSize = sp(5).toFloat()
                        textColor = ContextCompat.getColor(ctx, R.color.white)
                        hint = "lesson name ..."
                        id = name
                        hintTextColor = ContextCompat.getColor(ctx, R.color.grey500)
                        background = ContextCompat.getDrawable(ctx,R.drawable.menu_roe_background)
                        leftPadding = dip(10)
                        rightPadding = dip(10)
                        singleLine = true
                    }.lparams(matchParent, dip(50)) {
                        topMargin = dip(5)
                        rightMargin = dip(10)
                        leftMargin = dip(10)
                        bottomMargin = dip(5)

                    }

                    recyclerView {
                        id = RV
                    }.lparams(wrapContent, dip(50)) {
                        margin = dip(7)
                    }

                    imageView {
                        setImageResource(R.drawable.done)
                        id = done
                    }.lparams(dip(50),dip(50))

                }.lparams(matchParent, dip(240)) {
                    margin = dip(5)
                }
            }
        }
    }
}