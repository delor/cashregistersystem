package me.plich.cashregistersystem.utils;

import me.plich.cashregistersystem.model.*;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.util.HashSet;
import java.util.Set;

public class Utils {

    public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

//    public static boolean checkOwner(Object object, Long userId) {
//        String classType = object.getClass().getSimpleName();
//        switch(classType) {
//            case "Customer":
//                Customer customerObject = (Customer) object;
//                if(customerObject.getUser().getId() != userId) {
//                    return false;
//                } else {
//                    return true;
//                }
//            case "Device":
//                Device deviceObject = (Device) object;
//                if(deviceObject.getUser().getId() != userId) {
//                    return false;
//                } else {
//                    return true;
//                }
//            case "Location":
//                Location locationObject = (Location) object;
//                if(locationObject.getUser().getId() != userId) {
//                    return false;
//                } else {
//                    return true;
//                }
//            case "Order":
//                Order orderObject = (Order) object;
//                if(orderObject.getUser().getId() != userId) {
//                    return false;
//                } else {
//                    return true;
//                }
//            case "Serviceman":
//                Serviceman servicemanObject = (Serviceman) object;
//                if(servicemanObject.getUser().getId() != userId) {
//                    return false;
//                } else {
//                    return true;
//                }
//            default:
//                return false;
//        }
//    }

    public static boolean checkUser(Long userId, IUserChecker object) {
        if(object.getUser().getId() == userId) {
            return true;
        } else {
            return false;
        }
    }

}
