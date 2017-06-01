package tests;

import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import controllers.Scheduler;
import events.NewCustomerEvent;
import interfaces.SimulationEvent;
import models.BarberShop;
import time.Clock;
import time.TimeLine;
import tools.NewCustomerEventGenerator;

public class SchedulerTest {

	@Test
	public void priorityOrderTest() {
		Clock clock = new Clock();
		BarberShop shop = new BarberShop();
		Scheduler scheduler = new Scheduler(clock, shop);
		TimeLine line = new TimeLine(scheduler);
		PriorityQueue<SimulationEvent> queue = line.getFuture();
		
		NewCustomerEvent event = new NewCustomerEvent(6,shop, scheduler.getTimeLine(), clock,scheduler);
		NewCustomerEvent event1 = new NewCustomerEvent(5, shop, scheduler.getTimeLine(),clock,scheduler);
		
		queue.add(event);
		queue.add(event1);
		
		SimulationEvent actualEvent = queue.peek();
		
		int actual = actualEvent.getEventTime();
		int expected = 5;
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void newEventGenerationTest(){
		Clock clock = new Clock();
		BarberShop shop = new BarberShop();
		Scheduler scheduler = new Scheduler(clock, shop);
		TimeLine line = scheduler.getTimeLine();
		
		NewCustomerEventGenerator gen = new NewCustomerEventGenerator(clock, shop, scheduler);
		SimulationEvent event = gen.generateNewCustomer();
		
		scheduler.scheduleFutureEvent(event);
		
		Assert.assertTrue(line.getFuture().peek().equals(event));
		
	}

}
