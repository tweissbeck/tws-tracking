package tws.tracking.lib.model

interface Tracker {
    
    fun getName(): String
    fun getUnit(): IUnit
    fun getData(): Set<TrackingData>
}