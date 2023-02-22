package com.starter.demo.unittesting;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public final class MockVsSpy {


	//Mock : In mock, you are creating a complete mock or fake object will give.
	//Spy  : In spy, there is the real object and you just spying or stubbing specific methods of it.
	
    @Mock
    private List<String> mockList;
 
    @Spy
    private List<String> spyList = new ArrayList();
    
 
    @Test
    public void testMockList() {
        //by default, calling the methods of mock object will do nothing
        mockList.add("test");
        //assertNull(mockList.get(0));
        assertEquals("test", mockList.get(0));
    }
    
    
 
    @Test
    public void testSpyList() {
        //spy object will call the real method when not stub
        spyList.add("test");
        assertEquals("test", spyList.get(0));
    }
 
}