package com.example.noteapp.util

import androidx.room.TypeConverter
import java.util.UUID

class UuidConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID): String = uuid.toString()


    @TypeConverter
    fun toUUID(uuidString: String?): UUID? = UUID.fromString(uuidString)
}