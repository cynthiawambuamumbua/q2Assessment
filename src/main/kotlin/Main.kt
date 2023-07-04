fun main() {
    val story = Story(10, 3, 7, "The hare and elephant")
    story.display_details()

    val storyteller = StoryTeller("Kamba", "Cynthia Mumbua", 12, 4, 10, "How the hare was clever than elephant")
    println("${storyteller.storyteller_name} from ${storyteller.origin_language} tells the story of ${storyteller.title}.")
    storyteller.display_details()

    val translator = Translator("Swahili", 10, 3, 8, 2, "pakistan")
    println("The story '${translator.title}' which is ${translator.story_length} long and has ${translator.moral_lessons} moral lessons originally in ${translator.origin_language} has been translated to ${translator.new_language}.")
    translator.display_details()

    val recipe = Recipe("morocan", "beef", "morning", "frying", "healthy")
    recipe.display_recipe()

    val recipe1 = EthiopianRecipe("Ethiopian", "ajwain", "noon", "boiling", "not healthy", "coffee")
    recipe1.display_recipe()

    val recipe2 = NigerianRecipe("nigerian", "rice", "evening", "boiling", "healthier", "pudding")
    recipe2.display_recipe()
    val tiger = Predator("Tiger", "Carnivore", 15, listOf("Deer", "Wild boar", "Water buffalo"))
    val deer = Prey("Deer", "Herbivore", 10, listOf("Tiger", "Wolf", "Leopard"))

    println("The ${tiger.getName()} is a ${tiger.getDiet()} that has a lifespan of ${tiger.getLifespan()} years.")
    println("It preys on the following animals: ${tiger.getPreyList()}")

    println("The ${deer.getName()} is a ${deer.getDiet()} that has a lifespan of ${deer.getLifespan()} years.")
    println("It is preyed upon by the following animals: ${deer.getPredatorList()}")


    val books = Product("books",80.00,10)
    val sharpeners = Product("sharpeners",30.00,10)
    val rulers = Product("rulers",15.00,5)
    println(books.calculateTotalPrice())
    println(sharpeners.calculateTotalPrice())
    println(rulers.calculateTotalPrice())

    val njeri = Student("Njeri", 24, listOf(40, 50, 80, 72, 48, 90))
    println(njeri.displayInfo())
    println(njeri.calculateAveGrade())
    println(njeri.passMark())
    val john = Student("John", 22, listOf(60, 70, 65, 80, 75))
    val emily = Student("Emily", 20, listOf(90, 85, 95, 92, 88))



    val david = Student("David", 26, listOf(55, 60, 58, 62, 70))

    val flights = listOf(
        Flight("12345", "New York", "Los Angeles", "2023-07-08", 100),
        Flight("67890", "Los Angeles", "New York", "2023-07-10", 100)
    )

    val flightBooking = FlightBooking(flights)

    val flight = flightBooking.searchFlights("New York", "Los Angeles", "2023-07-08")

    if (flight != null) {
        flightBooking.reserveSeat(flight, "John Doe", "johndoe@example.com")
        flightBooking.managePassengerInformation(flight, "John Doe", "name", "Jane Doe")

        val bookingConfirmation = flightBooking.generateBookingConfirmation(flight)

        println(bookingConfirmation)
    }



}


// **Ancestral Stories:** In many African cultures,
//  the art of storytelling is passed
//  down from generation to generation. Imagine you're
// #creating an application that
// records these oral stories and translates them into different languages. The
// stories vary by length, moral lessons, and the age group they are intended for.
// Think about how you would model `Story`, `StoryTeller`, and `Translator`
// objects, and how inheritance might come into play if there are different types of
// stories or storytellers.

// input=length,moral-lessons,age-group
// output=story,story-teller,translator
// process=create a class;create the constructor,pass in the attributes,
//  create methods and pass in the conditions
open class Story(var story_length: Int, var moral_lessons: Int, var age_group: Int, var title: String) {
    var origin_language: String = if (age_group >= 7) {
        "English"
    } else {
        "French"
    }
    var new_language: String = if (moral_lessons == 2) {
        "Swahili"
    } else {
        "Zulu"
    }

