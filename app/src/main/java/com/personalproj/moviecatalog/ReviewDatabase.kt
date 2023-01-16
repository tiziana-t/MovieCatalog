package com.personalproj.moviecatalog

import com.raizlabs.android.dbflow.annotation.Database

@Database(name = ReviewDatabase.NAME, version = ReviewDatabase.VERSION, generatedClassSeparator = "_")
object ReviewDatabase {
    const val NAME: String = "ReviewDB"
    const val VERSION: Int = 1
}
