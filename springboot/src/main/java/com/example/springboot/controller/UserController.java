package com.example.springboot.controller;

import com.example.springboot.entity.R;
import com.example.springboot.entity.User;
import com.example.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @GetMapping("/list")
    public R list() {
        List<User> data = iUserService.list(null);
        return R.success(data);
    }

    @GetMapping("/page")
    public R page(@RequestParam(value = "nickname", required = false) String nickname,
                  @RequestParam(value = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                  @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize) {
        List<User> data = iUserService.page(nickname, pageNum, pageSize);
        return R.success(data);
    }

    /**
     * 测试mysql锁
     * <p>
     * #查询进程
     * show processlist;
     * # 查看锁
     * SELECT * FROM INFORMATION_SCHEMA.INNODB_TRX;
     *
     * @return
     */
    @GetMapping("/mysqlLock")
    public R page(@RequestParam(value = "tid", required = true) String tid) {
        iUserService.mysqlLock(tid);
        return R.success();
    }
}
