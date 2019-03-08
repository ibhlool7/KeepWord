package ir.ibhlool.keepwords.Adapter

import android.app.Activity
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import ir.ibhlool.keepwords.Models.ColorModel
import ir.ibhlool.keepwords.Rows.ColorRowUI
import org.jetbrains.anko.AnkoContext
import java.lang.Exception

class ColorAdapter(val activity: Activity, var list: ArrayList<ColorModel>) :
    RecyclerView.Adapter<ColorAdapter.ColorHolder>() {

    var lastClicked = 0

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ColorHolder {
        return ColorHolder(ColorRowUI().createView(AnkoContext.create(activity, parent, false)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ColorHolder, position: Int) {
        try {
            holder.pellate.setColorFilter(Color.parseColor(list[position].Color), PorterDuff.Mode.MULTIPLY)
        } catch (ex: Exception) {
            var st = ex.message
        }
        if (position != lastClicked){
            holder.pellate.alpha = .3f
        }else{
            holder.pellate.alpha = 1f
        }
        holder.pellate.setOnClickListener {
            lastClicked = position
            notifyDataSetChanged()
        }
    }

    fun getColor():Int{
        return list[lastClicked].ID
    }

    class ColorHolder(val view: View) : RecyclerView.ViewHolder(view) {

        lateinit var pellate: ImageView

        init {
            pellate = view.findViewById(ColorRowUI.pellate)
        }

    }
}