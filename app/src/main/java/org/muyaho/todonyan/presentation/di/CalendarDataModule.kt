package org.muyaho.todonyan.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.muyaho.todonyan.data.repository.calendar.datasource.CalendarLocalDataSource
import org.muyaho.todonyan.data.repository.calendar.datasourceimpl.CalendarLocalDataSourceImpl
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CalendarDataModule {
    @Singleton
    @Provides
    fun provideCalendarInstance(): Calendar {
        val instance = Calendar.getInstance()
        return instance
    }

    @Singleton
    @Provides
    fun provideCalendarLocalDataSource(calendar: Calendar): CalendarLocalDataSource {
        return CalendarLocalDataSourceImpl(calendar)
    }
}