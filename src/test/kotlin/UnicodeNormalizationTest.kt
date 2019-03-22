import org.junit.Test
import java.text.Normalizer
import java.util.regex.Pattern
import java.util.Locale



class UnicodeNormalizationTest {

    /**
     *
     * https://nukep.github.io/progblog/2015/02/26/some-gotchas-about-unicode-that-every-programmer-should-know.html
     * https://www.regular-expressions.info/unicode.html
     * http://unicode.org/faq/normalization.html
     *
     */

    @Test
    fun normalization1() {

        val a = "\uD835\uDC14\uD835\uDC27\uD835\uDC22\uD835\uDC1C\uD835\uDC28\uD835\uDC1D\uD835\uDC1E \uD835\uDDC5 \uD835\uDDC1\uD835\uDDBE\uD835\uDDCB\uD835\uDDBD \uD835\uDD4C \uD835\uDDC5\uD835\uDDC2\uD835\uDDC4\uD835\uDDBE \uD835\uDC61\uD835\uDC66\uD835\uDC5D\uD835\uDC52\uD835\uDC53\uD835\uDC4E\uD835\uDC50\uD835\uDC52\uD835\uDC60 \uD835\uDDCC\uD835\uDDC8 \uD835\uDDD0\uD835\uDDBE \uD835\uDDC9\uD835\uDDCE\uD835\uDDCD \uD835\uDDCC\uD835\uDDC8\uD835\uDDC6\uD835\uDDBE \uD835\uDE8C\uD835\uDE98\uD835\uDE8D\uD835\uDE8E\uD835\uDE99\uD835\uDE98\uD835\uDE92\uD835\uDE97\uD835\uDE9D\uD835\uDE9C"
        val b = "Jörg"
        val a1 = Normalizer.normalize(a, Normalizer.Form.NFC)
        println(a1)
        val a2 = Normalizer.normalize(a, Normalizer.Form.NFD)
        println(a2)
        val a3 = Normalizer.normalize(a, Normalizer.Form.NFKC)
        println(a3)
        val a4 = Normalizer.normalize(a, Normalizer.Form.NFKD)
        println(a4)

    }

    @Test
    fun normalizationForTextSearch() {

        val PATTERN_DIACRITICS = Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
        val PATTERN_NON_LETTER_DIGIT_TO_SPACES = Pattern.compile("[^\\p{L}\\p{Nd}]")

        var result = java.text.Normalizer.normalize("Arek' 6", java.text.Normalizer.Form.NFD)
        result = PATTERN_DIACRITICS.matcher(result).replaceAll("")
        result = PATTERN_NON_LETTER_DIGIT_TO_SPACES.matcher(result).replaceAll(" ")

        println(result.toLowerCase(Locale.ROOT))
    }
}