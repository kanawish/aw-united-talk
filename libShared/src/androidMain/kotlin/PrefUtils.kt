import android.app.Application
import android.content.Context
import android.content.SharedPreferences

private const val PREF_FILE = "com.kanastruk.android.prefs"

fun Context.appSharedPrefs(): SharedPreferences {
    return getSharedPreferences(PREF_FILE, Application.MODE_PRIVATE)
}

fun SharedPreferences.setStringKey(key: String, value: String) {
    with(edit()) {
        putString(key, value)
        commit()
    }
}

fun SharedPreferences.clearStringKey(key: String) {
    with(edit()) {
        remove(key)
        commit()
    }
}
