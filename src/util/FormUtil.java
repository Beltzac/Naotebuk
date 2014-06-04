package util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

public class FormUtil {	
	FormUtil(){
	
	}

	public static <T> T populate(Class<T> clazz, HttpServletRequest request) {
		T object = null;
		try {			
			
			DateTimeConverter dtConverter = new DateConverter();
			dtConverter.setPattern("dd/MM/yyyy");
			ConvertUtils.register(dtConverter, java.util.Date.class);
			
			object = (T) clazz.newInstance();
			BeanUtils.populate(object, request.getParameterMap());

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return object;
	}
}