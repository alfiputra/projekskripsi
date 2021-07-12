package ap.mobile.formtes.room

import androidx.room.*

@Dao
interface DataDao {

    @Insert
    suspend fun insertData(data: Data)

    @Delete
    suspend fun deleteData(data: Data)

    @Query ("SELECT * FROM data ORDER BY id DESC ")
    suspend fun getData(): List<Data>

//    @Query ("SELECT * FROM data ORDER BY result DESC LIMIT 1")
//    suspend fun getLastData(): List<Data>
}