package test;

import org.testng.annotations.Test;
import src.Core;

@Test
public class UnitTest {
    @Test
    public void TestDEMO() {
        Core core = new Core("../demo.in");
        core.run();
    }

    @Test
    public void TestTask1() {
        Core core = new Core("/Users/fenglongyang/Downloads/knowledge_representation/task1.in");
        core.run();
    }

    @Test
    public void TestTask3() {
        Core core = new Core("/Users/fenglongyang/Downloads/knowledge_representation/task3.in");
        core.run();;
    }

    @Test
    public void TestTask6() {
        Core core = new Core("/Users/fenglongyang/Downloads/knowledge_representation/task6.in");
        core.run();
    }

    @Test
    public void TestTask7() {
        Core core = new Core("/Users/fenglongyang/Downloads/knowledge_representation/task7.in");
        core.run();
    }
}
