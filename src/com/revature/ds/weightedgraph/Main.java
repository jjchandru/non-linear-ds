package com.revature.ds.weightedgraph;

public class Main {

	public static void main(String[] args) {
		WeightedGraph graph = new WeightedGraph();
		Vertex stMary = new Vertex("Port St. Mary");
		Vertex erin = new Vertex("Port Erin");
		Vertex ballabeg = new Vertex("Ballabeg");
		Vertex crossFourWays = new Vertex("Cross Four Ways");
		Vertex airport = new Vertex("Isle of Man Airport");
		Vertex ballasella = new Vertex("Ballasalla");
		Vertex peel = new Vertex("Peel");
		Vertex stJohns = new Vertex("St. Johns");
		Vertex littleSwitzerland = new Vertex("Little Switzerland");
		Vertex ballaugh = new Vertex("Ballaugh");
		Vertex ramsay = new Vertex("Ramsey");
		
		Edge stMaryToAirport = new Edge(airport, 9.1);
		Edge stMaryToErin = new Edge(erin, 1.7);
		Edge stMaryToCrossFourWays = new Edge(crossFourWays, 8.2);
		stMary.addEdge(stMaryToAirport);
		stMary.addEdge(stMaryToErin);
		stMary.addEdge(stMaryToCrossFourWays);
		
		Edge erinToBallabeg = new Edge(ballabeg, 5.5);
		Edge erinToStMary = new Edge(stMary, 1.7);
		erin.addEdge(erinToBallabeg);
		erin.addEdge(erinToStMary);
		
		Edge ballabegToErin = new Edge(erin, 1.7);
		Edge ballabegToCrossFourWays = new Edge(crossFourWays, 2.6);
		ballabeg.addEdge(ballabegToErin);
		ballabeg.addEdge(ballabegToCrossFourWays);
		
		Edge crossFourWaysToBallabeg = new Edge(ballabeg, 2.6);
		Edge crossFourWaysToStMary = new Edge(stMary, 8.2);
		Edge crossFourWaysToBallasella = new Edge(ballasella, 1.2);
		Edge crossFourWaysToStJohns = new Edge(stJohns, 12.5);
		crossFourWays.addEdge(crossFourWaysToBallabeg);
		crossFourWays.addEdge(crossFourWaysToStMary);
		crossFourWays.addEdge(crossFourWaysToBallasella);
		crossFourWays.addEdge(crossFourWaysToStJohns);
		
		Edge ballasellaToLittleSwitzerland = new Edge(littleSwitzerland, 12.6);
		Edge ballasellaToCrossFourWays = new Edge(crossFourWays, 1.2);
		Edge ballasellaToAirport = new Edge(airport, 1.6);
		ballasella.addEdge(ballasellaToLittleSwitzerland);
		ballasella.addEdge(ballasellaToCrossFourWays);
		ballasella.addEdge(ballasellaToAirport);

		Edge airportToBallasella = new Edge(ballasella, 1.6);
		Edge airportToStMary = new Edge(stMary, 9.1);
		airport.addEdge(airportToBallasella);
		airport.addEdge(airportToStMary);

		Edge littleSwitzerlandToStJohns = new Edge(ballabeg, 2.6);
		Edge littleSwitzerlandToBallasella = new Edge(stMary, 8.2);
		Edge littleSwitzerlandToRamsay1 = new Edge(ramsay, 25);
		Edge littleSwitzerlandToRamsay2 = new Edge(ramsay, 23.8);
		littleSwitzerland.addEdge(littleSwitzerlandToStJohns);
		littleSwitzerland.addEdge(littleSwitzerlandToBallasella);
		littleSwitzerland.addEdge(littleSwitzerlandToRamsay1);
		littleSwitzerland.addEdge(littleSwitzerlandToRamsay2);
		
		Edge stJohnsToPeel = new Edge(peel, 4.3);
		Edge stJohnsToBallaugh = new Edge(ballaugh, 16.1);
		Edge stJohnsToLittleSwitzerland = new Edge(littleSwitzerland, 12.6);
		Edge stJohnsToCrossFourWays = new Edge(crossFourWays, 12.5);
		stJohns.addEdge(stJohnsToPeel);
		stJohns.addEdge(stJohnsToBallaugh);
		stJohns.addEdge(stJohnsToLittleSwitzerland);
		stJohns.addEdge(stJohnsToCrossFourWays);
		
		Edge peelToBallaugh = new Edge(ballaugh, 14.9);
		Edge peelToStJohns = new Edge(stJohns, 4.3);
		peel.addEdge(peelToBallaugh);
		peel.addEdge(peelToStJohns);

		Edge ballaughToPeel = new Edge(peel, 14.9);
		Edge ballaughToRamsay = new Edge(ramsay, 10.8);
		Edge ballaughToStJohns = new Edge(stJohns, 16.1);
		ballaugh.addEdge(ballaughToPeel);
		ballaugh.addEdge(ballaughToRamsay);
		ballaugh.addEdge(ballaughToStJohns);

		Edge ramsayToBallaugh = new Edge(ballaugh, 10.8);
		Edge ramsayToLittleSwitzerland1 = new Edge(littleSwitzerland, 23.8);
		Edge ramsayToLittleSwitzerland2 = new Edge(littleSwitzerland, 25);
		ramsay.addEdge(ramsayToBallaugh);
		ramsay.addEdge(ramsayToLittleSwitzerland1);
		ramsay.addEdge(ramsayToLittleSwitzerland2);

		graph.addVertex(stMary);
		graph.addVertex(airport);
		graph.addVertex(erin);
		graph.addVertex(ballabeg);
		graph.addVertex(crossFourWays);
		graph.addVertex(ballasella);
		graph.addVertex(littleSwitzerland);
		graph.addVertex(stJohns);
		graph.addVertex(peel);
		graph.addVertex(ballaugh);
		graph.addVertex(ramsay);
		
		//graph.traverseBreadthFirst("Port Erin");
		graph.shortestPath("Port Erin", "Ramsey");
	}

}
