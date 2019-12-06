package src

import java.io.File

data class Instruction(val opcode: Int, val xInd: Int, val yInd: Int, val placement: Int);

class Problem2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val values = File("src/inputFiles/problem2.txt")
                    .readText()
                    .split(",")
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toIntArray();

            var part1Values = values.clone();
            part1Values[1] = 12;
            part1Values[2] = 2;

            val part1Answer = runComputer(part1Values);
            println("Part 1 answer: $part1Answer");

            for (noun in 1..99) {
                for (verb in 1..99) {
                    var mutableValues = values.clone();
                    mutableValues[1] = noun;
                    mutableValues[2] = verb;

                    val computerOutput = runComputer(mutableValues);
                    if (computerOutput == 19690720) {
                        val answer = 100 * noun + verb;
                        println("Part 2 answer: $answer")
                    }
                }
            }
        }

        private fun runComputer(mutableValues: IntArray): Int {
            var index = 0;
            while (index < mutableValues.size - 3) {
                val opcode = mutableValues[index++];

                if (opcode == 99) break;
                else if (opcode != 1 && opcode != 2) {
                    println("Not allowed!!");
                }

                val instruction = Instruction(
                        opcode,
                        mutableValues[index++],
                        mutableValues[index++],
                        mutableValues[index++]);

                val x = mutableValues[instruction.xInd];
                val y = mutableValues[instruction.yInd];

                val z = if (instruction.opcode == 1) x + y else x * y
                mutableValues[instruction.placement] = z;
            }

            return mutableValues[0];
        }
    }
}