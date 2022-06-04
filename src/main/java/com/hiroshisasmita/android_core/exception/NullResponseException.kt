package com.hiroshisasmita.android_core.exception

/**
 * When retrofit success data of handler implementation return null
 * No need message
 * Can be replaced with data using ResultState<T>.replaceIfNull()
 * Action/Message must be determined in UI layer
 */
class NullResponseException: Exception()