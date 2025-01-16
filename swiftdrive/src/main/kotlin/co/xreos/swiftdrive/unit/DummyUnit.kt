package co.xreos.swiftdrive.unit

class DummyUnit(val id: String) : IUnit {
    override fun setup() {

    }

    override fun loop() {

    }

    override fun destroy() {

    }

    override fun name(): String {
        return "DummyUnit-$id"
    }
}