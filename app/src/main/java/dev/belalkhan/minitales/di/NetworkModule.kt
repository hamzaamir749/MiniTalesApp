package dev.belalkhan.minitales.di

import androidx.core.os.BuildCompat
import com.belalkhan.minitales.network.MiniTalesHttpClientBuilder
import com.belalkhan.minitales.network.RequestHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.belalkhan.minitales.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.http.URLProtocol
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideMiniTalesHttpClient(): HttpClient =
        MiniTalesHttpClientBuilder().protocol(URLProtocol.HTTP).port(8080).host(BuildConfig.MINI_TALES_HOST).build()

    @Provides
    fun provideRequestHandler(client: HttpClient) = RequestHandler(client)
}