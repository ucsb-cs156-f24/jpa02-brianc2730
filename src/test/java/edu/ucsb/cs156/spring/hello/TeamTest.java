package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void equals_returns_correct_boolean() {
        assertEquals(true, team.equals(team));
        assertEquals(false, team.equals(null));

        Team team2 = new Team("test-team");
        assertEquals(true, team.equals(team2));

        team2.addMember("test-member");
        assertEquals(false, team.equals(team2));

        team2.setName("diff-team");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void hashCode_returns_correct_hashcode() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(expectedResult, result);
    }
}
