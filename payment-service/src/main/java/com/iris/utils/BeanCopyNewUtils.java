package com.iris.utils;

import com.iris.common.exception.BizException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.util.Assert;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


/**
 * bean属性复制功能，如果有异常会返回具体是哪个属性的setter方法出现异常
 *
 * @author qianjing
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class BeanCopyNewUtils extends BeanUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanCopyNewUtils.class);

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param target
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copyProps(Object source, Object target) throws BizException {
        copyProps(source, target,true, null);
    }

    /**
     * 
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source
     * @param target
     * @param igonre
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copyProps(Object source, Object target, String[] igonre) throws BizException {
       copyProps(source, target, true, igonre);
    }

    /**
     *
     * 功能描述: <br>
     * 〈功能详细描述〉
     *
     * @param source 源数据bean
     * @param target 数据设置目标bean
     * @param skipNull 如果是Null值，是否设置
     * @param igonre 不需要复制的字段名称列表
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static void copyProps(Object source, Object target, boolean skipNull, String[] igonre) throws BizException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class<?> actualEditable = target.getClass();
        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        Object methodName = null;
        // Object targetValue=null;
        // 需复制字段
        for (PropertyDescriptor targetPd : targetPds) {
            if (targetPd.getWriteMethod() != null) {

                try {
                    PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                    if (igonre != null) {
                        boolean jump = false;
                        // 忽略字段
                        for (int i = 0; i < igonre.length; i++) {
                            if (StringUtils.isBlank(igonre[i])) {// 判空
                                continue;
                            }
                            if (targetPd.getName().equals(igonre[i])) {// 是否为忽略字段
                                LOGGER.info("Ignore copy field: {}", targetPd.getName());
                                jump = true;
                                break;
                            }
                        }
                        if (jump) {// 忽略标志
                            continue;
                        }
                    }
                    if (sourcePd != null && sourcePd.getReadMethod() != null) {// 判空
                        Method readMethod = sourcePd.getReadMethod();
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object sourceValue = readMethod.invoke(source);

                        // 如果不复制null值，并且当前值为null继续下一个字段
                        if(skipNull && null == sourceValue) {
                            continue;
                        }

                        Method writeMethod = targetPd.getWriteMethod();
                        methodName = writeMethod.getName();
                        if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        writeMethod.invoke(target, sourceValue);
                    }
                } catch (BeansException | SecurityException | IllegalArgumentException
                        | IllegalAccessException | InvocationTargetException e) {
                    String errMsg = "BEAN COPY Exception! methodName=" + methodName + " ;" + e.getMessage();
                    LOGGER.error(errMsg, e);
                    throw new BizException("beanCopyException"+errMsg);
                }
            }
        }
    }

}
