package com.sercan.yigit.pokedexapp

import android.content.Context
import com.sercan.yigit.common.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    @ApplicationContext context: Context
) : BaseViewModel(context) {

}