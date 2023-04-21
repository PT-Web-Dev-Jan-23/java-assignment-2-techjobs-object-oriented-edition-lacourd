package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(),job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertEquals(testJob.getName(), "Product tester");
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals(testJob.getEmployer().toString(), "ACME");
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals(testJob.getLocation().toString(), "Desert");
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals(testJob.getPositionType().toString(), "Quality control");
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(testJob.getCoreCompetency().toString(), "Persistence");
//        assertTrue(testJob.getId() == int);
    }
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob.toString().charAt(0), '\n');
        assertEquals(testJob.toString().charAt(testJob.toString().length()-1), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob =  new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testData = "\nID: " + testJob.getId() +
                          "\nName: " + testJob.getName() +
                "\nEmployer: " + testJob.getEmployer().toString() +
                "\nLocation: " + testJob.getLocation().toString() +
                "\nPosition Type: " + testJob.getPositionType().toString() +
                "\nCore Competency: " + testJob.getCoreCompetency().toString() +"\n";
        assertEquals(testJob.toString(),testData);
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob =  new Job("Product tester", new Employer("ACME"), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String testData = "\nID: " + testJob.getId() +
                "\nName: " + testJob.getName() +
                "\nEmployer: " + testJob.getEmployer().toString() +
                "\nLocation: Data not available" +
                "\nPosition Type: " + testJob.getPositionType().toString() +
                "\nCore Competency: " + testJob.getCoreCompetency().toString() +"\n";
        assertEquals(testJob.toString(),testData);
    }
    @Test
    public void testToStringHandlesEmptyJobData() {
        Job testJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(testJob.toString(), "\nOOPS! This job does not seem to exist.\n");
    }

}
