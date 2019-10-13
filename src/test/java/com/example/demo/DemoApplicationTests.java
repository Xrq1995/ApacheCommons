package com.example.demo;

import com.example.demo.bean.Person;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.beanutils.BeanUtils;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  private Log log = LogFactory.getLog(DemoApplicationTests.class);

  @Test
  public void contextLoads() {
  }

  /**
   * Apache Commons 测试类
   */
  @Test
  public void cloneBean() {
    Person person = new Person();
    person.setName("tom");
    person.setAge(20);

    try {
      //克隆
      Person person1 = (Person) BeanUtils.cloneBean(person);
      log.info(person1.toString());

      //map 转为java对象
      Map map = new HashMap<>();
      map.put("name","map");
      map.put("age",21);
      Person person2 = new Person();
      BeanUtils.populate(person2,map);
      log.info(person2.toString());
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
  }
}
