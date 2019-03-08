package ir.ibhlool.keepwords

import android.graphics.drawable.Animatable
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.text.Html
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import ir.ibhlool.keepwords.UIs.AddWordActivityUI
import ir.ibhlool.keepwords.dataBase.WordDatabaseOpenHelper
import org.jetbrains.anko.backgroundResource
import org.jetbrains.anko.db.NOT_NULL
import org.jetbrains.anko.db.TEXT
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.setContentView

class AddWordActivity : AppCompatActivity() {

    lateinit var title: TextView
    lateinit var back: ImageView
    lateinit var word :TextView
    lateinit var definition :TextView
    lateinit var wordInUse :TextView
    lateinit var means :TextView
    lateinit var done : ImageView

    val activity = this



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AddWordActivityUI().setContentView(this)

        title = findViewById(AddWordActivityUI.title)
        back = findViewById(AddWordActivityUI.back)
        word = findViewById(AddWordActivityUI.word)
        wordInUse = findViewById(AddWordActivityUI.wordInUse)
        definition = findViewById(AddWordActivityUI.definition)
        means = findViewById(AddWordActivityUI.means)
        done = findViewById(AddWordActivityUI.done)

        initialize()


    }

    private fun initialize() {
        design()
    }

    private fun design() {
        val s1 = "<font color='#ff8f00'>A</font>"
        val s2 = "<font color='#ffffff'>dd </font>"
        val s3 = "<font color='#ff8f00'>W</font>"
        val s4 = "<font color='#ffffff'>ord</font>"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            title.text = Html.fromHtml(s1 + s2  + s3 + s4, Html.FROM_HTML_MODE_COMPACT)
        } else {
            title.text = Html.fromHtml(s1 + s2  + s3 + s4)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            val outValue = TypedValue()
            theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, outValue, true)
            back.backgroundResource = outValue.resourceId
        }

        back.setOnClickListener{
            finish()
        }
        done.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                val drawable = done.drawable
                if (drawable is Animatable){
                    save()
                    drawable.start()
                }
            }else{

            }
        }
    }

    private fun save() {
        val db = WordDatabaseOpenHelper.getInstance(activity)
        db.use {
            insert("MyWord",
                "Word" to word.text.toString(),
                "Definition" to definition.text.toString(),
                "WordInUse" to wordInUse.text.toString(),
                "Means" to means.text.toString(),
                "Voice" to "",
                "GroupID" to "")
        }
    }
}
