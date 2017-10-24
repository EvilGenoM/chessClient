package mobi.mpk.chessandroid.net;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Connect {

    @GET("/api/find/user")
    Call<String> getUser(@Query("username") String username, @Query("password") String password);

}
