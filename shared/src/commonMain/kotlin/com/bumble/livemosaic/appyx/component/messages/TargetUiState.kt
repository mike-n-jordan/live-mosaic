package com.bumble.livemosaic.appyx.component.messages

import com.bumble.appyx.interactions.core.ui.property.impl.Alpha
import com.bumble.appyx.interactions.core.ui.property.impl.RotationX
import com.bumble.appyx.interactions.core.ui.property.impl.Scale
import com.bumble.appyx.interactions.core.ui.property.impl.position.PositionAlignment
import com.bumble.appyx.interactions.core.ui.state.MutableUiStateSpecs

@MutableUiStateSpecs
data class TargetUiState(
    val linePosition: PositionAlignment.Target,
    val rotationX: RotationX.Target,
    val scale: Scale.Target,
    val alpha: Alpha.Target,
)
