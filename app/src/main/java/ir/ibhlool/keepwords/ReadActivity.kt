package ir.ibhlool.keepwords

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import ir.ibhlool.keepwords.Adapter.LessonAdapter
import ir.ibhlool.keepwords.Dialog.AddReadLessonDialog
import ir.ibhlool.keepwords.Models.LessonModel
import ir.ibhlool.keepwords.UIs.ReadActivityUI
import ir.ibhlool.keepwords.dataBase.WordDatabaseOpenHelper
import org.jetbrains.anko.db.select
import org.jetbrains.anko.setContentView
import java.lang.Exception

class ReadActivity : AppCompatActivity() {

    lateinit var floatingButton: ImageView
    private val activity = this
    lateinit var title: TextView

    lateinit var adapter: LessonAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ReadActivityUI().setContentView(this)

        floatingButton = findViewById(ReadActivityUI.floatingButton)
        title = findViewById(ReadActivityUI.title)
        recyclerView = findViewById(ReadActivityUI.RV)

        design()
        initialize()
    }

    private fun design() {
        val s1 = "<font color='#ff8f00'>R</font>"
        val s2 = "<font color='#ffffff'>ead</font>"


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            title.text = Html.fromHtml(s1 + s2, Html.FROM_HTML_MODE_COMPACT)
        } else {
            title.text = Html.fromHtml(s1 + s2)
        }
    }

    private fun initialize() {
        floatingButton.setOnClickListener {
            val dialog = AddReadLessonDialog(activity)
        }

        val arr = ArrayList<LessonModel>()
        val db = WordDatabaseOpenHelper.getInstance(activity)
        try {
            db.use {
                select(
                    "MyLesson",
                    "*"
                ).exec {
                    while (moveToNext()) {
                        val i = LessonModel(
                            name = getString(getColumnIndex("Name")),
                            color = getInt(getColumnIndex("Color")),
                            ID = getInt(getColumnIndex("ID"))
                        )
                        arr.add(i)
                    }
                }
            }
        }catch (ex : Exception){
            var st = ex.message
        }


        adapter = LessonAdapter(activity, arr)
        layoutManager = LinearLayoutManager(activity, LinearLayout.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }
}
