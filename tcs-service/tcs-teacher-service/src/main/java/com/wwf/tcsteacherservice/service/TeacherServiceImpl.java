package com.wwf.tcsteacherservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wwf.commons.IBaseDao;
import com.wwf.commons.constant.UserConstant;
import com.wwf.commons.impl.BaseServiceImpl;
import com.wwf.commons.pojo.ResultBean;
import com.wwf.entity.Case;
import com.wwf.entity.Category;
import com.wwf.entity.Teacher;
import com.wwf.entity.Topic;
import com.wwf.mapper.CaseMapper;
import com.wwf.mapper.CategoryMapper;
import com.wwf.mapper.TeacherMapper;
import com.wwf.mapper.TopicMapper;
import com.wwf.tcsteacherapi.ITeacherService;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author WangWeifeng
 * @date 2020-3-9 下午 5:40
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements ITeacherService{

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private CaseMapper caseMapper;
    @Autowired
    private TopicMapper topicMapper;

    @Override
    public IBaseDao<Teacher> getDao() {
        return teacherMapper;
    }

    @Resource(name = "stringSerializerRedisTemplate")
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public ResultBean checkUserNameIsExist(String username) {
        try {
            int i = teacherMapper.checkUserNameIsExist(username);
            if (i == 0){
                return new ResultBean("200",username);
            }
            return new ResultBean("500","");
        }catch (Exception e){
            System.out.println("验证用户名异常"+username);
            return new ResultBean("500","");
        }

    }

    @Override
    public ResultBean checkPhoneIsExist(String phone) {
        try {
            int i = teacherMapper.checkPhoneIsExist(phone);
            if (i == 0){
                return new ResultBean("200",phone);
            }
            return new ResultBean("500","");
        }catch (Exception e){
            System.out.println("验证手机号异常"+phone);
            return new ResultBean("500","");
        }

    }

    @Override
    public ResultBean checkEmailIsExist(String email) {
        try {
            int i = teacherMapper.checkEmailIsExist(email);
            if (i == 0){
                return new ResultBean("200",false);
            }
            return new ResultBean("500",true);
        }catch (Exception e){
            System.out.println("验证邮箱异常"+email);
            return new ResultBean("500","");
        }

    }

    @Override
    @Transactional
    public Map<String,String> register(JSONObject jsonObject) {
        Teacher teacher = new Teacher();
        String username = jsonObject.getString("username");
        teacher.setUsername(username);
        teacher.setPassword(jsonObject.getString("password"));
        teacher.setAge(Integer.parseInt(jsonObject.getString("age")));
        teacher.setEmail(jsonObject.getString("email"));
        teacher.setImageUrl(jsonObject.getString("imageUrl"));
        teacher.setNickName(jsonObject.getString("nickName"));
        teacher.setUserNo(System.currentTimeMillis()+username);
        teacher.setPhone(jsonObject.getString("phone"));
        teacher.setSex(jsonObject.getString("sex"));
        Map<String,String> map = new HashMap<>();
        try {
            getDao().insertSelective(teacher);
            String like = jsonObject.getString("like");
            teacherMapper.addTeacherLikes(teacher.getId(),like);
            System.out.println("教师服务！！"+teacher.getId());
            map.put("status","200");
            map.put("phone",teacher.getPhone());
            return map;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            map.put("status","500");
            map.put("phone","");
            return map;
        }
    }

    @Override
    public ResultBean generateCode(String identification) {
        return null;
    }

    @Override
    public Object updatePassword(Teacher teacher) {
        Map<String,String> map = new HashMap<>();
        try {
            teacherMapper.updatePassword(teacher);
        }catch (Exception e){
            System.out.println("更新密码错误"+teacher.getPhone());
            map.put("status","500");
            map.put("data",teacher.getPhone());
            return map;
        }
        map.put("status","200");
        map.put("data",teacher.getPhone());
        return map;
    }

    @Override
    public Teacher getByToken(String uuid) {
        Teacher teacher=null;
        try {
            teacher = (Teacher) redisTemplate.opsForValue().get(UserConstant.USER_LOGIN_KEY + uuid);
            redisTemplate.expire(UserConstant.USER_LOGIN_KEY+uuid,15, TimeUnit.MINUTES);
            System.out.println("从redis中获取的教师对象为:"+teacher);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("从redis中取教师对象失败。。。"+uuid);
            return null;
        }
        return teacher;
    }

    @Override
    public List<Category> getTeacherLikes(int id) {
        String likesId = teacherMapper.getTeacherLikes(id);
        if (likesId!=null){
            String[] strings = likesId.split(",");
            int length = strings.length;
            int[] ids=new int[length];
            for (int i = 0;i<length;i++){
                ids[i] = Integer.parseInt(strings[i]);
            }
            System.out.println(likesId);
            List<Category> list = categoryMapper.getCategoriesByIds(ids);
            return list;
        }
        return null;
    }

    @Override
    public ResultBean updateToken(int teacherId, String userToken) {
        Map<String,Object> map = new HashMap<>();
        map.put("teacherId",teacherId);
        map.put("userToken",userToken);
        try {
            Teacher teacher = teacherMapper.selectByPrimaryKey(teacherId);
            redisTemplate.opsForValue().set(UserConstant.USER_LOGIN_KEY+userToken,teacher,15,TimeUnit.MINUTES);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("更新redis失败。。"+teacherId);
            return new ResultBean("500",map);
        }
        return new ResultBean("200",map);
    }

    @Override
    @Transactional
    public Object modifyTeacher(String teacher) {
        JSONObject jsonObject = JSON.parseObject(teacher);
        Teacher currentTeacher = new Teacher();
        currentTeacher.setPassword(jsonObject.getString("password"));
        currentTeacher.setAge(Integer.parseInt(jsonObject.getString("age")));
        currentTeacher.setEmail(jsonObject.getString("email"));
        currentTeacher.setImageUrl(jsonObject.getString("imageUrl"));
        currentTeacher.setNickName(jsonObject.getString("nickName"));
        currentTeacher.setPhone(jsonObject.getString("phone"));
        currentTeacher.setSex(jsonObject.getString("sex"));
        int currentId = Integer.parseInt(jsonObject.getString("id"));
        String teacherLikes = jsonObject.getString("like");
        currentTeacher.setId(currentId);
        String currentToken = jsonObject.getString("token");
        Map<String,String> map = new HashMap<>();
        /**
         * 更新该教师对应的案例信息 writerName writerImageUrl
         * 更新该教师发布的话题信息
         */
        try {
            Case teachingCase = new Case();
            String currentTeacherNickName = currentTeacher.getNickName();
            String currentTeacherImageUrl = currentTeacher.getImageUrl();
            teachingCase.setCaseWriterName(currentTeacherNickName);
            teachingCase.setCaseWriterId(currentId);
            teachingCase.setWriterImageUrl(currentTeacherImageUrl);
            Topic topic = new Topic();
            topic.setTopicWriterId(currentId);
            topic.setTopicWriterName(currentTeacherNickName);
            topic.setWriterImageUrl(currentTeacherImageUrl);
            caseMapper.updateByTeacherId(teachingCase);
            topicMapper.updateByTeacherId(topic);
            teacherMapper.updateByPrimaryKeySelective(currentTeacher);
            teacherMapper.updateTeacherLikes(currentId,teacherLikes);
            return updateToken(currentId, currentToken);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            System.out.println("更新信息异常。。。"+currentTeacher);
            return new ResultBean<>("500","error");
        }
    }

    @Override
    @Transactional
    public Object toSubscribe(String targetId,String userToken) {
        String key = UserConstant.USER_LOGIN_KEY+userToken;
        Teacher currentTeacher = (Teacher) redisTemplate.opsForValue().get(key);
        Teacher targetTeacher = teacherMapper.selectByPrimaryKey(Integer.parseInt(targetId));
        Map<String,Object> map = new HashMap<>();
        int currentTeacherId = currentTeacher.getId();
        map.put("currentTeacherId",currentTeacherId);
        map.put("targetTeacher",targetTeacher);
        try {
            teacherMapper.addTeacherSubscribe(map);
            Integer targetCount = teacherMapper.getTargetCount(targetId);
            targetTeacher.setFansCount(targetCount);
            teacherMapper.updateByPrimaryKeySelective(targetTeacher);
            Integer subscribeCount = teacherMapper.getCurrentTeacherSubscribeCount(currentTeacherId);
            currentTeacher.setSubscribeCount(subscribeCount);
            teacherMapper.updateByPrimaryKeySelective(currentTeacher);
            teacherMapper.selectByPrimaryKey(currentTeacherId);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultBean<>("500","error");
        }
        redisTemplate.opsForValue().set(key,currentTeacher,15,TimeUnit.MINUTES);
        return new ResultBean<>("200","success");
    }

    @Override
    @Transactional
    public Object toCollect(Integer targetId,String identity,String userToken) {
        String key = UserConstant.USER_LOGIN_KEY+userToken;
        Teacher currentTeacher = (Teacher) redisTemplate.opsForValue().get(key);
        int currentTeacherId = currentTeacher.getId();
        Map<String,Object> map = new HashMap<>();
        map.put("targetId",targetId);
        map.put("identity",identity);
        map.put("userId",currentTeacherId);
        try {
            teacherMapper.addTeacherCollections(map);
            Integer collectCount = teacherMapper.getCollectCountByTeacherId(currentTeacherId);
            currentTeacher.setCollectCount(collectCount);
            teacherMapper.updateByPrimaryKeySelective(currentTeacher);
            Integer targetCollectCount = teacherMapper.getTargetCollectCount(targetId,identity);
            if ("1".equals(identity)){
                Case currentCase = new Case();
                currentCase.setId(targetId);
                currentCase.setCaseCollectCount(targetCollectCount);
                caseMapper.updateByPrimaryKeySelective(currentCase);
            }else {
                Topic topic = new Topic();
                topic.setId(targetId);
                topic.setTopicCollectCount(targetCollectCount);
                topicMapper.updateByPrimaryKeySelective(topic);

            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultBean<>("500","error");
        }
        redisTemplate.opsForValue().set(key,currentTeacher,15,TimeUnit.MINUTES);
        return new ResultBean<>("200","success");
    }

    @Override
    public Object checkHasSubscribed(Integer writerId, String userToken) {
        String key = UserConstant.USER_LOGIN_KEY+userToken;
        Teacher currentTeacher = (Teacher) redisTemplate.opsForValue().get(key);
        int currentTeacherId = currentTeacher.getId();
        try {
            Integer result = teacherMapper.checkHasSubscribed(writerId,currentTeacherId);
            if (result ==0){
                return new ResultBean<>("404","N");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResultBean<>("500","error");
        }
        return new ResultBean<>("200","Y");
    }

    @Override
    public Object checkHasCollected(String identity, Integer targetId, String userToken) {
        String key = UserConstant.USER_LOGIN_KEY+userToken;
        Teacher currentTeacher = (Teacher) redisTemplate.opsForValue().get(key);
        int currentTeacherId = currentTeacher.getId();
        try {
            int result = teacherMapper.checkHasCollected(currentTeacherId,targetId,identity);
            if (result==0){
                return new ResultBean<>("404","N");
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResultBean<>("500","error");
        }
        return new ResultBean<>("200","Y");

    }

    @Override
    public Map<String, Object> getTeacherCollections(String userToken) {
        String key = UserConstant.USER_LOGIN_KEY+userToken;
        Teacher currentTeacher = (Teacher) redisTemplate.opsForValue().get(key);
        redisTemplate.expire(key,15,TimeUnit.MINUTES);
        int currentTeacherId = currentTeacher.getId();
        List<Integer> caseIds = teacherMapper.getUserCollectCaseId(currentTeacherId);
        List<Case> teachingCases = caseMapper.getCaseByIds(caseIds);
        List<Integer> topicIds = teacherMapper.getUserCollectTopicId(currentTeacherId);
        List<Topic> topics = topicMapper.getTopicByIds(topicIds);
        return null;
    }
}
