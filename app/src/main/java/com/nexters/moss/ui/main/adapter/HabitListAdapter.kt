package com.nexters.moss.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nexters.moss.R

class HabitListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var itemList = ArrayList<String>()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        return when (viewType) {
            VIEW_TYPE_HABIT -> {
                HabitViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_main_habit, parent, false)
                )
            }
            else -> {
                HabitViewHolder(
                    LayoutInflater.from(context).inflate(R.layout.item_main_habit, parent, false)
                )
            }
        }
    }

    override fun getItemCount() = itemList.size
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is AddHabitViewHolder -> {

            }
            is HabitViewHolder -> {
                holder.habitName.text = itemList[position]
            }
            is EditHabitViewHolder -> {

            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (itemList.size == position) {
            VIEW_TYPE_ADD_HABIT
        } else {
            VIEW_TYPE_HABIT
        }
    }

    fun refreshItemList(list: ArrayList<String>) {
        itemList = list
    }

    class AddHabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
    class HabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val habitName: TextView = itemView.findViewById(R.id.tv_habitName)
    }
    class EditHabitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    companion object {
        const val VIEW_TYPE_ADD_HABIT = 0
        const val VIEW_TYPE_HABIT = 1
        const val VIEW_TYPE_EDIT_HABIT = 2
    }

}