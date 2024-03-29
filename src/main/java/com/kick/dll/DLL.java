package com.kick.dll;

public class DLL {
    private int size = 0;
    private Node start = null;
    private Node end = null;

    public void insert(int element) {
        Node node = new Node();
        node.value = element;
        size++;

        if (start == null) {
            start = node;
            end = node;
        } else {
            end.next = node;
            node.prev = end;
            end = node;
        }
    }

    public void delete(int element) {
        Node tmp = start;
        Node prev = null;
        while (tmp != null && tmp.value != element) {
            prev = tmp;
            tmp = tmp.next;
        }

        if (tmp != null) {
            if (prev != null) {
                prev.next = tmp.next;
            }
            if (tmp.next != null) {
                tmp.next.prev = prev;
            }
            size--;
            if (size == 0) {
                start = null;
                end = null;
            }
            if (tmp == start) {
                start = start.next;
                if (start != null) {
                    start.prev = null;
                }
            }
            if (tmp == end) {
                end = end.prev;
                if (end != null) {
                    end.next = null;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node tmp = start;
        while (tmp != null) {
            sb.append("(");
            sb.append(tmp.prev != null ? tmp.prev.value : "-");
            sb.append(",");
            sb.append(tmp.value);
            sb.append(",");
            sb.append(tmp.next != null ? tmp.next.value : "-");
            sb.append(")");
            tmp = tmp.next;
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node {
        int value;
        Node prev = null;
        Node next = null;
    }
}
