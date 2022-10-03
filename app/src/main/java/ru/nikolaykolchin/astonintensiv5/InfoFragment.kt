package ru.nikolaykolchin.astonintensiv5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

const val ITEM_INDEX = "item_index"
private const val ITEM_INDEX_DEFAULT = -1

class InfoFragment : Fragment() {
    private lateinit var editName: EditText
    private lateinit var editFamilyName: EditText
    private lateinit var editPhone: EditText
    private lateinit var buttonSave: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editName = view.findViewById(R.id.editTextName)
        editFamilyName = view.findViewById(R.id.editTextFamilyName)
        editPhone = view.findViewById(R.id.editTextPhone)
        buttonSave = view.findViewById(R.id.buttonSave)

        val args: Bundle? = arguments
        val itemIndex = args?.getInt(ITEM_INDEX, ITEM_INDEX_DEFAULT)
            ?: ITEM_INDEX_DEFAULT
        if (itemIndex != ITEM_INDEX_DEFAULT) setDetails(itemIndex)

        buttonSave.setOnClickListener {
            contactsData[itemIndex].name = editName.text.toString()
            contactsData[itemIndex].familyName = editFamilyName.text.toString()
            contactsData[itemIndex].phoneNumber = editPhone.text.toString()

            parentFragmentManager.popBackStack()
        }
    }

    fun setDetails(itemIndex: Int) {
        editName.setText(contactsData[itemIndex].name)
        editFamilyName.setText(contactsData[itemIndex].familyName)
        editPhone.setText(contactsData[itemIndex].phoneNumber)
    }
}