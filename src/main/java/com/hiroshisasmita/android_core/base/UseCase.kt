package com.hiroshisasmita.android_core.base

abstract class UseCase<Q : UseCase.RequestValues, P : UseCase.ResponseValues> {

    abstract suspend fun execute(requestValues: Q): P

    /**
     * Data passed to a request.
     */
    interface RequestValues

    /**
     * Data received from a request.
     */
    interface ResponseValues
}