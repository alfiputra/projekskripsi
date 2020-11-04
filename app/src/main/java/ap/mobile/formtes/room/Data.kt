package ap.mobile.formtes.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Data(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val data: String,
    val date: String
)