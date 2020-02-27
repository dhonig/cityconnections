package com.dhonig.cityconnections.service;

import com.dhonig.cityconnections.factory.CityDataFactory;
import com.dhonig.cityconnections.model.CityData;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.traverse.DepthFirstIterator;
import org.jgrapht.traverse.GraphIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;

@Component("searchService")
public class SearchServiceImpl implements SearchService {

    //In this class you could do some fancy things to support
    //different algorithms, traversals, but this wasn't specified in the requirements
    // so we'll go with the simplest thing that will work. Implementing a DFS with JGraphT

    Graph<String, DefaultEdge> graph;


    CityData cityData;

    @Autowired
    private CityDataFactory factory;


    @PostConstruct
    private void init() {
        cityData = factory.getObject();
        graph = new DefaultDirectedGraph<String, DefaultEdge>(DefaultEdge.class);
        for (String city : cityData.getUniqueCities()) {
            graph.addVertex(city.toString());
        }

        for (String[] cityPair : cityData.getCityPairs()) {
            graph.addEdge(cityPair[0], cityPair[1]);
        }

    }


    @Override
    public boolean search(String city1, String city2) {
        DijkstraShortestPath djsp=new DijkstraShortestPath(graph);
        GraphPath<String,DefaultEdge> path=djsp.getPath(city1,city2);
        if(path==null)
            return false;

       return path != null ? true : false;
    }
}