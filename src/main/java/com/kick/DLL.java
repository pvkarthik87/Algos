package com.kick;

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

    public void delete() {
        if (start != null) {
            start = start.next;
            if (start != null) {
                start.prev = null;
            }
            size--;
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
            if (tmp.prev != null) {
                sb.append(tmp.prev.value);
                sb.append(",");
            }
            sb.append(tmp.value);
            if (tmp.next != null) {
                sb.append(",");
                sb.append(tmp.next.value);
            }
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
