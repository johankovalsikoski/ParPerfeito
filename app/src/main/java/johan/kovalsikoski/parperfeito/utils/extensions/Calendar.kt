package johan.kovalsikoski.parperfeito.utils.extensions

import java.util.*
import java.util.Calendar.*

fun Calendar.getTimeNow(): Date {
    val now = getInstance()
    return apply {
        setTime(now.get(HOUR_OF_DAY), now.get(MINUTE), now.get(SECOND))
    }.time
}

fun Calendar.setHours(hours: Int): Calendar {
    return apply {
        set(get(YEAR), get(MONTH), get(DATE), hours, get(MINUTE), get(SECOND))
    }
}

fun Calendar.setMinutes(minutes: Int): Calendar {
    return apply {
        set(get(YEAR), get(MONTH), get(DATE), get(HOUR_OF_DAY), minutes, get(SECOND))
    }
}

fun Calendar.setSeconds(seconds: Int): Calendar {
    return apply {
        set(get(YEAR), get(MONTH), get(DATE), get(HOUR_OF_DAY), get(MINUTE), seconds)
    }
}

fun Calendar.setTime(hours: Int, minutes: Int, seconds: Int): Calendar {
    return apply {
        setHours(hours)
        setMinutes(minutes)
        setSeconds(seconds)
    }
}

fun Calendar.compareTimeTo(other: Calendar): Boolean {
    return get(HOUR_OF_DAY) == other.get(HOUR_OF_DAY) &&
            get(MINUTE) == other.get(MINUTE) &&
            get(SECOND) == other.get(SECOND)
}
