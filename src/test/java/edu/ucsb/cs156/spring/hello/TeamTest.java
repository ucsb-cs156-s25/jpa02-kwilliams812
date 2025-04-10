package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
    @Test
    public void equals_on_same_object() {
        assert(team.equals(team));
    }

    @Test
    public void equals_on_diff_class() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_on_equal_obj() {
        team.addMember("test-member");
        Team other_team = new Team("test-team");
        other_team.addMember("test-member");
        assert(team.equals(other_team));
    }

    @Test
    public void equals_on_diff_names() {
        team.addMember("test-member");
        Team other_team = new Team("test-team-different");
        other_team.addMember("test-member");
        assertFalse(team.equals(other_team));
    }

    @Test
    public void equals_on_diff_members() {
        team.addMember("test-member");
        Team other_team = new Team("test-team");
        other_team.addMember("test-member-different");
        assertFalse(team.equals(other_team));
    }

    @Test
    public void equals_on_not_equal_obj() {
        team.addMember("test-member");
        Team other_team = new Team("test-team-different");
        other_team.addMember("test-member-different");
        assertFalse(team.equals(other_team));
    }

    @Test
    public void hashCode_gives_expected_value() {
        // We hard code this to an expected value to get around equivalent mutations
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
