package com.szhua.boot.controller;
/*
*@author szhua 2018/1/2/002
*ReadingListController
github@szhua
*/


import com.szhua.boot.bean.Book;
import com.szhua.boot.domain.AmazonProperties;
import com.szhua.boot.domain.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readinglist")
////引入properties中的属性 直接注解注入；
//@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {
    private ReadingListRepository readingListRepository ;
    private AmazonProperties amazonProperties ;
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,AmazonProperties amazonProperties){
        this.readingListRepository =readingListRepository ;
        this.amazonProperties =amazonProperties ;
    }


    @RequestMapping("/requestlistrest/{reader}")
    public String readinglistRest(@PathVariable("reader") String reader , ModelMap model){
        model.addAttribute("reader",reader);
        model.addAttribute("url",amazonProperties.getAssociateId()) ;
        return  "readinglistRest" ;
    }



    /***
     *
     * @param reader
     * @param model 用于thymeleaf中的model输出；
     * @return
     */
    @RequestMapping(value = "/{reader}",method = RequestMethod.GET)
    public String readersBooks(@PathVariable("reader") String reader , ModelMap model){
        List<Book> readers = readingListRepository.findByReader(reader);
        if(readers!=null){
            model.addAttribute("books",readers) ;
            model.addAttribute("reader",reader);
            model.addAttribute("url",amazonProperties.getAssociateId());
        }
        //定位到readinglist.html界面；
        return  "readinglist";
    }

    /***
     *
     * @param reader
     * @param book
     * @return
     */
    @RequestMapping(value = "/{reader}",method = RequestMethod.POST,produces="text/html;charset=UTF-8")
    public String addToReadingList(@PathVariable("reader") String reader ,Book book){
        book.setReader(reader);
        System.err.println(book);
        readingListRepository.save(book);
        //重新定位
        return "redirect:/readinglist/{reader}" ;
    }

}
