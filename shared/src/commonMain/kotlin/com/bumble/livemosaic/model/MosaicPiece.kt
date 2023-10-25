package com.bumble.livemosaic.model

import com.bumble.appyx.utils.multiplatform.Parcelable
import com.bumble.appyx.utils.multiplatform.Parcelize

@Parcelize
data class MosaicPiece(
    val i: Int,
    val j: Int,
    val entryId: Int
) : Parcelable
