package com.kick.hierarchy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Hierarchy {
    String name;
    List<Hierarchy> children;

    Hierarchy(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        if (children.size() > 0) {
            sb.append(",");
            sb.append("[");
            children.forEach(child -> {
                sb.append("--");
                sb.append(child.toString());
                sb.append(",");
            });
            sb.append("]");
        }
        return sb.toString();
    }
}

class Product {
    String id;
    String name;
    String category;
    String subCategory;

    Product(String id, String name, String category, String subCategory) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getField(String columnName) {
        if (columnName.equals("category"))
            return category;
        if (columnName.equals("subCategory"))
            return subCategory;
        if (columnName.equals("name"))
            return name;
        return "";
    }

    public boolean match(String columnName, String value) {
        if (columnName.equals("category"))
            return category.equals(value);
        if (columnName.equals("subCategory"))
            return subCategory.equals(value);
        if (columnName.equals("name"))
            return name.equals(value);
        return false;
    }
}

public class Solution {

    static Hierarchy create(List<Product> products, List<String> columns) {
        Hierarchy result = new Hierarchy("All");
        result.children.addAll(find(products, columns));
        return result;
    }

    private static List<Hierarchy> find(List<Product> products, List<String> columns) {
        if (columns.size() == 0) {
            return Collections.emptyList();
        }
        String column = columns.get(0);
        List<Hierarchy> result = products.stream().map(product -> product.getField(column)).distinct().map(Hierarchy::new).toList();
        result.forEach(hierarchy -> {
            List<Product> matchingProducts = products.stream().filter(product -> product.match(column, hierarchy.name)).toList();
            hierarchy.children.addAll(find(matchingProducts, columns.subList(1, columns.size())));
        });
        return result;
    }

    public static void main(String[] args) {
        Product[] products = new Product[] {
            new Product("1", "p1", "c1", "s1"),
            new Product("2", "p2", "c1", "s2"),
            new Product("3", "p3", "c1", "s3"),
            new Product("4", "p4", "c2", "s1"),
            new Product("5", "p5", "c2", "s1"),
            new Product("6", "p6", "c2", "s2"),
            new Product("7", "p7", "c3", "s1"),
        };
        String[] levels = new String[] {
                "category", "subCategory", "name"
        };

        Hierarchy result = create(Arrays.stream(products).toList(), Arrays.stream(levels).toList());
        System.out.println(result);
    }
}