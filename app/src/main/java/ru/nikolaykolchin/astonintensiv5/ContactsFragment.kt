package ru.nikolaykolchin.astonintensiv5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.ListFragment

interface OnSelectedItemListener {
    fun onItemSelected(itemIndex: Int)
}

class ContactsFragment : ListFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =
            activity?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_list_item_activated_1,
                    contactsData
                )
            }
        listAdapter = adapter
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        val listener = activity as OnSelectedItemListener?
        listener?.onItemSelected(position)
    }
}