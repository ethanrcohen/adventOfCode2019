package src;

import java.io.File

class Problem1 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val modules = File("src/inputFiles/problem1.txt").readLines()
                    .map(String::toInt);

            val part1Answer = modules.map(::fuelRequired).sum();

            println("Part 1 Answer: $part1Answer");

            val part2Answer = modules.map(::fuelRequiredIncludingFuel).sum();

            println("Part 2 Answer: $part2Answer");
        }

        private fun fuelRequired(mass: Int): Int {
            return (mass / 3) - 2;
        }

        private fun fuelRequiredIncludingFuel(mass: Int): Int {
            val fuelRequired = fuelRequired(mass);

            return if (fuelRequired <= 0) 0
                else fuelRequired + fuelRequiredIncludingFuel(fuelRequired);
        }
    }
}



