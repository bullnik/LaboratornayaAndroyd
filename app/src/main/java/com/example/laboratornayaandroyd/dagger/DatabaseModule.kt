package com.example.laboratornayaandroyd.dagger

import androidx.room.Room
import com.example.laboratornayaandroyd.models.Database
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @Provides
    fun provideDatabase(): Database {
        return Room.databaseBuilder(
            Database.context,
            Database::class.java,
            Database.DATABASE_NAME
        ).build()
    }

}