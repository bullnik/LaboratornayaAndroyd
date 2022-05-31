package com.example.laboratornayaandroyd.models

import android.app.Application
import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.laboratornayaandroyd.models.dao.BalanceDao
import com.example.laboratornayaandroyd.models.dao.JijaDao
import com.example.laboratornayaandroyd.models.dao.TariffDao
import com.example.laboratornayaandroyd.models.dao.UserDao

@Database(
    entities = [
        Tariff::class,
        Balance::class,
        User::class,
        Jija::class,
    ],
    version = 2
)
abstract class Database: RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getTariffDao(): TariffDao
    abstract fun getBalanceDao(): BalanceDao
    abstract fun getJijaDao(): JijaDao

    companion object {
        @JvmStatic
        lateinit var context: Context

        const val DATABASE_NAME = "jija_database"
    }
}

object Migration: Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE jija (" +
                    "id text not null, " +
                    "name text not null, " +
                    "PRIMARY KEY(`id`)" +
                    ")")
    }
}