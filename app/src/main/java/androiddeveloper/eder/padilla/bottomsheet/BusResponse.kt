package androiddeveloper.eder.padilla.bottomsheet

/**
 * Created by ederpadilla on 28/06/17.
 */
data class BusResponse(var success : Boolean? = null, var message : String?=null)
data class Bus(var idBusStatus : Int? = null, var name : String?=null, var image : String? = null, var description : String?=null)