package ru.sharipov.shadow.outline

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import androidx.core.view.ViewCompat
import android.os.Build
import android.widget.FrameLayout


class OutlineShadowLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleRes) {

    private var viewOutline = OutlineProvider()
    private val paint = Paint()

    private val shadowMarginBottom: Int = 10
    private val shadowMarginLeft: Int = 10
    private val shadowMarginRight: Int = 10
    private val shadowMarginTop: Int = 10

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        updateViewOutline(w, h, 0.0F)
    }

    private fun updateViewOutline(width: Int, height: Int, radius: Float) {
        viewOutline.width = width
        viewOutline.height = height
        viewOutline.radius = radius
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && ViewCompat.getElevation(this) > 0f) {
            try {
                outlineProvider = viewOutline
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

//    override fun onDraw(canvas: Canvas?) {
//        super.onDraw(canvas)
//
//        canvas?.let {
//            val w = measuredWidth
//            val h = measuredHeight
//            val path = ShapeUtils.roundedRect(shadowMarginLeft.toFloat(), shadowMarginTop.toFloat(), (w - shadowMarginRight).toFloat()
//                , (h - shadowMarginBottom).toFloat()
//                , 0F
//                , 0F
//                , 0F
//                , 0F)
//            it.drawPath(path, paint)
//        }
//    }
//
//    override fun draw(canvas: Canvas?) {
//        super.draw(canvas)
//
//        canvas?.let {
//            canvas.save()
//            val w = measuredWidth
//            val h = measuredHeight
//            val path = ShapeUtils.roundedRect(shadowMarginLeft.toFloat(), shadowMarginTop.toFloat(), (w - shadowMarginRight).toFloat()
//                , (h - shadowMarginBottom).toFloat()
//                , 0F
//                , 0F
//                , 0F
//                , 0F)
//            canvas.clipPath(path)
////            drawForeground(canvas)
//            canvas.restore()
//        }
//    }
}