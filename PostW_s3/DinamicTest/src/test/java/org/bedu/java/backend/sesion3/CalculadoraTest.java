package org.bedu.java.backend.sesion3;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculadoraTest {
    Calculadora calculadora = new Calculadora();
    @TestFactory
    Stream<DynamicTest> dynamicTests() {
        return IntStream.iterate(0, n -> n + 1).limit(1000)
                .mapToObj(n->DynamicTest.dynamicTest("Test Multiplica"+n,
                        ()->assertEquals(n*(n+1),calculadora.multiplica(n,n+1))));
    }
}