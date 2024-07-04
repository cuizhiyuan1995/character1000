package com.classic.character1000.di

import com.classic.character1000.network.ChineseService
import com.classic.character1000.network.EnglishService
import com.classic.character1000.network.KoreanService
import com.classic.character1000.network.LoggingInterceptor
import com.classic.character1000.network.SimplifiedService
import com.classic.character1000.network.StrokeService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
object NetworkingModule {

    @Provides
    @Named("Moedict")
    fun providesRetrofit():Retrofit{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://www.moedict.tw/uni/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesChineseService(@Named("Moedict") retrofit:Retrofit):ChineseService{
        return retrofit.create(ChineseService::class.java)
    }

    @Provides
    @Named("Simply")
    fun providesSimplifiedRetrofit():Retrofit{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://api.zhconvert.org")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesSimplifiedService(@Named("Simply")retrofit:Retrofit):SimplifiedService{
        return retrofit.create(SimplifiedService::class.java)
    }


    @Provides
    fun providesLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor()
    }

    @Provides
    fun providesOkHttpClient(loggingInterceptor: LoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Named("Eng")
    fun providesEngRetrofit():Retrofit{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://dict.youdao.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesEnglishService(@Named("Eng")retrofit:Retrofit):EnglishService{
        return retrofit.create(EnglishService::class.java)
    }

    @Provides
    @Named("Kor")
    fun providesKorRetrofit():Retrofit{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://dict.youdao.com")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesKoreanService(@Named("Kor")retrofit:Retrofit):KoreanService{
        return retrofit.create(KoreanService::class.java)
    }

    @Provides
    @Named("Stroke")
    fun providesStrokeRetrofit():Retrofit{
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://cdn.jsdelivr.net/npm/hanzi-writer-data@2.0/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Provides
    fun providesStrokeService(@Named("Stroke")retrofit:Retrofit):StrokeService{
        return retrofit.create(StrokeService::class.java)
    }
}

//https://www.youtube.com/watch?v=23Gj0z88H2U