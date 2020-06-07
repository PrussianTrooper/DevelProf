package com.example.practicearchi

import com.example.practicearchi.search.SearchResult
import io.reactivex.Observable

class RoomDataBaseImplementation : DataSource<List<SearchResult>> {

    override fun getData(word: String): Observable<List<AppState>> {
        TODO("not implemented") // To change body of created functions use File
        // | Settings | File Templates.
    }
}
