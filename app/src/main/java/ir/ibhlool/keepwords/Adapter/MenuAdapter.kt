package ir.ibhlool.keepwords.Adapter

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import ir.ibhlool.keepwords.AddWordActivity
import ir.ibhlool.keepwords.Models.MenuModels
import ir.ibhlool.keepwords.R
import ir.ibhlool.keepwords.ReadActivity
import ir.ibhlool.keepwords.Rows.MenuRowUI
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.startActivity

class MenuAdapter(val activity: Activity, var list: List<MenuModels>) :
    RecyclerView.Adapter<MenuAdapter.MenuHolder>() {

    private var lastPosition = -1

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MenuHolder, position: Int) {
        holder.image.setImageDrawable(list[position].icon)
        holder.root.setOnClickListener {

        }
        setAnimation(holder.itemView, position)

        holder.root.setOnClickListener {
            when (position){
                0 ->{
                    var intent = Intent(activity, AddWordActivity::class.java)
                    activity.startActivity(intent)
                }
                1 ->{
                    var intent = Intent(activity, ReadActivity::class.java)
                    activity.startActivity(intent)
                }
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder {
        return MenuHolder(MenuRowUI().createView(AnkoContext.create(activity, parent, false)))
    }

    class MenuHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var root: ImageView = view.findViewById(MenuRowUI.root)
        var image: ImageView = view.findViewById(MenuRowUI.icon)
    }

    fun setAnimation(viewToAnimate: View, position: Int) {
        if (position > lastPosition && position % 2 == 0) {
            var animation = AnimationUtils.loadAnimation(activity, R.anim.left)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        } else {
            var animation = AnimationUtils.loadAnimation(activity, R.anim.right)
            viewToAnimate.startAnimation(animation)
            lastPosition = position
        }
    }
}