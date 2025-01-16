package co.xreos.swiftdrive.unit

interface IUnit {
    fun setup()
    fun loop()
    fun destroy()

    fun name(): String
}