package ap.mobile.formtes.room

import androidx.room.*

@Dao
interface DataDao {

    @Insert
    suspend fun insertData(data: Data)

    @Delete
    suspend fun deleteData(data: Data)

    @Query ("SELECT * FROM data")
    suspend fun getData(): List<Data>
}