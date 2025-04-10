package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Kade W.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_github_id() {
        assertEquals("kwilliams812", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("s25-03", t.getName());
    }

    @Test
    public void getTeam_returns_team_with_correct_members() {
        Team  t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Isaac L."),"Team should contain Isaac L.");
        assertTrue(t.getMembers().contains("Karena L."),"Team should contain Karena L.");
        assertTrue(t.getMembers().contains("Kade W."),"Team should contain Kade W.");
        assertTrue(t.getMembers().contains("Saahas B."),"Team should contain Saahas B.");
        assertTrue(t.getMembers().contains("Xin W."),"Team should contain Xin W.");
        assertTrue(t.getMembers().contains("Daisy Z."),"Team should contain Daisy Z.");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
