package com.mlhysrszn.ibuy.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mlhysrszn.ibuy.data.local.entity.ProductEntity
import com.mlhysrszn.ibuy.utils.Constants.DB_NAME

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productsDao(): ProductsDao

    companion object {
        private var instance: AppDatabase? = null

        fun getFavoritesDatabase(context: Context): AppDatabase? {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    ).allowMainThreadQueries()
                        .build()
            }
            return instance
        }
    }
}