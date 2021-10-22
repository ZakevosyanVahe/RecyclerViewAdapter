package com.vmd.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vmd.homework.adapter.PersonAdapter
import com.vmd.homework.model.Person
import com.vmd.homework.source.PersonList

class PersonFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.person_fragment,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var persons = PersonList().loadPerson()

        val personFragment = PersonAdapter()

        personFragment.submitList(persons)

        val buttonUpdate = view.findViewById<Button>(R.id.update_list)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = personFragment
        recyclerView.layoutManager = GridLayoutManager(context, 2)


        buttonUpdate.setOnClickListener {
            persons.toMutableList()
                .apply {
                    //removeAt(2)

                    add(5, Person(2, "Artak", 60))
                }
                .also {
                    persons = it
                }
            personFragment.submitList(persons)
        }

        val addFragment = view.findViewById<Button>(R.id.add_fragment_button)
        addFragment.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AlternativeFragment())
                .addToBackStack(null)
                .commit()
        }
        parentFragmentManager.setFragmentResultListener(REQUESTKEY,viewLifecycleOwner){ _, bundle ->

                persons.toMutableList()
                    .apply {
                        add(2,bundle.get(RESULT) as Person)
                    }
                    .also {
                        persons = it
                    }
            personFragment.submitList(persons)
            recyclerView.layoutManager = LinearLayoutManager(context)
                Toast.makeText(context, "${bundle.get(RESULT)}", Toast.LENGTH_LONG).show()
        }
    }
}