fun main() {
    val options = arrayOf("rock", "paper", "scissors")

    var wins = 0
    var losses = 0
    var ties = 0

    println("Let's play Rock Paper Scissors!")

    while (true) {
        println("Current wins: $wins, losses: $losses, ties: $ties.")
        val gameChoice = getGameChoice(options)
        val userChoice = getUserChoice(options)
        println("You chose $userChoice. I chose $gameChoice.")

        when {
            userChoice == gameChoice -> {
                println("We tied!")
                ties++
            }

            (userChoice == "rock" && gameChoice == "scissors") || (userChoice == "scissors" && gameChoice == "rock") -> {
                println("Rock breaks scissors…")

                when (userChoice) {
                    "scissors" -> {
                        losses++
                        println("I win!")
                    }
                    "rock" -> {
                        wins++
                        println("You win!")
                    }
                }
            }
            (userChoice == "paper" && gameChoice == "rock") || (userChoice == "rock" && gameChoice == "paper") -> {
                println("Paper covers rock…")

                when (userChoice) {
                    "rock" -> {
                        losses++
                        println("I win!")
                    }
                    "paper" -> {
                        wins++
                        println("You win!")
                    }
                }
            }
            (userChoice == "scissors" && gameChoice == "paper") || (userChoice == "paper" && gameChoice == "scissors") -> {
                println("Scissors cut paper…")

                when (userChoice) {
                    "paper" -> {
                        losses++
                        println("I win!")
                    }
                    "scissors" -> {
                        wins++
                        println("You win!")
                    }
                }
            }
        }

        println("Do you want to play again? (y/n)")
        do {
            val playAgain = readln()
            if (playAgain == "n") {
                println("Thanks for playing!\n")
                return
            } else if (playAgain == "y") {
                println("Let's play again!\n")
                break
            } else {
                println("Invalid input. Please enter 'y' or 'n'.")
            }
        } while (true)
    }
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam.random()

fun getUserChoice(optionsParam: Array<String>): String {
    var userChoice: String
    do {
        print("Enter your choice: ")
        userChoice = readln().lowercase()
    } while (!optionsParam.contains(userChoice))
    return userChoice
}