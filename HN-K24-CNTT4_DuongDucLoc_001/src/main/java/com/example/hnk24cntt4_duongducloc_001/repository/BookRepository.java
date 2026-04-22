package com.example.hnk24cntt4_duongducloc_001.repository;

import com.example.hnk24cntt4_duongducloc_001.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {
    List<Book> list = new ArrayList<>(
            Arrays.asList(
                    new Book(
                            1L,
                            "Đắc Nhân tâm",
                            "Dũng",
                            10,
                            ""
                    )
            )
    );

    public List<Book> getList() {
        return list;
    }
}
