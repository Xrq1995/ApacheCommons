package com.example.demo.betwixt;

import com.example.demo.bean.Person;
import java.beans.IntrospectionException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

/**
 * javabean xml相互转换
 */
public class WriteApp {
private static final Log LOG = LogFactory.getLog(WriteApp.class);
  public static void main(String[] args) throws IntrospectionException, SAXException, IOException {

    /**
     * 将Javabean转为xml
     */
    StringWriter outputWriter = new StringWriter();
    outputWriter.write("<?xml version='1.0' encoding='UTF-8'?\n");
    BeanWriter beanWriter = new BeanWriter(outputWriter);
    beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
    beanWriter.enablePrettyPrint();
    beanWriter.write("person",new Person());
    System.out.println(outputWriter.toString());
    outputWriter.close();

    /**
     * xml 转为 Javabean
     */
    StringReader xmlReader = new StringReader("<?xml version='1.0' encoding='UTF-8' ?> <person><age>25</age><name>James Smith</name></person>");
    BeanReader beanReader = new BeanReader();
    beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
    beanReader.getBindingConfiguration().setMapIDs(false);
    beanReader.registerBeanClass("person",Person.class);
    Person person = (Person) beanReader.parse(xmlReader);
    LOG.info(person.getAge());
    System.out.println(person);
  }
}