    open fun display_details() {
        println("$title is a story for children who are $age_group years old. It is $story_length pages long and has $moral_lessons moral lessons. It was originally written in $origin_language and has been translated to $new_language.")
    }
}

class StoryTeller(var community_origin: String, var storyteller_name: String, story_length: Int, moral_lessons: Int, age_group: Int, title: String, var storyLength: Int) : Story(story_length, moral_lessons, age_group, title) {
    var language: String = if (story_length < 10) {
        "English"
    } else {
        "Swahili"
    }

    override fun display_details() {
        println("$storyteller_name from ${origin_language}tells the story of $title in $language and the story limit is $storyLength.")
    }
}

class Translator(title: String, story_length: Int, moral_lessons: Int, age_group: Int,  origin_language: String, new_language: String) : Story(story_length, moral_lessons, age_group, title) {
    var language_level: String = if (age_group < 10) {
        "Beginner"
    } else {
        "Intermediate"
    }

    override fun display_details() {
        println("The story '$title' which is $story_length pages long and has $moral_lessons moral lessons was originally written in $origin_language and translated to $new_language for $age_group-year-olds at a $language_level level.")
    }
}
// q2
// **African Cuisine:** You're creating a recipe app specifically for African cuisine.
// The app needs to handle recipes from different African countries, each with its
// unique ingredients, preparation time, cooking method, and nutritional
// information. Consider creating a `Recipe` class, and think about how you might
// create subclasses for different types of recipes (e.g., `MoroccanRecipe`,
// `EthiopianRecipe`, `NigerianRecipe`), each with their own unique properties and
// methods.

// input=ingredients,preparation time,cooking method,nutritional information
// output=different types of recipes(moroccanRecipe,EthiopianRecipe,NigerianRecipe)
//  process=create a class Recipe,create subclasses,pass in the attributes,create methods and their subclasses

open class Recipe(
    var name: String,
    var ingredients: String,
    var preparation_time: String,
    var cooking_method: String,
    var nutritional_info: String
) {
    open fun display_recipe() {
        println("Recipe Name: $name")
        println("Ingredients: $ingredients")
        println("Preparation Time: $preparation_time")
        println("Cooking Method: $cooking_method")
        println("Nutritional Info: $nutritional_info")
    }
}

class MoroccanRecipe(
    name: String,
    ingredients: String,
    preparation_time: String,
    cooking_method: String,
    nutritional_info: String,
    var flavor: String
) : Recipe(name, ingredients, preparation_time, cooking_method, nutritional_info) {

    override fun display_recipe() {
        super.display_recipe()
        println("flavor: $flavor")
    }
}

class EthiopianRecipe(
    name: String,
    ingredients: String,
    preparation_time: String,
    cooking_method: String,
    nutritional_info: String,
    var additional_drink: String) : Recipe(name, ingredients, preparation_time, cooking_method, nutritional_info) {

    override fun display_recipe() {
        super.display_recipe()
        println("additional_drink: $additional_drink")
    }
}

class NigerianRecipe(
    name: String,
    ingredients: String,
    preparation_time: String,
    cooking_method: String,
    nutritional_info: String,
    var dessert: String
) : Recipe(name, ingredients, preparation_time, cooking_method, nutritional_info) {

    override fun display_recipe() {
        super.display_recipe()
        println("dessert: $dessert")
    }
}
//**Wildlife Preservation:** You're a wildlife conservationist working on a
//program to track different species in a national park. Each species has its own
//characteristics and behaviours, such as its diet, typical lifespan, migration
//patterns, etc. Some species might be predators, others prey. You'll need to
//create classes to model `Species`, `Predator`, `Prey`, etc., and think about how
//These classes might relate to each other through inheritance.
open class Species(val name: String, val diet: String, val lifeSpan: Int) {
    fun getName() {
        println( "the $name of the diet the animal takes is $diet and its lifespan is $lifeSpan")
    }
    fun getDiet() {
       println("The diet of animal $name is $diet and its lifespan is $lifeSpan")
    }
    fun getLifespan() {
        println("The lifespan of animal $name is $lifeSpan and its diet is $diet ")
    }
}

