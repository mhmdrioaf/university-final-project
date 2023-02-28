package com.gudmal.storagemanagement.model.service

interface LogService {
    fun logNonFatalCrash(throwable: Throwable)
}