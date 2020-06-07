package com.example.practicearchi

import io.reactivex.Observable

class RepositoryImplementation(private val dataSource: DataSource<List<AppState>>) :
    Repository<List<AppState>> {
    // Репозиторий возвращает данные, используя dataSource (локальный или
    // внешний)
    override fun getData(word: String): Observable<List<AppState>> {
        return dataSource.getData(word)
    }
}
