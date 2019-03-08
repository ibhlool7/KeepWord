package ir.ibhlool.keepwords

import android.graphics.Color.GREEN
import android.graphics.Color.YELLOW
import ir.ibhlool.keepwords.Models.ColorModel

class Setting {
    companion object {
        const val GREEN = 0
        const val RED = 1
        const val YELLOW = 2
        const val BLUE = 3
        private val colorMap = HashMap<Int,String>()

        fun getColorMap(id : Int) : String?{
            if (colorMap.size == 0){
                createColorMap()
            }
            return colorMap[id]
        }

        private fun createColorMap() {
            colorMap[GREEN] = "#8BC34A"
            colorMap[RED] = "#F44336"
            colorMap[YELLOW] = "#FFEB3B"
            colorMap[BLUE] = "#2196F3"
        }
    }


    fun getColorsList(): ArrayList<ColorModel> {
        val arr = ArrayList<ColorModel>()

        val green = ColorModel("green", "#8BC34A", GREEN)
        val red = ColorModel("red", "#F44336", RED)
        val yellow = ColorModel("yellow", "#FFEB3B", YELLOW)
        val blue = ColorModel("blue", "#2196F3", BLUE)

        arr.add(green)
        arr.add(red)
        arr.add(yellow)
        arr.add(blue)

        return arr
    }
}

