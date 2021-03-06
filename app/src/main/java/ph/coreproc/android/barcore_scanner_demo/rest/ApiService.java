package ph.coreproc.android.barcore_scanner_demo.rest;

import java.util.List;

import ph.coreproc.android.barcore_scanner_demo.models.Contributor;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by johneris on 6/5/2015.
 */
public interface ApiService {

//    @GET("")
//    void getContributors(@Header("X-Authorization") String authorization, Callback<Contributor> callback);

//    @POST("/users/new")
//    void createUser(@Body User user, Callback<User> cb);

    @GET("/repos/{user}/{repository}/contributors")
    void getContributors(
            @Path("user") String user,
            @Path("repository") String repository,
            Callback<List<Contributor>> callback
    );

}
