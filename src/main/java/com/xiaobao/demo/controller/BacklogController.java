package com.xiaobao.demo.controller;

import com.xiaobao.demo.domain.Backlog;
import com.xiaobao.demo.domain.User;
import com.xiaobao.demo.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.management.modelmbean.ModelMBeanAttributeInfo;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BacklogController {
    @Autowired
    private BacklogService backlogService;

    @RequestMapping("/backlog")
    public String getLogList(Backlog backlog, HttpSession session, ModelMap model){
        List<Backlog> list = backlogService.getLogList(backlog);
        model.addAttribute("list",list);
        return "/show";
    }

    @RequestMapping("/add")
    public String toAdd(){
        return "/add";
    }

    @RequestMapping("/addLog")
    public String addLog(Backlog backlog, HttpSession session){
//        System.out.println(backlog);
        User user = (User) session.getAttribute("user");
//        System.out.println(user);
        Date date = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //指定格式化格式
        String trueDate = sdf.format(date); //格式化当前日期
        Backlog l = new Backlog();
        l.setbTitle(backlog.getbTitle());
        l.setbContent(backlog.getbContent());
        l.setPriority(backlog.getPriority());
        l.setbTime(backlog.getbTime());
        l.setbCreateTime(trueDate);
        l.setbLastUpdateTime(trueDate);
        l.setbDeadline(backlog.getbDeadline());
        l.setFlag(1);
        l.setUserId(user.getUserId());
//        System.out.println(l);
        backlogService.addLog(l);
        return "redirect:/backlog"; //重定向到查询页面
    }

    @RequestMapping("/updateLog")
    public String updateLog(@RequestParam("bId") int id, ModelMap model, HttpSession session){
        Backlog backlog = backlogService.getLogById(id);
//        System.out.println(backlog);
        model.addAttribute("backlog",backlog);
        session.setAttribute("backlog",backlog);
        return "/update";
    }

    @RequestMapping("/updateupdate")
    /*
    * 在这里 起初new了一个新的Backlog对象，去更新，但是当我不想修改其中的某些值时，会出现传入空值的问题。通过session存储backlog最终成功。
    * */
    public String update(Backlog backlog, HttpSession session){
        Backlog bb = (Backlog)session.getAttribute("backlog");
//        System.out.println("bb:"+bb);
//        System.out.println("参数backlog："+backlog);
        Date date = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //指定格式化格式
        String trueDate = sdf.format(date); //格式化当前日期

        bb.setbLastUpdateTime(trueDate);
        if(backlog.getbTitle() != null && backlog.getbTitle() !=  ""){
            bb.setbTitle(backlog.getbTitle());
        }

        if(backlog.getbTime() != null && backlog.getbTime() !=  ""){
            bb.setbTime(backlog.getbTime());
        }

        if(backlog.getbContent() != null && backlog.getbContent() !=  ""){
            bb.setbContent(backlog.getbContent());
        }

        if(backlog.getPriority() != null){
            bb.setPriority(backlog.getPriority());
        }

        if(backlog.getbDeadline() != null && backlog.getbDeadline() !=  ""){
            bb.setbDeadline(backlog.getbDeadline());
        }

//        Backlog l = new Backlog();

//        l.setbTitle(backlog.getbTitle());
//        l.setbTime(backlog.getbTime());
//        l.setbContent(backlog.getbContent());
//        l.setPriority(backlog.getPriority());

//        l.setbId(bb.getbId());
//        l.setUserId(bb.getUserId());
//        l.setbLastUpdateTime(trueDate);
//        l.setFlag(bb.getFlag());
//        l.setbCreateTime(bb.getbCreateTime());
        //如果在修改表单中 对当前数据不打算做出修改 那么还是原来的值 不会是null
//        if(backlog.getbTitle() != null && backlog.getbTitle() !=  ""){
//            l.setbTitle(backlog.getbTitle());
//        }else l.setbTitle(bb.getbTitle());
//
//        if(backlog.getbTime() != null && backlog.getbTime() !=  ""){
//            l.setbTime(backlog.getbTime());
//        }else l.setbTime(bb.getbTime());
//
//        if(backlog.getbContent() != null && backlog.getbContent() !=  ""){
//            l.setbContent(backlog.getbContent());
//        }else l.setbContent(bb.getbContent());
//
//        if(backlog.getPriority() != null){
//            l.setPriority(backlog.getPriority());
//        }else l.setPriority(bb.getPriority());
//
//        if(backlog.getbDeadline() != null && backlog.getbDeadline() !=  ""){
//            l.setbDeadline(backlog.getbDeadline());
//        }else l.setbDeadline(bb.getbDeadline());
        System.out.println(bb);
        backlogService.update(bb);
        return "redirect:/backlog";
    }

    @RequestMapping("/deleteLog")
    public String deleteLog(@RequestParam("bId") int id,ModelMap model){
        Backlog backlog = backlogService.getLogById(id);
        Date date = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //指定格式化格式
        String trueDate = sdf.format(date); //格式化当前日期
        backlog.setbCreateTime(trueDate);
        backlog.setbLastUpdateTime(trueDate);
        backlogService.update(backlog);
        backlog.setFlag(0);
        backlogService.doLog(backlog);
        return "redirect:/backlog";
    }

    @RequestMapping("/recycle")
    public String getDelLogList(Backlog backlog, HttpSession session, ModelMap model){
        List<Backlog> lists = backlogService.getDelLogList(backlog);
        model.addAttribute("lists",lists);
        return "/recycle";
    }

    //恢复被删除事项
    @RequestMapping("/reLog")
    public String reLog(Backlog backlog,HttpSession session){
        backlog.setFlag(1);
        backlog.setbDeadline(backlog.getbDeadline());
        backlog.setbTime(backlog.getbTime());
        backlog.setPriority(backlog.getPriority());
        Date date = new Date(); //获取当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //指定格式化格式
        String trueDate = sdf.format(date); //格式化当前日期
        backlog.setbCreateTime(trueDate);
        backlog.setbLastUpdateTime(trueDate);
        backlogService.update(backlog);

//        System.out.println(backlog);
        backlogService.doLog(backlog);
        return "redirect:/backlog";
    }

    //彻底删除事项
    @RequestMapping("/deleteData")
    public String deleteData(@RequestParam("bId") int id){
        Backlog backlog = backlogService.getLogById(id);
        backlogService.deleteData(backlog);
        return "redirect:/recycle";
    }
}
