package org.myspringframework.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;


import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: shichong1008@outlook.com
 * @Description: TODO
 * @DateTime: 2023/12/20 15:15
 **/
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private static final Log log = LogFactory.getLog(ClassPathXmlApplicationContext.class);
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>(150);


    /**
     * 解析配置文件，初始化所有Bean对象
     *
     * @param configLocation 放入到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) throws DocumentException {
        //解析xml文件  dom4j解析xml的核心对象
        SAXReader reader = new SAXReader();
        InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(in);
        List<Node> nodes = document.selectNodes("//bean");
        nodes.forEach(node -> {
            try {
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                log.info("beanName: " + id);
                log.info("beanClassname: " + className);
                //创建对象
                Class<?> aClass = Class.forName(className);
                Object bean = aClass.newInstance();
                //提前曝光
                //放入容器
                singletonObjects.put(id, bean);
                log.info(singletonObjects.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        //再依次遍历 给属性赋值
        nodes.forEach(node -> {

            try {
                Element element = (Element) node;
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Class<?> aClass = Class.forName(className);


                Object o = aClass.newInstance();
                List<Element> props = element.elements("property");
                props.forEach(prop -> {
                    try {
                        String propertyName = prop.attributeValue("name");
                        Field declaredField = aClass.getDeclaredField(propertyName);
                        String propertyValue = prop.attributeValue("value");
                        String propertyRef = prop.attributeValue("ref");
                        if (propertyValue != null) {

                        }
                        log.info("property 属性名" + propertyName);
                        String setMethod = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                        log.info("set method " + setMethod);
                        //后去方法
                        Method method = aClass.getDeclaredMethod(setMethod, declaredField.getType());
                        //属性赋值
                        if (propertyValue != null) {
                            Object value = getHandlerParametersType(declaredField, propertyValue);
                            method.invoke(singletonObjects.get(id), value);
                        }
                        if (propertyRef != null) {
                            method.invoke(singletonObjects.get(id), singletonObjects.get(propertyRef));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private  Object getHandlerParametersType(Field field, String value) {
        //说明这个值是简单类型
        //调用set方法(set方法没有返回值
        //我们myspring框架声明一下：我们只支持这些类型为简单类型
        // byte short int long float double boolean char
        //Byte Short Integer Long Float Double Boolean Character
        //String
        //获取属性类型名
        Object actualValue = null;
        String propertyTypesimpleName = field.getType().getSimpleName();
        switch (propertyTypesimpleName) {
            case "byte":
                actualValue = Byte.parseByte(value);
                break;
            case "short":
                actualValue = Short.parseShort(value);
                break;
            case "int":
                actualValue = Integer.parseInt(value);
                break;
            case "long":
                actualValue = Long.parseLong(value);
                break;
            case "float":
                actualValue = Float.parseFloat(value);
                break;
            case "double":
                actualValue = Double.parseDouble(value);
                break;
            case "boolean":
                actualValue = Boolean.parseBoolean(value);
                break;
            case "char":
                actualValue =value.charAt(0);
                break;
            case "Byte":
                actualValue =Byte.valueOf(value);
                break;
            case "Short":
                actualValue = Short.valueOf(value);
                break;
            case "Integer":
                actualValue = Integer.valueOf(value);
                break;
            case "Long":
                actualValue = Long.valueOf(value);
                break;
            case "Float":
                actualValue = Float.valueOf(value);
                break;
            case "Double":
                actualValue = Double.valueOf(value);
                break;
            case "Boolean":
                actualValue = Boolean.valueOf(value);
                break;
            case "Char":
                actualValue =Character.valueOf(value.charAt(0));
                break;
            case "String":
                actualValue = value;
                break;
        }

        return actualValue;
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }

}
