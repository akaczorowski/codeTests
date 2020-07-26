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
    }


    data class Entry(val height: Int, val personsInFront: Int)

    fun reconstructQueueByHeight(entries: Array<Entry>) {
        val sortedArray = sortArray(entries)
        val result = mutableListOf

        for (entry in sortedArray) {


        }


    }

    private fun sortArray(entries: Array<Entry>): Array<Entry> {

    }

}