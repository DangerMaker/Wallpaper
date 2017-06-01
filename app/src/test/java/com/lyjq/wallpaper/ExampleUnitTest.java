package com.lyjq.wallpaper;

import com.lyjq.wallpaper.data.TasksDataSource;
import com.lyjq.wallpaper.data.TasksRepository;
import com.lyjq.wallpaper.data.model.Task;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.List;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    TasksRepository repository;

    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testTaskRepositoryHair(){
//        repository = new TasksRepository()
    }
}