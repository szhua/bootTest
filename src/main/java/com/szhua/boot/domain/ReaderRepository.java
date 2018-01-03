package com.szhua.boot.domain;
/*
*@author szhua 2018/1/2/002
*ReaderRepository
github@szhua
*/


import com.szhua.boot.bean.Reader;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ReaderRepository extends JpaRepository<Reader, String> {

    Reader findReaderByUsername(String userName) ;
}
