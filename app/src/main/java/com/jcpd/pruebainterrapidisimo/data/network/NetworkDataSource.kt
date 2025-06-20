package com.jcpd.pruebainterrapidisimo.data.network

import com.jcpd.pruebainterrapidisimo.data.models.LocationsModel
import com.jcpd.pruebainterrapidisimo.data.models.TableModel
import com.jcpd.pruebainterrapidisimo.data.models.UserModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface NetworkDataSource {

    @GET("apicontrollerpruebas/api/ParametrosFramework/ConsultarParametrosFramework/VPStoreAppControl")
    suspend fun getVersion(): Response<String>

    @Headers(
        "Usuario: pam.meredy21",
        "Identificacion: 987204545",
        "Accept: text/json",
        "IdUsuario: pam.meredy21",
        "IdCentroServicio: 1295",
        "NombreCentroServicio: PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA 30 # 7-45",
        "IdAplicativoOrigen: 9",
        "Content-Type: application/json"
    )
    @POST("FtEntregaElectronica/MultiCanales/ApiSeguridadPruebas/api/Seguridad/AuthenticaUsuarioApp")
    suspend fun getLogin(
        @Body body: Map<String, String> = mapOf<String, String>(
            "Mac" to "",
            "NomAplicacion" to "Controller APP",
            "Password" to "SW50ZXIyMDIx\n",
            "Path" to "",
            "Usuario" to "cGFtLm1lcmVkeTIx\n"
        )
    ): Response<UserModel>

    @Headers(
        "Usuario: pam.meredy21",
        "Identificacion: 987204545",
        "Accept: text/json",
        "IdUsuario: pam.meredy21",
        "IdCentroServicio: 1295",
        "NombreCentroServicio: PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA 30 # 7-45",
        "IdAplicativoOrigen: 9",
        "Content-Type: application/json"
    )
    @GET("apicontrollerpruebas/api/SincronizadorDatos/ObtenerEsquema/true")
    suspend fun getEsqueme(): Response<List<TableModel>>

    @GET("apicontrollerpruebas/api/ParametrosFramework/ObtenerLocalidadesRecogidas")
    suspend fun getLocations() : Response<List<LocationsModel>>
}