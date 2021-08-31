package org.muyaho.todonyan.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.muyaho.todonyan.data.repository.calendar.CalendarRepositoryImpl
import org.muyaho.todonyan.data.repository.calendar.datasource.CalendarLocalDataSource
import org.muyaho.todonyan.domain.repository.CalendarRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCalendarRepository(
        calendarLocalDataSource: CalendarLocalDataSource
    ): CalendarRepository {
        return CalendarRepositoryImpl(calendarLocalDataSource)
    }
}