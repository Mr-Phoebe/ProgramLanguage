package com.mingrisoft.generic;

import java.util.List;

public class GenericQueryTest {
    public static void main(String[] args) {
        String sql = "select * from tb_book";
        List<Books> list = GenericQuery.query(sql, Books.class);
        System.out.println("明日科技新书：");
        for (Books books : list) {
            System.out.println(books);
        }
    }
}
