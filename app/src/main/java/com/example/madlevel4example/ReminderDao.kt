package com.example.madlevel4example

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.madlevel2example.Reminder

interface ReminderDao {
    @Query("SELECT * FROM remindertable")
    fun getAllReminders():List<Reminder>
    @Insert
    fun insertReminder(reminder: Reminder)
    @Delete
    fun deleteReminder(reminder: Reminder)
    @Update
    fun updateReminder(reminder: Reminder)
}