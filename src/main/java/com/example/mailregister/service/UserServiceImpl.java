package com.example.mailregister.service;


import com.example.mailregister.dao.UserDao;
import com.example.mailregister.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MailService mailService;

    @Override
    public void add(User user) {
        userDao.insert(user);
        //获取激活码
        String code = user.getActiveCode();
        System.out.println("激活码:"+code);
        //主题
        String subject = "来自华夏神帝的激活邮件";
        //上面的激活码发送到用户注册邮箱
        String context = "您的激活码为："+code;
        //String context = "<a href=\"http:47.96.126.180/user/checkCode?code="+code+"\">激活请点击:"+code+"</a>";
        //发送激活邮件
        mailService.sendMimeMail (user.getEmail(),subject,context);
    }

    @Override
    public User getUserByActiveCode(String activeCode) {
        return userDao.selectUserByActiveCode(activeCode);
    }

    @Override
    public void modify(User user) {
        userDao.update(user);
    }

    @Override
    public User get(User user) {
        return userDao.select(user);
    }

    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    private SqlSession sqlSession;

    @Override
    public User getUserInfo() {
        // 假设这里从数据库或其他源获取用户信息
        // 为了简化，我们在这里硬编码一个用户信息
        User user = new User();
        user.setId(10);
        user.setUsername("张三");
        user.setEmail("zhangsan@example.com");
        user.setActiveStatus(1);
        return user;
    }

    @Override
    public User getUserInfo2() {
        return sqlSession.selectOne("getUserINfo2");
    }

}