class Predator(name: String, diet: String, lifeSpan: Int, val preyList: List<String>) : Species(name, diet, lifeSpan) {
    fun getPreyList(){
        println("the prey list is $preyList")
    }
}

class Prey(name: String, diet: String, lifeSpan: Int, val predatorList: List<String>) : Species(name, diet, lifeSpan) {
    fun getPredatorList() {
        println("the predator list is $predatorList")
    }
}
//**African Music Festival:** You're in charge of organizing a Pan-African music
//festival. Many artists from different countries, each with their own musical style
//and instruments, are scheduled to perform. You need to write a program to
//manage the festival lineup, schedule, and stage arrangements. Think about how
//you might model the `Artist`, `Performance`, and `Stage` classes, and consider
//how you might use inheritance if there are different types of performances or
//stages.

//Create a class called Product with attributes for name, price, and quantity.
//Implement a method to calculate the total value of the product (price * quantity).
//Create multiple objects of the Product class and calculate their total values.

class Product(var name:String,var price:Double, var quantity:Int){
    fun calculateTotalPrice():String{
        val totalPrice = quantity * price
        return "The total amount for the products is $totalPrice"
    }
}

//Implement a class called Student with attributes for name, age, and grades (a
//list of integers). Include methods to calculate the average grade, display the
//student information, and determine if the student has passed (average grade >=
//60). Create objects for the Student class and demonstrate the usage of these
//methods.
class Student(val name: String, val age: Int, val grades: List<Int>) {

    fun displayInfo(): String {
        return "Hello, I am $name and I am $age years old."
    }

    fun calculateAveGrade(): Double {
        var totalGrades = 0
        for (grade in grades) {
            totalGrades += grade
        }

        val aveGrade = totalGrades.toDouble() / grades.size
        return aveGrade
    }

    fun passMark(): String {
        val aveGrade = calculateAveGrade()
        return if (aveGrade >= 60) {
            "Congratulations, $name! You have passed."
        } else {
            "$name, you have not attained the passmark. Work harder!"
        }
    }
}
class FlightBooking(private val flights: List<Flight>) {

    fun searchFlights(destination: String, date: String, s: String): Flight? {
        return flights.find { it.destination == destination && it.date == date }
    }

    fun reserveSeat(flight: Flight, passengerName: String, passengerEmail: String) {
        if (!flights.contains(flight)) {
            throw IllegalArgumentException("Flight not found")
        }
        if (flight.isFull) {
            throw IllegalArgumentException("Flight is full")
        }
        flight.passengers.add(Passenger(passengerName, passengerEmail))
    }

    fun managePassengerInformation(flight: Flight, passengerName: String, field: String, newValue: String) {
        for (passenger in flight.passengers) {
            if (passenger.name == passengerName) {
                when (field) {
                    "name" -> passenger.name = newValue
                    "email" -> passenger.email = newValue
                    else -> throw IllegalArgumentException("Invalid field")
                }
            }
        }
    }

    fun generateBookingConfirmation(flight: Flight): String {
        return """
            Your booking for flight ${flight.id} has been confirmed.
            Departure: ${flight.departureAirport}
            Arrival: ${flight.arrivalAirport}
            Date: ${flight.date}
            Passengers:
            ${flight.passengers.joinToString("\n") { "${it.name} (${it.email})" }}
        """.trimIndent()
    }
}

data class Flight(
    val id: String,
    val destination: String,
    val arrivalAirport: String,
    val date: String,
    val capacity: Int,
    val passengers: MutableList<Passenger> = mutableListOf()
) {
    val departureAirport: String
        get() {
            TODO()
        }
    val isFull: Boolean = false
}

data class Passenger(var name: String, var email: String)

