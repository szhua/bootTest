package com.szhua.boot.domain;
/*
*@author szhua 2018/1/2/002
*ReadingListRepository
github@szhua
*/


import com.szhua.boot.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReadingListRepository extends JpaRepository<Book,Long> {
    List<Book> findByReader(String reader);
}
