package com.interview.codekata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TotalGoalsByATeamInYearTest {

    TotalGoalsByATeamInYear totalGoalsByATeamInYear;

    @Before
    public void setUp() {
        totalGoalsByATeamInYear = new TotalGoalsByATeamInYear();
    }


    @Test
    public void fetch_total_goals_scored_by_a_team_in_a_year() {
        Assert.assertEquals(35, totalGoalsByATeamInYear.getTotalGoals("Barcelona", 2011));
    }
}