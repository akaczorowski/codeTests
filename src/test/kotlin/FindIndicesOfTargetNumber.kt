import org.junit.Test

class FindIndicesOfTargetNumber {


    @Test
    fun testFindIndices(): Unit {
        val testInput = arrayOf(1, 2, 5, 7, 10, 10, 11, 12, 12, 21, 34, 35, 35, 35, 35, 35, 36, 90, 91)

        val resultFirst = findIndices(testInput, 36)
        assert(resultFirst.first == 16)
        assert(resultFirst.second == 16)
        println(resultFirst)

        val resultSecond = findIndices(testInput, 35)
        println(resultSecond)
        assert(resultSecond.first == 11)
        assert(resultSecond.second == 15)
    }

    private fun findIndices(array: Array<Int>, target: Int): Pair<Int, Int> {
        val firstIndex = findIndicesHelper(array, target, SearchMode.FIRST_OCCURRENCE)
        val lastIndex = findIndicesHelper(array, target, SearchMode.LAST_OCCURRENCE)

        return Pair(firstIndex, lastIndex)
    }


    private fun findIndicesHelper(array: Array<Int>, target: Int, searchMode: SearchMode): Int {
        var begin = 0
        var end = array.size - 1
        while (begin <= end) {
            var pivot = (begin + end) / 2
            when (searchMode) {
                SearchMode.FIRST_OCCURRENCE -> {
                    if ((pivot == 0 || target > array[pivot - 1]) && target == array[pivot]) {
                        return pivot
                    } else if (target > array[pivot]) {
                        begin = pivot + 1
                    } else {
                        end = pivot - 1
                    }
                }
                SearchMode.LAST_OCCURRENCE -> {
                    if ((pivot == array.size - 1 || target < array[pivot + 1]) && target == array[pivot]) {
                        return pivot
                    } else if (target < array[pivot]) {
                        end = pivot - 1
                    } else {
                        begin = pivot + 1
                    }
                }
            }
        }
        return -1
    }

    enum class SearchMode {
        FIRST_OCCURRENCE, LAST_OCCURRENCE
    }

}