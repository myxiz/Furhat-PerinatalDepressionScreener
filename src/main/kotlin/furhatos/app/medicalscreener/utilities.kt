package furhatos.app.medicalscreener

/**
 * Construct a conjugated list from iterable. The conjugated list has all items separated by the `separator` and the last
 * item is separated by the `conjugate`. E.g.:
 *      listOf("Lions", "Tigers", "Bears").toConjugatedList() == "Lions, Tigers & Bears"
 */
public fun <T> Iterable<T>.toConjugatedList(separator: CharSequence = ", ", conjugate: CharSequence = " & ") =
   listOf(take(count() - 1).joinToString(separator), last())
           .filter {it != ""}
           .joinToString(conjugate)