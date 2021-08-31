package org.muyaho.todonyan.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import org.muyaho.todonyan.domain.repository.CalendarRepository
import org.muyaho.todonyan.domain.usecase.GetCalendarUseCase

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {
    @Provides
    @ViewModelScoped
    fun provideGetCalendarUseCase(
        calendarRepository: CalendarRepository
    ): GetCalendarUseCase {
        return GetCalendarUseCase(calendarRepository)
    }
}