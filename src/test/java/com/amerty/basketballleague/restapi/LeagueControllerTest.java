package com.amerty.basketballleague.restapi;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class LeagueControllerTest {

    @Test
    public void givenTeamExists_whenTeamInfoRetrieved_then200isReceived() throws IOException {
        String name = "ANADOLU%20EFES";
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/v1/team/" + name);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        MatcherAssert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void givenTeamNotExists_whenTeamInfoRetrieved_then404isReceived() throws IOException {
        String name = "ASDF";
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/v1/team/" + name);

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        MatcherAssert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_NOT_FOUND));
    }
    @Test
    public void givenTeamStandingsCalled_whenTeamStandingsRetrieved_then200isReceived() throws IOException {
        HttpUriRequest request = new HttpGet("http://localhost:8080/api/v1/team-standings");

        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        MatcherAssert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }
    @Test
    public void givenScoreInvalid_whenMatchScoreCalled_then422isReceived() throws IOException{
        String json = "{\"home\":\"ANADOLU EFES\",\"guest\":\"PINAR KAR\u015eIYAKA\",\"hScore\":\"-106\",\"gScore\":\"106\"}";
        StringEntity entity = new StringEntity(json);


        HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/match-score");
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpClient client = HttpClients.createDefault();

        CloseableHttpResponse httpResponse = client.execute(httpPost);

        MatcherAssert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_UNPROCESSABLE_ENTITY));
    }

    @Test
    public void givenTeamNameInvalid_whenMatchScoreCalled_then422isReceived() throws IOException{
        String json = "{\"home\":\"ASDF\",\"guest\":\"QWERTT\",\"hScore\":\"106\",\"gScore\":\"100\"}";
        StringEntity entity = new StringEntity(json);


        HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/match-score");
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpClient client = HttpClients.createDefault();

        CloseableHttpResponse httpResponse = client.execute(httpPost);

        MatcherAssert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_UNPROCESSABLE_ENTITY));
    }

    @Test
    public void givenSameTeamNames_whenMatchScoreCalled_then422isReceived() throws IOException{
        String json = "{\"home\":\"ANADOLU EFES\",\"guest\":\"ANADOLU EFES\",\"hScore\":\"106\",\"gScore\":\"100\"}";
        StringEntity entity = new StringEntity(json);


        HttpPost httpPost = new HttpPost("http://localhost:8080/api/v1/match-score");
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpClient client = HttpClients.createDefault();

        CloseableHttpResponse httpResponse = client.execute(httpPost);

        MatcherAssert.assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_UNPROCESSABLE_ENTITY));
    }


}
