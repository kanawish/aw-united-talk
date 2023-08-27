@file:JsModule("firebase/app")
@file:JsNonModule

package com.kanastruk.js.ext.firebase

import kotlin.js.Json

external class FirebaseApp

external fun initializeApp(config: Json): FirebaseApp
