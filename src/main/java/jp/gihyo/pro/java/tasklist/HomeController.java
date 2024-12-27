package jp.gihyo.pro.java.tasklist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    record TaskItem(String id,String task,String deadline,boolean done) {}
    private List<TaskItem>taskItems =new ArrayList<>();

    @RequestMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("time", LocalDateTime.now());  // 時刻をモデルに追加
        return "hello";  // Thymeleafテンプレート「hello.html」を返す


        }
    @GetMapping("/list")
    String listItems(Model model){
        model.addAttribute("taskList",taskItems);
        return "home";
    }

}