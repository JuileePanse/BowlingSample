package com.bowling.bowlingsample;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.bowling.bowlingsample", appContext.getPackageName());
    }

    private Game g;

    public void setUp()
    {
        g = new Game();
    }

    public void testTwoThrowsNoMark()
    {
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
    }

    public void testFourThrowsNoMark()
    {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }

    public void testSimpleSpare()
    {
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.scoreForFrame(1));
    }

    public void testSimpleFrameAfterSpare()
    {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(18, g.score());
    }

    public void testSimpleStrike()
    {
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19, g.scoreForFrame(1));
        assertEquals(28, g.score());
    }

    public void testPerfectGame()
    {
        for (int i=0; i<12; i++)
        {
            g.add(10);
        }
        assertEquals(300, g.score());
    }

    public void testEndOfArray()
    {
        for (int i=0; i<9; i++)
        {
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8); // 10th frame spare
        g.add(10); // Strike in last position of array.
        assertEquals(20, g.score());
    }

    public void testSampleGame()
    {
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);
        assertEquals(133, g.score());
    }

    public void testHeartBreak()
    {
        for (int i=0; i<11; i++)
            g.add(10);
        g.add(9);
        assertEquals(299, g.score());
    }

    public void testTenthFrameSpare()
    {
        for (int i=0; i<9; i++)
            g.add(10);
        g.add(9);
        g.add(1);
        g.add(1);
        assertEquals(270, g.score());
    }
}