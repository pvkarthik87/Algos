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
        assertEquals("[(-,10,-)]", subject.toString());
        assertEquals(1, subject.getSize());
    }

    @Test
    void insert_two_elements() {

        // when
        subject.insert(10);
        subject.insert(20);

        // then
        assertEquals("[(-,10,20)(10,20,-)]", subject.toString());
        assertEquals(2, subject.getSize());
    }

    @Test
    void insert_three_elements() {

        // when
        subject.insert(10);
        subject.insert(20);
        subject.insert(30);

        // then
        assertEquals("[(-,10,20)(10,20,30)(20,30,-)]", subject.toString());
        assertEquals(3, subject.getSize());
    }

    @Test
    void delete_all_element() {
        // given
        subject.insert(10);

        // when
        subject.delete(10);

        // then
        assertEquals("[]", subject.toString());
        assertEquals(0, subject.getSize());
    }

    @Test
    void delete_start_element() {
        // given
        subject.insert(10);
        subject.insert(20);

        // when
        subject.delete(10);

        // then
        assertEquals("[(-,20,-)]", subject.toString());
        assertEquals(1, subject.getSize());
    }

    @Test
    void delete_end_element() {
        // given
        subject.insert(10);
        subject.insert(20);

        // when
        subject.delete(20);

        // then
        assertEquals("[(-,10,-)]", subject.toString());
        assertEquals(1, subject.getSize());
    }

    @Test
    void delete_middle_element() {
        subject.insert(10);
        subject.insert(20);
        subject.insert(30);

        // when
        subject.delete(20);

        // then
        assertEquals("[(-,10,30)(10,30,-)]", subject.toString());
        assertEquals(2, subject.getSize());
    }
}