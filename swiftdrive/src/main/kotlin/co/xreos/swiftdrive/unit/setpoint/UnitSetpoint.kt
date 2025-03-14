package co.xreos.swiftdrive.unit.setpoint

data class UnitSetpoint(
    val desiredSpeed: Double,
    val desiredAngle: Double,
) {
    companion object {
        val Zero = UnitSetpoint(0.0, 0.0)
    }

    override fun toString(): String {
        return "UnitSetpoint(desiredSpeed=$desiredSpeed, desiredAngle=$desiredAngle)"
    }
}