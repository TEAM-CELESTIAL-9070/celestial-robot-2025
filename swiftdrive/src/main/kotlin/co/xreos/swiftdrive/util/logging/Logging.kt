package co.xreos.swiftdrive.util.logging

import co.touchlab.kermit.DefaultFormatter
import co.touchlab.kermit.Logger
import co.touchlab.kermit.loggerConfigInit
import co.touchlab.kermit.platformLogWriter

val logger = Logger(
    loggerConfigInit(platformLogWriter(DefaultFormatter)),
    "Swiftdrive"
)