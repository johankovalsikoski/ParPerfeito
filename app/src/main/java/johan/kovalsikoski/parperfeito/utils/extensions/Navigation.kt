package johan.kovalsikoski.parperfeito.utils.extensions

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import johan.kovalsikoski.parperfeito.R

/** Use to clear navigation back stack */
fun Activity.reconfigureBottomNavigation(directionId: Int) {
    val navController = findNavController(R.id.host_fragment)
    navController.takeUnless { it.currentDestination?.id == directionId }?.apply {
        val navGraph = graph
        navGraph.startDestination = directionId
        navController.graph = navGraph
        navigate(directionId)
    }
}
/** Use to navigate avoiding double-tap crashes */
fun Fragment.navigateTo(directions: NavDirections, currentScreenLabel: String) {
    val navController = findNavController()
    navController.currentDestination?.takeIf { it.label == currentScreenLabel }
        ?: return navController.navigate(directions)
}

/** Use to pop back stack or navigate back to a specific point on the back stack */
fun Fragment.navigateBack(destinationId: Int?) {
    val navController = findNavController()
    destinationId?.let { destination ->
        val navigationStatus = navController.popBackStack(destination, false)
        if (navigationStatus.not()) {
            navController.popBackStack()
        }
    } ?: navController.popBackStack()
}
