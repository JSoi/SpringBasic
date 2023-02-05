package com.practice.demo.stream;

import com.practice.demo.mvc.dto.Position;
import lombok.Getter;
import lombok.ToString;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MapExample {
    @Test
    public void map(){
        List<Position> positionList = createPositionList();
        positionList.stream()
                .map(Position::getSymbol)
                .forEach(System.out::println);
//        positionList = new ArrayList<>();
        PositionSide any = positionList.stream()
                .map(p -> PositionSide.valueOf(p.getPositionSide()))
                        .takeWhile(p -> p == PositionSide.BOTH).findFirst().orElse(null);
        System.out.println("any = " + any);
    }
    public List<Position> createPositionList(){
        return new ArrayList<>(List.of(
                new Position("BTCUSDT", "BOTH", "0.0002"),
                new Position("UTF8080", "BOTH", "0.0002")
        ));
    }
    @Getter
    @ToString
    public static class Position {
        public Position(String symbol, String positionSide, String positionAmt) {
            this.symbol = symbol;
            this.positionSide = positionSide;
            this.positionAmt = positionAmt;
        }
    
        private String symbol;
        private String positionSide;
        private String positionAmt;
    }
    
    public enum PositionSide {
            BOTH, LONG, SHORT
    }
}
