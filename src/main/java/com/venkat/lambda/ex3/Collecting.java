package com.venkat.lambda.ex3;

import com.venkat.lambda.ex.Movie;
import com.venkat.lambda.ex.MovieUtil;
import com.venkat.lambda.ex.Trade;
import com.venkat.lambda.ex.TradeUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Collecting {

    List<Trade> trades = TradeUtil.createTrades2();

    private void collectIntoAList(){
        List<Trade> tradeCollection =
                trades.stream().collect(Collectors.toList());
        System.out.println(tradeCollection);
    }

    private void collectIntoASet(){
        Set<Trade> tradeCollection =
                trades.stream().collect(Collectors.toSet());
        System.out.println(tradeCollection);
    }

    private void collectIntoToAMap(){
        List<Movie> movies = MovieUtil.createMovies();

        Map<String, Movie> movieMap =
        movies.stream().collect(Collectors.toMap(Movie::getName, movie ->movie));
        System.out.println(movieMap);

    }

    public static void main(String[] args) {
        Collecting c = new Collecting();
        c.collectIntoAList();
        c.collectIntoASet();
        c.collectIntoToAMap();
    }
}
