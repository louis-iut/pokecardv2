package fr.iut.iem.pokecard.data.manager.impl

import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import fr.iut.iem.pokecard.BuildConfig
import fr.iut.iem.pokecard.data.manager.`interface`.PokeAPIManager
import fr.iut.iem.pokecard.data.model.Pokemon
import fr.iut.iem.pokecard.data.model.User
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.concurrent.TimeUnit

/**
 * Created by louis on 27/01/2018.
 */
class PokeAPIManagerImpl : PokeAPIManager {


    private var pokeAPIEndPoint: PokeAPIEndPoint
    private var retrofit: Retrofit
    private var baseUrl: String = BuildConfig.POKE_BASE_URL

    init {
        retrofit = initRetrofit(initHttpClient())
        pokeAPIEndPoint = retrofit.create(PokeAPIEndPoint::class.java)
    }

    override fun signUp(user: User): Observable<User> {
        return pokeAPIEndPoint.signUp(user)
    }

    override fun login(user: User): Observable<User> {
        return pokeAPIEndPoint.login(user)
    }

    override fun getUsers(): Observable<List<User>> {
        return pokeAPIEndPoint.getUsers()
    }

    override fun getPokemonByID(id: Int): Observable<Pokemon> {
        return pokeAPIEndPoint.getPokemonByID(id)
    }

    override fun getPokemons(page: Int, offset: Int): Observable<List<Pokemon>> {
        return pokeAPIEndPoint.getPokemons(page, offset)
    }

    override fun getUserPokemons(id: Int): Observable<List<Pokemon>> {
        return pokeAPIEndPoint.getUserPokemons(id)
    }

    private fun initHttpClient(): OkHttpClient {
        var logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Log.i("pokeAPI", message) })
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

    interface PokeAPIEndPoint {
        @POST("sign/up")
        fun signUp(@Body user: User): Observable<User>

        @POST("sign/in")
        fun login(@Body user: User): Observable<User>

        @GET("users")
        fun getUsers(): Observable<List<User>>

        @GET("fr/pokemon/{id}")
        fun getPokemonByID(@Path("id") id: Int): Observable<Pokemon>

        @GET("pokemons")
        fun getPokemons(@Query("page") page: Int, @Query("number") offset: Int): Observable<List<Pokemon>>

        @GET("user/{userID}/pokemons")
        fun getUserPokemons(@Path("userID") id: Int): Observable<List<Pokemon>>
    }
}