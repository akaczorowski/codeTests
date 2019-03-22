import org.junit.Test
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.ArrayList

class DateTimeTests {

    @Test
    fun test2() {

        val dates = arrayOf("01 Mar 2017", "03 Feb 2017", "15 Jan 1988")

        val result = sortDates(dates)
        result.forEach {
            println(it)
        }
    }

    fun sortDates(dates: Array<String>): Array<String> {
        val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy")
        val datesList = ArrayList<LocalDate>()
        dates.forEach {
            datesList.add(LocalDate.parse(it, formatter))
        }
        datesList.sort()

//        val results = arrayOfNulls<String>(datesList.size)
        return datesList.map { it.format(formatter) }.toTypedArray()
    }


}