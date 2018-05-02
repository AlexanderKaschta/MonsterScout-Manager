package de.codeoverflow.frc.monsterscoutmanager.networking;


import java.util.List;

import de.codeoverflow.frc.monsterscoutmanager.storage.models.ApiStatus;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.SimpleEvent;
import de.codeoverflow.frc.monsterscoutmanager.storage.models.Team;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @version 1.2
 * @since JDK 1.7
 * @author Alex
 * Created by Alex on 19.02.2018.
 */

public interface TBAApi {

    @GET("status")
    Call<ApiStatus> getStatus();

    /**
    @GET("events/{year}")
    Call<List<SimpleEvent>> getEvents(@Path("year") Integer year);
     **/

    @GET("events/{year}/simple")
    Call<List<SimpleEvent>> getSimpleEvents(@Path("year") Integer year);

    @GET("event/{event_key}/teams")
    Call<List<Team>> getTeamsOfEvent(@Path("event_key") String event);


}
