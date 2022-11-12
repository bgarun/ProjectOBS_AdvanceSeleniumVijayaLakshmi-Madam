package practisepackage;

import org.testng.annotations.Test;

public class Sample3 {

	@Test(groups ={"smoke","regression"})
	public void script6()
	{
		System.out.println("Script555555555555555");
	}
	
	@Test(groups="regression")
	public void script7()
	{
		System.out.println("Script6666666666666666");
	}
	
	@Test
	public void Scriptb()
	{
		System.out.println("Scriptbbbbbbbbbbbb");
	}
}
