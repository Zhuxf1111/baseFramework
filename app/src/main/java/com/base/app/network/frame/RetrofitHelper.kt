package com.base.app.network.frame

import com.base.app.androidapplication.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by HASEE on 2018/4/8.
 */
class RetrofitHelper {

    companion object {
        var helper: RetrofitHelper? = null

        fun getInstance(): RetrofitHelper {
            helper?.let {
                return it
            }
            helper = RetrofitHelper()
            return helper!!
        }
    }

    private constructor()

    private val client = initClient()

    val retrofit = initRetrofit()

    private fun initClient(): OkHttpClient {
        val debugInterceptor = HttpLoggingInterceptor()
        debugInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .addInterceptor(NetWorkInterceptor())
                .connectTimeout(1, TimeUnit.MINUTES)
        if (BuildConfig.DEBUG) {
            client.addInterceptor(debugInterceptor)
        }
        return client.build()
    }

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BuildConfig.API_URL)
                .build()
    }

    inner class NetWorkInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = Request.Builder()
            //TODO 添加token等内容
            return chain.proceed(request.build())
        }

    }


}