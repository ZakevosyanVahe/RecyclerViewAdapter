package com.vmd.homework

import androidx.recyclerview.widget.DiffUtil
import com.vmd.homework.model.Person

class PersonDiffUtilItemCallBack: DiffUtil.ItemCallback<Person>() {
    override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
        oldItem == newItem
}