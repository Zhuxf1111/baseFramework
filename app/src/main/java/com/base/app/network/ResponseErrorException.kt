package com.base.app.network

class ResponseErrorException : Throwable ,CustomResponseException{

    constructor(code : String? ,message: String?) : super(message){
        this.code = code
    }

    var code : String?
}