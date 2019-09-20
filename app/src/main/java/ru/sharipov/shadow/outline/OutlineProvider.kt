package ru.sharipov.shadow.outline

import android.graphics.Outline
import android.view.View
import android.view.ViewOutlineProvider

class OutlineProvider : ViewOutlineProvider() {

    var width: Int = 0
    var height: Int = 0
    var radius: Float = 0.0F

    override fun getOutline(p0: View?, p1: Outline?) {
        p1?.setRect(0, 0, width, height)
    }
}