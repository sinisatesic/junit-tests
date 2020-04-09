import org.hamcrest.core.IsInstanceOf;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;


import static org.junit.Assert.*;

public class StudentTest {

    //Testing
    private Student student1;
    private Student student2;
    private Student student3;

    @Before
    public void setup(){
        this.student1 = new Student("Amber", 1);
        student1.addGrade(90);
        student1.addGrade(100);
        student1.addGrade(100);
        student1.addGrade(90);
        student1.addGrade(100);
        student1.addGrade(100);

        this.student2 = new Student("Cami", 2);
        student2.addGrade(80);
        student2.addGrade(80);

        this.student3 = new Student("Mason", 3);
    }

    @Test
    public void testIfIdIsAccurate(){
        assertNotNull(student1.getId());
        assertNotEquals(student1.getId(), student2.getId());
    }

    @Test
    public void
    testIfNameIsValid(){
        assertNotNull(student1.getName());
        assertNotEquals("", student1.getName());
        assertEquals("Amber", student1.getName());
    }

    @Test
    public void
    testToEnsureGradesAreBeingAdded(){
        assertEquals(6, student1.getGradesLength());
        assertEquals(2, student2.getGradesLength());
        assertEquals(0, student3.getGradesLength());
    }

    @Test
    public void
    testToMakeSureAverageIsAccurate(){
        int student1Average = ((90+100+100) * 2) / student1.getGradesLength();
        int student2Average = ((80)*2) / 2;

        assertEquals(student1Average, student1.getGradeAverage(),0);
        assertEquals(student2Average, student2.getGradeAverage(), 0);
        assertEquals(0, student3.getGradeAverage(), 0);
    }

    @Test
    public void
    testToMakeSureReadResultsAreAccurate(){
        int[] test = {90, 100, 100, 90, 100, 100};
        Assert.assertArrayEquals(test, student1.readAllGrades());

        int[] test2 = {80,80};
        Assert.assertArrayEquals(test2, student2.readAllGrades());

        int[] test3 = {};
        Assert.assertArrayEquals(test3, student3.readAllGrades());
    }

    @Test
    public void
    testForUpdate(){
        int[] test = {90, 100, 100, 80, 100, 100};
        Assert.assertArrayEquals(test, student1.updateGrade(90, 80));

        int[] test2 = {80, 10};
        Assert.assertArrayEquals(test2, student2.updateGrade(80, 10));

        int[] test3 = new int[0];
        Assert.assertArrayEquals(test3, student3.updateGrade(10,10));
    }

    @Test
    public void
    testForRemovalOfGrade(){
        int[] test = {90, 100, 100, 90, 100};
        Assert.assertArrayEquals(test, student1.deleteGrade(100));

        int[] test2 = {80};
        Assert.assertArrayEquals(test2, student2.deleteGrade(80));

        int[] test3 = {};
        Assert.assertArrayEquals(test3, student3.deleteGrade(90));
    }


}