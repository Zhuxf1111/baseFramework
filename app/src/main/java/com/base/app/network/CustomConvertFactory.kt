package com.base.app.network

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class CustomConvertFactory : Converter.Factory {

    companion object {
        fun create(): CustomConvertFactory {
            return CustomConvertFactory()
        }
    }

    private val gson = Gson()

    private constructor() : super()

    override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
//        var newGson = GsonBuilder()
//                .setFieldNamingStrategy { it->
//                    if(it.name=="data"){
//                        return@setFieldNamingStrategy ClassKeyMapper.getKey(TypeToken.get(type))
//                    }
//                    return@setFieldNamingStrategy it.name
//                }
//                .setLenient().create()
//        val adapter = newGson.getAdapter(TypeToken.get(type))
        val adapter = gson.getAdapter(TypeToken.get(type))
        return CustomGsonResponseBodyConverter(gson, adapter)
    }

    private inline fun <reified T : Any> token(type: Type): TypeToken<T> =
            TypeToken.getParameterized(T::class.java, type) as TypeToken<T>

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<out Annotation>?, methodAnnotations: Array<out Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        val adapter = gson.getAdapter(TypeToken.get(type))
        return CustomGsonRequestBodyConverter(gson, adapter)
    }
}