package ru.nikolaykolchin.astonintensiv5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

const val TAG_FRAGMENT_CONTACTS = "fragmentContacts"
const val TAG_FRAGMENT_INFO = "fragmentInfo"

var contactsData = arrayOf(
    Contact("Ivan", "Ivanov", "88005553535"),
    Contact("Petr", "Petrov", "88005553536"),
    Contact("Tanya", "Danilova", "88005553537"),
    Contact("Grisha", "Popov", "88005553538"),
    Contact("Roman", "Lobanov", "88005553539")
)

class MainActivity : AppCompatActivity(), OnSelectedItemListener {
    private var isDynamic: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentInfo = fragmentManager.findFragmentById(R.id.infoFragment) as InfoFragment?
        isDynamic = (fragmentInfo == null) || !fragmentInfo.isInLayout

        if (isDynamic) {
            val ft: FragmentTransaction = fragmentManager.beginTransaction()
            val fragmentContacts = ContactsFragment()
            ft.add(R.id.container, fragmentContacts, TAG_FRAGMENT_CONTACTS)
            ft.commit()
        }
    }

    override fun onItemSelected(itemIndex: Int) {
        val fragmentManager = supportFragmentManager
        val fragmentInfo: InfoFragment

        if (isDynamic) {
            val ft: FragmentTransaction = fragmentManager.beginTransaction()
            fragmentInfo = InfoFragment()

            val args = Bundle()
            args.putInt(ITEM_INDEX, itemIndex)
            fragmentInfo.arguments = args

            ft.replace(R.id.container, fragmentInfo, TAG_FRAGMENT_INFO)
            ft.addToBackStack(null)
            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
            ft.commit()
        } else {
            fragmentInfo = fragmentManager.findFragmentById(R.id.infoFragment) as InfoFragment
            fragmentInfo.setDetails(itemIndex)
        }
    }
}