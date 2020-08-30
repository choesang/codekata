package com.interview.codekata;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TotalGoalsByATeamInYear {

    private Client client = ClientBuilder.newClient();

    private static final String REST_URI = "https://jsonmock.hackerrank.com/api/football_matches";

    public int getTotalGoals(String team, int year) {


//        fetchData(team, year).stream()
//          .map(Response.Data::getTeam1goals)
//          .map(Integer::valueOf)
//          .collect(() -> Integer::sum);

        List<Integer> team1 = fetchData("team1", team, year).stream()
          .map(game -> Integer.valueOf(game.getTeam1goals()))
          .collect(Collectors.toList());

        fetchData("team2", team, year).stream()
          .map(game -> Integer.valueOf(game.getTeam2goals()))
          .collect(Collectors.toList())
          .addAll(team1);

        int totalGoals = 0;
        for (Integer goals : team1) {
            totalGoals += goals;
        }
        return totalGoals;
    }

    private List<Response.Data> fetchData(String teamType, String team, int year) {

        int total_pages = 0;
        int page = 1;

        List<Response.Data> data = new ArrayList<>();

        Response response = restCall(teamType, team, year, page);

        total_pages = response.getTotal_pages();

        for (int i = 1; i >= total_pages; i++) {
            data.addAll(restCall(teamType, team, year, i).getData());
        }

        return data;
    }

    private Response restCall(String teamType, String team, int year, int page) {
        return client.target(REST_URI)
          .queryParam(teamType, team)
          .queryParam("year", year)
          .queryParam("page", page)
          .request(MediaType.APPLICATION_JSON_TYPE)
          .get(Response.class);
    }





}


@Data
class Response{
    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<Data> data = new ArrayList<>();

    public Response() {
        super();
    }

    public Response(int page, int per_page, int total, int total_pages, List<Data> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    @lombok.Data
    class Data {
        private String competition;
        private int year;
        private String round;
        private String team1;
        private String team2;
        private String team1goals;
        private String team2goals;

        public Data() {
            super();
        }

        public Data(String competition, int year, String round, String team1, String team2, String team1goals, String team2goals) {
            this.competition = competition;
            this.year = year;
            this.round = round;
            this.team1 = team1;
            this.team2 = team2;
            this.team1goals = team1goals;
            this.team2goals = team2goals;
        }
    }

  }
