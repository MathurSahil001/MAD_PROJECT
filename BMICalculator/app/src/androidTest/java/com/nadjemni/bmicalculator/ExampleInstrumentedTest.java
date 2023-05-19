package com.nadjemni.bmicalculator;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        androidx.test.platform.app.ApplicationProvider.getApplicationContext();
        String appContext = InstrumentationRegistry.getInstrumentation().getTargetContext().getPackageName();
        assertEquals("com.nadjemni.bmicalculator", appContext);
    }
}
