/*
 * Copyright 2015 sathyasy.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.flifi.tot.commons.collection;

import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @author sathyasy
 */
public class LRUHashMapTest {

    public LRUHashMapTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testNaturalEviction() {
        System.out.println("testNaturalEviction");
        LRUHashMap<Integer, Integer> map = new LRUHashMap<Integer, Integer>(2);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertEquals(null, map.get(1));
    }

    @Test
    public void testMaxSizeNonEviction() {
        System.out.println("testMaxSizeNonEviction");
        LRUHashMap<Integer, Integer> map = new LRUHashMap<Integer, Integer>(3);
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);
        assertEquals(1, map.get(1));
    }

    @Test
    public void testGetPreventingEviction() {
        System.out.println("testGetPreventingEviction");
        LRUHashMap<Integer, Integer> map = new LRUHashMap<Integer, Integer>(2);
        map.put(1, 1);
        map.put(2, 2);
        //use a Get to re-order the LRU stack
        map.get(1);
        map.put(3, 3);
        assertEquals(1, map.get(1));
    }

    @Test
    public void testUnusedEviction() {
        System.out.println("testUnusedEviction");
        LRUHashMap<Integer, Integer> map = new LRUHashMap<Integer, Integer>(2);
        map.put(1, 1);
        map.put(2, 2);
        //use a Get to re-order the LRU stack
        map.get(1);
        map.put(3, 3);
        assertEquals(null, map.get(2));
    }

}
