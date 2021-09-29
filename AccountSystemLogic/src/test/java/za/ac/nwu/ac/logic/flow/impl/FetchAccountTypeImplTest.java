package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FetchAccountTypeImplTest {

    private FetchAccountTypeImpl classToTest;

    @Before
    public void setUp() throws Exception {
        classToTest = new FetchAccountTypeImpl(null);
    }

    @After
    public void tearDown() throws Exception {
        classToTest = null;
    }

}