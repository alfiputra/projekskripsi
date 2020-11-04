package ap.mobile.formtes.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Data::class],
    version = 1,
    exportSchema = false
)

abstract class DataDB: RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object{

        @Volatile
        private var instance: DataDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized(LOCK){
            instance?: buildDatabase(context).also{
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            DataDB::class.java,
            "data_db"
        ).build()

//        @Volatile
//        private var INSTANCE: DataDB? = null
//
//        fun getDatabase(context: Context): DataDB {
//            // if the INSTANCE is not null, then return it,
//            // if it is, then create the database
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    DataDB::class.java,
//                    "data_db"
//                ).build()
//                INSTANCE = instance
//                // return instance
//                instance
//            }
//        }
    }
}
