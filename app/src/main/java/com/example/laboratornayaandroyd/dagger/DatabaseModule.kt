package com.example.laboratornayaandroyd.dagger

import android.content.Context
import androidx.room.Room
import com.example.laboratornayaandroyd.models.Database
import com.example.laboratornayaandroyd.models.dao.BalanceDao
import com.example.laboratornayaandroyd.models.dao.TariffDao
import com.example.laboratornayaandroyd.models.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Database.DATABASE_NAME
        ).build()
    }

}