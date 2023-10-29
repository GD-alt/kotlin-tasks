import kotlin.random.Random

val cities = arrayOf("Moscow", "Saint Petersburg", "Novosibirsk", "Yekaterinburg", "Nizhny Novgorod", "Kazan", "Chelyabinsk", "Omsk", "Samara", "Rostov-on-Don", "Samara", "London", "Pittsburgh", "Berlin", "Esch-sur-Alzette", "Paris", "Madrid", "Rome", "Warsaw", "Budapest", "Vienna", "Prague", "Bratislava", "Ljubljana", "Zagreb", "Belgrade", "Sarajevo", "Skopje", "Sofia", "Bucharest", "Athens", "Istanbul", "Kyiv", "Minsk", "Riga", "Tallinn", "Helsinki", "Stockholm", "Oslo", "Copenhagen", "Amsterdam", "Brussels", "Luxembourg", "Bern", "Monaco", "Vaduz", "Andorra la Vella", "Lisbon", "Dublin", "Reykjavik", "Washington", "New York", "Los Angeles", "Chicago", "Houston", "Philadelphia", "Phoenix", "San Antonio", "San Diego", "Dallas", "San Jose", "Austin", "Jacksonville", "Fort Worth", "Columbus", "San Francisco", "Charlotte", "Indianapolis", "Seattle", "Denver", "Boston", "El Paso", "Detroit", "Nashville", "Portland", "Memphis", "Oklahoma City", "Las Vegas", "Louisville", "Baltimore", "Milwaukee", "Albuquerque", "Tucson", "Fresno", "Sacramento", "Mesa", "Kansas City", "Atlanta", "Long Beach", "Colorado Springs", "Raleigh", "Miami", "Virginia Beach", "Omaha", "Oakland", "Minneapolis", "Tulsa", "Arlington", "New Orleans", "Wichita", "Cleveland", "Tampa", "Bakersfield", "Aurora", "Honolulu", "Anaheim", "Santa Ana", "Corpus Christi", "Riverside", "St. Louis", "Lexington", "Stockton", "Pittsburgh", "Anchorage", "Cincinnati", "Saint Paul", "Greensboro", "Toledo", "Newark", "Plano", "Henderson", "Lincoln", "Buffalo", "Jersey City", "Chula Vista", "Fort Wayne", "Orlando", "Chandler", "Laredo", "Norfolk", "Durham", "Madison", "Käerjeng")

class Train {
    var carts = emptyArray<Cart>()
    private var passengers = 0

    init {
        var city1 = ""
        var city2 = ""

        while (city1 == city2) {
            city1 = cities.random()
            city2 = cities.random()
        }

        println("🚂 The train is traveling from $city1 to $city2.")
    }

    fun sellTickets() {
        passengers = Random.nextInt(5, 201)

        println("🎫 The train is selling $passengers tickets.\n")
    }

    fun fillTrain() {
        var passengersLeft = passengers

        while (passengersLeft > 0) {
            val cart = Cart()

            cart.fillCart(passengersLeft)

            passengersLeft -= cart.passengers

            carts += cart
        }
    }

    fun sendTrain() {
        println("\n🛤️The train is traveling.\n")
    }
}

class Cart(val capacity: Int = Random.nextInt(5, 25), var passengers: Int = 0) {
    fun fillCart(amount: Int) {
        passengers = if (amount > capacity) {
            capacity
        } else {
            amount
        }
    }
}

fun main() {
    var nextAction: String

    println("⏲️ Welcome to the train station!")
    println("What are we going to do: send a train or stop working? (enter `y` to send a train, `n` to stop)")

    while (true) {
        nextAction = readln()
        if (nextAction == "n") {
            println("Thanks for working with us!")
            return
        } else if (nextAction == "y") {
            println("Let's see, what we have here.\n")
            break
        } else {
            println("Invalid input. Please enter 'y' or 'n'.")
        }
    }

    while (true) {
        val train = Train()

        train.sellTickets()

        train.fillTrain()

        for (i in 0..<train.carts.size) {
            println("🚃 Cart ${i + 1} has ${train.carts[i].passengers} passengers out of ${train.carts[i].capacity}.")
        }

        train.sendTrain()

        println("What are we going to do this time: send a train or stop working? (enter `y` to send a train, `n` to stop)")
        while (true) {
            nextAction = readln()
            if (nextAction == "n") {
                println("Thanks for traveling with us!")
                return
            } else if (nextAction == "y") {
                println("Let's go again!\n")
                break
            } else {
                println("Invalid input. Please enter 'y' or 'n'.")
            }
        }
    }
}