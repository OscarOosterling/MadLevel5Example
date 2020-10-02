package com.example.madlevel4example

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.madlevel2example.Reminder

@Database(entities = [Reminder::class],version = 1,exportSchema = false)
abstract class ReminderRoomDatabase :RoomDatabase(){

    abstract fun reminderDao():ReminderDao

    companion object{
        private const val DATABASE_NAME = "REMINDER_DATABASE"

        @Volatile
        private var reminderRoomDatabaseInstace:ReminderRoomDatabase? = null

        fun getDatabase(context:Context):ReminderRoomDatabase?{
            if(reminderRoomDatabaseInstace==null){
            synchronized(ReminderRoomDatabase::class.java){
                if(reminderRoomDatabaseInstace == null){
                    reminderRoomDatabaseInstace = Room.databaseBuilder(
                        context.applicationContext,ReminderRoomDatabase::class.java,DATABASE_NAME
                    ).build()
                }
            }
            }
            return reminderRoomDatabaseInstace
        }
    }
}