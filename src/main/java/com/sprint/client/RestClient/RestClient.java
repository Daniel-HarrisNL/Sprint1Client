package com.sprint.client.RestClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestClient {
    final static HttpClient client = HttpClient.newHttpClient();

    /**
     *
     * @param request
     * @return
     */
    private static String sendRequest(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200){
                return response.body();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Response failed.";
    }

    /**
     *
     * @param requestURI
     * @return
     */
    public static String getRequest(String requestURI){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestURI)).build();
        return sendRequest(request);
    }

    /**
     *
     * @param requestURI
     * @param body
     * @return
     */
    public static String postRequest(String requestURI, HttpRequest.BodyPublisher body){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestURI))
                .method("POST", body)
                .header("Content-Type", "application/json")
                .build();
        return sendRequest(request);
    }

    /**
     *
     * @param requestURI
     * @return
     */
    public static String deleteRequest(String requestURI){
        HttpRequest request = HttpRequest.newBuilder().DELETE().uri(URI.create(requestURI)).build();
        return sendRequest(request);
    }

    /**
     *
     * @param requestURI
     * @param body
     * @return
     */
    public static String putRequest(String requestURI, HttpRequest.BodyPublisher body){
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestURI))
                .method("PUT", body)
                .header("Content-Type", "application/json")
                .build();
        return sendRequest(request);
    }


}

