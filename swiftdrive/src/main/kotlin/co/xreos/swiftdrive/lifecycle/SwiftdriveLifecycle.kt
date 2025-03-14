package co.xreos.swiftdrive.lifecycle

import co.xreos.sarin.skeleton.Skeleton
import co.xreos.sarin.skeleton.lifecycle.Lifecycle
import co.xreos.swiftdrive.unit.IUnit

enum class SwiftdriveLifecycle: Lifecycle {
    INITIALIZATION,
    SETUP,
    LOOP,
    DESTROY,
}