import org.junit.Test

class QueueByHeightReconstructionTest {


    @Test
    fun reconstructQueue() {

        val array = arrayOf(
                Entry(7, 0),
                Entry(4, 4),
                Entry(7, 1),
                Entry(5, 0),
                Entry(6, 1),
                Entry(5, 2)
        )

        val result = reconstructQueueByHeight(array)

        result.forEach { print(it) }
    }


    private data class Entry(val height: Int, val personsInFront: Int)

    private fun reconstructQueueByHeight(entries: Array<Entry>): Array<Entry> {
        val sortedArray = sortArray(entries, true)
        val result = mutableListOf<Entry>()
        result.addAll(sortedArray)
        result.clear()

        for (entry in sortedArray) {
            result.add(entry.personsInFront, entry)
        }

        return result.toTypedArray()
    }

    private fun sortArray(entries: Array<Entry>, isInverted: Boolean): Array<Entry> {
        return quickSort(entries, 0, entries.size - 1, isInverted)
    }

    private fun quickSort(entries: Array<Entry>, start: Int, end: Int, isInverted: Boolean): Array<Entry> {
        if (end - start < 1) return entries

        val pivot = divide(entries, start, end, isInverted)
        quickSort(entries, 0, pivot, isInverted)
        quickSort(entries, pivot + 1, end, isInverted)

        return entries

    }

    private fun divide(array: Array<Entry>, start: Int, end: Int, isInverted: Boolean): Int {
        var pivot = start
        val pivotEntry = array[pivot]
        val pivotValue = pivotEntry.height

        var currentPosition = start
        for (i in start..end) {
            if (array[i].height < pivotValue && isInverted.not() ||
                    array[i].height > pivotValue && isInverted) {
                var swapEntry = array[currentPosition]
                array[currentPosition] = array[i]
                array[i] = swapEntry
                ++currentPosition
            }
        }

        return currentPosition
    }

}