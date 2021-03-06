package hu.unideb.shoppinglist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import hu.unideb.shoppinglist.database.dao.ProductDao
import hu.unideb.shoppinglist.database.model.Product

@Database(entities = [Product::class], version = 14, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val productDatabaseDao: ProductDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "shopping_list_database"
                    )
                        .fallbackToDestructiveMigration()

                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}