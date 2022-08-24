package com.gft.wineshop.controllerTests;

import com.gft.wineshop.controller.RegionController;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class RegionControllerTest {
    @Test
    void testGetRegion(){
        assertEquals("Tenemos region", new RegionController().getRegion(0));
    }

    @Test
    void testHello(){
        System.out.println(new RegionController().getAll());
    }

    @Test
    void testGetAll(){

        assertEquals(ArrayList.class,new RegionController().getAll().getClass());
    }

}
