package com.base.app.network

import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonToken
import okhttp3.ResponseBody
import retrofit2.Converter

class CustomGsonResponseBodyConverter<T> : Converter<ResponseBody, T> {


    private val gson: Gson
    private val adapter: TypeAdapter<T>

    constructor(gson: Gson, adapter: TypeAdapter<T>) {
        this.gson = gson
        this.adapter = adapter
    }


    override fun convert(value: ResponseBody?): T? {
        val jsonReader = gson.newJsonReader(value?.charStream())
        try {
            val result = adapter.read(jsonReader)
            if (jsonReader.peek() != JsonToken.END_DOCUMENT) {
                throw JsonIOException("JSON document was not fully consumed.")
            }
//            if(result is BaseResponse<*>){
//                if(result.state!=Constant.RESPONSE_SUCCESS){
//                    throw ResponseErrorException(result.code,result.message)
//                }
//            }
//            if(result is BaseListResponse<*>){
//                if(result.state!=Constant.RESPONSE_SUCCESS){
//                    throw ResponseErrorException(result.code,result.message)
//                }
//            }
            return result
        } finally {
            value?.close()
        }

    }


}