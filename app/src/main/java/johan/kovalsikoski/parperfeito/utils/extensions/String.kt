package johan.kovalsikoski.parperfeito.utils.extensions

fun String.capitalizeWords() = split(" ").joinToString(" ") { it.capitalize() }
