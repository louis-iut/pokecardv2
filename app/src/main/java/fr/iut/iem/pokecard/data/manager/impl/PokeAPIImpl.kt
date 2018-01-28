package fr.iut.iem.pokecard.data.manager.impl

import fr.iut.iem.pokecard.BuildConfig
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPI
import fr.iut.iem.pokecard.data.model.Pokemon
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Created by louis on 27/01/2018.
 */
class PokeAPIImpl : PokeAPI {

    private var pokeAPIEndPoint: PokeAPIEndPoint
    private var retrofit: Retrofit
    private var baseUrl: String = BuildConfig.POKE_BASE_URL

    init {
        retrofit = initRetrofit(initHttpClient())
        pokeAPIEndPoint = retrofit.create(PokeAPIEndPoint::class.java)
    }

    private fun initHttpClient(): OkHttpClient {
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    private fun initRetrofit(httpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .client(httpClient)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    override fun getPokemonByID(id: Int): Observable<Pokemon> {
        return pokeAPIEndPoint.getPokemonByID(id)
    }

    override fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>> {
        return pokeAPIEndPoint.getPokemons(page, offset)
    }

    interface PokeAPIEndPoint {
        @GET("test")
        fun getPokemonByID(@Query("test") id: Int): Observable<Pokemon>

        @GET("pokemons")
        fun getPokemons(@Query("page") page: Int, @Query("number") offset: Int): Observable<List<Pokemon>>
    }
}