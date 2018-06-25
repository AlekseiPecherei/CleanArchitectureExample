package com.lostheep.cleanarchitectureexample.domain.global.models

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonDeserialize(using = ArtistDeserializer::class)
data class Artist(
        val id: Long,
        val title: String
)