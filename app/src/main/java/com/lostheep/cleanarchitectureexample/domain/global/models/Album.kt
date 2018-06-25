package com.lostheep.cleanarchitectureexample.domain.global.models

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using = AlbumDeserializer::class)
data class Album(
        val id: Long,
        val title: String
)
