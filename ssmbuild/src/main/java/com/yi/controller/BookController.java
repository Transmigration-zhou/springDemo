package com.yi.controller;

import com.yi.pojo.Books;
import com.yi.service.impl.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部的书籍
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage() {
        return "addBook";
    }

    //增加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        System.out.println("addBook=" + books);
        bookService.addBook(books);
        return "redirect:/book/allBook"; //重定向到@RequestMapping("/allBook")请求
    }

    ///跳转到修改页面
    @RequestMapping("/toUpdateBook")
    public String toUpdatePage(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook", books);
        return "updateBook";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook=" + books);
        int i = bookService.updateBook(books);
        if (i > 0) {
            System.out.println("添加books成功" + books);
        }
        return "redirect:/book/allBook"; //重定向到@RequestMapping("/allBook")请求
    }

    //删除书籍的请求
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook"; //重定向到@RequestMapping("/allBook")请求
    }

    //查询书籍的请求
    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName, Model model) {
        Books books = bookService.queryBookName(queryBookName);
        System.err.println("queryBookBook=" + books);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        model.addAttribute("list", list);
        return "allBook"; //重定向到@RequestMapping("/allBook")请求
    }

}
