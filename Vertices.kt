import kotlin.math.pow
import kotlin.math.sqrt

class Triangle(vertices: Array<Array<Double>>) {
    val exist = checkTriangleExistence(vertices)

    private fun checkTriangleExistence(vertices: Array<Array<Double>>): Boolean {
        val (a, b, c) = getSidesLength(vertices)

        return a + b > c && a + c > b && b + c > a
    }

    private fun getSidesLength(coordinates: Array<Array<Double>>): Array<Double> {
        val (x1, y1) = coordinates[0]
        val (x2, y2) = coordinates[1]
        val (x3, y3) = coordinates[2]

        val a = sqrt((x2 - x1).pow(2) + (y2 - y1).pow(2))
        val b = sqrt((x3 - x2).pow(2) + (y3 - y2).pow(2))
        val c = sqrt((x1 - x3).pow(2) + (y1 - y3).pow(2))

        return arrayOf(a, b, c)
    }

    fun checkIfPointInTriangle(point: Point, coordinates: Array<Array<Double>>): Boolean {
        val (x1, y1) = coordinates[0]
        val (x2, y2) = coordinates[1]
        val (x3, y3) = coordinates[2]

        val a = (x1 - point.x) * (y2 - y1) - (x2 - x1) * (y1 - point.y)
        val b = (x2 - point.x) * (y3 - y2) - (x3 - x2) * (y2 - point.y)
        val c = (x3 - point.x) * (y1 - y3) - (x1 - x3) * (y3 - point.y)

        return (a >= 0 && b >= 0 && c >= 0) || (a <= 0 && b <= 0 && c <= 0)
    }
}


class Point(val x: Double, val y: Double) {
    init {
        if (!checkPointExistence(x, y)) {
            throw IllegalArgumentException("The point does not exist.")
        }
    }

    private fun checkPointExistence(x: Double, y: Double): Boolean {
        return x.isFinite() && y.isFinite()
    }
}


fun main() {
    println("Input coordinates:")
    val coordinates = Array(3) { Array(2) {0.0} }

    for (i in 1..3) {
        println("Enter `x y` coordinates of the $i vertex:")
        try {
            coordinates[i - 1] = readln().split(" ").map { it.toDouble() }.toTypedArray()
        }
        catch (e: Exception) {
            println("Invalid input. Please enter two numbers separated by a space.")
            return
        }
    }

    val triangle = Triangle(coordinates)

    if (!triangle.exist) {
        println("The triangle does not exist.")
        return
    }

    println("Input coordinates of the point:")
    try {
        val (x, y) = readln().split(" ").map { it.toDouble() }.toTypedArray()

        val point = Point(x, y)

        if (triangle.checkIfPointInTriangle(point, coordinates)) {
            println("The point is inside the triangle.")
        } else {
            println("The point is outside the triangle.")
        }
    }
    catch (e: Exception) {
        println("Invalid input. Please enter two numbers separated by a space.")
        return
    }
}
