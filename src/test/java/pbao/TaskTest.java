package pbao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TaskTest {

    private Task task = new Task();

    @Before
    public void testInit() {
        task.init();
    }

    @After
    public void testClose() {
        task.close();
    }

    @Test
    public void testMakeDir() {
        task.mkdir();
    }

    @Test
    public void testUpload() {
        task.upload();
    }

}
