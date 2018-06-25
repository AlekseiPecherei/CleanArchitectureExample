package com.lostheep.cleanarchitectureexample.data.repositories

import com.lostheep.cleanarchitectureexample.domain.global.models.Album
import com.lostheep.cleanarchitectureexample.domain.global.models.Artist
import com.lostheep.cleanarchitectureexample.domain.global.repositories.ContentRepository
import io.reactivex.Single

/**
 * CleanArchitectureExample
 * Created by lostsheep on 25.06.18:14:10.
 */
class ContentRepositoryImpl : ContentRepository {
    //get any content from some service such as db, filesystem or network
//    private val contentApiService = ServiceFactory.getContentApiService()

    fun getAlbums(): Single<List<Album>> {
//        contentApiService.get....
        val data = ArrayList<Album>()
        data.add(Album(1, "title 1"))
        data.add(Album(2, "title 2"))
        data.add(Album(3, "title 3"))
        data.add(Album(4, "title 4"))
        data.add(Album(5, "title 5"))
        data.add(Album(6, "title 6"))

        return Single.just(data)
    }

    fun getAlbumById(id: Long): Single<Album> {
//        contentApiService.get....
        val data = Album(id, "title $id")
        return Single.just(data)
    }

    fun getArtists(): Single<List<Artist>> {
//        contentApiService.get....
        val data = ArrayList<Artist>()
        data.add(Artist(1, "title 1"))
        data.add(Artist(2, "title 2"))
        data.add(Artist(3, "title 3"))
        data.add(Artist(4, "title 4"))
        data.add(Artist(5, "title 5"))
        data.add(Artist(6, "title 6"))

        return Single.just(data)
    }

    fun getArtistById(id: Long): Single<Artist> {
//        contentApiService.get....
        val data = Artist(id, "title $id")
        return Single.just(data)
    }
}