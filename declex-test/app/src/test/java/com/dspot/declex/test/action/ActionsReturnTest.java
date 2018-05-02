package com.dspot.declex.test.action;

import android.content.Context;

import com.dspot.declex.test.action.holder.SimpleActionHolder_;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareOnlyThisForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(RobolectricTestRunner.class)
@PowerMockIgnore({ "org.mockito.*", "org.robolectric.*", "android.*", "org.powermock.*" })
@PrepareOnlyThisForTest({
        SimpleActionHolder_.class
})
public class ActionsReturnTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    private ActionsReturnBean_ bean;

    @Before
    public void loadHolder() {
        bean = ActionsReturnBean_.getInstance_(RuntimeEnvironment.application);
    }

    private void mockSimpleHolder() {

        SimpleActionHolder_ simpleHolder = spy(SimpleActionHolder_.getInstance_(RuntimeEnvironment.application));

        mockStatic(SimpleActionHolder_.class);
        when(SimpleActionHolder_.getInstance_(any(Context.class))).thenReturn(simpleHolder);
    }

    @Test
    public void testReturnInt() {

        mockSimpleHolder();

        int intValue = bean.actionReturnInt();

        assertEquals(1, intValue);
    }

    @Test
    public void testReturnShort() {

        mockSimpleHolder();

        int intValue = bean.actionReturnShort();

        assertEquals(1, intValue);
    }

    @Test
    public void testReturnLong() {

        mockSimpleHolder();

        long longValue = bean.actionReturnLong();

        assertEquals(1, longValue);
    }

    @Test
    public void testReturnFloat() {

        mockSimpleHolder();

        float floatValue = bean.actionReturnFloat();

        assertEquals(1, floatValue, 0);
    }

    @Test
    public void testReturnDouble() {

        mockSimpleHolder();

        double doubleValue = bean.actionReturnDouble();

        assertEquals(1, doubleValue, 0);
    }

    @Test
    public void testReturnChar() {

        mockSimpleHolder();

        char charValue = bean.actionReturnChar();

        assertEquals(1, charValue);
    }

    @Test
    public void testReturnByte() {

        mockSimpleHolder();

        byte byteValue = bean.actionReturnByte();

        assertEquals(1, byteValue);
    }

    @Test
    public void testReturnBoolean() {

        mockSimpleHolder();

        boolean booleanValue = bean.actionReturnBoolean();

        assertTrue(booleanValue);
    }

    @Test
    public void testReturnInBlock() {

        mockSimpleHolder();

        int inBlockValue = bean.actionReturnInBlock();

        assertEquals(1, inBlockValue);
    }
}
