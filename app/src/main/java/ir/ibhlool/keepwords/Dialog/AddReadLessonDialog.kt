package ir.ibhlool.keepwords.Dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.drawable.Animatable
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.CountDownTimer
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Window
import android.widget.EditText
import android.widget.ImageView
import ir.ibhlool.keepwords.Adapter.ColorAdapter
import ir.ibhlool.keepwords.Dialog.UIs.AddLessonDialogUI
import ir.ibhlool.keepwords.Setting
import ir.ibhlool.keepwords.dataBase.WordDatabaseOpenHelper
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.db.insert


class AddReadLessonDialog(val activity: Activity) {
    val dialogBuilder = Dialog(activity)
    val view = AddLessonDialogUI().createView(AnkoContext.create(activity, this, false))
    val name: EditText
    val done: ImageView
    val cancel: ImageView
    val recyclerView: RecyclerView
    val layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
    val adapter: ColorAdapter

    init {
        name = view.findViewById(AddLessonDialogUI.name)
        cancel = view.findViewById(AddLessonDialogUI.cancel)
        recyclerView = view.findViewById(AddLessonDialogUI.RV)
        done = view.findViewById(AddLessonDialogUI.done)

        adapter = ColorAdapter(activity, Setting().getColorsList())
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        cancel.drawable.setColorFilter(Color.parseColor("#ff8f00"), PorterDuff.Mode.MULTIPLY)
        initialize()

        dialogBuilder.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogBuilder.setContentView(view)
        dialogBuilder.setCancelable(false)
        dialogBuilder.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogBuilder.show()
    }

    private fun initialize() {
        cancel.setOnClickListener {
            diss()
        }
        done.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val drawable = done.drawable
                if (drawable is Animatable) {
                    save()
                    drawable.start()
                    var v = object : CountDownTimer(300,100){
                        override fun onTick(p0: Long) {

                        }

                        override fun onFinish() {
                            diss()
                        }

                    }.start()
                }
            } else {

            }
        }
    }

    private fun save() {
        val db = WordDatabaseOpenHelper.getInstance(activity)
        db.use {
            insert("MyLesson",
                "Name" to name.text.toString(),
                "Color" to adapter.getColor())
        }
    }

    fun diss() {
        dialogBuilder.dismiss()
    }

}