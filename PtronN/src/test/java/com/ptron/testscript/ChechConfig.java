package com.ptron.testscript;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.ptron.generic.BaseClass;
public class ChechConfig extends BaseClass {
	@Test
public void check()
{
	Reporter.log("hi",true);
}
}
