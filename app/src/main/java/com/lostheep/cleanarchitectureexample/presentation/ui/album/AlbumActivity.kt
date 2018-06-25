package com.lostheep.cleanarchitectureexample.presentation.ui.album

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.lostheep.cleanarchitectureexample.R
import com.lostheep.cleanarchitectureexample.presentation.mvp.album.AlbumPresenter
import com.lostheep.cleanarchitectureexample.presentation.mvp.album.AlbumView
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.uimodels.AlbumDataUIModel
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.RouterConstants
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.routing.navigator.BackNavigator
import com.lostheep.cleanarchitectureexample.presentation.ui.artist.ArtistActivity
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_album.*
import ru.terrakok.cicerone.Navigator

class AlbumActivity : BaseMvpActivity(), AlbumView {

    @InjectPresenter
    lateinit var presenter: AlbumPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        button.setOnClickListener{ presenter.open() }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun method(model: AlbumDataUIModel) {
        text.text = model.text
    }

    override fun navigator(): Navigator? {
        return BackNavigator(this)
                .addForward(RouterConstants.ARTIST, ArtistActivity::class.java)
    }
}