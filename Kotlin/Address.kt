class Contact(var name: String, var phone: String, var email: String) {
    override fun toString(): String {
        return "Name: $name\nPhone: $phone\nEmail: $email\n"
    }
}

class Address {
    private val contacts = mutableMapOf<String, Contact>()
    fun addContact(name: String, phone: String, email: String) {
        contacts[name] = Contact(name, phone, email)
        println("Contact added successfully")
    }

    fun searchContact(name: String) {
        contacts[name]?.let {
            println(it)
        } ?: println("Contact not found!")
    }

    fun listContact() {
        if(contacts.isEmpty()) {
            println("Address book is empty!")
            return
        }
        contacts.values.forEach{println(it)}
    }

    fun deleteContact() {
        if(contacts.remove(name) != null) {
            println("Contact deleted successfully!")
        } else {
            println("Contact not found!")
        }
    }
}

fun main() {
    val addressBook = AddressBook()

    while(true) {
        println("\n===Address Book ===")
        println("1. Add Contact")
        println("2. Search Contact")
        println("3. List All Contacts")
        println("4. Delete Contact")
        println("5. Exit")
        print("Choose an option: ")
        when(readLine()) {
            "1" -> {
                print("Enter name: ")
                val name = readLine() ?: continue
                print("Enter phone: ")
                val phone = readLine() ?: continue
                print("Enter email: ")
                val email = readLine() ?: continue
                addressBook.addContact(name, phone, email)
            }
            "2" -> {
                print("Enter name to search: ")
                val name = readLine() ?: continue
                addressBook.deleteContact(name)
            }
            "3" -> addressBook.listContact()
            "4" -> {
                print("Enter name to delete: ")
                val name = readLine() ?: continue
                addressBook.deleteContact(name)
            }
            "5" -> break
            else -> println("Invalid option")
        }
    }
}
