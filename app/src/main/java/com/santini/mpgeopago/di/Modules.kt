package com.santini.mpgeopago.di
import org.koin.android.viewmodel.dsl.viewModel
import com.santini.mpgeopago.network.model.responseHadler.ResponseHandler
import com.santini.mpgeopago.network.ModInterceptor
import com.santini.mpgeopago.network.PaymentInterface
import com.santini.mpgeopago.repository.Repository
import com.santini.mpgeopago.ui.MainViewModel
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
       viewModel { MainViewModel(get()) }
}

val MercadoPagoModule = module {
    single(named("MercadoPago")) {
        provideRetrofit(
            get(),
            "https://api.mercadopago.com/v1/"
        )

    }
    single { get<Retrofit>(named("MercadoPago")).create(PaymentInterface::class.java) }
    single { provideOkHttpClient(get()) }
    single { ResponseHandler() }
    single { Repository(get(), get()) }
    single { ModInterceptor() }
}

fun provideRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

fun provideOkHttpClient(
    interceptor: ModInterceptor): OkHttpClient {
    val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
    okHttpClientBuilder.addInterceptor(interceptor)
    return okHttpClientBuilder.build()
}