package com.personalproj.moviecatalog

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table

@Table(database = ReviewDatabase::class)
class Review(@PrimaryKey var id: Int = 0, @Column var movieName: String? = null, @Column var reviewText: String? = null){
}