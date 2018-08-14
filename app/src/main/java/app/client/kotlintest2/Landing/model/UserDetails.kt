package app.client.kotlintest2.Landing.model

import java.io.Serializable
import java.util.*

/**
 * Created by User on 10-Aug-18.
 */
data class UserDetails(val firstName:String,
                        val lastName:String,
                        var age:Int,
                        val birthDate: Date= Date()):Serializable {

}

