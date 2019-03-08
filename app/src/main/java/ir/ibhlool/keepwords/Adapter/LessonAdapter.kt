package ir.ibhlool.keepwords.Adapter

import android.app.Activity
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ir.ibhlool.keepwords.Models.LessonModel
import ir.ibhlool.keepwords.Rows.LessonRow
import ir.ibhlool.keepwords.Setting
import org.jetbrains.anko.AnkoContext
import java.lang.Exception
import java.text.FieldPosition

class LessonAdapter(private val activity: Activity, private val list: ArrayList<LessonModel>) :
    RecyclerView.Adapter<LessonAdapter.LessonHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LessonHolder {
        return LessonHolder(LessonRow().createView(AnkoContext.create(activity, p0, false)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: LessonHolder, position:Int) {

        holder.name.text = list[position].name
        try {
            holder.palate.setColorFilter(Color.parseColor(Setting.getColorMap(list[position].ID)))
        }catch (ex : Exception){
            var s = ex.message
        }
//        holder.last

    }

    inner class LessonHolder(view: View) : RecyclerView.ViewHolder(view) {

        val palate: ImageView = view.findViewById(LessonRow.palate)
        val name: TextView = view.findViewById(LessonRow.name)
        val last: TextView = view.findViewById(LessonRow.last)

    }
}