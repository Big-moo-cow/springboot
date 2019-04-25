package cn.cza.springboot.modules.register.Service.Impl;import cn.cza.springboot.commons.utils.R;import cn.cza.springboot.commons.utils.StringUtils;import cn.cza.springboot.modules.register.Dao.UserMapper;import cn.cza.springboot.modules.register.Pojo.User;import cn.cza.springboot.modules.register.Service.RegisterService;import cn.cza.springboot.modules.register.utils.QueryUserRequest;import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;import com.baomidou.mybatisplus.core.metadata.IPage;import com.baomidou.mybatisplus.extension.plugins.pagination.Page;import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;import org.slf4j.Logger;import org.slf4j.LoggerFactory;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;/** * @Author: 车子昂 * @Date: 2019-4-16 9:43 * @Description: */@Servicepublic class RegisterServiceImpl extends ServiceImpl<UserMapper, User> implements RegisterService {    private Logger logger = LoggerFactory.getLogger(Class.class);    @Autowired    private UserMapper userMapper;    @Override    public R addUser(User user) {        return new R();    }    public R getUsers(int page, int size, QueryUserRequest params) {        R r = new R();        QueryWrapper ew = new QueryWrapper();        if (!StringUtils.isNull(params.getId())) {            ew.eq("id", params.getId());        }        if (!StringUtils.isNull(params.getName())) {            ew.eq("name", params.getName());        }        if (!StringUtils.isNull(params.getPhone())) {            ew.eq("phone", params.getPhone());        }        ew.eq("isdel", "0");        System.out.println(ew.getSqlSelect());        Page<User> userPage = new Page<>(page, size);        IPage<User> i = this.page(userPage, ew);        r.put("list", i.getRecords());        r.put("total", i.getTotal());        return r;    }}