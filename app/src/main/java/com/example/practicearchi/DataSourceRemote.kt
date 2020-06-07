package com.example.practicearchi

import io.reactivex.Observable

// Для получения внешних данных мы будем использовать Retrofit
class DataSourceRemote(private val remoteProvider: RetrofitImplementation = RetrofitImplementation()) :
    DataSource<List<AppState>> {

    override fun getData(word: String): Observable<List<AppState>> = remoteProvider.getData(word)
}
// Для локальных данных используется Room
class DataSourceLocal(private val remoteProvider: RoomDataBaseImplementation = RoomDataBaseImplementation()) :
    DataSource<List<AppState>> {

    override fun getData(word: String): Observable<List<AppState>> = remoteProvider.getData(word)
}
