package com.high.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.high.entity.Options;
import com.high.entity.Subject;
import com.high.entity.Users;
import com.high.entity.Vote;
import com.high.service.OptionsService;
import com.high.service.SubjectService;
import com.high.service.UsersService;
import com.high.service.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//加了注释
@Controller
public class UsersController {
    @Resource
    private UsersService usersService;
    @Resource
    private OptionsService optionsService;
    @Resource
    private SubjectService subjectService;
    @Resource
    private VoteService voteService;

    private String name = "";
    private Integer uid = 0;

    @RequestMapping("login")
    public String login(Users users, Model model, HttpServletRequest request) {
        request.getSession(true);
        Users users1 = usersService.getOne(new QueryWrapper<Users>()
                .eq("uname", users.getUname())
                .eq("password", users.getPassword()));
        if (users1 != null) {
            if (users1.getStatus() != 1) {
                name = users1.getUname();
                uid = users1.getUid();

//                int num = usersService.updateStatus("1", uid.toString());
                users1.setStatus(1);
                boolean num = usersService.updateById(users1);
                System.out.println(num);

                List<Map<String, Object>> map = voteService.votelist(null);
                model.addAttribute("map", map);
                model.addAttribute("name", name);
                request.getSession().setAttribute("userss", users1);
                return "votelist";
            }
            model.addAttribute("msg", "登录失败");
        }
        return "login";
    }

    @RequestMapping("djreg")
    public String djreg() {
        return "regist";
    }

    @RequestMapping("register")
    public String register(Users users) {
        boolean num = usersService.save(users);
        if (num) {
            return "login";
        }
        return "regist";
    }

    //
//    //查用户名重
    @ResponseBody
    @RequestMapping("exists")
    public String exists(String uname) {
        long a = usersService.count(new QueryWrapper<Users>().eq("uname", uname));
        if (a > 0) {
            return "true";
        }
        return "false";
    }


    @RequestMapping("goAdd")
    public String goAdd() {
        return "add";
    }

    //    //投票页面
    @RequestMapping("selectSubject")
    public String selectSubject(Integer entityId, Model model) {
        List<Map<String, Object>> map = voteService.votelist(entityId);
        model.addAttribute("map", map);
        List<Options> list = optionsService.list(new QueryWrapper<Options>().eq("o_sid", entityId));
        model.addAttribute("list", list);
        model.addAttribute("name", name);
        return "vote";
    }

    //
//    //返回列表
    @RequestMapping("back")
    public String back(Model model) {
        List<Map<String, Object>> map = voteService.votelist(null);
        model.addAttribute("map", map);
        model.addAttribute("name", name);
        return "votelist";
    }

    //
    @RequestMapping("insertVote")
    public String insertVote(Integer v_sid, Model model, Integer... options) {
        Vote vote;
        for (int i = 0; i < options.length; i++) {
//            int num = usersService.insertVote(uid, v_sid, options[i]);
            vote = new Vote(0, uid, v_sid, options[i]);
            voteService.save(vote);
        }
        List<Map<String, Object>> map = voteService.votelist(null);
        model.addAttribute("map", map);
        model.addAttribute("name", name);
        return "votelist";
    }

    @RequestMapping("addvote")
    public String addvote(Model model, String title, Integer radio, String... context) {
        boolean num1 = subjectService.save(new Subject(0, title, radio));
        System.out.println(num1);
        if (num1) {
//            this.getOne(new LambdaQueryWrapper<Test>().orderByDesc().last("limit 1"));

            Subject max = subjectService.getOne(new LambdaQueryWrapper<Subject>().orderByDesc(Subject::getSid).last("limit 1"));
            System.out.println(max.getSid());
            for (int i = 0; i < context.length; i++) {
                boolean num2 = optionsService.save(new Options(0, context[i], max.getSid()));
                System.out.println(num2);
            }
        }
        List<Map<String, Object>> map = voteService.votelist(null);
        model.addAttribute("map", map);
        model.addAttribute("name", name);
        return "votelist";
    }


    //    @ResponseBody
    @RequestMapping("deleteSubject")
    public String deleteSubject(Integer entityId, Model model) {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("v_sid", entityId);
        boolean num1 = voteService.removeByMap(map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("o_sid", entityId);
        boolean num2 = optionsService.removeByMap(map2);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("sid", entityId);
        boolean num3 = subjectService.removeByMap(map3);

        System.out.println(num1 + "\t" + num2 + "\t" + num3);
        List<Map<String, Object>> map = voteService.votelist(null);
        model.addAttribute("map", map);
        model.addAttribute("name", name);
        return "votelist";
    }


    @RequestMapping("updateSubject")
    public String updateSubject(Integer entityId, Model model) {
        List<Map<String, Object>> map = voteService.votelist(entityId);
        model.addAttribute("map", map);
        List<Options> list = optionsService.list(new QueryWrapper<Options>().eq("o_sid", entityId));
        model.addAttribute("list", list);
        return "update";
    }

    @RequestMapping("updatevote")
    public String updatevote(Integer o_sid, String[] context, Model model) {

        Map<String, Object> map1 = new HashMap<>();
        map1.put("v_sid", o_sid);
        boolean count = voteService.removeByMap(map1);
        System.out.println(count);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("o_sid", o_sid);
        boolean num = optionsService.removeByMap(map2);
        System.out.println(num);

        for (int i = 0; i < context.length; i++) {
            boolean num1 = optionsService.save(new Options(0, context[i], o_sid));
            System.out.println(num1);
        }
        List<Map<String, Object>> map = voteService.votelist(null);
        model.addAttribute("map", map);
        model.addAttribute("name", name);
        return "votelist";
    }

    @RequestMapping("like")
    public String like(String title, Model model) {
        List<Map<String, Object>> map = voteService.selectlike(title);
        model.addAttribute("map", map);
        model.addAttribute("name", name);
        return "votelist";
    }


    @RequestMapping("zhuxiao")
    public String zhuxiao(HttpSession session) {
        session.invalidate();
        System.out.println("session注销了：" + session.getId());
        return "login";
    }

}
