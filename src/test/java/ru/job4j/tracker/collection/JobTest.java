package ru.job4j.tracker.collection;

import org.junit.Test;
import ru.job4j.collection.*;

import java.util.Comparator;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("CC", 1),
                new Job("CC", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompByAscNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().
                thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("AA", 0),
                new Job("AA", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompAscByName() {
        Comparator<Job> jobComparator = new JobAscByName();
        int rsl = jobComparator.compare(
                new Job("a", 1),
                new Job("b", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompAscByPriority() {
        Comparator<Job> jobComparator = new JobAscByPriority();
        int rsl = jobComparator.compare(
                new Job("B", 2),
                new Job("C", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompDescByName() {
        Comparator<Job> jobComparator = new JobDescByName();
        int rsl = jobComparator.compare(
                new Job("b", 4),
                new Job("a", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompDescByPriority() {
        Comparator<Job> jobComparator = new JobDescByPriority();
        int rsl = jobComparator.compare(
                new Job("B", 7),
                new Job("C", 3)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompDescByNameLn() {
        Comparator<Job> jobComparator = new JobDescByNameLn();
        int rsl = jobComparator.compare(
                new Job("BBC", 1),
                new Job("C", 3)
        );
        assertThat(rsl, lessThan(0));
    }
}
