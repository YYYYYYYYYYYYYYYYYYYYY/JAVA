package ru.nsu.fit.oop.yaroslavodintsov.task_4_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * Class 4 match searching using hashmap
 */
public class OpMap {

    private static final Map<String, Operation> OpMap = new HashMap<>();

    static {
        OpMap.put(Division.symbol, new Division());
        OpMap.put(Multiplication.symbol, new Multiplication());
        OpMap.put(Minus.symbol, new Minus());
        OpMap.put(Plus.symbol, new Plus());
        OpMap.put(Power.symbol, new Power());
        OpMap.put(Cosine.symbol, new Cosine());
        OpMap.put(Logarithm.symbol, new Logarithm());
        OpMap.put(Sine.symbol, new Sine());
        OpMap.put(SquareRoot.symbol, new SquareRoot());
        OpMap.put(UnaryMinus.symbol, new UnaryMinus());
    }

    static final Map<String, Operation> Operations = Collections.unmodifiableMap(OpMap);
}
