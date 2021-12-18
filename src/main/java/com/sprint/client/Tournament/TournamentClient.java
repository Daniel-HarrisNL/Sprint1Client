package com.sprint.client.Tournament;

import com.sprint.client.RestClient.RestClient;

import java.net.http.HttpRequest;

public class TournamentClient {

    /**
     *
     * @return
     */
    public static String getAllTournaments() {
        return RestClient.getRequest("http://localhost:8080/tournaments");
    }

    /**
     *
     * @param id
     * @return
     */
    public static String getTournamentById(long id){
        return RestClient.getRequest("http://localhost:8080/tournaments/search?id="+id);
    }

    /**
     *
     * @param heading
     * @return
     */
    public static String getTournamentByHeading(String heading){
        return RestClient.getRequest("http://localhost:8080/tournaments/search?heading="+heading);
    }


    public static String postTournament(String heading,  String startDate, String endDate, String location,
                                    Double fee, Double prize){
        String jsonTournamentString = "{\"heading\": \"" + heading
                + "\",\"startDate\": \"" + startDate
                + "\",\"endDate\": \"" + endDate
                + "\",\"location\": \"" + location
                + "\",\"fee\": \"" + fee
                + "\",\"prize\": \"" + prize
                + "\",\"standings\": \"" + "N/A"
                + "\",\"status\": \"" + "Scheduled"
                + "\"}";
        HttpRequest.BodyPublisher jsonTournament = HttpRequest.BodyPublishers.ofString(jsonTournamentString);

        return RestClient.postRequest("http://localhost:8080/tournaments/add", jsonTournament);
    }

    /**
     *
     * @param id
     * @return
     */
    public static String deleteTournamentById(long id) {
        return RestClient.deleteRequest("http://localhost:8080/tournaments/delete?id=" + id);
    }

    /**
     *
     * @param id
     * @param heading
     * @param startDate
     * @param endDate
     * @param location
     * @param fee
     * @param prize
     * @param standings
     * @param status
     * @return
     */
    public static String putTournamentById(long id, String heading,  String startDate, String endDate, String location,
                                            Double fee, Double prize, String standings, String status) {
        String jsonTournamentString = "{\"heading\": \"" + heading
                + "\",\"startDate\": \"" + startDate
                + "\",\"endDate\": \"" + endDate
                + "\",\"location\": \"" + location
                + "\",\"fee\": \"" + fee
                + "\",\"prize\": \"" + prize
                + "\",\"standings\": \"" + standings
                + "\",\"status\": \"" + status
                + "\"}";
        HttpRequest.BodyPublisher jsonTournament = HttpRequest.BodyPublishers.ofString(jsonTournamentString);

        return RestClient.putRequest("http://localhost:8080/tournaments/update/" + id, jsonTournament);
    }
}