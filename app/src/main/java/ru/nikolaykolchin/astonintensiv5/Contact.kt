package ru.nikolaykolchin.astonintensiv5

data class Contact(
    var name: String,
    var familyName: String,
    var phoneNumber: String
) {
    override fun toString(): String {
        return "$name $familyName, $phoneNumber"
    }
}