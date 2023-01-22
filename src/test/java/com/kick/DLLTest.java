package com.kick;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DLLTest {
    private DLL subject;

    @BeforeEach
    void setUp() {
        subject = new DLL();
    }

    @Test
    void insert_zero_element() {

        // when

        // then
        assertEquals("[]", subject.toString());
        assertEquals(0, subject.getSize());
    }

    @Test
    void insert_one_element() {

        // when
        subject.insert(10);

        // then
        assertEquals("[(10)]", subject.toString());
        assertEquals(1, subject.getSize());
    }
}