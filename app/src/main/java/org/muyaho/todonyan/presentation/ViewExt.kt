package org.muyaho.todonyan.presentation

import android.view.View

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}