package com.matthew.weatherapp.ui.utils

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View
import com.matthew.weatherapp.R
import com.matthew.weatherapp.extensions.ctx
import com.matthew.weatherapp.ui.App
import org.jetbrains.anko.toast

/**
 * Created by Matthew on 20/09/2017.
 */
interface ToolbarManager {
    val toolbar: Toolbar;
    private fun CreateUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply {
        progress = 1f;
    }

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value;
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_settings -> App.instance.toast("Setings")
                else -> App.instance.toast("Unkown caption")
            }
            true
        }

    }

    fun enableHomeasUp(up: () -> Unit) {
        toolbar.navigationIcon = createUpDrawable();
        toolbar.setNavigationOnClickListener { up() }
    }

    private fun createUpDrawable() =
            with(DrawerArrowDrawable(toolbar.ctx)) {
                progress = 1f;
                this;
            }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }

    fun View.slideExit() {
        if (translationY == 0f) animate().translationY(-height.toFloat())

    }

    fun View.slideEnter() {
        if (translationY < 0f) animate().translationY(0f)
    }


}