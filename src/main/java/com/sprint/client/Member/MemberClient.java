package com.sprint.client.Member;

import com.sprint.client.RestClient.RestClient;

import java.net.http.HttpRequest;

public class MemberClient {

    /**
     *
     * @return
     */
    public static String getAllMembers() {
        return RestClient.getRequest("http://localhost:8080/members");
    }

    /**
     *
     * @param id
     * @return
     */
    public static String getMemberById(long id){
        return RestClient.getRequest("http://localhost:8080/members/search?id="+id);
    }

    /**
     *
     * @param fname
     * @return
     */
    public static String getMemberByFirstName(String fname){
        return RestClient.getRequest("http://localhost:8080/members/search?fname="+fname);
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     * @param phone
     * @param startDate
     * @param duration
     * @param membership
     * @return
     */
    public static String postMember(String firstName, String lastName, String address, String email, String phone,
                                    String startDate, String duration, String membership){
        String jsonMemberString = "{\"firstName\": \"" + firstName
                + "\",\"lastName\": \"" + lastName
                + "\",\"address\": \"" + address
                + "\",\"email\": \"" + email
                + "\",\"phone\": \"" + phone
                + "\",\"startDate\": \"" + startDate
                + "\",\"duration\": \"" + duration
                + "\",\"membership\": \"" + membership
                + "\"}";
        HttpRequest.BodyPublisher jsonMember = HttpRequest.BodyPublishers.ofString(jsonMemberString);

        return RestClient.postRequest("http://localhost:8080/members/add", jsonMember);
    }

    /**
     *
     * @param id
     * @return
     */
    public static String deleteMemberById(long id) {
        return RestClient.deleteRequest("http://localhost:8080/members/delete?id=" + id);
    }

    /**
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param email
     * @param phone
     * @param startDate
     * @param duration
     * @param membership
     * @return
     */
    public static String putMemberById(long id, String firstName, String lastName, String address, String email,
                                       String phone, String startDate, String duration, String membership) {
        String jsonMemberString = "{\"firstName\": \"" + firstName
                + "\",\"lastName\": \"" + lastName
                + "\",\"address\": \"" + address
                + "\",\"email\": \"" + email
                + "\",\"phone\": \"" + phone
                + "\",\"startDate\": \"" + startDate
                + "\",\"duration\": \"" + duration
                + "\",\"membership\": \"" + membership
                + "\"}";
        HttpRequest.BodyPublisher jsonMember = HttpRequest.BodyPublishers.ofString(jsonMemberString);

        return RestClient.putRequest("http://localhost:8080/members/update?id=" + id, jsonMember);
    }

}
