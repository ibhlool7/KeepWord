package ir.ibhlool.keepwords

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import ir.ibhlool.keepwords.Adapter.MenuAdapter
import ir.ibhlool.keepwords.Models.MenuModels
import ir.ibhlool.keepwords.UIs.MainActivityUI
import ir.ibhlool.keepwords.dataBase.WordDatabaseOpenHelper
import org.jetbrains.anko.db.select
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {
    private val activity = this
    lateinit var recyclerView : RecyclerView
    private var gridLayoutManager: GridLayoutManager = GridLayoutManager(activity, 2)
    private var menuAdapter : MenuAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
        recyclerView = findViewById(MainActivityUI.RV)
        prepareMenu()
    }




    private fun prepareMenu() {
        var arr = listOf(MenuModels("add",resources.getDrawable(R.drawable.addword)),
            MenuModels("note",resources.getDrawable(R.drawable.read)) ,
            MenuModels("re",resources.getDrawable(R.drawable.spelling)),
            MenuModels("add",resources.getDrawable(R.drawable.note_wall)))

        val db = WordDatabaseOpenHelper.getInstance(activity)
        db.use {
            var a = select("MyWord")
            var asd = "45"
        }
        menuAdapter = MenuAdapter(activity,arr)
        recyclerView.adapter = menuAdapter
        recyclerView.layoutManager = gridLayoutManager

    }

}
