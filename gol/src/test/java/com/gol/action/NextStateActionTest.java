package com.gol.action;

import junit.framework.TestCase;

import com.opensymphony.xwork2.ActionSupport;
public class NextStateActionTest extends TestCase
{
	NextStateAction nsa = new NextStateAction();
	String result;

	protected void setUp() {
		nsa = new NextStateAction();
		result = nsa.execute();
	}
	
  public void testAllDeadSecnario() throws Exception
  {
    nsa.setStates("11,13,39");
    String result = nsa.execute();
    assertTrue("Expected a success result!", ActionSupport.SUCCESS.equals(result));
    assertTrue("There should be not states returned for the playground", ("").equals(nsa.getStates()));
  
  }
  
  public void testLifeSecnario() throws Exception
  {
    nsa.setStates("11,12,13");
    String result = nsa.execute();
    assertTrue("Expected a success result!", ActionSupport.SUCCESS.equals(result));
    assertTrue("Next State should have one new live cell and also retain one of the existing live cell", ("12,37").equals(nsa.getStates()));
  }
}
