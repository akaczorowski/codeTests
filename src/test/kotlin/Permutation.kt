import org.junit.Test

class Permutation {


    @Test
    fun testPermute() {
        val array = arrayOf(1, 2, 3, 4, 5, 6)

        val permutations = Permutation().permute(array)

        println("Number of found permutations: ${permutations.size}")
        for (entry in permutations) {
            entry.iterator().forEach { print(it) }
            println()
        }

    }

    class Permutation {
        private val result = ArrayList<Array<Int>>()

        fun permute(array: Array<Int>): Array<Array<Int>> {
            result.clear()
            permuteHelper(array, 0, array.size - 1)

            return result.toTypedArray()
        }

        private fun permuteHelper(array: Array<Int>, start: Int, end: Int) {
            if (start == end) {
                result.add(array)
                return
            }
            for (index in start..end) {
                val arrayCopy = array.copyOf()
                arrayCopy[start] = array[index]
                arrayCopy[index] = array[start]
                permuteHelper(arrayCopy, start + 1, end)
            }
        }

    }
}