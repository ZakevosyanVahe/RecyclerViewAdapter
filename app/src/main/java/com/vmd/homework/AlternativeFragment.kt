package com.vmd.homework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.vmd.homework.model.Person

private const val KEY = "KEY"
const val REQUESTKEY = "FR_RESULT"
const val RESULT = "RESULT"

class AlternativeFragment : Fragment() {

    companion object {
        fun newInstance() = AlternativeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alternativ_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.back_button).setOnClickListener {
            parentFragmentManager.setFragmentResult(
                REQUESTKEY,
                bundleOf(RESULT to Person(0, "Ani", 18))
            )

            parentFragmentManager.popBackStack()
        }
    }
}