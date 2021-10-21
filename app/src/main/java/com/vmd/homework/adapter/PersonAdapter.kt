package com.vmd.homework.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vmd.homework.PersonDiffUtilItemCallBack
import com.vmd.homework.R
import com.vmd.homework.model.Person

class PersonAdapter : ListAdapter<Person, PersonAdapter.PersonAdapterViewHolder>(
    AsyncDifferConfig.Builder(PersonDiffUtilItemCallBack()).build()
) {

    class PersonAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val personData: TextView = itemView.findViewById(R.id.person_item)
        fun Bind(person: Person) {
            personData.text = person.name
            personData.setOnClickListener {
                val data = "${person.id} ${person.name} ${person.age}"
                Toast.makeText(
                    personData.context,
                    data,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapterViewHolder {
        return PersonAdapterViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.person_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PersonAdapterViewHolder, position: Int) {
        holder.Bind(getItem(position))
    }

}