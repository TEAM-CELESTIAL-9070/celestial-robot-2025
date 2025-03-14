package co.xreos.swiftdrive.transform

import co.xreos.swiftdrive.math.RelativeMarker

interface MarkerTransform {
    fun transform(marker: RelativeMarker)
}