package co.xreos.swiftdrive.engine.output

import co.xreos.swiftdrive.unit.IUnit
import co.xreos.swiftdrive.unit.setpoint.UnitSetpoint
import co.xreos.swiftdrive.util.logging.logger

data class EngineOutput (
    private val setpoints: Map<IUnit, UnitSetpoint>,
    private val defaultSetpoint: UnitSetpoint?,
) {
    init {
        if(defaultSetpoint == null) {
            if(setpoints.isEmpty()) {
                logger.w { "No default value or setpoint found for any unit, please provide a defaultSetpoint or non-empty setpoint data to suppress this warning." }
            }
        }
    }

    fun getSetpoint(unit: IUnit): UnitSetpoint {
        return setpoints[unit] ?: defaultSetpoint ?: UnitSetpoint.Zero.also {
            logger.w { "No default value or setpoint found for unit $unit, using zero setpoint as default. Please provide a defaultSetpoint to suppress this warning." }
        }
    }
}