package com.lostheep.cleanarchitectureexample.presentation.ui.artist

import android.content.Intent
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.lostheep.cleanarchitectureexample.R
import com.lostheep.cleanarchitectureexample.presentation.mvp.artist.ArtistPresenter
import com.lostheep.cleanarchitectureexample.presentation.mvp.artist.ArtistView
import com.lostheep.cleanarchitectureexample.presentation.mvp.global.mapping.uimodels.ArtistDataUIModel
import com.lostheep.cleanarchitectureexample.presentation.ui.global.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_artist.*

class ArtistActivity : BaseMvpActivity(), ArtistView {

    @InjectPresenter
    lateinit var presenter: ArtistPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        button.setOnClickListener{ presenter.back() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun method(model: ArtistDataUIModel) {
        text.text = model.text
    }
}
