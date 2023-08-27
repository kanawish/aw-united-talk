import com.kanastruk.js.ext.firebase.FirebaseApp
import com.kanastruk.js.ext.firebase.initializeApp
import com.kanastruk.utils.suspendFetch

/**
 *
 */
suspend fun initializeApp():FirebaseApp = initializeApp(
    // Running hosted, or with local config?
    suspendFetch("/__/firebase/init.json") ?: suspendFetch("./fbConfig.json")
    ?: throw RuntimeException("I need my config.")
)