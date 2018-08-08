package com.github.raphaelbluteau.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PeriodTest {

  @Test
  public void testPeriod() {

    assertEquals(Period.getEnum("morning"), Period.MORNING);
    assertEquals(Period.getEnum("MORnING"), Period.MORNING);
    assertEquals(Period.getEnum("Morning"), Period.MORNING);

    assertEquals(Period.getEnum("night"), Period.NIGHT);
    assertEquals(Period.getEnum("NighT"), Period.NIGHT);
    assertEquals(Period.getEnum("NIGHT"), Period.NIGHT);

  }

}