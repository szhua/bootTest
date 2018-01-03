package com.szhua.boot.controller;
/*
*@author szhua 2018/1/3/003
*api
github@szhua
*/


import com.szhua.boot.bean.Book;
import com.szhua.boot.bean.Reader;
import com.szhua.boot.domain.ReaderRepository;
import com.szhua.boot.domain.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * REST API !!!
 */

@RestController
@RequestMapping("/api/")
public class Api {

    @Autowired
    ReadingListRepository readingListRepository ;
    @Autowired
    ReaderRepository readerRepository ;

    @RequestMapping(value = "readers",method = RequestMethod.GET)
    public List<Reader> getReaders(){
        return readerRepository.findAll();
    }

    @RequestMapping(value = "readinglist",method = RequestMethod.GET)
    //required 设置它可否为空！
    public List<Book> getBooks(@RequestParam(value = "reader",required = false) String book ){
        if(book!=null){
           return readingListRepository.findByReader(book);
        }else{
            return  readingListRepository.findAll() ;
        }
    }

    @RequestMapping(value = "readinglist",method = RequestMethod.POST)
    public  Book  insertBook(Book book ){
          System.err.println(book.toString());
           Book bookResult =  readingListRepository.save(book);
        return bookResult;
    }


}
